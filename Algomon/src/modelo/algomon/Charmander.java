package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Brasas;
import modelo.ataques.Fogonazo;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoFuego;

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
