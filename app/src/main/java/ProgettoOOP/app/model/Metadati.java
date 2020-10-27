package ProgettoOOP.app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * La classe Metadati serve per creare i metadati
 *
 */
public class Metadati {
	
	public static Map<String,String> getMetadata() 
	{
		Map<String, String> metadata = new HashMap<String, String> ();
		metadata.put("Country","nome della nazione");
		metadata.put("Slug","parte dell'URL che identifica una nazione");
		metadata.put("ISO2","codice costituito da due lettere che identifica una nazione");
		return metadata;
	}
	
}
