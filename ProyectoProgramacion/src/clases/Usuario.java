package clases;
import Utilidades.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Utilidades.UtilFiles;
 
public class Usuario {

  private String Nombre;
  private String Correo;
  private String Contraseña;
 
  
public Usuario(String nombre, String correo, String contraseña) {
	super();
	Nombre = nombre;
	Correo = correo;
	Contraseña = contraseña;
	
}


public Usuario() {
	// TODO Auto-generated constructor stub
}


public String getNombre() {
	return Nombre;
}


public void setNombre(String nombre) {
	Nombre = nombre;
}


public String getCorreo() {
	return Correo;
}


public void setCorreo(String correo) {
	Correo = correo;
}


public String getContraseña() {
	return Contraseña;
}


public void setContraseña(String contraseña) {
	Contraseña = contraseña;
}
  
  
	  



}