package vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;
import modelo.ManejadorOfertas;

public class Main {

	public static boolean crearVentanaOfertas=true;
	private JFrame frame;
	private JTextField txtNombreOferente;
	private JLabel lblTituloPrincipal;
	private JLabel lblTiempoDeUso;
	private JLabel lblDineroOfrecido;
	private JTextField txtDineroOfrecido;
	private JComboBox<Integer> cmbxHoraInicio;
	private JComboBox<Integer> cmbxTiempoDeUso;
	private JPanel pnlFormulario;
	private JButton btnVerOfertas;
	private JTextField horaFintextField;
	private ManejadorOfertas manejadorOfertas;
	

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
		try{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}catch(Exception e){
			e.printStackTrace();
		}
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Administrador de sala de ensayos por demanda");
		frame.setBounds(100, 100, 488, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		manejadorOfertas=new ManejadorOfertas();
		pnlFormulario = new JPanel();
		pnlFormulario.setBounds(0, 0, 472, 262);
		frame.getContentPane().add(pnlFormulario);
		pnlFormulario.setLayout(null);
		
		lblTituloPrincipal = new JLabel("Ingreso de ofertas");
		lblTituloPrincipal.setForeground(Color.GRAY);
		lblTituloPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTituloPrincipal.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTituloPrincipal.setBounds(127, 11, 220, 25);
		pnlFormulario.add(lblTituloPrincipal);
		
		cmbxHoraInicio = new JComboBox<Integer>();
		cmbxHoraInicio.setModel(new DefaultComboBoxModel<Integer>(horas(true)));
		cmbxHoraInicio.setBounds(104, 99, 54, 20);
		pnlFormulario.add(cmbxHoraInicio);
		
		JLabel lblHoraInicio = new JLabel("Hora de inicio");
		lblHoraInicio.setBounds(27, 102, 86, 14);
		pnlFormulario.add(lblHoraInicio);
		
		lblTiempoDeUso = new JLabel("Tiempo de uso");
		lblTiempoDeUso.setBounds(187, 102, 86, 14);
		pnlFormulario.add(lblTiempoDeUso);
		
		lblDineroOfrecido = new JLabel("Dinero ofrecido");
		lblDineroOfrecido.setBounds(27, 141, 99, 14);
		pnlFormulario.add(lblDineroOfrecido);
		
		txtDineroOfrecido = new JTextField();
		txtDineroOfrecido.setColumns(10);
		txtDineroOfrecido.setBounds(128, 133, 105, 25);
		pnlFormulario.add(txtDineroOfrecido);
		
		JButton btnIngresarOferta = new JButton("Ingresar oferta");
		
		btnIngresarOferta.setBounds(27, 190, 132, 23);
		pnlFormulario.add(btnIngresarOferta);
		
		JLabel lblNombreOferente = new JLabel("Nombre del oferente");
		lblNombreOferente.setBounds(27, 66, 123, 14);
		pnlFormulario.add(lblNombreOferente);
		
		txtNombreOferente = new JTextField();
		txtNombreOferente.setBounds(156, 47, 205, 36);
		pnlFormulario.add(txtNombreOferente);
		txtNombreOferente.setColumns(10);
		
		cmbxTiempoDeUso = new JComboBox<Integer>();
		cmbxTiempoDeUso.setModel(new DefaultComboBoxModel<Integer>(horas(false)));
		cmbxTiempoDeUso.setBounds(270, 99, 54, 20);
		pnlFormulario.add(cmbxTiempoDeUso);
		
		JLabel lblHorasInicio = new JLabel("hs");
		lblHorasInicio.setBounds(163, 102, 21, 14);
		pnlFormulario.add(lblHorasInicio);
		
		JLabel lblHorasUso = new JLabel("hs");
		lblHorasUso.setBounds(326, 102, 21, 14);
		pnlFormulario.add(lblHorasUso);
		
		btnVerOfertas = new JButton("Ver soluci�n");
		btnVerOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(crearVentanaOfertas){
					creadorVentanaOfertas();
				}
			}
		});
		btnVerOfertas.setBounds(319, 190, 132, 23);
		pnlFormulario.add(btnVerOfertas);
		
		JLabel label = new JLabel("Hora Fin");
		label.setBounds(357, 102, 54, 14);
		pnlFormulario.add(label);
		
		horaFintextField = new JTextField();
		horaFintextField.setColumns(10);
		horaFintextField.setBounds(406, 94, 45, 25);
		pnlFormulario.add(horaFintextField);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(64, 64, 64), null, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(211, 211, 211));
		panel.setBounds(0, 237, 472, 25);
		pnlFormulario.add(panel);
		
		JLabel lblUniversidadNacionalDe = new JLabel("Universidad Nacional de General Sarmiento | Programaci\u00F3n III | Trabajo Pr\u00E1ctico N\u00B03");
		lblUniversidadNacionalDe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblUniversidadNacionalDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblUniversidadNacionalDe.setBounds(10, 5, 437, 14);
		panel.add(lblUniversidadNacionalDe);
		
		JLabel lblPesos = new JLabel("pesos");
		lblPesos.setBounds(236, 141, 37, 14);
		pnlFormulario.add(lblPesos);
		
		JButton btnBorrarOfertas = new JButton("Borrar ofertas");
		btnBorrarOfertas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					if(ventanaModalDesicion("Desea borrar todas las ofertas?")==0){
						manejadorOfertas.eliminarOfertasPersistidas();
					}
					
				} catch (IOException e) {
					e.getMessage();
				}
			}
		});
		btnBorrarOfertas.setBounds(169, 190, 140, 23);
		pnlFormulario.add(btnBorrarOfertas);
		
		btnIngresarOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					validacionCamposForm();
				
				} catch (IOException e) {
					e.getMessage();
				}
			}
		});
		/*---- Fin panel Ofertas ----*/
		
		
	}
	
	/*---- M�todos auxiliares ----*/
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
	
	//validacion de campos a llenar
	private void validacionCamposForm() throws IllegalArgumentException, IOException {
		boolean errores=false;
		String mensajeErrores="";
		String mensajeCorrecto="Oferta ingresada correctamente";
		int unDiaCompleto=24;
		//suma para mostrar la hora final
		int nro1=cmbxHoraInicio.getSelectedIndex();
		int nro2=cmbxTiempoDeUso.getSelectedIndex();
		int horaFinal=nro1+nro2+1;
		horaFintextField.setText(""+horaFinal);
		
		//validacion de oferente
		if(txtNombreOferente.getText().equals("")){
			mensajeErrores+="-Ingrese un nombre de oferente\n";
			errores=true;
		}
		
		//validacion de dinero
		if(txtDineroOfrecido.getText().equals("") || Integer.parseInt(txtDineroOfrecido.getText()) <= 0){
			mensajeErrores+="-Ingrese un monto mayor a cero para la oferta\n";
			errores=true;
		}
		
		//validacion de tiempo
		if((cmbxHoraInicio.getSelectedIndex()+1)+cmbxTiempoDeUso.getSelectedIndex()>unDiaCompleto){
			mensajeErrores+="-Ingrese un horario valido, sobrepaso el limite de horas\n";
			errores=true;
		}
		
		if(errores){
			ventanaModal(mensajeErrores);
		}else{
			
			Double dinero=Double.valueOf(txtDineroOfrecido.getText());
			ventanaModal(mensajeCorrecto);
	
			manejadorOfertas.agregarOferta(new Oferta(txtNombreOferente.getText(),dinero, new DemandaHoraria(cmbxHoraInicio.getSelectedIndex(),cmbxTiempoDeUso.getSelectedIndex() )));
			
			limpiarCamposForm();
		}
	}
	
	//poner en blanco los campos a llenar
	private void limpiarCamposForm() {
		txtNombreOferente.setText("");
		txtDineroOfrecido.setText("");
		cmbxHoraInicio.setSelectedIndex(0);
		cmbxTiempoDeUso.setSelectedIndex(0);
		horaFintextField.setText("");
	}

	private void ventanaModal(String mensaje){
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
	private int ventanaModalDesicion(String mensaje){
		return JOptionPane.showConfirmDialog(null,mensaje);
	}
	
	//crea la vista de la resolucion golosa
	private JFrame creadorVentanaOfertas(){
		JFrame ventanaOfertas=new VistaOfertas();
		ventanaOfertas.setBounds(400, 400, 488, 200);
		ventanaOfertas.setVisible(true);
		setCrearVentanaOfertas(false);
		return ventanaOfertas;
	}
	
	public static void setCrearVentanaOfertas(boolean estado){
		crearVentanaOfertas=estado;
	}
}
