package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.Algomon;
import modelo.algomon.Charmander;
import modelo.estados.EstadoDormido;
import modelo.estados.EstadoNormal;
import modelo.estados.EstadoQuemado;

public class EstadosAlgomonTest {

	@Test
	public void test01AlgomonVerificarEstadoNormal() {
		Algomon unAlgomon = new Charmander();
		
		assertTrue(unAlgomon.estaEnEstadoNormal());
	}
	
	@Test 
	public void test02AlgomonVerificarNoNormalConEstadoQuemado(){
		Algomon unAlgomon = new Charmander();
		
		EstadoQuemado estadoQuemado = new EstadoQuemado();
		
		unAlgomon.cambiarEstadoPersistente(estadoQuemado);
		
		assertFalse(unAlgomon.estaEnEstadoNormal());
		
	}
	
	@Test
	public void test03AlgomonVerificarNoNormalConEstadoDormido(){
		Algomon unAlgomon = new Charmander();
		
		EstadoDormido estadoDormido = new EstadoDormido();
		
		unAlgomon.cambiarEstadoEfimero(estadoDormido);
		
		assertFalse(unAlgomon.estaEnEstadoNormal());
		
	}
	
	@Test
	public void test04AlgomonVerificarNoNormalConEstadosDormidoYQuemado(){
		Algomon unAlgomon = new Charmander();
		
		EstadoDormido estadoDormido = new EstadoDormido();
		EstadoQuemado estadoQuemado = new EstadoQuemado();
		
		unAlgomon.cambiarEstadoEfimero(estadoDormido);
		unAlgomon.cambiarEstadoPersistente(estadoQuemado);
		
		assertFalse(unAlgomon.estaEnEstadoNormal());
	}
	@Test
	public void test05AlgomonVerificarEstadoPersitente(){
		Algomon unAlgomon = new Charmander();
		
		EstadoQuemado estadoQuemado = new EstadoQuemado();
		
		unAlgomon.cambiarEstadoPersistente(estadoQuemado);
		
		assertEquals(estadoQuemado.asString(), unAlgomon.getEstadoPersistenteComoString());
	}
	@Test
	public void test06AlgomonVerificarNormal(){
		Algomon unAlgomon = new Charmander();
		
		EstadoNormal estadoNormal = new EstadoNormal();
		
		assertEquals(estadoNormal.asString(), unAlgomon.getEstadoEfimeroComoString());
		assertEquals(estadoNormal.asString(), unAlgomon.getEstadoPersistenteComoString());
	}
	@Test
	public void test07AlgomonVerificarEfimero(){
		Algomon unAlgomon = new Charmander();
		
		EstadoDormido estadoDormido = new EstadoDormido();
		
		unAlgomon.cambiarEstadoEfimero(estadoDormido);
		
		assertEquals(estadoDormido.asString(), unAlgomon.getEstadoEfimeroComoString());
		
	}
}
