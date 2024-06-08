package negocio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

public class VentanaLog extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelIzq;
	private JPanel panel4;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel Panel3;
	private JPanel panelUserCartel;
	private JLabel cartelUser;
	private JPanel panelUserCampo;
	private JTextField textField;
	private JPanel panelContraCartel;
	private JLabel CartelContrasena;
	private JPanel panelContrasenaCampo;
	private JTextField textField_2;
	private JButton Iniciar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLog frame = new VentanaLog();
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
	public VentanaLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(0, 1, 0, 0));
		
		this.panelIzq = new JPanel();
		this.panelIzq.setBorder(new TitledBorder(null, "Ingresar al sistema", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelIzq);
		this.panelIzq.setLayout(new GridLayout(4, 0, 0, 0));
		
		this.panel1 = new JPanel();
		this.panelIzq.add(this.panel1);
		
		this.panel2 = new JPanel();
		this.panelIzq.add(this.panel2);
		this.panel2.setLayout(new GridLayout(2, 2, 0, 0));
		
		this.panelUserCartel = new JPanel();
		this.panel2.add(this.panelUserCartel);
		
		this.cartelUser = new JLabel("Usuario:");
		this.panelUserCartel.add(this.cartelUser);
		
		this.panelUserCampo = new JPanel();
		this.panel2.add(this.panelUserCampo);
		
		this.textField = new JTextField();
		this.panelUserCampo.add(this.textField);
		this.textField.setColumns(10);
		
		this.panelContraCartel = new JPanel();
		this.panel2.add(this.panelContraCartel);
		
		this.CartelContrasena = new JLabel("Contraseña:");
		this.panelContraCartel.add(this.CartelContrasena);
		
		this.panelContrasenaCampo = new JPanel();
		this.panel2.add(this.panelContrasenaCampo);
		
		this.textField_2 = new JTextField();
		this.panelContrasenaCampo.add(this.textField_2);
		this.textField_2.setColumns(10);
		
		this.Panel3 = new JPanel();
		this.panelIzq.add(this.Panel3);
		
		this.Iniciar = new JButton("Ingresar");
		this.Panel3.add(this.Iniciar);
		
		this.panel4 = new JPanel();
		this.panelIzq.add(this.panel4);
	}

}
