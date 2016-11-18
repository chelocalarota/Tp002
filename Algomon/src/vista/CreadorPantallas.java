package vista;

import java.util.ArrayList;

import javafx.geometry.Pos;
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

public class CreadorPantallas {
	Stage stage;
	ControladorLogicoDelJuego controladorLogico;
	public CreadorPantallas(Stage stage) {
		this.stage = stage;
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
<<<<<<< HEAD
        	this.crearPantallaJugador(this.stage);
=======
        	this.crearPantallaJugador();
>>>>>>> refs/remotes/origin/branchBrian
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
<<<<<<< HEAD
	private void crearPantallaJugador(Stage stage2) {
=======
	private void crearPantallaJugador() {
>>>>>>> refs/remotes/origin/branchBrian
		DropShadow sombraBoton = new DropShadow();
        sombraBoton.setOffsetY(2.0);
        sombraBoton.setOffsetX(2.0);
        sombraBoton.setColor(Color.PINK);
<<<<<<< HEAD

        Label label1 = new Label("Jugador 1");
=======
    	
        Label label1 = new Label("Jugador");
>>>>>>> refs/remotes/origin/branchBrian
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
<<<<<<< HEAD
			this.crearPantallaEleccionAlgomon(stage);

=======
			this.crearPantallaEleccionAlgomon();
			
>>>>>>> refs/remotes/origin/branchBrian
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
<<<<<<< HEAD
		grilla.add(contenedorVertical,2,2);
		Scene escenaCargarJugador= new Scene(grilla, 681, 600);
		stage.setScene(escenaCargarJugador);

	}
	private void crearPantallaEleccionAlgomon(Stage stage) {
		int cantidadAlgomon = 0;
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("vista/charmander.PNG", 150, 150, false, true);
		ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("vista/Chansey.PNG",150,150,false,true);
		CreadorBoton creadorBoton = new CreadorBoton();
		Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
//<<<<<<< HEAD
//		botonCharmander.setOnAction(event ->{
//			this.controladorLogico.agregarCharmanderJugadorActual();
//		});
//		cantidadAlgomon+=1;
//		
//=======
//		//botonCharmander.setOnAction(event ->{
//			//if (cantidadAlgomon == 2){
//				//this.controladorLogico.agregarCharmanderJugadorActual();
//			//}
//			//else{
//				//this.controladorLogico.agregarCharmanderJugadorActual();
//				//CambiarDeScene
//			//}
//		//});
//
//>>>>>>> origin/master
		Button botonChansey = creadorBoton.crearBoton("  chansey    ",imageViewChansey);
		botonChansey.setOnAction(event ->{
			this.controladorLogico.agregarChanseyJugadorActual();
		});
		if (cantidadAlgomon == 3){
			this.crearPantallaJugador(stage);
		}
		VBox contenedorVertical = new VBox();
		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalInferior = new HBox();
		contenedorHorizontalSuperior.getChildren().addAll(botonCharmander);
		contenedorHorizontalSuperior.setSpacing(10);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
		contenedorHorizontalInferior.getChildren().addAll(botonChansey);
		contenedorHorizontalInferior.setSpacing(10);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);
		contenedorVertical.getChildren().addAll(contenedorHorizontalSuperior,contenedorHorizontalInferior);
		GridPane grilla = new GridPane();
		grilla.add(contenedorVertical,2,2);
		Scene escenaElegirAlgomon= new Scene(grilla, 681, 600);
	    stage.setScene(escenaElegirAlgomon);
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
        
        contenedorEstadosJugador1.getChildren().add(new Label("VIDA: 100"));
        contenedorEstadosJugador1.getChildren().add(new Label("ESTADO: NORMAL"));
        

        contenedorEstadosJugador2.getChildren().add(new Label("VIDA: 100"));
        contenedorEstadosJugador2.getChildren().add(new Label("ESTADO: NORMAL"));
        
        
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
        
        
        Scene principal = new Scene(border, 681, 600);
        
        this.stage.setScene(principal);
        this.stage.show();
	}
=======
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
			
			Button botonChansey = creadorBoton.crearBoton("chansey",imageViewChansey);
			listaDeBotones.add(botonChansey);
			AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/Chansey_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoChansey);
			
			Button botonSquirtle =creadorBoton.crearBoton("squirtle",imageViewSquirtle);
			listaDeBotones.add(botonSquirtle);
			AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/Squirtle_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoSquirtle);
			
			Button botonRattata =creadorBoton.crearBoton("rattata",imageViewRattata);
			listaDeBotones.add(botonRattata);
			AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/Rattata_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoRattata);
			
			Button botonBulbasaur =creadorBoton.crearBoton("bulbasaur",imageViewBulbasaur);
			listaDeBotones.add(botonBulbasaur);
			AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/Bulbasaur_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoBulbasaur);
			
			Button botonJigglypuff =creadorBoton.crearBoton("jigglypuff",imageViewJigglypuff);
			listaDeBotones.add(botonJigglypuff);
			AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/Jigglypuff_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoJigglypuff);
			
			Button botonContinuar = creadorBoton.crearBoton("Continuar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
			botonContinuar.setDisable(true);
			int indice = 0;
			for (Button boton:listaDeBotones){
				boton.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
				boton.setMaxSize(280, contenedorHorizontalSuperior.getPrefHeight());
				boton.setMinSize(280, contenedorHorizontalSuperior.getPrefHeight());
				creadorBoton.setearBotonAlgomon(listaDeBotones, boton,botonContinuar,this.controladorLogico,listaDeSonidos.get(indice));
				indice+=1;
			}
			
			
			botonContinuar.setOnAction(event->{
				this.controladorLogico.cambiarJugador();
				if(this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.stage.close();
				}
				this.crearPantallaJugador();
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
	
>>>>>>> refs/remotes/origin/branchBrian
	
}
