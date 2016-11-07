package Modelo.Algomon;

import java.util.Hashtable;

public class Chansey extends Algomon{
	public Chansey(){
		this.ataques =new Hashtable<String,Modelo.Ataques.Ataque>();
		this.ataques.put("Burbuja", new Modelo.Ataques.Burbuja());
		this.ataques.put("Latigo Cepa", new Modelo.Ataques.LatigoCepa());
		this.ataques.put("Canto",new Modelo.Ataques.Canto());
		this.vida = 130;
		this.tipo = new TipoNormal();
	}
}
