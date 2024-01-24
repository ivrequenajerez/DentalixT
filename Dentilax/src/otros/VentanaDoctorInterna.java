package otros;
import mainPack.*;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

import database.ConectorBBDD;

import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class VentanaDoctorInterna extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel bienvenido;
	private JLabel texto1;
	private JButton playBoton;
	private ConectorBBDD conector = new ConectorBBDD();
	private JTextField textField;

	/**
	 * Autores: David Andrade Pablo Rodriguez Ian Requena 2023
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaDoctorInterna frame = new VentanaDoctorInterna();

					frame.setIconImage(Toolkit.getDefaultToolkit()
							.getImage(mainPack.pantallaInicial.class.getResource("/logoDentilax.png")));
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public VentanaDoctorInterna() {

		// asdasd

		super("Dentilax");
		VentanaDoctorInterna.this.setLocationRelativeTo(null);
		setResizable(false);
		// Icono
		ImageIcon icono1 = new ImageIcon("/logoDentilax.png");
		VentanaDoctorInterna.this.setIconImage(icono1.getImage());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1292, 728);

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
		buttonPanel.setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane(buttonPanel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBackground(Color.decode("#008cce"));

		scrollPane.setBounds(0, 101, 100, 590);

		contentPane.add(scrollPane);

		// Tablas
		DefaultTableModel modeloTabla = new DefaultTableModel();
		mainPack.Tabla table = new mainPack.Tabla(modeloTabla);

		JPanel tablasPanel = new JPanel();
		tablasPanel.setBackground(new Color(255, 255, 255));
		tablasPanel.setBounds(99, -1, 1179, 691);
		contentPane.add(tablasPanel);
		tablasPanel.setLayout(null);
		tablasPanel.setVisible(false);

		tablasPanel.add(table);

		JScrollPane scrollPaneT = new JScrollPane(table);
		scrollPaneT.setBounds(-2, 0, 1180, 691);
		tablasPanel.add(scrollPaneT);
		scrollPaneT.setBackground(new Color(255, 255, 255));

		JLabel lblNewLabel = new JLabel("Nuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuuu");
		scrollPaneT.setColumnHeaderView(lblNewLabel);

		textField = new JTextField();
		scrollPaneT.setColumnHeaderView(textField);
		textField.setColumns(10);

		java.net.URL imgUrl1 = getClass().getResource("/pacientesIcono.png");
		Icon icon = new ImageIcon(imgUrl1);
		buttonPanel.setLayout(null);
		JButton button1 = new JButton(icon);
		button1.setBounds(0, 0, 0, 0);
		button1.setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
		button1.setBackground(Color.WHITE);

		buttonPanel.add(button1);

		// Acción del botón
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					bienvenido.setVisible(false);
					texto1.setVisible(false);
					playBoton.setVisible(false);

					if (conector.conexion != null) {
						conector.cargarDatosPacientes(modeloTabla);
						tablasPanel.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(VentanaDoctorInterna.this,
								"Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					JOptionPane.showMessageDialog(VentanaDoctorInterna.this, "Error al cargar los datos de pacientes",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JPanel buttonPanel1 = new JPanel();
		scrollPane.setViewportView(buttonPanel1);
		buttonPanel1.setBackground(Color.decode("#008cce"));

		JPanel panel = new JPanel(); // PANEL DONDE ESTAN LOS LABELS

		// BOTONES

		// Botón 1
		java.net.URL imgUrl = getClass().getResource("/pacientesIcono.png");
		Icon icon1 = new ImageIcon(imgUrl);
		buttonPanel1.setLayout(null);
		JButton button11 = new JButton(icon1);
		button11.setBounds(0, 18, 98, 40);
		button11.setPreferredSize(new Dimension(icon1.getIconWidth(), icon1.getIconHeight()));
		button11.setBackground(Color.WHITE);
		buttonPanel1.add(button11);
		button11.setContentAreaFilled(false);

		// Botón 2
		java.net.URL imgUrl2 = getClass().getResource("/doctoresIcono.png");
		Icon icon2 = new ImageIcon(imgUrl2);
		JButton button2 = new JButton(icon2);
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoctorConsultar doctorConsultar = new DoctorConsultar();
				doctorConsultar.setVisible(true);
			}
		});
		button2.setBounds(0, 77, 98, 40);
		button2.setPreferredSize(new Dimension(icon2.getIconWidth(), icon2.getIconHeight()));
		button2.setBackground(Color.WHITE);
		buttonPanel1.add(button2);
		button2.setContentAreaFilled(false);

		// Botón 3
		java.net.URL imgUrl3 = getClass().getResource("/consultasIcono.png");
		Icon icon3 = new ImageIcon(imgUrl3);
		JButton button3 = new JButton(icon3);
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCitaCRUD ventanaCitaCRUD = new VentanaCitaCRUD();
				ventanaCitaCRUD.setVisible(true);
			}
		});
		button3.setBounds(0, 135, 98, 40);
		button3.setPreferredSize(new Dimension(icon3.getIconWidth(), icon3.getIconHeight()));
		button3.setBackground(Color.WHITE);
		buttonPanel1.add(button3);
		button3.setContentAreaFilled(false);

		// Botón 4
		java.net.URL imgUrl4 = getClass().getResource("/materialIcono.png");
		Icon icon4 = new ImageIcon(imgUrl4);
		JButton button4 = new JButton(icon4);
		button4.setBounds(0, 191, 98, 40);
		button4.setPreferredSize(new Dimension(icon4.getIconWidth(), icon4.getIconHeight()));
		button4.setBackground(Color.WHITE);
		buttonPanel1.add(button4);
		button4.setContentAreaFilled(false);

		// Botón 5
		java.net.URL imgUrl5 = getClass().getResource("/facturacionIcono.png");
		Icon icon5 = new ImageIcon(imgUrl5);
		JButton button5 = new JButton(icon5);
		button5.setBounds(0, 249, 98, 40);
		button5.setPreferredSize(new Dimension(icon5.getIconWidth(), icon5.getIconHeight()));
		button5.setBackground(Color.WHITE);
		buttonPanel1.add(button5);
		button5.setContentAreaFilled(false);

		// Botón 6
		java.net.URL imgUrl6 = getClass().getResource("/pedidosIcono.png");
		Icon icon6 = new ImageIcon(imgUrl6);
		JButton button6 = new JButton(icon6);
		button6.setBounds(-3, 308, 98, 40);
		button6.setPreferredSize(new Dimension(icon6.getIconWidth(), icon6.getIconHeight()));
		button6.setBackground(Color.WHITE);
		buttonPanel1.add(button6);
		button6.setContentAreaFilled(false);

		// Botón 7
		java.net.URL imgUrl7 = getClass().getResource("/proveedoresIcono.png");
		Icon icon7 = new ImageIcon(imgUrl7);
		JButton button7 = new JButton(icon7);
		button7.setBounds(2, 365, 98, 40);
		button7.setPreferredSize(new Dimension(icon7.getIconWidth(), icon7.getIconHeight()));
		button7.setBackground(Color.WHITE);
		buttonPanel1.add(button7);
		button7.setContentAreaFilled(false);

		// Botón 8
		java.net.URL imgUrl8 = getClass().getResource("/tratamientosIcono.png");
		Icon icon8 = new ImageIcon(imgUrl8);
		JButton button8 = new JButton(icon8);
		button8.setBounds(3, 426, 98, 40);
		button8.setPreferredSize(new Dimension(icon8.getIconWidth(), icon8.getIconHeight()));
		button8.setBackground(Color.WHITE);
		buttonPanel1.add(button8);
		button8.setContentAreaFilled(false);

		// Botón 9
		java.net.URL imgUrl9 = getClass().getResource("/especialistasIcono.png");
		Icon icon9 = new ImageIcon(imgUrl9);
		JButton button9 = new JButton(icon9);
		button9.setBounds(0, 487, 98, 40);
		button9.setPreferredSize(new Dimension(icon9.getIconWidth(), icon9.getIconHeight()));
		button9.setBackground(Color.WHITE);
		buttonPanel1.add(button9);
		button9.setContentAreaFilled(false);

		// Botón 10
		java.net.URL imgUrl10 = getClass().getResource("/usuariosIcono.png");
		Icon icon10 = new ImageIcon(imgUrl10);
		JButton button10 = new JButton(icon10);
		button10.setContentAreaFilled(false);
		button10.setBounds(0, 540, 98, 40);
		button10.setPreferredSize(new Dimension(icon10.getIconWidth(), icon10.getIconHeight()));
		button10.setBackground(Color.WHITE);
		buttonPanel1.add(button10);

		// LABELS DE LOS BOTONES MENÚ

		JLabel lblNewLabel1 = new JLabel("PACIENTE");
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel1.setBounds(26, 0, 62, 14);
		buttonPanel1.add(lblNewLabel1);

		JLabel lblDoctor = new JLabel("DOCTOR");
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDoctor.setBounds(26, 59, 62, 20);
		buttonPanel1.add(lblDoctor);

		JLabel lblCita = new JLabel("CITA");
		lblCita.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCita.setBounds(34, 121, 27, 14);
		buttonPanel1.add(lblCita);

		JLabel lblFactura = new JLabel("FACTURA");
		lblFactura.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblFactura.setBounds(24, 235, 54, 14);
		buttonPanel1.add(lblFactura);

		JLabel lblSrock = new JLabel("STOCK");
		lblSrock.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSrock.setBounds(28, 350, 47, 14);
		buttonPanel1.add(lblSrock);

		JLabel lblTratamiento = new JLabel("TRATAMIENTO");
		lblTratamiento.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTratamiento.setBounds(10, 472, 88, 14);
		buttonPanel1.add(lblTratamiento);

		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setBounds(28, 292, 47, 14);
		buttonPanel1.add(lblPedido);
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 11));

		JLabel lblUsuarios = new JLabel("USUARIOS");
		lblUsuarios.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuarios.setBounds(23, 528, 88, 14);
		buttonPanel1.add(lblUsuarios);

		JLabel lblMaterial = new JLabel("MATERIAL");
		lblMaterial.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMaterial.setBounds(23, 176, 88, 14);
		buttonPanel1.add(lblMaterial);

		JLabel lblEspecialidad = new JLabel("ESPECIALIDAD");
		lblEspecialidad.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEspecialidad.setBounds(10, 409, 88, 14);
		buttonPanel1.add(lblEspecialidad);

		// JMENU BAR JITEM ETC

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Menú");
		menuBar.add(mnNewMenu);

		JMenu mnNewMenu_1 = new JMenu("Clases");
		mnNewMenu.add(mnNewMenu_1);

		// ME REDIRIGE A CLASE PACIENTE

		JMenuItem mntmNewMenuItem = new JMenuItem("Paciente");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0));
		mnNewMenu_1.add(mntmNewMenuItem);

		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la ventana del paciente y mostrarla
				PacienteCRUD ventanaPaciente = new PacienteCRUD();
				ventanaPaciente.setVisible(true);

			}
		});

		// ME REDIRIGE A CLASE DOCTOR

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Doctor");
		mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnNewMenu_1.add(mntmNewMenuItem_1);
		mnNewMenu.add(mnNewMenu_1);
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Crear una instancia de la ventana del paciente y mostrarla
				DoctorConsultar doctorConsultar = new DoctorConsultar();
				doctorConsultar.setVisible(true);

			}
		});

	}
}