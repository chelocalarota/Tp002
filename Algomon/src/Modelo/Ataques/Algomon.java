package Modelo;

import java.util.Hashtable;

public class Algomon {
	protected Tipo tipo;
	protected int vida;
	protected Hashtable<String,Modelo.Ataque> ataques;
	
	public Modelo.Ataque ataque(String nombreAtaque){
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
