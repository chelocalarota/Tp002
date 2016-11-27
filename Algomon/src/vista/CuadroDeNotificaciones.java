package vista;

import javafx.scene.control.TextArea;
import modelo.enums.ItemsEnum;

public class CuadroDeNotificaciones {

	private TextArea textArea;

	public CuadroDeNotificaciones(){
		this.textArea = new TextArea();
		this.textArea.setEditable(false);
		this.textArea.setWrapText(true);
	}

	public TextArea getTextArea(){
		return this.textArea;
	}

	public void notificarCambioDeTurno(String jugador){
		this.textArea.setText(jugador + "ha terminado su turno.");
	}

	public void notificarAtaque(String pokemon, String ataque){
		this.textArea.setText(pokemon + "ha realizado" + ataque + ".");
	}

	public void notificarDanio(String pokemon, String vida){
		this.textArea.setText(pokemon + "ha perdido" + vida + "puntos de vida.");
	}

	public void notificarUsoDeItem(ItemsEnum item, String jugador){
		this.textArea.setText(jugador + "ha utilizado" + item);
	}

	public void notificarNoHayItemDisponible(ItemsEnum item){
		this.textArea.setText("No hay mas " + item + " disponible.\n");
	}

	public void notificarCambioDePokemon(String jugador, String pokemon){
		this.textArea.setText("El" + jugador + "ha cambiado de pokemon." + pokemon + "salió al combate.");
	}

	public void notificarPokemonMuerto(){
		this.textArea.setText("Este pokemon ha muerto. No podrás seguir utilizándolo.");
	}

	public void notificar(String string){
		this.textArea.setText(string);
		textArea.setEditable(true);
		textArea.setStyle("-fx-font: 34 arial; -fx-base: #b6e7c9;");
	}
}
