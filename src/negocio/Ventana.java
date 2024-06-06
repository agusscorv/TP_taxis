package negocio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelColIzq;
	private JPanel panelColMedio;
	private JPanel panelColDer;
	private JScrollPane scrollPaneIzq;
	private JTextArea textAreaIzq;
	private JScrollPane scrollPaneDer;
	private JTextArea textAreaDer;
	private JScrollPane scrollPaneMedio;
	private JTextArea textAreaMedio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.panelCentral = new JPanel();
		this.contentPane.add(this.panelCentral, BorderLayout.CENTER);
		this.panelCentral.setLayout(new GridLayout(0, 3, 0, 0));
		
		this.panelColIzq = new JPanel();
		this.panelColIzq.setBorder(new TitledBorder(null, "Vista del Cliente 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColIzq);
		this.panelColIzq.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneIzq = new JScrollPane();
		this.panelColIzq.add(this.scrollPaneIzq, BorderLayout.CENTER);
		
		this.textAreaIzq = new JTextArea();
		this.scrollPaneIzq.setViewportView(this.textAreaIzq);
		
		this.panelColMedio = new JPanel();
		this.panelColMedio.setBorder(new TitledBorder(null, "Vista General", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		this.panelCentral.add(this.panelColMedio);
		this.panelColMedio.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneMedio = new JScrollPane();
		this.panelColMedio.add(this.scrollPaneMedio, BorderLayout.CENTER);
		
		this.textAreaMedio = new JTextArea();
		this.scrollPaneMedio.setViewportView(this.textAreaMedio);
		
		this.panelColDer = new JPanel();
		this.panelColDer.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Vista de Chofer 1", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		this.panelCentral.add(this.panelColDer);
		this.panelColDer.setLayout(new BorderLayout(0, 0));
		
		this.scrollPaneDer = new JScrollPane();
		this.panelColDer.add(this.scrollPaneDer, BorderLayout.CENTER);
		
		this.textAreaDer = new JTextArea();
		this.scrollPaneDer.setViewportView(this.textAreaDer);
	}

}
