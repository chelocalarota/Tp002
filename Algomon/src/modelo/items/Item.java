package modelo.items;

import modelo.algomon.Algomon;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinUsosDisponiblesException;

public interface Item {
	boolean sinUsosDisponibles();
	void aplicarEfecto(Algomon algomon) throws SinUsosDisponiblesException, PokemonMuertoException;
	int cantidadDeUsos();
}
