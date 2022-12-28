import java.sql.SQLException;
import java.util.ArrayList;

import basesdedatos.MetodosUsuario_sql;

public class MainMenu {                           //Menu principal
	public static void main(String[] args)  {
	
		
		frm_menu.main(args);
		MetodosUsuario_sql metodos = new MetodosUsuario_sql();
		ArrayList usuarios = metodos.getUsuarios();
		System.out.println(usuarios);
	
		
		
	}
}
