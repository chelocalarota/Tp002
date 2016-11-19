package modelo.ataques;

import modelo.enums.AtaquesEnum;
import modelo.tipos.TipoAgua;

public class CanionDeAgua extends Ataque{
	
	public CanionDeAgua(){
		this.setPotencia(20);
		this.setCantidad(8);
		this.setTipo(new TipoAgua());
		this.nombre = "CANION DE AGUA";
	}
}
