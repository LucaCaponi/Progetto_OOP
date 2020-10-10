package ProgettoOOP.app.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ProgettoOOP.app.model.Countries;

@Service
public class CountryServiceImpl implements CountryService {
private static Map<String, Countries> countryRepo= new HashMap<>();

public CountryServiceImpl() {

Countries nation= new Countries(null, null, null);
nation.setISO2("IT");
nation.setCountry("Italy");
countryRepo.put(nation.getISO2(), nation);
}

@Override
public void InsertCountry(Countries country) {
	// TODO Auto-generated method stub
	if (countryRepo.containsKey(country.getISO2())) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing ISO2...");
	}
countryRepo.put(country.getISO2(), country);
}

@Override
public void UpdateCountry(String ISO2, Countries country) {
	// TODO Auto-generated method stub
	countryRepo.remove(ISO2);
	country.setISO2(ISO2);
	countryRepo.put(ISO2, country);
	
}


@Override
public void DeleteCountry(String ISO2) {
	// TODO Auto-generated method stub
	countryRepo.remove(ISO2);
}

@Override
public Collection<Countries> selectCountries() {
	// TODO Auto-generated method stub
	return countryRepo.values();
}


}
