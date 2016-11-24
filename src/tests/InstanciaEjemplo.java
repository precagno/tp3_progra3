package tests;

import logica_negocio.DemandaHoraria;
import logica_negocio.Instancia;
import logica_negocio.Oferta;

public class InstanciaEjemplo 
{
	public static Instancia instanciaEjemploUno(){
		Instancia instancia=new Instancia();
		
		instancia.agregarOferta(new Oferta("Juan Albornoz",600.0,new DemandaHoraria(11,2)));//2hs
		instancia.agregarOferta(new Oferta("Pablo Meirelles",1000.0,new DemandaHoraria(0,5)));//5hs
		instancia.agregarOferta(new Oferta("Joaquin Del Valle",1000.0,new DemandaHoraria(0,5)));//5hs
		instancia.agregarOferta(new Oferta("Jose Evaristo Mendieta",400.0,new DemandaHoraria(15,6)));//6hs
		instancia.agregarOferta(new Oferta("Enrique Bochini",600.0,new DemandaHoraria(21,3)));//3hs
		instancia.agregarOferta(new Oferta("Javier Marenco",1200.0,new DemandaHoraria(21,3)));//3hs
		instancia.agregarOferta(new Oferta("Patricia Heiner",600.0,new DemandaHoraria(11,2)));//2hs
		
		return instancia;
	}
	
	public static Instancia instanciaEjemploDos(){
		Instancia instancia=new Instancia();
		
		instancia.agregarOferta(new Oferta("Juan Alboran",200.0,new DemandaHoraria(5,5)));//5hs 40 cociente
		instancia.agregarOferta(new Oferta("Ernesto Bauman",100.0,new DemandaHoraria(16,3)));//3hs 33 cociente
		instancia.agregarOferta(new Oferta("Pedro Albornoz",600.0,new DemandaHoraria(0,2)));//2hs 300 cociente
		instancia.agregarOferta(new Oferta("Cesar Pitrola",400.0,new DemandaHoraria(11,4)));//4hs 100 cociente	
		
		return instancia;
	}
}
