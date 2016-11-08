package Modelo.Ataques;

import Modelo.TipoPlanta;

public class Chupavidas extends Ataque {
	public Chupavidas(){
		this.setPotencia(15);
		this.setCantidad(8);
		this.setTipo(new TipoPlanta());
	}
}
