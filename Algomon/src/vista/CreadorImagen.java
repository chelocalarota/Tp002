package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreadorImagen {

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
