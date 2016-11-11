package Modelo.Algomon;

import java.util.HashMap;
import Modelo.Tipos.TipoPlanta;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Chupavidas;
import Modelo.Ataques.LatigoCepa;
import Modelo.Estados.EstadoNormal;

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
