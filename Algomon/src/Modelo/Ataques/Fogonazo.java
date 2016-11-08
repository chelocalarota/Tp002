package Modelo.Ataques;

import Modelo.TipoFuego;

public class Fogonazo extends Ataque {
	public Fogonazo(){
		this.setPotencia(2);
		this.setCantidad(4);
		this.setTipo(new TipoFuego());
	}

}
