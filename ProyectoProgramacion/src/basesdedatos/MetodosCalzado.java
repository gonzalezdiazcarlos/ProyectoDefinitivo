package basesdedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MetodosCalzado {

	public static ConexionBDcalzado conexion = new ConexionBDcalzado();
	
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	
	
	public int guardar(String codigo, String nombre, String tipo, int cantidad, int precio, String color, int talla, String genero) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO calzado (Codigo,Nombre,Tipo,Cantidad,Precio,Color,Talla,Genero) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conexion = ConexionBDcalzado.Conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1, codigo);
			sentencia_preparada.setString(2, nombre);
			sentencia_preparada.setString(3, tipo);
			sentencia_preparada.setInt(4, cantidad);
			sentencia_preparada.setInt(5, precio);
			sentencia_preparada.setString(6, color);
			sentencia_preparada.setInt(7, talla);
			sentencia_preparada.setString(8, genero);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al guardar calzado");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			System.out.println(e);
		}
	
		return resultado;
	}
	
		
	
	
	public String buscarNombreCalzado (String nombre , String tipo, String color) {
		String busqueda_calzado = null;
		Connection conexion = null;
		
		try {
			
			conexion = ConexionBDcalzado.Conectar();
			String sentencia_busqueda_calzado = ("SELECT Nombre, Tipo, Color FROM calzado WHERE Tipo = ? AND Color = ?");
			sentencia_preparada = conexion.prepareStatement(sentencia_busqueda_calzado);
			sentencia_preparada.setString(1,nombre);
			sentencia_preparada.setString(2,color);
			resultado = sentencia_preparada.executeQuery();
			if(resultado.next()) {
				busqueda_calzado = "calzado encontrado";
			}else {
				busqueda_calzado = "calzado no encontrado";
				
			}
			conexion.close();
			
		} catch (Exception e) {
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al buscar calzado");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			System.out.println(e);
		}
		return busqueda_calzado;
		
		
	}
	
}