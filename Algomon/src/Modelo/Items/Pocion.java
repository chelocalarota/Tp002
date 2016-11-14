package Modelo.Items;

import Modelo.Algomon.Algomon;

public class Pocion implements Item {
	int cantidadDeUsos;
	public Pocion(){
		cantidadDeUsos = 4;
	}
	@Override
	public boolean sinUsosDisponibles() {
		return cantidadDeUsos ==0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		if (algomon.getVida() != algomon.getVidaOriginal()){
			algomon.cambiarVida(20);
		}
	}

}
