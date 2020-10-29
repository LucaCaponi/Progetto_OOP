package ProgettoOOP.app.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe Metadata serve per restituire i metadati
 *
 */
public class Metadata {

	/**
	 * Metodo che ottiene i metadati di un oggetto di tipo 'Countries'
	 *
	 * @return Map<String,String>
	 * 
	 */
	public static Map<String, String> getMetadata() {
		Map<String, String> metadata = new HashMap<String, String>(); // HashMap in cui le chiavi sono i metadati e i
																		// valori la descrizione di quest'ultimi
		metadata.put("Country", "nome della nazione");
		metadata.put("Slug", "parte dell'URL che identifica una nazione");
		metadata.put("ISO2", "codice costituito da due lettere che identifica una nazione");
		return metadata;
	}

}
