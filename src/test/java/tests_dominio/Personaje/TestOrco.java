package tests_dominio.Personaje;

import org.junit.Assert;
import org.junit.Test;

import dominio.Asesino;
import dominio.Guerrero;
import dominio.Hechicero;
import dominio.Humano;
import dominio.Orco;

/**
 * COMPRUEBA QUE LAS HABILIDADES ORCAS FUNCIONEN CORRECTAMENTE
 */

public class TestOrco {

	@Test
	public void testGolpeDefensivoTrue() {
		Humano h = new Humano("Nicolas", new Guerrero(), 1);
		Orco o = new Orco("Hernan", new Guerrero(), 1);

		Assert.assertTrue(h.getSalud() == 105);
		if (o.habilidadRaza1(h))
			Assert.assertTrue(h.getSalud() == 95);
	}
	
	@Test
	public void testMordiscoDeVida() {
		Humano h = new Humano("Nico", 100, 100, 55, 20, 30, new Hechicero(0.2, 0.3, 1.5), 0, 1, 1);
		Orco o = new Orco("Nico", 100, 100, 80, 20, 30, new Asesino(0.2, 0.3, 1.5), 0, 1, 1);

		Assert.assertTrue(h.getSalud() == 100);
		o.incrementarSalud(100 - o.getSalud());
//		o.setSalud(100);
		if (o.habilidadRaza2(h)) {
			Assert.assertEquals(40, h.getSalud());
			Assert.assertTrue(o.getSalud() == 100);
		} else {
			Assert.assertTrue(o.getSalud() == 100);
			Assert.assertTrue(h.getSalud() == 100);
		}
	}
}
