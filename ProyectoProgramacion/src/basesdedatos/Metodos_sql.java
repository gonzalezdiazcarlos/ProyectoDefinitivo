package basesdedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Metodos_sql {
	
	public static ConexionBD conexion = new ConexionBD ();
	
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	public int guardar (String nombre, String codigo, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO usuario (NOMBRE,CODIGO,CONTRASEÑA,TELEFONO) VALUES ('" + nombre +"',"+ codigo +"',"+ contraseña + "')";
		
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,nombre);
			sentencia_preparada.setString(2,codigo);
			sentencia_preparada.setString(3,contraseña);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
		
			
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return resultado;
	}
	
	
	

}
