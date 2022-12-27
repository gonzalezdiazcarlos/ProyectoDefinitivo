package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBDcalzado {

	public Connection c;
	
	public static Connection Conectar() {
		Connection c = null;
		String url = "jdbc:sqlite:BDcalzado.db";
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection(url);
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al conectar con la base de datos");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			System.out.println(e.getMessage());
		}
		
		return c;
	}
	
	
}
