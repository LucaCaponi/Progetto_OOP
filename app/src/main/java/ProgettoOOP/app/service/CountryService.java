package ProgettoOOP.app.service;

import java.util.Collection;

import ProgettoOOP.app.model.Countries;

public interface CountryService {
	
	public abstract void InsertCountry(Countries country);
	public abstract void UpdateCountry(String ISO2, Countries country);
	public abstract void DeleteCountry(String ISO2);
	public abstract Collection<Countries> selectCountries();

}
