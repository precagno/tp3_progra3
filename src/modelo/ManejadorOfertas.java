package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import logica_negocio.Oferta;
import logica_negocio.SolverGoloso;
import logica_negocio.Solucion;
import modelo.DAOfertas;

public class ManejadorOfertas{
	
	//constructor
	private static DAOfertas _dao;
	private static String _jsonOfertas="src/modelo/ofertas.json";
	
	//getter de instancia
	private static DAOfertas getInstanciaDAO() throws IOException{
		if(_dao==null){
			_dao=new DAOfertas(_jsonOfertas);
		}
		
		return _dao;
	}
	
	/*-- Devuelve todas las ofertas ya persistidas*/
	/*-- (no el conjunto solucion)  --*/
	public ArrayList<Oferta> obtenerOfertasPersistidas() throws IOException{
		return getInstanciaDAO().obtenerOfertas();
	}
	
	//agrega ofertas a la persistencia
	public void agregarOferta(Oferta oferta) throws IOException{
		getInstanciaDAO().agregarOferta(oferta);
	}
	
	//elimina ofertas de la persistencia
	public void eliminarOfertasPersistidas() throws IOException{
		getInstanciaDAO().eliminarOfertas();
	}
	
	//retorna la posible solucion
	public Solucion devuelveSolucion(Comparator<Oferta> comparador){
		
		SolverGoloso solver=new SolverGoloso(comparador,_jsonOfertas);
		Solucion solucion=solver.resolver();
		
		return solucion;
	}
}