package Tests.tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Ataques.Burbuja;

public class BurbujaTest {

	@Test
	public void test01BurbujaPotenciaOk() {
		Burbuja ataque = new Burbuja();
		
		assertEquals(10, ataque.getPotencia());
	}
	
	@Test
	public void test02BurbujaCantidadOk() {
		Burbuja ataque = new Burbuja();
		
		assertEquals(15, ataque.getCantidad());
	}
	
	@Test
	public void test03BurbujaTipoOk() {
		Burbuja ataque = new Burbuja();
		
		assertEquals("A", ataque.getTipo());
	}

}
