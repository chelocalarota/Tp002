package modelo.estados;

import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;

public class EstadoDormido implements Estado {
	private int turnos;
	
	public EstadoDormido(){
		turnos = 3;
	}
	
	@Override
	public boolean esEstadoNormal() {
		return false;
	}
	
	@Override
	public void accion(Algomon unAlgomon) throws EstaDormidoException {
		if (this.turnos == 0){
			unAlgomon.cambiarEstadoEfimero(new EstadoNormal());
			return ;
		}
		this.turnos -= 1;
		throw new EstaDormidoException("");
	}
	public String asString(){
		return "Dormido";
	}
}
