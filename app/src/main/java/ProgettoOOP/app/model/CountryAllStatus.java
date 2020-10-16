package ProgettoOOP.app.model;

public class CountryAllStatus {
private String Country;
private String CountryCode;
private String Province;
private String City;
private String CityCode;
private double Lat;
private double Lon;
private int Confirmed;
private int Deaths;
private int Recovered;
private int Active;
private String Date;


public CountryAllStatus(String country, String countryCode, String province, String city, String cityCode, double lat,
		double lon, int confirmed, int deaths, int recovered, int active, String date) {
	this.Country = country;
	this.CountryCode = countryCode;
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

public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	this.Country = country;
}
public String getCountryCode() {
	return CountryCode;
}
public void setCountryCode(String countryCode) {
	this.CountryCode = countryCode;
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
public int getConfirmed() {
	return Confirmed;
}
public void setConfirmed(int confirmed) {
	this.Confirmed = confirmed;
}
public int getDeaths() {
	return Deaths;
}
public void setDeaths(int deaths) {
	this.Deaths = deaths;
}
public int getRecovered() {
	return Recovered;
}
public void setRecovered(int recovered) {
	this.Recovered = recovered;
}
public int getActive() {
	return Active;
}
public void setActive(int active) {
	this.Active = active;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	this.Date = date;
}
	
}
