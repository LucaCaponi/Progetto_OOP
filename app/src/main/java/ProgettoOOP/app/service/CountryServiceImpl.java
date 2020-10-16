package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ProgettoOOP.app.database.DatabaseCountries;
import ProgettoOOP.app.database.DatabaseCountryAllStatus;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.exception.Nofile;

@Service
public class CountryServiceImpl implements CountryService {
private static Map<String, Countries> world= new HashMap<>();

public CountryServiceImpl() {
Countries nation = new Countries(null, null, null);
nation.setCountry("Italy");
nation.setSlug("italy");
nation.setISO2("IT");
world.put(nation.getISO2(), nation);
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
public void InsertCountry(Countries country) {
	// TODO Auto-generated method stub
	if (world.containsKey(country.getISO2())) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing ISO2...");
	}
world.put(country.getISO2(), country);
}

@Override
public void DeleteCountry(String ISO2) {
	world.remove(ISO2);
}

public Collection<Countries> gettingCountries() {
	return world.values();
}

}
