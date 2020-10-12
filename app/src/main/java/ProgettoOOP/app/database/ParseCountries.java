package ProgettoOOP.app.database;


	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.IOException;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;
	import org.json.simple.parser.JSONParser;
	import org.json.simple.parser.ParseException;


	 
	public class ParseCountries 
	{
	    @SuppressWarnings("unchecked")
	    public static void ParseDataCountries() throws IOException
	    {
	        //JSON parser object to parse read file
	        JSONParser jsonParser = new JSONParser();
	         
	        try (FileReader reader = new FileReader("Countries.json"))
	        {
	            //Read JSON file
	            Object obj = jsonParser.parse(reader);
	 
	            JSONArray CountryList = (JSONArray) obj;
	            System.out.println(CountryList);
	             
	            //Iterate over Country array
	            CountryList.forEach( cntry -> parseCountryObject( (JSONObject) cntry ) );
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    private static void parseCountryObject(JSONObject country) 
	    {
	    	 //Get country object within list
	        //JSONObject countryObject = (JSONObject) country.get("");
	         
	        //Get country Country
	        String Country = (String) country.get("Country");    
	       System.out.println(Country);
	         
	        //Get country Slug
	        String Slug = (String) country.get("Slug");  
	        System.out.println(Slug);
	         
	        //Get country ISO2
	        String ISO2 = (String) country.get("ISO2");    
	        System.out.println(ISO2);
	    }
	}