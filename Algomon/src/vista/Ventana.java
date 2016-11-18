package vista;
import java.awt.*;

public class Ventana extends Frame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8520443944205457770L;
	MenuBar barra = new MenuBar();
	Menu programa = new Menu("Programa");
	Menu ayuda = new Menu("Ayuda");
	Menu guardar = new Menu("Guardar");

   public Ventana(){
      super("Ventana en JAVA");
      this.setSize(500, 500);

      setMenuBar(barra);

      barra.add(programa);
      barra.add(ayuda);

      programa.add("Nuevo");
      programa.add("Abrir");

      programa.addSeparator();

      programa.add(guardar);
      guardar.add("Guardar");
      guardar.add("Guardar Como...");
      guardar.add("Guardar Todo");

      programa.addSeparator();

      programa.add("Salir");

      ayuda.add("Ayuda General");
      ayuda.addSeparator();
      ayuda.add("Acerca de...");
   }


@SuppressWarnings("deprecation")
public static void main(String g[]){
      Ventana prog = new Ventana();
      prog.show();
   }
@SuppressWarnings("deprecation")
public boolean handleEvent(Event evt){
      if (evt.id == Event.WINDOW_DESTROY)
         System.exit(0);
         return super.handleEvent(evt);
   }
}
