package ProgettoOOP.app.filters;

import java.util.Map;

import ProgettoOOP.app.exception.NotValidContinent;
import ProgettoOOP.app.model.Countries;

/**
 * 
 * La classe FiltersAllCountry permette di filtrare la lista dei paesi caricati
 * con la chiamata POST in base al loro continente di appartenenza. Il
 * continente viene richiesto dall'utente e tramite una GET, con la rotta
 * /countries/{continent}, è possibile visualizzare la lista filtrata.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class FiltersAllCountry {
	/**
	 * 
	 * @param cont
	 * @return La mappa del continente
	 */
	public static Map<String, Countries> gettingfilterCountries(String cont) {

		if (cont.toLowerCase().contentEquals("europe"))
			return Continents.getEurope();
		else if (cont.toLowerCase().contentEquals("asia"))
			return Continents.getAsia();
		else if (cont.toLowerCase().contentEquals("africa"))
			return Continents.getAfrica();
		else if (cont.toLowerCase().contentEquals("northamerica"))
			return Continents.getNorth();
		else if (cont.toLowerCase().contentEquals("southamerica"))
			return Continents.getSouth();
		else if (cont.toLowerCase().contentEquals("oceania"))
			return Continents.getOceania();
		else if (cont.toLowerCase().contentEquals("antarctica"))
			return Continents.getAntar();
		else
			throw new NotValidContinent();

	}
}
