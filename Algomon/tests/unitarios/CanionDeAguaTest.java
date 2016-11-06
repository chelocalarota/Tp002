package unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Ataques.CanionDeAgua;

public class CanionDeAguaTest {

	@Test
	public void test01CanionDeAguaPotenciaOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertEquals(20, ataque.getPotencia());
	}
	
	@Test
	public void test02CanionDeAguaCantidadOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertEquals(8, ataque.getCantidad());
	}
	
	@Test
	public void test03CañonDeAguaTipoOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertEquals("A", ataque.getTipo());
	}
}
