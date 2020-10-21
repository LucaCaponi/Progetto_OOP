package ProgettoOOP.app.database;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;


public class DatabaseCountryAllStatus {
	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
		Map<String, Countries> world =World.getworld();
		Map<String, Object> out =new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();
		for (String key : world.keySet()) {
			String slug=world.get(key).getSlug();
			String nomeurl= "https://api.covid19api.com/country/"+slug+"?from="+from+"&to="+to;
			
			/*
				int readerCountryAllStatus = 0;
				File CountryAllStatus =new File("CountryAllStatus.json");

				FileOutputStream FSCountryAllStatus = new FileOutputStream(CountryAllStatus);
				
				URL countryallstatusURL = new URL(nomeurl+World.getlastslug()+"?from="+from+"&to="+to);

				URLConnection URLConn = countryallstatusURL.openConnection();

				InputStream inputCountryAllStatus = URLConn.getInputStream();

				while ((readerCountryAllStatus=inputCountryAllStatus.read())!=-1){
		         FSCountryAllStatus.write(readerCountryAllStatus);
				}
				

				inputCountryAllStatus.close();
				FSCountryAllStatus.close();
				*/
			
				try { 
				URL oracle = new URL(nomeurl);
				URLConnection URLConn = oracle.openConnection();
				
				BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
				
				String inputLine;
				String outputLine = "";
				
				while ((inputLine = in.readLine()) != null)
					outputLine = outputLine + inputLine;
				in.close();
				out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
		}
		return new JSONObject(out).toString();
		}
}
