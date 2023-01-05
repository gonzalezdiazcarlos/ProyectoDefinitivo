package basesdedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodosCesta {
	
public static ConexionBDcesta conexion = new ConexionBDcesta ();
	
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	public int guardar (String Usuario, String Codigo, String Nombre, String Tipo, String Cantidad, String Precio, String Color, String Talla, String Genero) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO pedidos (Usuario,Codigo,Nombre,Tipo,Cantidad,Precio,Color,Talla,Genero) VALUES (?,?,?,?,?,?,?,?,?)";
		
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,Usuario);
			sentencia_preparada.setString(2,Codigo);
			sentencia_preparada.setString(3,Nombre);
			sentencia_preparada.setString(4,Tipo);
			sentencia_preparada.setString(5,Cantidad);
			sentencia_preparada.setString(6,Precio);
			sentencia_preparada.setString(7,Color);
			sentencia_preparada.setString(8,Talla);
			sentencia_preparada.setString(9,Genero);
			
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al guardar");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			
			System.out.println(e);
		}
		return resultado;
	
	}

}


