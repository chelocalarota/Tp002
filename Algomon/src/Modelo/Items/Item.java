package Modelo.Items;

import Modelo.Algomon.Algomon;

public interface Item {
	boolean sinUsosDisponibles();
	void aplicarEfecto(Algomon algomon);
}
