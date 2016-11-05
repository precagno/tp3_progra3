package logica_negocio;

import java.util.Comparator;

public class Comparador {

	/**sin constructor unifica comparadores
	 * de distintos tipos de parametros de 
	 * un objeto*/
	
	//comparador por dinero
	public static Comparator<Oferta> porDinero(){
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
	
	//comparador por tiempo
	public static Comparator<Oferta> porTiempo(){
		return new Comparator<Oferta>(){

			@Override
			public int compare(Oferta oferta1, Oferta oferta2) {
				if(oferta1.getDemandaHoraria().getTiempo()<oferta2.getDemandaHoraria().getTiempo()){
					return -1;
				}
				if(oferta1.getDemandaHoraria().getTiempo()>oferta2.getDemandaHoraria().getTiempo()){
					return 1;
				}
				return 0;
			}
		};
	}
	
	//comparador por cociente (dinero/tiempo)
	public static Comparator<Oferta> porCociente(){
		return new Comparator<Oferta>(){
			public int compare(Oferta uno, Oferta otro){
				double cocienteUno=uno.getDinero()/uno.getDemandaHoraria().getTiempo();
				double cocienteOtro=otro.getDinero()/otro.getDemandaHoraria().getTiempo();
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
