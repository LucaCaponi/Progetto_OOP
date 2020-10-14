package ProgettoOOP.app.database;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class DatabaseCountries {

	public static String DownloadDataCountries() throws IOException {
		/*
		int readerCountries = 0;
		File Countries =new File("Countries.json");

		FileOutputStream FScountries = new FileOutputStream(Countries);
		URL countriesURL = new URL("https://api.covid19api.com/countries");

		URLConnection URLConn = countriesURL.openConnection();

		InputStream inputCountries = URLConn.getInputStream();

		while ((readerCountries=inputCountries.read())!=-1){
         FScountries.write(readerCountries);
		}
		

		inputCountries.close();
		FScountries.close();
	    */
		
		URL oracle = new URL("https://api.covid19api.com/countries");
		URLConnection URLConn = oracle.openConnection();
		
		BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
		
		String inputLine;
		String outputLine = "";
		
		while ((inputLine = in.readLine()) != null)
			outputLine = outputLine + inputLine;
		in.close();
		return outputLine;
	}
}
