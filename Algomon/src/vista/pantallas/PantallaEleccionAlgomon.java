package vista.pantallas;

import java.util.ArrayList;
import java.util.LinkedList;

import controlador.ControladorLogicoDelJuego;
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
import vista.ReproductorDeSonidos;
import vista.creadores.CreadorBoton;

public class PantallaEleccionAlgomon {

	private Scene escena;
	private LinkedList<ImageView> miniaturasActual;
	private LinkedList<ImageView> imagenesActual;
	private ReproductorDeSonidos reproductor;
	private HBox contenedorBarraDeMiniaturas;

	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, int numeroDeJugador,
							   ReproductorDeSonidos reproductor) {

		this.reproductor = reproductor;

		this.miniaturasActual = controlador.getMiniaturasJugadorInicial();
		this.imagenesActual = controlador.getImagenesJugadorInicial();

		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

		Label label = new Label("JUGADOR  " + String.valueOf(numeroDeJugador));
		label.setStyle("-fx-font: 38 arial;");
		label.setTextFill(Color.WHITE);
		VBox contenedorVertical = new VBox();

		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalMedio = new HBox();
		HBox contenedorHorizontalInferior = new HBox();
		this.contenedorBarraDeMiniaturas = new HBox();

		CreadorBoton creadorBotonesDeEleccion = new CreadorBoton();

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
			if(controlador.cantidadAlgomonesDeJugadorActualEsTres()){
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
			this.limpiarMiniaturas(controlador,botonContinuar,listaDeBotones);
		});

		contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
		contenedorHorizontalSuperior.setSpacing(60);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);

		contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
		contenedorHorizontalMedio.setSpacing(60);
		contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);

		contenedorHorizontalInferior.getChildren().addAll(botonLimpiar, botonContinuar);
		contenedorHorizontalInferior.setSpacing(150);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);

		this.contenedorBarraDeMiniaturas.setSpacing(20);
		this.contenedorBarraDeMiniaturas.setAlignment(Pos.BASELINE_CENTER);

		contenedorVertical.getChildren().addAll(label, contenedorHorizontalSuperior, contenedorHorizontalMedio, contenedorHorizontalInferior, this.contenedorBarraDeMiniaturas);
		contenedorVertical.setAlignment(Pos.CENTER);
		contenedorVertical.setSpacing(35);

	    BorderPane border = new BorderPane();
	    border.setStyle("-fx-base: #17202A;");
		border.setTop(contenedorVertical);
		this.escena = new Scene(border, ancho - 20, alto - 100);
        stage.setScene(this.escena);
        stage.centerOnScreen();
        stage.show();
	}


	private void elegirAlgomon(String algomon, ControladorLogicoDelJuego controlador, ArrayList<Button> listaDeBotonesEleccionAlgomon, Button botonContinuar, Button botonLimpiar) {

		if (controlador.cantidadAlgomonesDeJugadorActualEsTres()){
			for (Button boton_auxiliar:listaDeBotonesEleccionAlgomon){
				boton_auxiliar.setDisable(true);
			}
			botonContinuar.setDisable(false);
		}
		reproductor.reproducir(algomon);
		controlador.agregarMiniatura(algomon);
	}

	private void cambiarMiniaturas(ControladorLogicoDelJuego controlador){
		this.miniaturasActual = controlador.getMiniaturasJugadorSegundo();
		this.imagenesActual= controlador.getImagenesJugadorSegundo();
	}	

	private void limpiarMiniaturas(ControladorLogicoDelJuego controlador, Button botonContinuar, ArrayList<Button> listaDeBotonesEleccionAlgomon){
			for (Button boton_auxiliar:listaDeBotonesEleccionAlgomon){
				boton_auxiliar.setDisable(false);
			}
			botonContinuar.setDisable(true);
		this.contenedorBarraDeMiniaturas.getChildren().clear();
		this.miniaturasActual.clear();
		this.miniaturasActual = controlador.getMiniaturaDeJugadorActual();
		this.imagenesActual.clear();
		this.imagenesActual = controlador.getImagenesDeJugadorActual();
		botonContinuar.setDisable(true);

	}
}