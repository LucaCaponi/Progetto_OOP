package ProgettoOOP.app.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;

class TestCountries {

	private Countries countries = null;

	@BeforeEach
	void setUp() throws Exception {
		countries = new Countries("Italy", "italy", "IT");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals("Italy", countries.getCountry());
		assertEquals("italy", countries.getSlug());
		assertEquals("IT", countries.getISO2());
	}

}
