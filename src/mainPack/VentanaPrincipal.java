package mainPack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.Dimension;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import database.ConectorBBDD;

import javax.swing.JTextField;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel bienvenido;
	private JLabel texto1;
	private JButton botonSalir;
	private ConectorBBDD conector = new ConectorBBDD();
	private JTextField fieldBuscar;
	private static JFrame VentanaPrincipal;
	private JButton button1;
	private JButton button2;
	private JButton button3;

	/**
	 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setIconImage(
							Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public VentanaPrincipal() {

		// asdasd

		super("Dentilax");

		setResizable(false);

		setVisible(true);

		// Icono
		ImageIcon icono1 = new ImageIcon("/logoDentilax.png");
		VentanaPrincipal.this.setIconImage(icono1.getImage());

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1292, 737);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel logoBlanco = new JLabel("");
		logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(logoBlanco);

		ImageIcon imagenLogo = new ImageIcon(getClass().getResource("/logoAzul.png"));
		int ancho = imagenLogo.getIconWidth();
		int alto = imagenLogo.getIconHeight();

		logoBlanco.setBounds(0, 0, 100, 100);

		Icon icono = new ImageIcon(imagenLogo.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		logoBlanco.setIcon(icono);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(null);
		buttonPanel.setForeground(new Color(255, 255, 255));
		buttonPanel.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(0, 101, 100, 590);
		scrollPane.setBorder(null);
		contentPane.add(scrollPane);

		// Tabla
		DefaultTableModel modeloTabla = new DefaultTableModel();
		Tabla table = new Tabla(modeloTabla);
		// table.getColumnModel().getColumn(modeloTabla.getColumnCount() -
		// 1).setCellRenderer(new ColumnaBuscar());

		// Esto es como si fuera el <div> que encierra al componente JTable
		JPanel tablasPanel = new JPanel();
		tablasPanel.setBackground(new Color(255, 255, 255));
		tablasPanel.setBounds(99, -1, 1179, 691);
		contentPane.add(tablasPanel);
		tablasPanel.setLayout(null);
		tablasPanel.setVisible(false);
		tablasPanel.add(table);

		// El JScrollPane es necesario para añadir una tabla de forma correcta en Java.
		// Para scrolear.
		JScrollPane scrollPaneT = new JScrollPane(table);
		scrollPaneT.setBounds(-2, 0, 1040, 691);
		tablasPanel.add(scrollPaneT);
		scrollPaneT.setBackground(new Color(255, 255, 255));

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// //

		// Panel derecho de botones y campo (PACIENTES)
		JPanel panelMenuDer = new JPanel();
		tablasPanel.add(panelMenuDer);
		panelMenuDer.setLayout(null);
		panelMenuDer.setVisible(false);

		// Panel derecho de botones y campo (DOCTORES)
		JPanel panelMenuDer2 = new JPanel();
		tablasPanel.add(panelMenuDer2);
		panelMenuDer2.setLayout(null);
		panelMenuDer2.setVisible(false);

		// Panel derecho de botones y campo (CITAS)
		JPanel panelMenuDer3 = new JPanel();
		tablasPanel.add(panelMenuDer3);
		panelMenuDer3.setLayout(null);
		panelMenuDer3.setVisible(false);

		// Panel derecho de botones y campo (MATERIAL)
		JPanel panelMenuDer4 = new JPanel();
		tablasPanel.add(panelMenuDer4);
		panelMenuDer4.setLayout(null);
		panelMenuDer4.setVisible(false);

		// -----------------------------------------------------------------------------------------------------------------------------------------------
		// //

		// ---- Componentes Panel PACIENTES ---- //
		JPanel panelComponentes = new JPanel();
		panelComponentes.setBounds(0, 0, 141, 101);
		panelMenuDer.add(panelComponentes);

		// Campo de búsqueda
		JTextField fieldBuscar = new JTextField("Buscar...");
		fieldBuscar.setBounds(10, 10, 121, 25);
		panelComponentes.add(fieldBuscar);

		// Botón Añadir (PACIENTES)
		JButton botonAñadirPaciente = new JButton("AÑADIR PACIENTE");
		botonAñadirPaciente.setBounds(22, 40, 97, 21);
		panelComponentes.add(botonAñadirPaciente);

		// Botón Editar
		JButton botonEditar = new JButton("EDITAR");
		botonEditar.setBounds(22, 66, 97, 21);
		panelComponentes.add(botonEditar);

		// ---- Componentes Panel DOCTORES ---- //
		JPanel panelComponentes2 = new JPanel();
		panelComponentes2.setBounds(0, 0, 141, 101);
		panelMenuDer2.add(panelComponentes2);

		// Campo de búsqueda para DOCTORES
		JTextField fieldBuscar2 = new JTextField("Buscar...");
		fieldBuscar2.setBounds(10, 10, 121, 25);
		panelComponentes2.add(fieldBuscar2);

		// Botón Añadir para DOCTORES
		JButton botonAñadir2 = new JButton("AÑADIR DOCTOR");
		panelComponentes2.add(botonAñadir2);

		// Botón Editar para DOCTORES
		JButton botonEditar2 = new JButton("EDITAR");
		botonEditar2.setBounds(22, 66, 97, 21);
		panelComponentes2.add(botonEditar2);

		// ---- Componentes Panel CITAS ---- //
		JPanel panelComponentes3 = new JPanel();
		panelComponentes3.setBounds(0, 0, 141, 101);
		panelMenuDer3.add(panelComponentes3);

		// Campo de búsqueda para CITAS
		JTextField fieldBuscar3 = new JTextField("Buscar...");
		fieldBuscar3.setBounds(10, 10, 121, 25);
		panelComponentes3.add(fieldBuscar3);

		// Botón Añadir para CITAS
		JButton botonAñadir3 = new JButton("AÑADIR CITA");
		panelComponentes3.add(botonAñadir3);

		// Botón Editar para CITAS
		JButton botonEditar3 = new JButton("EDITAR");
		botonEditar3.setBounds(22, 66, 97, 21);
		panelComponentes3.add(botonEditar3);

		// ---- Componentes Panel MATERIAL ---- //
		JPanel panelComponentes4 = new JPanel();
		panelComponentes4.setBounds(0, 0, 141, 101);
		panelMenuDer4.add(panelComponentes4);

		// Campo de búsqueda para MATERIAL
		JTextField fieldBuscar4 = new JTextField("Buscar...");
		fieldBuscar4.setBounds(10, 10, 121, 25);
		panelComponentes4.add(fieldBuscar4);

		// Botón Añadir para MATERIAL
		JButton botonAñadir4 = new JButton("AÑADIR MATERIAL");
		panelComponentes4.add(botonAñadir4);

		// Botón Editar para MATERIAL
		JButton botonEditar4 = new JButton("EDITAR");
		botonEditar4.setBounds(22, 66, 97, 21);
		panelComponentes4.add(botonEditar4);

		// Estilos componentes //

		panelMenuDer.setBackground(Color.WHITE);
		panelMenuDer.setBounds(1038, 0, 141, 691);
		panelMenuDer2.setBackground(Color.WHITE);
		panelMenuDer2.setBounds(1038, 0, 141, 691);
		panelMenuDer3.setBackground(Color.WHITE);
		panelMenuDer3.setBounds(1038, 0, 141, 691);
		panelMenuDer4.setBackground(Color.WHITE);
		panelMenuDer4.setBounds(1038, 0, 141, 691);

		panelComponentes.setBackground(new Color(0, 140, 206));
		botonAñadirPaciente.setBackground(Color.WHITE);
		botonAñadirPaciente.setForeground(new Color(0, 140, 206));
		botonAñadirPaciente.setFont(new Font("Montserrat", Font.BOLD, 12));
		botonEditar.setBackground(Color.WHITE);
		botonEditar.setForeground(new Color(0, 140, 206));
		botonEditar.setFont(new Font("Montserrat", Font.BOLD, 12));
		fieldBuscar.setBackground(Color.WHITE);
		fieldBuscar.setForeground(Color.GRAY);
		fieldBuscar.setFont(new Font("Montserrat", Font.PLAIN, 12));
		fieldBuscar.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelComponentes2.setBackground(new Color(0, 140, 206));
		botonAñadir2.setBackground(Color.WHITE);
		botonAñadir2.setForeground(new Color(0, 140, 206));
		botonAñadir2.setFont(new Font("Montserrat", Font.BOLD, 12));
		botonEditar2.setBackground(Color.WHITE);
		botonEditar2.setForeground(new Color(0, 140, 206));
		botonEditar2.setFont(new Font("Montserrat", Font.BOLD, 12));
		fieldBuscar2.setBackground(Color.WHITE);
		fieldBuscar2.setForeground(Color.GRAY);
		fieldBuscar2.setFont(new Font("Montserrat", Font.PLAIN, 12));
		fieldBuscar2.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelComponentes3.setBackground(new Color(0, 140, 206));
		botonAñadir3.setBackground(Color.WHITE);
		botonAñadir3.setForeground(new Color(0, 140, 206));
		botonAñadir3.setFont(new Font("Montserrat", Font.BOLD, 12));
		botonEditar3.setBackground(Color.WHITE);
		botonEditar3.setForeground(new Color(0, 140, 206));
		botonEditar3.setFont(new Font("Montserrat", Font.BOLD, 12));
		fieldBuscar3.setBackground(Color.WHITE);
		fieldBuscar3.setForeground(Color.GRAY);
		fieldBuscar3.setFont(new Font("Montserrat", Font.PLAIN, 12));
		fieldBuscar3.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		panelComponentes4.setBackground(new Color(0, 140, 206));
		botonAñadir4.setBackground(Color.WHITE);
		botonAñadir4.setForeground(new Color(0, 140, 206));
		botonAñadir4.setFont(new Font("Montserrat", Font.BOLD, 12));
		botonEditar4.setBackground(Color.WHITE);
		botonEditar4.setForeground(new Color(0, 140, 206));
		botonEditar4.setFont(new Font("Montserrat", Font.BOLD, 12));
		fieldBuscar4.setBackground(Color.WHITE);
		fieldBuscar4.setForeground(Color.GRAY);
		fieldBuscar4.setFont(new Font("Montserrat", Font.PLAIN, 12));
		fieldBuscar4.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		// FIN Estilos componentes //

		// ---- Funcionalidad componentes ---- //

		// Campos de búsqueda //

		// Pacientes
		fieldBuscar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String criterio = fieldBuscar.getText().trim();
				boolean retrocesoRealizado = true;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!criterio.isEmpty()) {
						conector.realizarBusqueda(criterio, modeloTabla);
						retrocesoRealizado = false;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && retrocesoRealizado) {
					conector.cargarDatosPacientes(modeloTabla);
				}
			}
		});

		fieldBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldBuscar.getText().equals("Buscar...")) {
					fieldBuscar.setText("");
					fieldBuscar.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldBuscar.getText().isEmpty()) {
					fieldBuscar.setText("Buscar...");
					fieldBuscar.setForeground(Color.GRAY);
				}
			}
		});

		// Doctores
		fieldBuscar2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String criterio = fieldBuscar2.getText().trim();
				boolean retrocesoRealizado = true;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!criterio.isEmpty()) {
						conector.realizarBusqueda(criterio, modeloTabla);
						retrocesoRealizado = false;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && retrocesoRealizado) {
					conector.cargarDatosDoctores(modeloTabla);
				}
			}
		});

		fieldBuscar2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldBuscar2.getText().equals("Buscar...")) {
					fieldBuscar2.setText("");
					fieldBuscar2.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldBuscar2.getText().isEmpty()) {
					fieldBuscar2.setText("Buscar...");
					fieldBuscar2.setForeground(Color.GRAY);
				}
			}
		});

		// Citas
		fieldBuscar3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String criterio = fieldBuscar3.getText().trim();
				boolean retrocesoRealizado = true;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!criterio.isEmpty()) {
						conector.realizarBusqueda(criterio, modeloTabla);
						retrocesoRealizado = false;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && retrocesoRealizado) {
					conector.cargarDatosCitas(modeloTabla);
				}
			}
		});

		fieldBuscar3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldBuscar3.getText().equals("Buscar...")) {
					fieldBuscar3.setText("");
					fieldBuscar3.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldBuscar3.getText().isEmpty()) {
					fieldBuscar3.setText("Buscar...");
					fieldBuscar3.setForeground(Color.GRAY);
				}
			}
		});

		// Material
		fieldBuscar4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String criterio = fieldBuscar4.getText().trim();
				boolean retrocesoRealizado = true;
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (!criterio.isEmpty()) {
						conector.realizarBusqueda(criterio, modeloTabla);
						retrocesoRealizado = false;
					}
				} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE && retrocesoRealizado) {
					conector.cargarDatosMaterial(modeloTabla);
				}
			}
		});

		fieldBuscar4.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (fieldBuscar4.getText().equals("Buscar...")) {
					fieldBuscar4.setText("");
					fieldBuscar4.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (fieldBuscar4.getText().isEmpty()) {
					fieldBuscar4.setText("Buscar...");
					fieldBuscar4.setForeground(Color.GRAY);
				}
			}
		});

		// ---- Botones ---- //

		// Añadir //
		JPanel ventanaPanel = new JPanel();

		// Instancia ventanas
		VentanaPaciente ventanaPaciente = new VentanaPaciente();
		ventanaPaciente.setResizable(false);
		ventanaPaciente
				.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
		ventanaPaciente.setLocationRelativeTo(null);
		VentanaDoctor ventanaDoctor = new VentanaDoctor();
		VentanaCitas ventanaCita = new VentanaCitas();
		VentanaMaterial ventanaMaterial = new VentanaMaterial();

		// Añadir paciente
		botonAñadirPaciente.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ventanaPaciente.setVisible(true);
			}
		});

		// Añadir doctor
		botonAñadir2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				ventanaDoctor.setVisible(true);
				
			}
		});

		// Añadir cita
		botonAñadir3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Cierra la ventana actual (VentanaPrincipal)
				dispose();

				// Muestra la nueva ventana cita
				ventanaCita.setVisible(true);
			}
		});

		// Añadir material
		botonAñadir4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Muestra la nueva ventana cita
				ventanaMaterial.setVisible(true);
			}
		});

		// Editar //

		// Editar paciente
		botonEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra un cuadro de diálogo de entrada
				String documento = JOptionPane.showInputDialog("Introduzca el Documento:");

				// Comprueba si se ingresó un documento
				if (documento != null && !documento.isEmpty()) {
					// Realizar la búsqueda en la base de datos
					conector.realizarBusqueda(documento, modeloTabla);

					// Obtener el nombre y apellidos del primer resultado
					String nombre = "";
					String apellidos = "";

					if (modeloTabla.getRowCount() > 0) {
						nombre = (String) modeloTabla.getValueAt(0, 0);
						apellidos = (String) modeloTabla.getValueAt(0, 1);
					}

					// Actualizar el texto de labelPaciente con el nombre y apellidos
					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					dispose();

					// Instancia y muestra la nueva ventana PacienteCRUD
					ventanaPaciente.setVisible(true);
					ventanaPaciente.labelPaciente.setText(nombre + " " + apellidos);

				} else {
					// Se canceló el ingreso del documento o se dejó en blanco
				}
			}
		});

		// Editar doctor
		botonEditar2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra un cuadro de diálogo de entrada
				String documento = JOptionPane.showInputDialog("Introduzca el Documento:");

				// Comprueba si se ingresó un documento
				if (documento != null && !documento.isEmpty()) {
					// Realizar la búsqueda en la base de datos
					conector.realizarBusqueda(documento, modeloTabla);

					// Obtener el nombre y apellidos del primer resultado
					String nombre = "";
					String apellidos = "";

					if (modeloTabla.getRowCount() > 0) {
						nombre = (String) modeloTabla.getValueAt(0, 0);
						apellidos = (String) modeloTabla.getValueAt(0, 1);
					}

					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					dispose();

					ventanaDoctor.setVisible(true);
					ventanaDoctor.labelDoctor.setText(nombre + " " + apellidos);
				} else {
					// Se canceló el ingreso del documento o se dejó en blanco
				}
			}
		});

		botonEditar3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra un cuadro de diálogo de entrada
				String documento = JOptionPane.showInputDialog("Introduzca el Documento:");

				// Comprueba si se ingresó un documento
				if (documento != null && !documento.isEmpty()) {
					// Realizar la búsqueda en la base de datos
					conector.realizarBusqueda(documento, modeloTabla);

					// Obtener el nombre y apellidos del primer resultado
					String nombre = "";
					String apellidos = "";

					if (modeloTabla.getRowCount() > 0) {
						nombre = (String) modeloTabla.getValueAt(0, 0);
						apellidos = (String) modeloTabla.getValueAt(0, 1);
					}

					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					dispose();

					ventanaCita.setVisible(true);

					// Acción que va a realizar...
					ventanaCita.labelCitas.setText("Cita de " + nombre); // Nombre del paciente en grande

					// Realizar la búsqueda de la cita asociada al paciente
					String consulta = "SELECT * FROM cita WHERE idPaciente_FK = ?";

					try {
						conector.conectarConBBDD();
						PreparedStatement statement = conector.obtenerConexion().prepareStatement(consulta);
						statement.setString(1, documento);

						ResultSet resultSet = statement.executeQuery();

						if (resultSet.next()) {
							// Obtiene los valores de la base de datos
							String fecha = resultSet.getString("fecha");
							String hora = resultSet.getString("hora");
							String motivo = resultSet.getString("motivo");
							String idDoctor = resultSet.getString("idDoctor_FK");

							// Llena los campos de la interfaz gráfica con la información obtenida
							ventanaCita.textField_Doc.setText(documento);
							ventanaCita.textField_Motivo.setText(motivo);
							ventanaCita.textField_Fecha.setText(fecha);
							ventanaCita.textField_Hora.setText(hora);
							ventanaCita.textField_DocDoctor.setText(idDoctor);
						}

						// Cierra los recursos
						resultSet.close();
						statement.close();
						conector.cerrarConexion();

					} catch (SQLException ex) {
						ex.printStackTrace();
						// Manejo de errores
					}
				} else {
					// Se canceló el ingreso del documento o se dejó en blanco
				}
			}
		});

		// Editar material
		botonEditar4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Muestra un cuadro de diálogo de entrada
				String documento = JOptionPane.showInputDialog("Introduzca el Material:");

				// Comprueba si se ingresó un documento
				if (documento != null && !documento.isEmpty()) {
					// Realizar la búsqueda en la base de datos
					conector.realizarBusqueda(documento, modeloTabla);

					// Obtener el nombre y apellidos del primer resultado
					String nombre = "";

					if (modeloTabla.getRowCount() > 0) {
						nombre = (String) modeloTabla.getValueAt(0, 0);
					}

					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					dispose();

					ventanaMaterial.setVisible(true);

					// Acción que va a realizar...
					ventanaCita.labelCitas.setText(nombre);

					String consulta = "SELECT * FROM material WHERE nombre = ?";

					try {
						conector.conectarConBBDD();
						PreparedStatement statement = conector.obtenerConexion().prepareStatement(consulta);
						statement.setString(1, documento);

						ResultSet resultSet = statement.executeQuery();

						if (resultSet.next()) {
							// Obtiene los valores de la base de datos
							String nombreM = resultSet.getString("nombre");
							String cantidad = resultSet.getString("cantidad");
							String precio = resultSet.getString("precio");

							// Llena los campos de la interfaz gráfica con la información obtenida
							ventanaMaterial.textField_nombre.setText(nombreM);
							ventanaMaterial.textField_cantidad.setText(cantidad);
							ventanaMaterial.textField_precio.setText(precio);
						}

						// Cierra los recursos
						resultSet.close();
						statement.close();
						conector.cerrarConexion();

					} catch (SQLException ex) {
						ex.printStackTrace();
						// Manejo de errores
					}
				} else {
					// Se canceló el ingreso del documento o se dejó en blanco
				}
			}
		});

		// Funcionalidad componentes //
		// ---- Componentes ---- //
		// --------------------------------------------- //

		// Botón de Pacientes, que está en la barra lateral izquierda del JFrame.
		java.net.URL imgUrl1 = getClass().getResource("/pacientesIcono.png");
		Icon icon = new ImageIcon(imgUrl1);
		buttonPanel.setLayout(null);
		button1 = new JButton(icon);
		button1.setForeground(new Color(255, 255, 255));
		button1.setBounds(20, 10, 50, 58);
		button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		button1.setBackground(Color.WHITE);
		button1.setBorderPainted(false);
		buttonPanel.add(button1);

		// Cuando se le hace click al botón, se muestra la tabla, se cargan los datos de
		// la bbdd en la tabla, etc.
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Se oculta lo que estaba antes en el panel principal
					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					/*
					 * // Si la conexión a la base de datos es correcta, se cargan los datos de la
					 * // tabla paciente de la bbdd en nuestra tabla
					 */
					if (conector.conexion != null) {
						conector.cargarDatosPacientes(modeloTabla);
						tablasPanel.setVisible(true); // se muestra la tabla
						panelMenuDer3.setVisible(false);
						panelMenuDer4.setVisible(false);
						panelMenuDer2.setVisible(false);
						panelMenuDer.setVisible(true);

					} else {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al conectar con la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
			
		});

		java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
		Icon icon2 = new ImageIcon(imgUrl2);
		button2 = new JButton(icon2);
		button2.setBounds(20, 85, 50, 58);
		button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
		button2.setBackground(Color.WHITE);
		button2.setBorderPainted(false);
		buttonPanel.add(button2);

		// Botón de Doctores
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Se oculta lo que estaba antes en el "panel principal", por llamarlo así
					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);

					// Si la conexión a la base de datos es correcta, se cargan los datos de la
					// tabla paciente de la bbdd en nuestra tabla
					if (conector.conexion != null) {
						conector.cargarDatosDoctores(modeloTabla);
						tablasPanel.setVisible(true); // se muestra la tabla
						panelMenuDer.setVisible(false);
						panelMenuDer3.setVisible(false);
						panelMenuDer4.setVisible(false);
						panelMenuDer2.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al conectar con la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
		Icon icon3 = new ImageIcon(imgUrl3);
		button3 = new JButton(icon3);
		button3.setBounds(20, 159, 50, 58);
		button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
		button3.setBackground(Color.WHITE);
		button3.setBorderPainted(false);
		buttonPanel.add(button3);

		button3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {   

					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					if (conector.conexion != null) {
						conector.cargarDatosCitas(modeloTabla);
						tablasPanel.setVisible(true);
						panelMenuDer2.setVisible(false);
						panelMenuDer.setVisible(false);
						panelMenuDer4.setVisible(false);
						panelMenuDer3.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al conectar con la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
		Icon icon4 = new ImageIcon(imgUrl4);
		JButton button4 = new JButton(icon4);
		button4.setBounds(20, 228, 50, 58);
		button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
		button4.setBackground(Color.WHITE);
		button4.setBorderPainted(false);
		buttonPanel.add(button4);

		button4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					bienvenido.setVisible(false);
					texto1.setVisible(false);
					botonSalir.setVisible(false);
					if (conector.conexion != null) {
						conector.cargarDatosMaterial(modeloTabla);
						tablasPanel.setVisible(true);
						panelMenuDer3.setVisible(false);
						panelMenuDer2.setVisible(false);
						panelMenuDer.setVisible(false);
						panelMenuDer4.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al conectar con la base de datos",
								"Error", JOptionPane.ERROR_MESSAGE);
					}

				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaPrincipal.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
		Icon icon5 = new ImageIcon(imgUrl5);
		JButton button5 = new JButton(icon5);
		button5.setBounds(20, 296, 50, 58);
		button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
		button5.setBackground(Color.WHITE);
		button5.setBorderPainted(false);
		buttonPanel.add(button5);

		button5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
			}
		});

		java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
		Icon icon6 = new ImageIcon(imgUrl6);
		JButton button6 = new JButton(icon6);
		button6.setBounds(20, 373, 50, 58);
		button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
		button6.setBackground(Color.WHITE);
		button6.setBorderPainted(false);
		buttonPanel.add(button6);

		button6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
			}
		});

		java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
		Icon icon7 = new ImageIcon(imgUrl7);
		JButton button7 = new JButton(icon7);
		button7.setBounds(20, 441, 50, 58);
		button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
		button7.setBackground(Color.WHITE);
		button7.setBorderPainted(false);
		buttonPanel.add(button7);

		button7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
			}
		});

		java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
		Icon icon8 = new ImageIcon(imgUrl8);
		JButton button8 = new JButton(icon8);
		button8.setBounds(20, 509, 50, 58);
		button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
		button8.setBackground(Color.WHITE);
		button8.setBorderPainted(false);
		buttonPanel.add(button8);

		button8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
			}
		});

		// java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
		// Icon icon9 = new ImageIcon(imgUrl9);

		java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
		Icon icon10 = new ImageIcon(imgUrl10);

		JLabel labeltiPacientes = new JLabel("Pacientes");
		labeltiPacientes.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiPacientes.setBounds(20, 68, 50, 13);
		buttonPanel.add(labeltiPacientes);

		JLabel labeltiDoctores = new JLabel("Doctores");
		labeltiDoctores.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiDoctores.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiDoctores.setBounds(20, 145, 50, 13);
		buttonPanel.add(labeltiDoctores);

		JLabel labeltiCitas = new JLabel("Citas");
		labeltiCitas.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiCitas.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiCitas.setBounds(20, 216, 50, 13);
		buttonPanel.add(labeltiCitas);

		JLabel labeltiMaterial = new JLabel("Material");
		labeltiMaterial.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiMaterial.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiMaterial.setBounds(20, 284, 50, 13);
		buttonPanel.add(labeltiMaterial);

		JLabel labeltiFacturas = new JLabel("Facturas");
		labeltiFacturas.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiFacturas.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiFacturas.setBounds(20, 353, 50, 13);
		buttonPanel.add(labeltiFacturas);

		JLabel labeltiPedidos = new JLabel("Pedidos");
		labeltiPedidos.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiPedidos.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiPedidos.setBounds(20, 429, 50, 13);
		buttonPanel.add(labeltiPedidos);

		JLabel labeltiStock = new JLabel("Stock");
		labeltiStock.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiStock.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiStock.setBounds(20, 498, 50, 13);
		buttonPanel.add(labeltiStock);

		JLabel labeltiTratamientos = new JLabel("Tratamientos");
		labeltiTratamientos.setHorizontalAlignment(SwingConstants.CENTER);
		labeltiTratamientos.setFont(new Font("Montserrat", Font.PLAIN, 10));
		labeltiTratamientos.setBounds(10, 565, 68, 13);
		buttonPanel.add(labeltiTratamientos);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(32, 11, 2, 2);
		buttonPanel.add(scrollPane_1);

		bienvenido = new JLabel(
				"<html><font color='#008CCE'>¡Bienvenido</font> admin<font color='#008CCE'>!</font></html>");
		bienvenido.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
		bienvenido.setBounds(387, 210, 725, 62);
		contentPane.add(bienvenido);

		texto1 = new JLabel(
				"<html><div align='center'>Pulsa para salir <br>al inicio de la <br> aplicación</div></html>");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
		texto1.setBounds(499, 270, 421, 109);
		contentPane.add(texto1);

		java.net.URL imgUrl11 = getClass().getResource("/salir.png");
		Icon icon11 = new ImageIcon(imgUrl11);
		botonSalir = new JButton(icon11);
		botonSalir.setBounds(679, 370, 57, 55);
		botonSalir.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
		botonSalir.setBackground(Color.WHITE);
		contentPane.add(botonSalir);

		// JMENU BAR JITEM ETC

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Clases");
		mnNewMenu.add(mnNewMenu_1);

		JMenuItem mntmNewMenuItem = new JMenuItem("+Paciente");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnNewMenu_1.add(mntmNewMenuItem);

		ventanaPanel.setBackground(new Color(255, 255, 255));
		ventanaPanel.setBounds(99, -1, 1179, 691);
		contentPane.add(ventanaPanel);
		ventanaPanel.setLayout(null);
		ventanaPanel.setVisible(false);

		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
				tablasPanel.setVisible(false);
				ventanaPanel.add(ventanaPaciente);
				ventanaPanel.setVisible(true);
			}
		});

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("+Doctor");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mnNewMenu.add(mnNewMenu_1);

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaDoctor doctor = new VentanaDoctor();
				doctor.setVisible(true);

			}
		});
		
		JMenuItem botonMenuOdontograma = new JMenuItem("Odontograma");
		botonMenuOdontograma.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

		botonMenuOdontograma.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String numeroDocumento;

				do {
					
					numeroDocumento = JOptionPane.showInputDialog("Ingrese el número del documento:");

					if (numeroDocumento == null) {
						// El usuario hizo clic en "Cancelar"
						// Puedes decidir qué hacer en este caso (por ejemplo, no hacer nada o mostrar
						// un mensaje)
						return;
					} else if (numeroDocumento.isEmpty()) {
						// El campo está vacío, mostrar un mensaje indicando que debe ingresar el
						// documento
						JOptionPane.showMessageDialog(null, "Debe ingresar el número de documento.");
					} else if (!esNumeroDocumentoValido(numeroDocumento)) {
						// Mostrar un mensaje indicando que el número de documento no es válido
						JOptionPane.showMessageDialog(null,
								"Número de documento no válido. Por favor, inténtelo de nuevo.");
					}
				} while (numeroDocumento == null || numeroDocumento.isEmpty()
						|| !esNumeroDocumentoValido(numeroDocumento));
				
				// El número de documento es válido, mostrar la ventana
				VentanaOdontograma odontogramaV = new VentanaOdontograma();

				setVisible(false);
				odontogramaV.setVisible(true);
				odontogramaV.setLocationRelativeTo(null);
				odontogramaV.mostrar(numeroDocumento);

			}
		});

		mnNewMenu_1.add(botonMenuOdontograma);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ayuda");
		mntmNewMenuItem_2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu_1.add(mntmNewMenuItem_2);

		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Ayuda ventanaAyuda = new Ayuda();

				ventanaAyuda.setVisible(true);
				ventanaAyuda.setLocationRelativeTo(null);
				ventanaAyuda.setResizable(false);
				VentanaPrincipal.dispose();
			}
		});

		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bienvenido.setVisible(false);
				texto1.setVisible(false);
				botonSalir.setVisible(false);
				tablasPanel.setVisible(false);
				ventanaPanel.add(ventanaDoctor);
				ventanaPanel.setVisible(true);
			}
		});

		logoBlanco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				bienvenido.setVisible(true);
				texto1.setVisible(true);
				botonSalir.setVisible(true);
				ventanaPanel.setVisible(false);
				tablasPanel.setVisible(false);
			}
		});

		logoBlanco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		botonSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		// Acción botónSalir
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				VentanaInicial frame = new VentanaInicial();
				frame.setResizable(false);
				frame.setIconImage(
						Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});

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

	private boolean esNumeroDocumentoValido(String numeroDocumento) {
		// Verificar si el número de documento contiene solo números y letras
		if (!numeroDocumento.matches("^[a-zA-Z0-9]+$")) {
			// Si no cumple el formato, retorna falso
			return false;
		}

		// Utilizar la instancia existente de ConectorBBDD
		ConectorBBDD conexionBD = ConectorBBDD.getInstancia();
		Connection conexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		try {
			// Abrir la conexión
			conexion = conexionBD.obtenerConexion();

			// Consulta SQL para verificar la existencia del número de documento en la tabla
			// dentilax.paciente
			String consulta = "SELECT COUNT(*) FROM dentilax.paciente WHERE idPaciente = ?";
			statement = conexion.prepareStatement(consulta);
			statement.setString(1, numeroDocumento);

			// Ejecutar la consulta
			resultSet = statement.executeQuery();

			// Obtener el resultado de la consulta
			if (resultSet.next()) {
				int count = resultSet.getInt(1);
				return count > 0; // Si count > 0, el número de documento existe en la base de datos
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// Cerrar recursos
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// En caso de error o si no se encuentra el número de documento en la base de
		// datos
		return false;
	}

	// Getters y Setters

	// Getter para button1

	public JButton getButton1() {
		return button1;
	}
	public JButton getButton2() {
		return button2;
	}
	public JButton getButton3() {
		return button3;
	}

}