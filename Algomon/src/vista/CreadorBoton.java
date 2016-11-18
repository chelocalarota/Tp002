package vista;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

public class CreadorBoton {

	public Button crearBoton(String titulo, String estilo) {
		Button boton = new Button(titulo);
        boton.setStyle(estilo);
        return boton;
		
	}

	public Button crearBoton(String titulo, ImageView imageViewCharmander) {
		Button boton = new Button(titulo, imageViewCharmander);

		boton.setContentDisplay(ContentDisplay.LEFT);
		return boton;
	}

}
