package ProgettoOOP.app.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Database {

	public static void DownloadData() throws IOException {
		int reader = 0;
		File countries = new File("Countries.json");

		FileOutputStream FScountries = new FileOutputStream(countries);
		URL countriesURL = new URL("https://api.covid19api.com/countries");

		URLConnection URLConn = countriesURL.openConnection();

		InputStream input = URLConn.getInputStream();

		while ((reader=input.read())!=-1){
         FScountries.write(reader);
		}

		input.close();
		FScountries.close();
	}
	
}
