package modelo;
import java.util.ArrayList;

import java.util.List;

import modelo.algomon.*;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.items.Item;

public class Jugador {
	private List<Algomon> algomonDisponibles;
	private List<Item> itemsDisponibles;
	private Algomon algomonActivo;
	public String nombre;
	
	public List<Algomon> obtenerAlgomon(){
		return this.algomonDisponibles;
	}
	public Jugador(){
		algomonDisponibles = new ArrayList<Algomon>();
		itemsDisponibles = new ArrayList<Item>();
	}
	
	public void agregarAlgomon(Algomon unAlgomon){
		this.algomonDisponibles.add(unAlgomon);
	}
	
	public void elegirAlgomonActivo(int indice) throws PokemonMuertoException{
		/**
		 * Los Pokemon estaran en un orden. El mismo que eligio el jugador
		 * Cuando uno decide cambiar, elegir� el Algomon numero 2, por ejemplo,
		 * ese ser� el indice que recibe.
		 */
		Algomon unAlgomon = algomonDisponibles.get(indice);
		if (unAlgomon.estaMuerto()){
			throw new PokemonMuertoException(null);
		}
		this.algomonActivo= unAlgomon;
	}
	
	public Ataque elegirAtaque(AtaquesEnum ataqueElegido) throws SinPuntosDePoderException, EstaDormidoException{
		return this.algomonActivo.ataque(ataqueElegido);
	}
	
	public void usarItem(int numeroItem) throws SinUsosDisponiblesException{
		/**
		 * Esto tambien puede manejarse igual que con los Pokemon, en el metodo
		 * elegirAlgomonActivo
		 */
		Item unItem = this.itemsDisponibles.get(numeroItem);
		if (unItem.sinUsosDisponibles()){
			throw new SinUsosDisponiblesException(null);
		}
		this.algomonActivo.usarItem(unItem);
	}
	public Algomon getPokemonActivo(){
		return this.algomonActivo;
	}

	public Boolean verificarVictoria() {
		for (Algomon algomon: this.algomonDisponibles){
			if(algomon.getVida()>0){
				return false;
			}
		}
		return true;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
