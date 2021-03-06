package ProgettoOOP.app.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ProgettoOOP.app.database.ParseCountries;

/**
 * Nella classe World viene gestita la LinkedHashMap 'world' che permette il
 * caricamento dei paesi inseriti tramite la POST in Postman all'interno di una
 * memoria dinamica. Sono presenti, inoltre, quattro metodi descritti di
 * seguito.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */

public final class World {
	private static Map<String, Countries> world = new LinkedHashMap<>();

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getworld() {
		return world;
	}
/**
 * 
 * @param nation
 */
	public static void setworld(Countries nation) {
		world.put(nation.getISO2(), nation);
	}

	/**
	 * I metodi 'getlastISO2()' , 'getlastname()' , 'getlastcountries()' servono per
	 * ottenere, rispettivamente, gli ultimi ISO2 e Country inseriti e l'ultimo
	 * oggetto caricato di tipo 'Countries'. Essi serviranno nel metodo
	 * 'returnContinent()' della classe 'Continents()'.
	 * 
	 */
	
	/**
	 * 
	 * @return lastcountry
	 */
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

	/**
	 * 
	 * @return lastiso2
	 */
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

	/**
	 * 
	 * @return state
	 */
	public static Countries getlastcountries() {
		Countries state = new Countries(null, null, null);
		try {
			List<Countries> CountriesArray = new ArrayList<Countries>();
			for (String key : world.keySet()) {
				CountriesArray.add(world.get(key));
			}
			String lc = CountriesArray.get(CountriesArray.size() - 1).getCountry();
			String ls = CountriesArray.get(CountriesArray.size() - 1).getSlug();
			String li = CountriesArray.get(CountriesArray.size() - 1).getISO2();

			state = new Countries(lc, ls, li);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return state;
	}

	/**
	 * 
	 * Il metodo boolean 'Verify' permette di controllare se il paese inserito
	 * esiste nell'API "GET Countries".
	 * 
	 * @param c
	 * @return bool
	 * @throws Exception
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
