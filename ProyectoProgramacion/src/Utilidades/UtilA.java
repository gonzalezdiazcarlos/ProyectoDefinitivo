package Utilidades;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import clases.Calzado;

public class UtilA {  // Metodos normales a usar en el proyecto

	
	public static String displayMenu() {
		System.out.println("Menu:");
		String choice= getStringInput("¿Que desea hacer?");
		return choice;}
	
	

	public static int getIntegerInput(String output) {//gives int input
		    System.out.println(output);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			Integer entero = null;
			boolean error = true;
			do{
				try{
					String cadena = br.readLine();
					entero = new Integer(cadena);
					error = false;
				}catch(NumberFormatException nfe)
	      {System.out.println("No teclee un numero entero-Repetir");
	      }catch (Exception e)
				{System.out.println("Error de entrada-Repetir ");
				}
			}while(error);
			return entero.intValue(); }

	
	
	
	public static String getStringInput(String output) {//gives String input
		    System.out.println(output);
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			String cadena = null;
			boolean error = true;
			do{
				try{
					cadena = br.readLine();
					error = false;
				}catch (Exception e)
				{System.out.println("Error de entrada-Repetir ");
				}
			}while(error);
			return cadena;  }
	
	
	
	
	public boolean logUserIn(String name, String password) throws IOException {// returns true= admin,  false=regular user
		boolean admin = false;
		String ficha=getStringInput("¿Que fichero desea?");
        File file =	UtilFiles.getFile(ficha);//read lines
        ArrayList<ArrayList<String[]>> users = UtilFiles.getUsers(file);//[[name1,password1,adminType1],[name2,password2,adminType2]...]
        //if password and name in same line-->
        for(int a =0; users.size() > a  ;a++) {
		   if(users.get(a).get(0).equals(name)  && users.get(a).get(1).equals(password)){
			   System.out.println("User: "+name+ " is a user");
			   if(users.get(a).get(2).equals("admin")) {
			   admin=true;}
		   }
		}
		return admin;
	}


public void popUser(String name, String password) throws IOException {
	boolean exists=false;
	String ficha=getStringInput("¿Que fichero desea?");
    File file =	UtilFiles.getFile(ficha);//read lines
    ArrayList<ArrayList<String[]>> users = UtilFiles.getUsers(file);
    for(int a =0; users.size() > a  ;a++) {
    	if(users.get(a).get(2).equals("normal")) {//solo los users normales se pueden eliminar
    	System.out.println(users.get(a));}}
    System.out.println("¿Que usuario desea eliminar?");
    
}

public static void VerdatosUsuario () {
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver de la base de datos");
	}
	try {
		Connection conn = DriverManager.getConnection("jdbc:sqlite:baseproyecto.db");
		Statement stmt  = conn.createStatement();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM USUARIO");
			while(rs.next()) {
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				System.out.format("%s, %s%n", apellido,nombre );
			}
		}	catch (SQLException e) {
			e.printStackTrace(); 
		}
		conn.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("No se ha podido establecer conexion a la base de datos");
	}
	
}

public static void VerdatosCalzado () {
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver de la base de datos");
	}
	try {
		Connection conn1 = DriverManager.getConnection("jdbc:sqlite:baseproyecto.db");
		Statement stmt1  = conn1.createStatement();
		try {
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM CALZADO");
			while(rs1.next()) {
				String codigo = rs1.getString("CODIGO");
				String precio = rs1.getString("PRECIO");
				System.out.format("%s, %s%n",codigo ,precio );
			}
		}	catch (SQLException e) {
			e.printStackTrace(); 
		}
		conn1.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println("No se ha podido establecer conexion a la base de datos");
	}
	
}

public static void UpdateUsuario (String name, String password, String puesto, int tlfn, int codigousuario){
	
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver de la base de datos");
	}
	
	System.out.println("hola");
	
	try {
		Connection conn3 = DriverManager.getConnection("jdbc:sqlite:baseproyecto.db");
		
		Statement stmt3  = conn3.createStatement();
		
		int rows = stmt3.executeUpdate("INSERT INTO USUARIO (CODIGO,NOMBRE,CONTRASENA,PUESTO,TELEFONO) VALUES (+ name,password,puesto,tlfn,codigousuario");
		System.out.println(String.format("%d filas modificas", rows));
		
		stmt3.close();
		conn3.close();
		
	}	catch (SQLException e) {
		System.out.println("No se ha podido conectar a la base de datos");
		System.out.println(e.getMessage());
	}

	
}

public static void UpdateCalzado (int Codigo, int cantidad, int precio, String color, int talla, String tipo){
	
	try {
		Class.forName("org.sqlite.JDBC");
	} catch (ClassNotFoundException e) {
		System.out.println("No se ha podido cargar el driver de la base de datos");
	}
	
	System.out.println("hola");
	
	try {
		Connection conn4 = DriverManager.getConnection("jdbc:sqlite:baseproyecto.db");
		
		Statement stmt4  = conn4.createStatement();
		
		int rows = stmt4.executeUpdate("INSERT INTO CALZADO (CODIGOCAL,CANTIDAD,PRECIO,COLOR,TALLA,TIPO) VALUES (CODIGO,CANTIDAD,PRECIO,COLOR,TALLA,TIPO");
		System.out.println(String.format("%d filas modificas", rows));
		
		stmt4.close();
		conn4.close();
		
	}	catch (SQLException e) {
		System.out.println("No se ha podido conectar a la base de datos");
		System.out.println(e.getMessage());
	}

	
}

public void suggestZapa(String[] listaVentas, int index) {
	Arrays.sort(listaVentas);
	for(int a=index;a<listaVentas.length;a++) {
        System.out.println(listaVentas[a]);  }
}


public void filterProduct(String filter, Calzado[]listaCalzados, String gender, String stamp,String colour,String type,int size,float price) {
	switch(filter) {
	
	}





	
	
}
	
	
}
