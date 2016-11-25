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
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;
	ReproductorDeSonidos reproductor; 


	public PantallaEleccionAlgomon(){
		this.miniaturasJugadorInicial = new LinkedList<ImageView>();
		this.imagenesJugadorInicial= new LinkedList<ImageView>();
		this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
		this.imagenesJugadorSegundo = new LinkedList<ImageView>();
	}

	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, int i, ReproductorDeSonidos reproductor) {
		
		this.reproductor = reproductor;
		
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    
	    
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/charmander.png", 150, 150, false, true);
		ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/squirtle.png", 150, 150, false, true);
		ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/rattata.png", 150, 150, false, true);
		ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/chansey.png", 150, 150, false, true);
		ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/bulbasaur.png", 150, 150, false, true);
		ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/jigglypuff.png", 150, 150, false, true);
				

		Label label = new Label("JUGADOR  " + String.valueOf(i));
		label.setStyle("-fx-font: 38 arial;");
		label.setTextFill(Color.WHITE);
		VBox contenedorVertical = new VBox();

		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalMedio = new HBox();
		HBox contenedorHorizontalInferior = new HBox();

		CreadorBoton creadorBoton = new CreadorBoton();
		ArrayList<Button> listaDeBotones = new ArrayList<Button>();
		
		
		String estiloCharmander = "-fx-font: 18 arial; -fx-base: #F5A9A9;";
		String textoCharmander = "CHARMANDER\n\nTipo: Fuego\nVida: 170\nAtaques:\n  -Brasas\n  -Fogonazo\n  -AtaqueRapido\n"; 
		Button botonCharmander = creadorBoton.crearBotonEleccionAlgomon(textoCharmander, imageViewCharmander, estiloCharmander);
		listaDeBotones.add(botonCharmander);
		
		String estiloChansey = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoChansey = "CHANSEY\n\nTipo: Normal\nVida: 130\nAtaques:\n  -Canto\n  -Latigo Cepa\n  -AtaqueRapido\n"; 
		Button botonChansey = creadorBoton.crearBotonEleccionAlgomon(textoChansey, imageViewChansey, estiloChansey);
		listaDeBotones.add(botonChansey);
		
		String estiloSquirtle = "-fx-font: 18 arial; -fx-base: #A9D0F5;";
		String textoSquirtle = "SQUIRTLE\n\nTipo: Agua\nVida: 150\nAtaques:\n  -Burbuja\n  -Cañon de Agua\n  -AtaqueRapido\n"; 
		Button botonSquirtle =creadorBoton.crearBotonEleccionAlgomon(textoSquirtle, imageViewSquirtle, estiloSquirtle);
		listaDeBotones.add(botonSquirtle);
		
		String estiloRattata = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoRattata = "RATTATA\n\nTipo: Normal\nVida: 170\nAtaques:\n  -Fogonazo\n  -Burbuja\n  -AtaqueRapido\n"; 
		Button botonRattata =creadorBoton.crearBotonEleccionAlgomon(textoRattata, imageViewRattata, estiloRattata);
		listaDeBotones.add(botonRattata);
		
		String estiloBulbasaur = "-fx-font: 18 arial; -fx-base: #BCF5A9;";
		String textoBulbasaur = "BULBASAUR\n\nTipo: Planta\nVida: 140\nAtaques:\n  -Chupavidas\n  -Latigo Cepa\n  -AtaqueRapido\n"; 
		Button botonBulbasaur =creadorBoton.crearBotonEleccionAlgomon(textoBulbasaur, imageViewBulbasaur, estiloBulbasaur);
		listaDeBotones.add(botonBulbasaur);
		
		String estiloJigglypuff = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoJigglypuff = "JIGGLYPUFF\n\nTipo: Normal\nVida: 130\nAtaques:\n  -Canto\n  -Burbuja\n  -AtaqueRapido\n"; 
		Button botonJigglypuff =creadorBoton.crearBotonEleccionAlgomon(textoJigglypuff, imageViewJigglypuff, estiloJigglypuff);
		listaDeBotones.add(botonJigglypuff);
		
		Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
		Button botonLimpiar = creadorBoton.crearBoton("Limpiar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonContinuar.setDisable(true);
		for (Button boton:listaDeBotones){
			boton.setMaxSize(350, contenedorHorizontalSuperior.getPrefHeight());
			boton.setMinSize(350, contenedorHorizontalSuperior.getPrefHeight());
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
			reproductor.reproducir("charmander");
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
			reproductor.reproducir("squirtle");;});

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
			reproductor.reproducir("bulbasaur");;});

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
			reproductor.reproducir("rattata");;
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
			reproductor.reproducir("jigglypuf");;
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
			reproductor.reproducir("chansey");;
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
				pantallaBatalla.cargarPantalla(stage,controlador,reproductor);
			}
			else{
				this.cargarPantalla(stage, controlador,2, reproductor);

			}
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
		contenedorHorizontalInferior.getChildren().addAll(botonLimpiar, botonContinuar);
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
}