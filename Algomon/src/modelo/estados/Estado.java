package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;

public interface Estado {
	public boolean esEstadoNormal();

	public void accion(Algomon unAlgomon) throws EstaDormidoException;
}
