package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombreOferente;
	private JLabel lblTituloPrincipal;
	private JLabel lblTiempoDeUso;
	private JLabel lblDineroOfrecido;
	private JTextField txtDineroOfrecido;
	private JComboBox<Integer> cmbxHoraInicio;
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
		
		txtNombreOferente = new JTextField();
		txtNombreOferente.setBounds(169, 77, 190, 20);
		contentPane.add(txtNombreOferente);
		txtNombreOferente.setColumns(10);
		
		JLabel lblNombreOferente = new JLabel("Nombre del oferente");
		lblNombreOferente.setBounds(41, 80, 118, 14);
		contentPane.add(lblNombreOferente);
		
		lblTituloPrincipal = new JLabel("Ingreso de ofertas");
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloPrincipal.setBounds(81, 21, 258, 45);
		contentPane.add(lblTituloPrincipal);
		
		cmbxHoraInicio = new JComboBox<Integer>();
		cmbxHoraInicio.setModel(new DefaultComboBoxModel<Integer>(horas(true)));
		cmbxHoraInicio.setBounds(138, 118, 44, 20);
		contentPane.add(cmbxHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(41, 121, 95, 14);
		contentPane.add(lblHoraInicio);
		
		lblTiempoDeUso = new JLabel("Tiempo de uso");
		lblTiempoDeUso.setBounds(222, 121, 85, 14);
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
		cmbxTiempoDeUso.setModel(new DefaultComboBoxModel<Integer>(horas(false)));
		cmbxTiempoDeUso.setBounds(315, 118, 44, 20);
		contentPane.add(cmbxTiempoDeUso);
		
		JLabel lblHorasInicio = new JLabel("hs");
		lblHorasInicio.setBounds(192, 121, 20, 14);
		contentPane.add(lblHorasInicio);
		
		JLabel lblHorasUso = new JLabel("hs");
		lblHorasUso.setBounds(365, 121, 32, 14);
		contentPane.add(lblHorasUso);
		
		btnIngresarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validacionCamposForm();
			}
		});
		
	}
	
	/*---- Métodos auxiliares ----*/
	private Integer[] horas(boolean desdeCero){
		Integer[] horas=new Integer[24];
		
		for(int i=0;i<24;i++){
			if(desdeCero)
				horas[i]=i;
			else
				horas[i]=i+1;
		}
		
		return horas;
	}
	
	private void validacionCamposForm() {
		boolean errores=false;
		String mensajeErrores="";
		String mensajeCorrecto="Oferta ingresada correctamente";
		
		if(txtNombreOferente.getText().equals("")){
			mensajeErrores+="-Ingrese un nombre de oferente\n";
			errores=true;
		}
		
		if(txtDineroOfrecido.getText().equals("") || Integer.parseInt(txtDineroOfrecido.getText()) <= 0){
			mensajeErrores+="-Ingrese un monto mayor a cero para la oferta\n";
			errores=true;
		}
		
		if(errores){
			ventanaModal(mensajeErrores);
		}else{
			ventanaModal(mensajeCorrecto);
			limpiarCamposForm();
		}
	}
	
	private void limpiarCamposForm() {
		txtNombreOferente.setText("");
		txtDineroOfrecido.setText("");
		cmbxHoraInicio.setSelectedIndex(0);
		cmbxTiempoDeUso.setSelectedIndex(0);		
	}

	private void ventanaModal(String mensaje){
		JOptionPane.showMessageDialog(null,mensaje);
	}
}