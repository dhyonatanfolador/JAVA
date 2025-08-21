package org.banco_de_entidades.dao;

import org.banco_de_entidades.model.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IDAO<Professor> {
    private final Connection conexao;
    public ProfessorDAO(Connection conexao) {
        this.conexao = conexao;
    }


    public void inserir(Professor professor) {
        String sqlPessoa = "INSERT INTO pessoas (nome, email) VALUES (?, ?)";
        String sqlProfessor = "INSERT INTO professores (pessoa_id, departamento) VALUES (?, ?)";

        try (PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement stmtProfessor = conexao.prepareStatement(sqlProfessor)) {

            conexao.setAutoCommit(false);

            // Inserir na tabela de pessoas
            stmtPessoa.setString(1, professor.getNome());
            stmtPessoa.setString(2, professor.getEmail());
            stmtPessoa.executeUpdate();

            try (ResultSet generatedKeys = stmtPessoa.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    professor.setId(generatedKeys.getInt(1));
                }
            }

            // Inserir na tabela de professores
            stmtProfessor.setInt(1, professor.getId());
            stmtProfessor.setString(2, professor.getDepartamento());
            stmtProfessor.executeUpdate();

            conexao.commit();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir professor: " + e.getMessage());
        }
    }

    @Override
    public Professor buscarPorId(int id) {
        String sql = "SELECT p.id, p.nome, p.email, pr.departamento FROM pessoas p JOIN professores pr ON p.id = pr.pessoa_id WHERE p.id = ?";
        Professor professor = null;

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                professor = new Professor(
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professor;
    }

    @Override
    public List<Professor> listarTodos() {
        String sql = "SELECT p.id, p.nome, p.email, pr.departamento FROM pessoas p JOIN professores pr ON p.id = pr.pessoa_id";
        List<Professor> professores = new ArrayList<>();

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Professor professor = new Professor(
                );
                professores.add(professor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return professores;
    }

    @Override
    public void atualizar(Professor professor) {
        String sqlPessoa = "UPDATE pessoas SET nome = ?, email = ? WHERE id = ?";
        String sqlProfessor = "UPDATE professores SET departamento = ? WHERE pessoa_id = ?";

        try (PreparedStatement stmtPessoa = conexao.prepareStatement(sqlPessoa);
             PreparedStatement stmtProfessor = conexao.prepareStatement(sqlProfessor)) {

            conexao.setAutoCommit(false);

            stmtPessoa.setString(1, professor.getNome());
            stmtPessoa.setString(2, professor.getEmail());
            stmtPessoa.setInt(3, professor.getId());
            stmtPessoa.executeUpdate();

            stmtProfessor.setString(1, professor.getDepartamento());
            stmtProfessor.setInt(2, professor.getId());
            stmtProfessor.executeUpdate();

            conexao.commit();
        }  catch (SQLException rollbackEx) {
            System.err.println("Erro no rollback: " + rollbackEx.getMessage());
        }
    }

    @Override
    public void deletar(int id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
