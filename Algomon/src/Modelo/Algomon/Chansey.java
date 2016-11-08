package Modelo.Algomon;

import java.util.HashMap;
import Modelo.TipoNormal;
import Modelo.Ataques.Ataque;
import Modelo.Ataques.Burbuja;
import Modelo.Ataques.Canto;
import Modelo.Ataques.LatigoCepa;

public class Chansey extends Algomon{
	public Chansey(){
		this.estado = new EstadoNormal();
		this.ataques = new HashMap<String, Ataque>();
		this.ataques.put("Burbuja", new Burbuja());
		this.ataques.put("Latigo Cepa", new LatigoCepa());
		this.ataques.put("Canto", new Canto());
		this.vida = 130;
		this.tipo = new TipoNormal();
	}
}
