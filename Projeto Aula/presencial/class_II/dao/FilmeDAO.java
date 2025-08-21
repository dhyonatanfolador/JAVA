package presencial.class_II.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import presencial.class_II.connection.ConnectionFactory;
import presencial.class_II.model.Filme;

public class FilmeDAO implements dao.DAO<Filme> {

	private Connection con = null;

	public FilmeDAO() {
		con = ConnectionFactory.getConnection();
	}

	public Optional<Filme> getbyID(long id) {//ok
		Filme filme = null;

		try {
			String sql = "select * from filme where id=" + id;
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				filme = new Filme();
				filme.setId(rs.getInt("id"));
				filme.setTitulo(rs.getString("titulo"));
			}

		} catch (SQLException ex) {
			System.err.println("Erro" + ex);
			return Optional.empty();

		} finally {
			ConnectionFactory.closeConnection(con);
		}

		return Optional.ofNullable(filme);
	}

	@Override
	public List<Filme> getAll() {
		try {

			List<Filme> filmes =  new ArrayList<Filme>();

			PreparedStatement ps = con.prepareStatement("select * from filme");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Filme f = new Filme();
				f.setId(rs.getInt("id"));
				f.setTitulo(rs.getString("titulo"));
				f.setSinopse(rs.getString("sinopse"));
				f.setGenero(rs.getString("genero"));

				filmes.add(f);
			}

			return filmes;

		} catch (SQLException ex) {
			System.err.println("Erro " + ex);
			return null;
		} finally {
			ConnectionFactory.closeConnection(con);
		}
	}

	@Override
	public boolean save(Filme t) { //ok
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO filme (titulo,genero,sinopse,duracao) VALUES (?,?,?,?)");
			stmt.setString(1, t.getTitulo());
			stmt.setString(2, t.getGenero());
			stmt.setString(3, t.getSinopse());
			stmt.setInt(4, t.getDuracao());

			stmt.executeUpdate();

			return true;

		} catch (SQLException ex) {
			System.err.println("Erro " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	@Override
	public boolean updatebyID(Filme t) {//ok
		PreparedStatement stmt = null;

		try {
			stmt = con
					.prepareStatement("UPDATE filme SET titulo = ?,genero = ?, sinopse = ?, duracao = ? WHERE id = ?");
			stmt.setString(1, t.getTitulo());
			stmt.setString(2, t.getGenero());
			stmt.setString(3, t.getSinopse());
			stmt.setInt(4, t.getDuracao());
			stmt.setInt(5, t.getId());

			stmt.executeUpdate();
			return true;

		} catch (SQLException ex) {
			System.err.println("Erro " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con, stmt);

		}
	}

	@Override
	public boolean deletebyID(Filme t) { //ok
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("delete from filme where id = ?");
			stmt.setInt(1, t.getId());

			stmt.executeUpdate();

			return true;
		} catch (SQLException ex) {
			System.err.println("Erro excluindo dados no filme " + ex);
			return false;
		} finally {
			ConnectionFactory.closeConnection(con);

		}
	}
}
