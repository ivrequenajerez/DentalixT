package mainPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import database.ConectorBBDD;

//import otros.VentanaDoctorInterna;

import javax.swing.JButton;
import javax.swing.JTextField;

public class VentanaMaterial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public JLabel labelMateriales = new JLabel("Materiales");
	public JTextField textField_nombre;
	public JTextField textField_cantidad;
	public JTextField textField_precio;
	ConectorBBDD conectorBBDD = new ConectorBBDD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMaterial frame = new VentanaMaterial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaMaterial() {

		// BOTON GUARDAR

		java.net.URL imgUrl11 = getClass().getResource("/save.png");
		Icon icon11 = new ImageIcon(imgUrl11);

		// BOTON ELIMINAR

		java.net.URL imgUrl12 = getClass().getResource("/eliminar.png");
		Icon icon12 = new ImageIcon(imgUrl12);

		// BOTON VOLVER
		java.net.URL imgUrl13 = getClass().getResource("/volverIcono.png");
		Icon icon13 = new ImageIcon(imgUrl13);
		setBounds(100, 100, 1292, 737);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		labelMateriales.setFont(new Font("Montserrat", Font.PLAIN, 50));
		labelMateriales.setBounds(121, 49, 419, 76);
		panel.add(labelMateriales);

		// Cargar la imagen desde la carpeta de recursos
		String rutaImagen = "/carpeta.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imagen1 = new ImageIcon(urlImagen);
		panel.setLayout(null);

		// Añadir la imagen al panel
		JLabel labelImagen = new JLabel(imagen1);
		labelImagen.setBounds(77, 119, 512, 512);
		panel.add(labelImagen);

		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblNewLabel.setBounds(727, 187, 164, 35);
		panel.add(lblNewLabel);

		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblCantidad.setBounds(727, 259, 164, 35);
		panel.add(lblCantidad);

		JLabel lblPrecio = new JLabel("Precio\r\n\r\n");
		lblPrecio.setFont(new Font("Montserrat", Font.BOLD, 18));
		lblPrecio.setBounds(727, 327, 164, 35);
		panel.add(lblPrecio);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(698, 522, 480, 76);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode("#FFFFFF"));

		// BOTÓN GUARDAR
		JButton btnGuardar = new JButton(icon11);

		btnGuardar.setBounds(10, 11, 78, 54);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los valores de los campos
				String nombre = textField_nombre.getText();
				String cantidad = textField_cantidad.getText();
				String precio = textField_precio.getText();

				if (nombre.isEmpty() || cantidad.isEmpty() || precio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!nombre.isEmpty() && !cantidad.isEmpty() && !precio.isEmpty()) {
					// Ejecutar la función para actualizar los datos en la base de datos
					conectorBBDD.actualizarDatosMaterial(nombre, cantidad, precio);

				} else {
					// Crear una instancia de ConectorBBDD (asegúrate de que sea accesible desde
					// esta clase)

					// Llamar al método para insertar paciente en la base de datos
					((ConectorBBDD) conectorBBDD).insertarMaterial(nombre, cantidad, precio);

				}
			}
		});

		// BOTÓN ELIMINAR
		JButton btnEliminar = new JButton(icon12);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_nombre.setText("");
				textField_cantidad.setText("");
				textField_precio.setText("");

			}
		});
		btnEliminar.setBounds(202, 11, 78, 54);
		panel_1.add(btnEliminar);
		btnEliminar.setPreferredSize(new Dimension(96, 96));
		btnEliminar.setContentAreaFilled(false);

		// BOTÓN VOLVER
		JButton btnVolver = new JButton(icon13);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				// Posicionar la ventana en el centro
				ventanaPrincipal.setLocationRelativeTo(null);
				// Ajuste para que no se pueda cambiar el tamaño de la ventana
				ventanaPrincipal.setResizable(false);
				// Icono pequeño para la ventana (superior izq)
				ventanaPrincipal.setIconImage(
						Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
				// Se hace visible la ventana
				ventanaPrincipal.setVisible(true);

				// Cargar la lista de materiales
				ventanaPrincipal.getButton4().doClick();
				ventanaPrincipal.getButton4().setVisible(true);

				dispose();

			}
		});

		btnVolver.setBounds(392, 11, 78, 54);
		panel_1.add(btnVolver);
		btnVolver.setPreferredSize(new Dimension(96, 96));
		btnVolver.setContentAreaFilled(false);

		textField_nombre = new JTextField();
		textField_nombre.setBounds(873, 183, 257, 48);
		panel.add(textField_nombre);
		textField_nombre.setColumns(10);

		textField_cantidad = new JTextField();
		textField_cantidad.setColumns(10);
		textField_cantidad.setBounds(873, 259, 257, 48);

		textField_cantidad.addKeyListener(new KeyAdapter() {
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
		panel.add(textField_cantidad);

		textField_precio = new JTextField();
		textField_precio.setColumns(10);
		textField_precio.setBounds(873, 327, 257, 48);

		textField_precio.addKeyListener(new KeyAdapter() {
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
		panel.add(textField_precio);

	}

	public JLabel getlabelMateriales() {
		return labelMateriales;
	}

}
