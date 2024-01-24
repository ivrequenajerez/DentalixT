package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Tabla extends JTable {

	// Tabla personalizada, con nuestros colores y demás cosas (basado en nuestro
	// diseño en Figma)

	private static final long serialVersionUID = 1L;

	public Tabla(DefaultTableModel modelo) {
		super(modelo);

		// Esto es cosas del diseño de la tabla
		setShowVerticalLines(false);
		modelo.addColumn("");
		setRowHeight(100);
		setGridColor(Color.BLACK);
		setEnabled(false);
		setBackground(new Color(255, 255, 255));
		setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		Font montserratFont = new Font("Montserrat", Font.PLAIN, 12);
		setFont(montserratFont);
		setOpaque(true);
		/*
		// Estilos del header o los header
		ColumnaBuscar estilosHeader = new ColumnaBuscar();
		getTableHeader().setDefaultRenderer(estilosHeader);
		 * */
		
		// Establecer el renderizador personalizado para las celdas del contenido de la tabla
        DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                        column);
                label.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0)); // Padding izquierdo
                return label;
            }
        };

        setDefaultRenderer(Object.class, customRenderer);
		
		// Configuración del renderizador personalizado para los encabezados
        JTableHeader header = getTableHeader();
        header.setDefaultRenderer(new HeaderTablasPers());
		getTableHeader().setPreferredSize(new java.awt.Dimension(30, 100));

	}

}
