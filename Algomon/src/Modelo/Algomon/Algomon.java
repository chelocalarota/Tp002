package Modelo.Algomon;

import java.util.Map;

import Modelo.Tipo;
import Modelo.Ataques.Ataque;

public class Algomon {
	protected Tipo tipo;
	protected int vida;
	protected Map<String, Ataque> ataques;
	
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
	
	public int recibirDa�o(Ataque unAtaque, Algomon unAlgomon){
		Tipo tipoAtacante = unAlgomon.getTipo();
		int multiplicador = (int) this.tipo.reaccionATipo(tipoAtacante);
		int da�oResultante = unAtaque.getPotencia()*multiplicador;
		this.vida = this.vida-da�oResultante;
		return this.vida;
	}
	
}
