package modelo.algomon;


import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.Canto;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoNormal;

public class Jigglypuff extends Algomon {
	public Jigglypuff(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Burbuja", new Burbuja());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
		this.ataques.put("Canto", new Canto());
		this.vida = 130;
		this.vidaOriginal=130;
		this.tipo = new TipoNormal();
	}
}
