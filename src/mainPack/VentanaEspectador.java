package mainPack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaEspectador extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel bienvenido;
	private JLabel texto1;
	private JButton playBoton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setIconImage(Toolkit.getDefaultToolkit()
							.getImage(pantallaInicial.class.getResource("/logoDentilax.png")));

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

	public VentanaEspectador() {

		// Dimensiones
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		// Estilos del JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Código de Ventana Principal...

		// Logo Fondo azul
		JLabel logoBlanco = new JLabel("");
		logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(logoBlanco);

		ImageIcon imagen = new ImageIcon(getClass().getResource("/logoAzul.png"));
		int ancho = imagen.getIconWidth();
		int alto = imagen.getIconHeight();
		logoBlanco.setBounds(0, 0, ancho, alto);

		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		logoBlanco.setIcon(icono);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 101, 100, 590);
		contentPane.add(scrollPane);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(10, 1));
		scrollPane.setViewportView(buttonPanel);

		buttonPanel.setBackground(Color.decode("#008cce"));
		// Botón 1
		java.net.URL imgUrl = getClass().getResource("/pacientesIcono.png");
		Icon icon = new ImageIcon(imgUrl);
		buttonPanel.setLayout(null);
		JButton button1 = new JButton(icon);
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPaciente pacienteCRUD = new VentanaPaciente();
				pacienteCRUD.setVisible(true);

			}
		});
		button1.setBounds(0, 18, 98, 40);
		button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		button1.setBackground(Color.WHITE);
		buttonPanel.add(button1);
		button1.setContentAreaFilled(false);

		// Botón 2
		java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
		Icon icon2 = new ImageIcon(imgUrl2);
		JButton button2 = new JButton(icon2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor doctorConsultar = new Doctor();
				doctorConsultar.setVisible(true);
			}
		});
		button2.setBounds(0, 77, 98, 40);
		button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
		button2.setBackground(Color.WHITE);
		buttonPanel.add(button2);
		button2.setContentAreaFilled(false);

		// Botón 3
		java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
		Icon icon3 = new ImageIcon(imgUrl3);
		JButton button3 = new JButton(icon3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCitas ventanaCitaCRUD = new VentanaCitas();
				ventanaCitaCRUD.setVisible(true);
			}
		});
		button3.setBounds(0, 135, 98, 40);
		button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
		button3.setBackground(Color.WHITE);
		buttonPanel.add(button3);
		button3.setContentAreaFilled(false);

		// Botón 4
		java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
		Icon icon4 = new ImageIcon(imgUrl4);
		JButton button4 = new JButton(icon4);
		button4.setBounds(0, 191, 98, 40);
		button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
		button4.setBackground(Color.WHITE);
		buttonPanel.add(button4);
		button4.setContentAreaFilled(false);

		// Botón 5
		java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
		Icon icon5 = new ImageIcon(imgUrl5);
		JButton button5 = new JButton(icon5);
		button5.setBounds(0, 249, 98, 40);
		button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
		button5.setBackground(Color.WHITE);
		buttonPanel.add(button5);
		button5.setContentAreaFilled(false);

		// Botón 6
		java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
		Icon icon6 = new ImageIcon(imgUrl6);
		JButton button6 = new JButton(icon6);
		button6.setBounds(-3, 308, 98, 40);
		button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
		button6.setBackground(Color.WHITE);
		buttonPanel.add(button6);
		button6.setContentAreaFilled(false);

		// Botón 7
		java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
		Icon icon7 = new ImageIcon(imgUrl7);
		JButton button7 = new JButton(icon7);
		button7.setBounds(2, 365, 98, 40);
		button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
		button7.setBackground(Color.WHITE);
		buttonPanel.add(button7);
		button7.setContentAreaFilled(false);

		// Botón 8
		java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
		Icon icon8 = new ImageIcon(imgUrl8);
		JButton button8 = new JButton(icon8);
		button8.setBounds(3, 426, 98, 40);
		button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
		button8.setBackground(Color.WHITE);
		buttonPanel.add(button8);
		button8.setContentAreaFilled(false);

		// Botón 9
		java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
		Icon icon9 = new ImageIcon(imgUrl9);
		JButton button9 = new JButton(icon9);
		button9.setBounds(0, 487, 98, 40);
		button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
		button9.setBackground(Color.WHITE);
		buttonPanel.add(button9);
		button9.setContentAreaFilled(false);

		// Botón 10
		java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
		Icon icon10 = new ImageIcon(imgUrl10);
		JButton button10 = new JButton(icon10);
		button10.setContentAreaFilled(false);
		button10.setBounds(0, 540, 98, 40);
		button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
		button10.setBackground(Color.WHITE);
		buttonPanel.add(button10);

		// LABELS DE LOS BOTONES MENÚ

		JLabel lblNewLabel = new JLabel("PACIENTE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(26, 0, 62, 14);
		buttonPanel.add(lblNewLabel);

		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoctor.setBounds(26, 59, 62, 20);
		buttonPanel.add(lblDoctor);

		JLabel lblCita = new JLabel("CITA");
		lblCita.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCita.setBounds(34, 121, 27, 14);
		buttonPanel.add(lblCita);

		JLabel lblFactura = new JLabel("FACTURA");
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFactura.setBounds(24, 235, 54, 14);
		buttonPanel.add(lblFactura);

		JLabel lblSrock = new JLabel("STOCK");
		lblSrock.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSrock.setBounds(28, 350, 47, 14);
		buttonPanel.add(lblSrock);

		JLabel lblTratamiento = new JLabel("TRATAMIENTO");
		lblTratamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTratamiento.setBounds(10, 472, 88, 14);
		buttonPanel.add(lblTratamiento);

		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setBounds(28, 292, 47, 14);
		buttonPanel.add(lblPedido);
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblUsuarios = new JLabel("USUARIOS");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarios.setBounds(23, 528, 88, 14);
		buttonPanel.add(lblUsuarios);

		JLabel lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaterial.setBounds(23, 176, 88, 14);
		buttonPanel.add(lblMaterial);

		JLabel lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspecialidad.setBounds(10, 409, 88, 14);
		buttonPanel.add(lblEspecialidad);
		// Texto de ventana principal
		bienvenido = new JLabel(
				"<html><font color='#008CCE'>¡Bienvenido</font> doctor<font color='#008CCE'>!</font></html>");
		bienvenido.setFont(new Font("Montserrat Medium", Font.BOLD, 60));
		bienvenido.setBounds(387, 210, 725, 62);
		contentPane.add(bienvenido);

		texto1 = new JLabel("<html><div align='center'>No puedes<br>editar nada<br> solo observar :)</div></html>");
		texto1.setHorizontalAlignment(SwingConstants.CENTER);
		texto1.setFont(new Font("Montserrat Medium", Font.PLAIN, 20));
		texto1.setBounds(499, 282, 421, 109);
		contentPane.add(texto1);

		// Boton de play
		java.net.URL imgUrl11 = getClass().getResource("/play.png");
		Icon icon11 = new ImageIcon(imgUrl11);
		playBoton = new JButton(icon11);
		playBoton.setBounds(679, 400, 57, 55);
		playBoton.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
		playBoton.setBackground(Color.WHITE);
		contentPane.add(playBoton);

		playBoton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});

		playBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String videoPath = "C:\\Users\\ianre\\git\\DentalixTeam\\recursos\\tutorial1.mkv";

				try {
					Desktop.getDesktop().open(new File(videoPath));
				} catch (IOException ex) {
					ex.printStackTrace();
				}
			}

		});

		// Zona de tablas
		JPanel tablasPanel = new JPanel();
		tablasPanel.setBackground(new Color(255, 255, 255));
		tablasPanel.setBounds(99, 0, 1167, 691);
		contentPane.add(tablasPanel);

		// Unicamente espectador

	}

	private void cargarDatosPacientes() {
		try {
			// Conexión a la base de datos
			String url = "jdbc:mysql://localhost:3306/dentilax?useSSL=false";
			String usuario = "root";
			String contrasenia = "1234";
			Connection conexion = DriverManager.getConnection(url, usuario, contrasenia);

			String consulta = "SELECT * FROM sys.paciente";
			Statement statement = conexion.createStatement();
			ResultSet resultado = statement.executeQuery(consulta);

			DefaultTableModel modeloTabla = new DefaultTableModel();

			modeloTabla.addColumn("ID/Documento");
			modeloTabla.addColumn("Nombre");
			modeloTabla.addColumn("Apellidos");
			modeloTabla.addColumn("Dirección");
			modeloTabla.addColumn("Teléfono");

			while (resultado.next()) {

				Object[] fila = {

						resultado.getInt("idPaciente"), resultado.getString("nombre"), resultado.getString("apellidos"),
						resultado.getString("dirección"), resultado.getInt("teléfono") };
				modeloTabla.addRow(fila);

			}

			conexion.close();

			JTable tablaPacientes = new JTable(modeloTabla);

			JPanel panel = new JPanel(new BorderLayout());
			panel.add(new JScrollPane(tablaPacientes), BorderLayout.CENTER);

			JOptionPane.showMessageDialog(this, panel, "Tabla de Pacientes", JOptionPane.INFORMATION_MESSAGE);

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error al cargar los datos de pacientes", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
