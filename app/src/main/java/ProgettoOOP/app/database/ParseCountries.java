package ProgettoOOP.app.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.Iterator;
//import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ProgettoOOP.app.model.Countries;

public final class ParseCountries{ //extends Countries{	

	//public ParseCountries(String country, String slug, String iSO2) {
		//super(country, slug, iSO2);
		// TODO Auto-generated constructor stub
	//}

	@SuppressWarnings("unchecked")
	public static void ParseDataCountries() throws IOException {
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("Countries.json")) {
			// Read JSON file
			Object obj = jsonParser.parse(reader);

			JSONArray CountryList = (JSONArray) obj;
			System.out.println(CountryList);

			// Iterate over Country array
			CountryList.forEach(cntry -> parseCountryObject((JSONObject) cntry));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public static Object parseCountryObject(JSONObject Country) {
		//Get country object within list
		//JSONObject countryObject = (JSONObject) Country.get("");
		// Get country Country
		String country;
		String slug;
		String iSO2;
 
		 country= (String) Country.get("Country");
		//System.out.println(country);
	
		// Get country Slug
		slug = (String) Country.get("Slug");
		
		// Get country ISO2
		iSO2 = (String) Country.get("ISO2");	
		Countries state=new Countries(country, slug, iSO2);
		return state;
	}
	
} 

