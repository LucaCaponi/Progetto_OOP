package ProgettoOOP.app.service;

import ProgettoOOP.app.model.Countries;

public interface CountryService {
	
	public abstract void InsertCountry(Countries country);
	public abstract void DeleteCountry(String ISO2);
	public abstract String totalCountries() throws Exception;
	public abstract String totalStatusCountries(String from, String to) throws Exception;

}
