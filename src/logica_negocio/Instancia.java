package logica_negocio;

import java.util.ArrayList;

public class Instancia {

	//variables de instancia
	private double _tiempoMaximo;//el tiempo es de 24hrs
	private ArrayList<Oferta> _listaOfertas;
	
	//constructor
	public Instancia(){//double tiempoTotal
		_tiempoMaximo=24;//tiempoTotal 24hrs
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
	public double getTiempoMaximo(){
		return _tiempoMaximo;
	}
	
	public int getCantOfertas(){
		return _listaOfertas.size();
	}
	
	public Oferta getOferta(int indice){
		return _listaOfertas.get(indice);
	}

	@Override
	public String toString() {
		return "Instancia: tiempoMaximo =" + _tiempoMaximo + "\n "+_listaOfertas;
	}
}
