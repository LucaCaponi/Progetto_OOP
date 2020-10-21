package ProgettoOOP.app.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.CountryAllStatus;
import ProgettoOOP.app.model.World;


public class DatabaseCountryAllStatus {
	
	private static Map<String, Countries> world =World.getworld();
	private static List<CountryAllStatus> data_all =new LinkedList<>();
	
	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
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
	
	public static List<CountryAllStatus> WritingFile() throws FileNotFoundException, IOException, ParseException, JSONException
	{	
		String a=null;
		String b=null;
		for (String key : world.keySet()) {
			String country=world.get(key).getCountry();
			
		String fileJSON=DownloadDataCountryAllStatus(a, b);
		FileWriter filew = new FileWriter("AllStatus.json"); 
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(fileJSON));
		JSONObject jsonObject =  (JSONObject) parser.parse(new FileReader(fileJSON));
		JSONArray data = (JSONArray) jsonObject.get(country);

		
		try 
		{			
			for(int i = 0; i < DownloadDataCountryAllStatus(a, b).length(); i++)
			{

				JSONObject countryObjectall = (JSONObject) data.get(i);
			
				data_all.add(
						new CountryAllStatus(
						(String) countryObjectall.get("Country"),
						(String) countryObjectall.get("CountryCode"),
						(String) countryObjectall.get(""),
						(String) countryObjectall.get("Province"),
						(String) countryObjectall.get("City"),
						(String) countryObjectall.get("CityCode"),
						(double) countryObjectall.get("Lat"),
						(double) countryObjectall.get("Lon"),
						(long) countryObjectall.get("Confirmed"),
						(long) countryObjectall.get("Deaths"),
						(long) countryObjectall.get("Recovered"),
						(long) countryObjectall.get("Active"),
						(String) countryObjectall.get("Date")));
			
				filew.write(data.get(i).toString());
			}
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			} catch (IOException e) {
			e.printStackTrace();
			} 
		
		filew.flush();
		
		}
		return data_all;
	}
}
