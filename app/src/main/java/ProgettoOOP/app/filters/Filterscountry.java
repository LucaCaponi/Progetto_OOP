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
		  else if(cont.contentEquals("asia")||cont.contentEquals("ASIA")||cont.contentEquals("Asia"))
			  return Continents.getAsia();
		  else if(cont.contentEquals("africa")||cont.contentEquals("AFRICA")||cont.contentEquals("Africa"))
			  return Continents.getAfrica();
		  else if(cont.contentEquals("northamerica")||cont.contentEquals("NORTHAMERICA")||cont.contentEquals("NorthAmerica"))
			  return Continents.getNorth();
		  else if(cont.contentEquals("southamerica")||cont.contentEquals("SOUTHAMERICA")||cont.contentEquals("SouthAmerica"))
			  return Continents.getSouth();
		  else if(cont.contentEquals("oceania")||cont.contentEquals("OCEANIA")||cont.contentEquals("Oceania"))
			  return Continents.getOceania();
		  else if(cont.contentEquals("antarctica")||cont.contentEquals("ANTARCTICA")||cont.contentEquals("Antarctica"))
			  return Continents.getAntar();
		  else throw new NotValidContinent();

	 
}}
