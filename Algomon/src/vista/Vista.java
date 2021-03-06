package vista;

import controlador.ControladorLogicoDelJuego;
import javafx.application.Application;

import javafx.stage.Stage;
import vista.pantallas.PantallaEleccionAlgomon;
import vista.pantallas.PantallaInicial;

public class Vista extends Application {

	@Override
	public void start(Stage Stage) {
        Stage.setTitle("Algomon-v0.5");
        ControladorLogicoDelJuego controlador = new ControladorLogicoDelJuego();
        ReproductorDeSonidos reproductor = new ReproductorDeSonidos(); 
        
        PantallaInicial pantallaInicial = new PantallaInicial(controlador,reproductor);
        PantallaEleccionAlgomon pantallaEleccion = new PantallaEleccionAlgomon();
		pantallaInicial.cargarPantalla(Stage, pantallaEleccion);

	}
	public static void main(String[] args) {
		launch(args);
	}

}
