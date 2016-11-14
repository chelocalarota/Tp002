package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.Fogonazo;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoNormal;

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
