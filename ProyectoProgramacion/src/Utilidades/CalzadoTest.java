package Utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Calzado;

public class CalzadoTest {
	
	@Test
	public void TestGetCodigo() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("1",c.getCodigo());
	}
	
	@Test
	public void TestGetNombre() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("Spezial",c.getNombre());
	}
	
	@Test
	public void TestGetTipo() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("deportiva",c.getTipo());
	}
	
	@Test
	public void TestGetCantidad() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("2",c.getCantidad());
	}
	
	@Test
	public void TestGetPrecio() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("40",c.getPrecio());
	}
	
	@Test
	public void TestGetColor() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("azul",c.getColor());
	}
	
	@Test
	public void TestGetTalla() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("40",c.getTalla());
	}
	
	@Test
	public void TestGetGenero() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		assertEquals("hombre",c.getGenero());
	}
	
	@Test
	public void TestSetCodigo() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setCodigo("2");
		assertEquals("2",c.getCodigo());
	}
	
	@Test
	public void TestSetNombre() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setNombre("busenitz");
		assertEquals("busenitz",c.getNombre());
	}
	
	@Test
	public void TestSetTipo() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setTipo("traje");
		assertEquals("traje",c.getTipo());
	}
	
	@Test
	public void TestSetCantidad() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setCantidad("40");
		assertEquals("40",c.getCantidad());
	}
	
	@Test
	public void TestSetPrecio() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setPrecio("80");
		assertEquals("80",c.getPrecio());
	}
	
	@Test
	public void TestSetColor() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setColor("rojo");
		assertEquals("rojo",c.getColor());
	}
	
	@Test
	public void TestSetTalla() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setTalla("46");
		assertEquals("46",c.getTalla());
	}
	
	@Test
	public void TestSetGenero() {
		Calzado c = new Calzado("1","Spezial","deportiva","2","40","azul","40","hombre");
		c.setGenero("mujer");
		assertEquals("mujer",c.getGenero());
	}
	
	

}
