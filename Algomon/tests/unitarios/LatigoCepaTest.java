package unitarios;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Modelo.Ataques.LatigoCepa;

public class LatigoCepaTest {
	
	@Test
	public void test01LatigoCepaPotenciaOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertEquals(15, ataque.getPotencia());
	}
	
	@Test
	public void test02LatigoCepaCantidadOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertEquals(10, ataque.getCantidad());
	}
	
	@Test
	public void test03LatigoCepaTipoOk() {
		LatigoCepa ataque = new LatigoCepa();
		
		assertEquals("P", ataque.getTipo());
	}


}
