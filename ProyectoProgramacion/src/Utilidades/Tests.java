package Utilidades;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.StringTokenizer;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import clases.*;


public class Tests {
    Usuario user;
    Calzado shoe;
	@Before
	public void before() {
		user= new Usuario();
		shoe = new Calzado();
	}
	
	@Test
	void testGmail() {
	StringTokenizer tokens = new StringTokenizer(user.getCorreo(),"@. ");
	int splits= tokens.countTokens();
	 assertEquals(3,splits);
	}
	
	
	
	@Test
	void testCodigoUser() {
	 //assertTrue(user.getContraseña()>999);
	}
	@Test
	void test() {
	 assertAll(
			 
			 ()->assertTrue(shoe.getCodigo()=="7"),
			 
			 ()->assertNotNull(shoe.getGenero()),
			 
			 
			 
			 ()->assertNotEquals("Keep searching", shoe.getColor(),"Rojo")
			 
	 );
	}


	@Test
	void testF() {
		fail("Hola mundo");

	}

}

