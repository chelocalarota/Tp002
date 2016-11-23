package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.*;

import modelo.tipos.*;

public class TiposTest {

	@Test
	public void test01VerificarTiposAlgomonesAgua() {
		Algomon unAlgomon = new Squirtle();
		
		assertTrue(unAlgomon.getTipo() instanceof TipoAgua);
	}
	
	@Test
	public void test02VerificarTiposAlgomonesFuego() {
		Algomon unAlgomon = new Charmander();
		
		assertTrue(unAlgomon.getTipo() instanceof TipoFuego);
	}
	
	@Test
	public void test03VerificarTiposAlgomonesPlanta() {
		Algomon unAlgomon = new Bulbasaur();
		
		assertTrue(unAlgomon.getTipo() instanceof TipoPlanta);
	}
	
	@Test
	public void test04VerificarTiposAlgomonesNormal() {
		Algomon primerAlgomon = new Chansey();
		Algomon segundoAlgomon = new Jigglypuff();
		Algomon tercerAlgomon = new Rattata();
	
		
		assertTrue(primerAlgomon.getTipo() instanceof TipoNormal);
		assertTrue(segundoAlgomon.getTipo() instanceof TipoNormal);
		assertTrue(tercerAlgomon.getTipo() instanceof TipoNormal);
	}
	
}
