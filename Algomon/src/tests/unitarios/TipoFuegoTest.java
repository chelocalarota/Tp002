package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.TipoAgua;
import Modelo.TipoFuego;
import Modelo.TipoNormal;
import Modelo.TipoPlanta;

public class TipoFuegoTest {
	@Test
	public void RespuestaFrenteFuego(){
		TipoFuego unTipo = new TipoFuego();
		TipoFuego TipoFuego = new TipoFuego();
		assertEquals(unTipo.reaccionATipo(TipoFuego), 0.5,0.00001D);	
	}
	@Test
	public void RespuestaFrenteAgua(){
		TipoFuego unTipo = new TipoFuego();
		TipoAgua TipoAgua = new TipoAgua();
		assertEquals(unTipo.reaccionATipo(TipoAgua), 2.0,0.00001D);
	}
	@Test
	public void RespuestaFrentePlanta(){
		TipoFuego unTipo = new TipoFuego();
		TipoPlanta TipoPlanta = new TipoPlanta();
		assertEquals(unTipo.reaccionATipo(TipoPlanta), 0.5,0.00001D);
	}
	@Test
	public void RespuestaFrenteNormal(){
		TipoFuego unTipo = new TipoFuego();
		TipoNormal TipoNormal = new TipoNormal();
		assertEquals(unTipo.reaccionATipo(TipoNormal), 1.0,0.00001D);
	}
}