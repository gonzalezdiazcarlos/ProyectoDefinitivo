package basesdedatos; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BasesdedDatos {
	
	public Connection conn;
	
	public Connection conectar () {
		Connection conn = null;
		String url = "jdbc:sqlite:baseproyecto.db";
		try {
			conn = DriverManager.getConnection(url);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
	public  void obtenerUsuarios () {
		String sql = "SELECT NOMBRE, CONTRASENA FROM USUARIOS";
		try (Connection conn = this.conectar();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {
			while(rs.next()) {
				System.out.println(rs.getString("nombre") + rs.getString("contrasena"));
			}
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void IntroducirTablaUsuario () {
		
	}
	
	public void obtenerCalzado() {
		
	}
	
	public void introducirTablaCalzado() {
		
	}
	
}	
