package modelo.ataques;

import modelo.algomon.Algomon;

import modelo.estados.EstadoDormido;
import modelo.tipos.TipoNormal;


public class Canto extends Ataque {
	
	public Canto(){
		this.setPotencia(0);
		this.setCantidad(6);
		this.setTipo(new TipoNormal());
		this.nombre = "Canto";
	}
	
	public void cambioDeEstado(Algomon unAlgomon){
		unAlgomon.cambiarEstadoEfimero(new EstadoDormido());
	}
}
