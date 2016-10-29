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
			if(oferta.getDinero()+subconjunto.getDineroTotal()
			             <= instancia.getTiempoTotal()){//si no me paso del peso maximo
				subconjunto.agregarOfertas(oferta);//agrego el elemento al conjunto solucion
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
