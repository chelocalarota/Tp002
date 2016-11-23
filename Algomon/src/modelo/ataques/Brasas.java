package modelo.ataques;

import modelo.algomon.Algomon;
import modelo.estados.EstadoQuemado;
import modelo.tipos.TipoFuego;

public class Brasas extends Ataque {
	
	public Brasas(){
		this.setPotencia(16);
		this.setCantidad(10);
		this.setTipo(new TipoFuego());
		this.nombre = "Brasas";
	}
	
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoPersistente(new EstadoQuemado());
	
	}

}
