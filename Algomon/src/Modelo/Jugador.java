package Modelo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Modelo.Algomon.*;

public class Jugador {
	List<Algomon> algomonDisponibles;
	Map<String,Item> itemsDisponibles;
	Algomon algomonActivo;
	
	public Jugador(){
		algomonDisponibles = new ArrayList<Algomon>();
		itemsDisponibles = new HashMap<String,Item>();
	}
	
	public void AgregarAlgomon(Algomon unAlgomon){
		this.algomonDisponibles.add(unAlgomon);
	}
	public void ElegirAlgomonActivo(int indice) throws PokemonMuertoException{
		Algomon unAlgomon = algomonDisponibles.get(indice);
		if (unAlgomon.estaMuerto()){
			throw new PokemonMuertoException(null);
		}
		this.algomonActivo= unAlgomon;
	}
	
	public void ElegirAtaque(String ataqueElegido) throws SinPuntosDePoderException{
		this.algomonActivo.ataque(ataqueElegido);
	}
	
}
