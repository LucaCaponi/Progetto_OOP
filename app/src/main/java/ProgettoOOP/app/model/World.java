package ProgettoOOP.app.model;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import ProgettoOOP.app.database.ParseCountries;
import ProgettoOOP.app.exception.NotValidCountry;






public final class World {
	private static Map<String, Countries> world= new LinkedHashMap<>();
	private static Map<String, CountryAllStatus> all= new LinkedHashMap<>();
	private static Map<String, Confirmed> conf= new LinkedHashMap<>();

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
		/*try { Object[] WorldArray = world.values().;
		return WorldArray[WorldArray.length-1].getSlug(); }
		catch (Exception e) {
			e.printStackTrace();
			return "";
		}*/
		String lastslug = null;
		try { List<Countries> CountriesArray = new ArrayList<Countries>();
		System.out.println(CountriesArray.size());
		for (String key: world.keySet()) {
		    System.out.println("key : " + key);
		    System.out.println("value : " + world.get(key));
		    CountriesArray.add(world.get(key));
		    } 
		lastslug=CountriesArray.get(CountriesArray.size()-1).getSlug(); }
		catch (Exception e) {
			e.printStackTrace();
		}
		return lastslug;
	}
	
	public static String getlastname() {
		String lastcountry = null;
		try { List<Countries> CountriesArray = new ArrayList<Countries>();
		System.out.println(CountriesArray.size());
		for (String key: world.keySet()) {
		    System.out.println("key : " + key);
		    System.out.println("value : " + world.get(key));
		    CountriesArray.add(world.get(key));
		    } 
		lastcountry=CountriesArray.get(CountriesArray.size()-1).getCountry(); }
		catch (Exception e) {
			e.printStackTrace();
		}
		return lastcountry;
	}
	//Verifica se i dati inseriti sono uguali a quelli del JSONObject
	/*
	public static void Verify() {
		CountryAllStatus a=new CountryAllStatus(null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
		org.json.simple.JSONObject cntryfull;
		JSONObject cntryempty = new JSONObject();
		int i=0;
		while(i<((Map<String, Countries>) ParseCountries.parseCountryObject(cntryfull)).size()||world.containsValue((ParseCountries.parseCountryObject(cntryempty)))==false) 
		{
		cntryempty = (JSONObject) ParseCountries.parseCountryObject(cntryfull.get(i));
		i++;
			//if(((Countries) world).getCountry()==((CountryAllStatus) all).getCountry()==true && 
				//	((Countries) world).getISO2()==((CountryAllStatus) all).getCountryCode()==true) {
					//createObject(w, a);
		//			}
		}
		throw new NotValidCountry();
	}
	*/

}
