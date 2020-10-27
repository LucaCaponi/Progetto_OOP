package ProgettoOOP.app.filters;
/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * La classe Filterscountry permette di richiamare la lista dei paesi caricati con la chiamata POST suddivisi in base al continente. 
 * Il continente viene richiesto dall'utente e tramite una GET e la rotta /countries/{continent} si visualizza la lista filtrata
 */

import java.util.Map;

import ProgettoOOP.app.exception.NotValidContinent;
import ProgettoOOP.app.model.Countries;



public class Filterscountry {
	
	  public static Map<String,Countries> gettingfilterCountries(String cont) {
		  
		  if(cont.toLowerCase().contentEquals("europe"))
			  return Continents.getEurope();
		  else if(cont.toLowerCase().contentEquals("asia"))
			  return Continents.getAsia();
		  else if(cont.toLowerCase().contentEquals("africa"))
			  return Continents.getAfrica();
		  else if(cont.toLowerCase().contentEquals("northamerica"))
			  return Continents.getNorth();
		  else if(cont.toLowerCase().contentEquals("southamerica"))
			  return Continents.getSouth();
		  else if(cont.toLowerCase().contentEquals("oceania"))
			  return Continents.getOceania();
		  else if(cont.toLowerCase().contentEquals("antarctica"))
			  return Continents.getAntar();
		  else throw new NotValidContinent();

	 
}}
