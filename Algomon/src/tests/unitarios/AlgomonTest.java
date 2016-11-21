package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.Algomon;
import modelo.algomon.Charmander;

public class AlgomonTest {

	@Test 
	public void test01CambiarVidaOriginalAlgomonConValorNeutro(){
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = 0;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal - valorDelCambio, unAlgomon.getVida());
		
	}
	@Test
	public void test02CambiarVidaOriginalAlgomonConValorPositivo(){
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = 2;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal, unAlgomon.getVida());
		
	}
	@Test
	public void test03CambiarVidaOriginalAlgomonConValorNegativ(){
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = -3;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal + valorDelCambio, unAlgomon.getVida());
		
	}
	@Test
	public void test04CambiarVidaOriginalAlgomonConValorNegativ(){
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int primerValorDelCambio = -3;
		int segundoValorDelCambio = 2;
		
		unAlgomon.cambiarVida(primerValorDelCambio);
		unAlgomon.cambiarVida(segundoValorDelCambio);
	
		assertEquals(vidaOriginal + primerValorDelCambio + segundoValorDelCambio, unAlgomon.getVida());
	}
	
	@Test
	public void test05VerificarSiEstaMuerto(){
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();
		
		assertFalse(unAlgomon.estaMuerto());
		
		unAlgomon.cambiarVida(-vidaOriginal);
		
		assertTrue(unAlgomon.estaMuerto());
		
		unAlgomon.cambiarVida(-vidaOriginal); //la vida es un numero negativo como vida
		
		assertTrue(unAlgomon.estaMuerto());
		
	}
}
