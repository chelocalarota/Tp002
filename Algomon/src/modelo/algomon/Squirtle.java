package modelo.algomon;

import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.CanionDeAgua;
import modelo.enums.AtaquesEnum;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoAgua;

public class Squirtle extends Algomon {
	
	public Squirtle(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoAgua();
		this.vida = 150;
		this.vidaOriginal = 150;
		this.ataques = new HashMap<AtaquesEnum, Ataque>();
		this.ataques.put(AtaquesEnum.BURBUJA, new Burbuja());
		this.ataques.put(AtaquesEnum.CANION_DE_AGUA, new CanionDeAgua());
		this.ataques.put(AtaquesEnum.ATAQUE_RAPIDO, new AtaqueRapido());
	}

}
