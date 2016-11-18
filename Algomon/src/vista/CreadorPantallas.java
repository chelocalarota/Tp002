package vista;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CreadorPantallas {
	Stage stage;
	ControladorLogicoDelJuego controladorLogico;
	public CreadorPantallas(Stage stage) {
		this.stage = stage;
	}
	public void crearPantallaInicial() {
		this.controladorLogico = new ControladorLogicoDelJuego();
		//AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/intro Pokemon.mp3").toExternalForm());
		//musicaPantallaInicial.play();
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewTitulo = creadorImagen.crearImageView("vista/Algomon.png");
        ImageView imageViewPikachu = creadorImagen.crearImageViewConTamanioEspecifico("vista/Pikachu.png",200,200,false,true);
        ImageView imageViewPikachu2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/Pikachu.png",200,200,false,true);

        BorderPane border = new BorderPane();
        HBox contenedorHorizontal = new HBox();
        VBox contenedorVerticalIzquierdo = new VBox();
        VBox contenedorVerticalCentral = new VBox();
        VBox contenedorVerticalDerecho = new VBox();
        border.setTop(contenedorHorizontal);
        border.setLeft(contenedorVerticalIzquierdo);
        border.setCenter(contenedorVerticalCentral);
        border.setRight(contenedorVerticalDerecho);
        
        HBox contenedorBotones = new HBox();
        CreadorBoton creadorBoton = new CreadorBoton();
        creadorBoton.crearBoton("Nuevo Juego","-fx-font: 20 arial; -fx-base: #b6e7c9;");
        Button botonNuevoJuego = creadorBoton.crearBoton("Nuevo Juego","-fx-font: 20 arial; -fx-base: #b6e7c9;");
        botonNuevoJuego.setOnAction(event ->{
        	//musicaPantallaInicial.stop();
        	this.crearPantallaJugador(this.stage);
        	this.controladorLogico.crearJuegoNuevo();
        });
		Button botonCargarJuego = creadorBoton.crearBoton("Cargar Juego","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonOpciones = creadorBoton.crearBoton("Opciones","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonAyuda = creadorBoton.crearBoton("Ayuda","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		botonSalir.setOnAction(event -> {
			//musicaPantallaInicial.stop();
			this.stage.close();
        });
		

        contenedorBotones.getChildren().addAll(botonAyuda,botonSalir);
        contenedorBotones.setSpacing(25);
        contenedorBotones.setAlignment(Pos.BASELINE_CENTER);
        contenedorHorizontal.getChildren().addAll(imageViewTitulo);
        contenedorHorizontal.setAlignment(Pos.BOTTOM_CENTER);
        contenedorVerticalCentral.getChildren().addAll(botonNuevoJuego,botonCargarJuego,botonOpciones,contenedorBotones);
        contenedorVerticalCentral.setSpacing(25);
        contenedorVerticalCentral.setAlignment(Pos.BASELINE_CENTER);
        contenedorVerticalIzquierdo.getChildren().addAll(imageViewPikachu);
        contenedorVerticalDerecho.getChildren().addAll(imageViewPikachu2);
        Scene principal = new Scene(border, 681, 600);
        this.stage.setScene(principal);
        this.stage.show();
	}
	private void crearPantallaJugador(Stage stage2) {
		DropShadow sombraBoton = new DropShadow();
        sombraBoton.setOffsetY(2.0);
        sombraBoton.setOffsetX(2.0);
        sombraBoton.setColor(Color.PINK);
    	
        Label label1 = new Label("Jugador 1");
		Label label2 = new Label("Nombre:");
		TextField textField = new TextField ();
		GridPane grilla = new GridPane();
		
		CreadorBoton creadorBoton = new CreadorBoton();
		
		VBox contenedorVertical = new VBox();
		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalInferior = new HBox();
		Button botonLimpiar = creadorBoton.crearBoton("Limpiar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonLimpiar.setEffect(sombraBoton);
		Button botonAceptar =  creadorBoton.crearBoton("Aceptar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonAceptar.setOnAction(event ->{
			this.controladorLogico.setNombreJugadorActual(textField.getText());
			this.crearPantallaEleccionAlgomon(stage);
			
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
		grilla.add(contenedorVertical,4,4);
		Scene escenaCargarJugador= new Scene(grilla, 981, 700);
		stage.setScene(escenaCargarJugador);
	}
	private void crearPantallaEleccionAlgomon(Stage stage) {
			CreadorImagen creadorImagen = new CreadorImagen();
			ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("vista/charmander.PNG", 150, 150, false, true);
			ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("vista/Squirtle.PNG", 150, 150, false, true);
			ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("vista/rattata.PNG", 150, 150, false, true);
			ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("vista/Chansey.PNG",150,150,false,true);
			ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("vista/Bulbasaur.PNG", 150, 150, false, true);
			ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("vista/jigglypuff.PNG", 150, 150, false, true);
			CreadorBoton creadorBoton = new CreadorBoton();
			ArrayList<Button> listaDeBotones = new ArrayList<Button>();
			Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
			listaDeBotones.add(botonCharmander);
			Button botonChansey = creadorBoton.crearBoton("  chansey    ",imageViewChansey);
			listaDeBotones.add(botonChansey);
			Button botonSquirtle =creadorBoton.crearBoton("  squirtle    ",imageViewSquirtle);
			listaDeBotones.add(botonSquirtle);
			Button botonRattata =creadorBoton.crearBoton("  rattata    ",imageViewRattata);
			listaDeBotones.add(botonRattata);
			Button botonBulbasaur =creadorBoton.crearBoton("  bulbasaur    ",imageViewBulbasaur);
			listaDeBotones.add(botonBulbasaur);
			Button botonJigglypuff =creadorBoton.crearBoton(" jigglypuff    ",imageViewJigglypuff);
			listaDeBotones.add(botonJigglypuff);
			Button botonContinuar = creadorBoton.crearBoton("Continuar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
			botonContinuar.setDisable(true);
			botonContinuar.setOnAction(event->{
				this.controladorLogico.cambiarJugador();
				this.crearPantallaJugador(stage);
			});
			
			botonCharmander.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			botonChansey.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			botonRattata.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			botonBulbasaur.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			botonSquirtle.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			botonJigglypuff.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton:listaDeBotones){
						boton.setDisable(true);
					}
					botonContinuar.setDisable(false);
					
				}
			});
			
			VBox contenedorVertical = new VBox();
			HBox contenedorHorizontalSuperior = new HBox();
			HBox contenedorHorizontalMedio = new HBox();
			HBox contenedorHorizontalInferior = new HBox();
			contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
			contenedorHorizontalSuperior.setSpacing(10);
			contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
			contenedorHorizontalMedio.setSpacing(10);
			contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalInferior.getChildren().add(botonContinuar);
			contenedorVertical.getChildren().addAll(contenedorHorizontalSuperior,contenedorHorizontalMedio,contenedorHorizontalInferior);
			GridPane grilla = new GridPane();
			grilla.add(contenedorVertical,2,2);
			Scene escenaElegirAlgomon= new Scene(grilla, 681, 600);
		    stage.setScene(escenaElegirAlgomon); 
		}
	
	
}
