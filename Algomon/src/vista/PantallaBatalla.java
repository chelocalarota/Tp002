package vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TitledPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.VictoriaObtenidaException;
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
	LinkedList<Button> botonesBloqueadosForEver;
	CuadroDeNotificaciones notificaciones;
	HashMap<String, AtaquesEnum>diccionarioEnums;
	int vidaAlgomon1;
	String estadoEfimeroAlgomon1;
	String estadoPersistenteAlgomon1;
	int vidaAlgomon2;
	String estadoEfimeroAlgomon2;
	String estadoPersistenteAlgomon2;
	
	
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
		diccionarioEnums.put("Canion de Agua", AtaquesEnum.CANION_DE_AGUA);
		diccionarioEnums.put("Canto", AtaquesEnum.CANTO);
		diccionarioEnums.put("ChupaVidas", AtaquesEnum.CHUPAVIDAS);
		diccionarioEnums.put("Fogonazo", AtaquesEnum.FOGONAZO);
		diccionarioEnums.put("LatigoCepa", AtaquesEnum.LATIGO_CEPA);
	}

		public void cargarPantalla(Stage stage, ControladorLogicoDelJuego controlador) {
			LinkedList<Button> botonesBloqueadosForEver = new LinkedList<Button>();
			LinkedList<Button> botonesDeCambioDeAlgomonDelJugador1 = new LinkedList<Button>();
			LinkedList<Button> botonesDeCambioDeAlgomonDelJugador2 = new LinkedList<Button>();
			
			BorderPane border = new BorderPane();
	        HBox contenedorHorizontalTop = new HBox();
	        VBox contenedorHorizontalBottom = new VBox();
	        VBox contenedorVerticalIzquierdo = new VBox();
	        VBox contenedorVerticalCentral = new VBox();
	        VBox contenedorVerticalDerecho = new VBox();


	        border.setTop(contenedorHorizontalTop);
	        border.setLeft(contenedorVerticalIzquierdo);
	        border.setCenter(contenedorVerticalCentral);
	        border.setRight(contenedorVerticalDerecho);
	        border.setBottom(contenedorHorizontalBottom);

	        CreadorImagen creadorImagen = new CreadorImagen();

	        //Menu
	        MenuBar menuBar = new MenuBar();

	        // --- Menu File
	        Menu menuFile = new Menu("File");

	        // --- Menu Edit
	        Menu menuEdit = new Menu("Edit");

	        // --- Menu View
	        Menu menuView = new Menu("View");

	        menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
	        menuBar.setMinWidth(1400);

	        contenedorHorizontalTop.getChildren().addAll(menuBar);


	        //Notificaciones
	        contenedorHorizontalBottom.getChildren().add(new Label("Notificaciones:"));
	        contenedorHorizontalBottom.getChildren().addAll(notificaciones.getTextArea());

	        //Batalla

	        HBox contenedorAlgomonesActivos = new HBox();

	        ImageView algomonJugador1 = this.imagenesJugadorInicial.get(0);
	        ImageView algomonJugador2 = this.imagenesJugadorSegundo.get(0);

	        contenedorAlgomonesActivos.getChildren().addAll(algomonJugador1,algomonJugador2);
	        contenedorAlgomonesActivos.setSpacing(1);
	        contenedorAlgomonesActivos.setAlignment(Pos.BOTTOM_CENTER);

	  
	        
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
	        contenedorVerticalCentral.setSpacing(2);



	        //Parte del jugador 1
	        TitledPane botonUsarItemJugador1 = new TitledPane();
	        TitledPane botonCambiarAlgomonJugador1 = new TitledPane();
	        ImageView avatarJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/avatar1.png",100,100,false,true);
	        HBox contenedorAvatarJugador1 = new HBox();
	        HBox contenedorAlgomonesJugador1 = new HBox();
	        contenedorAvatarJugador1.getChildren().addAll(avatarJugador1);
	        contenedorAvatarJugador1.setAlignment(Pos.BASELINE_CENTER);
	        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(0));
	        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(1));
	        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(2));
	        contenedorAlgomonesJugador1.setAlignment(Pos.BASELINE_CENTER);


	        ArrayList<Button> listaDeBotones1 = new ArrayList<Button>();
	        ArrayList<Button> listaDeBotones2 = new ArrayList<Button>();
	        
	        
	        VBox contenedorBotonesJugador1 = new VBox();
	        CreadorBoton creadorBoton = new CreadorBoton();
	        TitledPane botonAtacarJugador1 = new TitledPane();
	        GridPane grid = new GridPane();
	        ArrayList<Ataque> listaDeAtaques = controlador.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaques();
	       
	        //Ataques iniciales del jugador 1
	        
	        int indice = 0;
	        for(Ataque ataque: listaDeAtaques){
	        	Button boton = creadorBoton.crearBoton(ataque.getNombre(), "-fx-font: 14 arial; -fx-base: #b6e7c9;");
	        	listaDeBotones1.add(boton);
	        	boton.setOnAction(event->{
	        		this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2, listaDeBotones1, listaDeBotones2, ataque);
	        	});
	            grid.add(boton,indice,0);
	            indice+=1;
	        }

	        botonAtacarJugador1.setText("ATACAR");
	        botonAtacarJugador1.setExpanded(false);
	        botonAtacarJugador1.setContent(grid);


	        //Cambiar algomon jugador 1
	       
	        GridPane gridCambiarAlgomon = new GridPane();

	        CreadorBoton creadorBoton1 = new CreadorBoton();
	        
			Button botonPrimerAlgomon = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorInicial.get(0));
			Button botonSegundoAlgomon = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorInicial.get(1) );
			Button botonTercerAlgomon = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorInicial.get(2) );
			
			botonPrimerAlgomon.setDisable(true);
			this.botonesIntocablesTemporal.add(botonPrimerAlgomon);
			
			botonesDeCambioDeAlgomonDelJugador1.add(botonPrimerAlgomon);
			botonesDeCambioDeAlgomonDelJugador1.add(botonSegundoAlgomon);
			botonesDeCambioDeAlgomonDelJugador1.add(botonTercerAlgomon);
			
			gridCambiarAlgomon.add(botonPrimerAlgomon,0,0);
			gridCambiarAlgomon.add(botonSegundoAlgomon,1,0);
			gridCambiarAlgomon.add(botonTercerAlgomon,2,0);
			
			
			botonPrimerAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonPrimerAlgomon,
						botonSegundoAlgomon, botonTercerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 0);

				
				contenedorAlgomonesActivos.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(0);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

 	 	        ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
 	 	        int indiceNuevo = 0;
	    	    grid.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones1.add(boton2);
	            	boton2.setOnAction(event2->{
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque);
	            		
	            	});

	                grid.add(boton2,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);

			listaDeBotones1.add(botonSegundoAlgomon);
			botonSegundoAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonSegundoAlgomon,
						botonPrimerAlgomon, botonTercerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 1);
	    		
				contenedorAlgomonesActivos.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(1);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);
 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    int indiceNuevo = 0;
	    	    grid.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones1.add(boton2);
	            	boton2.setOnAction(event2->{
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque);	
	            	});

	                grid.add(boton2,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);
			//Ultimo boton de cambio de algomon del jugador 1
			listaDeBotones1.add(botonTercerAlgomon);
			botonTercerAlgomon.setOnAction(event->{
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones1, listaDeBotones2, botonTercerAlgomon,
						botonSegundoAlgomon, botonPrimerAlgomon,botonesDeCambioDeAlgomonDelJugador1, 2);
	    		
				contenedorAlgomonesActivos.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(2);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);

	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador1);

 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

 	 	        ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

 	 	        int indiceNuevo = 0;
	    	    grid.getChildren().clear();
	    	    //Nuevos botones de ataques debido al cambio por el tercer algomon
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones1.add(boton2);
	            	boton2.setOnAction(event2->{
	            		asignarEventABotonesAtaque(controlador, contenedorEstadosJugador1, contenedorEstadosJugador2,
								listaDeBotones1, listaDeBotones2, ataque);
	            	});
	                grid.add(boton2,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);


	        botonCambiarAlgomonJugador1.setText("CAMBIAR ALGOMON");

	        botonCambiarAlgomonJugador1.setExpanded(false);
	        botonCambiarAlgomonJugador1.setContent(gridCambiarAlgomon);


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
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonPocion,ItemsEnum.POCION, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonSuperPocion, ItemsEnum.SUPER_POCION, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonRestaurador, ItemsEnum.RESTAURADOR, botonesDeCambioDeAlgomonDelJugador1);
			this.setEventBotonItem(controlador, contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1, botonVitamina, ItemsEnum.VITAMINA,botonesDeCambioDeAlgomonDelJugador1);
			setearBotonContenedorDeItem(botonUsarItemJugador1, gridUsarItem, botonPocion, botonSuperPocion,
					botonRestaurador, botonVitamina);

			contenedorBotonesJugador1.getChildren().addAll(botonAtacarJugador1,botonCambiarAlgomonJugador1, botonUsarItemJugador1);
	        contenedorBotonesJugador1.setSpacing(25);
	        contenedorBotonesJugador1.setAlignment(Pos.BOTTOM_CENTER);

	        contenedorVerticalIzquierdo.getChildren().addAll(contenedorAvatarJugador1, contenedorBotonesJugador1);


	        //Parte del jugador 2

	        ImageView avatarJugador2 = creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/avatar2.png",100,100,false,true);
	        HBox contenedorAvatarJugador2 = new HBox();
	        contenedorAvatarJugador2.getChildren().addAll(avatarJugador2);
	        contenedorAvatarJugador2.setAlignment(Pos.BASELINE_CENTER);

	        VBox contenedorBotonesJugador2 = new VBox();
	        ArrayList<Ataque> listaDeAtaques2 = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

	        TitledPane botonAtacarJugador2 = new TitledPane();
	        GridPane grid2 = new GridPane();
	        int indice2 = 0;
	        //Ataques iniciales jugador2
	        for(Ataque ataque: listaDeAtaques2){
	        	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	        	boton2.setDisable(true);
	        	listaDeBotones2.add(boton2);
	        	boton2.setOnAction(event->{
	        		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	        				ataque);
	        		
	        	});
	            grid2.add(boton2,indice2,0);
	            indice2+=1;
	        }

	        botonAtacarJugador2.setText("ATACAR");
	        botonAtacarJugador2.setExpanded(false);
	        botonAtacarJugador2.setContent(grid2);

	        //Botones de cambio de algomon de jugador 2

	        TitledPane botonCambiarAlgomonJugador2 = new TitledPane();
	        GridPane gridCambiarAlgomon2 = new GridPane();
	        
	        Button botonPrimerAlgomon2 = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorSegundo.get(0));
	        Button botonSegundoAlgomon2 = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorSegundo.get(1) );
			Button botonTercerAlgomon2 = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorSegundo.get(2) );
			
			botonPrimerAlgomon2.setDisable(true);
			botonesIntocablesTemporal.add(botonPrimerAlgomon2);
			
			botonesDeCambioDeAlgomonDelJugador2.add(botonPrimerAlgomon2);
			botonesDeCambioDeAlgomonDelJugador2.add(botonSegundoAlgomon2);
			botonesDeCambioDeAlgomonDelJugador2.add(botonTercerAlgomon2);
			
			botonPrimerAlgomon2.setOnAction(event->{
				
				setEventBotonCambioDeAlgomon(controlador, listaDeBotones2, listaDeBotones1, botonPrimerAlgomon2,
						botonSegundoAlgomon2, botonTercerAlgomon2,botonesDeCambioDeAlgomonDelJugador2, 0);
	    	
				contenedorAlgomonesActivos.getChildren().remove(1);
	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(0);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

 	 	        ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
 	 	        //Ataques nuevos
 	 	        int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");
	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	        				ataque);
	            	});

	                grid2.add(boton2,indiceNuevo,0);
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
	    		
				contenedorAlgomonesActivos.getChildren().remove(1);

	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(1);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	        				ataque);
	            	});
	                grid2.add(boton2,indiceNuevo,0);
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
	    		
				contenedorAlgomonesActivos.getChildren().remove(1);
	    	    ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(2);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    this.actualizarJugadorDefensor(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton.setDisable(true);
	            	listaDeBotones2.add(boton);
	            	boton.setOnAction(event2->{
	            			 this.asignarEventABotonesAtaque(controlador, contenedorEstadosJugador2,
	 	 	        				contenedorEstadosJugador1, listaDeBotones2, listaDeBotones1,
	 	 	        				ataque);
	            	});

	                grid2.add(boton,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);
			
			gridCambiarAlgomon2.add(botonPrimerAlgomon2,0,0);
			gridCambiarAlgomon2.add(botonSegundoAlgomon2,1,0);
			gridCambiarAlgomon2.add(botonTercerAlgomon2,2,0);
	        botonCambiarAlgomonJugador2.setText("CAMBIAR ALGOMON");
	        botonCambiarAlgomonJugador2.setExpanded(false);
	        botonCambiarAlgomonJugador2.setContent(gridCambiarAlgomon2);


			//Uso de items jugador 2

	        TitledPane botonUsarItemJugador2 = new TitledPane();
			GridPane gridUsarItem2 = new GridPane();


			ImageView pocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pocion.png", 20, 20, false, true);
			ImageView superpocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/superpocion.png", 20, 20, false, true);
			ImageView restaurador2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/restaurador.png", 20, 20, false, true);
			ImageView vitamina2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/vitamina.png", 20, 20, false, true);
			
			Button botonPocion2 = creadorBoton1.crearBoton("Pocion", pocion2 );
			Button botonSuperPocion2 = creadorBoton1.crearBoton("Super pocion", superpocion2 );
			Button botonRestaurador2 = creadorBoton1.crearBoton("Restaurador", restaurador2 );
			Button botonVitamina2 = creadorBoton1.crearBoton("Vitamina", vitamina2 );
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
	        contenedorBotonesJugador2.setSpacing(25);
	        contenedorBotonesJugador2.setAlignment(Pos.BOTTOM_RIGHT);

	        contenedorVerticalDerecho.getChildren().addAll(contenedorAvatarJugador2, contenedorBotonesJugador2);
	        contenedorVerticalDerecho.setPrefWidth(500);
	        contenedorVerticalIzquierdo.setPrefWidth(500);

	        this.escena = new Scene(border, 981, 600);
	        stage.setScene(escena);
	        stage.setFullScreen(true);
	        stage.show();
	}

		private void setEventBotonCambioDeAlgomon(ControladorLogicoDelJuego controlador,
				ArrayList<Button> listaDeBotones1, ArrayList<Button> listaDeBotones2, Button botonElegido,
				Button primerBoton, Button segundoBoton,LinkedList<Button> listaDeBotonesDeCambio,int indice) {
			try {
				controlador.cambiarAlgomon(indice);
			} 
			catch (PokemonMuertoException e) {
				//Aca no tiene que llegar nunca
			}
			if (listaDeBotonesDeCambio.contains(primerBoton)){
				listaDeBotones1.add(primerBoton);
			}
			else if(listaDeBotonesDeCambio.contains(segundoBoton)){
				listaDeBotones1.add(segundoBoton);
			}
			botonElegido.setDisable(true);
			listaDeBotones1.remove(botonElegido);
			this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotones1, listaDeBotones2);
			
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

		private void setearBotonContenedorDeItem(TitledPane botonUsarItemJugador1, GridPane gridUsarItem,
				Button botonPocion, Button botonSuperPocion, Button botonRestaurador, Button botonVitamina) {
			gridUsarItem.add(botonPocion,0,0);
			gridUsarItem.add(botonSuperPocion,1,0);
			gridUsarItem.add(botonRestaurador,2,0);
			gridUsarItem.add(botonVitamina,3,0);
			botonUsarItemJugador1.setText("USAR ITEM");
			botonUsarItemJugador1.setExpanded(false);
			botonUsarItemJugador1.setContent(gridUsarItem);
		}

		private void setEventBotonItem(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotonesABloquear, ArrayList<Button> listaDeBotonesAAgregar, Button boton, ItemsEnum enumAsociado, 
				LinkedList<Button> listaDeBotonesDeCambio) {
			listaDeBotonesAAgregar.add(boton);
			boton.setOnAction(event->{
				usoDeItemYPasarTurno(controlador, contenedorEstadosJugador2, listaDeBotonesABloquear, listaDeBotonesAAgregar, 
						boton,enumAsociado, listaDeBotonesDeCambio);
			}
			);
		}
		
		private void usoDeItemYPasarTurno(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2,
				ArrayList<Button> listaDeBotonesDesbloqueables, ArrayList<Button> listaDeBotonesBloqueable, Button botonVitamina2, 
				ItemsEnum item,LinkedList<Button> listaDeBotonesDeCambio) {
			try {
				controlador.usarItem(item);
				controlador.verificarAlgomonActualMuerto();
				this.desbloquearBotonesDePrimerListaYBloquearBotonesDeLaSegunda(listaDeBotonesBloqueable , listaDeBotonesDesbloqueables);
				
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
			contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(controlador.obtenerJugadorActual().getPokemonActivo().getVida())));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
		}
}
