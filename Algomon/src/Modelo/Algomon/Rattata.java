package Modelo.Algomon;

import java.util.HashMap;

import Modelo.Tipos.TipoNormal;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.Fogonazo;
import Modelo.Estados.EstadoNormal;

public class Rattata extends Algomon {
	public Rattata(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.ataques =new HashMap<String, Ataque>();
		this.ataques.put("Fogonazo", new Fogonazo());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
		this.ataques.put("Burbuja", new Burbuja());
		this.vida = 170;
		this.vidaOriginal = 170;
		
		this.tipo = new TipoNormal();
	}
}
