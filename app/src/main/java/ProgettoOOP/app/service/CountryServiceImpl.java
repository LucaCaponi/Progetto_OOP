package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.model.Confirmed;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.CountryAllStatus;
import ProgettoOOP.app.model.World;
import ProgettoOOP.app.model.Continents;
import ProgettoOOP.app.exception.Nofile;


@Service
public class CountryServiceImpl implements CountryService {


public CountryServiceImpl() {
CountryAllStatus All=new CountryAllStatus(null, null, null, null, null, 0, 0, 0, 0, 0, 0, null);
Countries nation = new Countries(null , null, null);
nation.setCountry("Italy");
nation.setSlug("italy");
nation.setISO2("IT");
World.setworld(nation);
World.setall(All);
Confirmed cases = new Confirmed(nation.getCountry(), nation.getSlug(), nation.getISO2(), 0);
World.setconf(cases);
}

@Override
public String totalCountries() throws IOException {
	if(DatabaseCountries.DownloadDataCountries().isEmpty()) throw new Nofile();
	return DatabaseCountries.DownloadDataCountries();
}

@Override
public String totalStatusCountries(String from, String to) throws IOException {
	if(DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to).isEmpty()) throw new Nofile();
	return DatabaseCountryAllStatus.DownloadDataCountryAllStatus(from, to);
}

@Override
public void InsertCountry(Countries country) throws Exception {
	    Map<String, Countries> world= World.getworld();
	    //World.Verify();
		if (world.containsKey(country.getISO2())) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing ISO2...");
	}
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

public Collection<CountryAllStatus> gettingAll() {
	Map<String, CountryAllStatus> all= World.getall();
	return all.values();
}

public Collection<Confirmed> gettingConfirmed() {
	//World.Association();
	Map<String, Confirmed> conf= World.getconf();
	return conf.values();
}

public String yourcontinent() {
return Continents.returnContinent();	
}
}
