package ProgettoOOP.app.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * La classe DatabaseCountries apre l'URL dell'API Postman 'GET Countries' in Internet. 
 * Il contenuto dell'API viene letto e poi "parsato" in ParseCountries.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public class DatabaseCountries {

	/**
	 * 
	 * @return outputLine
	 * @throws IOException
	 */
	public static String DownloadDataCountries() throws IOException {

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
