package Modelo.Ataques;

import Modelo.Tipo;
import Modelo.Algomon.Algomon;

public abstract class Ataque {
	private double potencia;
	private int cantidad;
	private Tipo tipo;
	
	public void setPotencia(double potencia){
		this.potencia = potencia;
	}
	
	public void setCantidad(int cantidad){
		this.cantidad = cantidad;
	}
	
	public void setTipo(Tipo tipo){
		
		this.tipo = tipo;
	}
	
	public double getPotencia(){
		return this.potencia;
	}
	
	public int getCantidad(){
		return this.cantidad;
	}
	
	public Tipo getTipo(){
		return this.tipo;
	}
	
	public void restarPuntoDePoder(){
		this.cantidad-=1;
	}
	
	public int getPuntosDePoder(){
		return this.cantidad;
	}
	
	public void cambioDeEstado(Algomon unAlgomon){
		return;
	}
	public void consecuenciaPropiaDeAtaque(Algomon unAlgomon){
		return;
	}
}

