package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PantallaVictoria {
	public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador){
		BorderPane border = new BorderPane();
		CreadorImagen creador = new CreadorImagen();
		Label mensajeVictoria = new Label("¡VICTORIA!");
		Label mensajeAgradecimiento = new Label( "MUCHAS GRACIAS POR JUGAR ALGOMON.");
		mensajeAgradecimiento.setStyle("-fx-font: 55 arial");
		mensajeVictoria.setStyle("-fx-font: 55 arial");
		VBox contenedorMensajes = new VBox();
		contenedorMensajes.getChildren().addAll(mensajeVictoria,mensajeAgradecimiento);
		contenedorMensajes.setAlignment(Pos.BOTTOM_CENTER);
		HBox contenedorBotones = new HBox();
				border.setTop(mensajeVictoria);
		ReproductorDeSonidos reproductor = new ReproductorDeSonidos();
		CreadorBoton creadorBoton = new CreadorBoton();
        Button botonNuevoJuego = creadorBoton.crearBoton("Nuevo Juego","-fx-font: 55 arial; -fx-base: #FFFFFF;");
        botonNuevoJuego.setOnAction(event ->{
        	PantallaEleccionAlgomon pantallaEleccionAlgomon = new PantallaEleccionAlgomon();
          
        	pantallaEleccionAlgomon.cargarPantalla(stage, controlador, 1, reproductor);
        });
        Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  55 arial; -fx-base: #FFFFFF;");
        botonSalir.setOnAction(event -> {
			reproductor.stopMusicaInicial();
			stage.close();
        });
        border.setBottom(contenedorBotones);
        contenedorBotones.getChildren().add(botonNuevoJuego);
        contenedorBotones.setAlignment(Pos.CENTER);
		contenedorBotones.getChildren().add(botonSalir);
		ImageView copa = creador.crearImageView("vista/imagenes/copaPokemon.png");
		border.setCenter(copa);
		Scene escena = new Scene(border);
        stage.setScene(escena);
        stage.setFullScreen(true);
        stage.show();
	}
}
