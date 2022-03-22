package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja radnja;

	@Test
	void testDodajGumu() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar123");

		radnja.dodajGumu(ag);

		assertEquals(1, radnja.vratiSveGume().size());
		assertEquals(ag, radnja.vratiSveGume().get(0));
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> radnja.dodajGumu(null));
	}

	@Test
	void testDodajGumuDuplikat() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar123");

		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Tigar123");

		assertThrows(java.lang.RuntimeException.class, () -> radnja.dodajGumu(ag2));
	}

	@Test
	void testPronadjiGumuNull() {
		assertEquals(null, radnja.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNePostoji() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar123");

		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Tigar321");
		
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Guma koja ne postoji");
		
		assertTrue(gume.isEmpty());
	}
	
	@Test
	void testPronadjiGumuPostoji() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar123");
		ag.setPrecnik(15);
		ag.setSirina(200);
		ag.setVisina(50);

		radnja.dodajGumu(ag);
		
		AutoGuma ag2 = new AutoGuma();
		ag2.setMarkaModel("Tigar123");
		ag2.setPrecnik(20);
		ag2.setSirina(250);
		ag2.setVisina(60);
		
		radnja.dodajGumu(ag2);
		
		List<AutoGuma> gume = radnja.pronadjiGumu("Tigar123");
		
		assertEquals(2, gume.size());
		assertEquals(ag, gume.get(1));
		assertEquals(ag2, gume.get(0));
	}

	@Test
	void testVratiSveGume() {
		AutoGuma ag = new AutoGuma();
		ag.setMarkaModel("Tigar123");

		radnja.dodajGumu(ag);
		
		List<AutoGuma> gume = radnja.vratiSveGume();
		
		assertEquals(1, gume.size());
		assertEquals(ag, gume.get(0));
	}

}
