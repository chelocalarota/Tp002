package tests.unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Modelo.Algomon.Algomon;
import Modelo.Algomon.Bulbasaur;
import Modelo.Algomon.Chansey;
import Modelo.Algomon.Charmander;
import Modelo.Algomon.EstaDormidoException;
import Modelo.Algomon.Jigglypuff;
import Modelo.Algomon.Rattata;
import Modelo.Algomon.SinPuntosDePoderException;
import Modelo.Algomon.Squirtle;

public class AtaquesEspecialesTest {

	@Test
	public void JigglypuffYChanseyPuebanCantoConEstadoDormido() throws SinPuntosDePoderException, EstaDormidoException {
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Chansey = new Chansey();
		List<Algomon> TodosLosAlgomones = new ArrayList<Algomon>();
		TodosLosAlgomones.add(new Rattata());
		TodosLosAlgomones.add(new Bulbasaur());
		TodosLosAlgomones.add(new Charmander());
		TodosLosAlgomones.add(new Squirtle());
		
		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Jigglypuff.ataque("Canto"),Jigglypuff);
			assertEquals(false, atacado.estaEnEstadoNormal());
		}
		
		for(Algomon atacado : TodosLosAlgomones){
			atacado.recibirDanio(Chansey.ataque("Canto"),Chansey);
			assertEquals(false, atacado.estaEnEstadoNormal());
		}
		
	}
	
	@Test
	public void UnAlgomonDormidoNoPuedeAtacarPorTresTurnos() throws SinPuntosDePoderException{
		Algomon Jigglypuff = new Jigglypuff();
		Algomon Chansey = new Chansey();
		try {
			Jigglypuff.recibirDanio(Chansey.ataque("Canto"),Chansey);
		} catch (EstaDormidoException e) {
			e.printStackTrace();
		}
		try {
			 Jigglypuff.ataque("Ataque Rapido");
		}
		catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque("Ataque Rapido");
		}catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque("Ataque Rapido");
		}catch (EstaDormidoException e){
			assertTrue(true);
		}
		try {
			Jigglypuff.ataque("Ataque Rapido");
		}catch (EstaDormidoException e){
			assertTrue(false);
	}
	}	
	@Test
	public void ChupaVidasTest() throws SinPuntosDePoderException, EstaDormidoException{
		Algomon Bulbasaur = new Bulbasaur();
		Algomon Charmander = new Charmander();
		int vida = Bulbasaur.getVida();
		Charmander.recibirDanio(Bulbasaur.ataque("Chupavidas"),Bulbasaur);
		assertEquals(vida+2,Bulbasaur.getVida());
	}
	
}
