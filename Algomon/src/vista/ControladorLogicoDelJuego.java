package vista;

import modelo.Juego;
import modelo.Jugador;
import modelo.VictoriaObtenidaException;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;


public class ControladorLogicoDelJuego {

	Juego juego;
	
	public void crearJuegoNuevo() {
		this.juego = new Juego();
	}

	public void setNombreJugadorActual(String nombre) {
		this.juego.setNombreJugadorActual(nombre);
	}

	public void agregarCharmanderJugadorActual() {
		this.juego.agregarCharmander();
	}
	public void agregarChanseyJugadorActual() {
		this.juego.agregarChansey();
	}
	public void agregarBulbasaurJugadorActual() {
		this.juego.agregarBulbasaur();
	}
	public void agregarSquirtleJugadorActual(){
		this.juego.agregarSquirtle();
	}
	public void agregarRattataJugadorActual(){
		this.juego.agregarRattata();
	}
	public void agregarJigglypuffJugadorActual(){
		this.juego.agregarJigglypuff();
	}


	public boolean verificarCantidadAlgomonDeJugadorActual() {
		if(juego.obtenerJugadorActual().obtenerAlgomon().size()==2){
			return true;
		}
		return false;
	}

	public void cambiarJugador() {
		this.juego.cambiarJugador();
	}

	public Jugador obtenerJugadorActual() {
		return this.juego.obtenerJugadorActual();
	}

	public Jugador obtenerJugadorDefensor(){
		return this.juego.obtenerJugadorDefensor();
	}

	public void atacar(AtaquesEnum ataque) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException {
		this.juego.JugarTurnoAtaque(ataque);
	}
}
