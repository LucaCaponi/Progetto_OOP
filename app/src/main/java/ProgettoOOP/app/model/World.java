package ProgettoOOP.app.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class World {
	private static Map<String, Countries> world= new LinkedHashMap<>();

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
}
