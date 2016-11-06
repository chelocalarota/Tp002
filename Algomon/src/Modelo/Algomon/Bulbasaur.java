package Modelo.Algomon;

import java.util.Hashtable;

import Modelo.TipoPlanta;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Chupavidas;
import Modelo.Ataques.LatigoCepa;

public class Bulbasaur extends Algomon {
	
	public Bulbasaur(){
		this.tipo = new TipoPlanta();
		this.vida = 140;
		this.ataques = new Hashtable<String,Modelo.Ataques.Ataque>();
		this.ataques.put("Chupavidas", new Chupavidas());
		this.ataques.put("Latigo cepa", new LatigoCepa());
		this.ataques.put("Ataque rapido", new AtaqueRapido());
	}

}
