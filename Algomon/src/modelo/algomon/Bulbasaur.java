package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Chupavidas;
import modelo.ataques.LatigoCepa;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoPlanta;

public class Bulbasaur extends Algomon {
	
	public Bulbasaur(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoPlanta();
		this.vida = 140;
		this.vidaOriginal=140;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Chupavidas", new Chupavidas());
		this.ataques.put("Latigo Cepa", new LatigoCepa());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
	}

}
