package org.banco_de_entidades.dao;

import org.banco_de_entidades.infra.ConexaoSingleton;
import org.banco_de_entidades.dao.ITurmaDAO;
import org.banco_de_entidades.model.Estudante;
import org.banco_de_entidades.model.Pessoa;
import org.banco_de_entidades.model.Professor;
import org.banco_de_entidades.model.Turma;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TurmaDAO implements ITurmaDAO {

    private final Connection conexao;
    public TurmaDAO() {
        conexao = ConexaoSingleton.getConexao();
    }


    public void inserir(Turma turma) {
        String sql = "INSERT INTO turma (nome, id_professor) VALUES (?,?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getProfessor().getId());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    turma.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Turma buscarPorId(int id) {
        String sql = "SELECT * FROM turma WHERE id = ?";
        Turma turma = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int professorId = rs.getInt("id_professor");
                Professor professor = new ProfessorDAO(null).buscarPorId(professorId);
                turma = new Turma(id, rs.getString("nome"), professor);
                turma.setEstudantes(buscarEstudantesDaTurma(id));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turma;
    }

    public List<Turma> listarTodos() {
        List<Turma> turmas = new ArrayList<>();
        String sql = "SELECT * FROM turma";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Turma turma = buscarPorId(rs.getInt("id"));
                turmas.add(turma);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return turmas;
    }
    public void atualizar(Turma turma) {
        String sql = "UPDATE turma SET nome = ?, id_professor = ? WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, turma.getNome());
            stmt.setInt(2, turma.getProfessor().getId());
            stmt.setInt(3, turma.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM turma WHERE id = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void adicionarEstudante(int turmaId, int estudanteId) {
        String verificaTurma = "SELECT id FROM turma WHERE id = ?";
        String verificaEstudante = "SELECT pessoa_id FROM estudantes WHERE pessoa_id = ?";

        try (PreparedStatement stmtTurma = conexao.prepareStatement(verificaTurma);
             PreparedStatement stmtEstudante = conexao.prepareStatement(verificaEstudante)) {

            stmtTurma.setInt(1, turmaId);
            stmtEstudante.setInt(1, estudanteId);

            ResultSet rsTurma = stmtTurma.executeQuery();
            ResultSet rsEstudante = stmtEstudante.executeQuery();

            if (rsTurma.next() && rsEstudante.next()){
                String sql = "INSERT INTO turma_estudante (id_turma, id_estudante) VALUES (?,?)";
                try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                    stmt.setInt(1, turmaId);
                    stmt.setInt(2, estudanteId);
                    stmt.executeUpdate();
                }
            } else{
                System.out.println("Erro: Turma ou Estudante não encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerEstudante(int turmaId, int estudanteId) {
        String sql = "DELETE FROM turma_estudante WHERE id_turma = ? AND id_estudante = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, turmaId);
            stmt.setInt(2, estudanteId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void transferirEstudante(int IdEstudante, int turmaOrigem, int turmaDestino) {
        removerEstudante(turmaOrigem, IdEstudante);
        adicionarEstudante(turmaDestino, IdEstudante);
    }

    private List<Estudante> buscarEstudantesDaTurma (int turmaId){
        List<Estudante> estudantes = new ArrayList<>();
        String sql = "SELECT e.pessoa_id, pe.nome, pe.email, e.matricula " +
                "FROM estudantes e " +
                "INNER JOIN turma_estudante te ON e.pessoa_id = te.id_estudante " +
                "INNER JOIN pessoas pe ON e.pessoa_id = pe.id " +
                "WHERE te.id_turma = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, turmaId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Estudante estudante = new Estudante(
                        rs.getInt("pessoa_id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula")
                );
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return estudantes;
    }
}