package modelo.items;

import modelo.algomon.Algomon;

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
		if (algomon.getVida() != algomon.getVidaOriginal()){
			algomon.cambiarVida(40);
		}
	}

}
