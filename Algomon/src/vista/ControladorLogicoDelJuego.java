package vista;

import modelo.Juego;

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


	public boolean verificarCantidadAlgomonDeJugadorActual() {
		if(juego.obtenerJugadorActual().obtenerAlgomon().size()==2){
			return true;
		}
		return false;
	}

	public void cambiarJugador() {
		this.juego.cambiarJugador();
	}

}
