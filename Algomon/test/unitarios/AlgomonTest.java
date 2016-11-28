package tests.unitarios;

import static org.junit.Assert.*;

import java.util.ArrayList;

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
import modelo.ataques.Ataque;
import modelo.ataques.Canto;
import modelo.ataques.Fogonazo;
import modelo.tipos.Tipo;

public class AlgomonTest {

	@Test
	public void test01CambiarVidaOriginalAlgomonConValorNeutro() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();

		int valorDelCambio = 0;

		unAlgomon.cambiarVida(valorDelCambio);

		assertEquals(vidaOriginal - valorDelCambio, unAlgomon.getVida());

	}
	@Test
	public void test02CambiarVidaOriginalAlgomonConValorPositivo() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();

		int valorDelCambio = 2;

		unAlgomon.cambiarVida(valorDelCambio);

		assertEquals(vidaOriginal, unAlgomon.getVida());

	}
	@Test
	public void test03CambiarVidaOriginalAlgomonConValorNegativ() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();

		int valorDelCambio = -3;

		unAlgomon.cambiarVida(valorDelCambio);

		assertEquals(vidaOriginal + valorDelCambio, unAlgomon.getVida());

	}
	@Test
	public void test04CambiarVidaOriginalAlgomonConValorNegativ() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();

		int primerValorDelCambio = -3;
		int segundoValorDelCambio = 2;

		unAlgomon.cambiarVida(primerValorDelCambio);
		unAlgomon.cambiarVida(segundoValorDelCambio);

		assertEquals(vidaOriginal + primerValorDelCambio + segundoValorDelCambio, unAlgomon.getVida());
	}

	@Test
	public void test05VerificarSiEstaMuerto() throws PokemonMuertoException{
		Algomon unAlgomon = new Charmander();

		int vidaOriginal = unAlgomon.getVida();

		assertFalse(unAlgomon.estaMuerto());

		try {
			unAlgomon.cambiarVida(-vidaOriginal);
		} catch (PokemonMuertoException e) {
			assertTrue(true);
		}
	}


	@Test
	public void test06RecibirDanioDisminuyeVidaDelAlgomon() throws SinPuntosDePoderException, EstaDormidoException, PokemonMuertoException{
		Algomon unAlgomon = new Charmander();
		Algomon otroAlgomon = new Squirtle();

		ArrayList<Ataque> ataquesAlgomon = unAlgomon.obtenerTodosLosAtaques();
		Ataque ataque = ataquesAlgomon.get(0);

		Tipo tipoOtroAlgomon = otroAlgomon.getTipo();
		Tipo tipoAtacante = ataque.getTipo();

		double multiplicador =  tipoOtroAlgomon.reaccionATipo(tipoAtacante);
		double danioResultante = ataque.getPotencia()*multiplicador;

		int vidaOriginalOtroAlgomon = otroAlgomon.getVida();
		otroAlgomon.recibirDanio(ataque, unAlgomon);

		int vidaFinalOtroAlgomon = otroAlgomon.getVida();
		assertEquals(vidaFinalOtroAlgomon, vidaOriginalOtroAlgomon -(int)danioResultante);

	}

	@Test
	public void test07AlgomonEmpiezaEnEstadoNormal() {
		ArrayList<Algomon> algomones = new ArrayList<Algomon>();
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		Jigglypuff jigglypuff = new Jigglypuff();

		algomones.add(charmander);
		algomones.add(chansey);
		algomones.add(squirtle);
		algomones.add(bulbasaur);
		algomones.add(jigglypuff);
		algomones.add(rattata);

		for (Algomon algomon : algomones){
			assertTrue(algomon.estaEnEstadoNormal());
		}
	}

	@Test
	public void test08AlgomonCambiaEstadoNormalAQuemadoConFogonazo() throws PokemonMuertoException {
		ArrayList<Algomon> algomones = new ArrayList<Algomon>();
		Charmander charmanderAtacante = new Charmander();
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		Jigglypuff jigglypuff = new Jigglypuff();

		algomones.add(charmander);
		algomones.add(chansey);
		algomones.add(squirtle);
		algomones.add(bulbasaur);
		algomones.add(jigglypuff);
		algomones.add(rattata);

		Ataque fogonazo = new Fogonazo();

		for (Algomon algomon : algomones){

			algomon.recibirDanio(fogonazo, charmanderAtacante);

			assertFalse(algomon.estaEnEstadoNormal());
		}
	}

	@Test
	public void test09AlgomonCambiaEstadoNormalADormidoConCanto() throws PokemonMuertoException {
		ArrayList<Algomon> algomones = new ArrayList<Algomon>();
		Jigglypuff jigglypuffAtacante = new Jigglypuff();
		Charmander charmander = new Charmander();
		Squirtle squirtle = new Squirtle();
		Chansey chansey = new Chansey();
		Rattata rattata = new Rattata();
		Bulbasaur bulbasaur = new Bulbasaur();
		Jigglypuff jigglypuff = new Jigglypuff();

		algomones.add(charmander);
		algomones.add(chansey);
		algomones.add(squirtle);
		algomones.add(bulbasaur);
		algomones.add(jigglypuff);
		algomones.add(rattata);

		Ataque canto = new Canto();

		for (Algomon algomon : algomones){

			algomon.recibirDanio(canto, jigglypuffAtacante);

			assertFalse(algomon.estaEnEstadoNormal());
		}
	}

}
