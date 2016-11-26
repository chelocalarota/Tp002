package vista;

import java.util.ArrayList;
import java.util.LinkedList;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import modelo.Juego;
import modelo.Jugador;
import modelo.VictoriaObtenidaException;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

public class ControladorLogicoDelJuego {

	Juego juego;
	CreadorImagen creadorImagen;
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;

	public void crearJuegoNuevo() throws NoSuchMethodException, SecurityException {
		this.juego = new Juego();
		this.creadorImagen  = new CreadorImagen();

		this.miniaturasJugadorInicial = new LinkedList<ImageView>();
		this.imagenesJugadorInicial= new LinkedList<ImageView>();
		this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
		this.imagenesJugadorSegundo = new LinkedList<ImageView>();

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

	public void limpiarEleccionDeAlgomones(){
		this.juego.obtenerJugadorActual().eliminarAlgomonesElegidos();
		this.juego.obtenerJugadorActual().eliminarAlgomonActivo();
		if(this.miniaturasJugadorInicial.size()==3){
			this.imagenesJugadorSegundo = new LinkedList<ImageView>();
			this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
		}
		else{
			this.imagenesJugadorInicial = new LinkedList<ImageView>();
			this.miniaturasJugadorInicial = new LinkedList<ImageView>();
		}

	}

	public boolean cantidadAlgomonesDeJugadorActualEsTres() {
		if(this.juego.obtenerJugadorActual().obtenerAlgomon().size() == 3){
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

	public void agregarMiniatura(String algomon){

		if(this.miniaturasJugadorInicial.size()<3){
			this.imagenesJugadorInicial.add(this.creadorImagen.crearImagenParaBatalla("Jugador1", algomon));
			this.miniaturasJugadorInicial.add(this.creadorImagen.crearMiniaturas(algomon));
		}
		else{
			this.imagenesJugadorSegundo.add(this.creadorImagen.crearImagenParaBatalla("Jugador2", algomon));
			this.miniaturasJugadorSegundo.add(this.creadorImagen.crearMiniaturas(algomon));
		}

	}

	public LinkedList<ImageView> getMiniaturaDeJugadorActual(){
		if(this.miniaturasJugadorInicial.size()==3){
			return this.miniaturasJugadorSegundo;
		}
		return this.miniaturasJugadorInicial;
	}

	public LinkedList<ImageView> getMiniaturasJugadorInicial(){
		return this.miniaturasJugadorInicial;
	}

	public LinkedList<ImageView> getMiniaturasJugadorSegundo(){
		return this.miniaturasJugadorSegundo;
	}

	public LinkedList<ImageView> getImagenesJugadorInicial(){
		return this.imagenesJugadorInicial;
	}

	public LinkedList<ImageView> getImagenesJugadorSegundo(){
		return this.imagenesJugadorSegundo;
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
