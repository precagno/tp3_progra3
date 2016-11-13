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
	public SolverGoloso(Comparator<Oferta> comparador){
		_comparador=comparador;
	}

	public void setNombreArchivo(String nombre){
		_nombreArchivo=nombre;
	}
	
	public Subconjunto resolver() {
		
		Subconjunto subconjunto=new Subconjunto();
		Instancia instancia=null;
		
		try{
			
			if(_nombreArchivo==null){
				return null;
			}
			
			instancia = creadorInstancia();
			
			ArrayList<Oferta> ofertasOrdenadas=this.ordenarOfertas(instancia);
			//ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();
			
			for (Oferta oferta : ofertasOrdenadas) {
				
				int duracionOferta=oferta.getDemandaHoraria().getTiempo();
				boolean noHaySuperposicion=subconjunto.superposicionHoraria(oferta)==false;
				boolean menorQueUnDia=subconjunto.getTiempoTotal()+duracionOferta<=instancia.getTiempoMaximo();//24hrs
				
				if(noHaySuperposicion && menorQueUnDia){//si la oferta entrante no se superpone con las ya realizadas
					subconjunto.agregarOfertas(oferta);//agrego la oferta al conjunto solucion
				}
			}
			
		}catch(Exception excepcion){
			System.out.println(excepcion.getMessage());
		}
		
		
		return subconjunto;
	}

	/*-- Métodos auxiliares --*/
	
	/*-- Crea una instancia a partir de ofertas anteriormente persistidas --*/
	private Instancia creadorInstancia() throws IOException{
		Instancia aux=new Instancia();
		DAOfertas dao=new DAOfertas(_nombreArchivo);
		
		for(Oferta oferta:dao.obtenerOfertas()){
			aux.agregarOferta(oferta);
		}
		
		return aux;
	}
	
	ArrayList<Oferta> ordenarOfertas(Instancia instancia) {
		ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();//clon de una instancia
		Collections.sort(ofertasOrdenadas,_comparador);//ordena de < a >
		return ofertasOrdenadas;
	}
}
