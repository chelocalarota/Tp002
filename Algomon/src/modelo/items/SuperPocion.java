package modelo.items;

import modelo.algomon.Algomon;
import modelo.algomon.PokemonMuertoException;

public class SuperPocion implements Item {
	private int cantidadDeUsos;

	public SuperPocion(){
		cantidadDeUsos = 2;
	}
	
	@Override
	public boolean sinUsosDisponibles() {
		return this.cantidadDeUsos == 0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) throws PokemonMuertoException {
		if (algomon.getVida() != algomon.getVidaOriginal()){
			algomon.cambiarVida(40);
		}
		this.cantidadDeUsos-=1;
	}
	@Override
	public int cantidadDeUsos() {
		return this.cantidadDeUsos;
	}
}
