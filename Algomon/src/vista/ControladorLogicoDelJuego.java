package vista;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.scene.control.Button;
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
	public void usarItem(ItemsEnum vitamina) throws SinUsosDisponiblesException, PokemonMuertoException {
		this.obtenerJugadorActual().usarItem(vitamina);
	}

	public void cambiarAlgomon(int indice) throws PokemonMuertoException {
		this.juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(indice);
	}

	public void verificarAlgomonActualMuerto() throws PokemonMuertoException {
		this.juego.verificarAlgomonDefensorMuerto();
	}

	public void bloquearBotonesPorMuerteJugadorActual(ArrayList<Button> listaDeBotonesDeJugador,
			LinkedList<Button> listaDeBotonesDeCambio, LinkedList<Button> botonesBloqueadosForEver) {
		for (Button botonABloquear: listaDeBotonesDeJugador){
			botonABloquear.setDisable(true);
		}
		Button botonACambiar = null;
		for(Button botonDeCambio : listaDeBotonesDeCambio){
			if (!listaDeBotonesDeJugador.contains(botonDeCambio)){
				botonesBloqueadosForEver.add(botonDeCambio);
				botonACambiar = botonDeCambio;
			}
			else{
				botonDeCambio.setDisable(false);
			}
		}
		listaDeBotonesDeCambio.remove(botonACambiar);
	}


}
