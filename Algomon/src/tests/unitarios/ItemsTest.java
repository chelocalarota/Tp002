package tests.unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.Charmander;
import Modelo.Algomon.EstaDormidoException;
import Modelo.Algomon.Jigglypuff;
import Modelo.Algomon.Rattata;
import Modelo.Algomon.SinPuntosDePoderException;
import Modelo.Algomon.SinUsosDisponiblesException;
import Modelo.Algomon.Squirtle;
import Modelo.Ataques.Ataque;
import Modelo.Items.Item;
import Modelo.Items.Pocion;
import Modelo.Items.Restaurador;
import Modelo.Items.SuperPocion;
import Modelo.Items.Vitamina;

public class ItemsTest {

	@Test
	public void usarPocion() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item pocion = new Pocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		rattata.recibirDanio(squirtle.ataque("Canion de Agua"), squirtle);
		int vidaRattata = rattata.getVida();
		rattata.usarItem(pocion);

		assertEquals(vidaRattata+20, rattata.getVida());
	}

	@Test
	public void usarSuperPocion() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item superPocion = new SuperPocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		rattata.recibirDanio(squirtle.ataque("Canion de Agua"), squirtle);
		rattata.recibirDanio(squirtle.ataque("Canion de Agua"), squirtle);
		int vidaRattata = rattata.getVida();
		rattata.usarItem(superPocion);

		assertEquals(vidaRattata+40, rattata.getVida());
	}

	@Test
	public void usarRestaurador() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item restaurador = new Restaurador();
		Algomon jigglypuff = new Jigglypuff();
		Algomon charmander = new Charmander();
		charmander.recibirDanio(jigglypuff.ataque("Canto"),jigglypuff);
		charmander.usarItem(restaurador);
		assertTrue(charmander.estaEnEstadoNormal());
		jigglypuff.recibirDanio(charmander.ataque("Fogonazo"), charmander);
		jigglypuff.usarItem(restaurador);
		assertTrue(jigglypuff.estaEnEstadoNormal());
	}

	@Test
	public void usarVitamina() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException {
		Item vitamina = new Vitamina();
		Algomon squirtle1 = new Squirtle();
		Algomon squirtle2 = new Squirtle();
		ArrayList<Ataque> listaDeAtaques = squirtle1.ObtenerTodosLosAtaques();
		ArrayList<Ataque> listaDeAtaques2 = squirtle2.ObtenerTodosLosAtaques();
		squirtle1.usarItem(vitamina);
		for (int i = 0; i < listaDeAtaques.size(); i++){
			assertEquals(listaDeAtaques.get(i).getCantidad(),listaDeAtaques2.get(i).getCantidad()+2);
		}
	}

	@Test
	public void usarPocionMasDe4Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException{
		Item pocion = new Pocion();
		Algomon squirtle = new Squirtle();
		Algomon rattata = new Rattata();
		for (int i = 1; i < 6; i++){
			rattata.recibirDanio(squirtle.ataque("Canion de Agua"), squirtle);
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
	public void usarSuperPocionMasDe2Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException{
		Item superPocion = new SuperPocion();
		Algomon squirtle = new Squirtle();
		Algomon charmander = new Charmander();
		for (int i = 1; i < 3; i++){
			charmander.recibirDanio(squirtle.ataque("Canion de Agua"), squirtle);
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
	public void usarRestauradorMasDe3Veces() throws SinPuntosDePoderException, EstaDormidoException, SinUsosDisponiblesException{
		Item restaurador = new Restaurador();
		Algomon jigglypuff = new Jigglypuff();
		Algomon charmander = new Charmander();
		for (int i = 1; i < 4; i++){
			charmander.recibirDanio(jigglypuff.ataque("Canto"), jigglypuff);
			try{
				charmander.usarItem(restaurador);
			}
			catch(SinUsosDisponiblesException e){
				assertTrue(false);
			}
		}

		for (int j = 1; j < 4; j++){
			jigglypuff.recibirDanio(charmander.ataque("Fogonazo"), charmander);
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
