package ProgettoOOP.app.model;

public class getCountryAllStatus {
	
	private String CountryISO;
	private String Country;
	private String Continent;
	private String Date;
	private int TotalCases;
	private int NewCases;
	private int TotalDeaths;
	private int NewDeaths;
	private double TotalCasesPerMillion;
	private double NewCasesPerMillion;
	private double TotalDeathsPerMillion;
	private double NewDeathsPerMillion;
	private double StringencyIndex;
	private double DailyIncidenceConfirmedCases;
	private double DailyIncidenceConfirmedDeaths;
	private double DailyIncidenceConfirmedCasesPerMillion;
	private double DailyIncidenceConfirmedDeathsPerMillion;
	private double IncidenceRiskConfirmedPerHundredThousand;
	private double IncidenceRiskDeathsPerHundredThousand;
	private double IncidenceRiskNewConfirmedPerHundredThousand;
	private double IncidenceRiskNewDeathsPerHundredThousand;
	private double CaseFatalityRatio;
	


	public getCountryAllStatus(String countryISO, String country, String continent, String date, int totalCases,
			int newCases, int totalDeaths, int newDeaths, double totalCasesPerMillion, double newCasesPerMillion,
			double totalDeathsPerMillion, double newDeathsPerMillion, double stringencyIndex,
			double dailyIncidenceConfirmedCases, double dailyIncidenceConfirmedDeaths,
			double dailyIncidenceConfirmedCasesPerMillion, double dailyIncidenceConfirmedDeathsPerMillion,
			double incidenceRiskConfirmedPerHundredThousand, double incidenceRiskDeathsPerHundredThousand,
			double incidenceRiskNewConfirmedPerHundredThousand, double incidenceRiskNewDeathsPerHundredThousand,
			double caseFatalityRatio) 
	{
		this.CountryISO = countryISO;
		this.Country = country;
		this.Continent = continent;
		this.Date = date;
		this.TotalCases = totalCases;
		this.NewCases = newCases;
		this.TotalDeaths = totalDeaths;
		this.NewDeaths = newDeaths;
		this.TotalCasesPerMillion = totalCasesPerMillion;
		this.NewCasesPerMillion = newCasesPerMillion;
		this.TotalDeathsPerMillion = totalDeathsPerMillion;
		this.NewDeathsPerMillion = newDeathsPerMillion;
		this.StringencyIndex = stringencyIndex;
		this.DailyIncidenceConfirmedCases = dailyIncidenceConfirmedCases;
		this.DailyIncidenceConfirmedDeaths = dailyIncidenceConfirmedDeaths;
		this.DailyIncidenceConfirmedCasesPerMillion = dailyIncidenceConfirmedCasesPerMillion;
		this.DailyIncidenceConfirmedDeathsPerMillion = dailyIncidenceConfirmedDeathsPerMillion;
		this.IncidenceRiskConfirmedPerHundredThousand = incidenceRiskConfirmedPerHundredThousand;
		this.IncidenceRiskDeathsPerHundredThousand = incidenceRiskDeathsPerHundredThousand;
		this.IncidenceRiskNewConfirmedPerHundredThousand = incidenceRiskNewConfirmedPerHundredThousand;
		this.IncidenceRiskNewDeathsPerHundredThousand = incidenceRiskNewDeathsPerHundredThousand;
		this.CaseFatalityRatio = caseFatalityRatio;
	}


	public String getCountryISO() {
		return CountryISO;
	}
	

	public void setCountryISO(String countryISO) {
		CountryISO = countryISO;
	}


	public String getCountry() {
		return Country;
	}


	public void setCountry(String country) {
		Country = country;
	}


	public String getContinent() {
		return Continent;
	}


	public void setContinent(String continent) {
		Continent = continent;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public int getTotalCases() {
		return TotalCases;
	}


	public void setTotalCases(int totalCases) {
		TotalCases = totalCases;
	}


	public int getNewCases() {
		return NewCases;
	}


	public void setNewCases(int newCases) {
		NewCases = newCases;
	}


	public int getTotalDeaths() {
		return TotalDeaths;
	}


	public void setTotalDeaths(int totalDeaths) {
		TotalDeaths = totalDeaths;
	}


	public int getNewDeaths() {
		return NewDeaths;
	}


	public void setNewDeaths(int newDeaths) {
		NewDeaths = newDeaths;
	}


	public double getTotalCasesPerMillion() {
		return TotalCasesPerMillion;
	}


	public void setTotalCasesPerMillion(double totalCasesPerMillion) {
		TotalCasesPerMillion = totalCasesPerMillion;
	}


	public double getNewCasesPerMillion() {
		return NewCasesPerMillion;
	}


	public void setNewCasesPerMillion(double newCasesPerMillion) {
		NewCasesPerMillion = newCasesPerMillion;
	}


	public double getTotalDeathsPerMillion() {
		return TotalDeathsPerMillion;
	}


	public void setTotalDeathsPerMillion(double totalDeathsPerMillion) {
		TotalDeathsPerMillion = totalDeathsPerMillion;
	}


	public double getNewDeathsPerMillion() {
		return NewDeathsPerMillion;
	}


	public void setNewDeathsPerMillion(double newDeathsPerMillion) {
		NewDeathsPerMillion = newDeathsPerMillion;
	}


	public double getStringencyIndex() {
		return StringencyIndex;
	}


	public void setStringencyIndex(double stringencyIndex) {
		StringencyIndex = stringencyIndex;
	}


	public double getDailyIncidenceConfirmedCases() {
		return DailyIncidenceConfirmedCases;
	}


	public void setDailyIncidenceConfirmedCases(double dailyIncidenceConfirmedCases) {
		DailyIncidenceConfirmedCases = dailyIncidenceConfirmedCases;
	}


	public double getDailyIncidenceConfirmedDeaths() {
		return DailyIncidenceConfirmedDeaths;
	}


	public void setDailyIncidenceConfirmedDeaths(double dailyIncidenceConfirmedDeaths) {
		DailyIncidenceConfirmedDeaths = dailyIncidenceConfirmedDeaths;
	}


	public double getDailyIncidenceConfirmedCasesPerMillion() {
		return DailyIncidenceConfirmedCasesPerMillion;
	}


	public void setDailyIncidenceConfirmedCasesPerMillion(double dailyIncidenceConfirmedCasesPerMillion) {
		DailyIncidenceConfirmedCasesPerMillion = dailyIncidenceConfirmedCasesPerMillion;
	}


	public double getDailyIncidenceConfirmedDeathsPerMillion() {
		return DailyIncidenceConfirmedDeathsPerMillion;
	}


	public void setDailyIncidenceConfirmedDeathsPerMillion(double dailyIncidenceConfirmedDeathsPerMillion) {
		DailyIncidenceConfirmedDeathsPerMillion = dailyIncidenceConfirmedDeathsPerMillion;
	}


	public double getIncidenceRiskConfirmedPerHundredThousand() {
		return IncidenceRiskConfirmedPerHundredThousand;
	}


	public void setIncidenceRiskConfirmedPerHundredThousand(double incidenceRiskConfirmedPerHundredThousand) {
		IncidenceRiskConfirmedPerHundredThousand = incidenceRiskConfirmedPerHundredThousand;
	}


	public double getIncidenceRiskDeathsPerHundredThousand() {
		return IncidenceRiskDeathsPerHundredThousand;
	}


	public void setIncidenceRiskDeathsPerHundredThousand(double incidenceRiskDeathsPerHundredThousand) {
		IncidenceRiskDeathsPerHundredThousand = incidenceRiskDeathsPerHundredThousand;
	}


	public double getIncidenceRiskNewConfirmedPerHundredThousand() {
		return IncidenceRiskNewConfirmedPerHundredThousand;
	}


	public void setIncidenceRiskNewConfirmedPerHundredThousand(double incidenceRiskNewConfirmedPerHundredThousand) {
		IncidenceRiskNewConfirmedPerHundredThousand = incidenceRiskNewConfirmedPerHundredThousand;
	}


	public double getIncidenceRiskNewDeathsPerHundredThousand() {
		return IncidenceRiskNewDeathsPerHundredThousand;
	}


	public void setIncidenceRiskNewDeathsPerHundredThousand(double incidenceRiskNewDeathsPerHundredThousand) {
		IncidenceRiskNewDeathsPerHundredThousand = incidenceRiskNewDeathsPerHundredThousand;
	}


	public double getCaseFatalityRatio() {
		return CaseFatalityRatio;
	}


	public void setCaseFatalityRatio(double caseFatalityRatio) {
		CaseFatalityRatio = caseFatalityRatio;
	}
}
