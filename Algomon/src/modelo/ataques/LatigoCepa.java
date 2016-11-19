package modelo.ataques;

import modelo.enums.AtaquesEnum;
import modelo.tipos.TipoPlanta;

public class LatigoCepa extends Ataque {
	
	public LatigoCepa(){
		this.setPotencia(15);
		this.setCantidad(10);
		this.setTipo(new TipoPlanta());
		this.nombre = "LatigoCepa";
	}
}
