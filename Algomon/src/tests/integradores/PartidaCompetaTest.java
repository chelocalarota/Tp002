package tests.integradores;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.Juego;
import modelo.VictoriaObtenidaException;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

public class PartidaCompetaTest {

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
		
		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.BURBUJA);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CHUPAVIDAS);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.ATAQUE_RAPIDO);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.FOGONAZO);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.cambiarAlgomonParaJugadorActualYPasarDeTurno(1);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.LATIGO_CEPA);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.resolverAtaqueYPasarDeTurno(AtaquesEnum.CANION_DE_AGUA);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		juego.usarItemParaJugadorActualYPasarDeTurno(ItemsEnum.SUPER_POCION);
		System.out.println(juego.obtenerJugadorActual().getPokemonActivo()+ " " + juego.obtenerJugadorActual().getPokemonActivo().getVida());
		System.out.println(juego.obtenerJugadorDefensor().getPokemonActivo()+ " " + juego.obtenerJugadorDefensor().getPokemonActivo().getVida());

		
	}

}
