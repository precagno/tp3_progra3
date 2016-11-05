package logica_negocio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SolverGoloso implements Solver {//adiere a interface Solver
	
	//variables de instancia
	private Comparator<Oferta> _comparador;
	
	//constructor
	public SolverGoloso(Comparator<Oferta> comparador){
		_comparador=comparador;
	}

	public Subconjunto resolver(Instancia instancia) {
		Subconjunto subconjunto=new Subconjunto();
		ArrayList<Oferta> ofertasOrdenadas=this.ordenarOfertas(instancia);
		for (Oferta oferta : ofertasOrdenadas) {
			
			int duracionOferta=oferta.getDemandaHoraria().getTiempo();
			boolean noHaySuperposicion=subconjunto.superposicionHoraria(oferta)==false;
			boolean menorQueUnDia=subconjunto.getTiempoTotal()+duracionOferta<=24;
			
			if(noHaySuperposicion && menorQueUnDia){//si la oferta entrante no se superpone con las ya realizadas
				subconjunto.agregarOfertas(oferta);//agrego la oferta al conjunto solucion
			}
		}
		return subconjunto;
	}

	//ordenamiento
	ArrayList<Oferta> ordenarOfertas(Instancia instancia) {
		ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();//clon de una instancia
		Collections.sort(ofertasOrdenadas,_comparador);//ordena de < a >
		return ofertasOrdenadas;
	}
}
