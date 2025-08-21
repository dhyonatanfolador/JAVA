package presencial.class_II.dao;

import presencial.class_II.connection.ConnectionFactory;
import presencial.class_II.model.Filme;
import presencial.class_II.model.Filminho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class FilminhoDAO implements dao.DAO<Filminho> {
    private final Connection con;

    public FilminhoDAO() {
        con = presencial.class_II.connection.ConnectionFactory.getConnection();
    }

    public Optional<Filminho> getbyID(long id) {
        Filminho filminho = null;

        try {
            String sql = "select * from filminho where id=" + id;
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                filminho = new Filminho();
                filminho.setId(rs.getInt("id"));
                filminho.setAutor(rs.getString("autor"));
                filminho.setProdutora(rs.getString("produtora"));
            }

        } catch (SQLException ex) {
            System.err.println("Erro" + ex);
            return Optional.empty();

        } finally {
            ConnectionFactory.closeConnection(con);
        }

        return Optional.ofNullable(filminho);
    }

    public List<Filminho> getAll() {
        try {

            List<Filminho> filminhos =  new ArrayList<Filminho>();

            PreparedStatement ps = con.prepareStatement("select * from filminho");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Filminho f = new Filminho();
                f.setId(rs.getInt("id"));
                f.setAutor(rs.getString("autor"));
                f.setProdutora(rs.getString("produtora"));

                filminhos.add(f);
            }

            return filminhos;

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return null;
        } finally {
            ConnectionFactory.closeConnection(con);
        }
    }

    public boolean save(Filminho filminho) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO filminho (autor, produtora) VALUES (?, ?)");
            stmt.setString(1, filminho.getAutor());
            stmt.setString(2, filminho.getProdutora());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            presencial.class_II.connection.ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public boolean updatebyID(Filminho filminho) {
        PreparedStatement stmt = null;

        try {
            stmt = con
                    .prepareStatement("UPDATE filminho SET autor = ?,produtora = ? WHERE id = ?");
            stmt.setString(1, filminho.getAutor());
            stmt.setString(2, filminho.getProdutora());
            stmt.setInt(3, filminho.getId());

            stmt.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.err.println("Erro " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    public boolean deletebyID(Filminho filminho) {
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("delete from filminho where id = ?");
            stmt.setInt(1, filminho.getId());

            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            System.err.println("Erro excluindo dados no filminho " + ex);
            return false;
        } finally {
            ConnectionFactory.closeConnection(con);

        }
    }
}
