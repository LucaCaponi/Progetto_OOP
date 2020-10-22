package ProgettoOOP.app.database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
//import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.CountryAllStatus;
import ProgettoOOP.app.model.World;

public class DatabaseCountryAllStatus {

	private static Map<String, Countries> world = World.getworld();
	private static List<CountryAllStatus> data_all = new LinkedList<>();

	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
		//map e JSONParser
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();
		
		//for each (39-60)
		for (String key : world.keySet()) {
			
			String country = world.get(key).getCountry();
			String slug = world.get(key).getSlug();
			//Riprende lo slug
			String nomeurl = "https://api.covid19api.com/country/" + slug + "?from=" + from + "&to=" + to;

			try {
				URL info = new URL(nomeurl);
				URLConnection URLConn = info.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
				String inputLine;
				String outputLine = "";

				//legge i tuoi dati
				
				while ((inputLine = in.readLine()) != null) 
					outputLine = outputLine + inputLine;			
				
				in.close();
				//riempi l'out
				out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));
			
				
				
				
				//for
				//JSONArray data = (JSONArray) jsonObject.get(country);
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		Map<String, Object> result = new LinkedHashMap<>();
		for (String key : out.keySet()) {
			JSONArray countryObject = (JSONArray) out.get(key);
			
		long confirmedstart=0;
		long deathsstart=0;
		long recoveredstart=0;
		long activestart=0;
		long confirmedlast=0;
		long deathslast=0;
		long recoveredlast=0;
		long activelast=0;
			for(int i=0; i<countryObject.size(); i++) {
				
				 JSONObject countryObjectall = (JSONObject) countryObject.get(i);
				 if (i==0) { 
					 confirmedstart=(Long) countryObjectall.get("Confirmed");
				 deathsstart=(Long) countryObjectall.get("Deaths");
					recoveredstart=(Long) countryObjectall.get("Recovered");
					activestart=(Long) countryObjectall.get("Active");}
				 
			 if (i==countryObject.size()-1) { 
				 confirmedlast=(Long) countryObjectall.get("Confirmed");
			 deathslast=(Long) countryObjectall.get("Deaths");
				recoveredlast=(Long) countryObjectall.get("Recovered");
				activelast=(Long) countryObjectall.get("Active");}
			 
				 
				 /*
				data_all.add((new CountryAllStatus(
						(String) countryObjectall.get("Country"),
						(String) countryObjectall.get("CountryCode"),
						(String) countryObjectall.get(""),
						(String) countryObjectall.get("Province"), 
						(String) countryObjectall.get("City"),
						(String) countryObjectall.get("CityCode"), 
						Double.parseDouble((String) countryObjectall.get("Lat")),
						Double.parseDouble((String)countryObjectall.get("Lon")), 
						(Long) countryObjectall.get("Confirmed"),
						(Long) countryObjectall.get("Deaths"),
						(Long) countryObjectall.get("Recovered"),
						(Long) countryObjectall.get("Active"), 
						(String)countryObjectall.get("Date"))));		
			*/
			}
			Map<String, Long> stats=new LinkedHashMap<String, Long>();
			stats.put("Confirmed", confirmedlast-confirmedstart);
			stats.put("Deaths", deathslast-deathsstart);
			stats.put("Recovered", recoveredlast-recoveredstart);
			stats.put("Active", activelast-activestart);
		result.put(key,stats);
		
		}
		
		
		
		return new JSONObject(result).toString();
	}
}
		
		
		
		
		
	


