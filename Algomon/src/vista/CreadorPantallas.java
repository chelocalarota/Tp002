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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
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

public class CreadorPantallas {

	Stage stage;
	ControladorLogicoDelJuego controladorLogico;
	LinkedList<ImageView> miniaturasJugadorInicial;
	LinkedList<ImageView> imagenesJugadorInicial;
	LinkedList<ImageView> miniaturasJugadorSegundo;
	LinkedList<ImageView> imagenesJugadorSegundo;
	LinkedList<Button> botonesIntocables;
	HashMap<String, AtaquesEnum>diccionarioEnums;
	CuadroDeNotificaciones notificaciones;


	public CreadorPantallas(Stage stage) {
		this.stage = stage;
		this.miniaturasJugadorInicial = new LinkedList<ImageView>();
		this.imagenesJugadorInicial= new LinkedList<ImageView>();
		this.miniaturasJugadorSegundo = new LinkedList<ImageView>();
		this.imagenesJugadorSegundo = new LinkedList<ImageView>();
		this.botonesIntocables = new LinkedList<Button>();
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

	public void crearPantallaBatalla() {

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


        ImageView algomonJugador1 =this.imagenesJugadorInicial.get(0);
        ImageView algomonJugador2 =this.imagenesJugadorSegundo.get(0);

        contenedorAlgomonesActivos.getChildren().addAll(algomonJugador1,algomonJugador2);

        contenedorAlgomonesActivos.setSpacing(1);
        contenedorAlgomonesActivos.setAlignment(Pos.BOTTOM_CENTER);


        //Estados
        HBox contenedorEstados = new HBox();
        VBox contenedorEstadosJugador1 = new VBox();
        VBox contenedorEstadosJugador2 = new VBox();
        contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
        contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
        contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));


        contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
        contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
        contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));


        contenedorEstados.getChildren().addAll(contenedorEstadosJugador1, contenedorEstadosJugador2);

        contenedorEstados.setSpacing(25);
        contenedorEstados.setAlignment(Pos.TOP_CENTER);

        contenedorVerticalCentral.getChildren().addAll(contenedorEstados, contenedorAlgomonesActivos);
        contenedorVerticalCentral.setSpacing(2);



        //Parte del jugador 1

        ImageView avatarJugador1 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/avatar1.png",100,100,false,true);
        HBox contenedorAvatarJugador1 = new HBox();
        contenedorAvatarJugador1.getChildren().addAll(avatarJugador1);
        contenedorAvatarJugador1.setAlignment(Pos.BASELINE_CENTER);
        HBox contenedorAlgomonesJugador1 = new HBox();
        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(0));
        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(1));
        contenedorAlgomonesJugador1.getChildren().add((Node) miniaturasJugadorInicial.get(2));
        contenedorAlgomonesJugador1.setAlignment(Pos.BASELINE_CENTER);


        ArrayList<Button> listaDeBotones1 = new ArrayList<Button>();
        ArrayList<Button> listaDeBotones2 = new ArrayList<Button>();

        VBox contenedorBotonesJugador1 = new VBox();
        CreadorBoton creadorBoton = new CreadorBoton();
        ArrayList<Ataque> listaDeAtaques = this.controladorLogico.obtenerJugadorActual().getPokemonActivo().obtenerTodosLosAtaques();

        TitledPane botonAtacarJugador1 = new TitledPane();
        GridPane grid = new GridPane();
        int indice = 0;
        for(Ataque ataque: listaDeAtaques){
        	Button boton = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");
        	listaDeBotones1.add(boton);
        	boton.setOnAction(event->{
        		try {
					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));


				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
						| VictoriaObtenidaException e) {
					this.controladorLogico.cambiarJugador();
				}
        		contenedorEstadosJugador2.getChildren().clear();
	    		contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));

        		for (Button boton2: listaDeBotones2){
        			boton2.setDisable(false);
        		}
        		for (Button boton1: listaDeBotones1){
        			boton1.setDisable(true);
        		}
        	});
            grid.add(boton,indice,0);
            indice+=1;
        }

        botonAtacarJugador1.setText("ATACAR");
        botonAtacarJugador1.setExpanded(false);
        botonAtacarJugador1.setContent(grid);


        //Accion del atacar

        TitledPane botonCambiarAlgomonJugador1 = new TitledPane();
        GridPane gridCambiarAlgomon = new GridPane();
        CreadorBoton creadorBoton1 = new CreadorBoton();
		Button botonPrimerAlgomon = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorInicial.get(0));
		botonPrimerAlgomon.setDisable(true);
		botonesIntocables.add(botonPrimerAlgomon);
		Button botonSegundoAlgomon = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorInicial.get(1) );
		Button botonTercerAlgomon = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorInicial.get(2) );
		gridCambiarAlgomon.add(botonPrimerAlgomon,0,0);
		gridCambiarAlgomon.add(botonSegundoAlgomon,1,0);
		gridCambiarAlgomon.add(botonTercerAlgomon,2,0);
		botonPrimerAlgomon.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(0);
			} catch (PokemonMuertoException e) {
				System.out.println("no");
			}
			if (botonesIntocables.contains(botonSegundoAlgomon)){
				botonesIntocables.remove(botonSegundoAlgomon);
    			listaDeBotones1.add(botonSegundoAlgomon);
    		}
    		else{
    			botonesIntocables.remove(botonTercerAlgomon);
    			listaDeBotones1.add(botonTercerAlgomon);
    		}
			botonPrimerAlgomon.setDisable(true);
    		botonesIntocables.add(botonPrimerAlgomon);
    		listaDeBotones1.remove(botonPrimerAlgomon);

			for (Button boton1: listaDeBotones2){
    			boton1.setDisable(false);
    		}
    		for (Button boton: listaDeBotones1){
    			boton.setDisable(true);
    		}
    		contenedorAlgomonesActivos.getChildren().remove(0);
    	    ImageView nuevoAlgomonJugador1 =this.imagenesJugadorInicial.get(0);
    	    ImageView nuevoAlgomonJugador2 =(ImageView) contenedorAlgomonesActivos.getChildren().remove(0);
    	    contenedorEstadosJugador1.getChildren().clear();
    	    contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    int indiceNuevo = 0;
    	    grid.getChildren().clear();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));

            		} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}

            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
            		}
            	});

                grid.add(boton2,indiceNuevo,0);
                indiceNuevo+=1;
            }
		}
		);
		listaDeBotones1.add(botonSegundoAlgomon);
		botonSegundoAlgomon.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(1);
			} catch (PokemonMuertoException e) {
			}
			if (botonesIntocables.contains(botonPrimerAlgomon)){
				botonesIntocables.remove(botonPrimerAlgomon);
    			listaDeBotones1.add(botonPrimerAlgomon);
    		}
    		else{
    			botonesIntocables.remove(botonTercerAlgomon);
    			listaDeBotones1.add(botonTercerAlgomon);
    		}
    		botonesIntocables.add(botonSegundoAlgomon);
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
    	    contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    int indiceNuevo = 0;
    	    grid.getChildren().clear();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



    				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}
            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
            		}
            	});

                grid.add(boton2,indiceNuevo,0);
                indiceNuevo+=1;
            }
		}
		);
		listaDeBotones1.add(botonTercerAlgomon);
		botonTercerAlgomon.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(2);
			} catch (PokemonMuertoException e) {
			}
			if (botonesIntocables.contains(botonPrimerAlgomon)){
				botonesIntocables.remove(botonPrimerAlgomon);
    			listaDeBotones1.add(botonPrimerAlgomon);
    		}
    		else{
    			botonesIntocables.remove(botonSegundoAlgomon);
    			listaDeBotones1.add(botonSegundoAlgomon);
    		}
			botonTercerAlgomon.setDisable(true);
    		botonesIntocables.add(botonTercerAlgomon);
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
    	    contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    int indiceNuevo = 0;
    	    grid.getChildren().clear();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



    				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}
            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
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


		//Accion del cambiar algomon
		TitledPane botonUsarItemJugador1 = new TitledPane();
		GridPane gridUsarItem = new GridPane();


		ImageView pocion = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pocion.png", 20, 20, false, true);
		ImageView superpocion = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/superpocion.png", 20, 20, false, true);
		ImageView restaurador = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/restaurador.png", 20, 20, false, true);
		ImageView vitamina = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/vitamina.png", 20, 20, false, true);
		Button botonPocion = creadorBoton1.crearBoton("Posicion", pocion );
		Button botonSuperPocion = creadorBoton1.crearBoton("Super pocion", superpocion );
		Button botonRestaurador = creadorBoton1.crearBoton("Restaurador", restaurador );
		Button botonVitamina = creadorBoton1.crearBoton("vitamina", vitamina );
		listaDeBotones1.add(botonPocion);
		botonPocion.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.POCION);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
					botonPocion.setDisable(true);
					botonesIntocables.add(botonPocion);
					listaDeBotones1.remove(botonPocion);
	    		}
	    		contenedorEstadosJugador1.getChildren().clear();
	    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));


			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
				botonPocion.setDisable(true);
			}
		}
		);
		listaDeBotones1.add(botonSuperPocion);
		botonSuperPocion.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.SUPER_POCION);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
					botonSuperPocion.setDisable(true);
					botonesIntocables.add(botonSuperPocion);
					listaDeBotones1.remove(botonSuperPocion);
	    		}
	    		contenedorEstadosJugador1.getChildren().clear();
	    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
				botonSuperPocion.setDisable(true);
			}

		}
		);
		listaDeBotones1.add(botonRestaurador);
		botonRestaurador.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.RESTAURADOR);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
					botonRestaurador.setDisable(true);
					botonesIntocables.add(botonRestaurador);
					listaDeBotones1.remove(botonRestaurador);
	    		}
	    		contenedorEstadosJugador1.getChildren().clear();
	    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
				botonPocion.setDisable(true);
			}

		}
		);
		listaDeBotones1.add(botonVitamina);
		botonVitamina.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.VITAMINA);

				for (Button boton1: listaDeBotones2){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones1){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonVitamina.setDisable(true);
					botonesIntocables.add(botonVitamina);
					listaDeBotones1.remove(botonVitamina);
	    		}
	    		contenedorEstadosJugador1.getChildren().clear();
	    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
				botonPocion.setDisable(true);
			}

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
        ArrayList<Ataque> listaDeAtaques2 = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();

        TitledPane botonAtacarJugador2 = new TitledPane();
        GridPane grid2 = new GridPane();
        int indice2 = 0;
        for(Ataque ataque: listaDeAtaques2){
        	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

        	boton2.setDisable(true);
        	listaDeBotones2.add(boton2);
        	boton2.setOnAction(event->{
        		try {
					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
						| VictoriaObtenidaException e) {
					this.controladorLogico.cambiarJugador();
				}
        		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
	    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
        		for (Button boton1: listaDeBotones1){
        			boton1.setDisable(false);
        		}
        		for (Button boton: listaDeBotones2){
        			boton.setDisable(true);
        		}
        	});
            grid2.add(boton2,indice2,0);
            indice2+=1;
        }

        botonAtacarJugador2.setText("ATACAR");
        botonAtacarJugador2.setExpanded(false);
        botonAtacarJugador2.setContent(grid2);

        //Accion del atacar

        TitledPane botonCambiarAlgomonJugador2 = new TitledPane();
        GridPane gridCambiarAlgomon2 = new GridPane();
        Button botonSegundoAlgomon2 = creadorBoton1.crearBoton("SegundoAlgomon", miniaturasJugadorSegundo.get(1) );
		Button botonPrimerAlgomon2 = creadorBoton1.crearBoton("PrimerAlgomon", miniaturasJugadorSegundo.get(0));
		Button botonTercerAlgomon2 = creadorBoton1.crearBoton("TercerAlgomon", miniaturasJugadorSegundo.get(2) );
		botonPrimerAlgomon2.setDisable(true);
		botonesIntocables.add(botonPrimerAlgomon2);
		botonPrimerAlgomon2.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(0);
			} catch (PokemonMuertoException e) {
			}
			if (botonesIntocables.contains(botonSegundoAlgomon2)){
				botonesIntocables.remove(botonSegundoAlgomon2);
    			listaDeBotones2.add(botonSegundoAlgomon2);
    		}
    		else{
    			botonesIntocables.remove(botonTercerAlgomon2);
    			listaDeBotones2.add(botonTercerAlgomon2);
    		}
			botonPrimerAlgomon2.setDisable(true);
    		botonesIntocables.add(botonPrimerAlgomon2);
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
    	    contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    int indiceNuevo = 0;
    	    grid2.getChildren().clear();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



    				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}
            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
            		}
            	});

                grid2.add(boton2,indiceNuevo,0);
                indiceNuevo+=1;
            }
		}
		);

		listaDeBotones2.add(botonSegundoAlgomon2);
		botonSegundoAlgomon2.setDisable(true);
		botonSegundoAlgomon2.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(1);
			} catch (PokemonMuertoException e) {
			}
			if (botonesIntocables.contains(botonPrimerAlgomon2)){
				botonesIntocables.remove(botonPrimerAlgomon2);
    			listaDeBotones2.add(botonPrimerAlgomon2);
    		}
    		else{
    			botonesIntocables.remove(botonTercerAlgomon2);
    			listaDeBotones2.add(botonTercerAlgomon2);
    		}
    		botonesIntocables.add(botonSegundoAlgomon2);
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
    	    contenedorEstadosJugador2.getChildren().clear();
    	    contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    int indiceNuevo = 0;
    	    grid2.getChildren().clear();
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



    				} catch (SinPuntosDePoderException | EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}
            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
            		}
            	});

                grid2.add(boton2,indiceNuevo,0);
                indiceNuevo+=1;
            }
		}
		);

		listaDeBotones2.add(botonTercerAlgomon2);
		botonTercerAlgomon2.setDisable(true);
		botonTercerAlgomon2.setOnAction(event->{
			try {
				this.controladorLogico.cambiarAlgomon(2);
			} catch (PokemonMuertoException e) {
			}
			if (botonesIntocables.contains(botonPrimerAlgomon2)){
				botonesIntocables.remove(botonPrimerAlgomon2);
    			listaDeBotones2.add(botonPrimerAlgomon2);
    		}
    		else{
    			botonesIntocables.remove(botonSegundoAlgomon2);
    			listaDeBotones2.add(botonSegundoAlgomon2);
    		}
    		botonesIntocables.add(botonTercerAlgomon2);
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
    	    contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));
    	    contenedorAlgomonesActivos.getChildren().addAll(nuevoAlgomonJugador1,nuevoAlgomonJugador2);
    	    int indiceNuevo = 0;
    	    grid2.getChildren().clear();
    	    ArrayList<Ataque> listaDeAtaquesNueva = this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().obtenerTodosLosAtaques();
    	    for(Ataque ataque: listaDeAtaquesNueva){
            	Button boton2 = creadorBoton.crearBoton(ataque.getNombre(),"-fx-font: 12 arial; -fx-base: #b6e7c9;");

            	boton2.setDisable(true);
            	listaDeBotones2.add(boton2);
            	boton2.setOnAction(event2->{
            		try {
    					this.controladorLogico.atacar(this.diccionarioEnums.get(ataque.getNombre()));



    				} catch (SinPuntosDePoderException |EstaDormidoException | PokemonMuertoException
    						| VictoriaObtenidaException e) {
    					this.controladorLogico.cambiarJugador();
    				}

            		contenedorEstadosJugador1.getChildren().clear(); //ESTO HAY QUE ENCAPSULARLO EN UN METODO ACTUALIZAR ESTADO
		    		contenedorEstadosJugador1.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getVida())));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoEfimeroComoString()));
		            contenedorEstadosJugador1.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorActual().getPokemonActivo().getEstadoPersistenteComoString()));
            		for (Button boton1: listaDeBotones1){
            			boton1.setDisable(false);
            		}
            		for (Button boton: listaDeBotones2){
            			boton.setDisable(true);
            		}
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


		//Accion del cambiar algomon

        TitledPane botonUsarItemJugador2 = new TitledPane();
		GridPane gridUsarItem2 = new GridPane();


		ImageView pocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pocion.png", 20, 20, false, true);
		ImageView superpocion2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/superpocion.png", 20, 20, false, true);
		ImageView restaurador2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/restaurador.png", 20, 20, false, true);
		ImageView vitamina2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/vitamina.png", 20, 20, false, true);
		Button botonPocion2 = creadorBoton1.crearBoton("Posicion", pocion2 );

		Button botonSuperPocion2 = creadorBoton1.crearBoton("Super pocion", superpocion2 );
		Button botonRestaurador2 = creadorBoton1.crearBoton("Restaurador", restaurador2 );
		Button botonVitamina2 = creadorBoton1.crearBoton("vitamina", vitamina2 );
		listaDeBotones2.add(botonPocion2);
		botonPocion2.setDisable(true);
		botonPocion2.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.POCION);

				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.POCION)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
					botonPocion2.setDisable(true);
					botonesIntocables.add(botonPocion2);
					listaDeBotones2.remove(botonPocion2);
	    		}
	    		contenedorEstadosJugador2.getChildren().clear();
	    		contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.POCION);
				botonVitamina2.setDisable(true);
			}

		}
		);
		listaDeBotones2.add(botonSuperPocion2);
		botonSuperPocion2.setDisable(true);
		botonSuperPocion2.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.SUPER_POCION);

				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.SUPER_POCION)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
					botonSuperPocion2.setDisable(true);
					botonesIntocables.add(botonSuperPocion2);
					listaDeBotones2.remove(botonSuperPocion2);
	    		}
	    		contenedorEstadosJugador2.getChildren().clear();
	    		contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.SUPER_POCION);
				botonSuperPocion2.setDisable(true);
			}

		}
		);
		listaDeBotones2.add(botonRestaurador2);
		botonRestaurador2.setDisable(true);
		botonRestaurador2.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.RESTAURADOR);

				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.RESTAURADOR)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
					botonRestaurador2.setDisable(true);
					botonesIntocables.add(botonRestaurador2);
					listaDeBotones2.remove(botonRestaurador2);
	    		}
	    		contenedorEstadosJugador2.getChildren().clear();
	    		contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

				} catch (SinUsosDisponiblesException e) {
					notificaciones.notificarNoHayItemDisponible(ItemsEnum.RESTAURADOR);
					botonRestaurador2.setDisable(true);
				}

		}
		);
		listaDeBotones2.add(botonVitamina2);
		botonVitamina2.setDisable(true);
		botonVitamina2.setOnAction(event->{
			try {
				this.controladorLogico.usarItem(ItemsEnum.VITAMINA);

				for (Button boton1: listaDeBotones1){
	    			boton1.setDisable(false);
	    		}
	    		for (Button boton: listaDeBotones2){
	    			boton.setDisable(true);
	    		}
	    		if(controladorLogico.obtenerJugadorActual().cantidadDeUsosDisponiblesDeItem(ItemsEnum.VITAMINA)== 0){
	    			notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
					botonVitamina2.setDisable(true);
					botonesIntocables.add(botonVitamina2);
					listaDeBotones2.remove(botonVitamina2);
	    		}
	    		contenedorEstadosJugador2.getChildren().clear();
	    		contenedorEstadosJugador2.getChildren().add(new Label(Integer.toString(this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getVida())));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado efimero: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoEfimeroComoString()));
	            contenedorEstadosJugador2.getChildren().add(new Label("Estado persistente: "+ this.controladorLogico.obtenerJugadorDefensor().getPokemonActivo().getEstadoPersistenteComoString()));

			} catch (SinUsosDisponiblesException e) {
				notificaciones.notificarNoHayItemDisponible(ItemsEnum.VITAMINA);
				botonVitamina2.setDisable(true);
			}

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


        Scene principal = new Scene(border, 981, 600);
        stage.setScene(principal);
	}
	public void crearPantallaInicial() {
		this.controladorLogico = new ControladorLogicoDelJuego();
		AudioClip musicaPantallaInicial = new AudioClip(this.getClass().getResource("/vista/sonidos/intro_pokemon.mp3").toExternalForm());
		musicaPantallaInicial.play();
		CreadorImagen creadorImagen = new CreadorImagen();
		ImageView imageViewTitulo = creadorImagen.crearImageView("/vista/imagenes/algomon.png");
        ImageView imageViewPikachu = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pikachu.png",200,200,false,true);
        ImageView imageViewPikachu2 = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/pikachu.png",200,200,false,true);

        BorderPane border = new BorderPane();
        HBox contenedorHorizontal = new HBox();
        VBox contenedorVerticalIzquierdo = new VBox();
        VBox contenedorVerticalCentral = new VBox();
        VBox contenedorVerticalDerecho = new VBox();
        border.setTop(contenedorHorizontal);
        border.setLeft(contenedorVerticalIzquierdo);
        border.setCenter(contenedorVerticalCentral);
        border.setRight(contenedorVerticalDerecho);

        HBox contenedorBotones = new HBox();
        CreadorBoton creadorBoton = new CreadorBoton();
        creadorBoton.crearBoton("Nuevo Juego","-fx-font: 20 arial; -fx-base: #b6e7c9;");
        Button botonNuevoJuego = creadorBoton.crearBoton("Nuevo Juego","-fx-font: 20 arial; -fx-base: #b6e7c9;");
        botonNuevoJuego.setOnAction(event ->{
        	musicaPantallaInicial.stop();
        	this.crearPantallaJugador();
        	this.controladorLogico.crearJuegoNuevo();
        });
		Button botonCargarJuego = creadorBoton.crearBoton("Cargar Juego","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonOpciones = creadorBoton.crearBoton("Opciones","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonAyuda = creadorBoton.crearBoton("Ayuda","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		Button botonSalir = creadorBoton.crearBoton("Salir","-fx-font:  16 arial; -fx-base: #b6e7c9;");
		botonSalir.setOnAction(event -> {
			musicaPantallaInicial.stop();
			this.stage.close();
        });


        contenedorBotones.getChildren().addAll(botonAyuda,botonSalir);
        contenedorBotones.setSpacing(25);
        contenedorBotones.setAlignment(Pos.BASELINE_CENTER);
        contenedorHorizontal.getChildren().addAll(imageViewTitulo);
        contenedorHorizontal.setAlignment(Pos.BOTTOM_CENTER);
        contenedorVerticalCentral.getChildren().addAll(botonNuevoJuego,botonCargarJuego,botonOpciones,contenedorBotones);
        contenedorVerticalCentral.setSpacing(25);
        contenedorVerticalCentral.setAlignment(Pos.BASELINE_CENTER);
        contenedorVerticalIzquierdo.getChildren().addAll(imageViewPikachu);
        contenedorVerticalDerecho.getChildren().addAll(imageViewPikachu2);
        Scene principal = new Scene(border, 981, 600);
        this.stage.setScene(principal);
        this.stage.show();
	}

	private void crearPantallaJugador() {
		DropShadow sombraBoton = new DropShadow();
        sombraBoton.setOffsetY(2.0);
        sombraBoton.setOffsetX(2.0);
        sombraBoton.setColor(Color.PINK);

        Label label1 = new Label("Jugador");
		Label label2 = new Label("Nombre:");
		TextField textField = new TextField ();
		GridPane grilla = new GridPane();

		CreadorBoton creadorBoton = new CreadorBoton();

		VBox contenedorVertical = new VBox();
		HBox contenedorHorizontalSuperior = new HBox();
		HBox contenedorHorizontalInferior = new HBox();
		Button botonLimpiar = creadorBoton.crearBoton("Limpiar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonLimpiar.setEffect(sombraBoton);
		Button botonAceptar =  creadorBoton.crearBoton("Aceptar","-fx-font: 16 arial; -fx-base: #b6e7c9;");
		botonAceptar.setOnAction(event ->{
			this.controladorLogico.setNombreJugadorActual(textField.getText());
			this.crearPantallaEleccionAlgomon();
		});
		botonAceptar.setEffect(sombraBoton);
		contenedorHorizontalSuperior.getChildren().addAll(label2, textField);
		contenedorHorizontalSuperior.setSpacing(10);
		contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
		contenedorHorizontalInferior.getChildren().addAll(botonAceptar,botonLimpiar);
		contenedorHorizontalInferior.setSpacing(25);
		contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);
		contenedorVertical.getChildren().addAll(label1,contenedorHorizontalSuperior,contenedorHorizontalInferior);
		contenedorVertical.setAlignment(Pos.BASELINE_CENTER);
		grilla.add(contenedorVertical,4,4);
		grilla.setAlignment(Pos.CENTER);
		Scene escenaCargarJugador= new Scene(grilla, 981, 600);

		this.stage.setScene(escenaCargarJugador);
	}

	private void crearPantallaEleccionAlgomon() {

			CreadorImagen creadorImagen = new CreadorImagen();
			ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/charmander.png", 150, 150, false, true);
			ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/squirtle.png", 150, 150, false, true);
			ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/rattata.png", 150, 150, false, true);
			ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/chansey.png", 150, 150, false, true);
			ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/bulbasaur.png", 150, 150, false, true);
			ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/jigglypuff.png", 150, 150, false, true);
			VBox contenedorVertical = new VBox();
			HBox contenedorHorizontalSuperior = new HBox();
			HBox contenedorHorizontalMedio = new HBox();
			HBox contenedorHorizontalInferior = new HBox();
			CreadorBoton creadorBoton = new CreadorBoton();
			ArrayList<Button> listaDeBotones = new ArrayList<Button>();
			ArrayList<AudioClip> listaDeSonidos = new ArrayList<AudioClip>();

			Button botonCharmander = creadorBoton.crearBoton("charmander", imageViewCharmander);
			listaDeBotones.add(botonCharmander);
			AudioClip sonidoCharmander = new AudioClip(this.getClass().getResource("/vista/sonidos/charmander_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoCharmander);

			Button botonChansey = creadorBoton.crearBoton("chansey", imageViewChansey);
			listaDeBotones.add(botonChansey);
			AudioClip sonidoChansey = new AudioClip(this.getClass().getResource("/vista/sonidos/chansey_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoChansey);

			Button botonSquirtle =creadorBoton.crearBoton("squirtle", imageViewSquirtle);
			listaDeBotones.add(botonSquirtle);
			AudioClip sonidoSquirtle = new AudioClip(this.getClass().getResource("/vista/sonidos/squirtle_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoSquirtle);

			Button botonRattata =creadorBoton.crearBoton("rattata", imageViewRattata);
			listaDeBotones.add(botonRattata);
			AudioClip sonidoRattata = new AudioClip(this.getClass().getResource("/vista/sonidos/rattata_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoRattata);

			Button botonBulbasaur =creadorBoton.crearBoton("bulbasaur", imageViewBulbasaur);
			listaDeBotones.add(botonBulbasaur);
			AudioClip sonidoBulbasaur = new AudioClip(this.getClass().getResource("/vista/sonidos/bulbasaur_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoBulbasaur);

			Button botonJigglypuff =creadorBoton.crearBoton("jigglypuff", imageViewJigglypuff);
			listaDeBotones.add(botonJigglypuff);
			AudioClip sonidoJigglypuff = new AudioClip(this.getClass().getResource("/vista/sonidos/jigglypuff_audio.mp3").toExternalForm());
			listaDeSonidos.add(sonidoJigglypuff);

			Button botonContinuar = creadorBoton.crearBoton("Continuar", "-fx-font: 16 arial; -fx-base: #b6e7c9;");
			botonContinuar.setDisable(true);
			for (Button boton:listaDeBotones){
				boton.setStyle("-fx-font: 16 arial; -fx-base: #b6e7c9;");
				boton.setMaxSize(280, contenedorHorizontalSuperior.getPrefHeight());
				boton.setMinSize(280, contenedorHorizontalSuperior.getPrefHeight());
			}
			botonCharmander.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarCharmanderJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);

				}
				sonidoCharmander.play();
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/charmander.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
});
			botonSquirtle.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarSquirtleJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/squirtle.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoSquirtle.play();});

			botonBulbasaur.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarBulbasaurJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/bulbasaur.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoBulbasaur.play();});

			botonRattata.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarRattataJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoRattata.play();
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/rattata.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
});
			botonJigglypuff.setOnAction(event ->{
				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarJigglypuffJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoJigglypuff.play();
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/jigglypuff.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
});
			botonChansey.setOnAction(event ->{

				if (!this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.controladorLogico.agregarChanseyJugadorActual();
				}
				else{
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
				sonidoChansey.play();
				if(this.miniaturasJugadorInicial.size()<3){
					this.imagenesJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 130, 130, false, true));
					this.miniaturasJugadorInicial.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
				}
				else{
					this.imagenesJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 130, 130, false, true));
					this.miniaturasJugadorSegundo.add(creadorImagen.crearImageViewConTamanioEspecifico("vista/imagenes/chansey.png", 30, 30, false, true));
				}
				if (this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					for (Button boton_auxiliar:listaDeBotones){
						boton_auxiliar.setDisable(true);
					}
					botonContinuar.setDisable(false);
				}
});

			botonContinuar.setOnAction(event->{
				this.controladorLogico.cambiarJugador();
				if(this.controladorLogico.verificarCantidadAlgomonDeJugadorActual()){
					this.crearPantallaBatalla();
				}
				else{
					this.crearPantallaJugador();
				}
			});
			contenedorVertical.setSpacing(100);
			contenedorHorizontalSuperior.getChildren().addAll(botonCharmander,botonSquirtle,botonBulbasaur);
			contenedorHorizontalSuperior.setSpacing(60);
			contenedorHorizontalSuperior.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalMedio.getChildren().addAll(botonChansey,botonRattata,botonJigglypuff);
			contenedorHorizontalMedio.setSpacing(60);
			contenedorHorizontalMedio.setAlignment(Pos.BASELINE_CENTER);
			contenedorHorizontalInferior.getChildren().add(botonContinuar);
			contenedorHorizontalInferior.setAlignment(Pos.BASELINE_CENTER);

			contenedorVertical.getChildren().addAll(contenedorHorizontalMedio,contenedorHorizontalInferior);
		    BorderPane border = new BorderPane();
			border.setTop(contenedorHorizontalSuperior);
			border.setCenter(contenedorVertical);
			Scene escenaElegirAlgomon= new Scene(border, 981, 600);
		    stage.setScene(escenaElegirAlgomon);
		}
}
