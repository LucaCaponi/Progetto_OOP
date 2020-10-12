package ProgettoOOP.app.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class DatabaseCountryAllStatus {
	private static String nomeurl= "https://api.covid19api.com/live/country/";
public static void DownloadDataCountryAllStatus() throws IOException {
		
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
		
	}
}
