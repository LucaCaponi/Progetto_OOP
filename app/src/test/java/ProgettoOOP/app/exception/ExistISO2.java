package ProgettoOOP.app.exception;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;


class ExistISO2 {
	
	private Countries testcountries1 = null;
	private Countries testcountries2 = null;

	@BeforeEach
	void setUp() throws Exception {
	testcountries1= new Countries ("Italy", "italy", "IT");
	testcountries2= new Countries ("Italy", "italy", "IT");
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void tesExistingISO2() {
		
		ExistingISO2 exception= assertThrows(ExistingISO2.class, () -> {containsKey(testcountries2.getISO2());});
		assertTrue(testcountries1.getISO2().equals(testcountries2.getISO2()));
	    assertTrue(exception.getMessage().contains("Existing ISO2!"));	
		
	}

boolean containsKey(String test1) throws ExistingISO2{
	
	throw new ExistingISO2();
}

		
	}