package Modelo;

import Modelo.Algomon.Algomon;

public class SuperPocion implements Item {
	int cantidadDeUsos;
	@Override
	public boolean sinUsosDisponibles() {
		return this.cantidadDeUsos==0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		algomon.cambiarVida(40);
	}

}
