package ProgettoOOP.app.exception;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe TestNotValidCountry serve per testare l'eccezione
 *         'NotValidCountry'
 *
 */

class TestNotValidCountry {

	private Countries testcountries1 = null;

	@BeforeEach
	void setUp() throws Exception {
		testcountries1 = new Countries("Itly", "italy", "ITa"); // oggetto di tipo 'Countries' volutamente settato in
																// modo errato per testare l'eccezione

	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testNotValidCountry() {

		NotValidCountry exception = assertThrows(NotValidCountry.class, () -> {
			VerifyCountry(testcountries1);
		});
		assertTrue(exception.getMessage().contains("Nessun paese trovato!"));

	}

	String VerifyCountry(Countries test1) throws NotValidCountry, Exception {
		if (World.Verify(test1) == true)
			return "Nessuna eccezione: test fallito!";
		else
			throw new NotValidCountry();
	}

}
