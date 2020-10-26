package ProgettoOOP.app.model;

/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 *
 *         La classe CountryAllStatus serve per gestire l'API "GET BY COUNTRY
 *         ALL STATUS"
 */

public class CountryAllStatus extends Countries{
	
	private String Province;
	private String City;
	private String CityCode;
	private double Lat;
	private double Lon;
	private long Confirmed;
	private long Deaths;
	private long Recovered;
	private long Active;
	private String Date;

	public CountryAllStatus(String country, String slug, String countryCode, String province, String city,
			String cityCode, double lat, double lon, long confirmed, long deaths, long recovered, long active,
			String date) {
		super (country, slug, countryCode);
		this.Province = province;
		this.City = city;
		this.CityCode = cityCode;
		this.Lat = lat;
		this.Lon = lon;
		this.Confirmed = confirmed;
		this.Deaths = deaths;
		this.Recovered = recovered;
		this.Active = active;
		this.Date = date;
	}

	
	public String getProvince() {
		return Province;
	}

	public void setProvince(String province) {
		this.Province = province;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		this.City = city;
	}

	public String getCityCode() {
		return CityCode;
	}

	public void setCityCode(String cityCode) {
		this.CityCode = cityCode;
	}

	public double getLat() {
		return Lat;
	}

	public void setLat(double lat) {
		this.Lat = lat;
	}

	public double getLon() {
		return Lon;
	}

	public void setLon(double lon) {
		this.Lon = lon;
	}

	public long getConfirmed() {
		return Confirmed;
	}

	public void setConfirmed(long confirmed) {
		this.Confirmed = confirmed;
	}

	public long getDeaths() {
		return Deaths;
	}

	public void setDeaths(long deaths) {
		this.Deaths = deaths;
	}

	public long getRecovered() {
		return Recovered;
	}

	public void setRecovered(long recovered) {
		this.Recovered = recovered;
	}

	public long getActive() {
		return Active;
	}

	public void setActive(long active) {
		this.Active = active;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		this.Date = date;
	}

}
