package vista;

import javafx.application.Application;

import javafx.stage.Stage;

public class Vista extends Application {

	@Override
	public void start(Stage Stage) {
        Stage.setTitle("Algomon-v0.3");
        ControladorLogicoDelJuego controlador = new ControladorLogicoDelJuego();
        PantallaInicial pantallaInicial = new PantallaInicial(controlador);
        PantallaEleccionAlgomon pantallaEleccion = new PantallaEleccionAlgomon();
		pantallaInicial.cargarPantalla(Stage, pantallaEleccion);

	}
	public static void main(String[] args) {
		launch(args);
	}

}
