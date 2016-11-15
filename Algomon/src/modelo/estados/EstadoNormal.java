package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;

public class EstadoNormal implements Estado {

	@Override
	public boolean esEstadoNormal() {
		return true;
	}

	@Override
	public void accion(Algomon unAlgomon) throws EstaDormidoException{
	}

}
