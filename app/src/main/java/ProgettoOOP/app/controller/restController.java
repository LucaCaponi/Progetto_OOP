package ProgettoOOP.app.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.exception.ExceptionAbstract;
import ProgettoOOP.app.exception.ExceptionPrincipal;
import ProgettoOOP.app.filters.FiltersAllCountry;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.service.CountryService;

/**
 * Il restController serve per gestire le chiamate GET e POST in Postman
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */

@RestController
public class restController {

	/**
	 * 
	 * @Autowired lancia automaticamente il costruttore all'avvio di Spring
	 */
	@Autowired
	CountryService countryService;

	/**
	 * 
	 * @return Ritorna tutto il contenuto presente nell'API "Get Countries"
	 * @throws Exception
	 */
	@RequestMapping(value = "/totalcountries", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getTotalCountries() throws Exception {
		return new ResponseEntity<>(countryService.totalCountries(), HttpStatus.OK);
	}

	/**
	 * L'utente inserisce una nazione alla volta in formato JSON specificando
	 *                 il "country", lo "slug" e l"iSO2"
	 * @param country
	 * @return Se la nazione è inserita correttamente, ritorna un messaggio di
	 *         caricamento avvenuto (specificando il continente a cui appartiene);
	 *         altrimenti viene lanciata l'eccezione "NotValidCountry"; sarà invece
	 *         richiamata l'eccezione "Existing ISO2" se il paese che si desidera
	 *         inserire è stato già caricato dall'utente
	 * @throws Exception
	 */
	

	@RequestMapping(value = "/countries", method = RequestMethod.POST)
	public ResponseEntity<Object> postCountries(@RequestBody Countries country) throws Exception {
		countryService.InsertCountry(country);
		return new ResponseEntity<>(
				"Country is created successfully! The country is located in " + countryService.yourcontinent(),
				HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return Ritornano tutte le nazioni precedentemente inserite con la POST
	 *         dall'utente nel 'body'
	 * @throws Exception
	 */
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<Object> getCountries() throws Exception {
		return new ResponseEntity<>(countryService.gettingCountries(), HttpStatus.OK);
	}


	
	/**
	 * l'utente inserisce in Postman la rotta con il continente per cui vuole
	 *  filtrare la lista dei paesi precedentemente inseriti.
	 * @param cont 
	 * @return Ritorna la lista dei paesi filtrata per il continente desiderato
	 */
	@RequestMapping(value = "/countries/{continent}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilteredCountries(@PathVariable("continent") String cont) {
		FiltersAllCountry.gettingfilterCountries(cont);
		return new ResponseEntity<>(countryService.gettingfilterCountries(cont), HttpStatus.OK);
	}

	/**
	 * 
	 * @return Ritornano tutti i metadati di un oggetto di tipo 'Countries'
	 * 
	 */
	@RequestMapping(value = "/countries/metadata", method = RequestMethod.GET)
	public ResponseEntity<Object> getMetadata() {
		return new ResponseEntity<>(countryService.gettingMetadata(), HttpStatus.OK);
	}

	/**
	 * 
	 *       L'utente inserisce come parametri in Postman una data iniziale ed una
	 *                 finale in base al periodo che vuole ottenere. Per la query in
	 *                 Postman scrivere le date nel seguente formato:
	 *                 {anno}-{mese}-{giorno}T00:00:00Z 
	 *                 ESEMPIO 
	 *                 KEY       VALUE 
	 *                 from      2020-04-19T00:00:00Z 
	 *                 to        2020-05-09T00:00:00Z
	 * @param from
	 * @param to
	 * @return Ritorna (per ogni paese precedentemente inserito) il totale dei casi
	 *         confermati, dei decessi, dei ricoverati e degli attuali positivi nel
	 *         periodo compreso tra la data iniziale inserita e quella finale
	 * @throws Exception
	 */
	@RequestMapping(value = "/totalallstatus", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getTotalCountryAllStatus(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.totalStatusCountries(from, to), HttpStatus.OK);
	}

	/**
	 * 
	 * L'utente inserisce come parametri in Postman una data iniziale ed una
	 *                 finale in base al periodo che vuole ottenere. Per la query in
	 *                 Postman scrivere le date nel seguente formato:
	 *                 {anno}-{mese}-{giorno}T00:00:00Z 
	 *                 ESEMPIO 
	 *                 KEY       VALUE 
	 *                 from      2020-04-19T00:00:00Z 
	 *                 to        2020-05-09T00:00:00Z
	 *  L'utente inserisce in Postman la rotta con lo status
	 *               'confirmed'(casi confermati), 'deaths' (decessi), 'recovered'
	 *               (ricoverati) 'active' (casi attualmente positivi) in base alla
	 *               classifica che desidera visualizzare
	 * @param from
	 * @param to 
	 * @return Ritornano le classifiche dei paesi caricati dall'utente in base al
	 *         numero decrescente di confermati/decessi/ricoverati/positivi (a
	 *         seconda della rotta richiesta)
	 * @throws Exception
	 */
	@RequestMapping(value = "/covid/{status}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getRankingStatus(@PathVariable("status") String status,
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.Classify(from, to, status), HttpStatus.OK);
	}

	/**
	 * 
	 *  L'utente inserisce come parametri in Postman una data iniziale ed una
	 *                 finale in base al periodo che vuole ottenere. Per la query in
	 *                 Postman scrivere le date nel seguente formato:
	 *                 {anno}-{mese}-{giorno}T00:00:00Z ESEMPIO KEY VALUE from
	 *                 2020-04-19T00:00:00Z to 2020-05-09T00:00:00Z
	 * @param from
	 * @param to
	 * @return Ritornano le statistiche sul numero dei contagi giornalieri e sulle
	 *         loro variazioni percentuali per i paesi inseriti precedentemente
	 *         dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getStats(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.totalStats(from, to), HttpStatus.OK);
	}

	/**
	 * 
	 *  L'utente inserisce come parametri in Postman una data iniziale ed una
	 *                 finale in base al periodo che vuole ottenere. Per la query in
	 *                 Postman scrivere le date nel seguente formato:
	 *                 {anno}-{mese}-{giorno}T00:00:00Z Inoltre, l'utente richiede
	 *                 una soglia dei contagi giornalieri al di sopra/sotto della
	 *                 quale vuole visualizzare i giorni coi rispettivi casi
	 *                 confermati maggiori/minori di quella soglia. Per la query in
	 *                 Postman scrivere la soglia nel seguente formato: 1)
	 *                 $gt{soglia numerica} ($gt se si vogliono visualizzare i
	 *                 giorni con il numero di confermati maggiore della soglia.) 2)
	 *                 $lt{soglia numerica} ($lt se si vogliono visualizzare i
	 *                 giorni con il numero di confermati minore della soglia.)
	 *                 ESEMPIO 
	 *                 KEY          VALUE 
	 *                 from         2020-04-19T00:00:00Z 
	 *                 to           2020-05-09T00:00:00Z 
	 *                 threshold    $gt2000
	 * @param from
	 * @param to
	 * @param threshold
	 * @return Ritornano le statistiche (per i paesi inseriti precedentemente
	 *         dall'utente) sul numero dei contagi giornalieri e sulle loro
	 *         variazioni percentuali filtrati in base alla soglia imposta
	 * 
	 * @throws Exception
	 */
	@RequestMapping(value = "/stats/filter", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getFilteredStats(
			@RequestParam(name = "threshold", defaultValue = "$gt1000") String threshold,
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.totalStatsFiltered(from, to, threshold), HttpStatus.OK);
	}

	/**
	 * Metodo per gestire le eccezioni lanciate dai metodi.
	 *
	 * @param e
	 * @return Ritorna un oggetto di tipo ExceptionError
	 */
	
	@ExceptionHandler(ExceptionAbstract.class)
	public ResponseEntity<Object> handleExceptionAbstract(ExceptionAbstract e) {
		ExceptionPrincipal error = new ExceptionPrincipal(Calendar.getInstance(), HttpStatus.BAD_REQUEST,
				e.getClass().getCanonicalName(), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}