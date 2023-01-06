package clases;

public class Calzado {
	
	private String Codigo;
	private String Nombre;
	private String Tipo;
	private String Cantidad;
	private String Precio;
	private String Color;
	public String Talla;
	public String Genero;
	
	
	public Calzado(String codigo, String nombre, String tipo, String cantidad, String precio, String color, String talla,
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


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public String getCantidad() {
		return Cantidad;
	}


	public void setCantidad(String cantidad) {
		Cantidad = cantidad;
	}


	public String getPrecio() {
		return Precio;
	}


	public void setPrecio(String precio) {
		Precio = precio;
	}


	public String getColor() {
		return Color;
	}


	public void setColor(String color) {
		Color = color;
	}


	public String getTalla() {
		return Talla;
	}


	public void setTalla(String talla) {
		Talla = talla;
	}


	public String getGenero() {
		return Genero;
	}


	public void setGenero(String genero) {
		Genero = genero;
	}
	

	
	
	
}
