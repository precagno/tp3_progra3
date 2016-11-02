package logica_negocio;

//import java.math.BigDecimal;    hay un problema de comparacion y otras cosas que tuve que regresar a Double

public class Oferta {
	
	//variables de instancia
	private String _oferente;
	//private BigDecimal _dinero = new BigDecimal("1.00");  despues lo vemos
	private Double _dinero;
	private DemandaHoraria _demandaHoraria;
	
	//constructor
	public Oferta(String nombre, Double dinero, DemandaHoraria demandaHoraria){//Double beneficio
		_oferente=nombre;
		_dinero=dinero;
		_demandaHoraria=demandaHoraria;
	}
	
	//cargado de parametros
	public void setOferente(String nombre){
		_oferente = nombre;
	}

	public void setDinero(Double dinero){
		_dinero = dinero;
	}

	public void setDemandaHoraria(DemandaHoraria demandaHoraria) {
		this._demandaHoraria = demandaHoraria;
	}
	
	//lectura protegida
	public String getOferente(){
		return _oferente;
	}

	public Double getDinero(){
		return _dinero;
	}
	
	public DemandaHoraria getDemandaHoraria() {
		return _demandaHoraria;
	}
	
	//equals
	@Override
	public boolean equals(Object obj){
		if(this==obj){
			return true;
		}
		if(obj==null){
			return false;
		}
		if(getClass()!=obj.getClass()){
			return false;
		}
		Oferta otro=(Oferta)obj;
		if(_oferente==null&&otro._oferente!=null){
			return false;
		}
		else if(!_oferente.equals(otro._oferente)){
			return false;
		}
		if(_dinero==null&&otro._dinero!=null){
			return false;
		}
		else if(!_dinero.equals(otro._dinero)){
			return false;
		}
		if(_demandaHoraria==null&&otro._demandaHoraria!=null){//se apoya en el equals de franjaHoraria
			return false;
		}
		else if(!_demandaHoraria.equals(otro._demandaHoraria)){//incluye todos los parametros de franja horaria
			return false;                                    
		}
		return true;
	}
	
	//representacion
	@Override
	public String toString(){
		return "Oferta [nombre=" + _oferente + ", dinero = $" + _dinero + ", demandaHoraria=" + _demandaHoraria + "]";
	}
}
