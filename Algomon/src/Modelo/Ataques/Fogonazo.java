package Modelo.Ataques;

import Modelo.TipoFuego;
import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstadoQuemado;

public class Fogonazo extends Ataque {
	public Fogonazo(){
		this.setPotencia(2);
		this.setCantidad(4);
		this.setTipo(new TipoFuego());
	}
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoPersistente(new EstadoQuemado());
	}
}
