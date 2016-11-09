package Modelo.Ataques;

import Modelo.TipoPlanta;
import Modelo.Algomon.Algomon;

public class Chupavidas extends Ataque {
	public Chupavidas(){
		this.setPotencia(15);
		this.setCantidad(8);
		this.setTipo(new TipoPlanta());
	}
	public void consecuenciaPropiaDeAtaque(Algomon unAlgomon){
		unAlgomon.cambiarVida((int) (unAlgomon.getVida()*0.30));
	}
}
