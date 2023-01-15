package Utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Usuario;

public class UsuarioTest {
	
	@Test
	public void TestGetNombre() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		assertEquals("Carlos",us.getNombre());
	}
	
	@Test
	public void TestGetCorreo() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		assertEquals("Carlos@gmail.com",us.getCorreo());
	}
	
	@Test
	public void TestGetContraseña() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		assertEquals("contraseña",us.getContraseña());
	}
	
	@Test
	public void TestSetNombre() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		us.setNombre("Jorge");
		assertEquals("Jorge",us.getNombre());
	}
	
	@Test
	public void TestSetCorreo() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		us.setCorreo("jorge@gmail.com");
		assertEquals("jorge@gmail.com",us.getCorreo());
	}
	
	@Test
	public void TestSetContraseña() {
		Usuario us = new Usuario("Carlos","Carlos@gmail.com","contraseña");
		us.setContraseña("contraseñanueva");
		assertEquals("contraseñanueva",us.getContraseña());
	}

}
