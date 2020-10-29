package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.Metadata;
import ProgettoOOP.app.model.World;
import ProgettoOOP.app.stats.StatsCovid;
import ProgettoOOP.app.exception.ExistingISO2;
import ProgettoOOP.app.exception.NoJSONObject;
import ProgettoOOP.app.exception.NotValidCountry;
import ProgettoOOP.app.filters.Continents;
import ProgettoOOP.app.filters.FiltersAllCountry;
import ProgettoOOP.app.filters.FiltersAllStatus;
import ProgettoOOP.app.filters.StatsFilter;

/**
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 *         La classe CountryServiceImpl implementa i metodi astratti dell'interfaccia CountryService;
 *         questi metodi verranno poi richiamati ed eseguiti dal restController.
 */

@Service
public class CountryServiceImpl implements CountryService {

	String cont = null;
	String status = null;

	/**
	 * Costruttore per settare l'oggetto 'Countries'.
	 * 
	 */
	public CountryServiceImpl() {
		Countries nation = new Countries(null, null, null);
		nation.setCountry("");
		nation.setSlug("");
		nation.setISO2("");
		World.setworld(nation);
	}
	
	/**
	 * 
	 * @return Ritornano i dati dell'API "GET Countries".
	 * @throws IOException.
	 */
	@Override
	public String totalCountries() throws IOException {
		if (DatabaseCountries.DownloadDataCountries().isEmpty())
			throw new NoJSONObject();
		return DatabaseCountries.DownloadDataCountries();
	}

	/**
	 * 
	 * @return Ritornano i casi totali confermati, decessi, ricoverati, attualmente positivi 
	 *         di un determinato periodo di tempo per ogni paese inserito.
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	@Override
	public String totalStatusCountries(String from, String to) throws IOException, ParseException, JSONException {
		if (DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to).isEmpty())
			throw new NoJSONObject();
		return DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to);
	}

	/**
	 * 
	 * @return Ritornano le classifiche filtrate per status 
	 *         di un determinato periodo di tempo.
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	@Override
	public String Classify(String from, String to, String status) throws IOException, ParseException, JSONException {
		DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to);
		return FiltersAllStatus.gettingfilterStatus(status);
	}

	/**
	 * 
	 * @return Ritornano le statistiche per ogni paese sul numero di contagi giornalieri e sulle loro variazioni percentuali
	 *         di un determinato periodo di tempo.
	 *      
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	@Override
	public String totalStats(String from, String to) throws IOException, ParseException, JSONException {
		return StatsCovid.statistics(from, to);
	}
	
	@Override
	public String totalStatsFiltered(String from, String to, String threshold) throws Exception {
		return StatsFilter.statisticsfiltered(from, to, threshold);
	}

	@Override
	public void InsertCountry(Countries country) throws Exception {
		Map<String, Countries> world = World.getworld();
		if (World.Verify(country) == false) {
			throw new NotValidCountry();
		}
		if (world.containsKey(country.getISO2())) {
			throw new ExistingISO2();
		}
		World.setworld(country);
	}

	public Collection<Countries> gettingCountries() {
		Map<String, Countries> world = World.getworld();
		return world.values();
	}

	public ArrayList<Metadata> gettingMetadata() {
		ArrayList<Metadata> metadata = new ArrayList<Metadata>();
		metadata.add(new Metadata("Country", "Nome della nazione", "String"));
		metadata.add(new Metadata("Slug", "Parte dell'URL che identifica una nazione", "String"));
		metadata.add(new Metadata("ISO2", "Codice costituito da due lettere che identifica una nazione", "String"));
		return metadata;
		
	}

	public Collection<Countries> gettingfilterCountries(String cont) {
		Map<String, Countries> filter = FiltersAllCountry.gettingfilterCountries(cont);
		return filter.values();

	}

	public String yourcontinent() throws Exception {
		return Continents.returnContinent();
	}

}
