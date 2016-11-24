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
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class PantallaEleccionAlgomon {

	Scene escena;
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;


	public PantallaEleccionAlgomon(){
		this.miniaturasJugadorInicial = new LinkedList<ImageView>();
		this.imagenesJugadorInicial= new LinkedList<ImageView>();
		this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
		this.imagenesJugadorSegundo = new LinkedList<ImageView>();
	}

	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, int i) {
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/charmander.png", 150, 150, false, true);
		ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/squirtle.png", 150, 150, false, true);
		ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/rattata.png", 150, 150, false, true);
		ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/chansey.png", 150, 150, false, true);
		ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/bulbasaur.png", 150, 150, false, true);
		ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/jigglypuff.png", 150, 150, false, true);


		Label label = new Label("Jugador" + String.valueOf(i));
		VBox contenedorVertical = new VBox();
		VBox contenedorVertical2 = new VBox();

		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalMedio = new HBox();
		HBox contenedorHorizontalInferior = new HBox();

		CreadorBoton creadorBoton = new CreadorBoton();
		ArrayList<Button> listaDeBotones = new ArrayList<Button>();
		ArrayList<AudioClip> listaDeSonidos = new ArrayList<AudioClip>();

		Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
		listaDeBotones.add(botonCharmander);
		AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/sonidos/charmander_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoCharmander);

		Button botonChansey = creadorBoton.crearBoton("chansey", imageViewChansey);
		listaDeBotones.add(botonChansey);
		AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/sonidos/chansey_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoChansey);

		Button botonSquirtle =creadorBoton.crearBoton("squirtle", imageViewSquirtle);
		listaDeBotones.add(botonSquirtle);
		AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/sonidos/squirtle_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoSquirtle);

		Button botonRattata =creadorBoton.crearBoton("rattata", imageViewRattata);
		listaDeBotones.add(botonRattata);
		AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/sonidos/rattata_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoRattata);

		Button botonBulbasaur =creadorBoton.crearBoton("bulbasaur", imageViewBulbasaur);
		listaDeBotones.add(botonBulbasaur);
		AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/sonidos/bulbasaur_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoBulbasaur);

		Button botonJigglypuff =creadorBoton.crearBoton("jigglypuff", imageViewJigglypuff);
		listaDeBotones.add(botonJigglypuff);
		AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/sonidos/jigglypuff_audio.mp3").toExternalForm());
		listaDeSonidos.add(sonidoJigglypuff);

		Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonContinuar.setDisable(true);
		for (Button boton:listaDeBotones){
			boton.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
			boton.setMaxSize(280, contenedorHorizontalSuperior.getPrefHeight());
			boton.setMinSize(280, contenedorHorizontalSuperior.getPrefHeight());
		}

		botonCharmander.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarCharmanderJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);

			}
			sonidoCharmander.play();
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/CharmanderEspalda.gif", 130, 130, true, false));

				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Charmander_XY.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
});
		botonSquirtle.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarSquirtleJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Squirtle_espalda.gif", 130, 130, false, true));
				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Squirtle_frente.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			sonidoSquirtle.play();});

		botonBulbasaur.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarBulbasaurJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Bulbasaur_espalda.gif", 130, 130, false, true));
				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Bulbasaur_frente.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			sonidoBulbasaur.play();});

		botonRattata.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarRattataJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			sonidoRattata.play();
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Rattata_espalda.gif", 130, 130, false, true));
				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Rattata_frente.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
});
		botonJigglypuff.setOnAction(event ->{
			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarJigglypuffJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			sonidoJigglypuff.play();
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Jigglypuff_espalda.gif", 130, 130, false, true));
				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Jigglypuff_frente.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
});
		botonChansey.setOnAction(event ->{

			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
				controlador.agregarChanseyJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
			sonidoChansey.play();
			if(this.miniaturasJugadorInicial.size()<3){
				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Chansey_espalda.gif", 130, 130, false, true));
				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
			}
			else{
				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/ChanseyFrente.gif", 90, 90, false, true));
				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
			}
			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
			}
});

		botonContinuar.setOnAction(event->{
			controlador.pasarTurno();
			if(controlador.verificarCantidadAlgomonDeJugadorActual()){
				PantallaBatalla pantallaBatalla = new PantallaBatalla(this.miniaturasJugadorInicial,this.imagenesJugadorInicial, this.miniaturasJugadorSegundo, this.imagenesJugadorSegundo);
				pantallaBatalla.cargarPantalla(stage,controlador);
			}
			else{
				this.cargarPantalla(stage, controlador,2);

			}
		});
		contenedorVertical.setSpacing(100);

		contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
		contenedorHorizontalSuperior.setSpacing(60);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
		contenedorVertical2.getChildren().addAll(label,contenedorHorizontalSuperior);
		contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
		contenedorHorizontalMedio.setSpacing(60);
		contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);
		contenedorHorizontalInferior.getChildren().add(botonContinuar);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);

		contenedorVertical.getChildren().addAll(contenedorHorizontalMedio,contenedorHorizontalInferior);
	    BorderPane border = new BorderPane();
		border.setTop(contenedorVertical2);
		border.setCenter(contenedorVertical);
		this.escena = new Scene(border, 981, 600);
        stage.setScene(escena);
        stage.show();
	}
}

//package vista;
//
//import java.util.ArrayList;
//
//
//import java.util.LinkedList;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//
//import javafx.scene.control.Label;
//
//import javafx.scene.image.ImageView;
//import javafx.scene.layout.BorderPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;
//import javafx.scene.media.AudioClip;
//import javafx.stage.Stage;
//
//public class PantallaEleccionAlgomon {
//
//	Scene escena;
//	LinkedList<ImageView> miniaturasJugadorInicial;
//	LinkedList<ImageView> imagenesJugadorInicial;
//	LinkedList<ImageView> miniaturasJugadorSegundo;
//	LinkedList<ImageView> imagenesJugadorSegundo;
//
//
//	public PantallaEleccionAlgomon(){
//		this.miniaturasJugadorInicial = new LinkedList<ImageView>();
//		this.imagenesJugadorInicial= new LinkedList<ImageView>();
//		this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
//		this.imagenesJugadorSegundo = new LinkedList<ImageView>();
//	}
//
//	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, int i) {
//		CreadorImagen creadorImagen = new CreadorImagen();
//		ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/charmander.png", 150, 150, false, true);
//		ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/squirtle.png", 150, 150, false, true);
//		ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/rattata.png", 150, 150, false, true);
//		ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/chansey.png", 150, 150, false, true);
//		ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/bulbasaur.png", 150, 150, false, true);
//		ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/jigglypuff.png", 150, 150, false, true);
//
//
//
//		Label label = new Label("Jugador" + String.valueOf(i));
//		VBox contenedorVertical = new VBox();
//		VBox contenedorVertical2 = new VBox();
//
//		HBox contenedorHorizontalSuperior = new HBox();
//		HBox contenedorHorizontalMedio = new HBox();
//		HBox contenedorHorizontalInferior = new HBox();
//
//		MenuTop Menu = new MenuTop(stage);
//
//
//
//
//		CreadorBoton creadorBoton = new CreadorBoton();
//		ArrayList<Button> listaDeBotones = new ArrayList<Button>();
//		ArrayList<AudioClip> listaDeSonidos = new ArrayList<AudioClip>();
//
//		Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
//		listaDeBotones.add(botonCharmander);
//		AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/sonidos/charmander_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoCharmander);
//
//		Button botonChansey = creadorBoton.crearBoton("chansey", imageViewChansey);
//		listaDeBotones.add(botonChansey);
//		AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/sonidos/chansey_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoChansey);
//
//		Button botonSquirtle =creadorBoton.crearBoton("squirtle", imageViewSquirtle);
//		listaDeBotones.add(botonSquirtle);
//		AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/sonidos/squirtle_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoSquirtle);
//
//		Button botonRattata =creadorBoton.crearBoton("rattata", imageViewRattata);
//		listaDeBotones.add(botonRattata);
//		AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/sonidos/rattata_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoRattata);
//
//		Button botonBulbasaur =creadorBoton.crearBoton("bulbasaur", imageViewBulbasaur);
//		listaDeBotones.add(botonBulbasaur);
//		AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/sonidos/bulbasaur_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoBulbasaur);
//
//		Button botonJigglypuff =creadorBoton.crearBoton("jigglypuff", imageViewJigglypuff);
//		listaDeBotones.add(botonJigglypuff);
//		AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/sonidos/jigglypuff_audio.mp3").toExternalForm());
//		listaDeSonidos.add(sonidoJigglypuff);
//
//		Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
//		botonContinuar.setDisable(true);
//		for (Button boton:listaDeBotones){
//			boton.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
//			boton.setMaxSize(280, contenedorHorizontalSuperior.getPrefHeight());
//			boton.setMinSize(280, contenedorHorizontalSuperior.getPrefHeight());
//		}
//
//		botonCharmander.setOnAction(event ->{
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarCharmanderJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//
//			}
//			sonidoCharmander.play();
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/CharmanderEspalda.gif", 130, 130, true, false));
//
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/Charmander_XY.gif", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//});
//		botonSquirtle.setOnAction(event ->{
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarSquirtleJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 130, 130, false, true));
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			sonidoSquirtle.play();});
//
//		botonBulbasaur.setOnAction(event ->{
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarBulbasaurJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 130, 130, false, true));
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			sonidoBulbasaur.play();});
//
//		botonRattata.setOnAction(event ->{
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarRattataJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			sonidoRattata.play();
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 130, 130, false, true));
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//});
//		botonJigglypuff.setOnAction(event ->{
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarJigglypuffJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			sonidoJigglypuff.play();
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 130, 130, false, true));
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//});
//		botonChansey.setOnAction(event ->{
//
//			if (!controlador.verificarCantidadAlgomonDeJugadorActual()){
//				controlador.agregarChanseyJugadorActual();
//			}
//			else{
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//			sonidoChansey.play();
//			if(this.miniaturasJugadorInicial.size()<3){
//				this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 130, 130, false, true));
//				this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
//			}
//			else{
//				this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 90, 90, false, true));
//				this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
//			}
//			if (controlador.verificarCantidadAlgomonDeJugadorActual()){
//				for (Button boton_auxiliar:listaDeBotones){
//					boton_auxiliar.setDisable(true);
//				}
//				botonContinuar.setDisable(false);
//			}
//});
//
//		botonContinuar.setOnAction(event->{
//			controlador.pasarTurno();
//			if(controlador.verificarCantidadAlgomonDeJugadorActual()){
//				PantallaBatalla pantallaBatalla = new PantallaBatalla(this.miniaturasJugadorInicial,this.imagenesJugadorInicial, this.miniaturasJugadorSegundo, this.imagenesJugadorSegundo);
//				pantallaBatalla.cargarPantalla(stage,controlador);
//			}
//			else{
//				this.cargarPantalla(stage, controlador,2);
//
//			}
//		});
//		contenedorVertical.setSpacing(100);
//		contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
//		contenedorHorizontalSuperior.setSpacing(60);
//		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_LEFT);
//		contenedorVertical2.getChildren().addAll(Menu.obtenerMenu(),label,contenedorHorizontalSuperior);
//		contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
//		contenedorHorizontalMedio.setSpacing(60);
//		contenedorHorizontalMedio.setAlignment(Pos.BASELINE_LEFT);
//		contenedorHorizontalInferior.getChildren().add(botonContinuar);
//		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_LEFT);
//
//		contenedorVertical.getChildren().addAll(contenedorHorizontalMedio,contenedorHorizontalInferior);
//	    BorderPane border = new BorderPane();
//		border.setTop(contenedorVertical2);
//		border.setCenter(contenedorVertical);
//		this.escena = new Scene(border, 981, 600);
//        stage.setScene(escena);
//        stage.show();
//	}
//}