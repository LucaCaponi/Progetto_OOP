package ProgettoOOP.app.filters;

import java.io.IOException;

import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.exception.NotValidStatus;

/**
 * 
 * La classe FiltersAllStatus permette di impostare le classifiche in base al
 * numero di casi: 
 * -confermati; 
 * -decessi; 
 * -ricoverati; 
 * -attivi. 
 * Il parametro secondo cui si vuole stilare la classifica viene impostato dall'utente
 * tramite una GET, usufruendo della rotta '/covid/{status}'; in questo modo è
 * possibile visualizzare la classifica richiesta.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class FiltersAllStatus {
/**
 * 
 * @param status
 * @return
 * @throws IOException
 */
	public static String gettingfilterStatus(String status) throws IOException {

		if (status.toLowerCase().contentEquals("confirmed"))
			return DatabaseCountryAllStatus.OrderingConfirmed();
		else if (status.toLowerCase().contentEquals("deaths"))
			return DatabaseCountryAllStatus.OrderingDeaths();
		else if (status.toLowerCase().contentEquals("recovered"))
			return DatabaseCountryAllStatus.OrderingRecovered();
		else if (status.toLowerCase().contentEquals("active"))
			return DatabaseCountryAllStatus.OrderingActive();
		else
			throw new NotValidStatus();

	}

}
