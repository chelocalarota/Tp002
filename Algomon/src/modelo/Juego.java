package modelo;




import java.util.HashMap;

import modelo.algomon.*;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Cola colaAtacante;
	private Cola colaDefensor;
	private HashMap<String, AtaquesEnum>diccionarioEnums;
	
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

	public void setNombreJugadorActual(String nombre){
		this.obtenerJugadorActual().setNombre(nombre);
	}
	public Jugador obtenerJugadorActual() {
		// cuando comienza el juego, el jugador Actual sera el 1
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

	public void resolverAtaqueYPasarDeTurno(AtaquesEnum ataquesEnum) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException {
		
		Algomon algomonAtacante = this.obtenerJugadorActual().getPokemonActivo();
		Jugador jugadorDefensor = this.obtenerJugadorDefensor();
		Ataque unAtaque = algomonAtacante.ataque(ataquesEnum);
		Algomon algomonDefensor =jugadorDefensor.getPokemonActivo();
		algomonDefensor.recibirDanio(unAtaque,algomonAtacante);
		verificarVictoriaDeJugadorActual();
		this.cambiarJugador();
		
	}
	
	public void usarItemParaJugadorActualYPasarDeTurno(ItemsEnum unItem) throws SinUsosDisponiblesException, PokemonMuertoException{
		this.obtenerJugadorActual().usarItem(unItem);
		this.pasarTurno();
	}
	
	public void cambiarAlgomonParaJugadorActualYPasarDeTurno(int indiceAlgomon) throws PokemonMuertoException{
		this.cambiarPokemonDeJugadorActual(indiceAlgomon);
		this.pasarTurno();
	}

	public void verificarVictoriaDeJugadorActual() throws VictoriaObtenidaException {
		Jugador jugadorDefensor = this.obtenerJugadorDefensor();
		if (this.obtenerJugadorActual().verificarVictoriaContraOtroJugador(jugadorDefensor)){
			throw new VictoriaObtenidaException("");
		}
	}

	public Jugador obtenerJugadorDefensor() {
		return this.colaDefensor.verPrimero();
		
	}

	public void cambiarPokemonDeJugadorActual(int indice) throws PokemonMuertoException {
		this.obtenerJugadorActual().elegirAlgomonEnBatalla(indice);
	}
	
	public void elegirPokemonInicialDeJugadorActual() throws PokemonMuertoException{
		this.cambiarPokemonDeJugadorActual(0);
	}

	public void verificarAlgomonDefensorMuerto() throws PokemonMuertoException{
		Algomon algomonAtacante = this.obtenerJugadorActual().getPokemonActivo();
		if (algomonAtacante.estaMuerto()){
			throw new PokemonMuertoException("");
		}
	}
	
	public void pasarTurno() {
		this.cambiarJugador();
		
	}
}
