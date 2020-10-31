package ProgettoOOP.app.stats;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.gson.Gson;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

/**
 * 
 * La classe StatsCovid apre la connessione all'API "GET By Country All Status"
 * da cui prendiamo i dati per ogni nazione caricata su Postman e per un
 * determinato lasso di tempo. Successivamente, si elaborano i dati per ottenere
 * le statistiche giornaliere sul numero dei contagi e le relative variazioni
 * percentuali.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */
public class StatsCovid {

	private static Map<String, Countries> world = World.getworld();
/**
 * 
 * @param from
 * @param to
 * @return
 * @throws IOException
 */
	public static String statistics(String from, String to) throws IOException {
		Map<String, Object> out = new LinkedHashMap<>();
		JSONParser jsonParser = new JSONParser();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(from));
			calendar.add(Calendar.DAY_OF_MONTH, -2);
			String newfrom = sdf.format(calendar.getTime());
			from = newfrom;
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
				
			}
			Map<String, Object> resultstats = new LinkedHashMap<>();
			for (String key : out.keySet()) {
				JSONArray countryObject = (JSONArray) out.get(key);

				List<StatsModel> daily = new LinkedList<StatsModel>();
				
				List<JSONObject> filteredlist = new LinkedList<>();
				for (int i = 0; i < countryObject.size(); i++) {
					JSONObject countryObjectall = (JSONObject) countryObject.get(i);
					String province = (String) countryObjectall.get("Province");
					if (province.isEmpty()) {filteredlist.add(countryObjectall);
					}			   
				}

				for (int i = 2; i < filteredlist.size(); i++) {
					long confirmedbefore = 0;
					long confirmedafter = 0;

					JSONObject countryObjectallafter = filteredlist.get(i);
					JSONObject countryObjectallbefore =filteredlist.get(i - 1);
					JSONObject countryObjectallvar =   filteredlist.get(i - 2);
					confirmedafter = (Long) countryObjectallafter.get("Confirmed");
					confirmedbefore = (Long) countryObjectallbefore.get("Confirmed");
					long vartoday = confirmedafter - confirmedbefore;
					long varyesterday = (Long) countryObjectallbefore.get("Confirmed")
							- (Long) countryObjectallvar.get("Confirmed");

					double varperc;
					if (varyesterday == 0) {
						varperc = ((double) vartoday) * 100;

					} else {

						varperc = (((double) vartoday - (double) varyesterday) / (double) varyesterday) * 100;

					}
					DecimalFormat df = new DecimalFormat("#.##");
					String varpercstr = df.format(varperc) + "%";
					StatsModel covid = new StatsModel(countryObjectallafter.get("Date").toString(), vartoday,
							varpercstr);
					daily.add(covid);
					resultstats.put(key, daily);

				}

			}

			return new Gson().toJson(resultstats);

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		return "error";

	}

}
