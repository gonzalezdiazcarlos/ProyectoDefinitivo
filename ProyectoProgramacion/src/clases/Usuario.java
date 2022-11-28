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
  private String Dni;
  private int Tlfn;
  
public Usuario(String nombre, String correo, String contraseña, String dni, int tlfn) {
	super();
	Nombre = nombre;
	Correo = correo;
	Contraseña = contraseña;
	Tlfn=tlfn;
	Dni=dni;
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
  
  public void setTlfn(int tlfn) {
	  Tlfn=tlfn;
  }
 
  public void setDni(String dni) {
      Dni=dni;
  }
public String getDni() {
	return Dni;
}
public int getTlfn() {
	return Tlfn;
}
	  



}