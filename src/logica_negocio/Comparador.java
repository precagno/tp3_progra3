package logica_negocio;

import java.util.Comparator;

public class Comparador {

	//sin constructor unifica comparadores
	//comparador por oferta
	public static Comparator<Oferta> porDinero(){//de > a <, -1 primero
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
	public static Comparator<Oferta> porTiempo(){//de > a <, -1 primero
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
	
	//comparador por cociente
	public static Comparator<Oferta> porCociente(){//de > a <, -1 primero
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
