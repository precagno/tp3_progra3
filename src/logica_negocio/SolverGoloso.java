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
	@Override
	public Subconjunto resolver(Instancia instancia) {
		Subconjunto subconjunto=new Subconjunto();
		ArrayList<Oferta> ofertasOrdenadas=this.ordenarOfertas(instancia);
		for (Oferta oferta : ofertasOrdenadas) {
//			if(!oferta.getFranjaHoraria().superposicionHoraria(otraFranja)) aun no c con q compararlo
			if(oferta.getDemandaHoraria().getTiempo() + subconjunto.getTiempoTotal() <= instancia.getTiempoMaximo()){//si no me paso del tiempo maximo

				subconjunto.agregarOfertas(oferta);//agrego la oferta al conjunto solucion
			}
		}
		return subconjunto;
	}

	//ordenamiento
	ArrayList<Oferta> ordenarOfertas(Instancia instancia) {
		ArrayList<Oferta> ofertasOrdenadas=instancia.obtenerOfertas();//clon de una instancia
		Collections.sort(ofertasOrdenadas,_comparador);
		return ofertasOrdenadas;
	}
}
