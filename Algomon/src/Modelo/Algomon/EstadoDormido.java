package Modelo.Algomon;

public class EstadoDormido implements Estado {
	int turnos;
	public EstadoDormido(){
		turnos = 3;
	}
	@Override
	public boolean getPosibilidad(Algomon unAlgomon) {
		if (this.turnos ==0){
			unAlgomon.cambiarEstado(new EstadoNormal());
		}
		this.turnos-=1;
		return false;
	}

}
