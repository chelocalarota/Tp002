package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.Fogonazo;
import modelo.enums.AtaquesEnum;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoNormal;

public class Rattata extends Algomon {
	
	public Rattata(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoNormal();
		this.vida = 170;
		this.vidaOriginal = 170;
		this.ataques = new HashMap<AtaquesEnum, Ataque>();
		this.ataques.put(AtaquesEnum.FOGONAZO, new Fogonazo());
		this.ataques.put(AtaquesEnum.ATAQUE_RAPIDO, new AtaqueRapido());
		this.ataques.put(AtaquesEnum.BURBUJA, new Burbuja());
	}
}
