package Utilidades;

import static org.junit.Assert.*;

import org.junit.Test;

import clases.Pedidos;

public class PedidosTest {
	
	@Test
	public void TestGetUsuario() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("Maria",ped.getUsuario());
	}
	
	@Test
	public void TestGetCodigo() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("1",ped.getCodigo());
	}
	
	@Test
	public void TestGetNombre() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("Spezial",ped.getNombre());
	}
	
	@Test
	public void TestGetTipo() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("deportiva",ped.getTipo());
	}
	
	@Test
	public void TestGetCantidad() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("1",ped.getCantidad());
	}
	
	@Test
	public void TestGetPrecio() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("40",ped.getPrecio());
	}
	
	@Test
	public void TestGetColor() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("rojo",ped.getColor());
	}
	
	@Test
	public void TestGetTalla() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("39",ped.getTalla());
	}
	
	@Test
	public void TestGetGenero() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		assertEquals("mujer",ped.getGenero());
	}
	
	@Test
	public void TestSetUsuario() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setUsuario("Carlos");
		assertEquals("Carlos",ped.getUsuario());
	}
	
	@Test
	public void TestSetCodigo() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setCodigo("2");
		assertEquals("2",ped.getCodigo());
	}
	
	@Test
	public void TestSetNombre() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setNombre("busenitz");
		assertEquals("busenitz",ped.getNombre());
	}
	
	@Test
	public void TestSetTipo() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setTipo("elegante");
		assertEquals("elegante",ped.getTipo());
	}
	
	@Test
	public void TestSetCantidad() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setCantidad("4");
		assertEquals("4",ped.getCantidad());
	}
	
	@Test
	public void TestSetPrecio() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setPrecio("80");
		assertEquals("80",ped.getPrecio());
		
	}
	
	@Test
	public void TestSetColor() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setColor("azul");
		assertEquals("azul",ped.getColor());
	
	}
	
	@Test
	public void TestSetTalla() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setTalla("40");
		assertEquals("40",ped.getTalla());
	}
	
	@Test
	public void TestSetGenero() {
		Pedidos ped = new Pedidos("Maria","1","Spezial","deportiva","1","40","rojo","39","mujer");
		ped.setGenero("hombre");
		assertEquals("hombre",ped.getGenero());
	}
	
	

}
