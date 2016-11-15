package modelo.ataques;

import modelo.algomon.Algomon;
import modelo.tipos.TipoPlanta;

public class Chupavidas extends Ataque {
	
	public Chupavidas(){
		this.setPotencia(15);
		this.setCantidad(8);
		this.setTipo(new TipoPlanta());
	}
	
	public void consecuenciaPropiaDeAtaque(Algomon unAlgomon, int danioResultante){
		unAlgomon.cambiarVida((int) (danioResultante*0.30));
	}
}
