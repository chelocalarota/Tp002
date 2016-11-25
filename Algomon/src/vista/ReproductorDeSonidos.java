package vista;

import java.util.HashMap;
import javafx.scene.media.AudioClip;



public class ReproductorDeSonidos {
	public EstadoReproduccion estado = new EstadoReproduccionActivado();
	HashMap<String, AudioClip> diccionarioDeSonidos = new HashMap<String,AudioClip>();
	
	public ReproductorDeSonidos(){
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
}
