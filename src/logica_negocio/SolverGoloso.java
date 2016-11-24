package logica_negocio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import modelo.DAOfertas;

public class SolverGoloso implements Solver {//adiere a interface Solver
	
	//variables de instancia
	private Comparator<Oferta> _comparador;
	private String _nombreArchivo;
	
	//constructor
	public SolverGoloso(Comparator<Oferta> comparador,String nombreArchivo){
		_comparador=comparador;
		_nombreArchivo=nombreArchivo;
	}
	
	//heuristica golosa
	public Solucion resolver() {
		
		Solucion subconjunto=new Solucion();
		Instancia instancia=null;
		
		try{
			
			if(_nombreArchivo==null){
				return null;
			}
			
			instancia = creadorInstancia();
			
			ArrayList<Oferta> ofertasOrdenadas=ordenarOfertas(instancia);
						
			for (Oferta oferta : ofertasOrdenadas) {
				
				int duracionOferta=oferta.getDemandaHoraria().getTiempo();
				boolean haySuperposicion=subconjunto.superposicionHoraria(oferta)==true;
				boolean esMenorQueUnDia=(duracionOferta+subconjunto.getTiempoTotal() <= instancia.getTiempoMaximo());
				
				if(!haySuperposicion && esMenorQueUnDia && !subconjunto.contieneOferta(oferta)){//si la oferta entrante no se superpone con las ya realizadas
					//y si la suma de esa oferta con las ya recibidas es menor o igual a 24hs
					subconjunto.agregarOfertas(oferta);//agrego la oferta al conjunto solucion
					subconjunto.asignarTiempo(oferta);
				}
			}
			
		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
		}
		
		
		return subconjunto;
	}

	/*-- M�todos auxiliares --*/
	
	/*-- Crea una instancia a partir de ofertas anteriormente persistidas --*/
	private Instancia creadorInstancia() throws IOException{
		Instancia aux=new Instancia();
		DAOfertas dao=new DAOfertas(_nombreArchivo);
		
		for(Oferta oferta:dao.obtenerOfertas()){
			aux.agregarOferta(oferta);
		}
		
		return aux;
	}
	
	//ordena ofertas de acuerdo a comparador elegido
	ArrayList<Oferta> ordenarOfertas(Instancia instancia) {
		ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();//clon de una instancia
		Collections.sort(ofertasOrdenadas,_comparador);//ordena de < a >
		Collections.reverse(ofertasOrdenadas);
		return ofertasOrdenadas;
	}
}
