package logica_negocio;

import java.util.ArrayList;

public class Instancia {

	//variables de instancia
	private double _tiempoTotal;//el tiempo es de 24hrs, hay q ver si se hace con bigdecimal o long
	private ArrayList<Oferta> _listaOfertas;
	
	//constructor
	public Instancia(double tiempoTotal){
		_tiempoTotal=tiempoTotal;//seria de 24hrs creo que seria fijo, aunque quizas el usuario quiera definir otro tiempo
		_listaOfertas=new ArrayList<Oferta>();
	}
	
	//agrega elementos a la instancia
	public void agregarOferta(Oferta oferta){
		_listaOfertas.add(oferta);
	}
	
	//obtener elementos de la instancia
	@SuppressWarnings("unchecked")
	public ArrayList<Oferta> obtenerOfertas(){
		return (ArrayList<Oferta>) _listaOfertas.clone();//casteada a Array de ofertas
	}
	
	//lectura protegida
	public double getTiempoTotal(){
		return _tiempoTotal;
	}
	
	public int getCantOfertas(){
		return _listaOfertas.size();
	}
	
	public Oferta getOferta(int indice){
		return _listaOfertas.get(indice);
	}
}
