package Modelo;

import java.util.ArrayList;
import java.util.List;

import Modelo.Ataques.Ataque;

public class Juego {
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActivo;
	private List<Ataque> listaDeAtaquesJugador1;
	private List<Ataque> listaDeAtaquesJugador2;
	//Con esto se haran en su momento los botones
	
	public Juego(Jugador jugador1, Jugador jugador2) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.jugadorActivo = jugador1;
	}
	
}
