package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Model.Administrador;
import factory.ConnectionFactory;

public class AdministradorDAO {

	static Connection connection = new ConnectionFactory().getConnection();

	public static boolean createADM(Administrador adm) throws SQLException {
		String sql = "INSERT INTO Administrador(nome, login, email, senha) VALUES(?, ?, ?, ?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, adm.getNome());
		stmt.setString(2, adm.getLogin());
		stmt.setString(3, adm.getEmail());
		stmt.setString(4, adm.getSenha());

		int rows = stmt.executeUpdate();

		if (rows == 1) {
			return true;
		}
		return false;
	}

}
