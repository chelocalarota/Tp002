package Tests.tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.CañonDeAgua;

public class CañonDeAguaTest {

	@Test
	public void test01CañonDeAguaPotenciaOk() {
		CañonDeAgua ataque = new CañonDeAgua();
		
		assertEquals(20, ataque.getPotencia());
	}
	
	@Test
	public void test02CañonDeAguaCantidadOk() {
		CañonDeAgua ataque = new CañonDeAgua();
		
		assertEquals(8, ataque.getCantidad());
	}
	
	@Test
	public void test03CañonDeAguaTipoOk() {
		CañonDeAgua ataque = new CañonDeAgua();
		
		assertEquals("A", ataque.getTipo());
	}
}
