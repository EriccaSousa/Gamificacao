package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import Model.Gamer;
import factory.ConnectionFactory;

public class GamerDAO {
	static Connection connection = new ConnectionFactory().getConnection();

	public static boolean createGamer(Gamer gamer) throws SQLException {
		String sql = "INSERT INTO Gamer(nome, matricula, senha, email, pontuacao, diamantes, cristais) VALUES(?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, gamer.getNome());
		stmt.setString(2, gamer.getMatricula());
		stmt.setString(3, gamer.getSenha());
		stmt.setString(4, gamer.getEmail());
		stmt.setDouble(5, gamer.getPontuacao());
		stmt.setInt(6, gamer.getDiamantes());
		stmt.setInt(7, gamer.getCristais());

		int rows = stmt.executeUpdate();

		if (rows == 1) {
			return true;
		}
		return false;

	}

}
