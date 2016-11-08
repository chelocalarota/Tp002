package Modelo.Algomon;

import java.util.HashMap;

import Modelo.TipoFuego;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Brasas;
import Modelo.Ataques.Fogonazo;

public class Charmander extends Algomon {
	
	public Charmander(){
		this.estado = new EstadoNormal();
		this.tipo = new TipoFuego();
		this.vida = 170;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Brasas", new Brasas());
		this.ataques.put("Fogonazo", new Fogonazo());
		this.ataques.put("Ataque rapido", new AtaqueRapido());
	}

}
