package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ataques.Burbuja;
import modelo.tipos.TipoAgua;

public class BurbujaTest {

	@Test
	public void test01BurbujaPotenciaOk() {
		Burbuja ataque = new Burbuja();
		
		assertEquals(10, ataque.getPotencia(),0.001D);
	}
	
	@Test
	public void test02BurbujaCantidadOk() {
		Burbuja ataque = new Burbuja();
		
		assertEquals(15, ataque.getCantidad());
	}
	
	@Test
	public void test03BurbujaTipoOk() {
		Burbuja ataque = new Burbuja();
		
		assertTrue(ataque.getTipo() instanceof TipoAgua);
	}

}
