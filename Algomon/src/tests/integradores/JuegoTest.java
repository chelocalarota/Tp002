package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Juego;
import modelo.VictoriaObtenidaException;
import modelo.algomon.*;
import modelo.enums.AtaquesEnum;

public class JuegoTest {

	@Test
	public void test01ResolverAtaqueCuandoAlgomonAtaca() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.elegirPokemonInicialDeJugadorActual();
		juego.cambiarJugador();
		juego.agregarSquirtle();
		juego.elegirPokemonInicialDeJugadorActual();
		
		int vidaAlgomonDefensor = juego.obtenerJugadorDefensor().getPokemonActivo().getVida();
		int valorAtaque = (int)juego.obtenerJugadorActual().getPokemonActivo().ataque(AtaquesEnum.BURBUJA).getPotencia();
		int multiplicador = (int)juego.obtenerJugadorActual().getPokemonActivo().ataque(AtaquesEnum.BURBUJA).getTipo().respuestaAFuego();
		vidaAlgomonDefensor = vidaAlgomonDefensor - (valorAtaque * multiplicador);
		
		juego.resolverAtaque(AtaquesEnum.BURBUJA);
		assertEquals(juego.obtenerJugadorDefensor().getPokemonActivo().getVida(), vidaAlgomonDefensor);
	}
	
	@Test
	public void test02AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Bulbasaur bulbasaur = new Bulbasaur();
		juego.agregarBulbasaur();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), bulbasaur.getClass());
	}
	
	@Test
	public void test03AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Charmander charmander = new Charmander();
		juego.agregarCharmander();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), charmander.getClass());
	}
	
	@Test
	public void test04AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Chansey chansey = new Chansey();
		juego.agregarChansey();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), chansey.getClass());
	}
	
	@Test
	public void test05AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Jigglypuff jiggly = new Jigglypuff();
		juego.agregarJigglypuff();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), jiggly.getClass());
	}
	
	@Test
	public void test06AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Rattata rata = new Rattata();
		juego.agregarRattata();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), rata.getClass());
	}
	
	@Test
	public void test07AgregarAlgomonAJugador(){
		Juego juego = new Juego();
		Squirtle tortuga = new Squirtle();
		juego.agregarSquirtle();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), tortuga.getClass());
	}
	
	@Test
	public void test08VerificarJugadorActivoYCambiarJugador(){
		Juego juego = new Juego();
		Squirtle tortuga = new Squirtle();
		Rattata rata = new Rattata();
		
		juego.agregarSquirtle();
		Algomon algomon1 = juego.obtenerJugadorActual().getPokemonActivo();
		juego.cambiarJugador();
		juego.agregarRattata();
		Algomon algomon2 = juego.obtenerJugadorActual().getPokemonActivo();
		
		
		assertEquals(algomon1.getClass(), tortuga.getClass());
		assertEquals(algomon2.getClass(), rata.getClass());
		assertNotEquals(algomon1.getClass(), algomon2.getClass());
	}
	
	@Test
	public void test09VerificarVictoriaDeJugadorAtacante(){
		Juego juego = new Juego();
		juego.agregarBulbasaur();
		juego.obtenerJugadorActual().getPokemonActivo().cambiarVida(-100000);
		juego.cambiarJugador();
		
		try{
			juego.verificarVictoriaDeJugadorActual();
		}
		catch (VictoriaObtenidaException voe) {
			assertTrue(true);
		}
	}
	
	@Test
	public void test10VerificarNoVictoriaDeJugadorAtacante(){
		Juego juego = new Juego();
		juego.agregarBulbasaur();
		juego.obtenerJugadorActual().getPokemonActivo().cambiarVida(-10);
		juego.cambiarJugador();
		
		try{
			juego.verificarVictoriaDeJugadorActual();
		}
		catch (VictoriaObtenidaException voe) {
			assertTrue(false);
		}
		assertTrue(true); //No hubo excepcion de victoria
	}
	
	@Test
	public void test11ElegirPokemosActual() throws PokemonMuertoException {
		Juego juego = new Juego();
		juego.agregarBulbasaur();
		juego.agregarCharmander();
		juego.agregarRattata();
		Bulbasaur bulba = new Bulbasaur();
		juego.elegirPokemonInicialDeJugadorActual();
		Algomon algomon = juego.obtenerJugadorActual().getPokemonActivo();
		
		assertEquals(algomon.getClass(), bulba.getClass());
	}
	
	
	@Test
	public void unJugadorGana() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.agregarBulbasaur();
		try {
			juego.elegirPokemonInicialDeJugadorActual();
		} catch (PokemonMuertoException e1) {
			assertTrue(false);
		}
		juego.obtenerJugadorActual().getPokemonActivo().getVida();
		juego.cambiarJugador();
		juego.agregarSquirtle();

		assertEquals(juego.obtenerJugadorActual().obtenerAlgomon().size(),1);
		assertEquals(juego.obtenerJugadorDefensor().obtenerAlgomon().size(),2);
		try {
			juego.elegirPokemonInicialDeJugadorActual();
		} catch (PokemonMuertoException e1) {
			assertTrue(false);
		}
		while (true){

			try {
				juego.resolverAtaque(AtaquesEnum.BURBUJA);
				juego.pasarTurno();
			}
		 catch (VictoriaObtenidaException e) {
				assertTrue(false);
			}
		catch (PokemonMuertoException e) {
			juego.obtenerJugadorDefensor().elegirAlgomonEnBatalla(1);
			//Cuando se muere un algomon, lo elimina de la lista del jugador
			assertTrue(true);
			break;
			}
		}
	}
}
