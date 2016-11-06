package unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Ataques.Fogonazo;

public class FogonazoTest {

	@Test
	public void test01FogonazoPotenciaOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertEquals(2, ataque.getPotencia());
	}
	
	@Test
	public void test02FogonazoCantidadOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertEquals(4, ataque.getCantidad());
	}
	
	@Test
	public void test03FogonazoTipoOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertEquals("F", ataque.getTipo());
	}

}
