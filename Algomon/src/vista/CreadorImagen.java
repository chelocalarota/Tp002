package vista;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CreadorImagen {

	public ImageView crearImageView(String string) {
		Image imagen = new Image(string);
		ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        return imageView;
	}

	public ImageView crearImageViewConTamanioEspecifico(String string, int i, int j, boolean b, boolean c) {
		Image imagen = new Image(string,i,j,b,c);
		ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        return imageView;
	}

}
