package vista;

import java.util.HashMap;

import javafx.scene.media.AudioClip;

public abstract class EstadoReproduccion {
	public abstract void reproducir(String nombreSonido, HashMap<String, AudioClip> diccionarioDeSonidos);

	public abstract void stop(String nombresonido, HashMap<String, AudioClip> diccionarioDeSonidos);

}
