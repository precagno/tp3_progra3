package logica_negocio;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import modelo.DAOfertas;
import modelo.ManejadorArchivos;
import tests.InstanciaEjemplo;


public class SolverGolosoTest {

	private String _jsonOfertas="src/modelo/ofertas_test.json";
	
	@Before
	@After
	public void eliminarOfertas() throws IOException
	{
		ManejadorArchivos.borrarOfertas(_jsonOfertas);
	}
	
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
	
	@Test
	public void resolverTest() throws IOException 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porTiempo());
		
		@SuppressWarnings("unused")
		DAOfertas dao=new DAOfertas(_jsonOfertas);
		
		solver.setNombreArchivo(_jsonOfertas);
		
		Subconjunto solucion=solver.resolver();
		
		assertEquals(0,solucion.getCantOfertas());
		
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(0));
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(1));
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(2));
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(3));
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(4));
//		dao.agregarOferta(InstanciaEjemplo.instanciaEjemploUno().getOferta(5));
//		
//		solucion=solver.resolver();
//		
//		System.out.println(solucion);
//		
//		assertEquals(4,solucion.getCantOfertas());	
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