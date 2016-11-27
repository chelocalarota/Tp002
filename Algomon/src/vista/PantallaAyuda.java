package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PantallaAyuda {
	
	public void cargarPantalla() {
		int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	  
		
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

    };
}

