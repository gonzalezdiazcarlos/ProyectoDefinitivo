package clases;

public class Administrador {
	
	private String Codigo;
	private String Nombre;
	private String Contraseña;
	
	public Administrador(String codigo, String nombre, String contraseña) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Contraseña = contraseña;
	}
	
	public Administrador() {
		
	}

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	@Override
	public String toString() {
		return "Administrador [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Contraseña=" + Contraseña + "]";
	}
	
	


}
