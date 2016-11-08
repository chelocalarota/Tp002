package Modelo.Algomon;


import java.util.HashMap;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.AtaqueRapido;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.Canto;

import Modelo.TipoNormal;

public class Jigglypuff extends Algomon {
	public Jigglypuff(){
		this.estado = new EstadoNormal();
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Burbuja", new Burbuja());
		this.ataques.put("Ataque Rapido", new AtaqueRapido());
		this.ataques.put("Canto", new Canto());
		this.vida = 130;
		this.tipo = new TipoNormal();
	}
}
