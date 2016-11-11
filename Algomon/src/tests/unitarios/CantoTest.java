package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Tipos.TipoNormal;
import Modelo.Ataques.Canto;

public class CantoTest {

	@Test
	public void test01CantoPotenciaOk() {
		Canto ataque = new Canto();
		
		assertEquals(0, ataque.getPotencia(), 0.001D);
	}
	
	@Test
	public void test02CantoCantidadOk() {
		Canto ataque = new Canto();
		
		assertEquals(6, ataque.getCantidad());
	}
	
	@Test
	public void test03CantoTipoOk() {
		Canto ataque = new Canto();
		
		assertTrue(ataque.getTipo() instanceof TipoNormal);
	}

}
