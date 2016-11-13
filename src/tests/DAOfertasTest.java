package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;
import modelo.DAOfertas;
import modelo.ManejadorArchivos;

public class DAOfertasTest {

	private String jsonOfertas="src/modelo/ofertas.json";
	private String jsonOfertasVacia="src/modelo/ofertas_vacia.json";
	private String jsonOfertasInexistente="src/modelo/ofertas_inexistente.json";
	
	@Before
	@After
	public void eliminarOfertas() throws IOException
	{
		ManejadorArchivos.borrarOfertas(this.jsonOfertas);
	}
	
	@Test
	public void ListaOfertasVacia() throws IOException
	{
		DAOfertas dao=new DAOfertas(this.jsonOfertasVacia);
		
		ArrayList<Oferta> listaOfertas=dao.obtenerOfertas();
		
		assertEquals(0, listaOfertas.size());
		assertNotEquals(12,listaOfertas.size());
	}
	
	@Test
	public void agregarOfertaTest() throws IOException
	{
		DAOfertas dao=new DAOfertas(this.jsonOfertas);
		
		ArrayList<Oferta> listaOfertas=dao.obtenerOfertas();
		
		assertEquals(0,listaOfertas.size());
		assertNotEquals(10,listaOfertas.size());
		
		dao.agregarOferta(this.listaOfertas().get(0));
		dao.agregarOferta(this.listaOfertas().get(1));
		dao.agregarOferta(this.listaOfertas().get(2));
		
		assertEquals(3,listaOfertas.size());
	}
	
	@Test(expected=IOException.class)
	public void ArchivoInexistenteTest() throws IOException
	{
		DAOfertas dao=new DAOfertas(this.jsonOfertasInexistente);
		
		ArrayList<Oferta> listaOfertas=dao.obtenerOfertas();
		
		assertEquals(0, listaOfertas.size());
	}
	
	/*-- M�todos auxiliares --*/
	private ArrayList<Oferta> listaOfertas()
	{
		ArrayList<Oferta> listaOfertas=new ArrayList<Oferta>();
		
		listaOfertas.add(new Oferta("Pedro Granes",900.0, new DemandaHoraria(0,3)));//,18
		listaOfertas.add(new Oferta("Eduardo Cicuti",200.0, new DemandaHoraria(5,4)));//,9
		listaOfertas.add(new Oferta("Armando Renya",800.0, new DemandaHoraria(10,7)));//,17
		
		return listaOfertas;
	}
}
