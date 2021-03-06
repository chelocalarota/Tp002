package modelo;
import java.util.LinkedList;
public class Cola {
	private LinkedList<Jugador> cola;
	
	public Cola(){
		this.cola = new LinkedList<Jugador>();
	}
	public void encolar(Jugador unJugador){
		this.cola.addLast(unJugador);
	}
	public Jugador verPrimero(){
		return this.cola.getFirst();
	}
	public void avanzarTurno(){
		this.cola.addLast(this.cola.removeFirst());
	}

}
