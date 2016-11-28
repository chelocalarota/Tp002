package tests.integradores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
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

public class AtaqueSimplesTest {

	@Test
	public void test01SquirtleAtacaConBurbujaYConCanionDeAguaYLeQuita20y40DeVidaACharmander() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException {
		Algomon Squirtle = new Squirtle();
		Algomon Charmander = new Charmander();
		double vida = Charmander.getVida();
		Charmander.recibirDanio(Squirtle.ataque(AtaquesEnum.BURBUJA),Squirtle);

		assertEquals((vida-20), Charmander.getVida(),0.001D);


		vida -= 20;
		Charmander.recibirDanio(Squirtle.ataque(AtaquesEnum.CANION_DE_AGUA),Squirtle);

		Assert.assertTrue((vida-40) == Charmander.getVida());

	}

	@Test
	public void test02SquirtleAtacaConBurbujaYConCanionDeAguaABulbasaurYLeQuita5y10DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Algomon Squirtle = new Squirtle();
		Algomon Bulbasaur = new Bulbasaur();
		double vida = Bulbasaur.getVida();
		Bulbasaur.recibirDanio(Squirtle.ataque(AtaquesEnum.BURBUJA),Squirtle);

		assertEquals((vida-5), Bulbasaur.getVida(),0.001D);

		vida -= 5;
		Bulbasaur.recibirDanio(Squirtle.ataque(AtaquesEnum.CANION_DE_AGUA),Squirtle);

		assertEquals((vida-10), Bulbasaur.getVida(),0.001D);

	}
	@Test
	public void test03SquirtleAtacaConBurbujaYConCanionDeAguaALosOtrosAlgomonesYLesQuita10y20DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Algomon Squirtle = new Squirtle();
		Algomon Chansey = new Chansey();
		double vida = Chansey.getVida();


		Chansey.recibirDanio(Squirtle.ataque(AtaquesEnum.BURBUJA),Squirtle);

		assertEquals((vida-10), Chansey.getVida(),0.001D);

		vida -= 10;
		Chansey.recibirDanio(Squirtle.ataque(AtaquesEnum.CANION_DE_AGUA),Squirtle);

		assertEquals((vida-20), Chansey.getVida(),0.001D);

		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();


		Jigglypuff.recibirDanio(Squirtle.ataque(AtaquesEnum.BURBUJA),Squirtle);

		assertEquals((vida-10), Jigglypuff.getVida(),0.001D);

		vida -= 10;
		Jigglypuff.recibirDanio(Squirtle.ataque(AtaquesEnum.CANION_DE_AGUA),Squirtle);

		assertEquals((vida-20), Jigglypuff.getVida(),0.001D);

		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();


		Rattata.recibirDanio(Squirtle.ataque(AtaquesEnum.BURBUJA),Squirtle);

		assertEquals((vida-10), Rattata.getVida(),0.001D);

		vida -= 10;
		Rattata.recibirDanio(Squirtle.ataque(AtaquesEnum.CANION_DE_AGUA),Squirtle);

		assertEquals((vida-20), Rattata.getVida(),0.001D);

	}

	@Test
	public void test04BulbasaurYChanseyAtacanConLátigoCepaASquirtleYLeQuitan30DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Squirtle = new Squirtle();
		Algomon Chansey = new Chansey();
		Algomon Bulbasaur = new Bulbasaur();

		double vida = Squirtle.getVida();

		Squirtle.recibirDanio(Chansey.ataque(AtaquesEnum.LATIGO_CEPA),Chansey);

		assertEquals((vida-30.0), Squirtle.getVida(),0.001D);

		vida -= 30.0;

		Squirtle.recibirDanio(Bulbasaur.ataque(AtaquesEnum.LATIGO_CEPA),Bulbasaur);

		assertEquals((vida-30.0), Squirtle.getVida(),0.001D);
	}

	@Test
	public void test05BulbasaurYChanseyAtacanConLátigoCepaACharmanderYLeQuitan7DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Charmander = new Charmander();
		Algomon Bulbasaur = new Bulbasaur();
		Algomon Chansey = new Chansey();

		double vida = Charmander.getVida();

		Charmander.recibirDanio(Chansey.ataque(AtaquesEnum.LATIGO_CEPA),Chansey);

		assertEquals((vida-7), Charmander.getVida(),0.001D);

		vida -= 7;

		Charmander.recibirDanio(Bulbasaur.ataque(AtaquesEnum.LATIGO_CEPA),Bulbasaur);

		assertEquals((vida-7), Charmander.getVida(),0.001D);
	}


	@Test
	public void test06SBulbasaurYChanseyAtacanConLátigoCepaAOtrosAlgomonesYLesQuitan15DeVidaACadaUno() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Algomon Bulbasaur = new Bulbasaur();
		Algomon Chansey = new Chansey();;


		double vida = Chansey.getVida();

		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();


		Jigglypuff.recibirDanio(Chansey.ataque(AtaquesEnum.LATIGO_CEPA),Chansey);;

		assertEquals((vida-15), Jigglypuff.getVida(),0.001D);

		vida -= 15;
		Jigglypuff.recibirDanio(Bulbasaur.ataque(AtaquesEnum.LATIGO_CEPA),Bulbasaur);;

		assertEquals((vida-15), Jigglypuff.getVida(),0.001D);

		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();



		Rattata.recibirDanio(Chansey.ataque(AtaquesEnum.LATIGO_CEPA),Chansey);;

		assertEquals((vida-15), Rattata.getVida(),0.001D);

		vida -= 15;
		Rattata.recibirDanio(Bulbasaur.ataque(AtaquesEnum.LATIGO_CEPA),Bulbasaur);;

		assertEquals((vida-15), Rattata.getVida(),0.001D);


	}

	@Test
	public void test07CharmanderAtacaConBrasasABulbasaurYLeQuita32DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Charmander = new Charmander();
		Algomon Bulbasaur = new Bulbasaur();

		double vida = Bulbasaur.getVida();

		Bulbasaur.recibirDanio(Charmander.ataque(AtaquesEnum.BRASAS),Charmander);

		assertEquals((vida-32), Bulbasaur.getVida(),0.001D);

	}

	@Test
	public void test08CharmanderAtacaConBrasasASquirtleYLeQuita8DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{

		Algomon Charmander = new Charmander();
		Algomon Squirtle = new Squirtle();

		double vida = Squirtle.getVida();

		Squirtle.recibirDanio(Charmander.ataque(AtaquesEnum.BRASAS),Charmander);

		assertEquals((vida-8), Squirtle.getVida(),0.001D);

	}

	@Test
	public void test09CharmanderAtacaConBrasasAOtrosAlgomonesYLesQuita16DeVida() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Algomon Charmander = new Charmander();;
		Algomon Chansey = new Chansey();
		double vida = Chansey.getVida();


		Chansey.recibirDanio(Charmander.ataque(AtaquesEnum.BRASAS),Charmander);

		assertEquals((vida-16), Chansey.getVida(),0.001D);

		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();


		Jigglypuff.recibirDanio(Charmander.ataque(AtaquesEnum.BRASAS),Charmander);

		assertEquals((vida-16), Jigglypuff.getVida(),0.001D);

		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();


		Rattata.recibirDanio(Charmander.ataque(AtaquesEnum.BRASAS),Charmander);

		assertEquals((vida-16), Rattata.getVida(),0.001D);


	}
	@Test
	public void test10AlgomonesAtacanConAtaqueRápidoYQuitan10DeVidaAOtrosAlgomones() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		List<Algomon> TodosLosAlgomones = new ArrayList<Algomon>();
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Rattata = new Rattata();
		Algomon Chansey = new Chansey();

		TodosLosAlgomones.add(new Chansey());
		TodosLosAlgomones.add(new Rattata());
		TodosLosAlgomones.add(new Bulbasaur());
		TodosLosAlgomones.add(new Charmander());
		TodosLosAlgomones.add(new Squirtle());
		TodosLosAlgomones.add(Rattata);
		TodosLosAlgomones.add(Chansey);
		TodosLosAlgomones.add(Jigglypuff);

		for(Algomon atacado : TodosLosAlgomones){
			double vida = atacado.getVida();
			atacado.recibirDanio(Rattata.ataque(AtaquesEnum.ATAQUE_RAPIDO),Rattata);

			assertEquals((vida-10), atacado.getVida(),0.001D);

			vida -= 10;

			atacado.recibirDanio(Jigglypuff.ataque(AtaquesEnum.ATAQUE_RAPIDO),Jigglypuff);

			assertEquals((vida-10), atacado.getVida(),0.001D);

			vida -= 10;

			atacado.recibirDanio(Chansey.ataque(AtaquesEnum.ATAQUE_RAPIDO),Chansey);

			assertEquals((vida-10), atacado.getVida(),0.001D);

		}
	}
	@Test
	public void test11AlgomonesAgotanLaCantidadDisponibleAtaqueYNoPuedenVolverAUtilizarlo() throws EstaDormidoException, PokemonMuertoException{
		List<Algomon> TodosLosAlgomones = new ArrayList<Algomon>();
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Rattata = new Rattata();
		Algomon Chansey = new Chansey();
		TodosLosAlgomones.add(new Chansey());
		TodosLosAlgomones.add(new Rattata());
		TodosLosAlgomones.add(new Bulbasaur());
		TodosLosAlgomones.add(new Charmander());
		TodosLosAlgomones.add(new Squirtle());
		TodosLosAlgomones.add(Rattata);
		TodosLosAlgomones.add(Chansey);
		TodosLosAlgomones.add(Jigglypuff);
		for(Algomon atacado : TodosLosAlgomones){
			for(int i = 0; i< 17; i++){
				try {
					Rattata.recibirDanio(atacado.ataque(AtaquesEnum.ATAQUE_RAPIDO),Rattata);
					Rattata.cambiarVida(200);
				} catch (SinPuntosDePoderException e) {
					assertTrue(true);
				}
			}
		}
	}

}
