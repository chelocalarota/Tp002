package modelo.algomon;

import java.util.ArrayList;

import java.util.Map;

import javafx.scene.image.ImageView;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.estados.*;
import modelo.items.Item;
import modelo.tipos.Tipo;
import vista.CreadorImagen;

public abstract class Algomon {
	protected Tipo tipo;
	protected double vida;
	protected double vidaOriginal;
	protected Map<AtaquesEnum, Ataque> ataques;
	protected Estado estadoEfimero;
	protected Estado estadoPersistente;
	protected String imagenAsociada;

	public Ataque ataque(AtaquesEnum nombreAtaque) throws SinPuntosDePoderException, EstaDormidoException{

	

		Ataque ataque = ataques.get(nombreAtaque);
		ataque.getPuntosDePoderEsCero();
		this.estadoPersistente.accion(this);
		this.estadoEfimero.accion(this);

		ataque.restarPuntoDePoder();
		return ataque;
	}
	
	public int getVidaOriginal(){
		return (int)vidaOriginal;
	}

	public boolean estaEnEstadoNormal(){
		return (estadoEfimero.esEstadoNormal() && estadoPersistente.esEstadoNormal());
	}

	public void cambiarEstadoEfimero(Estado estadoNuevo) {
		this.estadoEfimero = estadoNuevo;
	}

	public void cambiarEstadoPersistente(Estado estadoNuevo) {
		this.estadoPersistente = estadoNuevo;
	}

	public int getVida(){
		return (int) vida;
	}

	public void cambiarVida(int cantidad){
		this.vida = this.vida + cantidad;
		if (vida >= this.vidaOriginal) { // Un algomon nunca tendra mas vida que la original
			this.vida = this.vidaOriginal;
		}
	}

	public Tipo getTipo(){
		return tipo;
	}

	public double recibirDanio(Ataque unAtaque, Algomon unAlgomonAtacante) throws PokemonMuertoException{

		Tipo tipoAtacante = unAtaque.getTipo();

		double multiplicador =  this.tipo.reaccionATipo(tipoAtacante);
		double danioResultante = unAtaque.getPotencia()*multiplicador;

		this.vida = this.vida-(int)danioResultante;

		unAtaque.cambioDeEstado(this);
		unAtaque.consecuenciaPropiaDeAtaque(unAlgomonAtacante, (int)danioResultante);
		if(this.vida<=0){
			throw new PokemonMuertoException("");
		}
		return this.vida;
	}

	public boolean estaMuerto() {
		return (this.vida < 0.001);
	}

	public void usarItem(Item unItem) throws SinUsosDisponiblesException {
		unItem.aplicarEfecto(this);
		
	}

	public ArrayList<Ataque> obtenerTodosLosAtaques(){
		ArrayList<Ataque> listaDeAtaques = new ArrayList<Ataque>();
		listaDeAtaques.addAll(this.ataques.values());
		return listaDeAtaques;
	}

	public String getEstadoPersistenteComoString() {
		return (this.estadoPersistente.asString());
	}

	public String getEstadoEfimeroComoString() {
		return (this.estadoEfimero.asString());
	}
}
