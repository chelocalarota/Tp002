package Modelo.Algomon;

import java.util.ArrayList;

import java.util.Map;

import Modelo.Item;
import Modelo.Tipo;
import Modelo.Ataques.Ataque;

public class Algomon {
	protected Tipo tipo;
	protected double vida;
	protected double vidaOriginal;
	protected Map<String, Ataque> ataques;
	protected Estado estadoEfimero;
	protected Estado estadoPersistente;
	
	public Ataque ataque(String nombreAtaque) throws SinPuntosDePoderException, EstaDormidoException{
		
		estadoPersistente.accion(this);
		
		if(this.estadoEfimero.accion(this)){
			throw new EstaDormidoException("");
		}
		Ataque ataque = ataques.get(nombreAtaque);
		if (ataque.getPuntosDePoder()==0){
			throw new SinPuntosDePoderException("");
		}
		ataque.restarPuntoDePoder();
		return ataque;
	}
	
	public int getVidaOriginal(){
		return (int)vidaOriginal;
	}
	
	public boolean estaEnEstadoNormal(){
		return (estadoEfimero.esEstadoNormal() && estadoPersistente.esEstadoNormal());
	}
	
	public void cambiarEstadoEfimero(Estado estadoNuevo) {
		this.estadoEfimero = estadoNuevo;
	}
	
	public void cambiarEstadoPersistente(Estado estadoNuevo) {
		this.estadoPersistente = estadoNuevo;
	}
	
	public int getVida(){
		return (int) vida;
	}

	public void cambiarVida(int cantidad){
		vida = vida + cantidad;
	} 
	
	public Tipo getTipo(){
		return tipo;
	}
	
	public double recibirDanio(Ataque unAtaque, Algomon unAlgomonAtacante){
		
		Tipo tipoAtacante = unAtaque.getTipo();
		
		double multiplicador =  this.tipo.reaccionATipo(tipoAtacante);
		double danioResultante = unAtaque.getPotencia()*multiplicador;
		
		this.vida = this.vida-(int)danioResultante;
		
		unAtaque.cambioDeEstado(this);
		unAtaque.consecuenciaPropiaDeAtaque(unAlgomonAtacante,(int)danioResultante);
		
		return this.vida;
	}

	public boolean estaMuerto() {
		return (this.vida == 0.0);
	}

	public void usarItem(Item unItem) {
		unItem.aplicarEfecto(this);
	}
	public ArrayList<Ataque> ObtenerTodosLosAtaques(){
		ArrayList<Ataque> listaDeAtaques = new ArrayList<Ataque>();
		listaDeAtaques.addAll(this.ataques.values());
		return listaDeAtaques;
	}
	
	
}
