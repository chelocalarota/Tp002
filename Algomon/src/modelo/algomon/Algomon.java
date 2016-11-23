package modelo.algomon;

import java.util.ArrayList;
import java.util.HashMap;
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

	public Ataque ataque(AtaquesEnum nombreAtaque) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
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

	public void cambiarVida(int cantidad) throws PokemonMuertoException{
		this.vida = this.vida + cantidad;
		if (vida >= this.vidaOriginal) { 
			this.vida = this.vidaOriginal;
		}
		if(this.estaMuerto()){
			throw new PokemonMuertoException("Te moriste... JA!");
		}
	}

	public Tipo getTipo(){
		return tipo;
	}

	public double recibirDanio(Ataque unAtaque, Algomon unAlgomonAtacante) throws PokemonMuertoException{

		Tipo tipoAtacante = unAtaque.getTipo();

		double multiplicador =  this.tipo.reaccionATipo(tipoAtacante);
		double danioResultante = unAtaque.getPotencia()*multiplicador;

		this.cambiarVida(-(int)danioResultante);

		unAtaque.cambioDeEstado(this);
		unAtaque.consecuenciaPropiaDeAtaque(unAlgomonAtacante, (int)danioResultante);
		return this.vida;
	}

	public boolean estaMuerto() {
		return (this.vida < 0.001);
	}

	public void usarItem(Item unItem) throws SinUsosDisponiblesException, PokemonMuertoException {
		unItem.aplicarEfecto(this);
		try {
			this.estadoPersistente.accion(this);
			this.estadoEfimero.accion(this);
		} catch (EstaDormidoException e) {
			
		}
	}

	public ArrayList<Ataque> obtenerTodosLosAtaques(){
		ArrayList<Ataque> listaDeAtaques = new ArrayList<Ataque>();
		listaDeAtaques.addAll(this.ataques.values());
		return listaDeAtaques;
	}
	
	public Map<AtaquesEnum, Ataque> obtenerTodosLosAtaquesEnFormaDeMap(){
		Map<AtaquesEnum, Ataque> hashDeAtaques = new HashMap<>();
		hashDeAtaques.putAll(this.ataques);
		return hashDeAtaques;
	}

	public String getEstadoPersistenteComoString() {
		return (this.estadoPersistente.asString());
	}

	public String getEstadoEfimeroComoString() {
		return (this.estadoEfimero.asString());
	}
}
