package Modelo.Ataques;

import Modelo.TipoFuego;
import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstadoQuemado;

public class Brasas extends Ataque {
	public Brasas(){
		this.setPotencia(16);
		this.setCantidad(10);
		this.setTipo(new TipoFuego());
	}
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoPersistente(new EstadoQuemado());
	
	}

}
