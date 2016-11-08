package Modelo.Algomon;

import java.util.Map;

import Modelo.Tipo;
import Modelo.Ataques.Ataque;

public class Algomon {
	protected Tipo tipo;
	protected double vida;
	protected Map<String, Ataque> ataques;
	protected Estado estado;
	
	public Ataque ataque(String nombreAtaque){
		Ataque ataque = ataques.get(nombreAtaque);
		if (ataque.getPuntosDePoder()==0){
			return null; //hay que utilizar una excepcion;
		}
		ataque.restarPuntoDePoder();
		return ataque;
	}
	public boolean posibilidadDeAccion(){
		return estado.getPosibilidad(this);
	}
	
	public double getVida(){
		return vida;
	}

	public void cambiarVida(int cantidad){
		vida = vida + cantidad;
	} 
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public double recibirDanio(Ataque unAtaque){
		Tipo tipoAtacante = unAtaque.getTipo();
		double multiplicador =  this.tipo.reaccionATipo(tipoAtacante);
		double danioResultante = unAtaque.getPotencia()*multiplicador;
		this.vida = this.vida-danioResultante;
		unAtaque.cambioDeEstado(this);
		return this.vida;
	}
	public void cambiarEstado(Estado estadoNuevo) {
		this.estado = estadoNuevo;
	}
	
}
