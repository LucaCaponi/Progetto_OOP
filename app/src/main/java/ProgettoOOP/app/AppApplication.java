package ProgettoOOP.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;


@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
	DatabaseCountries.DownloadDataCountries();
	DatabaseCountryAllStatus.DownloadDataCountryAllStatus();
		SpringApplication.run(AppApplication.class, args);
	}

}
