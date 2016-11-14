package tests.unitarios;

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
import modelo.algomon.Rattata;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.Squirtle;
import modelo.enums.AtaquesEnum;

public class AtaquesEspecialesTest {

	@Test
	public void test01JigglypuffYChanseyPuebanCantoConEstadoDormido() throws SinPuntosDePoderException, EstaDormidoException {
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
	public void test02UnAlgomonDormidoNoPuedeAtacarPorTresTurnos() throws SinPuntosDePoderException{
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
	public void test03ChupaVidasBulbasaurVsCharmander() throws SinPuntosDePoderException, EstaDormidoException{

		Algomon Bulbasaur = new Bulbasaur();
		Algomon Charmander = new Charmander();

		int vidaBulbasaur = Bulbasaur.getVida();
		int vidaCharmander = Charmander.getVida();

		Charmander.recibirDanio(Bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS),Bulbasaur);

		assertEquals(vidaCharmander - 7,Charmander.getVida());
		assertEquals(vidaBulbasaur+2,Bulbasaur.getVida());
	}
	@Test
	public void test04ChupaVidasBulbasaurVsSquirtle() throws SinPuntosDePoderException, EstaDormidoException{

		Algomon Bulbasaur = new Bulbasaur();
		Algomon Squirtle = new Squirtle();

		int vidaBulbasor = Bulbasaur.getVida();
		int vidaSquirtle = Squirtle.getVida();

		Squirtle.recibirDanio(Bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS),Bulbasaur);

		assertEquals(vidaSquirtle - 30,Squirtle.getVida());
		assertEquals(vidaBulbasor+9,Bulbasaur.getVida());
	}

	@Test
	public void test05ChupaVidasBulbasaurVsOtrosAlgomones() throws SinPuntosDePoderException, EstaDormidoException{

		Algomon Bulbasaur = new Bulbasaur();
		List<Algomon> OtrosAlgomones = new ArrayList<Algomon>();

		OtrosAlgomones.add(new Jigglypuff());
		OtrosAlgomones.add(new Rattata());
		OtrosAlgomones.add(new Chansey());

		for(Algomon atacado : OtrosAlgomones){

			int vidaBulbasor = Bulbasaur.getVida();
			int vidaAtacado = atacado.getVida();

			atacado.recibirDanio(Bulbasaur.ataque(AtaquesEnum.CHUPAVIDAS),Bulbasaur);

			assertEquals(vidaAtacado - 15,atacado.getVida());
			assertEquals(vidaBulbasor + 4,Bulbasaur.getVida());

		}

	}
	@Test
	public void test06CharmanderYRattataAtacanConFogonazo()throws SinPuntosDePoderException, EstaDormidoException{

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
