package logica_negocio;

import java.util.Comparator;

public class Comparador {

	//sin constructor unifica comparadores
	//comparador por peso
	public static Comparator<Oferta> porPeso(){
		return new Comparator<Oferta>() {

			@Override
			public int compare(Oferta oferta1, Oferta oferta2) {
				if(oferta1.getDinero()<oferta2.getDinero()){
					return -1;
				}
				if(oferta1.getDinero()>oferta2.getDinero()){
					return 1;
				}
				return 0;
			}
		};
	}
	
	//comparador por beneficio
	public static Comparator<Oferta> porBeneficio(){
		return new Comparator<Oferta>(){

			@Override
			public int compare(Oferta oferta1, Oferta oferta2) {
				if(oferta1.getBeneficio()<oferta2.getBeneficio()){
					return -1;
				}
				if(oferta1.getBeneficio()>oferta2.getBeneficio()){
					return 1;
				}
				return 0;
			}
		};
	}
	
	//comparador por cociente
	public static Comparator<Oferta> porCociente(){
		return new Comparator<Oferta>(){
			public int compare(Oferta uno, Oferta otro){
				double cocienteUno=uno.getBeneficio()/uno.getDinero();
				double cocienteOtro=otro.getBeneficio()/otro.getDinero();
				if(cocienteUno<cocienteOtro){
					return -1;
				}
				if(cocienteUno>cocienteOtro){
					return 1;
				}
				return 0;
			}
		};
	}
}
