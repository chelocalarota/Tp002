package Modelo.Ataques;

import Modelo.TipoAgua;

public class Burbuja extends Ataque {
	public Burbuja(){
		this.setPotencia(10);
		this.setCantidad(15);
		this.setTipo(new TipoAgua());
	}
}
