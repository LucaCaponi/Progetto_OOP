package ProgettoOOP.app.database;

import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileOutputStream;
import java.io.IOException;
//import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import ProgettoOOP.app.model.Countries;


public class DatabaseCountryAllStatus {
	private static String nomeurl= "https://api.covid19api.com/country/";
public static String DownloadDataCountryAllStatus(String from, String to) throws IOException {
	    Countries database = new Countries("Italy", "italy", "IT");
	
	/*
		int readerCountryAllStatus = 0;
		File CountryAllStatus =new File("CountryAllStatus.json");

		FileOutputStream FSCountryAllStatus = new FileOutputStream(CountryAllStatus);
		
		URL countryallstatusURL = new URL(nomeurl+"germany");

		URLConnection URLConn = countryallstatusURL.openConnection();

		InputStream inputCountryAllStatus = URLConn.getInputStream();

		while ((readerCountryAllStatus=inputCountryAllStatus.read())!=-1){
         FSCountryAllStatus.write(readerCountryAllStatus);
		}
		

		inputCountryAllStatus.close();
		FSCountryAllStatus.close();
		*/
	
		URL oracle = new URL(nomeurl+database.getSlug()+"?from="+from+"&to="+to);
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
