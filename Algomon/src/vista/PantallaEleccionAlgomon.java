package vista;

import java.util.ArrayList;
import java.util.LinkedList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaEleccionAlgomon {

	Scene escena;
	LinkedList<ImageView> miniaturasActual;
	ReproductorDeSonidos reproductor;
	HBox contenedorBarraDeMiniaturas;

	public PantallaEleccionAlgomon(){
	}

	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, int i, ReproductorDeSonidos reproductor) {

		this.reproductor = reproductor;

		this.miniaturasActual = controlador.getMiniaturasJugadorInicial();

		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

		Label label = new Label("JUGADOR  " + String.valueOf(i));
		label.setStyle("-fx-font: 38 arial;");
		label.setTextFill(Color.WHITE);
		VBox contenedorVertical = new VBox();

		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalMedio = new HBox();
		HBox contenedorHorizontalInferior = new HBox();
		this.contenedorBarraDeMiniaturas = new HBox();

		CreadorBotonesDeEleccion creadorBotonesDeEleccion = new CreadorBotonesDeEleccion();

		ArrayList<Button> listaDeBotones = creadorBotonesDeEleccion.crearBotonesDeEleccion();

		Button botonCharmander = listaDeBotones.get(0);
		Button botonChansey = listaDeBotones.get(1);
		Button botonSquirtle = listaDeBotones.get(2);
		Button botonRattata = listaDeBotones.get(3);
		Button botonBulbasaur = listaDeBotones.get(4);
		Button botonJigglypuff = listaDeBotones.get(5);

		CreadorBoton creadorBoton = new CreadorBoton();

		Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
		Button botonLimpiar = creadorBoton.crearBoton("Limpiar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonContinuar.setDisable(true);

		for (Button boton:listaDeBotones){
			boton.setMaxSize(350, contenedorHorizontalSuperior.getPrefHeight());
			boton.setMinSize(350, contenedorHorizontalSuperior.getPrefHeight());
		}

		botonCharmander.setOnAction(event ->{
				controlador.agregarCharmanderJugadorActual();
				elegirAlgomon("Charmander", controlador, listaDeBotones, botonContinuar, botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);
});
		botonSquirtle.setOnAction(event ->{
				controlador.agregarSquirtleJugadorActual();
				elegirAlgomon("Squirtle", controlador, listaDeBotones, botonContinuar, botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);
});

		botonBulbasaur.setOnAction(event ->{
				controlador.agregarBulbasaurJugadorActual();
				elegirAlgomon("Bulbasaur", controlador, listaDeBotones, botonContinuar, botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);

});

		botonRattata.setOnAction(event ->{
				controlador.agregarRattataJugadorActual();
				elegirAlgomon("Rattata", controlador, listaDeBotones, botonContinuar, botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);

});
		botonJigglypuff.setOnAction(event ->{
				controlador.agregarJigglypuffJugadorActual();
				elegirAlgomon("Jigglypuff", controlador, listaDeBotones, botonContinuar, botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);

});
		botonChansey.setOnAction(event ->{
				controlador.agregarChanseyJugadorActual();
				elegirAlgomon("Chansey", controlador, listaDeBotones, botonContinuar,botonLimpiar);
				this.contenedorBarraDeMiniaturas.getChildren().clear();
				this.contenedorBarraDeMiniaturas.getChildren().addAll(this.miniaturasActual);


});

		botonContinuar.setOnAction(event->{
			controlador.pasarTurno();
			if(controlador.verificarCantidadAlgomonDeJugadorActual()){
				PantallaBatalla pantallaBatalla = new PantallaBatalla();
				pantallaBatalla.cargarPantalla(stage,controlador,reproductor);
			}
			else{
				this.cargarPantalla(stage, controlador,2, reproductor);
				this.cambiarMiniaturas(controlador);
			}
		});

		botonLimpiar.setOnAction(event->{
			controlador.limpiarEleccionDeAlgomones();
			this.limpiarMiniaturas(controlador);
		});

		contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
		contenedorHorizontalSuperior.setSpacing(60);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
		contenedorVertical.getChildren().addAll(label, contenedorHorizontalSuperior, contenedorHorizontalMedio, contenedorHorizontalInferior);
		contenedorVertical.setAlignment(Pos.CENTER);
		contenedorVertical.setSpacing(35);
		contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
		contenedorHorizontalMedio.setSpacing(60);
		contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);

		this.contenedorBarraDeMiniaturas.setSpacing(20);
		contenedorHorizontalInferior.getChildren().addAll(contenedorBarraDeMiniaturas, botonLimpiar, botonContinuar);
		contenedorHorizontalInferior.setSpacing(150);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);

	    BorderPane border = new BorderPane();
	    border.setStyle("-fx-base: #17202A;");
		border.setTop(contenedorVertical);
		this.escena = new Scene(border, ancho - 20, alto - 100);
        stage.setScene(this.escena);
        stage.centerOnScreen();
        stage.show();
	}


	private void elegirAlgomon(String algomon, ControladorLogicoDelJuego controlador, ArrayList<Button> listaDeBotonesEleccionAlgomon, Button botonContinuar, Button botonLimpiar) {

		if (controlador.verificarCantidadAlgomonDeJugadorActual()){
			for (Button boton_auxiliar:listaDeBotonesEleccionAlgomon){
				boton_auxiliar.setDisable(true);
			}
			botonContinuar.setDisable(false);
			botonLimpiar.setDisable(true);
		}
		reproductor.reproducir(algomon);
		controlador.agregarMiniatura(algomon);
	}

	private void cambiarMiniaturas(ControladorLogicoDelJuego controlador){
		this.miniaturasActual = controlador.getMiniaturasJugadorSegundo();
	}

	private void limpiarMiniaturas(ControladorLogicoDelJuego controlador){
		this.contenedorBarraDeMiniaturas.getChildren().clear();
		this.miniaturasActual.clear();
		this.miniaturasActual = controlador.getMiniaturaDeJugadorActual();
	}
}