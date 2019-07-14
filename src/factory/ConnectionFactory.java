package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Gamificação", "postgres",
					"418376");

			return con;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
