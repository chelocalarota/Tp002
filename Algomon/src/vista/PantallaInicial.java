package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaInicial {

	ControladorLogicoDelJuego controlador;


	public PantallaInicial(ControladorLogicoDelJuego controlador){
		this.controlador = controlador;
	}

	public void cargarPantalla(Stage stage, PantallaEleccionAlgomon pantallaEleccion) {

		AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/sonidos/intro_pokemon.mp3").toExternalForm());
		musicaPantallaInicial.play();
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
        	musicaPantallaInicial.stop();
        	this.controlador.crearJuegoNuevo();

        	pantallaEleccion.cargarPantalla(stage,this.controlador,1);
        });
		botonNuevoJuego.setEffect(dropShadow);
        Button botonOpciones = creadorBoton.crearBoton("Opciones","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonOpciones.setEffect(dropShadow);
        Button botonAyuda = creadorBoton.crearBoton("Ayuda","-fx-font:  22 arial; -fx-base: #FFFFFF;");
		botonAyuda.setEffect(dropShadow);
        Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonSalir.setEffect(dropShadow);
        botonSalir.setOnAction(event -> {
			musicaPantallaInicial.stop();
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
        border.setBackground(new Background(new BackgroundImage(new Image("vista/imagenes/fondoPantallaInicio.jpg",981,600,false,false),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));
        Scene principal = new Scene(border, 981, 600);
        stage.setScene(principal);
        stage.show();
	}

}
