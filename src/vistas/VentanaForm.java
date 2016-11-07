package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class VentanaForm extends JFrame {

	private JPanel contentPane;
	private JTextField textNombreOferente;
	private JLabel lblTituloPrincipal;
	private JLabel lblTiempoDeUso;
	private JLabel lblDineroOfrecido;
	private JTextField txtDineroOfrecido;
	private JComboBox<Integer> cmbxTiempoDeUso;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaForm frame = new VentanaForm();
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
	public VentanaForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNombreOferente = new JTextField();
		textNombreOferente.setBounds(169, 77, 190, 20);
		contentPane.add(textNombreOferente);
		textNombreOferente.setColumns(10);
		
		JLabel lblNombreOferente = new JLabel("Nombre del oferente");
		lblNombreOferente.setBounds(41, 80, 118, 14);
		contentPane.add(lblNombreOferente);
		
		lblTituloPrincipal = new JLabel("Ingreso de ofertas");
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloPrincipal.setBounds(81, 21, 258, 45);
		contentPane.add(lblTituloPrincipal);
		
		JComboBox<Integer> cmbxHoraInicio = new JComboBox<Integer>();
		cmbxHoraInicio.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3}));
		cmbxHoraInicio.setBounds(146, 118, 54, 20);
		contentPane.add(cmbxHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(41, 121, 95, 14);
		contentPane.add(lblHoraInicio);
		
		lblTiempoDeUso = new JLabel("Tiempo de uso");
		lblTiempoDeUso.setBounds(210, 121, 85, 14);
		contentPane.add(lblTiempoDeUso);
		
		lblDineroOfrecido = new JLabel("Dinero ofrecido");
		lblDineroOfrecido.setBounds(41, 159, 118, 14);
		contentPane.add(lblDineroOfrecido);
		
		txtDineroOfrecido = new JTextField();
		txtDineroOfrecido.setColumns(10);
		txtDineroOfrecido.setBounds(169, 156, 190, 20);
		contentPane.add(txtDineroOfrecido);
		
		JButton btnIngresarOferta = new JButton("Ingresar oferta");
		btnIngresarOferta.setBounds(149, 210, 130, 23);
		contentPane.add(btnIngresarOferta);
		
		cmbxTiempoDeUso = new JComboBox<Integer>();
		cmbxTiempoDeUso.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {1,2,3}));
		cmbxTiempoDeUso.setBounds(305, 118, 54, 20);
		contentPane.add(cmbxTiempoDeUso);
		
	}
}
