package mainPack;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ColorChangingButtonBean extends JButton {
    private static final long serialVersionUID = 1L;
    private int contadorClics;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

    public ColorChangingButtonBean() {
        initialize();
    }

    private void initialize() {
        java.net.URL imgUrlColor = getClass().getResource("/cambiarColor.png");
        Icon iconColor = new ImageIcon(imgUrlColor);
        setIcon(iconColor);

        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contadorClics++;

                Color color;
                switch (contadorClics % 3) {
                    case 1:
                        color = Color.GREEN;
                        break;
                    case 2:
                        color = Color.RED;
                        break;
                    case 0:
                        color = Color.decode("#008cce");
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }

                firePropertyChange("background", getBackground(), color);
                setBackground(color);
            }
        });
    }

    // Métodos getter y setter para el contadorClics
    public int getContadorClics() {
        return contadorClics;
    }

    public void setContadorClics(int contadorClics) {
        int oldContadorClics = this.contadorClics;
        this.contadorClics = contadorClics;
        propertyChangeSupport.firePropertyChange("contadorClics", oldContadorClics, contadorClics);
    }

    // Métodos para agregar y remover PropertyChangeListeners
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
