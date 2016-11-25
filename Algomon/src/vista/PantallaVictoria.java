package vista;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;

public class PantallaVictoria {
	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlado){
		BorderPane border = new BorderPane();
		Scene escena = new Scene(border);
        stage.setScene(escena);
        stage.setFullScreen(true);
        stage.show();
	}
}
