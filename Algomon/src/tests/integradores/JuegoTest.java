package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Juego;
import modelo.Jugador;
import modelo.VictoriaObtenidaException;
import modelo.algomon.*;
import modelo.enums.AtaquesEnum;
import modelo.tipos.Tipo;

public class JuegoTest {

	@Test
	public void test01ResolverAtaqueCuandoAlgomonAtaca() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.elegirPokemonInicial(0);
		juego.cambiarJugador();
		juego.agregarSquirtle();
		juego.elegirPokemonInicial(0);
		
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
	public void unJugadorGana() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.agregarBulbasaur();
		try {
			juego.elegirPokemonInicial(0);
		} catch (PokemonMuertoException e1) {
			assertTrue(false);
		}
		juego.obtenerJugadorActual().getPokemonActivo().getVida();
		juego.cambiarJugador();
		juego.agregarSquirtle();

		assertEquals(juego.obtenerJugadorActual().obtenerAlgomon().size(),1);
		assertEquals(juego.obtenerJugadorDefensor().obtenerAlgomon().size(),2);
		try {
			juego.elegirPokemonInicial(0);
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
			juego.obtenerJugadorDefensor().elegirAlgomonActivo(1);
			//Cuando se muere un algomon, lo elimina de la lista del jugador
			assertTrue(true);
			break;
			}
		}
	}
}
