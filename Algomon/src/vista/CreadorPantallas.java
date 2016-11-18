package vista;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
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
import modelo.algomon.Algomon;

public class CreadorPantallas {
	Stage stage;
	ControladorLogicoDelJuego controladorLogico;
	public CreadorPantallas(Stage stage) {
		this.stage = stage;
	}
	public void crearPantallaBatalla() {
	       
		BorderPane border = new BorderPane();
        HBox contenedorHorizontalTop = new HBox();
        VBox contenedorHorizontalBottom = new VBox();
        VBox contenedorVerticalIzquierdo = new VBox();
        VBox contenedorVerticalCentral = new VBox();
        VBox contenedorVerticalDerecho = new VBox();
       
        border.setTop(contenedorHorizontalTop);
        border.setLeft(contenedorVerticalIzquierdo);
        border.setCenter(contenedorVerticalCentral);
        border.setRight(contenedorVerticalDerecho);
        border.setBottom(contenedorHorizontalBottom);
        
        CreadorImagen creadorImagen = new CreadorImagen();
        
        //Menu
        MenuBar menuBar = new MenuBar();
        
        // --- Menu File
        Menu menuFile = new Menu("File");
 
        // --- Menu Edit
        Menu menuEdit = new Menu("Edit");
 
        // --- Menu View
        Menu menuView = new Menu("View");
 
        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
        
        
        contenedorHorizontalTop.getChildren().addAll(menuBar);
        
        
        //Notificaciones
        TextArea textArea = new TextArea();
        contenedorHorizontalBottom.getChildren().add(new Label("notificaciones:"));
        contenedorHorizontalBottom.getChildren().addAll(textArea);
        
        //Batalla

        HBox contenedorAlgomonesActivos = new HBox();
        
        
        ImageView algomonJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",100,100,false,true);
        ImageView algomonJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",100,100,false,true);
        
        contenedorAlgomonesActivos.getChildren().addAll(algomonJugador1,algomonJugador2);

        contenedorAlgomonesActivos.setSpacing(100);
        contenedorAlgomonesActivos.setAlignment(Pos.BOTTOM_CENTER);
        
        
        //Estados
        HBox contenedorEstados = new HBox();
        VBox contenedorEstadosJugador1 = new VBox();
        VBox contenedorEstadosJugador2 = new VBox();
        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
        

        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

        
        contenedorEstados.getChildren().addAll(contenedorEstadosJugador1, contenedorEstadosJugador2);
       
        contenedorEstados.setSpacing(100);
        contenedorEstados.setAlignment(Pos.TOP_CENTER);
        
        contenedorVerticalCentral.getChildren().addAll(contenedorEstados, contenedorAlgomonesActivos);
        contenedorVerticalCentral.setSpacing(125);
        
        
        
        //Parte del jugador 1
        
        
		
        ImageView avatarJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("vista/avatar1.png",100,100,false,true);
        HBox contenedorAvatarJugador1 = new HBox();
        contenedorAvatarJugador1.getChildren().addAll(avatarJugador1);
        contenedorAvatarJugador1.setAlignment(Pos.BASELINE_CENTER);
        
        ImageView primerAlgomonJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        ImageView segundoAlgomonJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        ImageView terceroAlgomonJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        HBox contenedorAlgomonesJugador1 = new HBox();
        contenedorAlgomonesJugador1.getChildren().addAll(primerAlgomonJugador1, segundoAlgomonJugador1, terceroAlgomonJugador1);
        contenedorAlgomonesJugador1.setAlignment(Pos.BASELINE_CENTER);
        
        VBox contenedorBotonesJugador1 = new VBox();
        CreadorBoton creadorBoton = new CreadorBoton();
        
        Button botonAtacarJugador1 = creadorBoton.crearBoton("ATACAR","-fx-font: 16 arial; -fx-base: #b6e7c9;");
       
        //Accion del atacar
		
        Button botonCambiarAlgomonJugador1 = creadorBoton.crearBoton("CAMBIAR\nALGOMON","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		botonCambiarAlgomonJugador1.setMinHeight(50.0);
		
		//Accion del cambiar algomon
		Button botonUsarItemJugador1 = creadorBoton.crearBoton("USAR ITEM","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		//Accion del usar item
     
		contenedorBotonesJugador1.getChildren().addAll(botonAtacarJugador1,botonCambiarAlgomonJugador1, botonUsarItemJugador1);
        contenedorBotonesJugador1.setSpacing(25);
        contenedorBotonesJugador1.setAlignment(Pos.BASELINE_CENTER);
        
        contenedorVerticalIzquierdo.getChildren().addAll(contenedorAvatarJugador1, contenedorAlgomonesJugador1, contenedorBotonesJugador1);
        
        
        
        
        //Parte del jugador 2
        
        ImageView avatarJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/avatar2.png",100,100,false,true);
        HBox contenedorAvatarJugador2 = new HBox();
        contenedorAvatarJugador2.getChildren().addAll(avatarJugador2);
        contenedorAvatarJugador2.setAlignment(Pos.BASELINE_CENTER);
        
        ImageView primerAlgomonJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        ImageView segundoAlgomonJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        ImageView terceroAlgomonJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/pikachu.png",30,30,false,true);
        HBox contenedorAlgomonesJugador2 = new HBox();
        contenedorAlgomonesJugador2.getChildren().addAll(primerAlgomonJugador2, segundoAlgomonJugador2, terceroAlgomonJugador2);
        contenedorAlgomonesJugador2.setAlignment(Pos.BASELINE_CENTER);
        
        VBox contenedorBotonesJugador2 = new VBox();
        
        Button botonAtacarJugador2 = creadorBoton.crearBoton("ATACAR","-fx-font: 16 arial; -fx-base: #b6e7c9;");
        //Accion del atacar
		Button botonCambiarAlgomonJugador2 = creadorBoton.crearBoton("CAMBIAR\nALGOMON","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		botonCambiarAlgomonJugador2.setMinHeight(50.0);
		//Accion del cambiar algomon
		Button botonUsarItemJugador2 = creadorBoton.crearBoton("USAR ITEM","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		//Accion del usar item
     
		contenedorBotonesJugador2.getChildren().addAll(botonAtacarJugador2,botonCambiarAlgomonJugador2, botonUsarItemJugador2);
        contenedorBotonesJugador2.setSpacing(25);
        contenedorBotonesJugador2.setAlignment(Pos.BASELINE_CENTER);
        
        contenedorVerticalDerecho.getChildren().addAll(contenedorAvatarJugador2,contenedorAlgomonesJugador2, contenedorBotonesJugador2);
        
        Scene principal = new Scene(border, 981, 600);
        stage.setScene(principal);
	}
	public void crearPantallaInicial() {
		this.controladorLogico = new ControladorLogicoDelJuego();
		AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/intro Pokemon.mp3").toExternalForm());
		musicaPantallaInicial.play();
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
        	musicaPantallaInicial.stop();
        	this.crearPantallaJugador();
        	this.controladorLogico.crearJuegoNuevo();
        });
		Button botonCargarJuego = creadorBoton.crearBoton("Cargar Juego","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonOpciones = creadorBoton.crearBoton("Opciones","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonAyuda = creadorBoton.crearBoton("Ayuda","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		botonSalir.setOnAction(event -> {
			musicaPantallaInicial.stop();
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
        Scene principal = new Scene(border, 981, 600);
        this.stage.setScene(principal);
        this.stage.show();
	}
	private void crearPantallaJugador() {
		DropShadow sombraBoton = new DropShadow();
        sombraBoton.setOffsetY(2.0);
        sombraBoton.setOffsetX(2.0);
        sombraBoton.setColor(Color.PINK);
    	
        Label label1 = new Label("Jugador");
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
			this.crearPantallaEleccionAlgomon();
			
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
		Scene escenaCargarJugador= new Scene(grilla, 981, 600);
		
		this.stage.setScene(escenaCargarJugador);
	}
	private void crearPantallaEleccionAlgomon() {
			CreadorImagen creadorImagen = new CreadorImagen();
			ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("vista/charmander.PNG", 150, 150, false, true);
			ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("vista/Squirtle.PNG", 150, 150, false, true);
			ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("vista/rattata.PNG", 150, 150, false, true);
			ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("vista/Chansey.PNG",150,150,false,true);
			ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("vista/Bulbasaur.PNG", 150, 150, false, true);
			ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("vista/jigglypuff.PNG", 150, 150, false, true);
			VBox contenedorVertical = new VBox();
			HBox contenedorHorizontalSuperior = new HBox();
			HBox contenedorHorizontalMedio = new HBox();
			HBox contenedorHorizontalInferior = new HBox();
			CreadorBoton creadorBoton = new CreadorBoton();
			ArrayList<Button> listaDeBotones = new ArrayList<Button>();
			ArrayList<AudioClip> listaDeSonidos = new ArrayList<AudioClip>();
			
			Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
			listaDeBotones.add(botonCharmander);
			AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/Charmander_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoCharmander);
			
			Button botonChansey = creadorBoton.crearBoton("chansey", imageViewChansey);
			listaDeBotones.add(botonChansey);
			AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/Chansey_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoChansey);
			
			Button botonSquirtle =creadorBoton.crearBoton("squirtle", imageViewSquirtle);
			listaDeBotones.add(botonSquirtle);
			AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/Squirtle_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoSquirtle);
			
			Button botonRattata =creadorBoton.crearBoton("rattata", imageViewRattata);
			listaDeBotones.add(botonRattata);
			AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/Rattata_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoRattata);
			
			Button botonBulbasaur =creadorBoton.crearBoton("bulbasaur", imageViewBulbasaur);
			listaDeBotones.add(botonBulbasaur);
			AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/Bulbasaur_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoBulbasaur);
			
			Button botonJigglypuff =creadorBoton.crearBoton("jigglypuff", imageViewJigglypuff);
			listaDeBotones.add(botonJigglypuff);
			AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/Jigglypuff_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoJigglypuff);
			
			Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
			botonContinuar.setDisable(true);
			for (Button boton:listaDeBotones){
				boton.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
				boton.setMaxSize(280, contenedorHorizontalSuperior.getPrefHeight());
				boton.setMinSize(280, contenedorHorizontalSuperior.getPrefHeight());
			}
			botonCharmander.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoCharmander.play();});
			botonSquirtle.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarSquirtleJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoSquirtle.play();});
			
			botonBulbasaur.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarBulbasaurJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoBulbasaur.play();});
			
			botonRattata.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarRattataJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoRattata.play();});
			botonJigglypuff.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarJigglypuffJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoJigglypuff.play();});
			botonChansey.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarChanseyJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoChansey.play();});
			
			botonContinuar.setOnAction(event->{
				this.controladorLogico.cambiarJugador();
				if(this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.crearPantallaBatalla();
				}
				else{
					this.crearPantallaJugador();
				}
			});
			contenedorVertical.setSpacing(100);
			contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
			contenedorHorizontalSuperior.setSpacing(60);
			contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
			contenedorHorizontalMedio.setSpacing(60);
			contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalInferior.getChildren().add(botonContinuar);
			contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);
			
			contenedorVertical.getChildren().addAll(contenedorHorizontalMedio,contenedorHorizontalInferior);
		    BorderPane border = new BorderPane();
			border.setTop(contenedorHorizontalSuperior);
			border.setCenter(contenedorVertical);
			Scene escenaElegirAlgomon= new Scene(border, 981, 600);
		    stage.setScene(escenaElegirAlgomon); 
		}
	
	
}
