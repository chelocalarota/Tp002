package tests.unitarios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import Modelo.Tipos.TipoPlanta;
import Modelo.Ataques.LatigoCepa;

public class LatigoCepaTest {
	
	@Test
	public void test01LatigoCepaPotenciaOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertEquals(15, ataque.getPotencia(), 0.001D);
	}
	
	@Test
	public void test02LatigoCepaCantidadOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertEquals(10, ataque.getCantidad());
	}
	
	@Test
	public void test03LatigoCepaTipoOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertTrue(ataque.getTipo() instanceof TipoPlanta);
	}


}
