package modelo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import logica_negocio.Oferta;
import logica_negocio.SolverGoloso;
import logica_negocio.Subconjunto;
import modelo.DAOfertas;

public class ManejadorOfertas{
	
	private  DAOfertas _dao;
	private String _jsonOfertas="src/modelo/ofertas.json";
	
	public ManejadorOfertas() throws IOException{
		_dao=new DAOfertas(_jsonOfertas);
	}
	
	public Subconjunto devuelveSolucion(Comparator<Oferta> comparador){
		
		SolverGoloso solver=new SolverGoloso(comparador,_jsonOfertas);
		Subconjunto solucion=solver.resolver();
		
		return solucion;
	}
	
	/*-- Devuelve todas las ofertas ya persistidas*/
	/*-- (no el conjunto solucion)  --*/
	public ArrayList<Oferta> obtenerOfertasPersistidas(){
		return _dao.obtenerOfertas();
	}
	
	public void agregarOferta(Oferta oferta) throws IOException{
		_dao.agregarOferta(oferta);
	}
}