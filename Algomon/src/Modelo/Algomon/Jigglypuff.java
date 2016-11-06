package Modelo.Algomon;


import java.util.Hashtable;

import Modelo.TipoNormal;

public class Jigglypuff extends Algomon {
	public Jigglypuff(){
		this.ataques =new Hashtable<String,Modelo.Ataques.Ataque>();
		this.ataques.put("Burbuja", new Modelo.Ataques.Burbuja());
		this.ataques.put("Ataques Rapido", new Modelo.Ataques.AtaqueRapido());
		this.vida = 130;
		this.tipo = new TipoNormal();
	}
}
