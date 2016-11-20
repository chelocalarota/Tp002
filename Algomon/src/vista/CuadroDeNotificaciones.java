package vista;

import javafx.scene.control.TextArea;
import modelo.enums.ItemsEnum;

public class CuadroDeNotificaciones {

	TextArea textArea;

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

	public void notificarDaño(String pokemon, String vida){
		this.textArea.setText(pokemon + "ha perdido" + vida + "puntos de vida.");
	}

	public void notificarUsoDeItem(ItemsEnum item, String jugador){
		this.textArea.setText(jugador + "ha utilizado" + item);
	}

	public void notificarNoHayItemDisponible(ItemsEnum item, String jugador){
		this.textArea.setText(jugador + " no hay mas " + item + " disponible.\n");
	}

	public void notificarCambioDePokemon(String jugador, String pokemon){
		this.textArea.setText("El" + jugador + "ha cambiado de pokemon." + pokemon + "salió al combate.");
	}

	public void notificarPokemonMuerto(String pokemon){
		this.textArea.setText(pokemon + "ha muerto. No podrás seguir utilizándolo.");
	}
}
