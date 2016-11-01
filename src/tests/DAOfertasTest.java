package tests;

import org.junit.Test;

import logica_negocio.Oferta;
import modelo.DAOfertas;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

public class DAOfertasTest {

	@Test
	public void ListaOfertasVacia() throws IOException
	{
		DAOfertas dao=new DAOfertas("src/modelo/ofertas_vacia.json");
		
		ArrayList<Oferta> listaOfertas=dao.obtenerOfertas();
		
		assertEquals(0, listaOfertas.size());//traigo una lista vacia
	}
	
	@Test(expected=IOException.class)
	public void ArchivoInexistenteTest() throws IOException
	{
		DAOfertas dao=new DAOfertas("src/modelo/archivo_inexistente.json");
		
		ArrayList<Oferta> listaOfertas=dao.obtenerOfertas();
		
		assertEquals(0, listaOfertas.size());
	}
}
