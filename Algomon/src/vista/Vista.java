package vista;

import javafx.application.Application;

import javafx.stage.Stage;

public class Vista extends Application {

	@Override
	public void start(Stage Stage) {
        Stage.setTitle("Algomon-v0.3");
        PantallaInicial pantallaInicial = new PantallaInicial();
		pantallaInicial.cargarPantalla(Stage);

	}
	public static void main(String[] args) {
		launch(args);
	}

}
