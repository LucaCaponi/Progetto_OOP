package ProgettoOOP.app.model;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * Nella classe World viene gestita la LinkedHashMap world 
 * che permette il caricamento dei paesi inseriti tramite Postman 
 * all'interno di una memoria dinamica
 */

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
	
	public static String getlastname() {
 		String lastcountry = null;
 		try {
 			List<Countries> CountriesArray = new ArrayList<Countries>();
 			System.out.println(CountriesArray.size());
 			for (String key : world.keySet()) {
 				System.out.println("key : " + key);
 				System.out.println("value : " + world.get(key));
 				CountriesArray.add(world.get(key));
 			}
 			lastcountry = CountriesArray.get(CountriesArray.size() - 1).getCountry();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return lastcountry;
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
