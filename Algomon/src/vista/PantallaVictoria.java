package vista;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class PantallaVictoria {
	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlado){
		BorderPane border = new BorderPane();
		Scene principal = new Scene(border, 981, 600);
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewTitulo = creadorImagen.crearImageView("/vista/imagenes/algomon.png");
	}
}
