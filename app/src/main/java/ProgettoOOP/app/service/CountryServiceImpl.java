package ProgettoOOP.app.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ProgettoOOP.app.model.Countries;

@Service
public class CountryServiceImpl implements CountryService {
private static Set<Countries> world= new HashSet<>();

public CountryServiceImpl() {

Countries nation = new Countries("Italy", "italy", "IT");
//nation.setCountry("Italy");
//nation.setSlug("italy");
//nation.setISO2("IT");
world.add(nation);
}

@SuppressWarnings("unlikely-arg-type")
@Override
public void InsertCountry(Countries country) {
	// TODO Auto-generated method stub
	if (world.contains(country.getISO2())) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Existing ISO2...");
	}
world.add(country);
}


@SuppressWarnings("unlikely-arg-type")
@Override
public void DeleteCountry(String ISO2) {
	// TODO Auto-generated method stub
	world.remove(ISO2);
}

@Override
public Set<Countries> selectCountries() {
	// TODO Auto-generated method stub
	return world;
}

}
