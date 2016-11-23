package modelo.ataques;

import modelo.algomon.Algomon;
import modelo.estados.EstadoQuemado;
import modelo.tipos.TipoFuego;

public class Fogonazo extends Ataque {
	
	public Fogonazo(){
		this.setPotencia(2);
		this.setCantidad(4);
		this.setTipo(new TipoFuego());
		this.nombre = "Fogonazo";
	}
	
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoPersistente(new EstadoQuemado());
	}
}
