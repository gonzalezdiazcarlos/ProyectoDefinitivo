package clases;

public class Pedidos {
	
	private String Usuario;
	private String Codigo;
	private String Nombre;
	private String Tipo;
	private String Cantidad;
	private String Precio;
	private String Color;
	public String Talla;
	public String Genero;
	
	public Pedidos(String usuario, String codigo, String nombre, String tipo, String cantidad, String precio, String color, String talla,
			String genero) {
		super();
		Usuario = usuario;
		Codigo = codigo;
		Nombre = nombre;
		Tipo = tipo;
		Cantidad = cantidad;
		Precio = precio;
		Color = color;
		Talla = talla;
		Genero = genero;
		
	}

	@Override
	public String toString() {
		return "Pedidos [Usuario=" + Usuario + ", Codigo=" + Codigo + ", Nombre=" + Nombre + ", Tipo=" + Tipo
				+ ", Cantidad=" + Cantidad + ", Precio=" + Precio + ", Color=" + Color + ", Talla=" + Talla
				+ ", Genero=" + Genero + "]";
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
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
