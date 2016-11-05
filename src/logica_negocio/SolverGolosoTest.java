package logica_negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import tests.InstanciaEjemplo;


public class SolverGolosoTest {

	@Test
	public void ordenarPorTiempoTest() 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porTiempo());
		Instancia instancia=InstanciaEjemplo.instanciaEjemploDos();
		ArrayList<Oferta> listaOfertasOrdenada=solver.ordenarOfertas(instancia);
		
		//(Pedro Albornoz,Ernesto Bauman,Cesar Pitrola,Juan Alboran)
		assertEquals(instancia.getOferta(2).getOferente(),listaOfertasOrdenada.get(0).getOferente());
		assertEquals(instancia.getOferta(1).getOferente(),listaOfertasOrdenada.get(1).getOferente());
		assertEquals(instancia.getOferta(3).getOferente(),listaOfertasOrdenada.get(2).getOferente());
		assertEquals(instancia.getOferta(0).getOferente(),listaOfertasOrdenada.get(3).getOferente());	
	}
	
	@Test
	public void ordenarPorCocienteTest() 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porCociente());
		Instancia instancia=InstanciaEjemplo.instanciaEjemploDos();
		ArrayList<Oferta> listaOfertasOrdenada=solver.ordenarOfertas(instancia);
		
		//(Ernesto Bauman,Juan Alboran,Cesar Pitrola,Pedro Albornoz)
		assertEquals(instancia.getOferta(1).getOferente(),listaOfertasOrdenada.get(0).getOferente());
		assertEquals(instancia.getOferta(0).getOferente(),listaOfertasOrdenada.get(1).getOferente());
		assertEquals(instancia.getOferta(3).getOferente(),listaOfertasOrdenada.get(2).getOferente());
		assertEquals(instancia.getOferta(2).getOferente(),listaOfertasOrdenada.get(3).getOferente());	
	}
}