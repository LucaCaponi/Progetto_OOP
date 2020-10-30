package ProgettoOOP.app.database;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ProgettoOOP.app.model.Countries;

/**
 * 
 * Classe per il parsing dell'API "GET Countries".
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public final class ParseCountries {

	public static List<Countries> datacountry = new LinkedList<>();

	/**
	 * 
	 * @return datacountry
	 * @throws IOException
	 */
	public static List<Countries> ParseDataCountries() throws IOException {
		JSONParser jsonParser = new JSONParser();

		try (FileReader reader = new FileReader("Countries.json")) {
			Object obj = jsonParser.parse(reader);
			JSONArray CountryList = (JSONArray) obj;

			for (int i = 0; i < CountryList.size(); i++) {
				JSONObject countryObject = (JSONObject) CountryList.get(i);
				datacountry.add(new Countries((String) countryObject.get("Country"), (String) countryObject.get("Slug"),
						(String) countryObject.get("ISO2")));

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return datacountry;

	}

}
