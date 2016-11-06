package Tests.tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.TipoAgua;
import Modelo.TipoFuego;
import Modelo.TipoNormal;
import Modelo.TipoPlanta;

public class TipoNormalTest {
	@Test
	public void RespuestaFrenteFuego(){
		TipoNormal unTipo = new TipoNormal();
		TipoFuego TipoFuego = new TipoFuego();
		assertEquals(unTipo.reaccionATipo(TipoFuego), 1.0,0.0001D);	
	}
	@Test
	public void RespuestaFrenteAgua(){
		TipoNormal unTipo = new TipoNormal();
		TipoAgua TipoAgua = new TipoAgua();
		assertEquals(unTipo.reaccionATipo(TipoAgua), 1.0,0.0001D);
	}
	@Test
	public void RespuestaFrentePlanta(){
		TipoNormal unTipo = new TipoNormal();
		TipoPlanta TipoPlanta = new TipoPlanta();
		assertEquals(unTipo.reaccionATipo(TipoPlanta), 1.0,0.0001D);
	}
	@Test
	public void RespuestaFrenteNormal(){
		TipoNormal unTipo = new TipoNormal();
		TipoNormal TipoNormal = new TipoNormal();
		assertEquals(unTipo.reaccionATipo(TipoNormal), 1.0,0.0001D);
	}
}
