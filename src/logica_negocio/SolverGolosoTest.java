package logica_negocio;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Comparator;

import org.junit.Test;

import tests.InstanciaEjemplo;


public class SolverGolosoTest {

	@Test
	public void ordenarPorTiempoTest() 
	{
		testearOrden(Comparador.porTiempo(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{2,1,3,0});
	}
	
	@Test
	public void ordenarPorCocienteTest() 
	{
		testearOrden(Comparador.porCociente(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{1,0,3,2});
	}
	
	@Test
	public void ordenarPorDineroTest() 
	{
		
		testearOrden(Comparador.porDinero(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{1,0,3,2});	
	}
	
	@Test
	public void nombreNoSeteadoTest() 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porTiempo());
		
		Subconjunto solucion=solver.resolver();
		
		assertNull(solucion);
	}
	
	/*-- Métodos auxiliares --*/
	private void testearOrden(Comparator<Oferta> comparador,Instancia inst,int[] orden){
		SolverGoloso solver=new SolverGoloso(comparador);
		Instancia instancia=inst;
		ArrayList<Oferta> listaOfertasOrdenada=solver.ordenarOfertas(inst);
		
		for(int i=0;i<orden.length;i++){
			assertEquals(instancia.getOferta(orden[i]).getOferente(),listaOfertasOrdenada.get(i).getOferente());
		}
	}
}