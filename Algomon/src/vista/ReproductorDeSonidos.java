package vista;

import java.util.HashMap;
import javafx.scene.media.AudioClip;



public class ReproductorDeSonidos {
	public EstadoReproduccion estado = new EstadoReproduccionActivado();
	HashMap<String, AudioClip> diccionarioDeSonidos = new HashMap<String,AudioClip>();
	
	public ReproductorDeSonidos(){
		
		//sonidos pantalla incial
		
		AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/sonidos/intro_pokemon.mp3").toExternalForm());
		
		this.diccionarioDeSonidos.put("inicial",musicaPantallaInicial);
		//sonidos pantalla selecccion
		
		AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/sonidos/charmander_audio.mp3").toExternalForm());
		AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/sonidos/chansey_audio.mp3").toExternalForm());
		AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/sonidos/squirtle_audio.mp3").toExternalForm());
		AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/sonidos/rattata_audio.mp3").toExternalForm());
		AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/sonidos/bulbasaur_audio.mp3").toExternalForm());
		AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/sonidos/jigglypuff_audio.mp3").toExternalForm());
		
		this.diccionarioDeSonidos.put("charmander",sonidoCharmander);
		this.diccionarioDeSonidos.put("chansey",sonidoChansey);
		this.diccionarioDeSonidos.put("squirtle", sonidoSquirtle);
		this.diccionarioDeSonidos.put("rattata", sonidoRattata);
		this.diccionarioDeSonidos.put("bulbasaur",sonidoBulbasaur);
		this.diccionarioDeSonidos.put("jigglypuf", sonidoJigglypuff);
		
		
		
		//sonido pantalla batalla
		AudioClip ataqueDeFuego = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueDeFuego.mp3").toExternalForm());
		AudioClip ataqueDeAgua = new AudioClip(this.getClass().getResource("/vista/sonidos/canionDeAgua.mp3").toExternalForm());
		AudioClip ataqueBurbujas = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueBurbujas.mp3").toExternalForm());
		AudioClip canto = new AudioClip(this.getClass().getResource("/vista/sonidos/canto.mp3").toExternalForm());
		AudioClip latigoCepa = new AudioClip(this.getClass().getResource("/vista/sonidos/latigoCepa.mp3").toExternalForm());
		AudioClip item = new AudioClip(this.getClass().getResource("/vista/sonidos/pokemon_heal.mp3").toExternalForm());
		AudioClip ataqueRapido = new AudioClip(this.getClass().getResource("/vista/sonidos/ataqueRapido.mp3").toExternalForm());
		AudioClip ataquePlanta = new AudioClip(this.getClass().getResource("/vista/sonidos/absorver.mp3").toExternalForm());
		
		
		this.diccionarioDeSonidos.put("Fogonazo",ataqueDeFuego);
		this.diccionarioDeSonidos.put("Brasas", ataqueDeFuego);
		this.diccionarioDeSonidos.put("Ca�on de Agua", ataqueDeAgua);
		this.diccionarioDeSonidos.put("Burbuja",ataqueBurbujas);
		this.diccionarioDeSonidos.put("Canto", canto);
		this.diccionarioDeSonidos.put("Ataque Rapido", ataqueRapido);
		this.diccionarioDeSonidos.put("LatigoCepa", latigoCepa);
		this.diccionarioDeSonidos.put("item", item);
		this.diccionarioDeSonidos.put("ChupaVidas", ataquePlanta);
	
	}
	
	public void reproducir(String nombreSonido){
		this.estado.reproducir(nombreSonido, diccionarioDeSonidos);
	}

	public void desactivar() {
		this.estado = new EstadoReproduccionDesactivado();
		
	}
	public void activar() {
		this.estado = new EstadoReproduccionActivado();
		
	}

	public void stopMusicaInicial() {
		this.estado.stop("inicial", diccionarioDeSonidos);
		
		
	}

	public void playMusicaInicial() {
		this.estado.reproducir("inicial", diccionarioDeSonidos);
		
		
	}

	
}
