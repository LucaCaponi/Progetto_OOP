package ProgettoOOP.app;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ProgettoOOP.app.database.Database;


@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) throws IOException {
	Database.DownloadData();
		SpringApplication.run(AppApplication.class, args);
	}

}
