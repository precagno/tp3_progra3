package tests;

import java.util.ArrayList;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;

public class InstanciaEjemplo 
{
	public static ArrayList<Oferta> listaOfertas(){
		ArrayList<Oferta> listaOfertas=new ArrayList<Oferta>();
		
		listaOfertas.add(new Oferta("Juan Albornoz",600.0,new DemandaHoraria(11,2)));//,13
		listaOfertas.add(new Oferta("Pablo Meirelles",1000.0,new DemandaHoraria(0,5)));//,5
		listaOfertas.add(new Oferta("Joaquin Del Valle",1000.0,new DemandaHoraria(0,5)));//,5
		listaOfertas.add(new Oferta("Jose Evaristo Mendieta",400.0,new DemandaHoraria(15,6)));//,21
		listaOfertas.add(new Oferta("Enrique Bochini",600.0,new DemandaHoraria(21,3)));//,24
		listaOfertas.add(new Oferta("Javier Marenco",1200.0,new DemandaHoraria(21,3)));//,24
		listaOfertas.add(new Oferta("Patricia Heiner",600.0,new DemandaHoraria(11,2)));//,13
		
		return listaOfertas;
	}
}
