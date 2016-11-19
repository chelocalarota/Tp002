//package tests.integradores;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import modelo.Juego;
//import modelo.VictoriaObtenidaException;
//import modelo.algomon.EstaDormidoException;
//import modelo.algomon.PokemonMuertoException;
//import modelo.algomon.SinPuntosDePoderException;
//import modelo.enums.AtaquesEnum;
//
//public class PartidaCompetaTest {
//
//	@Test
//	public void test() throws PokemonMuertoException, SinPuntosDePoderException, EstaDormidoException, VictoriaObtenidaException {
//		Juego juego = new Juego();
//		
//		//Agrego los pokemons al primer jugador
//		juego.agregarBulbasaur();
//		juego.agregarChansey();
//		juego.agregarCharmander();
//		juego.elegirPokemonInicialDeJugadorActual();
//		
//		juego.pasarTurno();
//		
//		//Agrego los pokemons al segundo jugador
//		juego.agregarRattata();
//		juego.agregarSquirtle();
//		juego.agregarJigglypuff();
//		juego.elegirPokemonInicialDeJugadorActual();
//		
//		juego.pasarTurno();
//		
//		juego.resolverAtaque(AtaquesEnum.LATIGO_CEPA);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.BURBUJA);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.CHUPAVIDAS);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.ATAQUE_RAPIDO);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.ATAQUE_RAPIDO);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.FOGONAZO);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.LATIGO_CEPA);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.cambiarPokemonDeJugadorActual(1);
//		juego.pasarTurno();
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.LATIGO_CEPA);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.resolverAtaque(AtaquesEnum.CANION_DE_AGUA);
//		System.out.println(juego.obtenerJugadorActual().getPokemonActivo().getVida());
//		
//		juego.obtenerJugadorActual().usarItem(numeroItem);
//		
//		
//	}
//
//}
