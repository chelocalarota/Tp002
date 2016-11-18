package vista;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Vista extends Application {

	@Override
	public void start(Stage Stage) {
		Scene principal;

		Image image1 = new Image("vista/Algomon.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image1);

        Image image2 = new Image("vista/Pikachu.png",200,200,false,true);
		ImageView iv2 = new ImageView();
        iv2.setImage(image2);

        Image image3 = new Image("vista/Pikachu.png",200,200,false,true);
		ImageView iv3 = new ImageView();
        iv3.setImage(image3);

        BorderPane border = new BorderPane();
        HBox hbox = new HBox();
        VBox vboxIzq = new VBox();
        VBox vboxCenter = new VBox();
        VBox vboxDer = new VBox();
        border.setTop(hbox);
        border.setLeft(vboxIzq);
        border.setCenter(vboxCenter);
        HBox hboxBotones = new HBox();
        border.setRight(vboxDer);

        Button btn1 = new Button("Nuevo Juego");
        btn1.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");
		Button btn2 = new Button("Cargar Juego");
		btn2.setStyle("-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button btn3 = new Button("Opciones");
		btn3.setStyle("-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button btn4 = new Button("Ayuda");
		btn4.setStyle("-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button btn5 = new Button("Salir");
		btn5.setStyle("-fx-font:  16 arial; -fx-base: #b6e7c9;");

        hboxBotones.getChildren().addAll(btn4,btn5);
        hboxBotones.setSpacing(25);
        hboxBotones.setAlignment(Pos.BASELINE_CENTER);
        hbox.getChildren().addAll(iv1);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        vboxCenter.getChildren().addAll(btn1,btn2,btn3,hboxBotones);
        vboxCenter.setSpacing(25);
        vboxCenter.setAlignment(Pos.BASELINE_CENTER);
        vboxIzq.getChildren().addAll(iv2);
        vboxDer.getChildren().addAll(iv3);

        principal = new Scene(border, 681, 600);

        Stage.setScene(principal);
        Stage.setTitle("Algomon-v0.1");
        Stage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}

}
