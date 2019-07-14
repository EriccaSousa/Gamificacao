package factory;

import java.sql.Connection;
import java.sql.SQLException;

import DAO.AdministradorDAO;
import Model.Administrador;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConnectionFactory().getConnection();

		System.out.println("Conexão aberta!");

		connection.close();

	}

}
