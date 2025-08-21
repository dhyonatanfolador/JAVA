package org.banco_de_entidades.dao;

import org.banco_de_entidades.infra.ConexaoSingleton;
import org.banco_de_entidades.model.Estudante;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EstudanteDAO {

    private final Connection conexao;
    public EstudanteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserir(Estudante estudante) {
        String sqlPessoa = "INSERT INTO pessoas (nome, email) VALUES (?, ?)";
        String sqlEstudante = "INSERT INTO estudantes (pessoa_id, matricula) VALUES (?, ?)";

        try (PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtEstudante = conexao.prepareStatement(sqlEstudante)) {

            conexao.setAutoCommit(false);

            // Inserir na tabela de pessoas
            stmtPessoa.setString(1, estudante.getNome());
            stmtPessoa.setString(2, estudante.getEmail());
            stmtPessoa.executeUpdate();

            try (ResultSet generatedKeys = stmtPessoa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    estudante.setId(generatedKeys.getInt(1));
                }
            }

            // Inserir na tabela de estudantes
            stmtEstudante.setInt(1, estudante.getId());
            stmtEstudante.setString(2, estudante.getMatricula());
            stmtEstudante.executeUpdate();

            conexao.commit();
        } catch (SQLException e) {
            try {
                conexao.rollback();
            } catch (SQLException rollbackEx) {
                System.err.println("Erro no rollback: " + rollbackEx.getMessage());
            }
            System.err.println("Erro ao inserir estudante: " + e.getMessage());
        }
    }

    public Estudante buscar_id(int id) {
        Estudante estudante = null;
        String sql = "SELECT p.id, p.nome, p.email, es.matricula " +
                " FROM pessoas p " +
                " JOIN estudantes es " +
                " ON p.id = es.pessoa_id WHERE p.id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    estudante = new Estudante(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("email"),
                            rs.getString("matricula")
                    );
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudante;
    }

    public List<Estudante> listar_todos() {
        List<Estudante> estudantes = new ArrayList<>();
        String sql = "SELECT p.id, p.nome, p.email, es.matricula " +
                " FROM pessoas p " +
                " JOIN estudantes es " +
                " ON p.id = es.pessoa_id WHERE p.id = ?";

        try (PreparedStatement stmt = (PreparedStatement) conexao.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Estudante estudante = new Estudante(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("matricula")
                );
                estudantes.add(estudante);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return estudantes;
    }

    public void atualizar(Estudante estudante) {
        String sqlPessoa = "UPDATE pessoas SET nome = ?, email = ?, matricula = ? WHERE id = ?";
        String sqlEstudante = "UPDATE estudantes SET matricula = ? WHERE pessoa_id = ?";

        try (PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtEstudante = conexao.prepareStatement(sqlEstudante)) {

            conexao.setAutoCommit(false);

            // Inserir na tabela de pessoas
            stmtPessoa.setString(1, estudante.getNome());
            stmtPessoa.setString(2, estudante.getEmail());
            stmtPessoa.executeUpdate();

            stmtEstudante.setString(1, estudante.getMatricula());
            stmtEstudante.setInt(2, estudante.getId());
            stmtEstudante.executeUpdate();

            conexao.commit();
        } catch (SQLException rollbackEx) {
            System.err.println("Erro no rollback: " + rollbackEx.getMessage());
        }
    }

    public void deletar(int id) {
        String sqlPessoa = "DELETE FROM pessoas WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sqlPessoa)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
