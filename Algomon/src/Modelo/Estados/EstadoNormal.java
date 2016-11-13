package Modelo.Estados;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstaDormidoException;

public class EstadoNormal implements Estado {

	@Override
	public boolean esEstadoNormal() {
		return true;
	}

	@Override
	public void accion(Algomon unAlgomon) throws EstaDormidoException{
	}

}
