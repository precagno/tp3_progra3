package logica_negocio;

public class DemandaHoraria {

	//variables de instancia
	private int _horaInicio;
	private int _horaFin;
	private int _tiempo;
		
	//constructor
	public DemandaHoraria(int horaInicio, int tiempo){//, int horaFin
		_horaInicio=horaInicio;
		_tiempo=tiempo;
		_horaFin=horaInicio+tiempo;
	}
	
	//cargado de parametros
	public void setHoraInicio(int hora){
		_horaInicio=hora;
	}
	
	public void setTiempo(int tiempo){
		_tiempo=tiempo;
	}
	
//	public void setHoraFin(int hora){
//		_horaFin=hora;
//	}
	
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
		DemandaHoraria otra=(DemandaHoraria)obj;
		return this._horaInicio==otra._horaInicio && this._tiempo==otra._tiempo && this._horaFin==otra._horaFin;//
	}
	
	//representacion
	@Override
	public String toString(){
		return "( inicio "+this.getHoraInicio()+"["+this.getTiempo()+" Hrs]"+" final "+this.getHoraFin()+")";
	}
}
