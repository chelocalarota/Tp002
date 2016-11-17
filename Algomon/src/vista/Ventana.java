package vista;


import javafx.application.Application;
import javafx.scene.media.AudioClip;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
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

		Scene principal, Jugador1;

		AudioClip mApplause = new AudioClip(this.getClass().getResource("/vista/intro Pokemon.mp3").toExternalForm());
		mApplause.play();
		mApplause.setCycleCount(AudioClip.INDEFINITE);
		mApplause.play();

		Image image1 = new Image("vista/Algomon.png");
		ImageView iv1 = new ImageView();
        iv1.setImage(image1);

        Image image2 = new Image("vista/Pikachu.png",200,200,false,true);
		ImageView iv2 = new ImageView();
        iv2.setImage(image2);

        BackgroundImage myBI= new BackgroundImage(new Image("vista/fondo.jpg",320,320,true,true), null, null, null, null);
        DropShadow r = new DropShadow();
        r.setOffsetY(2.0);
        r.setOffsetX(2.0);
        r.setColor(Color.BLACK);

        GridPane grid2 = new GridPane();
		VBox v2 = new VBox();
		HBox h2 = new HBox();
		HBox h3 = new HBox();
		Button btn6 = new Button("Limpiar");
		btn6.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		btn6.setEffect(r);
		Button btn7 = new Button("Aceptar");
		btn7.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		btn7.setEffect(r);
		Label label1 = new Label("Jugador 1");
		Label label2 = new Label("Nombre:");
		TextField textField = new TextField ();
		h2.getChildren().addAll(label2, textField);
		h2.setSpacing(10);
		h2.setAlignment(Pos.BASELINE_CENTER);
		h3.getChildren().addAll(btn6,btn7);
		h3.setSpacing(25);
		h3.setAlignment(Pos.BASELINE_CENTER);
		v2.getChildren().addAll(label1,h2,h3);
		v2.setAlignment(Pos.BASELINE_CENTER);
		grid2.setBackground(new Background(myBI));
		grid2.add(v2,2,2);
		Jugador1 = new Scene(grid2, 681, 600);



        HBox h = new HBox();
		VBox v = new VBox();
		GridPane grid = new GridPane();
		Image imageDecline = new Image("vista/Pokeball.PNG",30,30,true,true);
		Button btn1 = new Button("Nuevo Juego",new ImageView(imageDecline));
		btn1.setEffect(r);
		btn1.setStyle("-fx-font: 20 arial; -fx-base: #b6e7c9;");

		Button btn2 = new Button("Cargar Juego");
		btn2.setStyle("-fx-font:  16 arial; -fx-base: #b6e7c9;");
		btn2.setEffect(r);
		Button btn3 = new Button("Opciones");
		btn3.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		btn3.setEffect(r);
		Button btn4 = new Button("Ayuda");
		btn4.setEffect(r);
		btn4.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		Button btn5 = new Button("Salir");
		btn5.setEffect(r);
		btn5.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
		Label lbl = new Label("ALGOMON");

        lbl.setFont(new Font("Arial", 30));
        lbl.setTextFill(Color.web("#0076a3"));

        btn5.setOnAction(event -> {
        	Stage.close();
        });
        btn1.setOnAction(event -> Stage.setScene(Jugador1));

        h.getChildren().addAll(btn4,btn5);
        h.setSpacing(25);
        h.setAlignment(Pos.BASELINE_CENTER);
		v.getChildren().addAll(iv1,btn1,btn2, btn3,h);
		v.setSpacing(20);
		v.setAlignment(Pos.BASELINE_CENTER);
		grid.add(v,2,2);
		grid.add(iv2,3,6);
		grid.setBackground(new Background(myBI));
		GridPane.setHalignment(iv2, HPos.CENTER);

		principal = new Scene(grid, 681, 600);






        Stage.setTitle("Algomon-v0.2");
        Stage.setScene(principal);
        Stage.sizeToScene();
        Stage.centerOnScreen();
        Stage.setResizable(false);
        Stage.show();
    }

	public static void main(String[] args) {
		launch(args);
	}

}


