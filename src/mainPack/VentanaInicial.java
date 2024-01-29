package mainPack;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.prefs.Preferences;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.Timer;

import database.ConectorBBDD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VentanaInicial extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel logoInicio;
	private JLabel logoLogin;
	private ConectorBBDD conector = new ConectorBBDD();
	private static Timer timer;
	private JCheckBox recordarCheckBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				VentanaInicial frame = new VentanaInicial();
				frame.setResizable(false);
				frame.setIconImage(
						Toolkit.getDefaultToolkit().getImage(VentanaInicial.class.getResource("/logoAzul.png")));
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			} catch (Exception e) {
				e.printStackTrace();
			}
		});

	}

	public VentanaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Font montserratFont = new Font("Montserrat", Font.PLAIN, 20);
		contentPane.setFont(montserratFont);

		logoInicio = new JLabel("");
		logoInicio.setHorizontalAlignment(JLabel.CENTER);
		logoInicio.setBounds(370, 100, 500, 500);

		ImageIcon imagen = new ImageIcon(getClass().getResource("/logoDentilax.png"));
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logoInicio.getWidth(), logoInicio.getHeight(),
				Image.SCALE_DEFAULT));
		logoInicio.setIcon(icono);

		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));

				logoInicio.setVisible(false);
				contentPane.remove(logoInicio);
				contentPane.repaint();

				logoLogin = new JLabel("");
				logoLogin.setHorizontalAlignment(JLabel.CENTER);
				logoLogin.setBounds(222, 100, 500, 500);

				ImageIcon imagen = new ImageIcon(getClass().getResource("/logoDentilax.png"));

				Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(logoLogin.getWidth(),
						logoLogin.getHeight(), Image.SCALE_DEFAULT));

				logoLogin.setIcon(icono);

				logoLogin.setBounds(222, 100, 500, 500);
				contentPane.add(logoLogin);
				timer.stop();

				// Campos de texto del formulario
				JTextField usuarioTextField = new JTextField();
				JPasswordField contraseniaTextField = new JPasswordField();

				usuarioTextField.setBounds(770, 250, 200, 30);
				contentPane.add(usuarioTextField);
				contraseniaTextField.setBounds(770, 300, 200, 30);
				contentPane.add(contraseniaTextField);

				// Hints de Botones
				@SuppressWarnings("unused")
				TextPrompt usuario = new TextPrompt("Usuario", usuarioTextField);
				@SuppressWarnings("unused")
				TextPrompt contrasenia = new TextPrompt("Contraseña", contraseniaTextField);

				// Botón para mostrar u ocultar contraseña
				JToggleButton toggleButton = new JToggleButton();
				toggleButton.setIcon(new ImageIcon(getClass().getResource("/mostrar.png")));
				toggleButton.setSelectedIcon(new ImageIcon(getClass().getResource("/ocultar.png")));
				toggleButton.setBounds(975, 300, 30, 30);

				toggleButton.setContentAreaFilled(false);
				toggleButton.setBorderPainted(false);
				toggleButton.setFocusPainted(false);

				// CHECKBOX
				recordarCheckBox = new JCheckBox("Recordar usuario y  contraseña", true);
				recordarCheckBox.setBounds(970, 350, 200, 30);
				recordarCheckBox.setOpaque(false);
				contentPane.add(recordarCheckBox);

				// Cargar preferencias al iniciar
				cargarPreferencias(usuarioTextField, contraseniaTextField);

				// Cambia el cursor al hacer hover sobre el botón
				toggleButton.addMouseListener((MouseListener) new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					@Override
					public void mouseExited(MouseEvent e) {
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});

				contentPane.add(toggleButton);

				toggleButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (toggleButton.isSelected()) {
							contraseniaTextField.setEchoChar((char) 0);
						} else {
							contraseniaTextField.setEchoChar('\u2022');
						}
					}
				});

				JButton loginBoton = new JButton("Login");

				loginBoton.setBounds(770, 350, 200, 40);
				loginBoton.setBackground(new Color(0, 140, 206));
				loginBoton.setForeground(Color.WHITE);
				contentPane.add(loginBoton);

				loginBoton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String usuario = usuarioTextField.getText();
						char[] contrasenia = contraseniaTextField.getPassword();

						if (usuario.isEmpty()) {
							usuarioTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
						} else {
							usuarioTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						}

						if (contrasenia.length == 0) {
							contraseniaTextField.setBorder(BorderFactory.createLineBorder(Color.RED));
						} else {
							contraseniaTextField.setBorder(BorderFactory.createLineBorder(Color.GRAY));
						}

						conector = ConectorBBDD.getInstancia();

						try {
							conector.conectarConBBDD();
							if (conector.conexion != null) {
								boolean credencialesValidas = conector.verificarCredencialesEnBaseDeDatos(usuario,
										new String(contrasenia));

								if (credencialesValidas) {
									setVisible(false);

									// Guardar o eliminar preferencias según el estado del checkbox
									if (recordarCheckBox.isSelected()) {
										recordarContrasenia(usuario, new String(contrasenia));
									} else {
										eliminarPreferencias();
									}
								}
							}
						} catch (Exception ex) {
							String mensajeError = "Error al conectar: " + ex.getMessage();
				            JOptionPane.showMessageDialog(contentPane, mensajeError, "Error de Conexión", JOptionPane.ERROR_MESSAGE);
				            ex.printStackTrace();
						} finally {
							conector.cerrarConexion();
						}
					}
				});

				usuarioTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							loginBoton.doClick();
						}
					}
				});

				contraseniaTextField.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							loginBoton.doClick();
						}
					}
				});

				contentPane.repaint();

				loginBoton.addMouseListener(new java.awt.event.MouseAdapter() {
					public void mouseEntered(java.awt.event.MouseEvent evt) {
						setCursor(new Cursor(Cursor.HAND_CURSOR));
					}

					public void mouseExited(java.awt.event.MouseEvent evt) {
						setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
					}
				});
			}
		});

		timer.start();
		contentPane.add(logoInicio);
	}

	private void recordarContrasenia(String usuario, String contrasenia) {
		// Utilizamos las preferencias del sistema para almacenar la contraseña
		Preferences prefs = Preferences.userNodeForPackage(VentanaInicial.class);
		prefs.put("usuario", usuario);
		prefs.put("contrasenia", contrasenia);
	}

	private void cargarPreferencias(JTextField usuarioTextField, JPasswordField contraseniaTextField) {
		// Cargamos las preferencias al iniciar la aplicación
		Preferences prefs = Preferences.userNodeForPackage(VentanaInicial.class);
		String usuario = prefs.get("usuario", "");
		String contrasenia = prefs.get("contrasenia", "");

		if (!usuario.isEmpty() && !contrasenia.isEmpty()) {
			// Si hay información almacenada, llenamos los campos
			usuarioTextField.setText(usuario);
			contraseniaTextField.setText(contrasenia);
		}
	}

	private void eliminarPreferencias() {
		// Elimina las preferencias almacenadas
		Preferences prefs = Preferences.userNodeForPackage(VentanaInicial.class);
		prefs.remove("usuario");
		prefs.remove("contrasenia");
	}
}
