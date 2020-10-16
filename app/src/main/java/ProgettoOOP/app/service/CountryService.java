package ProgettoOOP.app.service;

import java.io.IOException;
import java.util.Collection;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.CountryAllStatus;

public interface CountryService {
	
	public abstract void InsertCountry(Countries country, CountryAllStatus status) throws Exception;
	public abstract void DeleteCountry(String ISO2);
	public abstract String totalCountries() throws IOException;
	public abstract String totalStatusCountries(String from, String to) throws IOException;
	public abstract Collection<Countries> gettingCountries();
	public abstract Collection<CountryAllStatus> gettingAll();

}