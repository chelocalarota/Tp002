package Modelo.Algomon;

public class EstadoNormal implements Estado {

	@Override
	public boolean esEstadoNormal() {
		return true;
	}

	@Override
	public boolean accion(Algomon unAlgomon) {
		
		return false;
	}

}
