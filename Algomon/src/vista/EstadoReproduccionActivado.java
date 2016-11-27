package vista;

import java.util.HashMap;

import javafx.scene.media.AudioClip;

public class EstadoReproduccionActivado extends EstadoReproduccion {

	@Override
	public void reproducir(String nombreSonido, HashMap<String, AudioClip> diccionarioDeSonidos) {
		diccionarioDeSonidos.get(nombreSonido).play();	
		
	}

	@Override
	public void stop(String nombreSonido, HashMap<String, AudioClip> diccionarioDeSonidos) {
		diccionarioDeSonidos.get(nombreSonido).stop();
		
	}

}
