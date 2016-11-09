package Modelo.Ataques;

import Modelo.TipoNormal;
import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstadoDormido;


public class Canto extends Ataque {
	public Canto(){
		this.setPotencia(0);
		this.setCantidad(6);
		this.setTipo(new TipoNormal());
	}
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoEfimero(new EstadoDormido());
	}
}
