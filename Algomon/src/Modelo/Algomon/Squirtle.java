package Modelo.Algomon;

import java.util.HashMap;
import Modelo.Ataques.Ataque;

import Modelo.TipoAgua;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.CanionDeAgua;

public class Squirtle extends Algomon {
	
	public Squirtle(){
		this.tipo = new TipoAgua();
		this.vida = 150;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Burbuja", new Burbuja());
		this.ataques.put("Canion de Agua", new CanionDeAgua());
		this.ataques.put("Ataque rapido", new AtaqueRapido());
	}

}
