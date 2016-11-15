package modelo;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.algomon.*;
import modelo.enums.AtaquesEnum;

public class JuegoTest {

	@Test
	public void JuegoBasico() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Juego juego = new Juego();
		juego.agregarCharmander();
		juego.elegirPokemonInicial(0);
		juego.obtenerJugadorActual().getPokemonActivo().getVida();
		juego.cambiarJugador();
		juego.agregarSquirtle();
		juego.elegirPokemonInicial(0);
		juego.obtenerJugadorActual().getPokemonActivo().getVida();
		juego.JugarTurnoAtaque(AtaquesEnum.BURBUJA);
		
		
		assertEquals(juego.obtenerJugadorDefensor().getPokemonActivo().getVida(),150);
	}
}
