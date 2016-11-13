package Modelo.Estados;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.EstaDormidoException;

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
