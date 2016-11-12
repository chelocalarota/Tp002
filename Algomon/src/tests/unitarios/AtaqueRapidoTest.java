package tests.unitarios;



import static org.junit.Assert.*;

import org.junit.Test;
import Modelo.Tipos.TipoNormal;
import Modelo.Ataques.AtaqueRapido;

public class AtaqueRapidoTest {

	
	@Test
	public void test01AtaqueRapidoPotenciaOk() {
		AtaqueRapido ataque = new AtaqueRapido();
		
		assertEquals(10.0, ataque.getPotencia(),0.001D);
	}
	
	@Test
	public void test02AtaqueRapidoCantidadOk() {
		AtaqueRapido ataque = new AtaqueRapido();
		
		assertEquals(16, ataque.getCantidad());
	}
	
	@Test
	public void test03AtaqueRapidoTipoOk() {
		AtaqueRapido ataque = new AtaqueRapido();
		
		assertTrue(ataque.getTipo() instanceof TipoNormal);
	}

}
