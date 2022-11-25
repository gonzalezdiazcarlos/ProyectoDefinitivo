package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBD {
	
	public Connection conn;
	
	public static Connection conectar () {
		Connection conn = null;
		String url = "jdbc:sqlite:BDproyecto.db";
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection(url);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}
	