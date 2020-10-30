package ProgettoOOP.app.filters;

import java.util.LinkedHashMap;
import java.util.Map;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.model.World;

/**
 *
 * La classe Continent serve per catalogare i paesi inseriti dall'utente secondo
 * il continente di appartenenza.
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 */

public class Continents {

	private static Map<String, Countries> europe = new LinkedHashMap<>();
	private static Map<String, Countries> asia = new LinkedHashMap<>();
	private static Map<String, Countries> africa = new LinkedHashMap<>();
	private static Map<String, Countries> north = new LinkedHashMap<>();
	private static Map<String, Countries> south = new LinkedHashMap<>();
	private static Map<String, Countries> oceania = new LinkedHashMap<>();
	private static Map<String, Countries> antar = new LinkedHashMap<>();

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getEurope() {
		return europe;
	}

	/**
	 * 
	 * @param europe
	 */
	public static void setEurope(Map<String, Countries> europe) {
		Continents.europe = europe;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getAsia() {
		return asia;
	}

	/**
	 * 
	 * @param asia
	 */
	public static void setAsia(Map<String, Countries> asia) {
		Continents.asia = asia;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getAfrica() {
		return africa;
	}

	/**
	 * 
	 * @param africa
	 */
	public static void setAfrica(Map<String, Countries> africa) {
		Continents.africa = africa;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getNorth() {
		return north;
	}

	/**
	 * 
	 * @param north
	 */
	public static void setNorth(Map<String, Countries> north) {
		Continents.north = north;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getSouth() {
		return south;
	}

	/**
	 * 
	 * @param south
	 */
	public static void setSouth(Map<String, Countries> south) {
		Continents.south = south;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getOceania() {
		return oceania;
	}

	/**
	 * 
	 * @param oceania
	 */
	public static void setOceania(Map<String, Countries> oceania) {
		Continents.oceania = oceania;
	}

	/**
	 * 
	 * @return
	 */
	public static Map<String, Countries> getAntar() {
		return antar;
	}

	/**
	 * 
	 * @param antar
	 */
	public static void setAntar(Map<String, Countries> antar) {
		Continents.antar = antar;
	}

	private static String[] Europe = { "ALA Aland Islands", "Albania", "Andorra", "Austria", "Belarus", "Belgium",
			"Bosnia and Herzegovina", "Bulgaria", "Croatia", "Cyprus", "Czech Republic", "Denmark", "Estonia",
			"Faroe Islands", "Finland", "France", "Germany", "Gibraltar", "Greece", "Guernsey",
			"Holy See (Vatican City State)", "Hungary", "Iceland", "Ireland", "Isle of Man", "Italy", "Jersey",
			"Latvia", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia, Republic of", "Malta", "Moldova",
			"Monaco", "Montenegro", "Netherlands", "Norway", "Poland", "Portugal", "Republic of Kosovo", "Romania",
			"Russian Federation", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain",
			"Svalbard and Jan Mayen Islands", "Sweden", "Switzerland", "Ukraine", "United Kingdom"

	};

	private static String[] Asia = { "Afghanistan", "Armenia", "Azerbaijan", "Bahrain", "Bangladesh", "Bhutan",
			"British Indian Ocean Territory", "Brunei Darussalam", "Cambodia", "China", "Christmas Island",
			"Cocos (Keeling) Islands", "Georgia", "Hong Kong, SAR China", "India", "Indonesia",
			"Iran, Islamic Republic of", "Iraq", "Israel", "Japan", "Jordan", "Kazakhstan", "Korea (North)",
			"Korea (South)", "Kuwait", "Kyrgyzstan", "Lao PDR", "Lebanon", "Macao, SAR China", "Malaysia", "Maldives",
			"Mongolia", "Myanmar", "Nepal", "Oman", "Pakistan", "Palestinian Territory", "Philippines", "Qatar",
			"Saudi Arabia", "Singapore", "Sri Lanka", "Syrian Arab Republic (Syria)", "Taiwan, Republic of China",
			"Tajikistan", "Thailand", "Turkey", "Turkmenistan", "United Arab Emirates", "Uzbekistan", "Viet Nam",
			"Yemen" };

	private static String[] NorthAmerica = { "British Virgin Islands", "Anguilla", "Antigua and Barbuda", "Aruba",
			"Bahamas", "Barbados", "Belize", "Bermuda", "Canada", "Cayman Islands", "Costa Rica", "Cuba", "Dominica",
			"Dominican Republic", "El Salvador", "Greenland", "Grenada", "Guadeloupe", "Guatemala", "Haiti", "Honduras",
			"Jamaica", "Martinique", "Mexico", "Montserrat", "Netherlands Antilles", "Nicaragua", "Panama",
			"Puerto Rico", "Saint Kitts and Nevis", "Saint Lucia", "Saint Pierre and Miquelon",
			"Saint Vincent and Grenadines", "Saint-Barthélemy", "Saint-Martin (French part)", "Trinidad and Tobago",
			"Turks and Caicos Islands", "United States of America", "Virgin Islands, US",

	};

	private static String[] SouthAmerica = { "Guyana", "Argentina", "Bolivia", "Brazil", "Chile", "Colombia", "Ecuador",
			"Falkland Islands (Malvinas)", "French Guiana", "Paraguay", "Peru", "Suriname", "Uruguay",
			"Venezuela (Bolivarian Republic)",

	};

	private static String[] Oceania = { "American Samoa", "Australia", "Cook Islands", "Fiji", "French Polynesia",
			"Guam", "Kiribati", "Marshall Islands", "Micronesia, Federated States of", "Nauru", "New Caledonia",
			"New Zealand", "Niue", "Norfolk Island", "Northern Mariana Islands", "Palau", "Papua New Guinea",
			"Pitcairn", "Samoa", "Solomon Islands", "Timor-Leste", "Tokelau", "Tonga", "Tuvalu",
			"US Minor Outlying Islands", "Vanuatu", "Wallis and Futuna Islands",

	};

	private static String[] Africa = { "Algeria", "Angola", "Benin", "Botswana", "Burkina Faso", "Burundi", "Cameroon",
			"Cape Verde", "Central African Republic", "Chad", "Comoros", "Congo (Brazzaville)", "Congo (Kinshasa)",
			"Côte d'Ivoire", "Djibouti", "Egypt", "Equatorial Guinea", "Eritrea", "Ethiopia", "Gabon", "Gambia",
			"Ghana", "Guinea", "Guinea-Bissau", "Kenya", "Lesotho", "Liberia", "Libya", "Madagascar", "Malawi", "Mali",
			"Mauritania", "Mauritius", "Mayotte", "Morocco", "Mozambique", "Namibia", "Niger", "Nigeria", "Réunion",
			"Rwanda", "Saint Helena", "Sao Tome and Principe", "Senegal", "Seychelles", "Sierra Leone", "Somalia",
			"South Africa", "South Sudan", "Sudan", "Swaziland", "Tanzania, United Republic of", "Togo", "Tunisia",
			"Uganda", "Western Sahara", "Zambia", "Zimbabwe" };

	private static String[] Antarctica = { "Antarctica", "Bouvet Island", "French Southern Territories",
			"Heard and Mcdonald Islands", "South Georgia and the South Sandwich Islands"

	};

	/**
	 * 
	 * Il metodo 'returnContinent()' ha una doppia funzione: 1- serve ad informare
	 * l'utente a quale continente appartiene il paese appena inserito in Postman
	 * tramite la rotta "/countries" con la POST. 2- inserisce il paese appena
	 * caricato dall'utente all'interno del LinkedHashMap del continente di
	 * appartenenza.
	 * 
	 * @return continent
	 * @throws Exception
	 */
	public static String returnContinent() throws Exception {
		String continent = "Not a Country";
		World.getlastname();
		for (String c : Europe)
			if (c.contains(World.getlastname())) {
				continent = "EUROPE";
				getEurope().put(World.getlastISO2(), World.getlastcountries());
				setEurope(europe);
			}

		for (String c : Asia)
			if (c.contains(World.getlastname())) {
				continent = "ASIA";
				getAsia().put(World.getlastISO2(), World.getlastcountries());
				setAsia(asia);
			}

		for (String c : Africa)
			if (c.contains(World.getlastname())) {
				continent = "AFRICA";
				getAfrica().put(World.getlastISO2(), World.getlastcountries());
				setAfrica(africa);
			}

		for (String c : Oceania)
			if (c.contains(World.getlastname())) {
				continent = "OCEANIA";
				getOceania().put(World.getlastISO2(), World.getlastcountries());
				setOceania(oceania);
			}

		for (String c : NorthAmerica)
			if (c.contains(World.getlastname())) {
				continent = "NORTH AMERICA";
				getNorth().put(World.getlastISO2(), World.getlastcountries());
				setNorth(north);
			}

		for (String c : SouthAmerica)
			if (c.contains(World.getlastname())) {
				continent = "SOUTH AMERICA";
				getSouth().put(World.getlastISO2(), World.getlastcountries());
				setSouth(south);
			}

		for (String c : Antarctica)
			if (c.contains(World.getlastname())) {
				continent = "ANTARCTICA";
				getAntar().put(World.getlastISO2(), World.getlastcountries());
				setAntar(antar);
			}

		return continent;
	}

}
