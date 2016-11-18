package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.*;
import modelo.enums.AtaquesEnum;

public class JuegoTest {

	@Test
	public void AtaqueBasico() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.elegirPokemonInicial(0);
		juego.cambiarJugador();
		juego.agregarSquirtle();
		juego.elegirPokemonInicial(0);
		juego.JugarTurnoAtaque(AtaquesEnum.BURBUJA);
		assertEquals(juego.obtenerJugadorDefensor().getPokemonActivo().getVida(),150);
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
				juego.JugarTurnoAtaque(AtaquesEnum.BURBUJA);
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
