package Modelo.Algomon;

import java.util.Hashtable;

public class Rattata extends Algomon {
	public Rattata(){
		this.ataques =new Hashtable<String,Modelo.Ataques.Ataque>();
		this.ataques.put("Fogonazo", new Modelo.Ataques.Fogonazo());
		this.ataques.put("Ataques Rapido", new Modelo.Ataques.AtaqueRapido());
		this.ataques.put("Burbuja", new Modelo.Ataques.Burbuja());
		this.vida = 170;
		this.tipo = new TipoNormal();
	}
}
