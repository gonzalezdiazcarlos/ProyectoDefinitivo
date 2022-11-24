import basesdedatos.BasesdedDatos;



public class MainMenu {                           //Menu principal
	public static void main(String[] args) {
		
		BasesdedDatos bases=new BasesdedDatos();
		bases.conectar();
		bases.obtenerUsuarios();
		
		frm_menu.main(args);
	
		
		
	}
}
