package Modelo;

import java.util.ArrayList;

import Modelo.Algomon.Algomon;
import Modelo.Ataques.Ataque;

public class Vitamina implements Item {
	int usosDisponibles = 5;
	@Override
	public boolean sinUsosDisponibles() {
		return this.usosDisponibles==0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		ArrayList<Ataque> listaDeAtaques = algomon.ObtenerTodosLosAtaques();
		for (int i = 0; i < listaDeAtaques.size(); i++) {
			listaDeAtaques.get(i).agregarPuntosDePoder(2);
		}
	}

}
