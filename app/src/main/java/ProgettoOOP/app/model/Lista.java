package ProgettoOOP.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import ProgettoOOP.app.database.Database;

	public class Lista extends Database {

		public static List<Countries> getCountries(Database data) {

			Countries c = null;
			List<Countries> lc = new ArrayList<Countries>();
			if ( data.countries.size() > 0)
				for(HashMap<String,Object> hm : data.countries)
				{
					c = new Countries(null, null, null);
					c.setCountry((String)hm.get("Country"));
					c.setSlug((String)hm.get("Slug")); 
					c.setISO2((String)hm.get("ISO2"));
					lc.add(c);
				}	
			return lc;
		}
}