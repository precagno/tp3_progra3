package logica_negocio;

public interface Solver {
	
	/**toda clase que implemente Solver debera aderir 
	 * a esta interfaz implementando este metodo
	 * @param instancia*/
	
	public Subconjunto resolver(Instancia instancia);
}
