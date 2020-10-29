package ProgettoOOP.app.filters;

import java.io.BufferedReader;
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

import ProgettoOOP.app.exception.NotValidThreshold;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;
import ProgettoOOP.app.stats.StatsModel;

public class StatsFilter {

	private static Map<String, Countries> world = World.getworld();

	public static String statisticsfiltered(String from, String to, String threshold) throws Exception {
		Map<String, Object> resultfilter = new LinkedHashMap<>();
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
						varperc = ((double) vartoday) * 100;

					} else {

						varperc = (((double) vartoday - (double) varyesterday) / (double) varyesterday) * 100;

					}
					DecimalFormat df = new DecimalFormat("#.##");
					String varpercstr = df.format(varperc) + "%";
					StatsModel covid = new StatsModel(countryObjectallafter.get("Date").toString(), vartoday,
							varpercstr);
					resultfilter=conditional(threshold, key, vartoday, covid, daily, resultstats);

				}

			}

			return new Gson().toJson(resultfilter);

		} catch (ParseException e1) {
			e1.printStackTrace();
		}

		return "error";

	}

	public static Map<String, Object> conditional(String threshold, String keyfilter, long today, StatsModel covidfilter,
			List<StatsModel> day, Map<String, Object> resultfilter) {
		int cond=0;
		if (threshold.contains("$gt")) {
			cond = Integer.parseInt(threshold.substring(3));
			if (today > cond) {
				day.add(covidfilter);
				resultfilter.put(keyfilter, day);
			}
		}

		else if (threshold.contains("$lt")) {
			cond = Integer.parseInt(threshold.substring(3));
			if (today < cond) {
				day.add(covidfilter);
				resultfilter.put(keyfilter, day);
			}
		} else
			throw new NotValidThreshold();
		
		return resultfilter;

	}

}
