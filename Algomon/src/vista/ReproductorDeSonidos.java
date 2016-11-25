package vista;

import java.util.HashMap;
import javafx.scene.media.AudioClip;



public class ReproductorDeSonidos {
	public EstadoReproduccion estado = new EstadoReproduccionActivado();
	HashMap<String, AudioClip> diccionarioDeSonidos = new HashMap<String,AudioClip>();
	
	public ReproductorDeSonidos(){
		
		//sonidos pantalla incial
		
		AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/sonidos/intro_pokemon.mp3").toExternalForm());
		
		diccionarioDeSonidos.put("inicial",musicaPantallaInicial);
		//sonidos pantalla selecccion
		
		AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/sonidos/charmander_audio.mp3").toExternalForm());
		AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/sonidos/chansey_audio.mp3").toExternalForm());
		AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/sonidos/squirtle_audio.mp3").toExternalForm());
		AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/sonidos/rattata_audio.mp3").toExternalForm());
		AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/sonidos/bulbasaur_audio.mp3").toExternalForm());
		AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/sonidos/jigglypuff_audio.mp3").toExternalForm());
		
		diccionarioDeSonidos.put("charmander",sonidoCharmander);
		diccionarioDeSonidos.put("chansey",sonidoChansey);
		diccionarioDeSonidos.put("squirtle", sonidoSquirtle);
		diccionarioDeSonidos.put("rattata", sonidoRattata);
		diccionarioDeSonidos.put("bulbasaur",sonidoBulbasaur);
		diccionarioDeSonidos.put("jigglypuf", sonidoJigglypuff);
		
		
		
		//sonido pantalla batalla
		AudioClip ataqueDeFuego = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueDeFuego.mp3").toExternalForm());
		AudioClip ataqueDeAgua = new AudioClip(this.getClass().getResource("/vista/sonidos/canionDeAgua.mp3").toExternalForm());
		AudioClip ataqueBurbujas = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueBurbujas.mp3").toExternalForm());
		AudioClip canto = new AudioClip(this.getClass().getResource("/vista/sonidos/canto.mp3").toExternalForm());
		AudioClip latigoCepa = new AudioClip(this.getClass().getResource("/vista/sonidos/latigoCepa.mp3").toExternalForm());
		AudioClip item = new AudioClip(this.getClass().getResource("/vista/sonidos/pokemon_heal.mp3").toExternalForm());
		AudioClip ataqueRapido = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueRapido.mp3").toExternalForm());
		AudioClip ataquePlanta = new AudioClip(this.getClass().getResource("/vista/sonidos/absorver.mp3").toExternalForm());
		
		
		diccionarioDeSonidos.put("Fogonazo",ataqueDeFuego);
		diccionarioDeSonidos.put("Brasas", ataqueDeFuego);
		diccionarioDeSonidos.put("Ca�on de Agua", ataqueDeAgua);
		diccionarioDeSonidos.put("Burbuja",ataqueBurbujas);
		diccionarioDeSonidos.put("Canto", canto);
		diccionarioDeSonidos.put("Ataque Rapido", ataqueRapido);
		diccionarioDeSonidos.put("LatigoCepa", latigoCepa);
		diccionarioDeSonidos.put("item", item);
		diccionarioDeSonidos.put("ChupaVidas", ataquePlanta);
	
	}
	
	public void reproducir(String nombreSonido){
		estado.reproducir(nombreSonido, diccionarioDeSonidos);
	}

	public void desactivar() {
		this.estado = new EstadoReproduccionDesactivado();
		
	}
	public void activar() {
		this.estado = new EstadoReproduccionActivado();
		
	}

	public void stopMusicaInicial() {
		diccionarioDeSonidos.get("inicial").stop();
		
	}
}
