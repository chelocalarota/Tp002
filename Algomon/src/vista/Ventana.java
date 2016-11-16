package vista;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Ventana extends Application {

	@Override
	public void start(Stage Stage) {
		Image image1 = new Image("vista/Algomon.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image1);

        Image image2 = new Image("vista/Pikachu.png",200,200,false,true);
		ImageView iv2 = new ImageView();
        iv2.setImage(image2);

		HBox h = new HBox();
		VBox v = new VBox();
		GridPane grid = new GridPane();

		Button btn1 = new Button("Nuevo Juego");
		Button btn2 = new Button("Cargar Juego");
		Button btn3 = new Button("Opciones");
		Button btn4 = new Button("Ayuda");
		Button btn5 = new Button("Salir");
		Label lbl = new Label("ALGOMON");
        lbl.setFont(new Font("Arial", 30));
        lbl.setTextFill(Color.web("#0076a3"));

        btn5.setOnAction(event -> {
        	Stage.close();
        });

        h.getChildren().addAll(btn4,btn5);
        h.setSpacing(25);
        h.setAlignment(Pos.BASELINE_CENTER);
		v.getChildren().addAll(iv1,btn1,btn2, btn3,h);
		v.setSpacing(20);
		v.setAlignment(Pos.BASELINE_CENTER);
		grid.add(v,2,2);
		grid.add(iv2,3,6);
		BackgroundImage myBI= new BackgroundImage(new Image("vista/fondo.jpg",220,220,false,false), null, null, null, null);
		grid.setBackground(new Background(myBI));
		GridPane.setHalignment(iv2, HPos.CENTER);
		
		Scene scene = new Scene(grid, 681, 600);

		
		
        Stage.setTitle("Algomon-v0.2");
        Stage.setScene(scene);
        Stage.sizeToScene();
        Stage.centerOnScreen();
        Stage.setResizable(false);
        Stage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}

}


