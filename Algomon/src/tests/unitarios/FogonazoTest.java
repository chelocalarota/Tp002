package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ataques.Fogonazo;
import modelo.tipos.TipoFuego;

public class FogonazoTest {

	@Test
	public void test01FogonazoPotenciaOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertEquals(2, ataque.getPotencia(), 0.001D);
	}
	
	@Test
	public void test02FogonazoCantidadOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertEquals(4, ataque.getCantidad());
	}
	
	@Test
	public void test03FogonazoTipoOk() {
		Fogonazo ataque = new Fogonazo();
		
		assertTrue(ataque.getTipo() instanceof TipoFuego);
	}

}
