package Modelo.Ataques;

import Modelo.TipoNormal;

public class Canto extends Ataque {
	public Canto(){
		this.setPotencia(0);
		this.setCantidad(6);
		this.setTipo(new TipoNormal());
	}
	
	// Ver como manejamos el tema de los ataques especiales
}
