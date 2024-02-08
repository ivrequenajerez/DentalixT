package mainPack;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.*;
import java.net.URL;

public class Ayuda {

	public static void mostrarAyuda(JFrame frame) {
	    try {
	        ClassLoader classLoader = Ayuda.class.getClassLoader();
	        URL helpSetURL = HelpSet.findHelpSet(classLoader, "help/helpset.hs");
	        
	        if (helpSetURL == null) {
	            System.err.println("La URL de HelpSet es nula. Verifica la ruta y disponibilidad del recurso.");
	            return;
	        }

	        System.out.println("URL de HelpSet: " + helpSetURL);

	        HelpSet helpSet = new HelpSet(classLoader, helpSetURL);
	        HelpBroker helpBroker = helpSet.createHelpBroker();

	        helpBroker.setSize(new java.awt.Dimension(700, 500));
	        helpBroker.setDisplayed(true);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}