package vista;

import java.util.HashMap;

import javafx.scene.media.AudioClip;

public class EstadoReproduccionDesactivado extends EstadoReproduccion {

	@Override
	public void reproducir(String nombreSonido, HashMap<String, AudioClip> diccionarioDeSonidos) {
	}

	@Override
	public void stop(String nombresonido, HashMap<String, AudioClip> diccionarioDeSonidos) {
	}
}
