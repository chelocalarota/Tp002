package Modelo.Algomon;

import java.util.HashMap;
import Modelo.Ataques.Ataque;

import Modelo.Tipos.TipoAgua;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.CanionDeAgua;
import Modelo.Estados.EstadoNormal;

public class Squirtle extends Algomon {
	
	public Squirtle(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoAgua();
		this.vida = 150;
		this.vidaOriginal = 150;
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Burbuja", new Burbuja());
		this.ataques.put("Canion de Agua", new CanionDeAgua());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
	}

}
