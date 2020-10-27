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
import ProgettoOOP.app.filters.Filterscountry;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.service.CountryService;

/**
 * 
 * Il restController serve per gestire le chiamate GET e POST in Postman
 * 
 * @author Federico Catalini
 * @author Luca Caponi
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
	public ResponseEntity<Object> gettotalCountries() throws Exception {
		return new ResponseEntity<>(countryService.totalCountries(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna la differenza tra i confermati, i decessi, i ricoverati e gli
	 *         attuali positivi tra la data finale inserita e quella iniziale
	 * @throws Exception
	 */
	@RequestMapping(value = "/totalallstatus", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> gettotalCountryAllStatus(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.totalStatusCountries(from, to), HttpStatus.OK);
	}

	/**
	 * 
	 * @body L'utente inserisce una nazione alla volta in formato JSON specificando
	 *       il "country", lo "slug" e l"iSO2"
	 * @return Se la nazione esiste ritorna un messaggio di caricamento avvenuto
	 *         contenente anche il continente a cui appartiene, altrimenti lancia
	 *         l'eccezione "NotValidCountry". Viene, invece, lanciata l'eccezione
	 *         "Existing ISO2" se il paese che si desidera inserire è stato già
	 *         inserito dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/countries", method = RequestMethod.POST)
	public ResponseEntity<Object> InsertCountry(@RequestBody Countries country) throws Exception {
		countryService.InsertCountry(country);
		return new ResponseEntity<>(
				"Country is created successfully! The country is located in " + countryService.yourcontinent(),
				HttpStatus.CREATED);
	}

	/**
	 * 
	 * @return Ritorna tutte le nazioni inserite precedentemente dall'utente nel
	 *         body con la POST
	 */
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<Object> getCountries() throws Exception {
		return new ResponseEntity<>(countryService.gettingCountries(), HttpStatus.OK);
	}

	/**
	 * 
	 * @PathVariable L'utente inserisce nella rotta in Postman il continente per cui
	 *               vuole filtrare la lista dei paesi precedentemente inseriti
	 * @return Ritorna la lista dei paesi filtrata per il continente desiderato
	 */
	@RequestMapping(value = "/countries/{continent}", method = RequestMethod.GET)
	public ResponseEntity<Object> getFilteredCountries(@PathVariable("continent") String cont) {
		Filterscountry.gettingfilterCountries(cont);
		return new ResponseEntity<>(countryService.gettingfilterCountries(cont), HttpStatus.OK);

	}
	
	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna le classifiche dei casi confermati dal paese con più contagi 
	 *         a quello con meno tra i paesi scelti dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/confirmed", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getstatsconfirmed(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.ClassifyConfirmed(from, to), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna le classifiche dei casi decessi dal paese con più morti 
	 *         a quello con meno tra i paesi scelti dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/deaths", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getstatsdeaths(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.ClassifyDeaths(from, to), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna le classifiche dei casi ricoverati dal paese con più ricoverati 
	 *         a quello con meno tra i paesi scelti dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/recovered", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getstatsrecovered(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.ClassifyRecovered(from, to), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna le classifiche dei casi positivi (attivi) dal paese con più attivi 
	 *         a quello con meno tra i paesi scelti dall'utente
	 * @throws Exception
	 */
	@RequestMapping(value = "/active", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public ResponseEntity<Object> getstatsactive(
			@RequestParam(name = "from", defaultValue = "2020-03-01T00:00:00Z") String from,
			@RequestParam(name = "to", defaultValue = "2020-04-01T00:00:00Z") String to) throws Exception {
		return new ResponseEntity<>(countryService.ClassifyActive(from, to), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param L'utente inserisce nella rotta in Postman una data iniziale ed una
	 *                 finale in base a ciò che vuole ottenere
	 * @return Ritorna la differenza tra i confermati, i decessi, i ricoverati e gli
	 *         attuali positivi tra la data finale inserita e quella iniziale
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
	 * @PathVariable L'utente inserisce nella rotta in Postman l'ISO2 del paese che
	 *               vuole eliminare dalla sua lista
	 * @return Ritorna un messaggio di avvenuta cancellazione
	 */
	@RequestMapping(value = "/countries/{ISO2}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("ISO2") String ISO2) {
		countryService.DeleteCountry(ISO2);
		return new ResponseEntity<>("Country is deleted successfully!", HttpStatus.OK);
	}

	/**
	 * Metodo per gestire eccezioni lanciate dai metodi dei filtri
	 *
	 * @return Ritorna un oggetto di tipo ExceptionError
	 */
	@ExceptionHandler(ExceptionAbstract.class)
	public ResponseEntity<Object> handleExceptionAbstract(ExceptionAbstract e) {
		ExceptionPrincipal error = new ExceptionPrincipal(Calendar.getInstance(), HttpStatus.BAD_REQUEST,
				e.getClass().getCanonicalName(), e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}