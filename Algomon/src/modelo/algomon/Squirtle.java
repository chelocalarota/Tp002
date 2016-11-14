package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.CanionDeAgua;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoAgua;

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
