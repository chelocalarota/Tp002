package modelo.algomon;


import java.util.HashMap;

import modelo.ataques.Ataque;
import modelo.ataques.AtaqueRapido;
import modelo.ataques.Burbuja;
import modelo.ataques.Canto;
import modelo.enums.AtaquesEnum;
import modelo.estados.EstadoNormal;
import modelo.tipos.TipoNormal;

public class Jigglypuff extends Algomon {
	
	public Jigglypuff(){
		this.estadoEfimero = new EstadoNormal();
		this.estadoPersistente = new EstadoNormal();
		this.tipo = new TipoNormal();
		this.vida = 130;
		this.vidaOriginal = 130;
		this.ataques = new HashMap<AtaquesEnum, Ataque>();
		this.ataques.put(AtaquesEnum.BURBUJA, new Burbuja());
		this.ataques.put(AtaquesEnum.ATAQUE_RAPIDO, new AtaqueRapido());
		this.ataques.put(AtaquesEnum.CANTO, new Canto());

	}
}
