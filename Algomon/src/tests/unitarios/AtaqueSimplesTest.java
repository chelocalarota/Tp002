package tests.unitarios;

import static org.junit.Assert.assertEquals;

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
		Squirtle.recibirDanio(Bulbasaur.ataque("Latigo Cepa"));
		assertEquals((vida-60), Squirtle.getVida(),0.001D);
	}

}
