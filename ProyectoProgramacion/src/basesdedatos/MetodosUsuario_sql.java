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

import clases.Administrador;
import clases.Calzado;
import clases.Pedidos;
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
	
	public static int EliminarAdmin (String Codigo) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "DELETE FROM administrador where Codigo = ?";
		try {
			conexion = ConexionBD.conectar();
			sentencia_preparada = conexion.prepareStatement(sentencia_guardar);
			sentencia_preparada.setString(1,Codigo);
			
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
	
	public static ArrayList<Administrador> getAdmins(){
		Connection conexion = null;
		conexion = ConexionBD.conectar();
		try(Statement statement = conexion.createStatement()){
			ArrayList<Administrador>admins = new ArrayList<>();
			String sent = "SELECT * FROM administrador";
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { // Leer el resultset
				String codigo = rs.getString("CODIGO");
				String nombre = rs.getString("NOMBRE");
				String contraseña = rs.getString("CONTRASEÑA");
				admins.add( new Administrador (codigo , nombre, contraseña));
			}
			return admins ;
			
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
	
public int guardarCalzado(String codigo, String nombre, String tipo, int cantidad, int precio, String color, int talla, String genero) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "INSERT INTO calzado (Codigo,Nombre,Tipo,Cantidad,Precio,Color,Talla,Genero) VALUES (?,?,?,?,?,?,?,?)";
		try {
			conexion = ConexionBD.conectar();
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
			
			conexion = ConexionBD.conectar();
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
	
	public int guardarPedidos (String Usuario, String Codigo, String Nombre, String Tipo, String Cantidad, String Precio, String Color, String Talla, String Genero) {
		
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
	
	public static ArrayList<Calzado> getCalzado(String Nombre) {
		Connection conexion = null;
		conexion = ConexionBD.conectar();
		String sent = "SELECT * FROM calzado where Nombre = ?";
		try(Statement statement = conexion.createStatement()){
			ArrayList<Calzado>Calzados = new ArrayList<>();
			sentencia_preparada = conexion.prepareStatement(sent);
			sentencia_preparada.setString(1, Nombre);
			ResultSet rs = sentencia_preparada.executeQuery();
			while( rs.next() ) { // Leer el resultset
				String Codigo = rs.getString("Codigo");
				String Nombre1 = rs.getString("Nombre");
				String Tipo = rs.getString("Tipo");
				String Cantidad = rs.getString("Cantidad");
				String Precio = rs.getString("Precio");
				String Color = rs.getString("Color");
				String Talla = rs.getString("Talla");
				String Genero = rs.getString("Genero");
				Calzados.add( new Calzado (Codigo,Nombre1,Tipo,Cantidad,Precio,Color,Talla,Genero));
			}
			return Calzados;
			
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
	
	public static ArrayList<Pedidos> getPedidos(String Nombre) {
		Connection conexion = null;
		conexion = ConexionBD.conectar();
		String sent = "SELECT * FROM pedidos where Usuario = ?";
		try(Statement statement = conexion.createStatement()){
			ArrayList<Pedidos>Pedidos = new ArrayList<>();
			sentencia_preparada = conexion.prepareStatement(sent);
			sentencia_preparada.setString(1, Nombre);
			ResultSet rs = sentencia_preparada.executeQuery();
			while( rs.next() ) { // Leer el resultset
				String Correo = rs.getString("Usuario");
				String Codigo = rs.getString("Codigo");
				String Nombre1 = rs.getString("Nombre");
				String Tipo = rs.getString("Tipo");
				String Cantidad = rs.getString("Cantidad");
				String Precio = rs.getString("Precio");
				String Color = rs.getString("Color");
				String Talla = rs.getString("Talla");
				String Genero = rs.getString("Genero");
				Pedidos.add( new Pedidos (Correo,Codigo,Nombre1,Tipo,Cantidad,Precio,Color,Talla,Genero));
			}
			return Pedidos;
			
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
	
	public static int EliminarPedido (String Usuario,String Codigo,String Nombre,String Tipo,String Cantidad,String Precio,String Color,String Talla,String Genero) {
		
		int resultado = 0;
		Connection conexion = null;
		
		String sentencia_guardar = "DELETE FROM pedidos where Usuario = ? AND Codigo = ? AND Nombre = ? AND Tipo = ? AND Cantidad = ? AND Precio = ? AND Color = ? AND Talla = ? AND Genero = ?";
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
	
	public static ArrayList<Administrador> ordenarAdmin(){
		Connection conexion = null;
		conexion = ConexionBD.conectar();
		try(Statement statement = conexion.createStatement()){
			ArrayList<Administrador>admins = new ArrayList<>();
			String sent = "SELECT * FROM administrador ORDER BY CODIGO ASC";
			ResultSet rs = statement.executeQuery( sent );
			while( rs.next() ) { 
				String codigo = rs.getString("CODIGO");
				String nombre = rs.getString("NOMBRE");
				String contraseña = rs.getString("CONTRASEÑA");
				admins.add( new Administrador (codigo , nombre, contraseña));
				
			}
			return admins ;
			
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
		
		public static ArrayList<Usuario> ordenarUsuarios() {
			Connection conexion = null;
			conexion = ConexionBD.conectar();
			try(Statement statement = conexion.createStatement()){
				ArrayList<Usuario>usuarios = new ArrayList<>();
				String sent = "SELECT * FROM usuario ORDER BY NOMBRE ASC";
				ResultSet rs = statement.executeQuery( sent );
				while( rs.next() ) { 
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
