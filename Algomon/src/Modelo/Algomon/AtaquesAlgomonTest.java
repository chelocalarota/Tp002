package Modelo.Algomon;
import static org.junit.Assert.*;

import org.junit.Test;

import Modelo.Ataques.Ataque;
public class AtaquesAlgomonTest {
	@Test
	public void AtaqueSinModificacionPorTipo(){
		Bulbasaur bulbasaur = new Bulbasaur();
		Rattata rattata = new Rattata();
		Ataque ataqueRealizado = rattata.ataque("Ataque Rapido");
		int vidaRestante = bulbasaur.recibirDaño(ataqueRealizado, rattata);
		assertEquals(vidaRestante,130);
	}
	
	public void AtaqueConPotenciaFavorecia(){
		Bulbasaur bulbasaur = new Bulbasaur();
		Charmander charmander = new Charmander();
		Ataque ataqueRealizado = charmander.ataque("Brasas");
		int vidaRestante = bulbasaur.recibirDaño(ataqueRealizado, charmander);
		assertEquals(vidaRestante,108);
	}
}
