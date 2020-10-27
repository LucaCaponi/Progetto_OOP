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
		Map<String, Long> daily = new LinkedHashMap<String, Long>();
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

			long confirmeddaily = 0;
			long deathsdaily = 0;
			long recovereddaily = 0;
			long activedaily = 0;
			
			for (int i = 0; i < countryObject.size(); i++) {	
			JSONObject countryObjectall = (JSONObject) countryObject.get(i);
				for (int j = 1; j < countryObject.size(); j++) {	
					if (i==j-1) {
				JSONObject countryObjectall2 = (JSONObject) countryObject.get(j);
					confirmeddaily = (Long) countryObjectall2.get("Confirmed") - (Long) countryObjectall.get("Confirmed");
					deathsdaily = (Long) countryObjectall2.get("Deaths") - (Long) countryObjectall.get("Deaths"); 
					recovereddaily = (Long) countryObjectall2.get("Recovered")- (Long) countryObjectall.get("Recovered");
					activedaily = (Long) countryObjectall2.get("Active")- (Long) countryObjectall.get("Active");
					daily.put("Confirmed daily", confirmeddaily);
					resultstats.put(key, daily);
					}
				}
				
				
			}
			
			
			
		
			
		}
		
		return new JSONObject(resultstats).toString();
	
	}
	

}
