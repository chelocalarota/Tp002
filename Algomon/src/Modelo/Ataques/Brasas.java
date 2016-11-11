package Modelo.Ataques;

import Modelo.Tipos.TipoFuego;
import Modelo.Algomon.Algomon;
import Modelo.Estados.EstadoQuemado;

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
