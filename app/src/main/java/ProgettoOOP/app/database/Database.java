package ProgettoOOP.app.database;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Database {
	
	
	public static void DownloadData() throws IOException{
		int b=0;
		File albums = new File("Dati.json");

		 FileOutputStream FSalbum=new FileOutputStream(albums);


	

		 URL albumsURL = new URL("https://api.covid19api.com/countries");

		 URLConnection URLConn= albumsURL.openConnection();

		 InputStream input= URLConn.getInputStream();



		 while((b=input.read())!=-1)

		 {

		 FSalbum.write(b);

		 }

		 input.close();

		 FSalbum.close();
	}

}
