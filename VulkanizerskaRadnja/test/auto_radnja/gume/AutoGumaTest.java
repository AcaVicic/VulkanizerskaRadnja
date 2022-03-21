package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {

	AutoGuma ag;

	@BeforeEach
	void setUp() throws Exception {
		ag = new AutoGuma();
	}

	@AfterEach
	void tearDown() throws Exception {
		ag = null;
	}

	@Test
	void testAutoGuma() {
		ag = new AutoGuma();

		assertNotNull(ag);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		ag = new AutoGuma("Tigar123", 15, 200, 50);

		assertNotNull(ag);
		assertEquals("Tigar123", ag.getMarkaModel());
		assertEquals(15, ag.getPrecnik());
		assertEquals(200, ag.getSirina());
		assertEquals(50, ag.getVisina());
	}

	@Test
	void testSetMarkaModel() {
		ag.setMarkaModel("Tigar123");

		assertEquals("Tigar123", ag.getMarkaModel());
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> ag.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelDuzina() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setMarkaModel("Ti"));
	}

	@ParameterizedTest
	@CsvSource({ "14", "18", "21" })
	void testSetPrecnikDozvoljen(int precnik) {
		ag.setPrecnik(precnik);

		assertEquals(precnik, ag.getPrecnik());
	}

	@ParameterizedTest
	@CsvSource({ "12", "0", "23", "-5" })
	void testSetPrecnikNedozvoljen(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setPrecnik(precnik));
	}

	@ParameterizedTest
	@CsvSource({ "136", "200", "354" })
	void testSetSirinaDozvoljen(int sirina) {
		ag.setSirina(sirina);

		assertEquals(sirina, ag.getSirina());
	}

	@ParameterizedTest
	@CsvSource({ "134", "356", "0", "-100" })
	void testSetSirinaNedozvoljen(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setSirina(sirina));
	}

	@ParameterizedTest
	@CsvSource({ "26", "94", "50" })
	void testSetVisinaDozvoljen(int visina) {
		ag.setVisina(visina);

		assertEquals(visina, ag.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({ "24", "96", "0", "-45" })
	void testSetVisinaNedozvoljen(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> ag.setVisina(visina));
	}

	@Test
	void testToString() {
		ag.setMarkaModel("Tigar123");
		ag.setPrecnik(15);
		ag.setSirina(200);
		ag.setVisina(50);

		String s = ag.toString();

		assertTrue(s.contains("Tigar123"));
		assertTrue(s.contains("15"));
		assertTrue(s.contains("200"));
		assertTrue(s.contains("50"));
	}

	@ParameterizedTest
	@CsvSource({ "Tigar123, 15, 200, 50, Tigar123, 15, 200, 50, true",
			"Tigar1231, 15, 200, 50, Tigar123, 15, 200, 50, false",
			"Tigar123, 16, 200, 50, Tigar123, 15, 200, 50, false",
			"Tigar123, 15, 201, 50, Tigar123, 15, 200, 50, false",
			"Tigar123, 15, 200, 51, Tigar123, 15, 200, 50, false",
			"Tigar123, 15, 200, 50, Tigar1231, 15, 200, 50, false",
			"Tigar123, 15, 200, 50, Tigar123, 16, 200, 50, false",
			"Tigar123, 15, 200, 50, Tigar123, 15, 201, 50, false",
			"Tigar123, 15, 200, 50, Tigar123, 15, 200, 51, false", "null, 15, 200, 50, Tigar123, 15, 200, 50, false",
			"Tigar123, 15, 200, 50, null, 15, 200, 50, false" })
	void testEqualsObject(String markaModel1, int precnik1, int sirina1, int visina1, String markaModel2, int precnik2,
			int sirina2, int visina2, boolean eq) {
		ag.setMarkaModel(markaModel1);
		ag.setPrecnik(precnik1);
		ag.setSirina(sirina1);
		ag.setVisina(visina1);

		AutoGuma ag2 = new AutoGuma();

		ag2.setMarkaModel(markaModel2);
		ag2.setPrecnik(precnik2);
		ag2.setSirina(sirina2);
		ag2.setVisina(visina2);

		assertEquals(eq, ag.equals(ag2));
	}

}
