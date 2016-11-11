package Modelo.Ataques;

import Modelo.Tipos.TipoPlanta;
import Modelo.Algomon.Algomon;

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
