package otros;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ColumnaBuscar extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel panel;
	private final JButton button;
	private final JTextField textField;

	public ColumnaBuscar() {
		// JPanel
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 30));
		panel.setBackground(new Color(0, 140, 206, 230));
		panel.setBorder(BorderFactory.createEtchedBorder());

		// Componentes
		button = new JButton();
		textField = new JTextField("Buscar... ");

		// Configuración del botón
		URL imgUrl = getClass().getResource("/añadir.png");
		Icon icon = new ImageIcon(imgUrl);
		button.setIcon(icon);
		button.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);

		// Configuración del textField
		textField.setBackground(Color.WHITE);
		textField.setForeground(Color.GRAY);
		textField.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textField.setHorizontalAlignment(JTextField.LEFT);

		// Cambia el color del borde del textField a negro con un 20% de opacidad
		Color borderColor = new Color(0, 0, 0, 51); // RGBA: 0, 0, 0, 51 (20% de opacidad)
		textField.setBorder(
				BorderFactory.createCompoundBorder(new LineBorder(borderColor, 1), new EmptyBorder(0, 10, 0, 0)));

		textField.setPreferredSize(new Dimension(150, 35));

		// Agregar componentes al panel
		/*
		 * 
		// Agrega un ActionListener al botón
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Código a ejecutar cuando se hace clic en el botón
				System.out.println("Botón clicado");
			}
		});
		 * textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.print("hola");
			}
		});
		panel.add(button);
		panel.add(textField);
		
		*/
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		if (column == table.getColumnCount() - 1) {

			return panel;
		} else {
			// Devuelve el valor predeterminado para las demás columnas
			JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));
			Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
			label.setFont(montserratFont);
			label.setOpaque(true);
			label.setBackground(new Color(0, 140, 206, 230));
			label.setForeground(Color.WHITE);
			return label;
		}
	}
}

