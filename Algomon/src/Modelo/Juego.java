package Modelo;

import java.util.ArrayList;

import Modelo.Ataques.Ataque;

public class Juego {
	Jugador jugador1;
	Jugador jugador2;
	Jugador jugadorActivo;
	ArrayList<Ataque> listaDeAtaquesJugador1;
	ArrayList<Ataque> listaDeAtaquesJugador2;
	//Con esto se haran en su momento los botones
	
	public Juego(Jugador jugador1,Jugador jugador2){
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.jugadorActivo = jugador1;
	}
	
}
