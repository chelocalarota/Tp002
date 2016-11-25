package vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.animation.FadeTransition;
import javafx.animation.FadeTransitionBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import modelo.VictoriaObtenidaException;
import modelo.algomon.EstaDormidoException;
import modelo.algomon.PokemonMuertoException;
import modelo.algomon.SinPuntosDePoderException;
import modelo.algomon.SinUsosDisponiblesException;
import modelo.ataques.Ataque;
import modelo.enums.AtaquesEnum;
import modelo.enums.ItemsEnum;

@SuppressWarnings("deprecation")
public class PantallaBatalla {

	Scene escena;
	private Stage stage;
	ReproductorDeSonidos reproductor;
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;
	LinkedList<Button> botonesIntocablesTemporal;
	LinkedList<Button> botonesBloqueadosForEver;
	CuadroDeNotificaciones notificaciones;
	HashMap<String, AtaquesEnum>diccionarioEnums;
	int vidaAlgomon1;
	String estadoEfimeroAlgomon1;
	String estadoPersistenteAlgomon1;
	int vidaAlgomon2;
	String estadoEfimeroAlgomon2;
	String estadoPersistenteAlgomon2;
	HashMap<String,AudioClip>diccionarioSonidosDeAtaques ;
	
	
	public PantallaBatalla(LinkedList<ImageView> miniaturasJugadorInicial, LinkedList<ImageView> imagenesJugadorInicial, LinkedList<ImageView> miniaturasJugadorSegundo, LinkedList<ImageView> imagenesJugadorSegundo){

		this.botonesBloqueadosForEver = new LinkedList<Button>();
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
		diccionarioEnums.put("Ca�on de Agua", AtaquesEnum.CANION_DE_AGUA);
		diccionarioEnums.put("Canto", AtaquesEnum.CANTO);
		diccionarioEnums.put("ChupaVidas", AtaquesEnum.CHUPAVIDAS);
		diccionarioEnums.put("Fogonazo", AtaquesEnum.FOGONAZO);
		diccionarioEnums.put("LatigoCepa", AtaquesEnum.LATIGO_CEPA);
		
			}

		public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador, ReproductorDeSonidos reproductor) {
			int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		    int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		    this.stage = stage;
		    this.reproductor = reproductor;
//		    AudioClip musicaBatalla = new AudioClip(this.getClass().getResource("/vista/sonidos/batalla.mp3").toExternalForm());
		   
		    
		   	botonesBloqueadosForEver = new LinkedList<Button>();
			LinkedList<Button> botonesDeCambioDeAlgomonDelJugador1 = new LinkedList<Button>();
			LinkedList<Button> botonesDeCambioDeAlgomonDelJugador2 = new LinkedList<Button>();
			ArrayList<Button> listaDeBotones1 = new ArrayList<Button>();
	        ArrayList<Button> listaDeBotones2 = new ArrayList<Button>(); 
			
			BorderPane panelPrincipal = new BorderPane();
	        HBox contenedorHorizontalTop = new HBox();
	        VBox contenedorHorizontalBottom = new VBox();
	        VBox contenedorVerticalIzquierdo = new VBox();
	        contenedorVerticalIzquierdo.setMaxWidth(350);
	        VBox contenedorVerticalCentral = new VBox();
	        contenedorVerticalCentral.setBackground(new Background(new BackgroundImage(new Image("vista/imagenes/fondoBatalla.png",900,5000,true,false),
	                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
	                BackgroundSize.DEFAULT)));
	        VBox contenedorVerticalDerecho = new VBox();
	        contenedorVerticalDerecho.setMaxWidth(350);

	        panelPrincipal.setTop(contenedorHorizontalTop);
	        panelPrincipal.setLeft(contenedorVerticalIzquierdo);
	        panelPrincipal.setCenter(contenedorVerticalCentral);
	        panelPrincipal.setRight(contenedorVerticalDerecho);
	        panelPrincipal.setBottom(contenedorHorizontalBottom);

	        CreadorImagen creadorImagen = new CreadorImagen();
	     	
	        MenuTop Menu = new MenuTop(stage, this.reproductor);
	        
	        contenedorHorizontalTop.getChildren().addAll(Menu.obtenerMenu());

	        //Notificaciones
	        contenedorHorizontalBottom.getChildren().add(new Label("Notificaciones:"));
	        contenedorHorizontalBottom.getChildren().addAll(notificaciones.getTextArea());

	        //Imagenes de algomones iniciales
	        VBox contenedorAlgomonesActivos = new VBox();
	        contenedorAlgomonesActivos.setSpacing(130);
	        HBox contenedorAlgomonesActivos1 = new HBox();
	        HBox contenedorAlgomonesActivos2= new HBox();
	        contenedorAlgomonesActivos2.setMinHeight(130);
	        ImageView algomonJugador1 = this.imagenesJugadorInicial.get(0);
	        ImageView algomonJugador2 = this.imagenesJugadorSegundo.get(0);
	        
	        
	        contenedorAlgomonesActivos1.getChildren().addAll(algomonJugador1);
	        contenedorAlgomonesActivos1.setAlignment(Pos.TOP_LEFT);
	        contenedorAlgomonesActivos2.getChildren().addAll(algomonJugador2);
	        contenedorAlgomonesActivos2.setAlignment(Pos.BOTTOM_RIGHT);
	        contenedorAlgomonesActivos.getChildren().addAll(contenedorAlgomonesActivos2,contenedorAlgomonesActivos1);


	        //Estados
	        HBox contenedorEstados = new HBox();
	        VBox contenedorEstadosJugador1 = new VBox();
	        VBox contenedorEstadosJugador2 = new VBox();
	        
	        actualizarJugadorActual(controlador,contenedorEstadosJugador1);
	        actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);

	        contenedorEstados.getChildren().addAll(contenedorEstadosJugador1, contenedorEstadosJugador2);
	        contenedorEstados.setSpacing(40);
	        contenedorEstados.setAlignment(Pos.TOP_CENTER);

	        contenedorVerticalCentral.getChildren().addAll(contenedorEstados, contenedorAlgomonesActivos);
	        contenedorVerticalCentral.setSpacing(68);



	        //Parte del jugador 1
	        //Paneles
	        TitledPane panelContenedorDeItemsJugador1 = new TitledPane();
	        panelContenedorDeItemsJugador1.setMaxWidth(286);
	        panelContenedorDeItemsJugador1.setMinWidth(286);
	        panelContenedorDeItemsJugador1.setExpanded(true);
	        
	        TitledPane panelContenedorDeCambioDeAlgomon = new TitledPane();
	        panelContenedorDeCambioDeAlgomon.setMaxWidth(286);
	        panelContenedorDeCambioDeAlgomon.setMinWidth(286);
	        panelContenedorDeCambioDeAlgomon.setExpanded(true);
	        

            FadeTransition fadeTransition = FadeTransitionBuilder.create()
                 .duration(Duration.seconds(0.4))
                 .node(contenedorAlgomonesActivos2.getChildren().get(0))
                 .fromValue(0.2)
                 .toValue(1)
                 .cycleCount(3)
                 .autoReverse(true)
                 .build();
            FadeTransition fadeTransition2 = FadeTransitionBuilder.create()
                    .duration(Duration.seconds(0.4))
                    .node(contenedorAlgomonesActivos1.getChildren().get(0))
                    .fromValue(0.2)
                    .toValue(1)
                    .cycleCount(3)
                    .autoReverse(true)
                    .build();
            
            
	        TitledPane botonAtacarJugador1 = new TitledPane();
	        botonAtacarJugador1.setMaxWidth(286);
	        botonAtacarJugador1.setMinWidth(286);
	        botonAtacarJugador1.setExpanded(true);
	        //Avatar
	        ImageView avatarJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/avatar1.png",100,100,false,true);
	        HBox contenedorAvatarJugador1 = new HBox();
	        contenedorAvatarJugador1.getChildren().addAll(avatarJugador1);
	        contenedorAvatarJugador1.setAlignment(Pos.TOP_CENTER);

	        VBox contenedorBotonesJugador1 = new VBox();
	        CreadorBoton creadorBoton = new CreadorBoton();
	       
	        //Botones de ataque iniciales
	        GridPane gridBotonesDeAtaqueJugador1 = new GridPane();
	        ArrayList<Ataque> listaDeAtaques = controlador.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaques();
	        int indice = 0;
	        for(Ataque ataque: listaDeAtaques){
	        	Button boton = creadorBoton.crearBoton(ataque.getNombre(), "-fx-font: 14 arial; -fx-base: #b6e7c9;");
	        	listaDeBotones1.add(boton);
	        	boton.setMinWidth(255);
	        	boton.setOnAction(event->{
	        		this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2, ataque, botonesDeCambioDeAlgomonDelJugador1, botonesDeCambioDeAlgomonDelJugador2);
	        		fadeTransition.play();
	        	});
	            gridBotonesDeAtaqueJugador1.add(boton,0,indice);
	            indice+=1;
	        }
	        botonAtacarJugador1.setText("ATACAR");
	        botonAtacarJugador1.setContent(gridBotonesDeAtaqueJugador1);

	        //Botones de cambiar algomon
	        GridPane gridCambiarAlgomon = new GridPane();
	        CreadorBoton creadorBoton1 = new CreadorBoton();  
			//Creacion y agregacion al grid
	        Button botonPrimerAlgomon = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorInicial.get(0));
			botonPrimerAlgomon.setMinWidth(256);
			botonPrimerAlgomon.setMinHeight(50);
			botonPrimerAlgomon.setDisable(true);
			this.botonesIntocablesTemporal.add(botonPrimerAlgomon);
			Button botonSegundoAlgomon = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorInicial.get(1) );
			botonSegundoAlgomon.setMinWidth(256);
			botonSegundoAlgomon.setMinHeight(50);
			Button botonTercerAlgomon = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorInicial.get(2) );
			botonTercerAlgomon.setMinWidth(256);
			botonTercerAlgomon.setMinHeight(50);
						
			botonesDeCambioDeAlgomonDelJugador1.add(botonPrimerAlgomon);
			botonesDeCambioDeAlgomonDelJugador1.add(botonSegundoAlgomon);
			botonesDeCambioDeAlgomonDelJugador1.add(botonTercerAlgomon);
			
			gridCambiarAlgomon.add(botonPrimerAlgomon,0,0);
			gridCambiarAlgomon.add(botonSegundoAlgomon,0,1);
			gridCambiarAlgomon.add(botonTercerAlgomon,0,2);
			//Seteo de los botones
			botonPrimerAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonPrimerAlgomon,
						botonSegundoAlgomon, botonTercerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 0);
				contenedorAlgomonesActivos1.getChildren().remove(0);
				
				ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(0);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos2.getChildren().remove(0);
	    	    
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
				ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
 	 	        int indiceNuevo = 0;
	    	    gridBotonesDeAtaqueJugador1.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button botonAtaque = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	botonAtaque.setDisable(true);
	            	listaDeBotones1.add(botonAtaque);
	            	botonAtaque.setOnAction(event2->{
	            		botonAtaque.setMinWidth(255);
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque, botonesDeCambioDeAlgomonDelJugador1, botonesDeCambioDeAlgomonDelJugador2);    		
	            		fadeTransition.play();
	            	});

	                gridBotonesDeAtaqueJugador1.add(botonAtaque,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);
			listaDeBotones1.add(botonSegundoAlgomon);
			botonSegundoAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonSegundoAlgomon,
						botonPrimerAlgomon, botonTercerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 1);
	    		
				contenedorAlgomonesActivos1.getChildren().remove(0);
				
				ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(1);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos2.getChildren().remove(0);
	    	    
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
	    	    
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    int indiceNuevo = 0;
	    	    gridBotonesDeAtaqueJugador1.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button botonAtaque = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	botonAtaque.setMinWidth(255);
	            	botonAtaque.setDisable(true);
	            	listaDeBotones1.add(botonAtaque);
	            	botonAtaque.setOnAction(event2->{
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque, botonesDeCambioDeAlgomonDelJugador2, botonesDeCambioDeAlgomonDelJugador2);	
	            		fadeTransition.play();
	            	});

	                gridBotonesDeAtaqueJugador1.add(botonAtaque,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);
			listaDeBotones1.add(botonTercerAlgomon);
			botonTercerAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonTercerAlgomon,
						botonSegundoAlgomon, botonPrimerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 2);
	    		
				contenedorAlgomonesActivos1.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(2);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos2.getChildren().remove(0);

	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
 	 	        ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

 	 	        int indiceNuevo = 0;
	    	    gridBotonesDeAtaqueJugador1.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button botonAtaque = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	botonAtaque.setMinWidth(255);
	            	botonAtaque.setDisable(true);
	            	listaDeBotones1.add(botonAtaque);
	            	botonAtaque.setOnAction(event2->{
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque, botonesDeCambioDeAlgomonDelJugador1, botonesDeCambioDeAlgomonDelJugador2);
	            		fadeTransition.play();
	            	});
	                gridBotonesDeAtaqueJugador1.add(botonAtaque,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);
	        panelContenedorDeCambioDeAlgomon.setText("CAMBIAR ALGOMON");
	        panelContenedorDeCambioDeAlgomon.setExpanded(true);
	        panelContenedorDeCambioDeAlgomon.setContent(gridCambiarAlgomon);
			
	        //Botones de uso de items del jugador 1
			
			GridPane gridUsarItem = new GridPane();

			ImageView pocion = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pocion.png", 20, 20, false, true);
			ImageView superpocion = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/superpocion.png", 20, 20, false, true);
			ImageView restaurador = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/restaurador.png", 20, 20, false, true);
			ImageView vitamina = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/vitamina.png", 20, 20, false, true);
			
			
			Button botonPocion = creadorBoton1.crearBoton("Pocion", pocion );
			Button botonSuperPocion = creadorBoton1.crearBoton("Super pocion", superpocion );
			Button botonRestaurador = creadorBoton1.crearBoton("Restaurador", restaurador );
			Button botonVitamina = creadorBoton1.crearBoton("Vitamina", vitamina );
			

			botonPocion.setMinWidth(135);
        	botonPocion.setMaxWidth(135);
        	botonSuperPocion.setMinWidth(135);
        	botonSuperPocion.setMaxWidth(135);
        	botonRestaurador.setMinWidth(135);
        	botonRestaurador.setMaxWidth(135);
        	botonVitamina.setMinWidth(135);
        	botonVitamina.setMaxWidth(135);
			
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonPocion,ItemsEnum.POCION, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonSuperPocion, ItemsEnum.SUPER_POCION, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonRestaurador, ItemsEnum.RESTAURADOR, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonVitamina, ItemsEnum.VITAMINA,botonesDeCambioDeAlgomonDelJugador1);
			setearBotonContenedorDeItem(panelContenedorDeItemsJugador1, gridUsarItem, botonPocion, botonSuperPocion,
					botonRestaurador, botonVitamina);

			contenedorBotonesJugador1.getChildren().addAll(botonAtacarJugador1,panelContenedorDeCambioDeAlgomon, panelContenedorDeItemsJugador1);
	        contenedorBotonesJugador1.setSpacing(2);
	        contenedorBotonesJugador1.setAlignment(Pos.BOTTOM_LEFT);

	        contenedorVerticalIzquierdo.getChildren().addAll(contenedorAvatarJugador1, contenedorBotonesJugador1);


	        //Parte del jugador 2
	        TitledPane botonAtacarJugador2 = new TitledPane();
	        botonAtacarJugador2.setMaxWidth(286);
	        botonAtacarJugador2.setMinWidth(286);
	        botonAtacarJugador2.setExpanded(true);
	       
	        TitledPane botonCambiarAlgomonJugador2 = new TitledPane();
	        botonCambiarAlgomonJugador2.setMaxWidth(286);
	        botonCambiarAlgomonJugador2.setMinWidth(286);
	        botonCambiarAlgomonJugador2.setExpanded(true);
	        

	        TitledPane botonUsarItemJugador2 = new TitledPane();
	        botonUsarItemJugador2.setExpanded(true);
	        botonUsarItemJugador2.setMaxWidth(286);
	        botonUsarItemJugador2.setMinWidth(286);
	        
	        //Avatar jugador 2
	        ImageView avatarJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/avatar2.png",100,100,false,true);
	        HBox contenedorAvatarJugador2 = new HBox();
	        contenedorAvatarJugador2.getChildren().addAll(avatarJugador2);
	        contenedorAvatarJugador2.setAlignment(Pos.BASELINE_CENTER);

	        VBox contenedorBotonesJugador2 = new VBox();
	        ArrayList<Ataque> listaDeAtaques2 = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

	       
	        GridPane grid2 = new GridPane();
	        int indice2 = 0;
	        //Ataques iniciales jugador2
	        for(Ataque ataque: listaDeAtaques2){
	        	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	        	boton2.setMinWidth(255);
	        	boton2.setDisable(true);
	        	listaDeBotones2.add(boton2);
	        	boton2.setOnAction(event->{
	        		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	        				ataque, botonesDeCambioDeAlgomonDelJugador2, botonesDeCambioDeAlgomonDelJugador1);
	        		 fadeTransition2.play();
	        	});
	            grid2.add(boton2,0,indice2);
	            indice2+=1;
	        }

	        botonAtacarJugador2.setText("ATACAR");
	        botonAtacarJugador2.setExpanded(true);
	        botonAtacarJugador2.setContent(grid2);

	        //Botones de cambio de algomon de jugador 2            
	        GridPane gridCambiarAlgomon2 = new GridPane();      
	        Button botonPrimerAlgomon2 = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorSegundo.get(0));			
			botonPrimerAlgomon2.setDisable(true);
			botonesIntocablesTemporal.add(botonPrimerAlgomon2);
	        Button botonSegundoAlgomon2 = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorSegundo.get(1) );
			Button botonTercerAlgomon2 = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorSegundo.get(2) );
			
			botonesDeCambioDeAlgomonDelJugador2.add(botonPrimerAlgomon2);
			botonesDeCambioDeAlgomonDelJugador2.add(botonSegundoAlgomon2);
			botonesDeCambioDeAlgomonDelJugador2.add(botonTercerAlgomon2);
			
			botonPrimerAlgomon2.setOnAction(event->{
				
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones2, listaDeBotones1, botonPrimerAlgomon2,
						botonSegundoAlgomon2, botonTercerAlgomon2,botonesDeCambioDeAlgomonDelJugador2, 0);
	    	
				contenedorAlgomonesActivos2.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(0);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos1.getChildren().remove(0);
	    	    actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
 	 	        //Ataques nuevos
 	 	        int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	boton2.setMinWidth(255);
	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	        				ataque, botonesDeCambioDeAlgomonDelJugador2, botonesDeCambioDeAlgomonDelJugador1);
	            		 fadeTransition2.play();
	            	});

	                grid2.add(boton2,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);
			//Boton de cambio por algomon numero 2
			listaDeBotones2.add(botonSegundoAlgomon2);
			botonSegundoAlgomon2.setDisable(true);
			botonSegundoAlgomon2.setOnAction(event->{
				
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones2, listaDeBotones1, botonSegundoAlgomon2,
						botonPrimerAlgomon2, botonTercerAlgomon2,botonesDeCambioDeAlgomonDelJugador2, 1);
	    		
				contenedorAlgomonesActivos2.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(1);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos1.getChildren().remove(0);
	    	    actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	boton2.setMinWidth(255);
	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	        				ataque, botonesDeCambioDeAlgomonDelJugador2, botonesDeCambioDeAlgomonDelJugador1);
	            		 fadeTransition2.play();
	            	});
	                grid2.add(boton2,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);

			listaDeBotones2.add(botonTercerAlgomon2);
			//Tercer boton de cambio
			botonTercerAlgomon2.setDisable(true);
			botonTercerAlgomon2.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones2, listaDeBotones1, botonTercerAlgomon2,
						botonSegundoAlgomon2, botonPrimerAlgomon2,botonesDeCambioDeAlgomonDelJugador2, 2);
				
				contenedorAlgomonesActivos2.getChildren().remove(0);
	    	    ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(2);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos1.getChildren().remove(0);
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos1.getChildren().add(nuevoAlgomonJugador1);
	    	    contenedorAlgomonesActivos2.getChildren().add(nuevoAlgomonJugador2);
	    	    
	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 14 arial; -fx-base: #b6e7c9;");
	            	boton.setMinWidth(255);
	            	boton.setDisable(true);
	            	listaDeBotones2.add(boton);
	            	boton.setOnAction(event2->{
	            			 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	 	        				ataque, botonesDeCambioDeAlgomonDelJugador2, botonesDeCambioDeAlgomonDelJugador1);
	            			 fadeTransition2.play();
	            	});

	                grid2.add(boton,0,indiceNuevo);
	                indiceNuevo+=1;
	            }
			}
			);
			botonPrimerAlgomon2.setMinWidth(256);
			botonPrimerAlgomon2.setMinHeight(50);
			botonSegundoAlgomon2.setMinWidth(256);
			botonSegundoAlgomon2.setMinHeight(50);
			botonTercerAlgomon2.setMinWidth(256);
			botonTercerAlgomon2.setMinHeight(50);
			gridCambiarAlgomon2.add(botonPrimerAlgomon2,0,0);
			gridCambiarAlgomon2.add(botonSegundoAlgomon2,0,1);
			gridCambiarAlgomon2.add(botonTercerAlgomon2,0,2);
	        botonCambiarAlgomonJugador2.setText("CAMBIAR ALGOMON");
	        botonCambiarAlgomonJugador2.setContent(gridCambiarAlgomon2);


			//Uso de items jugador 2

			GridPane gridUsarItem2 = new GridPane();


			ImageView pocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pocion.png", 20, 20, false, true);
			ImageView superpocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/superpocion.png", 20, 20, false, true);
			ImageView restaurador2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/restaurador.png", 20, 20, false, true);
			ImageView vitamina2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/vitamina.png", 20, 20, false, true);
			
			Button botonPocion2 = creadorBoton1.crearBoton("Pocion", pocion2 );
			Button botonSuperPocion2 = creadorBoton1.crearBoton("Super pocion", superpocion2 );
			Button botonRestaurador2 = creadorBoton1.crearBoton("Restaurador", restaurador2 );
			Button botonVitamina2 = creadorBoton1.crearBoton("Vitamina", vitamina2 );
			botonPocion2.setMinWidth(135);
        	botonPocion2.setMaxWidth(135);
        	botonSuperPocion2.setMinWidth(135);
        	botonSuperPocion2.setMaxWidth(135);
        	botonRestaurador2.setMinWidth(135);
        	botonRestaurador2.setMaxWidth(135);
        	botonVitamina2.setMinWidth(135);
        	botonVitamina2.setMaxWidth(135);
			setEventBotonItem(controlador, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2,
					botonPocion2, ItemsEnum.POCION, botonesDeCambioDeAlgomonDelJugador2);
			botonPocion2.setDisable(true);
			setEventBotonItem(controlador, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2,
					botonSuperPocion2,ItemsEnum.SUPER_POCION, botonesDeCambioDeAlgomonDelJugador2);
			botonSuperPocion2.setDisable(true);
			setEventBotonItem(controlador, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2,
					botonVitamina2,ItemsEnum.VITAMINA, botonesDeCambioDeAlgomonDelJugador2);
			botonVitamina2.setDisable(true);
			setEventBotonItem(controlador, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2,
					botonRestaurador2, ItemsEnum.RESTAURADOR, botonesDeCambioDeAlgomonDelJugador2);
			botonRestaurador2.setDisable(true);
			setearBotonContenedorDeItem(botonUsarItemJugador2, gridUsarItem2, botonPocion2, botonSuperPocion2,
					botonRestaurador2, botonVitamina2);

			contenedorBotonesJugador2.getChildren().addAll(botonAtacarJugador2,botonCambiarAlgomonJugador2, botonUsarItemJugador2);
	        contenedorBotonesJugador2.setSpacing(1);
	        contenedorBotonesJugador2.setAlignment(Pos.BOTTOM_CENTER);

	        contenedorVerticalDerecho.getChildren().addAll(contenedorAvatarJugador2, contenedorBotonesJugador2);
	        contenedorVerticalDerecho.setPrefWidth(500);
	        contenedorVerticalIzquierdo.setPrefWidth(500);

	        this.escena = new Scene(panelPrincipal,ancho-10,alto-70);
	        stage.setScene(escena);
	        stage.centerOnScreen();
//	        stage.setMaximized(true);
	        stage.show();
//	        musicaBatalla.setCycleCount(AudioClip.INDEFINITE);
//	        musicaBatalla.play();
	}

		private void setEventBotonCambioDeAlgomon(ControladorLogicoDelJuego controlador,
				ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2, Button botonElegido,
				Button primerBoton, Button segundoBoton,LinkedList<Button> listaDeBotonesDeCambio,int indice) {
			try {
				controlador.cambiarAlgomon(indice);
				notificaciones.notificar("");
			} 
			catch (PokemonMuertoException e) {
				//Aca no tiene que llegar nunca
			}
			if (this.botonesIntocablesTemporal.contains(primerBoton)){
				
				if (!this.botonesBloqueadosForEver.contains(primerBoton)){
					listaDeBotonesDeCambio.add(primerBoton);
					listaDeBotones1.add(primerBoton);
				}	
				this.botonesIntocablesTemporal.remove(primerBoton);
			}
			else if(this.botonesIntocablesTemporal.contains(segundoBoton)){
				
				if(!this.botonesBloqueadosForEver.contains(segundoBoton)){
					listaDeBotonesDeCambio.add(segundoBoton);
					listaDeBotones1.add(segundoBoton);
				}
				this.botonesIntocablesTemporal.remove(segundoBoton);
			}
			botonElegido.setDisable(true);
			listaDeBotones1.remove(botonElegido);
			this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
			this.botonesIntocablesTemporal.add(botonElegido);
			
			
		}
		
		private void asignarEventABotonesAtaque(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador1,
				VBox contenedorEstadosJugador2, ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2,
				Ataque ataque, LinkedList<Button> listaDeBotonesDeCambio,LinkedList<Button> listaDeBotonesDeCambio2) {
			try {
				this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
				this.actualizarJugadorActual(controlador, contenedorEstadosJugador1);
			    controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));

			    reproductor.reproducir(ataque.getNombre());

			    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
			    this.actualizarJugadorActual(controlador, contenedorEstadosJugador2);
			    this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
			    notificaciones.notificar("");
			} catch (SinPuntosDePoderException
					e) {
					notificaciones.notificar("No se pudo utilizar el ataque. No quedan puntos de poder para el mismo");
			} catch (PokemonMuertoException e) {
				
				if(controlador.obtenerJugadorActual().getPokemonActivo().estaMuerto()){	
					controlador.bloquearBotonesPorMuerteJugadorActual(listaDeBotones1, listaDeBotonesDeCambio, botonesBloqueadosForEver);
					notificaciones.notificar("El algomon atacante ha muerto debido a sus heridas");
				}
				else{
					this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
					controlador.bloquearBotonesPorMuerteJugadorActual(listaDeBotones2, listaDeBotonesDeCambio2,botonesBloqueadosForEver);
					this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
					this.actualizarJugadorActual(controlador, contenedorEstadosJugador1);
					notificaciones.notificar("El algomon defensor ha muerto. Por favor, elige otro");
					controlador.pasarTurno();
					
				}
			} catch (EstaDormidoException e) {
				notificaciones.notificar("No se pudo atacar debido a que el algomon esta dormido. Al realizar el cuarto ataque"
						+ "desde el cambio de estado, se despertara");
				this.actualizarJugadorActual(controlador, contenedorEstadosJugador1);
				this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
				this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
				controlador.pasarTurno();
			} catch (VictoriaObtenidaException e) {
				PantallaVictoria pantallaVictoria = new PantallaVictoria();
				pantallaVictoria.cargarPantalla(stage, controlador);
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
			Label vida = new Label(Integer.toString(controlador.obtenerJugadorDefensor().getPokemonActivo().getVida()));
			vida.setStyle("-fx-font: 17 arial");
			vida.setTextFill(Color.WHITE);
			contenedorEstadosJugador2.getChildren().add(vida);
			Label estadoEfimero = new Label("Estado efimero: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString());
			estadoEfimero.setStyle("-fx-font: 17 arial");
			estadoEfimero.setTextFill(Color.WHITE);
			contenedorEstadosJugador2.getChildren().add(estadoEfimero);
			Label estadoPermanente = new Label("Estado persistente: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString());
			estadoPermanente.setStyle("-fx-font: 17 arial");
			estadoPermanente.setTextFill(Color.WHITE);
	        contenedorEstadosJugador2.getChildren().add(estadoPermanente);
		}

		private void setearBotonContenedorDeItem(TitledPane botonUsarItemJugador1, GridPane gridUsarItem,
				Button botonPocion, Button botonSuperPocion, Button botonRestaurador, Button botonVitamina) {
			gridUsarItem.add(botonPocion,0,0);
			gridUsarItem.add(botonSuperPocion,1,0);
			gridUsarItem.add(botonRestaurador,0,1);
			gridUsarItem.add(botonVitamina,1,1);

			botonUsarItemJugador1.setText("USAR ITEM");
			botonUsarItemJugador1.setExpanded(true);
			botonUsarItemJugador1.setContent(gridUsarItem);
			notificaciones.notificar("");
		}

		private void setEventBotonItem(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotonesABloquear, ArrayList<Button> listaDeBotonesAAgregar, Button boton, ItemsEnum enumAsociado, 
				LinkedList<Button> listaDeBotonesDeCambio) {
			listaDeBotonesAAgregar.add(boton);
			boton.addEventFilter(MouseEvent.MOUSE_PRESSED, e -> {
            if( e.isPrimaryButtonDown()) {
            	usoDeItemYPasarTurno(controlador, contenedorEstadosJugador2, listaDeBotonesABloquear, listaDeBotonesAAgregar, 
					boton,enumAsociado, listaDeBotonesDeCambio);
			}
            else{
            	final Stage stage = new Stage(StageStyle.TRANSPARENT);

                Group rootGroup = new Group();

                Scene scene = new Scene(rootGroup, 1300, 900, Color.TRANSPARENT);

                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
                CreadorImagen creador = new CreadorImagen();
                ImageView imagen = creador.crearImageView("vista/imagenes/pantalla_items.png");

                CreadorBoton creadorBoton = new CreadorBoton();
                Button close = creadorBoton.crearBoton("Cerrar","-fx-font: 57 arial; -fx-base: #FFFFFF;");

                close.setOnAction(new EventHandler<ActionEvent>() {

                    public void handle(ActionEvent event) {

                        stage.close();

                    }

                });
                VBox vBox = new VBox();
                vBox.setSpacing(10);
                vBox.setPadding(new Insets(60, 0, 0, 20));
                vBox.setAlignment(Pos.TOP_CENTER);
                vBox.getChildren().addAll(close);
                vBox.setMinSize(1300,1300);
                rootGroup.getChildren().addAll(imagen,vBox);

            }

        });

    }

		private void usoDeItemYPasarTurno(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotonesDesbloqueables, ArrayList<Button> listaDeBotonesBloqueable, Button botonVitamina2, 
				ItemsEnum item,LinkedList<Button> listaDeBotonesDeCambio) {
			try {
				controlador.usarItem(item);
				controlador.verificarAlgomonActualMuerto();
				this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotonesBloqueable , listaDeBotonesDesbloqueables);

				reproductor.reproducir("item");
				if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(item)== 0){
					notificaciones.notificarNoHayItemDisponible(item);
					botonVitamina2.setDisable(true);
					botonesIntocablesTemporal.add(botonVitamina2);
					listaDeBotonesBloqueable.remove(botonVitamina2);
				}
				actualizarJugadorActual(controlador, contenedorEstadosJugador2);
		
			} 
			catch (SinUsosDisponiblesException e) {
				botonVitamina2.setDisable(true);
			}
			catch (PokemonMuertoException e) {
				controlador.bloquearBotonesPorMuerteJugadorActual(listaDeBotonesBloqueable,listaDeBotonesDeCambio,botonesBloqueadosForEver);
				controlador.pasarTurno();
			}
			controlador.pasarTurno();
		}

		private void actualizarJugadorActual(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2) {
			contenedorEstadosJugador2.getChildren().clear();
			Label vida = new Label(Integer.toString(controlador.obtenerJugadorActual().getPokemonActivo().getVida()));
			vida.setStyle("-fx-font: 17 arial; -fx-base: #FA8258");
			vida.setTextFill(Color.WHITE);
			contenedorEstadosJugador2.getChildren().add(vida);
			Label estadoEfimero = new Label("Estado efimero: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString());
			estadoEfimero.setStyle("-fx-font: 17 arial; -fx-base: #FA8258");
			estadoEfimero.setTextFill(Color.WHITE);
			contenedorEstadosJugador2.getChildren().add(estadoEfimero);
			Label estadoPermanente = new Label("Estado persistente: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString());
			estadoPermanente.setStyle("-fx-font: 17 arial; -fx-base: #FA8258");
			estadoPermanente.setTextFill(Color.WHITE);
			contenedorEstadosJugador2.getChildren().add(estadoPermanente);
		}
}

