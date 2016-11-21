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

	        this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

	        this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoEfimeroAlgomon2));

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
	        		try {
						controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
						//Actualizacion de estados del jugador 1
		        		contenedorEstadosJugador1.getChildren().clear();
		        		this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		 	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		 	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		 	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		        		
		 	 	        //Actualizacion de estados del jugador 2
		        		contenedorEstadosJugador2.getChildren().clear();
		 	 	        this.vidaAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		 	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		 	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		 	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		 	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		 	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));

		 	 	        for (Button boton2: listaDeBotones2){
		        			boton2.setDisable(false);
		        		}
		        		for (Button boton1: listaDeBotones1){
		        			boton1.setDisable(true);
		        		}

					} catch (SinPuntosDePoderException 
							| VictoriaObtenidaException e) {
						notificaciones.notificar("No se pudo utilizar el ataque jeje.");
						
					} catch (PokemonMuertoException e) {
						notificaciones.notificarPokemonMuerto();
						botonCambiarAlgomonJugador1.setDisable(true);
						botonUsarItemJugador1.setDisable(true);
						
						
					} catch (EstaDormidoException e) {
						controlador.pasarTurno();
						for (Button boton2: listaDeBotones2){
			        		boton2.setDisable(false);
			        	}
			        	for (Button boton1: listaDeBotones1){
			        		boton1.setDisable(true);
			        	}
					}	
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
			botonPrimerAlgomon.setDisable(true);
		      //Variables auxiliares
			
	        Button botonAlgomonElegidoJugador1 = botonPrimerAlgomon;
			this.botonesIntocablesTemporal.add(botonPrimerAlgomon);

			Button botonSegundoAlgomon = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorInicial.get(1) );
			Button botonTercerAlgomon = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorInicial.get(2) );

			gridCambiarAlgomon.add(botonPrimerAlgomon,0,0);
			gridCambiarAlgomon.add(botonSegundoAlgomon,1,0);
			gridCambiarAlgomon.add(botonTercerAlgomon,2,0);
			
			
			botonPrimerAlgomon.setOnAction(event->{
				try {
					controlador.cambiarAlgomon(0);
				} catch (PokemonMuertoException e) {
					notificaciones.notificarPokemonMuerto();
					botonPrimerAlgomon.setDisable(true);
				}
				if (botonesIntocablesTemporal.contains(botonSegundoAlgomon)){
					botonesIntocablesTemporal.remove(botonSegundoAlgomon);
	    			listaDeBotones1.add(botonSegundoAlgomon);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonTercerAlgomon);
	    			listaDeBotones1.add(botonTercerAlgomon);
	    		}
				botonPrimerAlgomon.setDisable(true);
	    		botonesIntocablesTemporal.add(botonPrimerAlgomon);
	    		listaDeBotones1.remove(botonPrimerAlgomon);

				for (Button boton: listaDeBotones2){
	    			boton.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(0);
	    	    ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(0);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    
	    	    //Actualizacion de estados del jugador 1
	    	    contenedorEstadosJugador1.getChildren().clear();
        		this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
 	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
 	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
 	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
 	 	        
 	 	        
 	 	        //Creacion de los nuevos botones de ataques en caso de cambio de algomon
 	 	        ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
 	 	        int indiceNuevo = 0;
	    	    grid.getChildren().clear();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones1.add(boton2);
	            	boton2.setOnAction(event2->{
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados de jugador 1
		            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		            		this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
			        		contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		     	 	        
		     	 	        for (Button boton: listaDeBotones2){
		            			boton.setDisable(false);
		            		}
		            		for (Button boton: listaDeBotones1){
		            			boton.setDisable(true);
		            		}

	            		} catch (SinPuntosDePoderException| PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    						notificaciones.notificar("No se pudo utilizar el ataque.");
	    						return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}
						}
	            		
	            	});

	                grid.add(boton2,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);
			//Segundo boton de cambio
			listaDeBotones1.add(botonSegundoAlgomon);
			botonSegundoAlgomon.setOnAction(event->{
				try {
					controlador.cambiarAlgomon(1);
				} catch (PokemonMuertoException e) {
					notificaciones.notificarPokemonMuerto();
					botonSegundoAlgomon.setDisable(true);
				}
				if (botonesIntocablesTemporal.contains(botonPrimerAlgomon)){
					botonesIntocablesTemporal.remove(botonPrimerAlgomon);
	    			listaDeBotones1.add(botonPrimerAlgomon);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonTercerAlgomon);
	    			listaDeBotones1.add(botonTercerAlgomon);
	    		}
	    		botonesIntocablesTemporal.add(botonSegundoAlgomon);
	    		listaDeBotones1.remove(botonSegundoAlgomon);
	    		botonSegundoAlgomon.setDisable(true);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(1);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);

	    	    contenedorEstadosJugador1.getChildren().clear();
	    	    this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
 	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
 	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
 	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
 	 	        contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    int indiceNuevo = 0;
	    	    grid.getChildren().clear();
	    	    //Nuevos botones de ataque al cambiar por algomon numero 2
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones1.add(boton2);
	            	boton2.setOnAction(event2->{
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados del jugador 1
		            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    	    	    this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
			        		contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		     	 	        
				            for (Button boton: listaDeBotones1){
		            			boton.setDisable(true);
		            		}
		            		for (Button boton: listaDeBotones2){
		            			boton.setDisable(false);
		            		}

	    				} catch (SinPuntosDePoderException| PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    					notificaciones.notificar("No se pudo utilizar el ataque.");
	    					return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}
						}
	            		
	            	});

	                grid.add(boton2,indiceNuevo,0);
	                indiceNuevo+=1;
	            }
			}
			);
			//Ultimo boton de cambio de algomon del jugador 1
			listaDeBotones1.add(botonTercerAlgomon);
			botonTercerAlgomon.setOnAction(event->{
				try {
					controlador.cambiarAlgomon(2);
				} catch (PokemonMuertoException e) {
					notificaciones.notificarPokemonMuerto();
					botonTercerAlgomon.setDisable(true);
				}
				if (botonesIntocablesTemporal.contains(botonPrimerAlgomon)){//si est�, es el primero el utilizado
					botonesIntocablesTemporal.remove(botonPrimerAlgomon);
	    			listaDeBotones1.add(botonPrimerAlgomon);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonSegundoAlgomon);
	    			listaDeBotones1.add(botonSegundoAlgomon);
	    		}
				botonTercerAlgomon.setDisable(true);
	    		botonesIntocablesTemporal.add(botonTercerAlgomon);
	    		listaDeBotones1.remove(botonTercerAlgomon);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(0);

	    		ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(2);
	    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);

	    	    contenedorEstadosJugador1.getChildren().clear();

	    	    this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
 	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
 	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
 	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
 	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

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
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados del jugador 1
		            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		            		this.vidaAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
			        		contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		     	 	       
		     	 	        for (Button boton: listaDeBotones1){
		            			boton.setDisable(true);
		            		}
		            		for (Button boton: listaDeBotones2){
		            			boton.setDisable(false);
		            		}

	            		} catch (SinPuntosDePoderException | PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    					notificaciones.notificar("No se pudo utilizar el ataque.");
	    					return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}
						}
	            		
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
			listaDeBotones1.add(botonPocion);

			botonPocion.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.POCION);

					for (Button boton1: listaDeBotones2){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones1){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
						botonPocion.setDisable(true);
						botonesIntocablesTemporal.add(botonPocion);
						listaDeBotones1.remove(botonPocion);
		    		}
		    		contenedorEstadosJugador1.getChildren().clear();
		    		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonPocion.setDisable(true);
				}
				controlador.pasarTurno();
			}
		
			);
			listaDeBotones1.add(botonSuperPocion);
			botonSuperPocion.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.SUPER_POCION);

					for (Button boton1: listaDeBotones2){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones1){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
						botonSuperPocion.setDisable(true);
						botonesIntocablesTemporal.add(botonSuperPocion);
						listaDeBotones1.remove(botonSuperPocion);
		    		}

		    		contenedorEstadosJugador1.getChildren().clear();
		    		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonSuperPocion.setDisable(true);
				}
				controlador.pasarTurno();
			}	
			);
			listaDeBotones1.add(botonRestaurador);
			botonRestaurador.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.RESTAURADOR);

					for (Button boton1: listaDeBotones2){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones1){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
						botonRestaurador.setDisable(true);
						botonesIntocablesTemporal.add(botonRestaurador);
						listaDeBotones1.remove(botonRestaurador);
		    		}
		    		contenedorEstadosJugador1.getChildren().clear();
		    		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonPocion.setDisable(true);
				}
				controlador.pasarTurno();
			}
			);
			listaDeBotones1.add(botonVitamina);
			botonVitamina.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.VITAMINA);

					for (Button boton1: listaDeBotones2){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones1){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
						botonVitamina.setDisable(true);
						botonesIntocablesTemporal.add(botonVitamina);
						listaDeBotones1.remove(botonVitamina);
		    		}
		    		contenedorEstadosJugador1.getChildren().clear();
		    		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonPocion.setDisable(true);
				}
				controlador.pasarTurno();
			}
			);
			gridUsarItem.add(botonPocion,0,0);
			gridUsarItem.add(botonSuperPocion,1,0);
			gridUsarItem.add(botonRestaurador,2,0);
			gridUsarItem.add(botonVitamina,3,0);


			botonUsarItemJugador1.setText("USAR ITEM");
			botonUsarItemJugador1.setExpanded(false);
			botonUsarItemJugador1.setContent(gridUsarItem);

			//Accion del usar item

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
	        //Ataques iniciales jugador1
	        for(Ataque ataque: listaDeAtaques2){
	        	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	        	boton2.setDisable(true);
	        	listaDeBotones2.add(boton2);
	        	boton2.setOnAction(event->{
	        		try {
						controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
						//Actualizacion de estados jugador1
		        		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		        		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
	     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
	     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
	     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
	     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
	     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
	     	 	        
	     	 	        //Actualizacion de estados del jugador 2
	     	 	        contenedorEstadosJugador2.getChildren().clear();
	            		this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
	     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
	     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
	     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
	     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
	     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
	     	 	        for (Button boton1: listaDeBotones1){
		        			boton1.setDisable(false);
		        		}
		        		for (Button boton: listaDeBotones2){
		        			boton.setDisable(true);
		        		}

					} catch (SinPuntosDePoderException | PokemonMuertoException
							| VictoriaObtenidaException e) {
    					notificaciones.notificar("No se pudo utilizar el ataque.");
    					return;
					} catch (EstaDormidoException e) {
						controlador.pasarTurno();
						for (Button boton: listaDeBotones2){
			        		boton.setDisable(false);
			        	}
			        	for (Button boton1: listaDeBotones1){
			        		boton1.setDisable(true);
			        	}
					}
	        		
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
	        Button botonSegundoAlgomon2 = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorSegundo.get(1) );
			Button botonPrimerAlgomon2 = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorSegundo.get(0));
			Button botonTercerAlgomon2 = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorSegundo.get(2) );
			botonPrimerAlgomon2.setDisable(true);
			botonesIntocablesTemporal.add(botonPrimerAlgomon2);
			botonPrimerAlgomon2.setOnAction(event->{
				try {
					controlador.cambiarAlgomon(0);
				} catch (PokemonMuertoException e) {
					botonPrimerAlgomon2.setDisable(true);
					notificaciones.notificarPokemonMuerto();
				}
				if (botonesIntocablesTemporal.contains(botonSegundoAlgomon2)){
					botonesIntocablesTemporal.remove(botonSegundoAlgomon2);
	    			listaDeBotones2.add(botonSegundoAlgomon2);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonTercerAlgomon2);
	    			listaDeBotones2.add(botonTercerAlgomon2);
	    		}
				botonPrimerAlgomon2.setDisable(true);
	    		botonesIntocablesTemporal.add(botonPrimerAlgomon2);
	    		listaDeBotones2.remove(botonPrimerAlgomon2);

				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(1);

	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(0);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);

	    	    contenedorEstadosJugador2.getChildren().clear();
	    	    this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
 	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
 	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
 	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
 	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
 	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
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
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados jugador1
			        		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
			        		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
		     	 	        contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		      	 	        for (Button boton1: listaDeBotones1){
		            			boton1.setDisable(false);
		            		}
		            		for (Button boton: listaDeBotones2){
		            			boton.setDisable(true);
		            		}

	    				} catch (SinPuntosDePoderException | PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    					notificaciones.notificar("No se pudo utilizar el ataque.");
	    					return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}
						}
	            		
	            		
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
				try {
					controlador.cambiarAlgomon(1);
				} catch (PokemonMuertoException e) {
				}
				if (botonesIntocablesTemporal.contains(botonPrimerAlgomon2)){
					botonesIntocablesTemporal.remove(botonPrimerAlgomon2);
	    			listaDeBotones2.add(botonPrimerAlgomon2);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonTercerAlgomon2);
	    			listaDeBotones2.add(botonTercerAlgomon2);
	    		}
	    		botonesIntocablesTemporal.add(botonSegundoAlgomon2);
	    		listaDeBotones2.remove(botonSegundoAlgomon2);
	    		botonSegundoAlgomon2.setDisable(true);
				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(1);

	    		ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(1);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);

	    	    actualizarJugador2PorItem(controlador, contenedorEstadosJugador2);
	    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);

	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados jugador1
			        		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
			        		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
		     	 	        contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		            		for (Button boton1: listaDeBotones1){
		            			boton1.setDisable(false);
		            		}
		            		for (Button boton: listaDeBotones2){
		            			boton.setDisable(true);
		            		}

	    				} catch (SinPuntosDePoderException| PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    					notificaciones.notificar("No se pudo utilizar el ataque.");
	    					return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
	    					//Falta copy paste
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}
						}
	            		
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
				try {
					controlador.cambiarAlgomon(2);
				} catch (PokemonMuertoException e) {
				}
				if (botonesIntocablesTemporal.contains(botonPrimerAlgomon2)){
					botonesIntocablesTemporal.remove(botonPrimerAlgomon2);
	    			listaDeBotones2.add(botonPrimerAlgomon2);
	    		}
	    		else{
	    			botonesIntocablesTemporal.remove(botonSegundoAlgomon2);
	    			listaDeBotones2.add(botonSegundoAlgomon2);
	    		}
	    		botonesIntocablesTemporal.add(botonTercerAlgomon2);
	    		listaDeBotones2.remove(botonTercerAlgomon2);
	    		botonTercerAlgomon2.setDisable(true);
				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		contenedorAlgomonesActivos.getChildren().remove(1);
	    	    ImageView nuevoAlgomonJugador2 =this.imagenesJugadorSegundo.get(2);
	    	    ImageView nuevoAlgomonJugador1 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
	    	    contenedorEstadosJugador2.getChildren().clear();
	    	    contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(controlador.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
	    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
	    	    int indiceNuevo = 0;
	    	    grid2.getChildren().clear();
	    	    ArrayList<Ataque> listaDeAtaquesNueva = controlador.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
	    	    for(Ataque ataque: listaDeAtaquesNueva){
	            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

	            	boton2.setDisable(true);
	            	listaDeBotones2.add(boton2);
	            	boton2.setOnAction(event2->{
	            		try {
	    					controlador.atacar(this.diccionarioEnums.get(ataque.getNombre()));
	    					//Actualizacion de estados jugador1
			        		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
			        		this.vidaAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon1 = controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.vidaAlgomon1)));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon1));
		     	 	        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon1));
		     	 	        
		     	 	        //Actualizacion de estados del jugador 2
		     	 	        contenedorEstadosJugador2.getChildren().clear();
		            		this.vidaAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getVida();
		     	 	        this.estadoEfimeroAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString();
		     	 	        this.estadoPersistenteAlgomon2 = controlador.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString();
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.vidaAlgomon2)));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.estadoEfimeroAlgomon2));
		     	 	        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.estadoPersistenteAlgomon2));
		            		for (Button boton1: listaDeBotones1){
		            			boton1.setDisable(false);
		            		}
		            		for (Button boton: listaDeBotones2){
		            			boton.setDisable(true);
		            		}

	    				} catch (SinPuntosDePoderException | PokemonMuertoException
	    						| VictoriaObtenidaException e) {
	    					notificaciones.notificar("No se pudo utilizar el ataque.");
	    					return;
	    				} catch (EstaDormidoException e) {
	    					controlador.pasarTurno();
							for (Button boton: listaDeBotones2){
				        		boton.setDisable(false);
				        	}
				        	for (Button boton1: listaDeBotones1){
				        		boton1.setDisable(true);
				        	}						}
	            		
	            	});

	                grid2.add(boton2,indiceNuevo,0);
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
			listaDeBotones2.add(botonPocion2);
			botonPocion2.setDisable(true);
			botonPocion2.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.POCION);

					for (Button boton1: listaDeBotones1){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones2){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
						botonPocion2.setDisable(true);
						botonesIntocablesTemporal.add(botonPocion2);
						listaDeBotones2.remove(botonPocion2);
		    		}
		    		actualizarJugador2PorItem(controlador, contenedorEstadosJugador2);

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
					botonVitamina2.setDisable(true);
				}
				controlador.pasarTurno();
			}
			);
			listaDeBotones2.add(botonSuperPocion2);
			botonSuperPocion2.setDisable(true);
			botonSuperPocion2.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.SUPER_POCION);

					for (Button boton1: listaDeBotones1){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones2){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
						botonSuperPocion2.setDisable(true);
						botonesIntocablesTemporal.add(botonSuperPocion2);
						listaDeBotones2.remove(botonSuperPocion2);
		    		}
		    		actualizarJugador2PorItem(controlador, contenedorEstadosJugador2);

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
					botonSuperPocion2.setDisable(true);
				}
				controlador.pasarTurno();
			}
			);
			listaDeBotones2.add(botonRestaurador2);
			botonRestaurador2.setDisable(true);
			botonRestaurador2.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.RESTAURADOR);

					for (Button boton1: listaDeBotones1){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones2){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
						botonRestaurador2.setDisable(true);
						botonesIntocablesTemporal.add(botonRestaurador2);
						listaDeBotones2.remove(botonRestaurador2);
		    		}
		    		actualizarJugador2PorItem(controlador, contenedorEstadosJugador2);

					} catch (SinUsosDisponiblesException e) {
						notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
						botonRestaurador2.setDisable(true);
					}
				controlador.pasarTurno();
			}
			);
			listaDeBotones2.add(botonVitamina2);
			botonVitamina2.setDisable(true);
			botonVitamina2.setOnAction(event->{
				try {
					controlador.usarItem(ItemsEnum.VITAMINA);

					for (Button boton1: listaDeBotones1){
		    			boton1.setDisable(false);
		    		}
		    		for (Button boton: listaDeBotones2){
		    			boton.setDisable(true);
		    		}
		    		if(controlador.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA)== 0){
		    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
						botonVitamina2.setDisable(true);
						botonesIntocablesTemporal.add(botonVitamina2);
						listaDeBotones2.remove(botonVitamina2);
		    		}
		    		actualizarJugador2PorItem(controlador, contenedorEstadosJugador2);

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonVitamina2.setDisable(true);
				}
				controlador.pasarTurno();
			}
			);
			gridUsarItem2.add(botonPocion2,0,0);
			gridUsarItem2.add(botonSuperPocion2,1,0);
			gridUsarItem2.add(botonRestaurador2,2,0);
			gridUsarItem2.add(botonVitamina2,3,0);


			botonUsarItemJugador2.setText("USAR ITEM");
			botonUsarItemJugador2.setExpanded(false);
			botonUsarItemJugador2.setContent(gridUsarItem2);

			//Accion del usar item

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

		private void actualizarJugador2PorItem(ControladorLogicoDelJuego controlador, VBox contenedorEstadosJugador2) {
			contenedorEstadosJugador2.getChildren().clear();
			contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(controlador.obtenerJugadorActual().getPokemonActivo().getVida())));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
			contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ controlador.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
		}
}