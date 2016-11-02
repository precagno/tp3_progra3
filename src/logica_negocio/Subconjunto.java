package logica_negocio;

import java.util.HashSet;
import java.util.Set;

public class Subconjunto {

	//variables de instancia
	private Set<Oferta> _conjOfertas;
	private Double _dineroTotal;
	private Double _tiempoTotal;
	private static boolean [] _tiempoRequerido=new boolean[24];//horas del dia
	
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

	//asignar tiempo en un dia de 24 hrs
	public void asignarTiempo(Oferta tiempo){
		for (int i =tiempo.getDemandaHoraria().getHoraInicio(); i <tiempo.getDemandaHoraria().getHoraInicio()+tiempo.getDemandaHoraria().getTiempo(); i++){
//			System.out.println(tiempo.getDemandaHoraria().getHoraInicio()+","+(tiempo.getDemandaHoraria().getHoraInicio()+tiempo.getDemandaHoraria().getTiempo()));
			_tiempoRequerido[i]=true;
		}
		
	}
	//previene una superposicion horaria de asignacion en un periodo de 24hrs
	public boolean superposicionHoraria(Oferta otra){
		for (int i =otra.getDemandaHoraria().getHoraInicio(); i <otra.getDemandaHoraria().getHoraInicio()+otra.getDemandaHoraria().getTiempo(); i++){
//			System.out.println(otra.getDemandaHoraria().getHoraInicio()+","+(otra.getDemandaHoraria().getHoraInicio()+otra.getDemandaHoraria().getTiempo()));
			if(getTiempoRequerido()[i]==true){
//				System.out.println(getTiempoRequerido()[i]);
				return true;
			}
		}
		return false;
	}
	
	//lectura protegida
	public static boolean[] getTiempoRequerido(){
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
				+ ", dinero total= $" + _dineroTotal + ", tiempoTotal="
				+ _tiempoTotal + "]";
	}
	
	
	
	
	//             prueba solamente de codigo
	public static void mostrarArreglo(boolean[] tiempoRequerido){//ingresa un arreglo por parametro
		System.out.print("[");
		for (int i = 0; i < tiempoRequerido.length; i++){//se recorre el arreglo
			System.out.print("("+tiempoRequerido[i]+"),");
		}
			System.out.println("]");
	}
	
	public static void main(String[] args){
		
		System.out.println("muestra arreglo inicializado");		
		mostrarArreglo(getTiempoRequerido());
		
		/**creacion de oferta*/
		DemandaHoraria dh=new DemandaHoraria(2,5,7);
		Oferta aux=new Oferta("agus", 100.0 ,dh);
		Subconjunto subConj=new Subconjunto();
		
		//se le dice al arreglo de boolean que cambie
		subConj.asignarTiempo(aux);
		System.out.println("demuestra como queda dicho arreglo luego de la asignacion");
		mostrarArreglo(getTiempoRequerido());
		
		subConj.agregarOfertas(aux);
		System.out.println("se muestra la oferta");
		System.out.println(subConj.toString());
		
		/**creacion de otra oferta*/
		//se crea la demanda horaria
		DemandaHoraria dh1=new DemandaHoraria(0,2,2);/////////esta mal revisar
		//se crea la oferta
		Oferta aux1=new Oferta("agust", 100.0 ,dh1);
		subConj.asignarTiempo(aux1);
		subConj.agregarOfertas(aux1);
		System.out.println("demuestra como queda dicho arreglo luego de las asignaciones");
		mostrarArreglo(getTiempoRequerido());
		System.out.println(subConj.toString());
		
		System.out.println("superposicion");
		System.out.println(subConj.superposicionHoraria(aux1));
	}
}
