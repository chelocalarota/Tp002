package Modelo;

public class TipoNormal implements Tipo {

	@Override
	public double respuestaAAgua() {
		return 1.0;
	}

	@Override
	public double respuestaAFuego() {
		return 1.0;
	}

	@Override
	public double respuestaAPlanta() {
		return 1.0;
	}

	@Override
	public double respuestaANormal() {
		return 1.0;
	}

	@Override
	public double reaccionATipo(Tipo unTipo) {
		return unTipo.respuestaANormal();
	}

}
