package ProgettoOOP.app.exception;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe TestExistingISO2 serve per testare l'eccezione
 *         'ExistingISO2'
 *
 */
class TestExistingISO2 {

	private Countries testcountries1 = null;
	private Countries testcountries2 = null;

	@BeforeEach
	void setUp() throws Exception {
		testcountries1 = new Countries("Italy", "italy", "IT");
		testcountries2 = new Countries("Italy", "italy", "IT");
		// oggetti di tipo 'Countries' volutamente identici per testare l'eccezione
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExistingISO2() {

		ExistingISO2 exception = assertThrows(ExistingISO2.class, () -> {
			ContainsKey();
		});
		assertTrue(exception.getMessage().contains("Existing ISO2!"));

	}

	String ContainsKey() throws ExistingISO2 {
		if (testcountries1.getISO2().equals(testcountries2.getISO2()))
			throw new ExistingISO2();
		else
			return "Nessuna eccezione: test fallito!";
	}

}