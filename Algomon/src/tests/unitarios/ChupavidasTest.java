package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.ataques.Chupavidas;
import modelo.tipos.TipoPlanta;

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
