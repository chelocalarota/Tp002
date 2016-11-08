package Modelo.Algomon;

import java.util.HashMap;
import Modelo.TipoPlanta;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Chupavidas;
import Modelo.Ataques.LatigoCepa;

public class Bulbasaur extends Algomon {
	
	public Bulbasaur(){
		this.tipo = new TipoPlanta();
		this.vida = 140;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Chupavidas", new Chupavidas());
		this.ataques.put("Latigo Cepa", new LatigoCepa());
		this.ataques.put("Ataque rapido", new AtaqueRapido());
	}

}
