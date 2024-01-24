package otros;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Image;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;
import java.awt.event.InputEvent;

public class VentanaCitaCRUD extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private static final Font fuenteLabel = new Font("Montserrat", Font.PLAIN, 20);
	private static final Font fuenteGrande = new Font("Montserrat", Font.PLAIN, 50);
	int yPosition = -40;
	int separacionVertical = 95;
	  int contadorClics;

	private JTextField textField_salario;
	ImageIcon icono = new ImageIcon("images/nombre_de_tu_imagen.png");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					VentanaCitaCRUD frame = new VentanaCitaCRUD();
					
					frame.setVisible(true);
					frame.setResizable(false);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */

	public VentanaCitaCRUD() {

		// Dimensiones
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 748);

		// Estilos del JPanel
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#FFFFFF"));

		// Código de Ventana Principal...

		// Logo Fondo azul
		JLabel logoBlanco = new JLabel("");
		logoBlanco.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(logoBlanco);
		logoBlanco.setOpaque(false);

		ImageIcon imagen = new ImageIcon(getClass().getResource("/logoAzul.png"));
		int ancho = imagen.getIconWidth();
		int alto = imagen.getIconHeight();
		logoBlanco.setBounds(-43, -30, 183, 156);

		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
		logoBlanco.setIcon(icono);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 101, 100, 590);
		contentPane.add(scrollPane);

		// PANEL CON LOS BOTONES DEL MENU

		JPanel buttonPanel = new JPanel();
		scrollPane.setViewportView(buttonPanel);
		buttonPanel.setBackground(Color.decode("#FFFFFF"));

		JPanel panel = new JPanel(); // PANEL DONDE ESTAN LOS LABELS

		// Botón 1 
    	java.net.URL imgUrl = getClass().getResource("/pacientesIcono.png");
    	Icon icon = new ImageIcon(imgUrl);
    	buttonPanel.setLayout(null);
    	JButton button1 = new JButton(icon);
    	button1.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			PacienteCRUD pacienteCRUD= new PacienteCRUD();
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
    		DoctorConsultar doctorConsultar= new DoctorConsultar();
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
    			VentanaCitaCRUD ventanaCitaCRUD= new VentanaCitaCRUD();
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
    	
    	
    	//LABELS DE LOS BOTONES MENÚ
    	
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
		editarPanel.setBounds(100, 0, 1164, 670);
		contentPane.add(editarPanel);

		// Panel donde están los labels

		editarPanel.setViewportView(panel);
		panel.setBackground(new Color(255, 255, 255));

		// Cargar la imagen desde la carpeta de recursos
		String rutaImagen = "/cita.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen = getClass().getResource(rutaImagen);
		ImageIcon imagen1 = new ImageIcon(urlImagen);
		panel.setLayout(null);
		panel.setLayout(null);

		// Añadir la imagen al panel
		JLabel labelImagen = new JLabel(imagen1);
		
		
		
		labelImagen.setBounds(-226, -110, 1012, 865);
		panel.add(labelImagen);

		// L NOMBRE
		JLabel label_IDCita = new JLabel("ID Cita:");
		label_IDCita.setBounds(605, 40, 78, 65);
		panel.add(label_IDCita);

		label_IDCita.setFont(fuenteLabel);
		label_IDCita.setBackground(Color.decode("#008cce"));

		// APELLIDOS

		JLabel label_IDDoctor = new JLabel("ID Doctor:");
		label_IDDoctor.setBounds(580, 230, 97, 65);
		panel.add(label_IDDoctor);

		label_IDDoctor.setFont(fuenteLabel);

		// TELEFONO

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(612, 418, 65, 65);
		panel.add(lblFecha);

		lblFecha.setFont(fuenteLabel);

		// DIRECCION

		JLabel label_Motivo = new JLabel("Motivo:");
		label_Motivo.setBounds(609, 323, 74, 65);
		panel.add(label_Motivo);

		label_Motivo.setFont(fuenteLabel);

		// EMAIL

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setBounds(623, 513, 60, 65);
		panel.add(lblHora);

		lblHora.setFont(fuenteLabel);

		String rutaImagen2 = "/guardarIcono.png"; // Ajusta la ruta según la ubicación de tu recurso
		java.net.URL urlImagen2 = getClass().getResource(rutaImagen2);
		JTextField textField_IDCita = new JTextField();
		textField_IDCita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
				 }
    			if (!Character.isDigit(c)) {
                    e.consume(); 
                    JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		textField_IDCita.setBounds(673, 55, 379, 38);
		panel.add(textField_IDCita);

		JTextField textField_IDPaciente = new JTextField();
		textField_IDPaciente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
			        }
				 if (!Character.isDigit(c)) {
				        e.consume();
				        JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia", JOptionPane.WARNING_MESSAGE);
				    }
				}
				
			
		});
		textField_IDPaciente.setBounds(673, 150, 379, 38);
		panel.add(textField_IDPaciente);

		JTextField textField_IDDoctor = new JTextField();
		textField_IDDoctor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
				 }
				
    			if (!Character.isDigit(c)&& c != '-') {
                    e.consume(); 
                    JOptionPane.showMessageDialog(null, "Solo se pueden introducir números", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
				
			}
		});
		textField_IDDoctor.setBounds(673, 245, 379, 38);
		panel.add(textField_IDDoctor);
		
		
		JTextField textField_Motivo = new JTextField();
		textField_Motivo.setBounds(673, 340, 379, 38);
		panel.add(textField_Motivo);
		
		JTextField textField_Fecha = new JTextField();
		textField_Fecha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				char c = e.getKeyChar();
				 if (c == KeyEvent.VK_BACK_SPACE) {
			            return;
				 }
    			if (!Character.isDigit(c)&& c != '-') {
                    e.consume(); 
                    JOptionPane.showMessageDialog(null, "El formato de la fecha es AÑO-MES-DÍA", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
			}
		});
		textField_Fecha.setBounds(673, 435, 379, 38);
		panel.add(textField_Fecha);
		
		JTextField textField_Hora = new JTextField();
		textField_Hora.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
					char c=e.getKeyChar();
					 if (c == KeyEvent.VK_BACK_SPACE) {
				            return;
					 }
					 if (!Character.isDigit(c)&& c !=':') {
					        e.consume();
					        JOptionPane.showMessageDialog(null, "Solo se pueden introducir números y ':' ", "Advertencia", JOptionPane.WARNING_MESSAGE);
					    }
					}
		});
		textField_Hora.setBounds(673, 530, 379, 38);
		panel.add(textField_Hora);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(591, 593, 592, 75);
		panel_1.setBackground(new Color(70, 130, 180));
		panel.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.decode("#FFFFFF"));

	
		// BOTON GUARDAR
		// BOTON GUARDAR
		// BOTON GUARDAR
		// BOTON GUARDAR
		JButton btnGuardar = new JButton(icon11);
		btnGuardar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            String idCita = textField_IDCita.getText();
		            String idPaciente = textField_IDPaciente.getText();
		            String idDoctor = textField_IDDoctor.getText();
		            String motivo = textField_Motivo.getText();
		            String fecha = textField_Fecha.getText();
		            String hora = textField_Hora.getText();

		            // Verificar que todos los campos estén llenos
		            if (idCita.isEmpty() || idPaciente.isEmpty() || idDoctor.isEmpty() || motivo.isEmpty()
		                    || fecha.isEmpty() || hora.isEmpty()) {
		                // Mostrar un mensaje de error si algún campo está vacío
		                JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		            } else {
		                // Crear una instancia de ConectorBBDD (asegúrate de que sea accesible desde esta clase)
		                ConectorBBDD conectorBBDD = new ConectorBBDD();

		                // Llamar al método para insertar cita en la base de datos
		               

		                // Luego, si es necesario, puedes actualizar la tabla o realizar otras acciones después de la inserción.
		                // ...
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Error al procesar la cita", "Error", JOptionPane.ERROR_MESSAGE);
		        }
		    }
		});


		            // Realizar la lógica de guardar aquí


		// Agrega el botón al panel_1
		btnGuardar.setBounds(28, 11, 76, 59);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);

		// Establecer el botón como predeterminado para la tecla "Enter"
		getRootPane().setDefaultButton(btnGuardar);

		// Agrega el ActionListener para la tecla "Enter" en el JFrame
		addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
		            // Simular el clic en el botón al presionar "Enter"
		            btnGuardar.doClick();
		        }
		    }
		});

		// Agrega el botón al panel_1
		btnGuardar.setBounds(28, 11, 76, 59);
		panel_1.add(btnGuardar);
		btnGuardar.setPreferredSize(new Dimension(icon11.getIconWidth(), icon11.getIconHeight()));
		btnGuardar.setContentAreaFilled(false);

		// Establecer el botón como predeterminado para la tecla "Enter"
		getRootPane().setDefaultButton(btnGuardar);

		// Agrega el ActionListener para la tecla "Enter" en el JFrame
		addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyTyped(KeyEvent e) {
		        if (e.getKeyChar() == KeyEvent.VK_ENTER) {
		            // Simular el clic en el botón al presionar "Enter"
		            btnGuardar.doClick();
		        }
		    }
		});



		
		// BOTON VOLVER
		JButton btnVolver = new JButton(icon13);
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
		
		JLabel label_IDPaciente = new JLabel("ID Paciente:");
		label_IDPaciente.setBounds(562, 135, 115, 65);
		label_IDPaciente.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(label_IDPaciente);
		
		
		java.net.URL imgUrlColor = getClass().getResource("/cambiarColor.png");
		Icon iconColor = new ImageIcon(imgUrlColor);
		JButton btnCambiaColor = new JButton(iconColor);
		btnCambiaColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Incrementar el contador de clics
		        contadorClics++;

		        // Determinar el color según el número de clics
		        Color color;
		        switch (contadorClics % 3) {
		            case 1:
		                color = Color.WHITE;
		                break;
		            case 2:
		                color = Color.RED;
		                break;
		            case 0:
		                color = Color.decode("#008cce");;
		                break;
		            default:
		                color = Color.WHITE; // Color por defecto
		                break;
		        }

		        // Cambiar el color del panel
		        panel.setBackground(color);
		        contentPane.setBackground(color);
		       // buttonPanel.setBackground(color);
		        panel_1.setBackground(color);
		        
		    }
		});
				
		
		 btnCambiaColor.setContentAreaFilled(false);
	
			
		btnCambiaColor.setBounds(1063, 11, 89, 38);
		panel.add(btnCambiaColor);
		

		
		
		
		//JMENU BAR JITEM ETC
		
		   
	    JMenuBar menuBar = new JMenuBar();
	    setJMenuBar(menuBar);
	    
	    JMenu mnNewMenu = new JMenu("Menú");
	    menuBar.add(mnNewMenu);
	    
	    JMenu mnNewMenu_1 = new JMenu("Clases");
	    mnNewMenu.add(mnNewMenu_1);
	    
	  
	    
	    // ME REDIRIGE A  CLASE PACIENTE
	    
	    
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

	    
	    // ME REDIRIGE A  CLASE DOCTOR
	    
	    
	    JMenuItem mntmNewMenuItem_1 = new JMenuItem("Doctor");
	    mntmNewMenuItem_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
	    mnNewMenu_1.add(mntmNewMenuItem_1);
	    mnNewMenu.add(mnNewMenu_1);
	    mntmNewMenuItem_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear una instancia de la ventana del paciente y mostrarla
            DoctorConsultar  doctorConsultar  = new  DoctorConsultar();
            doctorConsultar.setVisible(true);
	   
	    
            	
	    	}
	    });
	    
	    
	    
	    
	    
	    
	    JMenuItem mntmNewMenuItem_3 = new JMenuItem("Material");
	    mnNewMenu_1.add(mntmNewMenuItem_3);
	    
	    JMenuItem mntmNewMenuItem_4 = new JMenuItem("Factura");
	    mnNewMenu_1.add(mntmNewMenuItem_4);
	    
	    JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pedido");
	    mnNewMenu_1.add(mntmNewMenuItem_5);
	    
	    JMenuItem mntmNewMenuItem_6 = new JMenuItem("Stock");
	    mnNewMenu_1.add(mntmNewMenuItem_6);
	    
	    JMenuItem mntmNewMenuItem_7 = new JMenuItem("Tratamiento");
	    mnNewMenu_1.add(mntmNewMenuItem_7);
	    
	    JMenuItem mntmNewMenuItem_8 = new JMenuItem("Especialistas");
	    mnNewMenu_1.add(mntmNewMenuItem_8);
	    
	    JMenuItem mntmNewMenuItem_9 = new JMenuItem("Usuarios");
	    mnNewMenu_1.add(mntmNewMenuItem_9);
	    
	    JMenu mnNewMenu_2 = new JMenu("Opciones");
	    mnNewMenu.add(mnNewMenu_2);
	    
	    JMenuItem mntmNewMenuItem_10 = new JMenuItem("Guardar");
	    mntmNewMenuItem_10.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
	    mnNewMenu_2.add(mntmNewMenuItem_10);
	    mntmNewMenuItem_10.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            try {
	                String idCita = textField_IDCita.getText();
	                String idPaciente = textField_IDPaciente.getText();
	                String idDoctor = textField_IDDoctor.getText();
	                String motivo = textField_Motivo.getText();
	                String fecha = textField_Fecha.getText();
	                String hora = textField_Hora.getText();

	                // Verificar que todos los campos estén llenos
	                if (idCita.isEmpty() || idPaciente.isEmpty() || idDoctor.isEmpty() || motivo.isEmpty()
	                        || fecha.isEmpty() || hora.isEmpty()) {
	                    // Mostrar un mensaje de error si algún campo está vacío
	                    JOptionPane.showMessageDialog(null, "Rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
	                    return;  // Salir del método para evitar el segundo mensaje de error
	                }

	                // Realizar la lógica de guardar aquí
	                // (Debes agregar aquí la lógica para guardar la información)

	            } catch (Exception ex) {
	                // Capturar cualquier excepción no manejada
	                JOptionPane.showMessageDialog(null, "Error al procesar la información", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	        }
	    });
	    JMenuItem mntmNewMenuItem_11 = new JMenuItem("Borrar");
	    mntmNewMenuItem_11.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_BACK_SPACE, InputEvent.CTRL_DOWN_MASK));
	    mnNewMenu_2.add(mntmNewMenuItem_11);
	    
	    JMenuItem mntmNewMenuItem_12 = new JMenuItem("Volver");
	    mntmNewMenuItem_12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, InputEvent.CTRL_DOWN_MASK));
	    mnNewMenu_2.add(mntmNewMenuItem_12);
	    
		
		
		
		
		
		
		
	}
}
	    
