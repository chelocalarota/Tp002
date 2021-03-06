package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.tipos.TipoAgua;
import modelo.tipos.TipoFuego;
import modelo.tipos.TipoNormal;
import modelo.tipos.TipoPlanta;

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
