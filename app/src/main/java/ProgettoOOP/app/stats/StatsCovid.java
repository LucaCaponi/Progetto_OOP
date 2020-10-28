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
import java.util.Date;
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

public class StatsCovid {

	private static Map<String, Countries> world = World.getworld();

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

				List<Stats> daily = new LinkedList<Stats>();

				long confirmedstart = 0;
				long confirmedlast = 0;

				for (int i = 2; i < countryObject.size(); i++) {
					long confirmedbefore = 0;
					long confirmedafter = 0;

					JSONObject countryObjectallafter = (JSONObject) countryObject.get(i);
					JSONObject countryObjectallbefore = (JSONObject) countryObject.get(i - 1);
					JSONObject countryObjectallvar = (JSONObject) countryObject.get(i - 2);
					confirmedafter = (Long) countryObjectallafter.get("Confirmed");
					confirmedbefore = (Long) countryObjectallbefore.get("Confirmed");
					long vartoday = confirmedafter - confirmedbefore;

					long varyesterday = (Long) countryObjectallbefore.get("Confirmed")
							- (Long) countryObjectallvar.get("Confirmed");
					
					double varperc;
					if (varyesterday == 0) {
						varperc = ((double)vartoday) * 100;
						
					} else {

						varperc = (((double)vartoday - (double)varyesterday) / (double)varyesterday) * 100;
						
					}
					DecimalFormat df = new DecimalFormat("#.##");
			       String varpercstr=df.format(varperc)+"%";
					Stats covid = new Stats(countryObjectallafter.get("Date").toString(), vartoday, varpercstr);
					daily.add(covid);
					resultstats.put(key, daily);
					/*
					 * if (i == 1) { confirmedstart = (Long) countryObjectallafter.get("Confirmed");
					 * }
					 * 
					 * 
					 * if (i == countryObject.size()-1) { confirmedlast = (Long)
					 * countryObjectallafter.get("Confirmed"); }
					 */
					// double
					// varperc=(((confirmedafter-confirmedbefore)*countryObject.size()-(confirmedlast-confirmedstart))/(confirmedlast-confirmedstart))*100;

				}

			}

			return new Gson().toJson(resultstats);

		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return "error";

	}

}
