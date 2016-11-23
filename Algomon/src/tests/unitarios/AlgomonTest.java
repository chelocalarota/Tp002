package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.Algomon;
import modelo.algomon.Charmander;
import modelo.algomon.PokemonMuertoException;

public class AlgomonTest {

	@Test 
	public void test01CambiarVidaOriginalAlgomonConValorNeutro() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = 0;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal - valorDelCambio, unAlgomon.getVida());
		
	}
	@Test
	public void test02CambiarVidaOriginalAlgomonConValorPositivo() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = 2;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal, unAlgomon.getVida());
		
	}
	@Test
	public void test03CambiarVidaOriginalAlgomonConValorNegativ() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int valorDelCambio = -3;
		
		unAlgomon.cambiarVida(valorDelCambio);
		
		assertEquals(vidaOriginal + valorDelCambio, unAlgomon.getVida());
		
	}
	@Test
	public void test04CambiarVidaOriginalAlgomonConValorNegativ() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();
		
		int vidaOriginal = unAlgomon.getVida();
		
		int primerValorDelCambio = -3;
		int segundoValorDelCambio = 2;
		
		unAlgomon.cambiarVida(primerValorDelCambio);
		unAlgomon.cambiarVida(segundoValorDelCambio);
	
		assertEquals(vidaOriginal + primerValorDelCambio + segundoValorDelCambio, unAlgomon.getVida());
	}
	
	@Test
	public void test05VerificarSiEstaMuerto() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();
		
		assertFalse(unAlgomon.estaMuerto());
		
		try {
			unAlgomon.cambiarVida(-vidaOriginal);	
		} catch (PokemonMuertoException e) {
			assertTrue(unAlgomon.estaMuerto());
		}
		
		try {  //la vida es un numero negativo como vida
			unAlgomon.cambiarVida(-vidaOriginal);	
		} catch (PokemonMuertoException e) {
			assertTrue(unAlgomon.estaMuerto());
		}
		
	}
}
