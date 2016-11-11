package tests.unitarios;

import static org.junit.Assert.*;

import Modelo.Tipos.TipoPlanta;
import Modelo.Ataques.Chupavidas;

import org.junit.Test;

public class ChupavidasTest {

	@Test
	public void test01ChupavidasPotenciaOk() {
		Chupavidas ataque = new Chupavidas();
		
		assertEquals(15, ataque.getPotencia(), 0.001D);
	}
	
	@Test
	public void test02ChupavidasCantidadOk() {
		Chupavidas ataque = new Chupavidas();
		
		assertEquals(8, ataque.getCantidad());
	}
	
	@Test
	public void test03ChupavidasTipoOk() {
		Chupavidas ataque = new Chupavidas();
		
		assertTrue(ataque.getTipo() instanceof TipoPlanta);
	}

}
