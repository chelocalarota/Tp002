package vista;

import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreadorImagen {

	HashMap<String, HashMap <String, String>> rutaDeImagenes;
	HashMap<String, String> rutaDeImagenesJugador1;
	HashMap<String, String> rutaDeImagenesJugador2;
	HashMap<String, String> rutaDeMiniaturas;

	public CreadorImagen(){

		this.rutaDeImagenes = new HashMap<String, HashMap <String, String>>();
		this.rutaDeImagenesJugador1 = new HashMap<String, String>();
		this.rutaDeImagenesJugador2 = new HashMap<String, String>();
		this.rutaDeImagenes.put("Jugador1",rutaDeImagenesJugador1);
		this.rutaDeImagenes.put("Jugador2",rutaDeImagenesJugador2);

		this.rutaDeMiniaturas = new HashMap<String, String>();

	}

	public ImageView crearImagenParaBatalla(String jugador, String algomon,int ancho,int alto){

		this.rutaDeImagenesJugador1.put("Charmander", "vista/imagenes/CharmanderEspalda.gif");
		this.rutaDeImagenesJugador1.put("Chansey", "vista/imagenes/Chansey_espalda.gif");
		this.rutaDeImagenesJugador1.put("Rattata", "vista/imagenes/Rattata_espalda.gif");
		this.rutaDeImagenesJugador1.put("Squirtle", "vista/imagenes/Squirtle_espalda.gif");
		this.rutaDeImagenesJugador1.put("Bulbasaur", "vista/imagenes/Bulbasaur_espalda.gif");
		this.rutaDeImagenesJugador1.put("Jigglypuff", "vista/imagenes/Jigglypuff_espalda.gif");

		this.rutaDeImagenesJugador2.put("Charmander", "vista/imagenes/Charmander_XY.gif");
		this.rutaDeImagenesJugador2.put("Chansey", "vista/imagenes/ChanseyFrente.gif");
		this.rutaDeImagenesJugador2.put("Rattata", "vista/imagenes/Rattata_frente.gif");
		this.rutaDeImagenesJugador2.put("Squirtle", "vista/imagenes/Squirtle_frente.gif");
		this.rutaDeImagenesJugador2.put("Bulbasaur", "vista/imagenes/Bulbasaur_frente.gif");
		this.rutaDeImagenesJugador2.put("Jigglypuff", "vista/imagenes/Jigglypuff_frente.gif");

		String pathImagen = this.rutaDeImagenes.get(jugador).get(algomon);

		return crearImageViewConTamanioEspecifico(pathImagen, ancho, alto, false, true);

	}

	public ImageView crearMiniaturas(String algomon){

		this.rutaDeMiniaturas.put("Charmander", "vista/imagenes/charmander.png");
		this.rutaDeMiniaturas.put("Chansey", "vista/imagenes/chansey.png");
		this.rutaDeMiniaturas.put("Rattata", "vista/imagenes/rattata.png");
		this.rutaDeMiniaturas.put("Squirtle", "vista/imagenes/squirtle.png");
		this.rutaDeMiniaturas.put("Bulbasaur", "vista/imagenes/bulbasaur.png");
		this.rutaDeMiniaturas.put("Jigglypuff", "vista/imagenes/jigglypuff.png");

		String pathImagen = this.rutaDeMiniaturas.get(algomon);

		return crearImageViewConTamanioEspecifico(pathImagen, 30, 30, false, true);

	}

	public ImageView crearImageView(String pathImagen) {
		Image imagen = new Image(pathImagen);
		ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        return imageView;
	}

	public ImageView crearImageViewConTamanioEspecifico(String pathImagen, int ancho, int alto, boolean redimensionable, boolean buenaCalidad) {
		Image imagen = new Image(pathImagen, ancho, alto, redimensionable, buenaCalidad);
		ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        return imageView;
	}

}
