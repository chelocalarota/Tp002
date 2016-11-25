package vista;

import java.util.ArrayList;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class CreadorBoton {

	public Button crearBoton(String titulo, String estilo) {
		Button boton = new Button(titulo);
        boton.setStyle(estilo);
        return boton;
		
	}

	public Button crearBoton(String titulo, ImageView imageView) {
		Button boton = new Button(titulo, imageView);

		boton.setContentDisplay(ContentDisplay.LEFT);
		return boton;
	}

	public void setearBotonAlgomon(ArrayList<Button> listaDeBotones,Button botonElegido, Button botonContinuar, 
								   ControladorLogicoDelJuego controlador, AudioClip audio) {
	
			botonElegido.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarCharmanderJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
	
		}
		audio.play();});

		}
	
	public Button crearBotonEleccionAlgomon(String titulo, ImageView imageView, String estilo) {
		Button boton = new Button(titulo, imageView);
		boton.setStyle(estilo);
		
		boton.setContentDisplay(ContentDisplay.LEFT);
		return boton;
	}
}

