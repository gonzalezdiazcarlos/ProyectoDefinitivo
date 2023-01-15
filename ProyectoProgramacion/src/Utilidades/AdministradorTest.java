package Utilidades;

import static org.junit.Assert.*;

import org.junit.Test;


import clases.Administrador;

public class AdministradorTest {
	
	
	@Test
	public void TestGetCodigo() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		assertEquals("15",admin.getCodigo());
	}
	
	@Test
	public void TestGetNombre() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		assertEquals("Jose",admin.getNombre());
	}
	
	@Test
	public void TestGetContraseña() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		assertEquals("contraseña",admin.getContraseña());
	}
	
	@Test
	public void TestSetCodigo() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		admin.setCodigo("16");
		assertEquals("16",admin.getCodigo());
	}
	
	@Test
	public void TestSetNombre() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		admin.setNombre("Carlos");
		assertEquals("Carlos",admin.getNombre());
	}
	
	@Test
	public void TestSetContraseña() {
		Administrador admin = new Administrador("15","Jose","contraseña");
		admin.setContraseña("nuevacontraseña");
		assertEquals("16",admin.getContraseña());
	}


}
