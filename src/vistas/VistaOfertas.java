package vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import logica_negocio.Comparador;
import logica_negocio.Oferta;
import logica_negocio.Solucion;
import modelo.ManejadorOfertas;

@SuppressWarnings("serial")
public class VistaOfertas extends JFrame {
	public VistaOfertas() {
		super("Listado de ofertas resueltas");
		DefaultTableModel dtm= new DefaultTableModel(new Object[0][0],nombreColumnas());
	
		final JTable table = new JTable(dtm);
		
		populaTableModel(dtm);
		
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		//Creamos un JscrollPane y le agregamos la JTable
		JScrollPane scrollPane = new JScrollPane(table);
		//Agregamos el JScrollPane al contenedor
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		//manejamos la salida
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				Main.setCrearVentanaOfertas(true);	
			}
		});
	}

	public static void main(String[] args) {
		VistaOfertas frame = new VistaOfertas();
		frame.pack();
		frame.setVisible(true);	
	}
	
	/*---- M�todos auxiliares ----*/
	private String[] nombreColumnas(){
		return new String[]{"Nombre oferente","Horario Inicio", "Horario Fin",
		"Dinero"};
	}
	
	//completa la vista con la solucion golosa (comparador elegido por cociente)
	private void populaTableModel(DefaultTableModel dtm)
	{
		ManejadorOfertas manejador=new ManejadorOfertas();
		Comparator<Oferta> comparador=Comparador.porCociente();// comparador por cociente
		Solucion solucion=manejador.devuelveSolucion(comparador);
		
		for(int i=0;i<solucion.getCantOfertas();i++){
			
			Oferta oferta=solucion.getOferta(i);
			String oferente=oferta.getOferente();
			int horaInicio=oferta.getDemandaHoraria().getHoraInicio();
			int horaFin=oferta.getDemandaHoraria().getHoraFin();
			Double dinero=oferta.getDinero();
			Object[] nuevaFila={oferente,horaInicio,horaFin,dinero};
			
			dtm.addRow(nuevaFila);
		}
		
	}
}
