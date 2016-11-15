package modelo.ataques;

import modelo.tipos.TipoNormal;

public class AtaqueRapido extends Ataque {
	
	public AtaqueRapido(){
		this.setPotencia(10.0);
		this.setCantidad(16);
		this.setTipo(new TipoNormal());
	}
}
