package ProgettoOOP.app.model;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;

import ProgettoOOP.app.database.ParseCountries;
import ProgettoOOP.app.exception.Nofile;
import ProgettoOOP.app.exception.NotValidCountry;




public final class World {
	private static Map<String, Countries> world= new LinkedHashMap<>();
	private static Map<String, CountryAllStatus> all= new LinkedHashMap<>();
	private static String NameCountry;
	private static String ISOcode;
	private static int SumConfirmed=0;
	public String getNameCountry() {
		return NameCountry;
	}

	public void setNameCountry(String nameCountry) {
	NameCountry = nameCountry;
	}

	public String getISOcode() {
		return ISOcode;
	}

	public void setISOcode(String iSOcode) {
		ISOcode = iSOcode;
	}

	public int getSumConfirmed() {
		return SumConfirmed;
	}

	public void setSumConfirmed(int sumConfirmed) {
		SumConfirmed = sumConfirmed;
	}

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
	
	//Verifica se i dati inseriti sono uguali a quelli del JSONObject
	public static void Verify() {
JSONObject count=new JSONObject();
		CountryAllStatus a=new CountryAllStatus(null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
		if(world.equals(ParseCountries.parseCountryObject(count))==false) {
			throw new Nofile();
			//if(((Countries) world).getCountry()==((CountryAllStatus) all).getCountry()==true && 
				//	((Countries) world).getISO2()==((CountryAllStatus) all).getCountryCode()==true) {
					//createObject(w, a);	
		//			}
		}
		else throw new NotValidCountry();
		
	}
	
	public static void createObject(Countries createcountry,CountryAllStatus createall) {	
		NameCountry=createcountry.getCountry();
		ISOcode=createcountry.getISO2();
		SumConfirmed=sum(createall.getConfirmed());

}
	public static int sum(int a) {
		int s=0;	
		s+=a;
		return s;
		}}
