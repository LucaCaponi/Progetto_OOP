package ProgettoOOP.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.database.ParseCountries;
import ProgettoOOP.app.database.ParseCountryAllStatus;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
	DatabaseCountries.DownloadDataCountries();
	DatabaseCountryAllStatus.DownloadDataCountryAllStatus();
	ParseCountries.ParseDataCountries();
	ParseCountryAllStatus.ParseDataCountryAllStatus();
		SpringApplication.run(AppApplication.class, args);
	}

}
