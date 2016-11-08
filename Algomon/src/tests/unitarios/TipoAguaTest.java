package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.TipoAgua;
import Modelo.TipoFuego;
import Modelo.TipoNormal;
import Modelo.TipoPlanta;

public class TipoAguaTest {
	@Test
	public void RespuestaFrenteFuego(){
		TipoAgua unTipo = new TipoAgua();
		TipoFuego TipoFuego = new TipoFuego();
		assertEquals(unTipo.reaccionATipo(TipoFuego), 0.5,0.0001D);	
	}
	@Test
	public void RespuestaFrenteAgua(){
		TipoAgua unTipo = new TipoAgua();
		TipoAgua TipoAgua = new TipoAgua();
		assertEquals(unTipo.reaccionATipo(TipoAgua), 0.5,0.0001D);
	}
	@Test
	public void RespuestaFrentePlanta(){
		TipoAgua unTipo = new TipoAgua();
		TipoPlanta TipoPlanta = new TipoPlanta();
		assertEquals(unTipo.reaccionATipo(TipoPlanta), 2.0,0.0001D);
	}
	@Test
	public void RespuestaFrenteNormal(){
		TipoAgua unTipo = new TipoAgua();
		TipoNormal TipoNormal = new TipoNormal();
		assertEquals(unTipo.reaccionATipo(TipoNormal), 1.0,0.0001D);
	}
}
