package ProgettoOOP.app;

import java.io.IOException;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.database.ParseCountries;

/**
 * 
 * Classe main dell'applicazione
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 *
 */

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException, ParseException, JSONException, InterruptedException {
		DatabaseCountries.DownloadDataCountries();
		DatabaseCountryAllStatus.DownloadDataCountryAllStatus(null, null);
		ParseCountries.ParseDataCountries();
		SpringApplication.run(AppApplication.class, args);
	}

}
