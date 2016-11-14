package modelo.tipos;

public class TipoPlanta implements Tipo {

	@Override
	public double respuestaAAgua() {
		return 2.0;
	}

	@Override
	public double respuestaAFuego() {
		return 0.5;
	}

	@Override
	public double respuestaAPlanta() {
		return 0.5;
	}

	@Override
	public double respuestaANormal() {
		return 1.0;
	}

	@Override
	public double reaccionATipo(Tipo unTipo) {
		return unTipo.respuestaAPlanta();
	}

}
