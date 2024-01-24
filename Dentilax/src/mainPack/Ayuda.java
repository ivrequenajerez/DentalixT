
package mainPack;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ayuda extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtParaAgregarUn;
    private JTextField txtParaAgregarUn_1;
    private JTextField txtParaAgregarUna;
    private JTextField txtParaVisualizarUn;
    private JTextField txtParaGuardarPresionamos;
    private JTextField txtEnElMen;
    private JButton btnvolver;
    private static JFrame Ayuda;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Ayuda frame = new Ayuda();
                    frame.setVisible(true);
                    frame.setResizable(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Ayuda() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, -1, 1179, 691);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setForeground(Color.LIGHT_GRAY);
        panel.setBounds(0, 0, 1163, 652);
        contentPane.add(panel);

        // Cargar la imagen desde la carpeta de recursos
        java.net.URL imgUrl = getClass().getResource("/pregunta.png");
        ImageIcon icon = new ImageIcon(imgUrl);
        panel.setLayout(null);

        java.net.URL imgUrl1 = getClass().getResource("/volverIcono.png");
        ImageIcon icon11 = new ImageIcon(imgUrl1);
        btnvolver = new JButton(icon11);
        btnvolver.setBounds(821, 490, 384, 180);
        btnvolver.setContentAreaFilled(false);

        btnvolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
                ventanaPrincipal.setLocationRelativeTo(null); // Coloca la ventana en el centro
                ventanaPrincipal.setVisible(true);
                Ayuda.dispose();
            }
        });

        panel.add(btnvolver);

        // Configurar JTextFields como de solo lectura
        txtParaAgregarUn = new JTextField();
        txtParaAgregarUn.setBounds(556, 21, 476, 72);
        txtParaAgregarUn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtParaAgregarUn.setText("Para agregar un paciente en la pantalla principal pulsa F1");
        txtParaAgregarUn.setEditable(false);
        panel.add(txtParaAgregarUn);
        txtParaAgregarUn.setColumns(10);

        txtParaAgregarUn_1 = new JTextField();
        txtParaAgregarUn_1.setBounds(556, 104, 476, 72);
        txtParaAgregarUn_1.setText("Para agregar un doctor en la pantalla principal pulsa F2");
        txtParaAgregarUn_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtParaAgregarUn_1.setEditable(false);
        txtParaAgregarUn_1.setColumns(10);
        panel.add(txtParaAgregarUn_1);

        txtParaAgregarUna = new JTextField();
        txtParaAgregarUna.setBounds(556, 187, 476, 72);
        txtParaAgregarUna.setText("Para agregar una cita en la pantalla principal pulsa F3");
        txtParaAgregarUna.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtParaAgregarUna.setEditable(false);
        txtParaAgregarUna.setColumns(10);
        panel.add(txtParaAgregarUna);

        txtParaVisualizarUn = new JTextField();
        txtParaVisualizarUn.setBounds(556, 270, 499, 72);
        txtParaVisualizarUn.setText("Para visualizar un odontograma de un paciente pulsa Ctr + O");
        txtParaVisualizarUn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtParaVisualizarUn.setEditable(false);
        txtParaVisualizarUn.setColumns(10);
        panel.add(txtParaVisualizarUn);

        txtParaGuardarPresionamos = new JTextField();
        txtParaGuardarPresionamos.setBounds(624, 436, 369, 72);
        txtParaGuardarPresionamos.setText("Para guardar presionamos la tecla ENTER");
        txtParaGuardarPresionamos.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtParaGuardarPresionamos.setEditable(false);
        txtParaGuardarPresionamos.setColumns(10);
        panel.add(txtParaGuardarPresionamos);

        txtEnElMen = new JTextField();
        txtEnElMen.setBounds(515, 353, 562, 72);
        txtEnElMen.setText("En el Menú desplegable encontramos las combinaciones de teclas + Funcionalidades");
        txtEnElMen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        txtEnElMen.setEditable(false);
        txtEnElMen.setColumns(10);
        panel.add(txtEnElMen);
        
        
        java.net.URL imgUrl11 = getClass().getResource("/pregunta.png");
        ImageIcon icon12 = new ImageIcon(imgUrl11);
        JButton btnNewButton = new JButton(icon12);
        
        btnNewButton.setContentAreaFilled(false);
       
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnNewButton.setBounds(29, 88, 499, 514);
        panel.add(btnNewButton);
    }
}