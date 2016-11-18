package vista;

import javafx.application.Application;

import javafx.stage.Stage;

public class Vista extends Application {

	@Override
	public void start(Stage Stage) {
        Stage.setTitle("Algomon-v0.1");
		CreadorPantallas creadorPantallas = new CreadorPantallas(Stage);
		creadorPantallas.crearPantallaInicial();

	}
	public static void main(String[] args) {
		launch(args);
	}

}
