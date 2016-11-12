package Modelo.Ataques;

import Modelo.Tipos.TipoNormal;
import Modelo.Algomon.Algomon;
import Modelo.Estados.EstadoDormido;


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
