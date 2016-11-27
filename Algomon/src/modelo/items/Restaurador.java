package modelo.items;

import modelo.algomon.Algomon;
import modelo.estados.EstadoNormal;

public class Restaurador implements Item {
	private int cantidadDeUsos;
	
	public Restaurador(){
		cantidadDeUsos = 3;
	}
	
	@Override
	public boolean sinUsosDisponibles() {
		return this.cantidadDeUsos == 0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) {
		algomon.cambiarEstadoEfimero(new EstadoNormal());
		algomon.cambiarEstadoPersistente(new EstadoNormal());
		this.cantidadDeUsos-=1;
	}

	@Override
	public int cantidadDeUsos() {
		return this.cantidadDeUsos;
	}
}