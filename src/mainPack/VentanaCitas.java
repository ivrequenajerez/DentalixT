package mainPack;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import database.ConectorBBDD;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

public class VentanaCitas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	public JLabel labelCitas = new JLabel("Citas");
	private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
	// Campos de texto
	public JTextField textField_Doc;
	public JTextField textField_Motivo;
	public JTextField textField_Fecha;
	public JLabel lblFecha;
	public JTextField textField_Hora;
	public JTextField textField_DocDoctor;
	public JLabel lblHora;
	public JLabel lblDocDoctor;
	ConectorBBDD conectorBBDD = new ConectorBBDD();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCitas frame = new VentanaCitas();
					frame.setResizable(false);
					frame.setIconImage(
							Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));

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
	public VentanaCitas() {
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(100, 100, 1292, 737);
		panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panel);
		panel.setLayout(null);

		labelCitas.setFont(new Font("Dialog", Font.PLAIN, 74));
		labelCitas.setBounds(154, 51, 706, 76);
		panel.add(labelCitas);

		// Cargar la imagen desde la carpeta de recursos
		String rutaImagen = "/cita.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imagen1 = new ImageIcon(urlImagen);
		panel.setLayout(null);

		// Añadir la imagen al panel
		JLabel labelImagen = new JLabel(imagen1);
		labelImagen.setBounds(10, 115, 512, 512);
		panel.add(labelImagen);

		// -- Botones -- //

		// Estilos
		java.net.URL imgUrl11 = getClass().getResource("/save.png");
		Icon icon11 = new ImageIcon(imgUrl11);

		java.net.URL imgUrl12 = getClass().getResource("/eliminar.png");
		Icon icon12 = new ImageIcon(imgUrl12);

		java.net.URL imgUrl13 = getClass().getResource("/volverIcono.png");
		Icon icon13 = new ImageIcon(imgUrl13);

		JLabel lblDoc = new JLabel("DNI: ");
		lblDoc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDoc.setBounds(727, 196, 164, 35);
		panel.add(lblDoc);

		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblMotivo.setBounds(727, 269, 164, 35);
		panel.add(lblMotivo);

		lblFecha = new JLabel("Fecha: ");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFecha.setBounds(727, 340, 164, 35);
		panel.add(lblFecha);

		lblHora = new JLabel("Hora: ");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblHora.setBounds(727, 399, 164, 35);
		panel.add(lblHora);

		lblDocDoctor = new JLabel("DNI Doctor: ");
		lblDocDoctor.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDocDoctor.setBounds(727, 460, 164, 35);
		panel.add(lblDocDoctor);

		// Contenedor
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(698, 522, 480, 76);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode("#FFFFFF"));

		// Instancias - Botones //

		// GUARDAR
		JButton btnGuardar = new JButton(icon11);
		btnGuardar.setBounds(10, 11, 78, 54);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);

		// BOTÓN ELIMINAR
		JButton btnEliminar = new JButton(icon12);
		btnEliminar.setBounds(202, 11, 78, 54);
		panel_1.add(btnEliminar);
		btnEliminar.setPreferredSize(new Dimension(96, 96));
		btnEliminar.setContentAreaFilled(false);

		// BOTÓN VOLVER
		JButton btnVolver = new JButton(icon13);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(true);
				dispose();
				
				ventanaPrincipal.getButton3().doClick();
				ventanaPrincipal.getButton3().setVisible(true);
			}
		});

		btnVolver.setBounds(392, 11, 78, 54);
		panel_1.add(btnVolver);
		btnVolver.setPreferredSize(new Dimension(96, 96));
		btnVolver.setContentAreaFilled(false);

		// -- FIN Botones -- //

		// Campos de texto //
		textField_Doc = new JTextField();
		textField_Doc.setBounds(873, 183, 257, 48);
		panel.add(textField_Doc);
		textField_Doc.setColumns(10);

		textField_Motivo = new JTextField();
		textField_Motivo.setColumns(10);
		textField_Motivo.setBounds(873, 256, 257, 48);

		panel.add(textField_Motivo);

		textField_Fecha = new JTextField();
		textField_Fecha.setColumns(10);
		textField_Fecha.setBounds(873, 327, 257, 48);

		panel.add(textField_Fecha);

		textField_Hora = new JTextField();
		textField_Hora.setColumns(10);
		textField_Hora.setBounds(873, 386, 257, 48);
		panel.add(textField_Hora);

		textField_DocDoctor = new JTextField();
		textField_DocDoctor.setColumns(10);
		textField_DocDoctor.setBounds(873, 447, 257, 48);
		panel.add(textField_DocDoctor);

//		// Control de excepción
//		textField_Motivo.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				if (c == KeyEvent.VK_BACK_SPACE) {
//					return;
//				}
//				if (!Character.isDigit(c)) {
//					e.consume();
//					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
//							JOptionPane.WARNING_MESSAGE);
//				}
//
//			}
//		});

//		textField_Fecha.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyTyped(KeyEvent e) {
//				char c = e.getKeyChar();
//				if (c == KeyEvent.VK_BACK_SPACE) {
//					return;
//				}
//				if (!Character.isDigit(c)) {
//					e.consume();
//					JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia",
//							JOptionPane.WARNING_MESSAGE);
//				}
//
//			}
//		});

		// ---- FUNCIONALIDAD BOTONES ---- //

		// Guardar
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los valores de los campos
				String Documento = textField_Doc.getText();
				String Motivo = textField_Motivo.getText();
				String Fecha = textField_Fecha.getText();
				String Hora = textField_Hora.getText();
				String DocumentoDoctor = textField_DocDoctor.getText();

				// Verificar que todos los campos estén llenos
				if (Documento.isEmpty() || Motivo.isEmpty() || Fecha.isEmpty() || Hora.isEmpty() || DocumentoDoctor.isEmpty())  {
					// Mostrar un mensaje de error si algún campo está vacío
					JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} 
				else if (!Documento.isEmpty() && !Motivo.isEmpty() && !Fecha.isEmpty() && !Hora.isEmpty() && !DocumentoDoctor.isEmpty()) {
		            // Ejecutar la función para actualizar los datos en la base de datos
		            conectorBBDD.actualizarDatosCita(Documento, Motivo, Fecha, Hora, DocumentoDoctor);
		            
		        }
				else {
					// Llamar al método para insertar paciente en la base de datos
					((ConectorBBDD) conectorBBDD).insertarCita(Documento, Motivo, Fecha, Hora,
							DocumentoDoctor);

					// Luego, si es necesario, puedes actualizar la tabla o realizar otras acciones
					// después de la inserción.
				}
			}
		});

	}
//	public JLabel getlabelMateriales() {
//		return labelMateriales;
//	}
}
