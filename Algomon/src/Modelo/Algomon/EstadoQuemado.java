package Modelo.Algomon;

public class EstadoQuemado implements Estado {


	@Override
	public boolean esEstadoNormal() {
		return false;
	}

	@Override
	public boolean accion(Algomon unAlgomon) {
		unAlgomon.cambiarEstadoPersistente(this);
		unAlgomon.cambiarVida((int) (-unAlgomon.getVidaOriginal()*0.1));
		return false;
	}

}
