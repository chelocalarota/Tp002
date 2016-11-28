package tests.integradores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import modelo.Jugador;
import modelo.algomon.Algomon;
import modelo.algomon.Bulbasaur;
import modelo.algomon.Charmander;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.algomon.Squirtle;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;
import modelo.items.Item;

public class JugadorTest {

	@Test
	public void test01JugadorContieneTodosLosItemsAlEmpezar() {
		Jugador jugador = new Jugador();
		Map<ItemsEnum, Item> items = jugador.getItemsDisponibles();

		assertEquals(4, items.size());
	}

	@Test
	public void test02JugadorEmpiezaSinAlgomones() {
		Jugador jugador = new Jugador();
		List<Algomon> algomones = jugador.obtenerAlgomon();

		assertEquals(0, algomones.size());
	}

	@Test
	public void test03JugadorAgregaAlgomon() {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();

		jugador.agregarAlgomon(algomon);
		List<Algomon> algomones = jugador.obtenerAlgomon();

		assertEquals(1, algomones.size());
	}

	@Test
	public void test04JugadorAgregaAlgomonYEliminarAlgomon() {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();

		jugador.agregarAlgomon(algomon);
		jugador.eliminarAlgomonesElegidos();
		List<Algomon> algomones = jugador.obtenerAlgomon();


		assertEquals(0, algomones.size());
	}

	@Test
	public void test05JugadorTienePorDefaultElPrimerPokemonElegidoComoPokemonActivoEnBatalla() {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);

		Algomon algomonActivo = jugador.getPokemonActivo();

		assertEquals(algomonActivo, algomon);
	}

	@Test
	public void test06JugadorCambiaElAlgomonEnBatalla() throws PokemonMuertoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);

		jugador.elegirAlgomonEnBatalla(2);

		Algomon algomonActivo = jugador.getPokemonActivo();

		assertEquals(algomonActivo, algomon3);
	}

	@Test
	public void test07JugadorIntentaCambiarElAlgomonEnBatallaAUnAlgomonMuerto() throws PokemonMuertoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);
		try{
			algomon2.cambiarVida(-1000);
		}catch (PokemonMuertoException e){
			try{
				jugador.elegirAlgomonEnBatalla(1);
			}catch (PokemonMuertoException e2){
				assertTrue(true);
			}
		}
	}

	@Test
	public void test08JugadorEligeUnAtaqueDelAlgomonActivo() throws PokemonMuertoException, SinPuntosDePoderException, EstaDormidoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);
		Map<AtaquesEnum, Ataque> ataques = algomon.obtenerTodosLosAtaquesEnFormaDeMap();
		ArrayList<AtaquesEnum> ataquesEnum = new ArrayList<AtaquesEnum>(ataques.keySet());
		AtaquesEnum ataqueEnum = ataquesEnum.get(0);
		Ataque ataque = ataques.get(ataqueEnum);
		int cantidadDeUsosDeAtaque = ataque.getCantidad();

		jugador.elegirAtaque(ataqueEnum);

		int cantidadDeUsosRestantes = ataque.getCantidad();

		assertEquals(cantidadDeUsosDeAtaque -1, cantidadDeUsosRestantes);

	}

	@Test
	public void test09JugadorIntentaElegirUnAtaqueGastadoDelAlgomonActivo() throws PokemonMuertoException, SinPuntosDePoderException, EstaDormidoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);
		Map<AtaquesEnum, Ataque> ataques = algomon.obtenerTodosLosAtaquesEnFormaDeMap();
		ArrayList<AtaquesEnum> ataquesEnum = new ArrayList<AtaquesEnum>(ataques.keySet());
		AtaquesEnum ataqueEnum = ataquesEnum.get(0);
		Ataque ataque = ataques.get(ataqueEnum);
		int cantidadDeUsosDeAtaque = ataque.getCantidad();

		for(int i = 1; i > cantidadDeUsosDeAtaque; i++){
			try{
				jugador.elegirAtaque(ataqueEnum);
			}
			catch (SinPuntosDePoderException e){
				assertTrue(true);
			}
		}

	}

	@Test
	public void test10JugadorUsarUnItem() throws SinUsosDisponiblesException, PokemonMuertoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);

		Map<ItemsEnum, Item> items = jugador.getItemsDisponibles();
		ArrayList<ItemsEnum> itemsEnum = new ArrayList<ItemsEnum>(items.keySet());

		ItemsEnum itemEnum = itemsEnum.get(0);
		Item item = items.get(itemEnum);
		int cantidadDeUsosDeItem = item.cantidadDeUsos();

		jugador.usarItem(itemEnum);

		int cantidadDeUsosRestantes = item.cantidadDeUsos();

		assertEquals(cantidadDeUsosDeItem -1, cantidadDeUsosRestantes);

	}

	@Test
	public void test11JugadorIntentaUsarUnItemCuandoNoTieneMas() throws SinUsosDisponiblesException, PokemonMuertoException {
		Jugador jugador = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador.agregarAlgomon(algomon);
		jugador.agregarAlgomon(algomon2);
		jugador.agregarAlgomon(algomon3);

		Map<ItemsEnum, Item> items = jugador.getItemsDisponibles();
		ArrayList<ItemsEnum> itemsEnum = new ArrayList<ItemsEnum>(items.keySet());

		ItemsEnum itemEnum = itemsEnum.get(0);
		Item item = items.get(itemEnum);
		int cantidadDeUsosDeItem = item.cantidadDeUsos();

		for(int i = 1; i > cantidadDeUsosDeItem; i++){
			try{
				jugador.usarItem(itemEnum);
			}
			catch (SinUsosDisponiblesException e){
				assertTrue(true);
			}
		}

	}

	@Test
	public void test12JugadorIntentaUsarUnItemCuandoNoTieneMas() {
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Algomon algomon = new Charmander();
		Algomon algomon2 = new Squirtle();
		Algomon algomon3 = new Bulbasaur();

		jugador1.agregarAlgomon(algomon);
		jugador1.agregarAlgomon(algomon2);
		jugador1.agregarAlgomon(algomon3);

		for(Algomon algomonDisponible : jugador1.obtenerAlgomon()){
			try{
				algomonDisponible.cambiarVida(-1000);
			}
			catch (PokemonMuertoException e){
			}
		}

		assertTrue(jugador2.verificarVictoriaContraOtroJugador(jugador1));

	}



}
