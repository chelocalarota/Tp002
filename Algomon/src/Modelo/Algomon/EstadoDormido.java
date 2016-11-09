package Modelo.Algomon;

public class EstadoDormido implements Estado {
	int turnos;
	public EstadoDormido(){
		turnos = 3;
	}
	@Override
	public boolean getEstado(Algomon unAlgomon) {
		if (this.turnos ==0){
			unAlgomon.cambiarEstadoEfimero(new EstadoNormal());
		}
		this.turnos-=1;
		return false;
	}
	
}
