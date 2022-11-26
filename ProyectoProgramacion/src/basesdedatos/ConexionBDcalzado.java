package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBDcalzado {

	public Connection c;
	
	public static Connection Conectar() {
		Connection c = null;
		String url = "jdbc:sqlite:BDcalzado.db";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return c;
	}
	
	
}
