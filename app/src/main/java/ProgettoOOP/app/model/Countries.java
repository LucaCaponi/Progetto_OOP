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
	 * @param Country
	 * @param Slug
	 * @param ISO2
	 */
	public Countries(String Country, String Slug, String ISO2) {
		this.Country = Country;
		this.Slug = Slug;
		this.ISO2 = ISO2;
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
	public void setCountry(String Country) {
		this.Country = Country;
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
	public void setSlug(String Slug) {
		this.Slug = Slug;
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
	public void setISO2(String ISO2) {
		this.ISO2 = ISO2;
	}

}
