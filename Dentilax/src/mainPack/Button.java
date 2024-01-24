package mainPack;
import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setForeground(Color.WHITE);
        setBackground(new Color(0, 140, 206));
        setText(value != null ? value.toString() : "");
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;

    public ButtonEditor(JTextField textField) {
        super(textField);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> fireEditingStopped());
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(0, 140, 206));
        button.setText(value != null ? value.toString() : "");
        return button;
    }

    public Object getCellEditorValue() {
        return button.getText();
    }
}
