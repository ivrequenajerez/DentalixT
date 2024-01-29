package mainPack;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.ModeloDiente;
import database.ConectorBBDD;

import java.awt.Panel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

public class VentanaOdontograma extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// trackea el diente que ha sido pulsado
	private int nDientePulsado;
	protected List<JButton> listaBotonesDiente;
	protected List<ModeloDiente> listaDientes;
	public ConectorBBDD conexionBD;
	private static JFrame VentanaOdontograma;
	private JTextField textFieldDescrip;
	private JLabel lblNDiente;
	VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOdontograma = new VentanaOdontograma();
					VentanaOdontograma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaOdontograma() {
		listaBotonesDiente = new LinkedList<JButton>();
		listaDientes = new LinkedList<ModeloDiente>();
		setBounds(0, -1, 1179, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(103, -41, 947, 463);
		contentPane.add(panel);
		panel.setLayout(null);

		// Primer Diente
		java.net.URL imgUrl1 = getClass().getResource("/dient.png");
		ImageIcon icon1 = new ImageIcon(imgUrl1);
		JButton diente1 = new JButton(icon1);
		diente1.setBounds(54, 65, 119, 62);
		panel.add(diente1);
		listaBotonesDiente.add(diente1);

		// Segundo Diente
		java.net.URL imgUrl2 = getClass().getResource("/dient.png");
		ImageIcon icon2 = new ImageIcon(imgUrl2);
		JButton diente2 = new JButton(icon2);
		diente2.setBounds(226, 65, 119, 62);
		panel.add(diente2);
		listaBotonesDiente.add(diente2);

		// Tercer Diente
		java.net.URL imgUrl3 = getClass().getResource("/dient.png");
		ImageIcon icon3 = new ImageIcon(imgUrl3);
		JButton diente3 = new JButton(icon3);
		diente3.setBounds(399, 65, 119, 62);
		panel.add(diente3);
		listaBotonesDiente.add(diente3);

		// Cuarto Diente
		java.net.URL imgUrl4 = getClass().getResource("/dient.png");
		ImageIcon icon4 = new ImageIcon(imgUrl4);
		JButton diente4 = new JButton(icon4);
		diente4.setBounds(581, 65, 119, 62);
		panel.add(diente4);
		listaBotonesDiente.add(diente4);

		// Quinto Diente
		java.net.URL imgUrl5 = getClass().getResource("/dient.png");
		ImageIcon icon5 = new ImageIcon(imgUrl5);
		JButton diente5 = new JButton(icon5);
		diente5.setBounds(755, 65, 119, 62);
		panel.add(diente5);
		listaBotonesDiente.add(diente5);

		// Sexto Diente
		java.net.URL imgUrl6 = getClass().getResource("/dient.png");
		ImageIcon icon6 = new ImageIcon(imgUrl6);
		JButton diente6 = new JButton(icon6);
		diente6.setBounds(54, 220, 119, 62);
		panel.add(diente6);
		listaBotonesDiente.add(diente6);

		// Séptimo Diente
		java.net.URL imgUrl7 = getClass().getResource("/dient.png");
		ImageIcon icon7 = new ImageIcon(imgUrl7);
		JButton diente7 = new JButton(icon7);
		diente7.setBounds(226, 220, 119, 62);
		panel.add(diente7);
		listaBotonesDiente.add(diente7);

		// Octavo Diente
		java.net.URL imgUrl8 = getClass().getResource("/dient.png");
		ImageIcon icon8 = new ImageIcon(imgUrl8);
		JButton diente8 = new JButton(icon8);
		diente8.setBounds(399, 220, 119, 62);
		panel.add(diente8);
		listaBotonesDiente.add(diente8);

		// Noveno Diente
		java.net.URL imgUrl9 = getClass().getResource("/dient.png");
		ImageIcon icon9 = new ImageIcon(imgUrl9);
		JButton diente9 = new JButton(icon9);
		diente9.setBounds(581, 220, 119, 62);
		panel.add(diente9);
		listaBotonesDiente.add(diente9);

		// Décimo Diente
		java.net.URL imgUrl10 = getClass().getResource("/dient.png");
		ImageIcon icon10 = new ImageIcon(imgUrl10);
		JButton diente10 = new JButton(icon10);
		diente10.setBounds(755, 220, 119, 62);
		panel.add(diente10);
		listaBotonesDiente.add(diente10);

		// Undécimo Diente
		java.net.URL imgUrl11 = getClass().getResource("/dient.png");
		ImageIcon icon11 = new ImageIcon(imgUrl11);
		JButton diente11 = new JButton(icon11);
		diente11.setBounds(54, 368, 119, 62);
		panel.add(diente11);
		listaBotonesDiente.add(diente11);

		// Duodécimo Diente
		java.net.URL imgUrl12 = getClass().getResource("/dient.png");
		ImageIcon icon12 = new ImageIcon(imgUrl12);
		JButton diente12 = new JButton(icon12);
		diente12.setBounds(195, 368, 119, 62);
		panel.add(diente12);
		listaBotonesDiente.add(diente12);

		// Decimotercero Diente
		java.net.URL imgUrl13 = getClass().getResource("/dient.png");
		ImageIcon icon13 = new ImageIcon(imgUrl13);
		JButton diente13 = new JButton(icon13);
		diente13.setBounds(360, 368, 119, 62);
		panel.add(diente13);
		listaBotonesDiente.add(diente13);

		// Decimocuarto Diente
		java.net.URL imgUrl14 = getClass().getResource("/dient.png");
		ImageIcon icon14 = new ImageIcon(imgUrl14);
		JButton diente14 = new JButton(icon14);
		diente14.setBounds(514, 368, 119, 62);
		panel.add(diente14);
		listaBotonesDiente.add(diente14);

		// Decimoquinto Diente
		java.net.URL imgUrl15 = getClass().getResource("/dient.png");
		ImageIcon icon15 = new ImageIcon(imgUrl15);
		JButton diente15 = new JButton(icon15);
		diente15.setBounds(661, 368, 119, 62);
		panel.add(diente15);
		listaBotonesDiente.add(diente15);

		// DECIMOSEXTO DIENTE

		java.net.URL imgUrl16 = getClass().getResource("/dient.png");
		ImageIcon icon16 = new ImageIcon(imgUrl16);
		JButton diente15_1 = new JButton(icon16);
		listaBotonesDiente.add(diente15_1);

		diente15_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		diente15_1.setBounds(803, 368, 119, 62);
		panel.add(diente15_1);

		JLabel lblNewLabel = new JLabel("1");
		lblNewLabel.setBounds(103, 126, 46, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("2");
		lblNewLabel_1.setBounds(281, 126, 30, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("3");
		lblNewLabel_2.setBounds(450, 126, 46, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("4");
		lblNewLabel_3.setBounds(635, 126, 46, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setBounds(809, 126, 46, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("6");
		lblNewLabel_5.setBounds(103, 280, 46, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("7");
		lblNewLabel_6.setBounds(281, 280, 46, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("8");
		lblNewLabel_7.setBounds(450, 280, 46, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("9");
		lblNewLabel_8.setBounds(635, 280, 46, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("10");
		lblNewLabel_9.setBounds(809, 280, 46, 14);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("11");
		lblNewLabel_10.setBounds(103, 430, 46, 14);
		panel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("12");
		lblNewLabel_11.setBounds(250, 430, 46, 14);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("13");
		lblNewLabel_12.setBounds(414, 430, 46, 14);
		panel.add(lblNewLabel_12);

		JLabel lblNewLabel_13 = new JLabel("14");
		lblNewLabel_13.setBounds(570, 430, 46, 14);
		panel.add(lblNewLabel_13);

		JLabel lblNewLabel_14 = new JLabel("15");
		lblNewLabel_14.setBounds(714, 430, 46, 14);
		panel.add(lblNewLabel_14);

		JLabel lblNewLabel_15 = new JLabel("16");
		lblNewLabel_15.setBounds(860, 430, 46, 14);
		panel.add(lblNewLabel_15);

		conexionBD = new ConectorBBDD();

		// BOTON GUARDAR
		java.net.URL imgUrl17 = getClass().getResource("/save.png");
		ImageIcon icon17 = new ImageIcon(imgUrl17);
		JButton btGuardar = new JButton(icon17);
		btGuardar.setContentAreaFilled(false);

		btGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        // Buscar el diente pulsado
		        for (ModeloDiente diente : listaDientes) {
		            if (diente.getnDiente() == nDientePulsado) {
		                // Actualizar la descripción del diente con el valor del textFieldDescrip
		                diente.setDescripcion(textFieldDescrip.getText());

		                // Actualizar la descripción en la base de datos
		                conexionBD.actualizarDescripcion(diente.getIdDiente(), textFieldDescrip.getText());

		                break; // Terminar el bucle una vez que se encuentra y actualiza el diente.
		            }
		        }
		    }
		});

		btGuardar.setBounds(323, 560, 121, 66);
		contentPane.add(btGuardar);

		// BOTON ELIMINAR
		java.net.URL imgUrl18 = getClass().getResource("/eliminar.png");
		ImageIcon icon18 = new ImageIcon(imgUrl18);

		JButton btEliminar = new JButton(icon18);
		btEliminar.setContentAreaFilled(false);
		btEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// buscar el diente pulsado
				for (ModeloDiente diente : listaDientes) {

					if (diente.getnDiente() == nDientePulsado) {
						diente.setDescripcion("");
						textFieldDescrip.setText("");
						JOptionPane.showMessageDialog(null, "Descripción borrada. Haga click en ✔️ para guardar los datos.");
					}
				}

			}
		});
		
		btEliminar.setBounds(502, 560, 121, 66);
		contentPane.add(btEliminar);

		// BOTON VOLVER
		java.net.URL imgUrl19 = getClass().getResource("/volverIcono.png");
		ImageIcon icon19 = new ImageIcon(imgUrl19);

		JButton btVolver = new JButton(icon19);
		btVolver.setContentAreaFilled(false);

		btVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				ventanaPrincipal.setVisible(true);
				ventanaPrincipal.setLocationRelativeTo(null);

			}
		});

		btVolver.setBounds(667, 560, 121, 66);
		contentPane.add(btVolver);
		
		textFieldDescrip = new JTextField();
		textFieldDescrip.setFont(new Font("Montserrat", Font.PLAIN, 12));
		textFieldDescrip.setBounds(302, 483, 300, 67);
		contentPane.add(textFieldDescrip);
		textFieldDescrip.setColumns(10);
		
		JLabel lblNewLabel_16 = new JLabel("Número:");
		lblNewLabel_16.setFont(new Font("Montserrat", Font.BOLD, 20));
		lblNewLabel_16.setBounds(152, 442, 121, 16);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("Descripción:");
		lblNewLabel_17.setFont(new Font("Montserrat", Font.BOLD, 20));
		lblNewLabel_17.setBounds(152, 483, 133, 19);
		contentPane.add(lblNewLabel_17);
		
		lblNDiente = new JLabel("New label");
		lblNDiente.setFont(new Font("Montserrat", Font.PLAIN, 12));
		lblNDiente.setBounds(305, 447, 77, 13);
		contentPane.add(lblNDiente);

	}

	public void mostrar(String numeroDocumento) {
	    ConectorBBDD conexionBD = new ConectorBBDD();

	    try {
	        // Abrir la conexión
	        conexionBD.conectarConBBDD();

	        listaDientes = conexionBD.cargarOdontogramaPorDocumento(Integer.parseInt(numeroDocumento));

	        // recorro los dientes para asignarle el boton que le corresponde
	        for (ModeloDiente diente : listaDientes) {

	            // jbutton del diente correspondiente
	            JButton dienteAux = listaBotonesDiente.get(diente.getnDiente() - 1);

	            dienteAux.addActionListener(new ActionListener() {
	                public void actionPerformed(ActionEvent e) {
	                	lblNDiente.setText(String.valueOf(diente.getnDiente()));
	                    // Mostrar la descripción del diente en textFieldDescrip
	                    textFieldDescrip.setText(diente.getDescripcion());

	                    nDientePulsado = diente.getnDiente();
	                }
	            });

	            if (!diente.getDescripcion().isEmpty()) {
	                java.net.URL imgUrlIconoNuevo = getClass().getResource("/dienteRojo.png");
	                ImageIcon iconoNuevo = new ImageIcon(imgUrlIconoNuevo);
	                dienteAux.setIcon(iconoNuevo);
	                dienteAux.repaint();
	            }

	            diente.setBotonDiente(dienteAux);
	        }
	    } finally {
	        // Cerrar la conexión en la cláusula finally
	        conexionBD.cerrarConexion();
	    }
	}

}
