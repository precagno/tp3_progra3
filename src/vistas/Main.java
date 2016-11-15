package vistas;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Main {

	private JFrame frame;
	private JTextField txtNombreOferente;
	private JLabel lblTituloPrincipal;
	private JLabel lblTiempoDeUso;
	private JLabel lblDineroOfrecido;
	private JTextField txtDineroOfrecido;
	private JComboBox<Integer> cmbxHoraInicio;
	private JComboBox<Integer> cmbxTiempoDeUso;
	private JPanel pnlFormulario;
	private JPanel pnlOfertas;
	private JButton btnVerOfertas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pnlFormulario = new JPanel();
		pnlFormulario.setBounds(0, 0, 434, 262);
		frame.getContentPane().add(pnlFormulario);
		pnlFormulario.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Ingreso de ofertas");
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloPrincipal.setBounds(126, 11, 187, 25);
		pnlFormulario.add(lblTituloPrincipal);
		
		cmbxHoraInicio = new JComboBox<Integer>();
		cmbxHoraInicio.setModel(new DefaultComboBoxModel<Integer>(horas(true)));
		cmbxHoraInicio.setBounds(123, 99, 45, 20);
		pnlFormulario.add(cmbxHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(27, 102, 86, 14);
		pnlFormulario.add(lblHoraInicio);
		
		lblTiempoDeUso = new JLabel("Tiempo de uso");
		lblTiempoDeUso.setBounds(195, 102, 86, 14);
		pnlFormulario.add(lblTiempoDeUso);
		
		lblDineroOfrecido = new JLabel("Dinero ofrecido");
		lblDineroOfrecido.setBounds(29, 141, 99, 14);
		pnlFormulario.add(lblDineroOfrecido);
		
		txtDineroOfrecido = new JTextField();
		txtDineroOfrecido.setColumns(10);
		txtDineroOfrecido.setBounds(133, 138, 105, 20);
		pnlFormulario.add(txtDineroOfrecido);
		
		JButton btnIngresarOferta = new JButton("Ingresar oferta");
		
		btnIngresarOferta.setBounds(93, 190, 132, 23);
		pnlFormulario.add(btnIngresarOferta);
		
		JLabel lblNombreOferente = new JLabel("Nombre del oferente");
		lblNombreOferente.setBounds(27, 66, 99, 14);
		pnlFormulario.add(lblNombreOferente);
		
		txtNombreOferente = new JTextField();
		txtNombreOferente.setBounds(136, 63, 248, 20);
		pnlFormulario.add(txtNombreOferente);
		txtNombreOferente.setColumns(10);
		
		cmbxTiempoDeUso = new JComboBox<Integer>();
		cmbxTiempoDeUso.setModel(new DefaultComboBoxModel<Integer>(horas(false)));
		cmbxTiempoDeUso.setBounds(291, 99, 38, 20);
		pnlFormulario.add(cmbxTiempoDeUso);
		
		JLabel lblHorasInicio = new JLabel("hs");
		lblHorasInicio.setBounds(178, 102, 21, 14);
		pnlFormulario.add(lblHorasInicio);
		
		JLabel lblHorasUso = new JLabel("hs");
		lblHorasUso.setBounds(339, 102, 28, 14);
		pnlFormulario.add(lblHorasUso);
		
		btnVerOfertas = new JButton("Ver ofertas");
		btnVerOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pnlFormulario.setVisible(false);
				pnlOfertas.setVisible(true);
			}
		});
		btnVerOfertas.setBounds(235, 190, 132, 23);
		pnlFormulario.add(btnVerOfertas);
		
				pnlOfertas = new JPanel();
				pnlOfertas.setBounds(0, 0, 434, 262);
				frame.getContentPane().add(pnlOfertas);
				pnlOfertas.setLayout(null);
				
				JButton btnIngresarOfertas = new JButton("Ingresar ofertas");
				btnIngresarOfertas.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						pnlOfertas.setVisible(false);
						pnlFormulario.setVisible(true);
					}
				});
				btnIngresarOfertas.setBounds(109, 99, 132, 23);
				pnlOfertas.add(btnIngresarOfertas);
		
		btnIngresarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				validacionCamposForm();
			}
		});
		/*---- Fin panel Ofertas ----*/
		
		
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
