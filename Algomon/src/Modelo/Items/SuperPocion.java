package Modelo.Items;

import Modelo.Algomon.Algomon;

public class SuperPocion implements Item {
	int cantidadDeUsos;

	public SuperPocion(){
		cantidadDeUsos=2;
	}
	@Override
	public boolean sinUsosDisponibles() {
		return this.cantidadDeUsos==0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		algomon.cambiarVida(40);
	}

}
