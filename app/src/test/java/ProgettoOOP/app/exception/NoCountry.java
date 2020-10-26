package ProgettoOOP.app.exception;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;


class NoCountry {
	
	private Countries testcountries1;

	@BeforeEach
	void setUp() throws Exception {
	testcountries1= new Countries ("Ital", "italy", "IT");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void tesNotValidCountry() {
		
		NotValidCountry exception= assertThrows(NotValidCountry.class, () -> {Verify(testcountries1);});
	assertTrue(exception.getMessage().contains("Nessun paese trovato!"));	
		
	}

boolean Verify(Countries test1) throws NotValidCountry{
	
	throw new NotValidCountry();
}

		
	}

