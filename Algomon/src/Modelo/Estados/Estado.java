package Modelo.Estados;

import Modelo.Algomon.Algomon;

public interface Estado {
	public boolean esEstadoNormal();

	public boolean accion(Algomon unAlgomon);
}
