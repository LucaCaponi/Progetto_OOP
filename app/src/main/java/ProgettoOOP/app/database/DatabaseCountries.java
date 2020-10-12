package ProgettoOOP.app.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class DatabaseCountries {

	public static void DownloadDataCountries() throws IOException {
		
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
		
	}
}
