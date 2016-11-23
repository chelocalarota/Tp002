package modelo.ataques;

import modelo.tipos.TipoAgua;

public class Burbuja extends Ataque {
	
	public Burbuja(){
		this.setPotencia(10);
		this.setCantidad(15);
		this.setTipo(new TipoAgua());
		this.nombre = "Burbuja";
	}
}
