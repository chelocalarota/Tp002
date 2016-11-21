package vista;

import modelo.Juego;
import modelo.Jugador;
import modelo.VictoriaObtenidaException;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

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
		if(juego.obtenerJugadorActual().obtenerAlgomon().size()==3){
			return true;
		}
		return false;
	}

	public void pasarTurno() {
		this.juego.pasarTurno();
	}

	public Jugador obtenerJugadorActual() {
		return this.juego.obtenerJugadorActual();
	}

	public Jugador obtenerJugadorDefensor(){
		return this.juego.obtenerJugadorDefensor();
	}

	public void atacar(AtaquesEnum ataquesEnum) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException {
		this.juego.resolverAtaqueYPasarDeTurno(ataquesEnum);
	}
	public void usarItem(ItemsEnum vitamina) throws SinUsosDisponiblesException {
		this.obtenerJugadorActual().usarItem(vitamina);
	}

	public void cambiarAlgomon(int indice) throws PokemonMuertoException {
		this.juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(indice);
	}
}
