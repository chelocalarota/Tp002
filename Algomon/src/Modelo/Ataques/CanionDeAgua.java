package Modelo.Ataques;

import Modelo.TipoAgua;

public class CanionDeAgua extends Ataque{
	public CanionDeAgua(){
		this.setPotencia(20);
		this.setCantidad(8);
		this.setTipo(new TipoAgua());
	}
}
