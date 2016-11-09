package tests.unitarios;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.Bulbasaur;
import Modelo.Algomon.Chansey;
import Modelo.Algomon.Charmander;
import Modelo.Algomon.Jigglypuff;
import Modelo.Algomon.Rattata;
import Modelo.Algomon.Squirtle;

public class AtaqueSimplesTest {

	@Test
	public void test01SquirtleVsCharmander() {
		Algomon Squirtle = new Squirtle();
		Algomon Charmander = new Charmander();
		double vida = Charmander.getVida();
		Charmander.recibirDanio(Squirtle.ataque("Burbuja"));
		
		assertEquals((vida-20), Charmander.getVida(),0.001D);
		
		
		vida -= 20;
		Charmander.recibirDanio(Squirtle.ataque("Canion de Agua"));
		
		Assert.assertTrue((vida-40) == Charmander.getVida());
		
	}
	
	@Test
	public void test02SquirtleVsBulbasaur(){
		Algomon Squirtle = new Squirtle();
		Algomon Bulbasaur = new Bulbasaur();
		double vida = Bulbasaur.getVida();
		Bulbasaur.recibirDanio(Squirtle.ataque("Burbuja"));
		
		assertEquals((vida-5), Bulbasaur.getVida(),0.001D);
		
		vida -= 5;
		Bulbasaur.recibirDanio(Squirtle.ataque("Canion de Agua"));
		
		assertEquals((vida-10), Bulbasaur.getVida(),0.001D);
		
	}
	@Test
	public void test03SquirtleVsOtrosAlgomones(){
		Algomon Squirtle = new Squirtle();
		Algomon Chansey = new Chansey();
		double vida = Chansey.getVida();
		
		
		Chansey.recibirDanio(Squirtle.ataque("Burbuja"));
		
		assertEquals((vida-10), Chansey.getVida(),0.001D);
		
		vida -= 10;
		Chansey.recibirDanio(Squirtle.ataque("Canion de Agua"));
		
		assertEquals((vida-20), Chansey.getVida(),0.001D);

		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();
		
		
		Jigglypuff.recibirDanio(Squirtle.ataque("Burbuja"));
		
		assertEquals((vida-10), Jigglypuff.getVida(),0.001D);
		
		vida -= 10;
		Jigglypuff.recibirDanio(Squirtle.ataque("Canion de Agua"));
		
		assertEquals((vida-20), Jigglypuff.getVida(),0.001D);
		
		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();
		
		
		Rattata.recibirDanio(Squirtle.ataque("Burbuja"));
		
		assertEquals((vida-10), Rattata.getVida(),0.001D);
		
		vida -= 10;
		Rattata.recibirDanio(Squirtle.ataque("Canion de Agua"));
		
		assertEquals((vida-20), Rattata.getVida(),0.001D);
		
	}
	
	@Test
	public void test04BalbasauryChanseyVsSquirtle(){
		
		Algomon Squirtle = new Squirtle();
		Algomon Chansey = new Chansey();
		Algomon Bulbasaur = new Bulbasaur();
		
		double vida = Squirtle.getVida();
		
		Squirtle.recibirDanio(Chansey.ataque("Latigo Cepa"));
		
		assertEquals((vida-30.0), Squirtle.getVida(),0.001D);
		
		vida -= 30.0;
		
		Squirtle.recibirDanio(Bulbasaur.ataque("Latigo Cepa"));
		
		assertEquals((vida-30.0), Squirtle.getVida(),0.001D);
	}
	
	@Test 
	public void test05BalbasauryChanseyVsCharmander(){
		
		Algomon Charmander = new Charmander();
		Algomon Bulbasaur = new Bulbasaur();
		Algomon Chansey = new Chansey();
		
		double vida = Charmander.getVida();
		
		Charmander.recibirDanio(Chansey.ataque("Latigo Cepa"));
		
		assertEquals((vida-7.5), Charmander.getVida(),0.001D);
		
		vida -= 7.5;
		
		Charmander.recibirDanio(Bulbasaur.ataque("Latigo Cepa"));
		
		assertEquals((vida-7.5), Charmander.getVida(),0.001D);
	}
	
	
	@Test
	public void test06SquirtleVsOtrosAlgomones(){
		Algomon Bulbasaur = new Bulbasaur();
		Algomon Chansey = new Chansey();;
		
		
		double vida = Chansey.getVida();
		
		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();
		
		
		Jigglypuff.recibirDanio(Chansey.ataque("Latigo Cepa"));;
		
		assertEquals((vida-15), Jigglypuff.getVida(),0.001D);
		
		vida -= 15;
		Jigglypuff.recibirDanio(Bulbasaur.ataque("Latigo Cepa"));;
		
		assertEquals((vida-15), Jigglypuff.getVida(),0.001D);
		
		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();
		
		
		
		Rattata.recibirDanio(Chansey.ataque("Latigo Cepa"));;
		
		assertEquals((vida-15), Rattata.getVida(),0.001D);
		
		vida -= 15;
		Rattata.recibirDanio(Bulbasaur.ataque("Latigo Cepa"));;
		
		assertEquals((vida-15), Rattata.getVida(),0.001D);
		
		
	}
	
	@Test
	public void test07CharmanderVsBulbasaur(){
		
		Algomon Charmander = new Charmander();
		Algomon Bulbasaur = new Bulbasaur();
		
		double vida = Bulbasaur.getVida();
		
		Bulbasaur.recibirDanio(Charmander.ataque("Brasas"));
		
		assertEquals((vida-32), Bulbasaur.getVida(),0.001D);
		
	}
	
	@Test
	public void test08CharmanderVsSquirtle(){
		
		Algomon Charmander = new Charmander();
		Algomon Squirtle = new Squirtle();
		
		double vida = Squirtle.getVida();
		
		Squirtle.recibirDanio(Charmander.ataque("Brasas"));
		
		assertEquals((vida-8), Squirtle.getVida(),0.001D);
		
	}
	
	@Test
	public void test09CharmanderVsOtrosAlgomones(){
		Algomon Charmander = new Charmander();;
		Algomon Chansey = new Chansey();
		double vida = Chansey.getVida();
		
		
		Chansey.recibirDanio(Charmander.ataque("Brasas"));
		
		assertEquals((vida-16), Chansey.getVida(),0.001D);

		Algomon Jigglypuff = new Jigglypuff();
		vida = Jigglypuff.getVida();
		
		
		Jigglypuff.recibirDanio(Charmander.ataque("Brasas"));
		
		assertEquals((vida-16), Jigglypuff.getVida(),0.001D);
		
		Algomon Rattata = new Rattata();
		vida = Rattata.getVida();
		
		
		Rattata.recibirDanio(Charmander.ataque("Brasas"));
		
		assertEquals((vida-16), Rattata.getVida(),0.001D);
	
		
	}
	@Test
	public void test10AlgomonesAtacanConAtaqueRapido(){
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
			atacado.recibirDanio(Rattata.ataque("Ataque Rapido"));
			
			assertEquals((vida-10), atacado.getVida(),0.001D);
			
			vida -= 10;
			
			atacado.recibirDanio(Jigglypuff.ataque("Ataque Rapido"));

			assertEquals((vida-10), atacado.getVida(),0.001D);
			
			vida -= 10;
			
			atacado.recibirDanio(Chansey.ataque("Ataque Rapido"));
		
			assertEquals((vida-10), atacado.getVida(),0.001D);
	
		}
	}
	@Test
	public void test11AlgomonesAgotanCantidadDeAtaques(){
		
	}

}
