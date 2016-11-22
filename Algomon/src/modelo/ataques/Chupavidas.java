package modelo.ataques;

import modelo.algomon.Algomon;
import modelo.algomon.PokemonMuertoException;
import modelo.enums.AtaquesEnum;
import modelo.tipos.TipoPlanta;

public class Chupavidas extends Ataque {
	
	public Chupavidas(){
		this.setPotencia(15);
		this.setCantidad(8);
		this.setTipo(new TipoPlanta());
		this.nombre = "ChupaVidas";
	}
	
	public void consecuenciaPropiaDeAtaque(Algomon unAlgomon, int danioResultante) throws PokemonMuertoException{
		unAlgomon.cambiarVida((int) (danioResultante*0.30));
	}
}
