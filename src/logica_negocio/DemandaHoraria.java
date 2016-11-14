package logica_negocio;

public class DemandaHoraria {

	//variables de instancia
	private int _horaInicio;
	private int _horaFin;
	private int _tiempo;
		
	//constructor
	public DemandaHoraria(int horaInicio, int tiempo)throws IllegalArgumentException{//, int horaFin
		_horaInicio=horaInicio;
		_tiempo=tiempo;
		_horaFin=horaInicio+tiempo;
		if(_horaFin > 24){
			throw new IllegalArgumentException("El horario de fin de uso va de 0 a 24hs");
		}
	}
	
	//cargado de parametros
	public void setHoraInicio(int hora){
		_horaInicio=hora;
	}
	
	public void setTiempo(int tiempo){
		_tiempo=tiempo;
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
		DemandaHoraria otra=(DemandaHoraria)obj;
		return _horaInicio==otra._horaInicio && _tiempo==otra._tiempo && _horaFin==otra._horaFin;//
	}
	
	//representacion
	@Override
	public String toString(){
		return "(hora de inicio = "+_horaInicio+"hs, hora fin = "+_horaFin+"hs , duración = "+_tiempo+"hs)";
	}
}
