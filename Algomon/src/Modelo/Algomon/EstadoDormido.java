package Modelo.Algomon;

public class EstadoDormido implements Estado {
	int turnos;
	public EstadoDormido(){
		turnos = 3;
	}
	@Override
	public boolean esEstadoNormal() {
		
		return false;
	}
	@Override
	public boolean accion(Algomon unAlgomon) {
		if (this.turnos ==0){
			unAlgomon.cambiarEstadoEfimero(new EstadoNormal());
			return false;
		}
		this.turnos-=1;
		return true;
	}
	
}
