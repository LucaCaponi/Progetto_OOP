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
 			for (String key : world.keySet()) {
 				CountriesArray.add(world.get(key));
 			}
 			lastcountry = CountriesArray.get(CountriesArray.size() - 1).getCountry();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return lastcountry;
 	}

	
	public static String getlastISO2() {
 		String lastiso2 = null;
 		try {
 			List<Countries> CountriesArray = new ArrayList<Countries>();
 			for (String key : world.keySet()) {
 				CountriesArray.add(world.get(key));
 			}
 			lastiso2 = CountriesArray.get(CountriesArray.size() - 1).getISO2();
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return lastiso2;
 	}
	
	
	public static Countries getlastcountries() {
 		Countries state = new Countries(null, null, null);
 		try {
 			List<Countries> CountriesArray = new ArrayList<Countries>();
 			for (String key : world.keySet()) {
 				CountriesArray.add(world.get(key));
 			}
 			String lc=   CountriesArray.get(CountriesArray.size() - 1).getCountry();
 			String ls=  CountriesArray.get(CountriesArray.size() - 1).getSlug();
 			String li = CountriesArray.get(CountriesArray.size() - 1).getISO2();
 		
 		state=new Countries(lc, ls, li);
 			
 		} catch (Exception e) {
 			e.printStackTrace();
 		}
 		return state;
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
