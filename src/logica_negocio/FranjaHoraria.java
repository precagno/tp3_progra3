package logica_negocio;

public class FranjaHoraria {

	//variables de instancia
	private int _horaInicio;//aca hay que pensarlo mas, vamos a hacer horas enteras
	private int _horaFin;// o puede arrancar en mitad de horas?????
	private int _tiempo;//creo q la mejor opcion seria hacerlo long en minutos
	
	//constructor
	public FranjaHoraria(int horaInicio, int tiempo, int horaFin){
		_horaInicio=horaInicio;
		_tiempo=tiempo;
		_horaFin=horaFin;
	}
	
	//cargado de parametros
	public void setHoraInicio(int hora){
		_horaInicio=hora;
	}
	
	public void setTiempo(int tiempo){
		_tiempo=tiempo;
	}
	
	public void setHoraFin(int hora){
		_horaFin=hora;
	}
	
	//lectura protegida
	public int getHoraInicio(){
		return _horaInicio;
	}
	
	public int getTiempo(){
		return _tiempo;
	}
	
	public int getHoraFin(){
		return _horaFin;
	}
	
	// Equals de object sobreescrito (comparacion por igualdad)
	@Override
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null||getClass()!=obj.getClass()){
			return false;
		}
		FranjaHoraria otra=(FranjaHoraria)obj;
		return this._horaInicio==otra._horaInicio && this._horaFin==otra._horaFin && this._tiempo==otra._tiempo;
	}
	
	//previene una superposicion horaria de asignacion en un periodo de 24hrs
	public boolean superposicionHoraria(FranjaHoraria otraFranja){
		/*este metodo deberia entregar true si se pisan dos franjas o false si no lo hacen
		  estuve pensando como hacerlo pero aun no me sierra la idea, para evitar agregar
		  una oferta en una franja ya asignada y para despues intentar graficarla*/
		
		return false;
	}
	
//	// CompareTo esto deberia ir en comparador pero aun no inserte la franja horarria a la clase oferta
//	//@Override
//	public int compareTo(FranjaHoraria otraFranja){
//		if(this.getTiempo()< otraFranja.getTiempo()){
//			return 1;
//		}
//		if (this.getTiempo()> otraFranja.getTiempo()){
//			return -1;
//		}
//		return 0;
//	}
	
	//representacion
	@Override
	public String toString(){
		return "("+this.getHoraInicio()+"["+this.getTiempo()+" Hrs]"+this.getHoraFin()+")";
	}
}
