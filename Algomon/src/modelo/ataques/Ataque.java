package modelo.ataques;

import modelo.algomon.Algomon;
import modelo.algomon.SinPuntosDePoderException;
import modelo.enums.AtaquesEnum;
import modelo.tipos.Tipo;

public abstract class Ataque {
	private double potencia;
	private int cantidad;
	private Tipo tipo;
	protected String nombre;
	
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
	
	public void getPuntosDePoderEsCero()throws SinPuntosDePoderException{
		if (this.cantidad == 0){
			throw new SinPuntosDePoderException("");
		}
	}
	
	public void cambioDeEstado(Algomon unAlgomon){
		return;
	}
	
	public void consecuenciaPropiaDeAtaque(Algomon unAlgomonAtacante, int danio){
		return;
	}

	public void agregarPuntosDePoder(int cantidad) {
		this.cantidad += cantidad;
	}

	public String getNombre() {
		return this.nombre;
	}
}

