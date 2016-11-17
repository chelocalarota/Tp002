package vista;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VentanaCargarJugador extends Stage {
	Label x = new Label("Jugador 1");
	VBox y = new VBox();

	public VentanaCargarJugador(){
	    y.getChildren().add(x);
	    this.setScene(new Scene(y, 300, 300));
	    this.show();
	   }
}

