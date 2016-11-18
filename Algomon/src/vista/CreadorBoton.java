package vista;

import java.util.ArrayList;

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

	public void setearBotonAlgomon(ArrayList<Button> listaDeBotones,Button botonContinuar,ControladorLogicoDelJuego controlador) {
		for (Button boton: listaDeBotones){
			boton.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarCharmanderJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
				
			}
		});
		}
	}
}
