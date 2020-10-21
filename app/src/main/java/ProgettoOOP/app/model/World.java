package ProgettoOOP.app.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import ProgettoOOP.app.database.ParseCountries;

public final class World {
	private static Map<String, Countries> world = new LinkedHashMap<>();
	private static Map<String, CountryAllStatus> all = new LinkedHashMap<>();
	private static Map<String, Confirmed> conf = new LinkedHashMap<>();

	public static Map<String, CountryAllStatus> getall() {
		return all;
	}

	public static void setall(CountryAllStatus All) {
		all.put(All.getCountryCode(), All);

	}

	public static Map<String, Countries> getworld() {
		return world;
	}

	public static void setworld(Countries nation) {
		world.put(nation.getISO2(), nation);
	}

	public static void deleteworld(String ISO2) {
		world.remove(ISO2);
	}

	public static Map<String, Confirmed> getconf() {
		return conf;
	}

	public static void setconf(Confirmed cases) {
		conf.put(cases.getISO2(), cases);
	}

	
	public static String getlastslug() {
		
		String lastslug = null;
		try {
			List<Countries> CountriesArray = new ArrayList<Countries>();
			//System.out.println(CountriesArray.size());
			for (String key : world.keySet()) {
				//System.out.println("key : " + key);
				//System.out.println("value : " + world.get(key));
				CountriesArray.add(world.get(key));
			}
			lastslug = CountriesArray.get(CountriesArray.size() - 1).getSlug();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastslug;
	}

	public static String getlastname() {
		String lastcountry = null;
		try {
			List<Countries> CountriesArray = new ArrayList<Countries>();
			//System.out.println(CountriesArray.size());
			for (String key : world.keySet()) {
				//System.out.println("key : " + key);
				//System.out.println("value : " + world.get(key));
				CountriesArray.add(world.get(key));
			}
			lastcountry = CountriesArray.get(CountriesArray.size() - 1).getCountry();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastcountry;
	}
	
	public static String getlastiso2() {
		String lastiso2 = null;
		try {
			List<Countries> CountriesArray = new ArrayList<Countries>();
			//System.out.println(CountriesArray.size());
			for (String key : world.keySet()) {
				//System.out.println("key : " + key);
				//System.out.println("value : " + world.get(key));
				CountriesArray.add(world.get(key));
			}
			lastiso2 = CountriesArray.get(CountriesArray.size() - 1).getISO2();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastiso2;
	}
	
public static long getlastconfirmed() {
		
		long lastconfirmed = 0;
		try {
			List<CountryAllStatus> CountryAllStatusList = new ArrayList<CountryAllStatus>();
			//System.out.println(CountryAllStatusList.size());
			for (String key : all.keySet()) {
				//System.out.println("key : " + key);
				//System.out.println("value : " + all.get(key));
				CountryAllStatusList.add(all.get(key));
			}
			lastconfirmed = CountryAllStatusList.get(CountryAllStatusList.size() - 1).getConfirmed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lastconfirmed;
	}

public static String getslug() {
	
	String lastslug = null;
	try {
		List<Countries> CountriesArray = new ArrayList<Countries>();
		//System.out.println(CountriesArray.size());
		for (String key : world.keySet()) {
			//System.out.println("key : " + key);
			//System.out.println("value : " + world.get(key));
			CountriesArray.add(world.get(key));
		}
		lastslug = CountriesArray.get(CountriesArray.size() - 1).getSlug();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return lastslug;
}
	
	
	// Verifica se i dati inseriti sono uguali a quelli del JSONObject

	public static boolean Verify(Countries c) throws Exception {
boolean bool=false;
for (Countries a : ParseCountries.ParseDataCountries()) {
	//String cod=a.getSlug();
	bool=(a.getSlug().contentEquals(c.getSlug()) && a.getCountry().contentEquals(c.getCountry()) && a.getISO2().contentEquals(c.getISO2()));
	if (bool==true) return bool;
	//System.out.println(bool);
	//a.getSlug().contentEquals(c.getSlug())
//System.out.println(c);
//System.out.println(cod);
    
    
    }
   
		return bool;

	}

}
