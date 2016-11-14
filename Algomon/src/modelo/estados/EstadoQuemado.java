package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;

public class EstadoQuemado implements Estado {

	@Override
	public boolean esEstadoNormal() {
		return false;
	}

	@Override
	public void accion(Algomon unAlgomon) throws EstaDormidoException{
		unAlgomon.cambiarEstadoPersistente(this);
		unAlgomon.cambiarVida((int) (-unAlgomon.getVidaOriginal()*0.1));
	}

}
