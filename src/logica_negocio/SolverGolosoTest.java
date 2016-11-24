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
		ManejadorArchivos.borrarContenido(_jsonOfertas);
	}
	
	@Test
	public void ordenarPorTiempoTest() 
	{
		testearOrden(Comparador.porTiempo(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{0,3,1,2});
	}
	
	@Test
	public void ordenarPorCocienteTest() 
	{
		testearOrden(Comparador.porCociente(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{2,3,0,1});
	}
	
	@Test
	public void ordenarPorDineroTest() 
	{
		
		testearOrden(Comparador.porDinero(), InstanciaEjemplo.instanciaEjemploDos(),new int[]{2,3,0,1});	
	}
	
	@Test
	public void resolverTest() throws IOException 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porDinero(),_jsonOfertas);
		
		DAOfertas dao=new DAOfertas(_jsonOfertas);
		
		Solucion solucion=solver.resolver();
		
		assertEquals(0,solucion.getCantOfertas());
		
		Oferta oferta1=InstanciaEjemplo.instanciaEjemploUno().getOferta(0);
		Oferta oferta2=InstanciaEjemplo.instanciaEjemploUno().getOferta(1);
			
		dao.agregarOferta(oferta1);
		dao.agregarOferta(oferta2);

		solucion=solver.resolver();
		
		assertEquals(2,solucion.getCantOfertas());
	}
	
	@Test
	public void resolverSuperposicionTest() throws IOException 
	{
		SolverGoloso solver=new SolverGoloso(Comparador.porDinero(),_jsonOfertas);
		
		DAOfertas dao=new DAOfertas(_jsonOfertas);
		
		Solucion solucion=solver.resolver();
		
		assertEquals(0,solucion.getCantOfertas());
		
		Oferta oferta1=InstanciaEjemplo.instanciaEjemploUno().getOferta(0);
		Oferta oferta2=InstanciaEjemplo.instanciaEjemploUno().getOferta(1);
		Oferta oferta3=InstanciaEjemplo.instanciaEjemploUno().getOferta(2);
		Oferta oferta4=InstanciaEjemplo.instanciaEjemploUno().getOferta(3);
		Oferta oferta5=InstanciaEjemplo.instanciaEjemploUno().getOferta(4);
		Oferta oferta6=InstanciaEjemplo.instanciaEjemploUno().getOferta(5);
		
		dao.agregarOferta(oferta1);
		dao.agregarOferta(oferta2);
		dao.agregarOferta(oferta3);
		dao.agregarOferta(oferta4);
		dao.agregarOferta(oferta5);
		dao.agregarOferta(oferta6);

		solucion=solver.resolver();
		
		assertEquals(4,solucion.getCantOfertas());
	}
	
	/*-- Métodos auxiliares --*/
	private void testearOrden(Comparator<Oferta> comparador,Instancia inst,int[] orden){
		SolverGoloso solver=new SolverGoloso(comparador,_jsonOfertas);
		Instancia instancia=inst;
		ArrayList<Oferta> listaOfertasOrdenada=solver.ordenarOfertas(inst);
		
		for(int i=0;i<orden.length;i++){
			assertEquals(instancia.getOferta(orden[i]).getOferente(),listaOfertasOrdenada.get(i).getOferente());
		}
	}
}