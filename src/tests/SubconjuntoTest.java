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
		subconjunto.mostrarHorasAlquiler();
		
		Oferta oferta=listaOfertas().get(0);
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		subconjunto.mostrarHorasAlquiler();
		
		assertTrue(subconjunto.horaOcupada(11));
		assertTrue(subconjunto.horaOcupada(12));
		
	}
	
	private ArrayList<Oferta> listaOfertas(){
		ArrayList<Oferta> listaOfertas=new ArrayList<Oferta>();
		
		listaOfertas.add(new Oferta("Juan Albornoz",600.0,new DemandaHoraria(11,2,13)));
		listaOfertas.add(new Oferta("Pablo Meirelles",1000.0,new DemandaHoraria(0,5,5)));
		listaOfertas.add(new Oferta("Joaquin Del Valle",1000.0,new DemandaHoraria(0,5,5)));
		listaOfertas.add(new Oferta("Jose Evaristo Mendieta",400.0,new DemandaHoraria(15,6,21)));
		
		return listaOfertas;
	}
}
