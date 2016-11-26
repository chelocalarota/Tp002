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
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		BorderPane border = new BorderPane();
		CreadorImagen creador = new CreadorImagen();
		Label mensajeVictoria = new Label("VICTORIA");
		Label mensajeAgradecimiento = new Label( "MUCHAS GRACIAS POR JUGAR ALGOMON.");
		mensajeAgradecimiento.setStyle("-fx-font: 40 arial");
		mensajeVictoria.setStyle("-fx-font: 56 arial");
		VBox contenedorMensajes = new VBox();
		contenedorMensajes.getChildren().addAll(mensajeVictoria,mensajeAgradecimiento);
		contenedorMensajes.setAlignment(Pos.BOTTOM_CENTER);
		HBox contenedorBotones = new HBox();
		ReproductorDeSonidos reproductor = new ReproductorDeSonidos();
		CreadorBoton creadorBoton = new CreadorBoton();
      
        Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  55 arial; -fx-base: #FFFFFF;");
        botonSalir.setOnAction(event -> {
			reproductor.stopMusicaInicial();
			stage.close();
        });
        border.setBottom(contenedorBotones);
        contenedorBotones.setAlignment(Pos.CENTER);
		contenedorBotones.getChildren().add(botonSalir);
		ImageView copa = creador.crearImageView("vista/imagenes/copaPokemon.png");
		border.setCenter(copa);
		border.setTop(contenedorMensajes);
		Scene escena = new Scene(border,ancho-50,alto-50);
        stage.setScene(escena);
        stage.setMaximized(true);
        stage.show();
	}
}
