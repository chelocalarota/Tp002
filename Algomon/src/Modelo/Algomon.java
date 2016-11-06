package Modelo;

import java.util.Map;

import Modelo.Ataques.Ataque;

public class Algomon {
	private Tipo tipo;
	private int vida;
	private Map<String, Ataque> ataques;
	
	public Ataque ataque(String nombreAtaque){
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
