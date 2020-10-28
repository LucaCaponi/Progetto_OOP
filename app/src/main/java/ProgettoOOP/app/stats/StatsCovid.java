package ProgettoOOP.app.stats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

public class StatsCovid {

	
	private static Map<String, Countries> world = World.getworld();	


	public static String statistics(String from, String to) throws IOException {
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();

		for (String key : world.keySet()) {
			

			String slug = world.get(key).getSlug();
			if(slug!="") {
			String nomeurl = "https://api.covid19api.com/country/" + slug + "?from=" + from + "&to=" + to;
			
			try {
				URL info = new URL(nomeurl);
				URLConnection URLConn = info.openConnection();
				BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
				String inputLine;
				String outputLine = "";

				while ((inputLine = in.readLine()) != null)
					outputLine = outputLine + inputLine;

				in.close();

				out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));

			} catch (Exception e) {
				e.printStackTrace();
			}
			}

		}
		Map<String, Object> resultstats = new LinkedHashMap<>();
		for (String key : out.keySet()) {
			JSONArray countryObject = (JSONArray) out.get(key);
			
			Map<String, Long> daily = new LinkedHashMap<String, Long>();

			long confirmedbefore = 0;
			long confirmedafter = 0;
		
			long confirmedstart = 0;
			long confirmedlast = 0;

			
			for (int i = 0; i < countryObject.size(); i++) {
				JSONObject countryObjectall = (JSONObject) countryObject.get(i);
				
				daily.put("Confirmed daily on "+countryObjectall.get("Date"), confirmedafter-confirmedbefore);	
			    resultstats.put(key, daily);
			    
				for (int j = 0; j < countryObject.size(); j++) {
					
					JSONObject countryObjectall2 = (JSONObject) countryObject.get(j);
					
							if (j==i) {
							confirmedbefore = (Long) countryObjectall.get("Confirmed");
						}
							
						    if(j==i+1) {
							confirmedafter = (Long) countryObjectall2.get("Confirmed");
							
						}
				
							}
				
				if (i == 0) {
					confirmedstart = (Long) countryObjectall.get("Confirmed");
				}

				
				if (i == countryObject.size()-1) {
					confirmedlast = (Long) countryObjectall.get("Confirmed");
				}
			   
				double varperc=(((confirmedafter-confirmedbefore)*countryObject.size()-(confirmedlast-confirmedstart))/(confirmedlast-confirmedstart))*100;
				
						}
			
			
		}	
			
		
		return new JSONObject(resultstats).toString();
	
	}
	
	

	}
