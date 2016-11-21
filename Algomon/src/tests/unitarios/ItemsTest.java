package tests.unitarios;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.items.*;

public class ItemsTest {

	@Test
	public void test01ItemsVerificarQueTienesUsosDisponibles() {
		Item pocion = new Pocion();
		Item vitamina = new Vitamina();
		Item restaurador = new Restaurador();
		Item superpocion = new SuperPocion();
		
		assertFalse(pocion.sinUsosDisponibles());
		assertFalse(superpocion.sinUsosDisponibles());
		assertFalse(vitamina.sinUsosDisponibles());
		assertFalse(restaurador.sinUsosDisponibles());
	}
	@Test
	public void test02PocionCantidadDeUsoCuatro(){
		Item pocion = new Pocion();

		assertEquals(4, pocion.cantidadDeUsos());
	}
	@Test
	public void test03RestauradorCantidadDeUsoTres(){
		Item restaurador = new Restaurador();

		assertEquals(3, restaurador.cantidadDeUsos());
	}
	@Test
	public void test04SuperPocionCantidadDeUsoDos(){
		Item superpocion = new SuperPocion();

		assertEquals(2, superpocion.cantidadDeUsos());
	}
	@Test
	public void test05VitaminaCantidadDeUsoCinco(){
		Item vitamina = new Vitamina();

		assertEquals(5, vitamina.cantidadDeUsos());
	}



}
