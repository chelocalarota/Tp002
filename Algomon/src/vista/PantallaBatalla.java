package vista;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import modelo.VictoriaObtenidaException;
import modelo.algomon.Algomon;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

public class PantallaBatalla {

	Scene escena;
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;
	LinkedList<Button> botonesIntocablesTemporal;
	CuadroDeNotificaciones notificaciones;
	HashMap<String, AtaquesEnum>diccionarioEnums;
	int vidaAlgomon1;
	String estadoEfimeroAlgomon1;
	String estadoPersistenteAlgomon1;
	int vidaAlgomon2;
	String estadoEfimeroAlgomon2;
	String estadoPersistenteAlgomon2;


	public PantallaBatalla(LinkedList<ImageView> miniaturasJugadorInicial, LinkedList<ImageView> imagenesJugadorInicial, LinkedList<ImageView> miniaturasJugadorSegundo, LinkedList<ImageView> imagenesJugadorSegundo){

		this.miniaturasJugadorInicial = miniaturasJugadorInicial;
		this.imagenesJugadorInicial = imagenesJugadorInicial;
		this.miniaturasJugadorSegundo = miniaturasJugadorSegundo;
		this.imagenesJugadorSegundo = imagenesJugadorSegundo;
		this.botonesIntocablesTemporal = new LinkedList<Button>();
		this.notificaciones = new CuadroDeNotificaciones();
		this.diccionarioEnums = new HashMap<String, AtaquesEnum>();
		diccionarioEnums.put("Ataque Rapido", AtaquesEnum.ATAQUE_RAPIDO);
		diccionarioEnums.put("Brasas", AtaquesEnum.BRASAS);
		diccionarioEnums.put("Burbuja", AtaquesEnum.BURBUJA);
		diccionarioEnums.put("Canion de Agua", AtaquesEnum.CANION_DE_AGUA);
		diccionarioEnums.put("Canto", AtaquesEnum.CANTO);
		diccionarioEnums.put("ChupaVidas", AtaquesEnum.CHUPAVIDAS);
		diccionarioEnums.put("Fogonazo", AtaquesEnum.FOGONAZO);
		diccionarioEnums.put("LatigoCepa", AtaquesEnum.LATIGO_CEPA);
	}

		public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador) {

	        VBox contenedorNotificaciones = new VBox();
	        contenedorNotificaciones.getChildren().add(notificaciones.getTextArea());
	        contenedorNotificaciones.setAlignment(Pos.CENTER_LEFT);

	        HBox contenedorButtons = crearBotones("Fight", "Run", "Bag", "Pokemons");

	        HBox lowerScreen = new HBox(100,contenedorNotificaciones, contenedorButtons);
	        lowerScreen.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

	        // Now, let's do the upper screen.
	        ImageView algomonJugador1 = this.imagenesJugadorInicial.get(0);
	        ImageView algomonJugador2 = this.imagenesJugadorSegundo.get(0);

	        Image imagenDeFondo = new Image("/vista/imagenes/background.png");
	        ImageView imageView = new ImageView(imagenDeFondo);

	        GridPane grid = new GridPane();
	        grid.getColumnConstraints().add(new ColumnConstraints(150));
	        grid.getColumnConstraints().add(new ColumnConstraints(150));
	        grid.getColumnConstraints().add(new ColumnConstraints(150));
	        grid.getColumnConstraints().add(new ColumnConstraints(150));
	        grid.getColumnConstraints().add(new ColumnConstraints(150));
	        grid.setHgap(10);
	        grid.setVgap(10);
	        grid.setPadding(new Insets(10, 10, 10, 10));

	        grid.add(algomonJugador1, 1, 2, 1, 1);
	        grid.add(algomonJugador2, 3, 1);
	        grid.setBackground(new Background(new BackgroundImage(imagenDeFondo,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER , BackgroundSize.DEFAULT)));

	        AnchorPane anchor = new AnchorPane();
	        anchor.getChildren().add(grid);

	        // Finally, everything together
	       BorderPane border = new BorderPane();
	       imageView.fitWidthProperty().bind(border.widthProperty());
	       border.setBottom(lowerScreen);
	       border.setCenter(anchor);


	        Scene scene = new Scene(border,800,500);
	        stage.setScene(scene);
	        stage.show();
	}

		private HBox crearBotones(String boton1, String boton2, String boton3, String boton4){

			CreadorBoton creadorBoton = new CreadorBoton();
			Button btn1 = creadorBoton.crearBoton(boton1, "-fx-font: 14 arial; -fx-base: #b6e7c9;");
			Button btn2 = creadorBoton.crearBoton(boton2, "-fx-font: 14 arial; -fx-base: #b6e7c9;");
			Button btn3 = creadorBoton.crearBoton(boton3, "-fx-font: 14 arial; -fx-base: #b6e7c9;");
			Button btn4 = creadorBoton.crearBoton(boton4, "-fx-font: 14 arial; -fx-base: #b6e7c9;");

			// We'll add the buttons in the order we want
	        // them to appear
			HBox buttons = new HBox(20, btn1, btn2, btn3,btn4);

	        buttons.setAlignment(Pos.CENTER_RIGHT);

	        return buttons;

		}

		private void setEventBotonAtaque(ControladorLogicoDelJuego controlador,HBox contenedor){

			ObservableList<Node> botones = contenedor.getChildren();
			Button botonAtaque = (Button) botones.get(0);
			botonAtaque.setOnAction(event ->{


				List<Algomon> algomones = controlador.juego.obtenerJugadorActual().obtenerAlgomon();
				Algomon algomon = algomones.get(0);
				ArrayList<Ataques> ataques = algomon.obtenerTodosLosAtaques();
				HBox buttons = crearBotones(ataques.get(0).getNombre(), String boton2, String boton3, String boton4)
			}


					);

		}


		private void setEventBotonCambioDeAlgomon(ControladorLogicoDelJuego controlador,
				ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2, Button botonElegido,
				Button segundoBoton, Button tercerBoton,int indice) {
			try {
				controlador.cambiarAlgomon(indice);
			} catch (PokemonMuertoException e) {
				notificaciones.notificarPokemonMuerto();
				botonElegido.setDisable(true);
			}
			if (botonesIntocablesTemporal.contains(segundoBoton)){
				botonesIntocablesTemporal.remove(segundoBoton);
				listaDeBotones1.add(segundoBoton);
			}
			else{
				botonesIntocablesTemporal.remove(tercerBoton);
				listaDeBotones1.add(tercerBoton);
			}
			botonElegido.setDisable(true);
			botonesIntocablesTemporal.add(botonElegido);
			listaDeBotones1.remove(botonElegido);
			this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);

		}

		private void setEventBotonItem(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2, Button boton) {
			listaDeBotones2.add(boton);
			boton.setDisable(true);
			boton.setOnAction(event->{
				usoDeItemYPasarTurno(controlador, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2, boton,ItemsEnum.RESTAURADOR);
			}
			);
		}


		private void asignarEventABotonesAtaque(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador1,
				VBox contenedorEstadosJugador2, ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2,
				Ataque ataque) {
			try {
			    controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
				this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
			    this.actualizarJugadorActual(controlador, contenedorEstadosJugador2);
			    this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
			} catch (SinPuntosDePoderException| PokemonMuertoException
					| VictoriaObtenidaException | EstaDormidoException e) {
					notificaciones.notificar("No se pudo utilizar el ataque.");
			}
		}

		private void desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(ArrayList<Button> listaDeBotones1,
				ArrayList<Button> listaDeBotones2) {
			for (Button boton2: listaDeBotones2){
				boton2.setDisable(false);
			}
			for (Button boton1: listaDeBotones1){
				boton1.setDisable(true);
			}
		}

		private void actualizarJugadorDefensor(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2) {
			contenedorEstadosJugador2.getChildren().clear();
	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(controlador.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
		}

		private void seteBotonContenedorDeItem(TitledPane botonUsarItemJugador1, GridPane gridUsarItem,
				Button botonPocion, Button botonSuperPocion, Button botonRestaurador, Button botonVitamina) {
			gridUsarItem.add(botonPocion,0,0);
			gridUsarItem.add(botonSuperPocion,1,0);
			gridUsarItem.add(botonRestaurador,2,0);
			gridUsarItem.add(botonVitamina,3,0);
			botonUsarItemJugador1.setText("USAR ITEM");
			botonUsarItemJugador1.setExpanded(false);
			botonUsarItemJugador1.setContent(gridUsarItem);
		}

		private void usoDeItemYPasarTurno(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2, Button botonVitamina2, ItemsEnum item) {
			try {
				controlador.usarItem(item);
				for (Button boton1: listaDeBotones1){
					boton1.setDisable(false);
				}
				for (Button boton: listaDeBotones2){
					boton.setDisable(true);
				}
				if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(item)== 0){
					notificaciones.notificarNoHayItemDisponible(item);
					botonVitamina2.setDisable(true);
					botonesIntocablesTemporal.add(botonVitamina2);
					listaDeBotones2.remove(botonVitamina2);
				}
				actualizarJugadorActual(controlador, contenedorEstadosJugador2);
			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(item);
				botonVitamina2.setDisable(true);
			}
			controlador.pasarTurno();
		}

		private void actualizarJugadorActual(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2) {
			contenedorEstadosJugador2.getChildren().clear();
			contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(controlador.obtenerJugadorActual().getPokemonActivo().getVida())));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
		}
}
