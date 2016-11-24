package logica_negocio;

import java.util.ArrayList;


public class Solucion {

	//variables de instancia
	private ArrayList<Oferta> _ofertas;
	private Double _dineroTotal;
	private Double _tiempoTotal;
	private boolean [] _tiempoRequerido;
	
	//constructor
	public Solucion(){
		_ofertas=new ArrayList<Oferta>();
		_dineroTotal=0.0;
		_tiempoTotal=0.0;
		_tiempoRequerido=new boolean[24];//horas del dia
	}
	
	//agregar oferta
	public void agregarOfertas(Oferta oferta){
		_dineroTotal+=oferta.getDinero();//peso total O(1)
		_tiempoTotal+=oferta.getDemandaHoraria().getTiempo();//O(1)
		_ofertas.add(oferta);
	}
	
	//quitar oferta
	public void quitarOfertas(Oferta oferta){
		_dineroTotal-=oferta.getDinero();//peso total O(1)
		_tiempoTotal-=oferta.getDemandaHoraria().getTiempo();//O(1)
		_ofertas.remove(oferta);
	}
	
	//mejor ganancia entre soluciones
	public boolean mayorDineroQue(Solucion otro){
		return this.getDineroTotal()>otro.getDineroTotal();
	}
		
	//lectura protegida
	public Double getDineroTotal(){
		return _dineroTotal;
	}
	
	//mejor tiempo entre soluciones
	public boolean mayorTiempoQue(Solucion otro){
		return this.getTiempoTotal()>otro.getTiempoTotal();
	}
	
	//lectura protegida
	public Double getTiempoTotal(){
		return _tiempoTotal;
	}

	//chequea s� una hora(tomando su indice)  
	//fue ocupada por alguna oferta
	public boolean horaOcupada(int indiceHora){
		return _tiempoRequerido[indiceHora]==true;
	}
	
	//asignar tiempo en un dia de 24 hrs
	public void asignarTiempo(Oferta oferta){
		for (int i =oferta.getDemandaHoraria().getHoraInicio(); i <oferta.getDemandaHoraria().getHoraInicio()+oferta.getDemandaHoraria().getTiempo(); i++){
			
			_tiempoRequerido[i]=true;
		}
	}
	
	//previene una superposicion horaria de asignacion en un periodo de 24hrs
	public boolean superposicionHoraria(Oferta otraOferta){
		
		int horaInicio=otraOferta.getDemandaHoraria().getHoraInicio();
		int horaFin=otraOferta.getDemandaHoraria().getHoraFin();
		
		for (int i=horaInicio; i < horaFin; i++){
			
			boolean ocupada=horaOcupada(i)==true;
			
			if(ocupada){
				return true;
			}
		}
		
		return false;
	}
	
	//lectura protegida
	public boolean[] getTiempoRequerido(){
		return _tiempoRequerido;
	}
	
	//compara igualdad
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
			
		Solucion otro = (Solucion) obj;
		if(this.getCantOfertas()!=otro.getCantOfertas()){
			return false;
		}
			
		for(Oferta oferta:_ofertas){
			if(!otro.contieneOferta(oferta)){
				return false;
			}
		}
		return true;
	}
	
	//asegura contencion
	public boolean contieneOferta(Oferta oferta) {
		return _ofertas.contains(oferta);
	}

	//cant de ofertas del solucion
	public int getCantOfertas() {
		return _ofertas.size();
	}
	
	//clonar un conjunto
	public Solucion clonar(){
		Solucion aux=new Solucion();
		for (Oferta oferta : _ofertas) {
			aux.agregarOfertas(oferta);
		}
		return aux;
	}
	
	//representacion
	@Override
	public String toString()
	{	
		String cadena="solucion de ofertas: \n\n";
		
		for(Oferta oferta:_ofertas){
			cadena+=oferta.toString();
		}
		
		return cadena;
	}
	
	// prueba de codigo solamente, muestra q tan ocupara esta la grilla horaria
	public void mostrarHorasAlquiler(){//ingresa un arreglo por parametro
		System.out.print("[");
		for (int i = 0; i < _tiempoRequerido.length; i++){//se recorre el arreglo
			
			System.out.print(i+"hs: "+_tiempoRequerido[i]+" , ");
		}
			System.out.println("]");
	}

	public Oferta getOferta(int indice) {
		return _ofertas.get(indice);
	}
}
