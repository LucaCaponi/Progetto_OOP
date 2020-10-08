package ProgettoOOP.app.model;

public class getCountries {
private String Country;
private String Slug;
private String ISO2;

public getCountries(String country, String slug, String iSO2) {
	this.Country = country;
	this.Slug = slug;
	this.ISO2 = iSO2;
}

public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	this.Country = country;
}

public String getSlug() {
	return Slug;
}
public void setSlug(String slug) {
	this.Slug = slug;
}

public String getISO2() {
	return ISO2;
}
public void setISO2(String iSO2) {
	this.ISO2 = iSO2;
}
}
