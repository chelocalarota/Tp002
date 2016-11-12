package Modelo.Items;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.SinUsosDisponiblesException;

public interface Item {
	boolean sinUsosDisponibles();
	void aplicarEfecto(Algomon algomon) throws SinUsosDisponiblesException;
}
