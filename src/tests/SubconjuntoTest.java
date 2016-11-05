package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;
import logica_negocio.Subconjunto;

public class SubconjuntoTest {

	@Test
	public void asignarTiempotest(){
		Subconjunto subconjunto=new Subconjunto();
		
		assertFalse(subconjunto.horaOcupada(11));
		assertFalse(subconjunto.horaOcupada(12));
		
		Oferta oferta=listaOfertas().get(0);
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		assertTrue(subconjunto.horaOcupada(11));
		assertTrue(subconjunto.horaOcupada(12));
	}
	
	@Test
	public void asignarTiempoBordetest(){
		Subconjunto subconjunto=new Subconjunto();
		
		assertFalse(subconjunto.horaOcupada(0));
		assertFalse(subconjunto.horaOcupada(1));
		
		
		Oferta oferta=listaOfertas().get(1);
	
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		assertTrue(subconjunto.horaOcupada(0));
		assertTrue(subconjunto.horaOcupada(1));
		
		assertFalse(subconjunto.horaOcupada(21));
		assertFalse(subconjunto.horaOcupada(22));
		assertFalse(subconjunto.horaOcupada(23));
		
		Oferta oferta2=listaOfertas().get(4);
		
		subconjunto.agregarOfertas(oferta2);
		subconjunto.asignarTiempo(oferta2);
		
		assertTrue(subconjunto.horaOcupada(21));
		assertTrue(subconjunto.horaOcupada(22));
		assertTrue(subconjunto.horaOcupada(23));
	}
	
	@Test
	public void superposicionHorariatest(){
		Subconjunto subconjunto=new Subconjunto();
	
		Oferta oferta=listaOfertas().get(0);
	
		assertFalse(subconjunto.superposicionHoraria(oferta));
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		Oferta oferta2=listaOfertas().get(6);
		
		assertTrue(subconjunto.superposicionHoraria(oferta2));
	}
	
	@Test
	public void superposicionHorariaBordetest(){
		Subconjunto subconjunto=new Subconjunto();
	
		Oferta oferta=listaOfertas().get(1);
	
		assertFalse(subconjunto.superposicionHoraria(oferta));
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		Oferta oferta2=listaOfertas().get(2);
		
		assertTrue(subconjunto.superposicionHoraria(oferta2));
	}
	
	private ArrayList<Oferta> listaOfertas(){
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