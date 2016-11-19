package modelo.items;

import java.util.ArrayList;

import modelo.algomon.Algomon;
import modelo.ataques.Ataque;

public class Vitamina implements Item {
	int usosDisponibles = 5;
	
	@Override
	public boolean sinUsosDisponibles() {
		return this.usosDisponibles == 0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		ArrayList<Ataque> listaDeAtaques = algomon.obtenerTodosLosAtaques();
		for (int i = 0; i < listaDeAtaques.size(); i++) {
			listaDeAtaques.get(i).agregarPuntosDePoder(2);
		}
		this.usosDisponibles-=1;
	}

	@Override
	public int cantidadDeUsos() {
		return this.usosDisponibles;
	}
}
