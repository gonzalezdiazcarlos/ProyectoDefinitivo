package clases;

public class Calzado {
	
	private int Codigo;
	private String Nombre;
	private String Tipo;
	private int Cantidad;
	private int Precio;
	private String Color;
	public int Talla;
	public String Genero;
	
	
	public Calzado(int codigo, String nombre, String tipo, int cantidad, int precio, String color, int talla,
			String genero) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Tipo = tipo;
		Cantidad = cantidad;
		Precio = precio;
		Color = color;
		Talla = talla;
		Genero = genero;
		
	}


	public Calzado() {
		// TODO Auto-generated constructor stub
	}


	


	public int getCodigo() {
		return Codigo;
	}


	public void setCodigo(int codigo) {
		Codigo = codigo;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public int getCantidad() {
		return Cantidad;
	}


	public void setCantidad(int cantidad) {
		Cantidad = cantidad;
	}


	public int getPrecio() {
		return Precio;
	}


	public void setPrecio(int precio) {
		Precio = precio;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public int getTalla() {
		return Talla;
	}


	public void setTalla(int talla) {
		Talla = talla;
	}


	public String getGenero() {
		return Genero;
	}


	public void setGenero(String genero) {
		Genero = genero;
	}
	

	
	
	
}
