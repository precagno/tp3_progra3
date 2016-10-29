package logica_negocio;

public interface Solver {
	
	//toda clase que implemente Solver debera aderir a este metodo
	public Subconjunto resolver(Instancia instancia);
}
