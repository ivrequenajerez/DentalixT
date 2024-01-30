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

		// Código existente...
		setBounds(0, -1, 1179, 691);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(Color.WHITE);
		setLayout(null);
		setBackground(Color.decode("#008cce"));
		setLayout(null); // Layout nulo para posicionar manualmente los componentes

		// BOTON GUARDAR

		java.net.URL imgUrl11 = getClass().getResource("/save.png");
		Icon icon11 = new ImageIcon(imgUrl11);

		// BOTON ELIMINAR

		java.net.URL imgUrl12 = getClass().getResource("/eliminar.png");
		Icon icon12 = new ImageIcon(imgUrl12);

		// BOTON VOLVER

		java.net.URL imgUrl13 = getClass().getResource("/volverIcono.png");
		Icon icon13 = new ImageIcon(imgUrl13);

		// Panel Principal

		JScrollPane editarPanel = new JScrollPane();
		editarPanel.setBounds(0, -1, 1179, 691);
		this.add(editarPanel);

		// Panel donde están los labels
		JPanel panel = new JPanel(); // PANEL DONDE ESTAN LOS LABELS
		editarPanel.setViewportView(panel);
		panel.setBackground(new Color(255, 255, 255));

		// Cargar la imagen desde la carpeta de recursos
		String rutaImagen = "/doctorIcono.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imagen1 = new ImageIcon(urlImagen);
		panel.setLayout(null);

		// Añadir la imagen al panel
		JLabel labelImagen = new JLabel(imagen1);
		labelImagen.setBounds(10, 115, 512, 512);
		panel.add(labelImagen);

		// COLOR DEL PANEL(FONDO)

		// ID
		JLabel label_ID = new JLabel("ID:");
		label_ID.setBounds(630, 511, 36, 55);
		label_ID.setBackground(new Color(0, 128, 192));
		panel.add(label_ID);

		// Establecemos el tamaño y su fuente
		label_ID.setFont(fuenteLabel);
		label_ID.setBackground(Color.decode("#008cce"));

		// L NOMBRE
		JLabel label_Nombre = new JLabel("Nombre:");
		label_Nombre.setBounds(591, 13, 85, 65);
		panel.add(label_Nombre);

		label_Nombre.setFont(fuenteLabel);
		label_Nombre.setBackground(Color.decode("#008cce"));

		// APELLIDOS

		JLabel label_Apellidos = new JLabel("Apellidos:");
		label_Apellidos.setBounds(583, 89, 85, 65);
		panel.add(label_Apellidos);

		label_Apellidos.setFont(fuenteLabel);

		// TELEFONO

		JLabel label_Telefono = new JLabel("Teléfono:");
		label_Telefono.setBounds(591, 223, 82, 65);
		panel.add(label_Telefono);

		label_Telefono.setFont(fuenteLabel);

		// DIRECCION

		JLabel label_Direccion = new JLabel("Dirección:");
		label_Direccion.setBounds(583, 159, 93, 65);
		panel.add(label_Direccion);

		label_Direccion.setFont(fuenteLabel);

		// ID ESPECIALIDAD

		JLabel label_IDEspecialidad = new JLabel("ID Especialidad:");
		label_IDEspecialidad.setBounds(526, 435, 150, 65);
		panel.add(label_IDEspecialidad);

		label_IDEspecialidad.setFont(fuenteLabel);

		// SALARIO

		JLabel label_Salario = new JLabel("Salario:");
		label_Salario.setBounds(602, 359, 74, 65);
		panel.add(label_Salario);

		label_Salario.setFont(fuenteLabel);

		// EMAIL

		JLabel label_Email = new JLabel("Email:");
		label_Email.setBounds(606, 299, 62, 65);
		panel.add(label_Email);

		label_Email.setFont(fuenteLabel);

		String rutaImagen2 = "/guardarIcono.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen2 = getClass().getResource(rutaImagen2);

		// TextFields separados equitativamente

		JTextField textField_nombre = new JTextField();
		textField_nombre.setBounds(673, 30, 379, 38);
		panel.add(textField_nombre);

		JTextField textField_apellidos = new JTextField();
		textField_apellidos.setBounds(673, 100, 379, 38);
		panel.add(textField_apellidos);

		JTextField textField_direccion = new JTextField();
		textField_direccion.setBounds(673, 170, 379, 38);
		panel.add(textField_direccion);

		JTextField textField_tlf = new JTextField();
		textField_tlf.setBounds(673, 240, 379, 38);
		textField_tlf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				if (!Character.isDigit(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		panel.add(textField_tlf);

		textField_email = new JTextField();
		textField_email.setBounds(673, 310, 379, 38);
		panel.add(textField_email);

		textField_Salario = new JTextField();
		textField_Salario.setBounds(673, 380, 379, 38);

		// ERRORES

		textField_Salario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == KeyEvent.VK_BACK_SPACE) {
					return;
				}
				if (!Character.isDigit(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});
		panel.add(textField_Salario);

		textField_especialidad = new JTextField();
		textField_especialidad.setBounds(673, 450, 379, 38);
		textField_especialidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == KeyEvent.VK_BACK_SPACE) {
					return;
				}

				if (!Character.isDigit(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		panel.add(textField_especialidad);

		textField_id = new JTextField();
		textField_id.setBounds(673, 520, 379, 38);
		textField_id.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c == KeyEvent.VK_BACK_SPACE) {
					return;
				}

				if (!Character.isDigit(c)) {
					e.consume();
					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(textField_id);

		labelDoctor.setBounds(113, 45, 468, 47);
		panel.add(labelDoctor);
		labelDoctor.setFont(new Font("Montserrat", Font.PLAIN, 50));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(591, 593, 592, 75);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode("#FFFFFF"));

		// BOTÓN GUARDAR
		JButton btnGuardar = new JButton(icon11);
		btnGuardar.setBounds(28, 11, 76, 59);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los valores de los campos
				String nombre = textField_nombre.getText();
				String apellidos = textField_apellidos.getText();
				String telefono = textField_direccion.getText();
				String direccion = textField_tlf.getText();
				String salario = textField_email.getText();
				String idEspecialidad = textField_Salario.getText();
				String email = textField_especialidad.getText();
				String id = textField_id.getText();

				// Verificar que todos los campos estén llenos
				if (nombre.isEmpty() || apellidos.isEmpty() || telefono.isEmpty() || direccion.isEmpty()
						|| salario.isEmpty() || idEspecialidad.isEmpty() || email.isEmpty() || id.isEmpty()) {
					// Mostrar un mensaje de error si algún campo está vacío
					JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!email.contains("@")) {
					// Mostrar un mensaje de error si el correo electrónico no contiene '@'
					JOptionPane.showMessageDialog(null, "Ingrese un correo electrónico válido", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		/*
		 * // Establecer el botón como predeterminado para la tecla "Enter"
		 * getRootPane().setDefaultButton(btnGuardar);
		 * 
		 * // Agrega el ActionListener para la tecla "Enter" en el JFrame
		 * addKeyListener(new KeyAdapter() {
		 * 
		 * @Override public void keyTyped(KeyEvent e) { if (e.getKeyChar() ==
		 * KeyEvent.VK_ENTER) { // Simular el clic en el botón al presionar "Enter"
		 * btnGuardar.doClick(); } } });
		 */

		// BOTÓN VOLVER
		JButton btnVolver = new JButton(icon13);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaPrincipal ventanaDoctorInterna = new VentanaPrincipal();
				ventanaDoctorInterna.setVisible(true);

			}
		});
		btnVolver.setBounds(391, 0, 164, 80);
		panel_1.add(btnVolver);
		btnVolver.setPreferredSize(new Dimension(96, 96));
		btnVolver.setContentAreaFilled(false);

		// BOTÓN ELIMINAR
		JButton btnEliminar = new JButton(icon12);
		btnEliminar.setBounds(192, 0, 164, 80);
		panel_1.add(btnEliminar);
		btnEliminar.setPreferredSize(new Dimension(96, 96));
		btnEliminar.setContentAreaFilled(false);

	}

	public JLabel getLabelDoctor() {
		return labelDoctor;
	}
}
