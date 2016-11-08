package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Ataques.Brasas;

public class BrasasTest {

	@Test
	public void test01BrasasPotenciaOk() {
		Brasas ataque = new Brasas();
		
		assertEquals(16, ataque.getPotencia(),0.001D);
	}
	
	@Test
	public void test02BrasasCantidadOk() {
		Brasas ataque = new Brasas();
		
		assertEquals(10, ataque.getCantidad());
	}
	
	@Test
	public void test03BrasasTipoOk() {
		Brasas ataque = new Brasas();
		
		assertEquals("F", ataque.getTipo());
	}

}
