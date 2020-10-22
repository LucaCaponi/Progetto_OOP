package ProgettoOOP.app.model;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * Nella classe World viene gestita la LinkedHashMap world 
 * che permette il caricamento dei paesi inseriti tramite Postman 
 * all'interno di una memoria dinamica
 */
import java.util.LinkedHashMap;
import java.util.Map;

import ProgettoOOP.app.database.ParseCountries;

public final class World {
	private static Map<String, Countries> world = new LinkedHashMap<>();

	public static Map<String, Countries> getworld() {
		return world;
	}

	public static void setworld(Countries nation) {
		world.put(nation.getISO2(), nation);
	}

	public static void deleteworld(String ISO2) {
		world.remove(ISO2);
	}

/**
 * 
 * Il metodo boolean Verify permette di controllare se il paese inserito esiste.
 * 
 * 
 */

	public static boolean Verify(Countries c) throws Exception {
		boolean bool = false;
		for (Countries a : ParseCountries.ParseDataCountries()) {

			bool = (a.getSlug().contentEquals(c.getSlug()) && a.getCountry().contentEquals(c.getCountry())
					&& a.getISO2().contentEquals(c.getISO2()));
			if (bool == true)
				return bool;

		}

		return bool;

	}

}
