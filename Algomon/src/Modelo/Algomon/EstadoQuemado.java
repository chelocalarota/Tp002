package Modelo.Algomon;

public class EstadoQuemado implements Estado {

	@Override
	public boolean getEstado(Algomon unAlgomon) {
		unAlgomon.cambiarVida((int) (-unAlgomon.getVida()*0.1));
		return true;
	}

}
