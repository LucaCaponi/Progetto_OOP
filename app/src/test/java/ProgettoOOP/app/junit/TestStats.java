package ProgettoOOP.app.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ProgettoOOP.app.stats.Stats;

class TestStats {

	private Stats stats = null;

	@BeforeEach
	void setUp() throws Exception {
		stats = new Stats("2020-03-01T00:00:00Z", 1000, "50%");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		assertEquals("2020-03-01T00:00:00Z", stats.getDate());
		assertEquals(1000, stats.getDailyConfirmed());
		assertEquals("50%", stats.getVar());
	}

}
