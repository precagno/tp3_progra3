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

	//sobreescrito de la interface Solver, contrato de adecion
	//agrega al subconjunto (posible solucion) una oferta
	@Override
	public Subconjunto resolver(Instancia instancia) {
		Subconjunto subconjunto=new Subconjunto();
		ArrayList<Oferta> ofertasOrdenadas=this.ordenarOfertas(instancia);
		for (Oferta oferta : ofertasOrdenadas) {
			if(subconjunto.superposicionHoraria(oferta)==false){//si la oferta entrante no se superpone con las ya realizadas
				subconjunto.agregarOfertas(oferta);//agrego la oferta al conjunto solucion
			}
		}
		return subconjunto;
	}

	//ordenamiento
	ArrayList<Oferta> ordenarOfertas(Instancia instancia) {
		ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();//clon de una instancia
		Collections.sort(ofertasOrdenadas,_comparador);//ordena de < a >
		Collections.reverse(ofertasOrdenadas);//invierte el orden de > a <  de no ser necesario se quita
		return ofertasOrdenadas;
	}
}
