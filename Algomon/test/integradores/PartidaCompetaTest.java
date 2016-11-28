package tests.integradores;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.junit.Test;

import modelo.Juego;
import modelo.VictoriaObtenidaException;
import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

public class PartidaCompetaTest {
	
	private void mostrarEstadoCompletoDelJuego(Juego juego){
		ArrayList<Ataque> ataquesJugadorActivo = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaques();
		ArrayList<Ataque> ataquesJugadorDefensor = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

		System.out.println("Jugador Actual:");
		System.out.println("Algomon Activo: " + juego.obtenerJugadorActual().getPokemonActivo());
		System.out.println("	Vida: " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println("	Estado Efimero: " + juego.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString());
		System.out.println("	Estado Persistente: " + juego.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString());
		for (Iterator<Ataque> iterator = ataquesJugadorActivo.iterator(); iterator.hasNext();) {
			Ataque ataque = (Ataque) iterator.next();
			System.out.println("	Ataque: " + ataque.getNombre() + " con: " + ataque.getCantidad());
		}
		System.out.println("	Item: Pocion: " + juego.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION));
		System.out.println("	Item: Super Pocion: " + juego.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION));
		System.out.println("	Item: Restaurador: " + juego.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR));
		System.out.println("	Item: Vitamina: " + juego.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA));
		System.out.println("");
		System.out.println("Jugador Defensor:");
		System.out.println("Algomon Activo: " + juego.obtenerJugadorDefensor().getPokemonActivo());
		System.out.println("	Vida: " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());
		System.out.println("	Estado Efimero: " + juego.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString());
		System.out.println("	Estado Persistente: " + juego.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString());
		for (Iterator<Ataque> iterator = ataquesJugadorDefensor.iterator(); iterator.hasNext();) {
			Ataque ataque = (Ataque) iterator.next();
			System.out.println("	Ataque: " + ataque.getNombre() + " con: " + ataque.getCantidad());
		}
		System.out.println("	Item: Pocion: " + juego.obtenerJugadorDefensor().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION));
		System.out.println("	Item: Super Pocion: " + juego.obtenerJugadorDefensor().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION));
		System.out.println("	Item: Restaurador: " + juego.obtenerJugadorDefensor().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR));
		System.out.println("	Item: Vitamina: " + juego.obtenerJugadorDefensor().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA));
		System.out.println("--------------------------------------------------------------");
		System.out.println("");
		System.out.println("");
	}

	@Test
	public void test() throws PokemonMuertoException, SinPuntosDePoderException, EstaDormidoException, VictoriaObtenidaException, SinUsosDisponiblesException {
		Juego juego = new Juego();
		
		//Agrego los pokemons al primer jugador
		juego.agregarBulbasaur();
		juego.agregarChansey();
		juego.agregarCharmander();
		juego.elegirPokemonInicialDeJugadorActual();
		
		juego.pasarTurno();
		
		//Agrego los pokemons al segundo jugador
		juego.agregarRattata();
		juego.agregarSquirtle();
		juego.agregarCharmander();
		juego.elegirPokemonInicialDeJugadorActual();
		
		juego.pasarTurno();
		
		// el primer jugador ataca
		Map<AtaquesEnum, Ataque> ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		int cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		
		// System.out.println("El atacante atacara con LatigoCepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);

		Map<AtaquesEnum, Ataque> ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		int cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);

		
		
		// el segundo jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.BURBUJA).getCantidad();
		
		// System.out.println("El atacante atacara con Burbuja, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BURBUJA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.BURBUJA).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);

		
		
		// el primer jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.CHUPAVIDAS).getCantidad();
		
		// System.out.println("El atacante atacara con chupavidas, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CHUPAVIDAS);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.CHUPAVIDAS).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		//el segundo jugador ataca.
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.ATAQUE_RAPIDO).getCantidad();
		
		// System.out.println("El atacante atacara con ataque rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.ATAQUE_RAPIDO).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		// el primer jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.ATAQUE_RAPIDO).getCantidad();
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.ATAQUE_RAPIDO).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		//el segundo jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.FOGONAZO).getCantidad();
		
		// System.out.println("El atacante atacara con fogonazo, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.FOGONAZO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.FOGONAZO).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		// el primer jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		
		// System.out.println("El atacante atacara con LatigoCepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		// el segundo jugador cambia de algomon
		List<Algomon> algomones = juego.obtenerJugadorActual().obtenerAlgomon();
		Algomon algomonSiguiente = algomones.get(1);
		
		// System.out.println("El atacante cambia de algomon al segundo, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(1);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		Algomon algomonActualDeJugadorDefensor = juego.obtenerJugadorDefensor().getPokemonActivo();
		assertEquals(algomonSiguiente.getClass(), algomonActualDeJugadorDefensor.getClass()); // no es lo mas feliz probar esto, pero es algo
		
		
		
		//el prumer jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		
		// System.out.println("El atacante atacara con LatigoCepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.LATIGO_CEPA).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		
		
		
		//el prumer jugador ataca
		ataquesAntes = juego.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesAntes = ataquesAntes.get(AtaquesEnum.CANION_DE_AGUA).getCantidad();
		
		// System.out.println("El atacante atacara con canion de agua, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANION_DE_AGUA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		ataquesDespues = juego.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaquesEnFormaDeMap();
		cantidadAtaquesDespues = ataquesDespues.get(AtaquesEnum.CANION_DE_AGUA).getCantidad();
		assertEquals(cantidadAtaquesAntes - 1, cantidadAtaquesDespues);
		

		
		// System.out.println("El atacante latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante usara una pocion, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.POCION);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con burbuja, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BURBUJA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante usa restaurador, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.RESTAURADOR);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante cambia de algomon al tercero, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(2);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante cambia de algomon al primero, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(0);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante usa vitamina, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.VITAMINA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con latigo cepa, y pasa de turno (ahora es defensor):");
		try {
			juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		} catch (SinPuntosDePoderException e) {
			assertTrue(true);
		}
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//como no pudo atacar porque se quedo sin latico cepa, hace otra accion
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con ataquerapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//muere un algomon => hay que cambiarlo		
		// System.out.println("El atacante atacara con ataquerapido, y deja sin vida "
				// + "\n al algomon oponente, por lo cual el jugador debe camiarlo"
				// + "\n y pasa de turno:");
		try {
			juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		} catch (PokemonMuertoException e) {
			assertTrue(true);
			juego.pasarTurno();
			juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(1);
		}
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante usa super pocion, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.SUPER_POCION);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Canto, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANTO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//quiere atacar pero esta dormido
		// System.out.println("El atacante atacara con ataquerapido, "
				// + "\n pero esta dormido:");
		try {
			juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		} catch (EstaDormidoException e) {
			assertTrue(true);
			juego.pasarTurno();
		}
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Latigo Cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//se cura del sueño
		// System.out.println("El atacante usa restaurador, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.RESTAURADOR);
		// this.mostrarEstadoCompletoDelJuego(juego);
		//verifico que este despierto
		String estado = juego.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		assertNotEquals(estado, "Dormido");
		assertEquals(estado, "Normal");
		
		// System.out.println("El atacante atacara con Latigo Cepa, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante usa super pocion restaurador, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.SUPER_POCION);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante cambia de algomon, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(2);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Fogonazo, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.FOGONAZO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//verifico que quedo quemado
		estado = juego.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		assertEquals(estado, "Quemado");
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante cambia de algomon, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(1);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Canion de agua, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANION_DE_AGUA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Canion de agua, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANION_DE_AGUA);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//mato al segundo algomon
		// System.out.println("El atacante atacara con canion de agua, y deja sin vida "
				// + "\n al algomon oponente, por lo cual el jugador debe camiarlo"
				// + "\n y pasa de turno:");
		try {
			juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANION_DE_AGUA);
		} catch (PokemonMuertoException e) {
			assertTrue(true);
			juego.pasarTurno();
			juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(1);
		}
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//no hay mas superpocion
		// System.out.println("El atacante intenrata usar super pocion, "
				// + "\n pero no tiene disponibles:");
		try {
			juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.SUPER_POCION);
		} catch (SinUsosDisponiblesException e) {
			assertTrue(true);
		}
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		
		// System.out.println("El atacante usa pocion restaurador, y pasa de turno (ahora es defensor):");
		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.POCION);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Canto, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANTO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//verifico que quedo dormido
		estado = juego.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		assertEquals(estado, "Dormido");
		
		// System.out.println("El atacante cambia de algomon, y pasa de turno (ahora es defensor):");
		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(2);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Brasas, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BRASAS);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		//verifico que esta quemado
		estado = juego.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		assertEquals(estado, "Quemado");
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Brasas, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BRASAS);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Brasas, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BRASAS);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Brasas, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BRASAS);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Ataque Rapido, y pasa de turno (ahora es defensor):");
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		// this.mostrarEstadoCompletoDelJuego(juego);
		
		// System.out.println("El atacante atacara con Brasas, y pasa de turno (ahora es defensor):");
		try {
			juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BRASAS);
		} catch (VictoriaObtenidaException e) {
			assertTrue(true);
		}
	}
}
