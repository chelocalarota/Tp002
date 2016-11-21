package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.*;

import modelo.tipos.*;

public class TiposTest {

	@Test
	public void test01VerificarTiposAlgomonesAgua() {
		Algomon unAlgomon = new Squirtle();
		
		Tipo tipoAgua = new TipoAgua();
		
		assertEquals(tipoAgua.getClass(), unAlgomon.getTipo().getClass());
	}
	
	@Test
	public void test02VerificarTiposAlgomonesFuego() {
		Algomon unAlgomon = new Charmander();
		
		Tipo tipoFuego = new TipoFuego();
		
		assertEquals(tipoFuego.getClass(), unAlgomon.getTipo().getClass());
	}
	
	@Test
	public void test03VerificarTiposAlgomonesPlanta() {
		Algomon unAlgomon = new Bulbasaur();
		
		Tipo tipoPlanta = new TipoPlanta();
		
		assertEquals(tipoPlanta.getClass(), unAlgomon.getTipo().getClass());
	}
	
	@Test
	public void test04VerificarTiposAlgomonesNormal() {
		Algomon primerAlgomon = new Chansey();
		Algomon segundoAlgomon = new Jigglypuff();
		Algomon tercerAlgomon = new Rattata();
		
		
		Tipo tipoNormal = new TipoNormal();
		
		assertEquals(tipoNormal.getClass(), primerAlgomon.getTipo().getClass());
		assertEquals(tipoNormal.getClass(), segundoAlgomon.getTipo().getClass());
		assertEquals(tipoNormal.getClass(), tercerAlgomon.getTipo().getClass());
	}
	
}
