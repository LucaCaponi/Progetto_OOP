package ProgettoOOP.app.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.CountryAllStatus;

class testCountryAllStatus {
	
	private CountryAllStatus countryallstatus = null;

	@BeforeEach
	void setUp() throws Exception {
		
		countryallstatus=new CountryAllStatus("Italy", "italy", "IT", "Rome", "Rome", "RM", 41.87, 12.57, 100000, 1000, 2000, 50000, "2020-03-01T00:00:00Z");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals("Italy", countryallstatus.getCountry());
		assertEquals("italy", countryallstatus.getSlug());
		assertEquals("IT", countryallstatus.getISO2());
		assertEquals("Rome", countryallstatus.getProvince());
		assertEquals("Rome", countryallstatus.getCity());
		assertEquals("RM", countryallstatus.getCityCode());
		assertEquals(41.87, countryallstatus.getLat());
		assertEquals(12.57, countryallstatus.getLon());
		assertEquals(100000, countryallstatus.getConfirmed());
		assertEquals(1000, countryallstatus.getDeaths());
		assertEquals(2000, countryallstatus.getRecovered());
		assertEquals(50000, countryallstatus.getActive());
		assertEquals("2020-03-01T00:00:00Z", countryallstatus.getDate());
	}

}
