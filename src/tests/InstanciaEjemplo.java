package tests;

import logica_negocio.DemandaHoraria;
import logica_negocio.Instancia;
import logica_negocio.Oferta;

public class InstanciaEjemplo 
{
	public static Instancia instanciaEjemploUno(){
		Instancia instancia=new Instancia();
		
		instancia.agregarOferta(new Oferta("Juan Albornoz",600.0,new DemandaHoraria(11,2)));//,13
		instancia.agregarOferta(new Oferta("Pablo Meirelles",1000.0,new DemandaHoraria(0,5)));//,5
		instancia.agregarOferta(new Oferta("Joaquin Del Valle",1000.0,new DemandaHoraria(0,5)));//,5
		instancia.agregarOferta(new Oferta("Jose Evaristo Mendieta",400.0,new DemandaHoraria(15,6)));//,21
		instancia.agregarOferta(new Oferta("Enrique Bochini",600.0,new DemandaHoraria(21,3)));//,24
		instancia.agregarOferta(new Oferta("Javier Marenco",1200.0,new DemandaHoraria(21,3)));//,24
		instancia.agregarOferta(new Oferta("Patricia Heiner",600.0,new DemandaHoraria(11,2)));//,13
		
		return instancia;
	}
	
	public static Instancia instanciaEjemploDos(){
		Instancia instancia=new Instancia();
		
		instancia.agregarOferta(new Oferta("Juan Alboran",200.0,new DemandaHoraria(5,5)));//,10
		instancia.agregarOferta(new Oferta("Ernesto Bauman",100.0,new DemandaHoraria(16,3)));//,19
		instancia.agregarOferta(new Oferta("Pedro Albornoz",600.0,new DemandaHoraria(0,2)));//,2
		instancia.agregarOferta(new Oferta("Cesar Pitrola",400.0,new DemandaHoraria(11,4)));//,15
		
		
		return instancia;
	}
}
