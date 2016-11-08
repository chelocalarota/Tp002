package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.TipoAgua;
import Modelo.TipoFuego;
import Modelo.TipoNormal;
import Modelo.TipoPlanta;

public class TipoPlantaTest {
	@Test
	public void RespuestaFrenteFuego(){
		TipoPlanta unTipo = new TipoPlanta();
		TipoFuego TipoFuego = new TipoFuego();
		assertEquals(unTipo.reaccionATipo(TipoFuego), 2.0,0.0001D);	
	}
	@Test
	public void RespuestaFrenteAgua(){
		TipoPlanta unTipo = new TipoPlanta();
		TipoAgua TipoAgua = new TipoAgua();
		assertEquals(unTipo.reaccionATipo(TipoAgua), 0.5 ,0.0001D);
	}
	@Test
	public void RespuestaFrentePlanta(){
		TipoPlanta unTipo = new TipoPlanta();
		TipoPlanta TipoPlanta = new TipoPlanta();
		assertEquals(unTipo.reaccionATipo(TipoPlanta), 0.5,0.0001D);
	}
	@Test
	public void RespuestaFrenteNormal(){
		TipoPlanta unTipo = new TipoPlanta();
		TipoNormal TipoNormal = new TipoNormal();
		assertEquals(unTipo.reaccionATipo(TipoNormal), 1.0,0.0001D);
	}
}