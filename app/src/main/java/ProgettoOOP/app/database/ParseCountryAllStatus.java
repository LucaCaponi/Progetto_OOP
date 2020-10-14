package ProgettoOOP.app.database;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseCountryAllStatus {

	@SuppressWarnings("unchecked")
	    public static void ParseDataCountryAllStatus() throws IOException
	    {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader readerall = new FileReader("CountryAllStatus.json"))
	        {
	            //Read JSON file
	            Object objall = jsonParser.parse(readerall);
	 
	            JSONArray CountryAllStatusList = (JSONArray) objall;
	            System.out.println(CountryAllStatusList);
	             
	            //Iterate over Country array
	            CountryAllStatusList.forEach( cntryall -> parseCountryObject( (JSONObject) cntryall ) );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    private static void parseCountryObject(JSONObject countryallstatus) 
	    {
	    	 //Get country object within list
	        //JSONObject countryObject = (JSONObject) country.get("");
	         
	        //Get countryallstatus Country
	        String Country = (String) countryallstatus.get("Country");    
	         
	        //Get countryallstatus CountryCode
	        String CountryCode = (String) countryallstatus.get("CountryCode");  
	         
	        //Get countryallstatus Province
	        String Province = (String) countryallstatus.get("Province");    
	        
	        //Get countryallstatus City
	        String City = (String) countryallstatus.get("City");    
	         
	        //Get countryallstatus CityCode
	        String CityCode = (String) countryallstatus.get("CityCode");  
	         
	        //Get countryallstatus Lat
	        double Lat = Double.parseDouble((String) countryallstatus.get("Lat"));    
	        
	        //Get countryallstatus Lon
	        double Lon = Double.parseDouble((String) countryallstatus.get("Lon"));    
	         
	        //Get countryallstatus Confirmed
	        long Confirmed = (long) countryallstatus.get("Confirmed");  
	         
	        //Get countryallstatus Deaths
	        long Deaths = (long) countryallstatus.get("Deaths");  
	        
	        //Get countryallstatus Recovered
	        long Recovered = (long) countryallstatus.get("Recovered");  
	         
	        //Get countryallstatus Active
	        long Active = (long) countryallstatus.get("Active");  
	     
	        //Get countryallstatus Date
	        String Date = (String) countryallstatus.get("Date");    
	        
	    }

}
