package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ataques.CanionDeAgua;
import modelo.tipos.TipoAgua;

public class CanionDeAguaTest {

	@Test
	public void test01CanionDeAguaPotenciaOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertEquals(20, ataque.getPotencia(), 0.001D);
	}
	
	@Test
	public void test02CanionDeAguaCantidadOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertEquals(8, ataque.getCantidad());
	}
	
	@Test
	public void test03CanionDeAguaTipoOk() {
		CanionDeAgua ataque = new CanionDeAgua();
		
		assertTrue(ataque.getTipo() instanceof TipoAgua);
	}
}
