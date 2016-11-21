package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaJugador {

	Scene escena;
	GridPane grilla;
	ControladorLogicoDelJuego controlador;


	public PantallaJugador() {
		this.grilla = new GridPane();
	}

	public void cargarPantalla(Stage stage,ControladorLogicoDelJuego controlador){
		this.controlador = controlador;


		DropShadow sombraBoton = new DropShadow();
        sombraBoton.setOffsetY(2.0);
        sombraBoton.setOffsetX(2.0);
        sombraBoton.setColor(Color.PINK);

        Label label1 = new Label("Jugador");
		Label label2 = new Label("Nombre:");
		TextField textField = new TextField ();

		CreadorBoton creadorBoton = new CreadorBoton();

		VBox contenedorVertical = new VBox();
		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalInferior = new HBox();

		Button botonLimpiar = creadorBoton.crearBoton("Limpiar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonLimpiar.setEffect(sombraBoton);

		Button botonAceptar =  creadorBoton.crearBoton("Aceptar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonAceptar.setOnAction(event ->{
			this.controlador.setNombreJugadorActual(textField.getText());

//			PantallaEleccionAlgomon pantallaEleccion = new PantallaEleccionAlgomon(this);

//			pantallaEleccion.cargarPantalla(stage,this.controlador);
		});
		botonAceptar.setEffect(sombraBoton);
		contenedorHorizontalSuperior.getChildren().addAll(label2, textField);
		contenedorHorizontalSuperior.setSpacing(10);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
		contenedorHorizontalInferior.getChildren().addAll(botonAceptar,botonLimpiar);
		contenedorHorizontalInferior.setSpacing(25);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);
		contenedorVertical.getChildren().addAll(label1,contenedorHorizontalSuperior,contenedorHorizontalInferior);
		contenedorVertical.setAlignment(Pos.BASELINE_CENTER);
		this.grilla.add(contenedorVertical,0,0);
		this.grilla.setAlignment(Pos.CENTER);
		this.escena = new Scene(grilla, 981, 600);
        stage.setScene(escena);
        stage.show();

	}

}
