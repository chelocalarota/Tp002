package Modelo.Algomon;

import java.util.Hashtable;

import Modelo.Tipo;

public class Algomon {
	protected Tipo tipo;
	protected int vida;
	protected Hashtable<String,Modelo.Ataques.Ataque> ataques;
	
	public Modelo.Ataques.Ataque ataque(String nombreAtaque){
		return ataques.get(nombreAtaque);
	}
	
	public int getVida(){
		return vida;
	}
	
	public void cambiarVida(int cantidad){
		vida = vida + cantidad;
	} 
	
	public Tipo getTipo(){
		return tipo;
	}
	
}
