package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONException;
import org.json.simple.parser.ParseException;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.Metadata;

/**
 * L'interfaccia CountryService contiene una lista di metodi astratti che
 * verranno poi implementati nella classe CountryServiceImpl.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */

public interface CountryService {

	/**
	 * 
	 * @param country
	 * @throws Exception
	 */
	public abstract void InsertCountry(Countries country) throws Exception;

	/**
	 * 
	 * @return
	 * @throws IOException
	 */
	public abstract String totalCountries() throws IOException;

	/**
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 * @throws InterruptedException 
	 */
	public abstract String totalStatusCountries(String from, String to)
			throws IOException, ParseException, JSONException, InterruptedException;

	/**
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 */
	public abstract String totalStats(String from, String to) throws IOException, ParseException, JSONException;

	/**
	 * 
	 * @param from
	 * @param to
	 * @param threshold
	 * @return
	 * @throws Exception
	 */
	public abstract String totalStatsFiltered(String from, String to, String threshold) throws Exception;

	/**
	 * 
	 * @param from
	 * @param to
	 * @param status
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 * @throws JSONException
	 * @throws InterruptedException 
	 */
	public abstract String Classify(String from, String to, String status)
			throws IOException, ParseException, JSONException, InterruptedException;

	/**
	 * 
	 * @return
	 */
	public abstract Collection<Countries> gettingCountries();

	/**
	 * 
	 * @return
	 */
	public abstract ArrayList<Metadata> gettingMetadata();

	/**
	 * 
	 * @param cont
	 * @return
	 */
	public abstract Collection<Countries> gettingfilterCountries(String cont);

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public abstract String yourcontinent() throws Exception;

}
