package tests.unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.Bulbasaur;
import Modelo.Algomon.Chansey;
import Modelo.Algomon.Charmander;
import Modelo.Algomon.Jigglypuff;
import Modelo.Algomon.Rattata;
import Modelo.Algomon.Squirtle;

public class AtaquesEspecialesTest {

	@Test
	public void JigglypuffYChanseyPuebanCantoConEstadoDormido() {
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Chansey = new Chansey();
		List<Algomon> TodosLosAlgomones = new ArrayList<Algomon>();
		TodosLosAlgomones.add(new Rattata());
		TodosLosAlgomones.add(new Bulbasaur());
		TodosLosAlgomones.add(new Charmander());
		TodosLosAlgomones.add(new Squirtle());
		
		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Jigglypuff.ataque("Canto"));
			assertEquals(false, atacado.estaEnEstadoNormal());
		}
		
		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Chansey.ataque("Canto"));
			assertEquals(false, atacado.estaEnEstadoNormal());
		}
	}

}
