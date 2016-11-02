package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;
import modelo.DAOfertas;
import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOfertasTest {

	private String jsonOfertas="src/modelo/ofertas.json";
	private String jsonOfertasVacia="src/modelo/ofertas_vacia.json";
	private String jsonOfertasInexistente="src/modelo/ofertas_inexistente.json";
	
	@Before
	@After
	public void eliminarOfertas() throws IOException
	{
		this.borrarOfertas(this.jsonOfertas);
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
	
	/*---- Métodos auxiliares ----*/
	private void borrarOfertas(String nombreArchivo) throws IOException
	{
		BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo));
		escritor.write("");
		escritor.close();
	}
	
	private ArrayList<Oferta> listaOfertas()
	{
		ArrayList<Oferta> listaOfertas=new ArrayList<Oferta>();
		
		listaOfertas.add(new Oferta("Pedro Granes",900.0, new DemandaHoraria(0,3,18)));
		listaOfertas.add(new Oferta("Eduardo Cicuti",200.0, new DemandaHoraria(5,4,9)));
		listaOfertas.add(new Oferta("Armando Renya",800.0, new DemandaHoraria(10,7,17)));
		
		return listaOfertas;
	}
}
