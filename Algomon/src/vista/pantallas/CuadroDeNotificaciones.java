package vista.pantallas;

import javafx.scene.control.TextArea;
import modelo.enums.ItemsEnum;

public class CuadroDeNotificaciones {

	private TextArea textArea;

	public CuadroDeNotificaciones(){
		this.textArea = new TextArea();
		this.textArea.setPrefColumnCount(10);
		this.textArea.setPrefRowCount(5);
		this.textArea.setEditable(false);
		this.textArea.setWrapText(true);
		this.textArea.setCenterShape(true);
		this.textArea.setStyle(" -fx-font-family: arial; -fx-font-size: 26;-fx-text-alignment: center;-fx-padding: 50 50 50 50");
	}

	public TextArea getTextArea(){
		return this.textArea;
	}

	public void notificarUsoDeItem(ItemsEnum item){
		this.textArea.setText("Se ha utilizado " + item);
	}

	public void notificarNoHayItemDisponible(ItemsEnum item){
		this.textArea.setText("No hay mas " + item + " disponible.\n");
	}

	public void notificarPokemonMuerto(){
		this.textArea.setText("Este pokemon ha muerto. No podrás seguir utilizándolo.");
	}

	public void notificar(String string){
		this.textArea.setText(string);

	}
}
