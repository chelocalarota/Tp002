package tests.integradores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import modelo.algomon.Algomon;
import modelo.algomon.Bulbasaur;
import modelo.algomon.Chansey;
import modelo.algomon.Charmander;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.Jigglypuff;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.Rattata;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.Squirtle;
import modelo.enums.AtaquesEnum;

public class AtaquesEspecialesTest {

	@Test
	public void test01JigglypuffYChanseyPuebanCantoConEstadoDormido() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException {
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Chansey = new Chansey();
		List<Algomon> TodosLosAlgomones = new ArrayList<Algomon>();
		TodosLosAlgomones.add(new Rattata());
		TodosLosAlgomones.add(new Bulbasaur());
		TodosLosAlgomones.add(new Charmander());
		TodosLosAlgomones.add(new Squirtle());

		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Jigglypuff.ataque(AtaquesEnum.CANTO),Jigglypuff);
			assertFalse(atacado.estaEnEstadoNormal());
		}

		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Chansey.ataque(AtaquesEnum.CANTO),Chansey);
			assertFalse(atacado.estaEnEstadoNormal());
		}

	}

	@Test
	public void test02UnAlgomonDormidoNoPuedeAtacarPorTresTurnos() throws SinPuntosDePoderException, PokemonMuertoException{
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Chansey = new Chansey();
		try {
			Jigglypuff.recibirDanio(Chansey.ataque(AtaquesEnum.CANTO),Chansey);
		} catch (EstaDormidoException e) {
			e.printStackTrace();
			fail("no deberia haber pasado por aca");
		}
		try {
			 Jigglypuff.ataque(AtaquesEnum.ATAQUE_RAPIDO);
		}
		catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque(AtaquesEnum.ATAQUE_RAPIDO);
		}catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque(AtaquesEnum.ATAQUE_RAPIDO);
		}catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque(AtaquesEnum.ATAQUE_RAPIDO);
		}catch (EstaDormidoException e){
			assertTrue(false);
	}
	}
	@Test
	public void test03ChupaVidasBulbasaurVsCharmander() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Bulbasaur = new Bulbasaur();
		Algomon Charmander = new Charmander();

		int vidaBulbasaur = Bulbasaur.getVida();
		int vidaCharmander = Charmander.getVida();
		
		Bulbasaur.cambiarVida(-20);
		Charmander.recibirDanio(Bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS),Bulbasaur);
		vidaBulbasaur = vidaBulbasaur -20 + 2;
		assertEquals(vidaCharmander - 7, Charmander.getVida());
		assertEquals(vidaBulbasaur, Bulbasaur.getVida());
	}
	@Test
	public void test04ChupaVidasBulbasaurVsSquirtle() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Bulbasaur = new Bulbasaur();
		Algomon Squirtle = new Squirtle();

		int vidaBulbasor = Bulbasaur.getVida();
		int vidaSquirtle = Squirtle.getVida();

		Bulbasaur.cambiarVida(-20);
		Squirtle.recibirDanio(Bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS),Bulbasaur);
		vidaBulbasor = vidaBulbasor - 20 + 9;

		assertEquals(vidaSquirtle - 30, Squirtle.getVida());
		assertEquals(vidaBulbasor, Bulbasaur.getVida());
	}

	@Test
	public void test05ChupaVidasBulbasaurVsOtrosAlgomones() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon bulbasaur = new Bulbasaur();
		List<Algomon> otrosAlgomones = new ArrayList<Algomon>();

		otrosAlgomones.add(new Jigglypuff());
		otrosAlgomones.add(new Rattata());
		otrosAlgomones.add(new Chansey());

		for(Algomon atacado : otrosAlgomones){

			int vidaAtacado = atacado.getVida();
			bulbasaur.cambiarVida(-10);

			atacado.recibirDanio(bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS), bulbasaur);
			int vidaBulbasaur = bulbasaur.getVida();
			

			assertEquals(vidaAtacado - 15, atacado.getVida());
			assertEquals(vidaBulbasaur, bulbasaur.getVida());

		}

	}
	@Test
	public void test06CharmanderYRattataAtacanConFogonazo()throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Charmander = new Charmander();
		Algomon Rattata = new Rattata();

		Algomon Squirtle = new Squirtle();

		int diezporcientoVidaOriginal = (int)(Squirtle.getVida() * 0.1);

		Squirtle.recibirDanio(Charmander.ataque(AtaquesEnum.FOGONAZO), Charmander);



		for(int i = 0; i<4 ; i++){

			int vida = Squirtle.getVida();

			Squirtle.ataque(AtaquesEnum.BURBUJA);

			assertEquals(vida - diezporcientoVidaOriginal,Squirtle.getVida());
		}

		Squirtle.recibirDanio(Rattata.ataque(AtaquesEnum.FOGONAZO), Rattata);

		for(int i = 0; i<4 ; i++){

			int vida = Squirtle.getVida();

			Squirtle.ataque(AtaquesEnum.BURBUJA);

			assertEquals(vida - diezporcientoVidaOriginal,Squirtle.getVida());
		}
	}

}
