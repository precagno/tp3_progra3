package logica_negocio;

public interface Solver {
	
	/**toda clase que implemente Solver debera adherir 
	 * a esta interfaz implementando los siguientes metodos
	 * @param instancia*/
	
	public Subconjunto resolver(Instancia instancia);
}
