package logica_negocio;

import java.util.HashSet;
import java.util.Set;

public class Subconjunto {

	//variables de instancia
	private Set<Oferta> _conjOfertas;
	private Double _dineroTotal;
	private Double _tiempoTotal;
	private boolean [] _tiempoRequerido;
	
	//constructor
	public Subconjunto(){
		_conjOfertas=new HashSet<Oferta>();
		_dineroTotal=0.0;
		_tiempoTotal=0.0;
		_tiempoRequerido=new boolean[24];//horas del dia
	}
	
	//agregar elementos
	public void agregarOfertas(Oferta oferta){
//		if(!oferta.getFranjaHoraria().superposicionHoraria(otraFranja)) aun no c con q compararlo
		_dineroTotal+=oferta.getDinero();//peso total O(1)
		_tiempoTotal+=oferta.getDemandaHoraria().getTiempo();//O(1)
		_conjOfertas.add(oferta);
	}
	
	//agregar elementos
	public void quitarOfertas(Oferta oferta){
//		if(!oferta.getFranjaHoraria().superposicionHoraria(otraFranja)) aun no c con q compararlo
		_dineroTotal-=oferta.getDinero();//peso total O(1)
		_tiempoTotal-=oferta.getDemandaHoraria().getTiempo();//O(1)
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

	//chequea sí una hora(tomando su indice)  
	//fue ocupada por alguna oferta
	public boolean horaOcupada(int indiceHora){
		return _tiempoRequerido[indiceHora]==true;
	}
	
	//asignar tiempo en un dia de 24 hrs
	public void asignarTiempo(Oferta tiempo){
		for (int i =tiempo.getDemandaHoraria().getHoraInicio(); i <tiempo.getDemandaHoraria().getHoraInicio()+tiempo.getDemandaHoraria().getTiempo(); i++){
			_tiempoRequerido[i]=true;
		}
		
	}
	
	//previene una superposicion horaria de asignacion en un periodo de 24hrs
	public boolean superposicionHoraria(Oferta otra){
		for (int i =otra.getDemandaHoraria().getHoraInicio(); i <otra.getDemandaHoraria().getHoraInicio()+otra.getDemandaHoraria().getTiempo(); i++){
			if(horaOcupada(i)==true){//con true es mas explicito (marenco producciones)
				return true;
			}
		}
		return false;
	}
	
	//lectura protegida
	public boolean[] getTiempoRequerido(){
		return _tiempoRequerido;
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
	private boolean contieneOferta(Oferta oferta) {
		return _conjOfertas.contains(oferta);
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
		return "Subconjunto [conjunto de Ofertas=" + _conjOfertas
				+ ", dinero total= $" + _dineroTotal + ", tiempoTotal= Hrs"
				+ _tiempoTotal + "]";
	}
	
	// prueba de codigo solamente, muestra q tan ocupara esta la grilla horaria
	public void mostrarHorasAlquiler(){//ingresa un arreglo por parametro
		System.out.print("[");
		for (int i = 0; i < _tiempoRequerido.length; i++){//se recorre el arreglo
			
			System.out.print(i+"hs: "+_tiempoRequerido[i]+" , ");
		}
			System.out.println("]");
	}
}
