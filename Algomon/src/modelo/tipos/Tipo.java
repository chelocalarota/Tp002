package modelo.tipos;

public interface Tipo {
	public double respuestaAAgua();
	public double respuestaAFuego();
	public double respuestaAPlanta();
	public double respuestaANormal();
	public double reaccionATipo(Tipo unTipo);
}
