package ProgettoOOP.app.model;

public class getCountryContinent {
	private String country;
	private String continent;
	public getCountryContinent(String country, String continent) {
		this.country = country;
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinente(String continent) {
		this.continent = continent;
	}

}
