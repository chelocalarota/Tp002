package Modelo.Ataques;

import Modelo.TipoFuego;

public class Brasas extends Ataque {
	public Brasas(){
		this.setPotencia(16);
		this.setCantidad(10);
		this.setTipo(new TipoFuego());
	}

}
