package logica_negocio;

import java.util.HashSet;
import java.util.Set;

public class Subconjunto {

	//variables de instancia
	private Set<Oferta> _conjOfertas;
	private Double _dineroTotal;// hay q cambiar el tipo de dato bigdecimal o long
	private Double _tiempoTotal;
	
	//constructor
	public Subconjunto(){
		_conjOfertas=new HashSet<Oferta>();
		_dineroTotal=0.0;
		_tiempoTotal=0.0;
	}
	
	//agregar elementos
	public void agregarOfertas(Oferta oferta){
//		if(!oferta.getFranjaHoraria().superposicionHoraria(otraFranja)) aun no c con q compararlo
		_dineroTotal+=oferta.getDinero();//peso total O(1)
		_tiempoTotal+=oferta.getFranjaHoraria().getTiempo();//O(1)
		_conjOfertas.add(oferta);
	}
	
	//agregar elementos
	public void quitarOfertas(Oferta oferta){
//		if(!oferta.getFranjaHoraria().superposicionHoraria(otraFranja)) aun no c con q compararlo
		_dineroTotal-=oferta.getDinero();//peso total O(1)
		_tiempoTotal-=oferta.getFranjaHoraria().getTiempo();//O(1)
		_conjOfertas.remove(oferta);
	}
	
	//mejor ganancia entre subconjuntos
	public boolean mayorDineroQue(Subconjunto otro){
		return this.getDineroTotal()>otro.getDineroTotal();
	}
		
	//lectura protegida
	public Double getDineroTotal(){
		return _dineroTotal;
	}
	
	//mejor tiempo entre subconjuntos
	public boolean mayorTiempoQue(Subconjunto otro){
		return this.getTiempoTotal()>otro.getTiempoTotal();
	}
	
	//lectura protegida
	public Double getTiempoTotal(){
		return _tiempoTotal;
	}
			
	//equals
	@Override
	public boolean equals(Object obj){
		if (this == obj){
			return true;
		}
		if (obj == null){
			return false;
		}
		if (getClass() != obj.getClass()){
			return false;
		}
			
		Subconjunto otro = (Subconjunto) obj;
		if(this.getCantObjetos()!=otro.getCantObjetos()){
			return false;
		}
			
		for(Oferta oferta:_conjOfertas){
			if(!otro.contieneOferta(oferta)){
				return false;
			}
		}
		return true;
	}
	
	//asegura contencion
	private boolean contieneOferta(Oferta elem) {
		return _conjOfertas.contains(elem);
	}

	//cant de elementos del subconjunto
	private Object getCantObjetos() {
		return _conjOfertas.size();
	}
	
	//clonar un conjunto
	public Subconjunto clonar(){
		Subconjunto aux=new Subconjunto();
		for (Oferta oferta : _conjOfertas) {
			aux.agregarOfertas(oferta);
		}
		return aux;
	}
	
	//representacion
	@Override
	public String toString()
	{
		return "Subconjunto [conjuntoOfertas=" + _conjOfertas
				+ ", dinero total=" + _dineroTotal + ", tiempoTotal="
				+ _tiempoTotal + "]";
	}
}
