package basesdedatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import clases.Usuario;


public class MetodosUsuario_sql {
	
	public static ConexionBD conexion = new ConexionBD ();
	
	public static PreparedStatement sentencia_preparada;
	public static ResultSet resultado;
	public static String sql;
	public static int resultado_numero = 0;
	
	public int guardar (String nombre, String Correo, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO usuario (NOMBRE,CORREO,CONTRASEÑA) VALUES (?,?,?)";
		
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
		
	public int guardarAdmin (String Codigo, String nombre, String contraseña) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO administrador (CODIGO,NOMBRE,CONTRASEÑA) VALUES (?,?,?)";
		
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
			
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al guardar admin");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}

			System.out.println(e);
		}
		return resultado;
	}
	
	public static String buscarNombre (String Correo) {
		 String busqueda_nombre = null;
		 Connection conexion = null;
		 try {
			 conexion  = ConexionBD.conectar();
			 String sentencia_buscar = ("SELECT NOMBRE, CONTRASEÑA FROM USUARIO WHERE CORREO = ?");
			 sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
			 sentencia_preparada.setString(1,Correo);
			 resultado = sentencia_preparada.executeQuery();
			 if(resultado.next()) {
				 String nombre = resultado.getString("NOMBRE");
				 
				 busqueda_nombre = (nombre);
			 }
			 
			 conexion.close(); 
			 
		 } catch (Exception e) {
			 System.out.println(e);
			 Logger logger = Logger.getLogger("My Logger");
				logger.log(Level.ALL, "Error al buscar");
				try {
					logger.addHandler(new FileHandler("Logger.txt",true)); 
				}catch (Exception e1) {
					logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
				}
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
			String sentencia_buscar_usuario = ("SELECT NOMBRE, CORREO, CONTRASEÑA FROM USUARIO WHERE CORREO = ? AND CONTRASEÑA = ?");
			sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
			sentencia_preparada.setString(1, correo);
			sentencia_preparada.setString(2, contraseña);
			resultado = sentencia_preparada.executeQuery();
			if(resultado.next()) {
				busqueda_usuario = "usuario encontrado";
			}else {
				busqueda_usuario = "usuario no encontrado";
			}
			
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(e);
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al buscar");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
		}
		
		return busqueda_usuario;
	}
	
	public static String buscarNombreAdmin (String Codigo) {
		 String busqueda_nombre = null;
		 Connection conexion = null;
		 try {
			 conexion  = ConexionBD.conectar();
			 String sentencia_buscar = ("SELECT NOMBRE, CONTRASEÑA FROM administrador WHERE CODIGO = ?");
			 sentencia_preparada = conexion.prepareStatement(sentencia_buscar); 
			 sentencia_preparada.setString(1,Codigo);
			 resultado = sentencia_preparada.executeQuery();
			 if(resultado.next()) {
				 String nombre = resultado.getString("NOMBRE");
				 String contraseña = resultado.getString("CONTRASEÑA");
				 busqueda_nombre = (nombre);
			 }
			 
			 conexion.close(); 
			 
		 } catch (Exception e) {
			 System.out.println(e);
			 Logger logger = Logger.getLogger("My Logger");
				logger.log(Level.ALL, "Error al buscar");
				try {
					logger.addHandler(new FileHandler("Logger.txt",true)); 
				}catch (Exception e1) {
					logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
				}
		 }
		 
		 return busqueda_nombre;
	}
	
	public static String buscarAdminRegistrado (String Codigo, String contraseña) {
		String busqueda_usuario = null;
		Connection conexion = null; 
		
		try {
			conexion = ConexionBD.conectar();
			String sentencia_buscar_usuario = ("SELECT CODIGO, NOMBRE, CONTRASEÑA FROM administrador WHERE CODIGO = ? AND CONTRASEÑA = ?");
			sentencia_preparada = conexion.prepareStatement(sentencia_buscar_usuario);
			sentencia_preparada.setString(1, Codigo);
			sentencia_preparada.setString(2, contraseña);
			resultado = sentencia_preparada.executeQuery();
			if(resultado.next()) {
				busqueda_usuario = "usuario encontrado";
			}else {
				busqueda_usuario = "usuario no encontrado";
			}
			
			conexion.close();
			
		}catch(Exception e) {
			System.out.println(e);
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al buscar");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
		}
		
		return busqueda_usuario;
	}
	
	public static int EliminarUsuario (String Correo) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "DELETE FROM usuario where Correo = ?";
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,Correo);
			
			resultado = sentencia_preparada.executeUpdate();
			sentencia_preparada.close();
			
			conexion.close();
			
		}catch (Exception e) {
			System.out.println(e);
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al buscar");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			
		}
		
		return resultado;
		
	}
	
	public static ArrayList<Usuario> getUsuarios() {
		Connection conexion = null;
		conexion = ConexionBD.conectar();
		try(Statement statement = conexion.createStatement()){
			ArrayList<Usuario>usuarios = new ArrayList<>();
			String sent = "SELECT * FROM usuario";
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String nombre = rs.getString("NOMBRE");
				String correo = rs.getString("CORREO");
				String contraseña = rs.getString("CONTRASEÑA");
				usuarios.add( new Usuario ( nombre, correo, contraseña));
			}
			return usuarios;
			
		}catch(Exception e) {
			System.out.println(e);
			Logger logger = Logger.getLogger("My Logger");
			logger.log(Level.ALL, "Error al buscar");
			try {
				logger.addHandler(new FileHandler("Logger.txt",true)); 
			}catch (Exception e1) {
				logger.log(Level.SEVERE, "No se pudo crear el fichero",e1);
			}
			return null;
		}
	}
	
	
	
	
	

}
