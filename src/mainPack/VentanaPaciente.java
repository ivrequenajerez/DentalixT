package mainPack;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.commons.collections4.map.HashedMap;

import database.ConectorBBDD;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.*;

public class VentanaPaciente extends JFrame {

	// Variables
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
	private static final Font fuenteGrande = new Font("Montserrat", Font.PLAIN, 50);
	
	int yPosition = 40;
	int separacionVertical = 70;
	private JTextField textField_Id;
	JButton btnGuardar;
	static ConectorBBDD conectorBBDDD;
	private JasperReport reporte;
	
	public JLabel lblIDPaciente = new JLabel(" "); // ID o Documento del Paciente
	public JLabel labelPaciente = new JLabel(" "); // Nombre y Apellidos del Paciente
	public JTextField textField_nombre = new JTextField();
	public JTextField textField_apellidos = new JTextField();
	public JTextField textField_direccion = new JTextField();
	public JTextField textField_tlf = new JTextField();
	public JTextField textField_UltimaConsulta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					VentanaPaciente frame = new VentanaPaciente();
					frame.setResizable(false);
					frame.setIconImage(
							Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
					frame.setLocationRelativeTo(null);
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
	public VentanaPaciente() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		setBounds(0, -1, 1179, 691);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setBackground(Color.decode("#008cce"));
		getContentPane().setLayout(null); // Layout nulo para posicionar manualmente los componentes

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
		getContentPane().add(editarPanel);

		// Panel donde están los labels
		JPanel panel = new JPanel(); // PANEL DONDE ESTAN LOS LABELS
		editarPanel.setViewportView(panel);
		panel.setBackground(Color.decode("#FFFFFF"));

		// Cargar la imagen desde la carpeta de recursos
		String rutaImagen = "/paciente.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imagen1 = new ImageIcon(urlImagen);
		panel.setLayout(null);

		// 	 la imagen al panel
		JLabel labelImagen = new JLabel(imagen1);
		labelImagen.setBounds(0, 124, 544, 512);
		panel.add(labelImagen);

		// L NOMBRE
		JLabel label_Nombre = new JLabel("Nombre:");
		label_Nombre.setBounds(520, 93, 200, 65);
		panel.add(label_Nombre);

		label_Nombre.setFont(fuenteLabel);
		label_Nombre.setBackground(Color.decode("#008cce"));

		// APELLIDOS

		JLabel label_Apellidos = new JLabel("Apellidos:");
		label_Apellidos.setBounds(520, 162, 200, 65);
		panel.add(label_Apellidos);

		label_Apellidos.setFont(fuenteLabel);

		// TELEFONO

		JLabel label_Telefono = new JLabel("Teléfono:");
		label_Telefono.setBounds(520, 300, 100, 65);
		panel.add(label_Telefono);

		label_Telefono.setFont(fuenteLabel);

		// DIRECCION

		JLabel label_Direccion = new JLabel("Dirección:");
		label_Direccion.setBounds(520, 231, 200, 65);
		panel.add(label_Direccion);

		label_Direccion.setFont(fuenteLabel);

		// SALARIO

		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(555, 420, 40, 65);
		panel.add(lblId);

		lblId.setFont(fuenteLabel);

		// EMAIL

		JLabel lblUltimaConsulta = new JLabel("Últ. Consulta:");
		lblUltimaConsulta.setBounds(520, 360, 200, 65);
		panel.add(lblUltimaConsulta);

		lblUltimaConsulta.setFont(fuenteLabel);

		String rutaImagen2 = "/guardarIcono.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen2 = getClass().getResource(rutaImagen2);

		textField_nombre = new JTextField();
		textField_nombre.setBounds(673, yPosition + separacionVertical * 1, 379, 38);
		panel.add(textField_nombre);

		textField_apellidos = new JTextField();
		textField_apellidos.setBounds(673, 175, 379, 38);
		panel.add(textField_apellidos);

		textField_direccion = new JTextField();
		textField_direccion.setBounds(673, 245, 379, 38);
		panel.add(textField_direccion);

		textField_tlf = new JTextField();
		textField_tlf.setBounds(673, 315, 379, 38);
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

		JTextField textField_UltimaConsulta = new JTextField();
		textField_UltimaConsulta.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (c == KeyEvent.VK_BACK_SPACE) {
		            return;
		        }

		        if (!Character.isDigit(c) && c != '-') {
		            e.consume();
		            JOptionPane.showMessageDialog(null, "Solo se pueden introducir números y '-'", "Advertencia",
		                    JOptionPane.WARNING_MESSAGE);
		        }
		    }
		});

		
		textField_UltimaConsulta.setBounds(673, 375, 379, 38);
		panel.add(textField_UltimaConsulta);
		
		labelPaciente.setHorizontalAlignment(SwingConstants.CENTER);

		labelPaciente.setBounds(0, 40, 533, 47);
		panel.add(labelPaciente);
		labelPaciente.setFont(new Font("Montserrat", Font.PLAIN, 40));

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(591, 550, 592, 75);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode("#FFFFFF"));

		// BOTÓN GUARDAR
		btnGuardar = new JButton(icon11);
		btnGuardar.setBounds(10, 11, 78, 54);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Obtener los valores de los campos
				String nombre = textField_nombre.getText();
				String apellidos = textField_apellidos.getText();
				String direccion = textField_direccion.getText();
				String telefono = textField_tlf.getText();
				String ultimaConsulta = textField_UltimaConsulta.getText();
				String id = lblIDPaciente.getText();

				if (nombre.isEmpty() || apellidos.isEmpty() || direccion.isEmpty() || telefono.isEmpty()
						|| ultimaConsulta.isEmpty() || id.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					// Crear una instancia de ConectorBBDD (asegúrate de que sea accesible desde
					// esta clase)
					ConectorBBDD conectorBBDD = new ConectorBBDD();

					// Llamar al método para insertar paciente en la base de datos
					((ConectorBBDD) conectorBBDD).insertarPaciente(nombre, apellidos, direccion, telefono,
							ultimaConsulta, id);

					// Luego, si es necesario, puedes actualizar la tabla o realizar otras acciones
					// después de la inserción.
				}
			}
		});

		// BOTÓN VOLVER
		JButton btnVolver = new JButton(icon13);
		btnVolver.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				// Instancia
				VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
				ventanaPrincipal.setVisible(false);
				// Posicionar la ventana en el centro
				ventanaPrincipal.setLocationRelativeTo(null);
				// Ajuste para que no se pueda cambiar el tamaño de la ventana
				ventanaPrincipal.setResizable(false);
				// Icono pequeño para la ventana (superior izq)
				ventanaPrincipal.setIconImage(
						Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
				// Se hace visible la ventana
				ventanaPrincipal.setVisible(true);
				dispose();

				/*
				 * AL hacer click debe volver a VP, al botón de P (lista)
				 * 
				 */

				ventanaPrincipal.getButton1().doClick();
				ventanaPrincipal.getButton1().setVisible(true);

			}
		});
		btnVolver.setBounds(391, 0, 164, 80);
		panel_1.add(btnVolver);
		btnVolver.setPreferredSize(new Dimension(96, 96));
		btnVolver.setContentAreaFilled(false);

		// BOTÓN ELIMINAR
		JButton btnEliminar = new JButton(icon12);
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textField_nombre.setText("");
				textField_apellidos.setText("");
				textField_direccion.setText("");
				textField_tlf.setText("");
				textField_UltimaConsulta.setText("");
				lblIDPaciente.setText("");

			}
		});
		btnEliminar.setBounds(192, 0, 164, 80);
		panel_1.add(btnEliminar);
		btnEliminar.setPreferredSize(new Dimension(96, 96));
		btnEliminar.setContentAreaFilled(false);
		
		JButton btnNewButton = new JButton("Facturacion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					  conectorBBDDD = new ConectorBBDD();
				Map<String, Object> parametros = new HashedMap<String, Object>();
				parametros.put("idPaciente", lblIDPaciente.getText());
				reporte = JasperCompileManager.compileReport("factura1.jrxml");
				JasperPrint p = JasperFillManager.fillReport(reporte, parametros, conectorBBDDD.conectarConBBDD());
				JasperViewer viewer = new JasperViewer(p, false);
	            viewer.setVisible(true);
	            dispose();
	            viewer.toFront();
				}catch (JRException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(647, 40, 137, 42);
		panel.add(btnNewButton);

		lblIDPaciente.setFont(new Font("Montserrat", Font.BOLD, 20));
		lblIDPaciente.setBounds(675, 440, 200, 25);
		panel.add(lblIDPaciente);

		// Atajo de teclado
		InputMap inputMap = getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_DOWN_MASK);
		inputMap.put(keyStroke, "cerrarVentana");

		getRootPane().getActionMap().put("cerrarVentana", new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}

	public void setDefaultButton() {
		if (getRootPane() != null) {
			getRootPane().setDefaultButton(btnGuardar);
		}
	}

	public JLabel getLabelPaciente() {
		return labelPaciente;
	}

}
