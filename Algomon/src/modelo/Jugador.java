package modelo;
import java.util.ArrayList;

import java.util.List;

import modelo.algomon.*;
import modelo.enums.AtaquesEnum;
import modelo.items.Item;

public class Jugador {
	private List<Algomon> algomonDisponibles;
	private List<Item> itemsDisponibles;
	private Algomon algomonActivo;
	
	public Jugador(){
		algomonDisponibles = new ArrayList<Algomon>();
		itemsDisponibles = new ArrayList<Item>();
	}
	
	public void AgregarAlgomon(Algomon unAlgomon){
		this.algomonDisponibles.add(unAlgomon);
	}
	public void ElegirAlgomonActivo(int indice) throws PokemonMuertoException{
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
	
	public void ElegirAtaque(AtaquesEnum ataqueElegido) throws SinPuntosDePoderException, EstaDormidoException{
		this.algomonActivo.ataque(ataqueElegido);
	}
	public void UsarItem(int numeroItem) throws SinUsosDisponiblesException{
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
}
