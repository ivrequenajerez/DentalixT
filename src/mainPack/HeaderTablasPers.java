package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class HeaderTablasPers extends DefaultTableCellRenderer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public HeaderTablasPers() {
        setHorizontalAlignment(JLabel.LEFT); // Ajusta la alineación del texto en el encabezado
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Esto es como el padding-left jaja
        Font montserratFont = new Font("Montserrat", Font.BOLD, 12);
        label.setFont(montserratFont);
        label.setOpaque(true);
        label.setBackground(new Color(0, 140, 206, 230));
        label.setForeground(Color.WHITE);
        return label;
    }
}
