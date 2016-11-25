package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PantallaOpciones {
	ControladorLogicoDelJuego controlador;
	


	public PantallaOpciones(ControladorLogicoDelJuego controlador){
		this.controlador = controlador;
	}

	public void cargarPantalla(Stage stage, ReproductorDeSonidos reproductor) {
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;

	    Label opcionesTitulo = new Label("OPCIONES");
		opcionesTitulo.setStyle("-fx-font: 38 arial;");
		opcionesTitulo.setTextFill(Color.WHITE);

        BorderPane border = new BorderPane();
        HBox contenedorHorizontal = new HBox();
        VBox contenedorVerticalCentral = new VBox();
        border.setTop(contenedorHorizontal);
        border.setCenter(contenedorVerticalCentral);

        
        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.BLACK);
        dropShadow.setOffsetX(4.0);
        dropShadow.setOffsetY(4.0);
        CreadorBoton creadorBoton = new CreadorBoton();
        Button botonDesactivarSonido = creadorBoton.crearBoton("DesactivarSonido","-fx-font: 22 arial; -fx-base: #FFFFFF;");
        botonDesactivarSonido.setOnAction(event ->{
        	reproductor.stopMusicaInicial();
        	reproductor.desactivar();
        	
        });
		botonDesactivarSonido.setEffect(dropShadow);
        Button botonMaximizar = creadorBoton.crearBoton("Maximizar","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonMaximizar.setEffect(dropShadow);
        botonMaximizar.setOnAction(event ->{
        	
        });
        Button botonMinimizar = creadorBoton.crearBoton("Minimizar","-fx-font:  22 arial; -fx-base: #FFFFFF;");
		botonMinimizar.setEffect(dropShadow);
        Button botonVolver = creadorBoton.crearBoton("Volver","-fx-font:  22 arial; -fx-base: #FFFFFF;");
        botonVolver.setEffect(dropShadow);
        botonVolver.setOnAction(event -> {
        	PantallaInicial pantallaInicial = new PantallaInicial(controlador, reproductor);
        	PantallaEleccionAlgomon pantallaEleccion = new PantallaEleccionAlgomon();
        	pantallaInicial.cargarPantalla(stage, pantallaEleccion);
			        });

        
        contenedorHorizontal.setAlignment(Pos.BOTTOM_CENTER);
        contenedorVerticalCentral.getChildren().addAll(opcionesTitulo, botonDesactivarSonido, botonMaximizar, botonMinimizar, botonVolver);
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
