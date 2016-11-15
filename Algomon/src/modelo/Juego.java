package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.algomon.*;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private List<Ataque> listaDeAtaquesJugador1;
	private List<Ataque> listaDeAtaquesJugador2;
	private Cola colaAtacante;
	private Cola colaDefensor;
	
	public Juego() {
		this.jugador1 = new Jugador();
		this.jugador2 = new Jugador();
		this.colaAtacante = new Cola();
		this.colaAtacante.encolar(jugador1);
		this.colaAtacante.encolar(jugador2);	
		this.colaDefensor = new Cola();
		this.colaDefensor.encolar(jugador2);
		this.colaDefensor.encolar(jugador1);
	}

	public Jugador obtenerJugadorActual() {
		return this.colaAtacante.verPrimero();
	}

	public void cambiarJugador() {
		this.colaAtacante.avanzarTurno();
		this.colaDefensor.avanzarTurno();
	}

	public void agregarCharmander() {
		this.obtenerJugadorActual().agregarAlgomon(new Charmander());
	}
	public void agregarBulbasaur() {
		this.obtenerJugadorActual().agregarAlgomon(new Bulbasaur());
	}
	public void agregarSquirtle() {
		this.obtenerJugadorActual().agregarAlgomon(new Squirtle());
	}
	public void agregarRattata() {
		this.obtenerJugadorActual().agregarAlgomon(new Rattata());
	}
	public void agregarJigglypuff() {
		this.obtenerJugadorActual().agregarAlgomon(new Jigglypuff());
	}
	public void agregarChansey() {
		this.obtenerJugadorActual().agregarAlgomon(new Chansey());
	}

	public void JugarTurnoAtaque(AtaquesEnum ataque) throws SinPuntosDePoderException, EstaDormidoException {
		Ataque unAtaque = this.obtenerJugadorActual().elegirAtaque(ataque);
		Algomon algomonAtacante = this.obtenerJugadorActual().getPokemonActivo();
		Jugador jugadorDefensor = this.obtenerJugadorDefensor();
		Algomon algomonDefensor =jugadorDefensor.getPokemonActivo();
		algomonDefensor.recibirDanio(unAtaque,algomonAtacante);
		this.cambiarJugador();
	}

	public Jugador obtenerJugadorDefensor() {
		return this.colaDefensor.verPrimero();
		
	}

	public void elegirPokemonInicial(int i) throws PokemonMuertoException {
		this.obtenerJugadorActual().elegirAlgomonActivo(i);
	}
}
