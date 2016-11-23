package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;

public interface Estado {
	public boolean esEstadoNormal();
	public String asString();
	public void accion(Algomon unAlgomon) throws EstaDormidoException, PokemonMuertoException;
}
