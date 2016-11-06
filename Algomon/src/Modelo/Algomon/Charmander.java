package Modelo.Algomon;

import java.util.Hashtable;

import Modelo.TipoFuego;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Brasas;
import Modelo.Ataques.Fogonazo;

public class Charmander extends Algomon {
	
	public Charmander(){
		this.tipo = new TipoFuego();
		this.vida = 170;
		this.ataques = new Hashtable<String,Modelo.Ataques.Ataque>();
		this.ataques.put("Brasas", new Brasas());
		this.ataques.put("Fogonazo", new Fogonazo());
		this.ataques.put("Ataque rapido", new AtaqueRapido());
	}

}
