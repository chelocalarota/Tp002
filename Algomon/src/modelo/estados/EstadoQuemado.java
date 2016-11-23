package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;

public class EstadoQuemado implements Estado {

	@Override
	public boolean esEstadoNormal() {
		return false;
	}

	@Override
	public void accion(Algomon unAlgomon) throws EstaDormidoException, PokemonMuertoException{
		unAlgomon.cambiarEstadoPersistente(this);
		unAlgomon.cambiarVida((int) (-unAlgomon.getVidaOriginal()*0.1));
	}

	@Override
	public String asString() {
		return "Quemado";
	}

}
