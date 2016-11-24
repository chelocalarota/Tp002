package vista;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class MenuTop {
	
	private MenuBar menu;
	
	public MenuTop(Stage stage){

		menu = new MenuBar();
        // --- Menu File
        
        Menu menuArchivo = new Menu("Archivo");
        
        
        RadioMenuItem salir = new RadioMenuItem("Salir");
        
        salir.setOnAction(event->{
        	stage.close();
        });
        

        menuArchivo.getItems().addAll(salir,
            new SeparatorMenuItem());

		// --- Menu Edit
        Menu menuOpciones = new Menu("Opciones");
        
        ToggleGroup tGroup = new ToggleGroup();
        RadioMenuItem desactivarSonido = new RadioMenuItem("Desactivar Sonido");
        RadioMenuItem activarSonido = new RadioMenuItem("Activar Sonido");
        
        desactivarSonido.setOnAction(event->{
        	
        });
        
        desactivarSonido.setToggleGroup(tGroup);

        activarSonido.setOnAction(event->{
        	
        });
        
        activarSonido.setToggleGroup(tGroup);

        menuOpciones.getItems().addAll(desactivarSonido, activarSonido,
            new SeparatorMenuItem());

        // --- Menu View
        Menu menuAyuda = new Menu("Ayuda");
        
        
        menu.getMenus().addAll(menuArchivo, menuOpciones, menuAyuda);
        menu.setMinWidth(1400);

	}
	
	public MenuBar obtenerMenu(){
		return menu;
	}
}
