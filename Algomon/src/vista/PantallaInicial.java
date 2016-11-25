package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;


import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PantallaInicial {

	ControladorLogicoDelJuego controlador;
	ReproductorDeSonidos reproductor; 


	public PantallaInicial(ControladorLogicoDelJuego controlador,ReproductorDeSonidos reproductor){
		this.controlador = controlador;
		this.reproductor = reproductor;
	}

	public void cargarPantalla(Stage stage, PantallaEleccionAlgomon pantallaEleccion) {
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	    reproductor.playMusicaInicial();
		
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewTitulo = creadorImagen.crearImageView("/vista/imagenes/algomon.png");

        BorderPane border = new BorderPane();
        HBox contenedorHorizontal = new HBox();
        VBox contenedorVerticalCentral = new VBox();
        border.setTop(contenedorHorizontal);
        border.setCenter(contenedorVerticalCentral);

        HBox contenedorBotones = new HBox();
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetX(4.0);
        dropShadow.setOffsetY(4.0);
        CreadorBoton creadorBoton = new CreadorBoton();
        Button botonNuevoJuego = creadorBoton.crearBoton("Nuevo Juego","-fx-font: 22 arial; -fx-base: #FFFFFF;");
        botonNuevoJuego.setOnAction(event ->{
        	reproductor.stopMusicaInicial();
        	this.controlador.crearJuegoNuevo();

        	pantallaEleccion.cargarPantalla(stage,this.controlador,1, reproductor);
        });
		botonNuevoJuego.setEffect(dropShadow);
        Button botonOpciones = creadorBoton.crearBoton("Opciones","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonOpciones.setEffect(dropShadow);
        botonOpciones.setOnAction(event ->{
        	PantallaOpciones pantallaOpciones = new PantallaOpciones(this.controlador);
        	pantallaOpciones.cargarPantalla(stage,this.reproductor);
        });
        Button botonAyuda = creadorBoton.crearBoton("Ayuda","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonAyuda.setOnAction(event->{

          final Stage stage2 = new Stage(StageStyle.TRANSPARENT);
            Group rootGroup = new Group();
            Scene scene2 = new Scene(rootGroup, ancho, alto, Color.TRANSPARENT);
            stage2.setScene(scene2);
            stage2.centerOnScreen();
            stage2.show();
            CreadorImagen creador = new CreadorImagen();
            ImageView imagen = creador.crearImageView("vista/imagenes/pantalla_ayuda.png");
            CreadorBoton creadorBoton2 = new CreadorBoton();
            Button close = creadorBoton2.crearBoton("Cerrar","-fx-font: 57 arial; -fx-base: #FFFFFF;");
            close.setOnAction(new EventHandler<ActionEvent>() {
                public void handle(ActionEvent event) {
                    stage2.close();

                }

            });
            VBox vBox = new VBox();
            vBox.setSpacing(10);
            vBox.setPadding(new Insets(60, 0, 0, 20));
            vBox.setAlignment(Pos.TOP_CENTER);
            vBox.getChildren().addAll(close);
            vBox.setMinSize(1300,1300);
            rootGroup.getChildren().addAll(imagen,vBox);

        });
		botonAyuda.setEffect(dropShadow);
        Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonSalir.setEffect(dropShadow);
        botonSalir.setOnAction(event -> {
			reproductor.stopMusicaInicial();
			stage.close();
        });

        contenedorBotones.getChildren().addAll(botonAyuda,botonSalir);
        contenedorBotones.setSpacing(35);
        contenedorBotones.setAlignment(Pos.BASELINE_CENTER);
        contenedorHorizontal.getChildren().addAll(imageViewTitulo);
        contenedorHorizontal.setAlignment(Pos.BOTTOM_CENTER);
        contenedorVerticalCentral.getChildren().addAll(botonNuevoJuego,botonOpciones,contenedorBotones);
        contenedorVerticalCentral.setSpacing(40);
        contenedorVerticalCentral.setAlignment(Pos.BASELINE_CENTER);
        border.setBackground(new Background(new BackgroundImage(new Image("vista/imagenes/fondoPantallaInicio.jpg",ancho,alto,false,false),
                null,null, BackgroundPosition.CENTER,
         null)));
        Scene principal = new Scene(border,ancho-20,alto-100);
        stage.centerOnScreen();
        stage.setScene(principal);
        stage.show();
	}

}
