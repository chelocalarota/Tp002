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
		this.diccionarioEnums = new HashMap<String, AtaquesEnum>();
		diccionarioEnums.put("Ataque Rapido", AtaquesEnum.ATAQUE_RAPIDO);
		diccionarioEnums.put("Brasas", AtaquesEnum.BRASAS);
		diccionarioEnums.put("Burbuja", AtaquesEnum.BURBUJA);
		diccionarioEnums.put("Canion de Agua", AtaquesEnum.CANION_DE_AGUA);
		diccionarioEnums.put("Canto", AtaquesEnum.CANTO);
		diccionarioEnums.put("ChupaVidas", AtaquesEnum.CHUPAVIDAS);
		diccionarioEnums.put("Fogonazo", AtaquesEnum.FOGONAZO);
		diccionarioEnums.put("LatigoCepa", AtaquesEnum.LATIGO_CEPA);
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

	public void resolverAtaqueYPasarDeTurno(Ataque ataque) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException, VictoriaObtenidaException {
		
		Algomon algomonAtacante = this.obtenerJugadorActual().getPokemonActivo();
		Jugador jugadorDefensor = this.obtenerJugadorDefensor();
		ataque = algomonAtacante.ataque(this.diccionarioEnums.get(ataque.getNombre()));
		Algomon algomonDefensor =jugadorDefensor.getPokemonActivo();
		algomonDefensor.recibirDanio(ataque,algomonAtacante);
		verificarVictoriaDeJugadorActual();
		if (algomonDefensor.getVida()<0){
			throw new PokemonMuertoException("");
		}
		this.cambiarJugador();
	}
	
	public void usarItemParaJugadorActualYPasarDeTurno(ItemsEnum unItem) throws SinUsosDisponiblesException{
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

	public void pasarTurno() {
		this.cambiarJugador();
	}
}
