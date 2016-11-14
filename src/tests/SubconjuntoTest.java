package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import logica_negocio.Oferta;
import logica_negocio.Subconjunto;

public class SubconjuntoTest {

	@Test
	public void asignarTiempotest(){
		Subconjunto subconjunto=new Subconjunto();
		
		assertFalse(subconjunto.horaOcupada(11));
		assertFalse(subconjunto.horaOcupada(12));
		
		Oferta oferta=InstanciaEjemplo.instanciaEjemploUno().getOferta(0);
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		assertTrue(subconjunto.horaOcupada(11));
		assertTrue(subconjunto.horaOcupada(12));
	}
	
	@Test
	public void asignarTiempoBordetest(){
		Subconjunto subconjunto=new Subconjunto();
		
		assertFalse(subconjunto.horaOcupada(0));
		assertFalse(subconjunto.horaOcupada(1));
		
		Oferta oferta=InstanciaEjemplo.instanciaEjemploUno().getOferta(1);
	
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		assertTrue(subconjunto.horaOcupada(0));
		assertTrue(subconjunto.horaOcupada(1));
		
		assertFalse(subconjunto.horaOcupada(21));
		assertFalse(subconjunto.horaOcupada(22));
		assertFalse(subconjunto.horaOcupada(23));
		
		Oferta oferta2=InstanciaEjemplo.instanciaEjemploUno().getOferta(4);
		
		subconjunto.agregarOfertas(oferta2);
		subconjunto.asignarTiempo(oferta2);
		
		assertTrue(subconjunto.horaOcupada(21));
		assertTrue(subconjunto.horaOcupada(22));
		assertTrue(subconjunto.horaOcupada(23));
	}
	
	@Test
	public void superposicionHorariatest(){
		Subconjunto subconjunto=new Subconjunto();
	
		Oferta oferta=InstanciaEjemplo.instanciaEjemploUno().getOferta(0);
	
		assertFalse(subconjunto.superposicionHoraria(oferta));
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		Oferta oferta2=InstanciaEjemplo.instanciaEjemploUno().getOferta(6);
		
		assertTrue(subconjunto.superposicionHoraria(oferta2));
	}
	
	@Test
	public void superposicionHorariaBordetest(){
		Subconjunto subconjunto=new Subconjunto();
	
		Oferta oferta=InstanciaEjemplo.instanciaEjemploUno().getOferta(1);
	
		assertFalse(subconjunto.superposicionHoraria(oferta));
		
		subconjunto.agregarOfertas(oferta);
		subconjunto.asignarTiempo(oferta);
		
		Oferta oferta2=InstanciaEjemplo.instanciaEjemploUno().getOferta(2);
		
		assertTrue(subconjunto.superposicionHoraria(oferta2));
	}
}