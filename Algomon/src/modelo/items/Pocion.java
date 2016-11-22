package modelo.items;

import modelo.algomon.Algomon;
import modelo.algomon.PokemonMuertoException;

public class Pocion implements Item {
	int cantidadDeUsos;
	
	public Pocion(){
		cantidadDeUsos = 4;
	}
	
	@Override
	public boolean sinUsosDisponibles() {
		return cantidadDeUsos == 0;
	}

	@Override
	public void aplicarEfecto(Algomon algomon) throws PokemonMuertoException {
		if (algomon.getVida() != algomon.getVidaOriginal()){
			algomon.cambiarVida(20);
		}
		this.cantidadDeUsos-=1;
	}

	@Override
	public int cantidadDeUsos() {
		return this.cantidadDeUsos;
	}
}
