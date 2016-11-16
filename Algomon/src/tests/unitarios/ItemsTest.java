package tests.unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import modelo.algomon.Algomon;
import modelo.algomon.Charmander;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.Jigglypuff;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.Rattata;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.algomon.Squirtle;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.items.Item;
import modelo.items.Pocion;
import modelo.items.Restaurador;
import modelo.items.SuperPocion;
import modelo.items.Vitamina;

public class ItemsTest {

	@Test
	public void usarPocion() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException {
		Item pocion = new Pocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		rattata.recibirDanio(squirtle.ataque(AtaquesEnum.CANION_DE_AGUA), squirtle);
		int vidaRattata = rattata.getVida();
		rattata.usarItem(pocion);

		assertEquals(vidaRattata+20, rattata.getVida());
	}

	@Test
	public void usarPocionConVidaMaximaNoSumaMasVida() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item pocion = new Pocion();
		Algomon rattata = new Rattata();
		int vidaRattata = rattata.getVida();
		rattata.usarItem(pocion);

		assertEquals(vidaRattata, rattata.getVida());
	}

	@Test
	public void usarSuperPocion() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException {
		Item superPocion = new SuperPocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		rattata.recibirDanio(squirtle.ataque(AtaquesEnum.CANION_DE_AGUA), squirtle);
		rattata.recibirDanio(squirtle.ataque(AtaquesEnum.CANION_DE_AGUA), squirtle);
		int vidaRattata = rattata.getVida();
		rattata.usarItem(superPocion);

		assertEquals(vidaRattata+40, rattata.getVida());
	}

	@Test
	public void usarSuperPocionConVidaMaximaNoSumaMasVida() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item superPocion = new SuperPocion();
		Algomon rattata = new Rattata();
		int vidaRattata = rattata.getVida();
		rattata.usarItem(superPocion);

		assertEquals(vidaRattata, rattata.getVida());
	}

	@Test
	public void usarRestaurador() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException {
		Item restaurador = new Restaurador();
		Algomon jigglypuff = new Jigglypuff();
		Algomon charmander = new Charmander();
		charmander.recibirDanio(jigglypuff.ataque(AtaquesEnum.CANTO),jigglypuff);
		charmander.usarItem(restaurador);
		assertTrue(charmander.estaEnEstadoNormal());
		jigglypuff.recibirDanio(charmander.ataque(AtaquesEnum.FOGONAZO), charmander);
		jigglypuff.usarItem(restaurador);
		assertTrue(jigglypuff.estaEnEstadoNormal());
	}

	@Test
	public void usarVitamina() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item vitamina = new Vitamina();
		Algomon squirtle1 = new Squirtle();
		Algomon squirtle2 = new Squirtle();
		ArrayList<Ataque> listaDeAtaques = squirtle1.obtenerTodosLosAtaques();
		ArrayList<Ataque> listaDeAtaques2 = squirtle2.obtenerTodosLosAtaques();
		squirtle1.usarItem(vitamina);
		for (int i = 0; i < listaDeAtaques.size(); i++){
			assertEquals(listaDeAtaques.get(i).getCantidad(),listaDeAtaques2.get(i).getCantidad()+2);
		}
	}

	@Test
	public void usarPocionMasDe4Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException{
		Item pocion = new Pocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		for (int i = 1; i < 6; i++){
			rattata.recibirDanio(squirtle.ataque(AtaquesEnum.CANION_DE_AGUA), squirtle);
		}
		for (int j = 1; j < 6; j++){
			try{
				rattata.usarItem(pocion);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);

			}
		}
	}

	@Test
	public void usarSuperPocionMasDe2Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException{
		Item superPocion = new SuperPocion();
		Algomon squirtle = new Squirtle();
		Algomon charmander = new Charmander();
		for (int i = 1; i < 3; i++){
			charmander.recibirDanio(squirtle.ataque(AtaquesEnum.CANION_DE_AGUA), squirtle);
		}
		for (int j = 1; j < 3; j++){
			try{
				charmander.usarItem(superPocion);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);

			}
		}
	}

	@Test
	public void usarRestauradorMasDe3Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException, PokemonMuertoException{
		Item restaurador = new Restaurador();
		Algomon jigglypuff = new Jigglypuff();
		Algomon charmander = new Charmander();
		for (int i = 1; i < 4; i++){
			charmander.recibirDanio(jigglypuff.ataque(AtaquesEnum.CANTO), jigglypuff);
			try{
				charmander.usarItem(restaurador);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);
			}
		}

		for (int j = 1; j < 4; j++){
			jigglypuff.recibirDanio(charmander.ataque(AtaquesEnum.FOGONAZO), charmander);
			try{
				jigglypuff.usarItem(restaurador);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);
			}
		}
	}

	@Test
	public void usarVitaminaMasDe5Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException{
		Item vitamina = new Vitamina();
		Algomon squirtle = new Squirtle();
		for (int i = 1; i < 6; i++){
			try{
				squirtle.usarItem(vitamina);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);

			}
		}
	}


}
