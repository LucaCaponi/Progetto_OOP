package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.json.JSONException;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;
import ProgettoOOP.app.model.Continents;
import ProgettoOOP.app.exception.ExistingISO2;
import ProgettoOOP.app.exception.Nofile;
import ProgettoOOP.app.exception.NotValidCountry;


@Service
public class CountryServiceImpl implements CountryService {


public CountryServiceImpl() {
Countries nation = new Countries(null , null, null);
nation.setCountry("Italy");
nation.setSlug("italy");
nation.setISO2("IT");
World.setworld(nation);
}

@Override
public String totalCountries() throws IOException {
	if(DatabaseCountries.DownloadDataCountries().isEmpty()) throw new Nofile();
	return DatabaseCountries.DownloadDataCountries();
}

@Override
public String totalStatusCountries(String from, String to) throws IOException, ParseException, JSONException {
	if(DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to).isEmpty()) throw new Nofile();
	return DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to);
}

@Override
public void InsertCountry(Countries country) throws Exception {
	    Map<String, Countries> world= World.getworld();
	    if (World.Verify(country)==false) {
	    	 throw new NotValidCountry();}
	    if (world.containsKey(country.getISO2())) {
	    throw new ExistingISO2(); }
	    World.setworld(country);
}

@Override
public void DeleteCountry(String ISO2) {
	World.deleteworld(ISO2);
}

public Collection<Countries> gettingCountries() {
	Map<String, Countries> world= World.getworld();
	return world.values();
}

public String yourcontinent() throws Exception {
return Continents.returnContinent();	
}
}
