package ProgettoOOP.app.model;


public class Continents {
	


	private static String[] Europe= {
			"ALA Aland Islands",
			"Albania",
			"Andorra",
			"Austria",
			"Belarus",
			"Belgium",
			"Bosnia and Herzegovina",
			"Bulgaria",
			"Croatia",
			"Cyprus",
			"Czech Republic",
			"Denmark",
			"Estonia",
			"Faroe Islands",
			"Finland",
			"France",
			"Germany",
			"Gibraltar",
			"Greece",
			"Guernsey",
			"Holy See (Vatican City State)",
			"Hungary",
			"Iceland",
			"Ireland",
			"Isle of Man",
			"Italy",
			"Jersey",
			"Latvia",
			"Liechtenstein",
			"Lithuania",
			"Luxembourg",
			"Macedonia, Republic of",
			"Malta",
			"Moldova",
			"Monaco",
			"Montenegro",
			"Netherlands",
			"Norway",
			"Poland",
			"Portugal",
			"Republic of Kosovo",
			"Romania",
			"Russian Federation",
			"San Marino",
			"Serbia",
			"Slovakia",
			"Slovenia",
			"Spain",
			"Svalbard and Jan Mayen Islands",
			"Sweden",
			"Switzerland",
			"Ukraine",
			"United Kingdom"

	};
	
	private static String[] Asia= {
			"Afghanistan",
			"Armenia",
			"Azerbaijan",
			"Bahrain",
			"Bangladesh",
			"Bhutan",
			"British Indian Ocean Territory",
			"Brunei Darussalam",
			"Cambodia",
			"China",
			"Christmas Island",
			"Cocos (Keeling) Islands",
			"Georgia",
			"Hong Kong, SAR China",
			"India",
			"Indonesia	",
			"Iran, Islamic Republic of",
			"Iraq",
			"Israel",
			"Japan",
			"Jordan",
			"Kazakhstan",
			"Korea (North)",
			"Korea (South)",
			"Kuwait",
			"Kyrgyzstan",
			"Lao PDR",
			"Lebanon",
			"Macao, SAR China",
			"Malaysia",
			"Maldives",
			"Mongolia",
			"Myanmar",
			"Nepal",
			"Oman",
			"Pakistan",
			"Palestinian Territory",
			"Philippines",
			"Qatar",
			"Saudi Arabia",
			"Singapore",
			"Sri Lanka",
			"Syrian Arab Republic (Syria)",
			"Taiwan, Republic of China",
			"Tajikistan",
			"Thailand",
			"Turkey",
			"Turkmenistan",
			"United Arab Emirates",
			"Uzbekistan",
			"Viet Nam",
			"Yemen"
	};

	private static String[] NorthAmerica= {
			"British Virgin Islands",
			"Anguilla",
			"Antigua and Barbuda",
			"Aruba",
			"Bahamas",
			"Barbados",
			"Belize",
			"Bermuda",
			"Canada",
			"Cayman Islands",
			"Costa Rica",
			"Cuba",
			"Dominica",
			"Dominican Republic",
			"El Salvador",
			"Greenland",
			"Grenada",
			"Guadeloupe",
			"Guatemala",
			"Haiti",
			"Honduras",
			"Jamaica",
			"Martinique",
			"Mexico	",
			"Montserrat",
			"Netherlands Antilles",
			"Nicaragua",
			"Panama",
			"Puerto Rico",
			"Saint Kitts and Nevis",
			"Saint Lucia",
			"Saint Pierre and Miquelon",
			"Saint Vincent and Grenadines",
			"Saint-Barthélemy",
			"Saint-Martin (French part)",
			"Trinidad and Tobago",
			"Turks and Caicos Islands",
			"United States of America",
			"Virgin Islands, US",

			
	};
	
	private static String[] SouthAmerica= {
			"Guyana",
			"Argentina",
			"Bolivia",
			"Brazil",
			"Chile",
			"Colombia",
			"Ecuador",
			"Falkland Islands (Malvinas)",
			"French Guiana",
			"Paraguay",
			"Peru",
			"Suriname",
			"Uruguay",
			"Venezuela (Bolivarian Republic)",

			
			
	};
	
	private static String[] Oceania= {
			"American Samoa",
			"Australia",
			"Cook Islands",
			"Fiji",
			"French Polynesia",
			"Guam",
			"Kiribati",
			"Marshall Islands",
			"Micronesia, Federated States of",
			"Nauru",
			"New Caledonia",
			"New Zealand",
			"Niue",
			"Norfolk Island",
			"Northern Mariana Islands",
			"Palau",
			"Papua New Guinea",
			"Pitcairn",
			"Samoa",
			"Solomon Islands",
			"Timor-Leste",
			"Tokelau",
			"Tonga",
			"Tuvalu",
			"US Minor Outlying Islands",
			"Vanuatu",
			"Wallis and Futuna Islands",

	};
	
	private static String[] Africa= {
			"Algeria",
			"Angola",
			"Benin",
			"Botswana",
			"Burkina Faso",
			"Burundi",
			"Cameroon",
			"Cape Verde",
			"Central African Republic",
			"Chad",
			"Comoros",
			"Congo (Brazzaville)",
			"Congo (Kinshasa)",
			"Côte d'Ivoire",
			"Djibouti",
			"Egypt",
			"Equatorial Guinea",
			"Eritrea",
			"Ethiopia",
			"Gabon",
			"Gambia",
			"Ghana",
			"Guinea",
			"Guinea-Bissau",
			"Kenya",
			"Lesotho",
			"Liberia",
			"Libya",
			"Madagascar",
			"Malawi",
			"Mali",
			"Mauritania",
			"Mauritius",
			"Mayotte",
			"Morocco",
			"Mozambique",
			"Namibia",
			"Niger",
			"Nigeria",
			"Réunion",
			"Rwanda",
			"Saint Helena",
			"Sao Tome and Principe",
			"Senegal",
			"Seychelles",
			"Sierra Leone",
			"Somalia",
			"South Africa",
			"South Sudan",
			"Sudan",
			"Swaziland",
			"Tanzania, United Republic of",
			"Togo",
			"Tunisia",
			"Uganda",
			"Western Sahara",
			"Zambia",
			"Zimbabwe"		
	};
	
	private static String[] Antarctica={
			"Antarctica",
			"Bouvet Island",
			"French Southern Territories",
			"Heard and Mcdonald Islands",
			"South Georgia and the South Sandwich Islands"

	};
	

	
public static String returnContinent() throws Exception {
	String continent = "Not a Country";
	World.getlastname();
	for (String c : Europe) 
	if (c.contains(World.getlastname())) continent="EUROPE";
	
	for (String c : Asia) 
		if (c.contains(World.getlastname())) continent="ASIA";
	
	for (String c : Africa) 
		if (c.contains(World.getlastname())) continent="AFRICA";
	
	for (String c : Oceania) 
		if (c.contains(World.getlastname())) continent="OCEANIA";
	
	for (String c : NorthAmerica) 
		if (c.contains(World.getlastname())) continent="NORTH AMERICA";
	
	for (String c : SouthAmerica) 
		if (c.contains(World.getlastname())) continent="SOUTH AMERICA";
	
	for (String c : Antarctica) 
		if (c.contains(World.getlastname())) continent="ANTARCTICA";
	
	return continent;}

	
}



