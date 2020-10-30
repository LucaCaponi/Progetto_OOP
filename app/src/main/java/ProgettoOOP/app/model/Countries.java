package ProgettoOOP.app.model;

/**
 * 
 * La classe Countries serve per gestire l'API "GET Countries", creando oggetti
 * di tipo 'Countries'.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 */
public class Countries {
	private String Country;
	private String Slug;
	private String ISO2;

	/**
	 * 
	 * @param country
	 * @param slug
	 * @param iSO2
	 */
	public Countries(String country, String slug, String iSO2) {
		this.Country = country;
		this.Slug = slug;
		this.ISO2 = iSO2;
	}

	/**
	 * 
	 * @return
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * 
	 * @param country
	 */
	public void setCountry(String country) {
		this.Country = country;
	}

	/**
	 * 
	 * @return
	 */
	public String getSlug() {
		return Slug;
	}

	/**
	 * 
	 * @param slug
	 */
	public void setSlug(String slug) {
		this.Slug = slug;
	}

	/**
	 * 
	 * @return
	 */
	public String getISO2() {
		return ISO2;
	}

	/**
	 * 
	 * @param iSO2
	 */
	public void setISO2(String iSO2) {
		this.ISO2 = iSO2;
	}

}
