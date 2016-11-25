package modelo;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import modelo.algomon.*;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;
import modelo.items.Item;
import modelo.items.Pocion;
import modelo.items.Restaurador;
import modelo.items.SuperPocion;
import modelo.items.Vitamina;

public class Jugador {
	private List<Algomon> algomonDisponibles;
	private Map<ItemsEnum, Item> itemsDisponibles;
	private Algomon algomonActivo;
	public String nombre;

	public List<Algomon> obtenerAlgomon(){
		return this.algomonDisponibles;
	}

	public Jugador(){
		this.algomonDisponibles = new ArrayList<Algomon>();
		this.itemsDisponibles = new HashMap<>();
		this.itemsDisponibles.put(ItemsEnum.POCION, new Pocion());
		this.itemsDisponibles.put(ItemsEnum.SUPER_POCION, new SuperPocion());
		this.itemsDisponibles.put(ItemsEnum.RESTAURADOR, new Restaurador());
		this.itemsDisponibles.put(ItemsEnum.VITAMINA, new Vitamina());
	}

	public void agregarAlgomon(Algomon unAlgomon){
		this.algomonDisponibles.add(unAlgomon);
		if (this.algomonActivo == null){
			this.algomonActivo = unAlgomon;
		}
	}

	public void eliminarAlgomonesElegidos(){
		this.algomonDisponibles = new ArrayList<Algomon>();
	}

	public void elegirAlgomonEnBatalla(int indice) throws PokemonMuertoException{
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

	public Ataque elegirAtaque(AtaquesEnum ataqueElegido) throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		return this.algomonActivo.ataque(ataqueElegido);
	}

	public void usarItem(ItemsEnum unItem) throws SinUsosDisponiblesException, PokemonMuertoException{
		/**
		 * Esto tambien puede manejarse igual que con los Pokemon, en el metodo
		 * elegirAlgomonActivo
		 */
		Item item = this.itemsDisponibles.get(unItem);
		if (item.sinUsosDisponibles()){
			throw new SinUsosDisponiblesException(null);
		}
		this.algomonActivo.usarItem(item);
	}

	public Algomon getPokemonActivo(){
		return this.algomonActivo;
	}

	public Boolean verificarVictoriaContraOtroJugador(Jugador unJugador) {

		for (Algomon algomon: unJugador.algomonDisponibles){
			if(! algomon.estaMuerto()){
				return false;
			}
		}
		return true;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int cantidadDeUsosDisponiblesDeItem(ItemsEnum unItem) {
		Item item = this.itemsDisponibles.get(unItem);
		return item.cantidadDeUsos();
	}
}
