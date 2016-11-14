package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import logica_negocio.DemandaHoraria;
import logica_negocio.Oferta;

public class DemandaHorariaTest {

	@Test(expected=IllegalArgumentException.class)
	public void horarioExcedidotest(){
		Oferta oferta=new Oferta("Jose Luis Perales",5000.0, new DemandaHoraria(12,15));
		assertEquals(27,oferta.getDemandaHoraria().getHoraFin());
	}
}