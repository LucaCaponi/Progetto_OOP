package ProgettoOOP.app.database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

/**
 * 
 * 
 * La classe DatabaseCountryAllStatus apre la connessione all'API "GET By
 * Country All Status" da cui prendiamo i dati per ogni nazione caricata su
 * Postman e per un determinato lasso di tempo. Si riesce quindi ad ottenere il
 * numero di casi COVID-19 confermati, decessi, ricoverati e positivi e le
 * classifiche dei paesi per i casi confermati, decessi, ricoverati e positivi
 * in un periodo temporale scelto dall'utente.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */
public class DatabaseCountryAllStatus {

	private static Map<String, Countries> world = World.getworld();
	private static Map<String, Long> confirmed = new LinkedHashMap<String, Long>();
	private static Map<String, Long> deaths = new LinkedHashMap<String, Long>();
	private static Map<String, Long> recovered = new LinkedHashMap<String, Long>();
	private static Map<String, Long> active = new LinkedHashMap<String, Long>();

	/**
	 * 
	 * @param from
	 * @param to
	 * @return new JSONObject(result).toString()
	 * @throws IOException
	 * @throws InterruptedException 
	 */
	public static String DownloadDataCountryAllStatus(String from, String to) throws IOException, InterruptedException {
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();

		for (String key : world.keySet()) {

			String slug = world.get(key).getSlug();
			if (slug != "") {
				String nomeurl = "https://api.covid19api.com/country/" + slug + "?from=" + from + "&to=" + to;

				try {
					URL info = new URL(nomeurl);
					URLConnection URLConn = info.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(URLConn.getInputStream()));
					String inputLine;
					String outputLine = "";

					while ((inputLine = in.readLine()) != null)
						outputLine = outputLine + inputLine;

					in.close();

					out.put(world.get(key).getCountry(), jsonParser.parse(outputLine));

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
Thread.sleep(200);
		}
		Map<String, Object> result = new LinkedHashMap<>();
		for (String key : out.keySet()) {
			JSONArray countryObject = (JSONArray) out.get(key);

			long confirmedstart = 0;
			long deathsstart = 0;
			long recoveredstart = 0;
			long activestart = 0;
			long confirmedlast = 0;
			long deathslast = 0;
			long recoveredlast = 0;
			long activelast = 0;

			for (int i = 0; i < countryObject.size(); i++) {
				JSONObject countryObjectall = (JSONObject) countryObject.get(i);

				if (i == 0) {
					confirmedstart = (Long) countryObjectall.get("Confirmed");
					deathsstart = (Long) countryObjectall.get("Deaths");
					recoveredstart = (Long) countryObjectall.get("Recovered");
					activestart = (Long) countryObjectall.get("Active");
				}

				if (i == countryObject.size() - 1) {
					confirmedlast = (Long) countryObjectall.get("Confirmed");
					deathslast = (Long) countryObjectall.get("Deaths");
					recoveredlast = (Long) countryObjectall.get("Recovered");
					activelast = (Long) countryObjectall.get("Active");

				}

			}

			Map<String, Long> stats = new LinkedHashMap<String, Long>();

			stats.put("Confirmed", confirmedlast - confirmedstart);
			stats.put("Deaths", deathslast - deathsstart);
			stats.put("Recovered", recoveredlast - recoveredstart);
			stats.put("Active", activelast - activestart);
			result.put(key, stats);
			confirmed.put(key + "'s confirmed cases", confirmedlast - confirmedstart);
			deaths.put(key + "'s deaths cases", deathslast - deathsstart);
			recovered.put(key + "'s recovered cases", recoveredlast - recoveredstart);
			active.put(key + "'s active cases", activelast - activestart);
			Thread.sleep(200);
		}

		return new JSONObject(result).toString();
	}

	/**
	 * 
	 * @return json
	 * @throws IOException
	 */
	public static String OrderingConfirmed() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sortHashMapByValues(confirmed), LinkedHashMap.class);
		return json;
	}

	/**
	 * 
	 * @return json
	 * @throws IOException
	 */
	public static String OrderingDeaths() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sortHashMapByValues(deaths), LinkedHashMap.class);
		return json;
	}

	/**
	 * 
	 * @return json
	 * @throws IOException
	 */
	public static String OrderingRecovered() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sortHashMapByValues(recovered), LinkedHashMap.class);
		return json;
	}

	/**
	 * 
	 * @return json
	 * @throws IOException
	 */
	public static String OrderingActive() throws IOException {
		Gson gson = new Gson();
		String json = gson.toJson(sortHashMapByValues(active), LinkedHashMap.class);
		return json;
	}

	/**
	 * 
	 * @param codenames
	 * @return result
	 */
	public static LinkedHashMap<String, Long> sortHashMapByValues(Map<String, Long> codenames) {

		Set<Entry<String, Long>> entries = codenames.entrySet();
		Comparator<Entry<String, Long>> valueComparator = new Comparator<Entry<String, Long>>() {
			@Override
			public int compare(Entry<String, Long> e1, Entry<String, Long> e2) {
				Long v1 = e1.getValue();
				Long v2 = e2.getValue();
				return (v1).compareTo(v2);
			}
		};
		List<Entry<String, Long>> listOfEntries = new ArrayList<Entry<String, Long>>(entries);
		Collections.sort(listOfEntries, Collections.reverseOrder(valueComparator));
		LinkedHashMap<String, Long> sortedByValue = new LinkedHashMap<String, Long>(listOfEntries.size());
		for (Entry<String, Long> entry : listOfEntries) {
			sortedByValue.put(entry.getKey(), entry.getValue());
		}

		Set<Entry<String, Long>> entrySetSortedByValue = sortedByValue.entrySet();
		LinkedHashMap<String, Long> result = new LinkedHashMap<String, Long>();
		for (Entry<String, Long> mapping : entrySetSortedByValue) {
			result.put(mapping.getKey(), mapping.getValue());

		}

		return result;

	}

}
