package Modelo.Estados;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstaDormidoException;

public interface Estado {
	public boolean esEstadoNormal();

	public void accion(Algomon unAlgomon)throws EstaDormidoException;
}
