package Modelo.Algomon;

import java.util.HashMap;

import Modelo.TipoNormal;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.Fogonazo;

public class Rattata extends Algomon {
	public Rattata(){
		this.ataques =new HashMap<String, Ataque>();
		this.ataques.put("Fogonazo", new Fogonazo());
		this.ataques.put("Ataques Rapido", new AtaqueRapido());
		this.ataques.put("Burbuja", new Burbuja());
		this.vida = 170;
		this.tipo = new TipoNormal();
	}
}
