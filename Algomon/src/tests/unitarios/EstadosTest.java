package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.algomon.Algomon;
import modelo.algomon.Charmander;
import modelo.algomon.EstaDormidoException;
import modelo.estados.EstadoDormido;
import modelo.estados.EstadoNormal;
import modelo.estados.EstadoQuemado;

public class EstadosTest {

	@Test
	public void test01EstadoEsNormal() {
		
		EstadoDormido primerEstado = new EstadoDormido();
		EstadoNormal segundoEstado = new EstadoNormal();
		EstadoQuemado tercerEstado = new EstadoQuemado();
		
		assertFalse(primerEstado.esEstadoNormal());
		
		assertTrue(segundoEstado.esEstadoNormal());
		
		assertFalse(tercerEstado.esEstadoNormal());
	}
	
	@Test
	public void test02EstadoVerString(){
		
		EstadoDormido primerEstado = new EstadoDormido();
		EstadoNormal segundoEstado = new EstadoNormal();
		EstadoQuemado tercerEstado = new EstadoQuemado();
		
		assertEquals("Dormido" , primerEstado.asString());
		
		assertEquals("Normal" , segundoEstado.asString());

		assertEquals("Quemado" , tercerEstado.asString());
		
	}
	@Test
	public void test03EstadoDormidoAccion() throws EstaDormidoException{
		EstadoDormido Estado = new EstadoDormido();
		
		Algomon unAlgomon = new Charmander(); //se crea solo porque se necesita para el metodo accionar
		
		try{
			Estado.accion(unAlgomon);
		}
		catch(EstaDormidoException e){
			assertTrue(true);
		}										//acciona 3 veces el estado la primera 3 deberia 
		try{									//lanzar la excepcion a la cuarta veces no
			Estado.accion(unAlgomon);
		}
		catch(EstaDormidoException e){
			assertTrue(true);
		}
		try{
			Estado.accion(unAlgomon);
		}
		catch(EstaDormidoException e){
			assertTrue(true);
		}
		try{
			Estado.accion(unAlgomon);
		}
		catch(EstaDormidoException e){
			fail();
		}	
	}
	
}
