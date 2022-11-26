package basesdedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MetodosUsuario_sql {
	
	public static ConexionBD conexion = new ConexionBD ();
	
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	public int guardar (String nombre, String Correo, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO usuario (NOMBRE,CORREO,CONTRASEÑA) VALUES ("+"'"+nombre+"',"+"'"+Correo +"',"+"'"+contraseña+"'"+")";
		
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,nombre);
			sentencia_preparada.setString(2,Correo);
			sentencia_preparada.setString(3,contraseña);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
			
		} catch (Exception e) {
			
			System.out.println(e);
		}
		return resultado;
	
	}
		
	public int guardarAdmin (String Codigo, String nombre, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO admin (CODIGO,NOMBRE,CONTRASEÑA) VALUES ("+"'"+Codigo+"',"+"'"+nombre+"',"+"'"+contraseña+"'"+")";
		
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1, Codigo);
			sentencia_preparada.setString(2, nombre);
			sentencia_preparada.setString(3, contraseña);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
			
		} catch (Exception e) {

			System.out.println(e);
		}
		return resultado;
	}
	
	public static String buscarNombre (String Correo) {
		 String busqueda_nombre = null;
		 Connection conexion = null;
		 try {
			 conexion  = ConexionBD.conectar();
			 String sentencia_buscar = ("SELECT NOMBRE, CONTRASEÑA FROM USUARIO WHERE CORREO = '" + Correo + "'");
			 sentencia_preparada = conexion.prepareStatement(sentencia_buscar); 
			 resultado = sentencia_preparada.executeQuery();
			 if(resultado.next()) {
				 String nombre = resultado.getString("NOMBRE");
				 String contraseña = resultado.getString("CONTRASEÑA");
				 busqueda_nombre = (nombre + " "+ contraseña);
			 }
			 
			 conexion.close(); 
			 
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 
		 return busqueda_nombre;
	}
	
	/**
	 * @return
	 */
	public static String buscarUsuarioRegistrado (String correo, String contraseña) {
		String busqueda_usuario = null;
		Connection conexion = null; 
		
		try {
			conexion = ConexionBD.conectar();
			String sentencia_buscar_usuario = ("SELECT NOMBRE, CORREO, CONTRASEÑA FROM USUARIO WHERE CORREO = '"+correo+"' && CONTRASEÑA = '"+ contraseña + "'");
			sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
			resultado = sentencia_preparada.executeQuery();
			if(resultado.next()) {
				busqueda_usuario = "usuario encontrado";
			}else {
				busqueda_usuario = "usuario no encontrado";
			}
			
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return busqueda_usuario;
	}
	
	public static String buscarNombreAdmin (String Codigo) {
		 String busqueda_nombre = null;
		 Connection conexion = null;
		 try {
			 conexion  = ConexionBD.conectar();
			 String sentencia_buscar = ("SELECT NOMBRE, CONTRASEÑA FROM administrador WHERE CORREO = '" + Codigo + "'");
			 sentencia_preparada = conexion.prepareStatement(sentencia_buscar); 
			 resultado = sentencia_preparada.executeQuery();
			 if(resultado.next()) {
				 String nombre = resultado.getString("NOMBRE");
				 String contraseña = resultado.getString("CONTRASEÑA");
				 busqueda_nombre = (nombre + " "+ contraseña);
			 }
			 
			 conexion.close(); 
			 
		 } catch (Exception e) {
			 System.out.println(e);
		 }
		 
		 return busqueda_nombre;
	}
	
	public static String buscarAdminRegistrado (String Codigo, String contraseña) {
		String busqueda_usuario = null;
		Connection conexion = null; 
		
		try {
			conexion = ConexionBD.conectar();
			String sentencia_buscar_usuario = ("SELECT NOMBRE, CORREO, CONTRASEÑA FROM administrador WHERE CORREO = '"+Codigo+"' && CONTRASEÑA = '"+ contraseña + "'");
			sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
			resultado = sentencia_preparada.executeQuery();
			if(resultado.next()) {
				busqueda_usuario = "usuario encontrado";
			}else {
				busqueda_usuario = "usuario no encontrado";
			}
			
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return busqueda_usuario;
	}
	
	
	
	
	
	

}
