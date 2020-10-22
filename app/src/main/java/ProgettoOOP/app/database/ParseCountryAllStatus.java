package ProgettoOOP.app.database;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import ProgettoOOP.app.model.CountryAllStatus;

public final class ParseCountryAllStatus {
	public static List<CountryAllStatus> data_all=new LinkedList<>();
	    public static List<CountryAllStatus> ParseDataCountryAllStatus() throws FileNotFoundException,IOException {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        String from=null;
			String to=null;
			try (FileReader readerall=new FileReader(DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to)))
	        {
	            //Read JSON file
	            Object objall = jsonParser.parse(readerall);
	 
	            JSONArray CountryAllStatusList = (JSONArray) objall;
	            System.out.println(CountryAllStatusList);
	             
	       	 for (int i=0; i<CountryAllStatusList.size(); i++) {
	    		 JSONObject countryObjectall = (JSONObject) CountryAllStatusList.get(i);
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
	    			(int) countryObjectall.get("Confirmed"),	
	    			(int) countryObjectall.get("Deaths"), 
	    			(int) countryObjectall.get("Recovered"),
	    			(int) countryObjectall.get("Active"),	
	    			(String) countryObjectall.get("Date"))); 
	 	        

	    	 }
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	 
	  return data_all;

}

}







