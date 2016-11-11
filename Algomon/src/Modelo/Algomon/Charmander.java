package Modelo.Algomon;

import java.util.HashMap;

import Modelo.Tipos.TipoFuego;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Brasas;
import Modelo.Ataques.Fogonazo;
import Modelo.Estados.EstadoNormal;

public class Charmander extends Algomon {
	
	public Charmander(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoFuego();
		this.vida = 170;
		this.vidaOriginal = 170;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Brasas", new Brasas());
		this.ataques.put("Fogonazo", new Fogonazo());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
	}

}
