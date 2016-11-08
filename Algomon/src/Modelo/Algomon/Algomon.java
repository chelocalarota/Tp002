package Modelo.Algomon;

import java.util.Map;

import Modelo.Tipo;
import Modelo.Ataques.Ataque;

public class Algomon {
	protected Tipo tipo;
	protected double vida;
	protected Map<String, Ataque> ataques;
	
	public Ataque ataque(String nombreAtaque){
		return ataques.get(nombreAtaque);
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
	
	public double recibirDanio(Ataque unAtaque, Algomon unAlgomon){
		Tipo tipoAtacante = unAlgomon.getTipo();
		double multiplicador =  this.tipo.reaccionATipo(tipoAtacante);
		double danioResultante = unAtaque.getPotencia()*multiplicador;
		this.vida = this.vida-danioResultante;
		return this.vida;
	}
	
}
