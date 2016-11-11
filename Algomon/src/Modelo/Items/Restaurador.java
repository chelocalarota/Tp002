package Modelo.Items;

import Modelo.Algomon.Algomon;
import Modelo.Estados.EstadoNormal;

public class Restaurador implements Item {
	int cantidadDeUsos;
	
	public Restaurador(){
		cantidadDeUsos=3;
	}
	@Override
	public boolean sinUsosDisponibles() {
		return this.cantidadDeUsos==0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		algomon.cambiarEstadoEfimero(new EstadoNormal());
		algomon.cambiarEstadoPersistente(new EstadoNormal());
	}

}
