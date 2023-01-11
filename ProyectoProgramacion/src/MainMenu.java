import java.sql.SQLException;
import java.util.ArrayList;

import basesdedatos.MetodosUsuario_sql;

public class MainMenu {                           //Menu principal
	public static void main(String[] args)  {
	
		
		VentanaMenu.main(args);
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		ArrayList usuarios = metodos.getUsuarios();
		System.out.println(usuarios);
	
		
		
	}
}
