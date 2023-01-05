package clases;

public class UsuarioPedidos extends Usuario {
	
	int NumeroPedidos;
	
	public UsuarioPedidos (int NumeroPedidos) {
		super();
		this.NumeroPedidos = NumeroPedidos;
		
	}

	public int getNumeroPedidos() {
		return NumeroPedidos;
	}

	public void setNumeroPedidos(int numeroPedidos) {
		NumeroPedidos = numeroPedidos;
	}

	@Override
	public String toString() {
		return "UsuarioPedidos [NumeroPedidos=" + NumeroPedidos + "]";
	}
	
	

}
