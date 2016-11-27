package vista.creadores;

import java.util.ArrayList;

import controlador.ControladorLogicoDelJuego;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

public class CreadorBoton {
	

	private CreadorImagen creadorImagen;
	private CreadorBoton creadorBoton;
	private ArrayList<Button> listaDeBotones;

	public CreadorBoton(){
		this.creadorImagen = new CreadorImagen();
		this.listaDeBotones = new ArrayList<Button>();
	}
	
	public ArrayList<Button> crearBotonesDeEleccion(){

		ImageView imageViewCharmander = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/charmander.png", 150, 150, false, true);
		ImageView imageViewSquirtle = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/squirtle.png", 150, 150, false, true);
		ImageView imageViewRattata = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/rattata.png", 150, 150, false, true);
		ImageView imageViewChansey = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/chansey.png", 150, 150, false, true);
		ImageView imageViewBulbasaur = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/bulbasaur.png", 150, 150, false, true);
		ImageView imageViewJigglypuff = creadorImagen.crearImageViewConTamanioEspecifico("/vista/imagenes/jigglypuff.png", 150, 150, false, true);

		String estiloCharmander = "-fx-font: 18 arial; -fx-base: #F5A9A9;";
		String textoCharmander = "CHARMANDER\n\nTipo: Fuego\nVida: 170\nAtaques:\n  -Brasas\n  -Fogonazo\n  -AtaqueRapido\n";
		Button botonCharmander = this.crearBotonEleccionAlgomon(textoCharmander, imageViewCharmander, estiloCharmander);
		this.listaDeBotones.add(botonCharmander);

		String estiloChansey = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoChansey = "CHANSEY\n\nTipo: Normal\nVida: 130\nAtaques:\n  -Canto\n  -Latigo Cepa\n  -AtaqueRapido\n";
		Button botonChansey = this.crearBotonEleccionAlgomon(textoChansey, imageViewChansey, estiloChansey);
		this.listaDeBotones.add(botonChansey);

		String estiloSquirtle = "-fx-font: 18 arial; -fx-base: #A9D0F5;";
		String textoSquirtle = "SQUIRTLE\n\nTipo: Agua\nVida: 150\nAtaques:\n  -Burbuja\n  -Cañon de Agua\n  -AtaqueRapido\n";
		Button botonSquirtle =this.crearBotonEleccionAlgomon(textoSquirtle, imageViewSquirtle, estiloSquirtle);
		this.listaDeBotones.add(botonSquirtle);

		String estiloRattata = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoRattata = "RATTATA\n\nTipo: Normal\nVida: 170\nAtaques:\n  -Fogonazo\n  -Burbuja\n  -AtaqueRapido\n";
		Button botonRattata =this.crearBotonEleccionAlgomon(textoRattata, imageViewRattata, estiloRattata);
		listaDeBotones.add(botonRattata);

		String estiloBulbasaur = "-fx-font: 18 arial; -fx-base: #BCF5A9;";
		String textoBulbasaur = "BULBASAUR\n\nTipo: Planta\nVida: 140\nAtaques:\n  -Chupavidas\n  -Latigo Cepa\n  -AtaqueRapido\n";
		Button botonBulbasaur =this.crearBotonEleccionAlgomon(textoBulbasaur, imageViewBulbasaur, estiloBulbasaur);
		this.listaDeBotones.add(botonBulbasaur);

		String estiloJigglypuff = "-fx-font: 18 arial; -fx-base: #F5ECCE;";
		String textoJigglypuff = "JIGGLYPUFF\n\nTipo: Normal\nVida: 130\nAtaques:\n  -Canto\n  -Burbuja\n  -AtaqueRapido\n";
		Button botonJigglypuff =this.crearBotonEleccionAlgomon(textoJigglypuff, imageViewJigglypuff, estiloJigglypuff);
		this.listaDeBotones.add(botonJigglypuff);

		return this.listaDeBotones;
	}
	
	public Button crearBoton(String titulo, String estilo) {
		Button boton = new Button(titulo);
        boton.setStyle(estilo);
        return boton;
	}

	public Button crearBoton(String titulo, ImageView imageView) {
		Button boton = new Button(titulo, imageView);

		boton.setContentDisplay(ContentDisplay.LEFT);
		return boton;
	}

	public void setearBotonAlgomon(ArrayList<Button> listaDeBotones,Button botonElegido, Button botonContinuar, 
								   ControladorLogicoDelJuego controlador, AudioClip audio) {
	
			botonElegido.setOnAction(event ->{
			if (!controlador.cantidadAlgomonesDeJugadorActualEsTres()){
				controlador.agregarCharmanderJugadorActual();
			}
			else{
				for (Button boton_auxiliar:listaDeBotones){
					boton_auxiliar.setDisable(true);
				}
				botonContinuar.setDisable(false);
	
		}
		audio.play();});

		}
	
	public Button crearBotonEleccionAlgomon(String titulo, ImageView imageView, String estilo) {
		Button boton = new Button(titulo, imageView);
		boton.setStyle(estilo);
		
		boton.setContentDisplay(ContentDisplay.LEFT);
		return boton;
	}
}

