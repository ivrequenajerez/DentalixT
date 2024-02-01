package mainPack;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;

import javax.print.DocFlavor.URL;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class VentanaDoctor extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
	private static final Font fuenteGrande = new Font("Montserrat", Font.PLAIN, 50);
	int yPosition = 30;
	int separacionVertical = 70;
	private JTextField textField_email;
	private JTextField textField_Salario;
	private JTextField textField_especialidad;
	private JTextField textField_id;
	private JOptionPane joptionPane;
	JLabel labelDoctor = new JLabel("NOMBRE DOCTOR");

	/**
	 * Create the panel.
	 */
	public VentanaDoctor() {

	}
}