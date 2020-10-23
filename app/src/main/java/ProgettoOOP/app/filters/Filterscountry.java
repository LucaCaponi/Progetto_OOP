package ProgettoOOP.app.filters;
/**
 * 
 * @author Federico Catalini
 * @author Luca Caponi
 * 
 * La classe Filterscountry permette di richiamare la lista dei paesi caricati con la chiamata POST suddivisi in base al continente. 
 * Il continente viene richiesto dall'utente tramite la rotta /countries/{continent}
 */

import java.util.Map;

import ProgettoOOP.app.exception.NotValidContinent;
import ProgettoOOP.app.model.Continents;
import ProgettoOOP.app.model.Countries;



public class Filterscountry {
	
	  public static Map<String,Countries> gettingfilterCountries(String cont) {
		switch(cont)
		{
			case "europe": case "EUROPE" : case "Europe" : return  Continents.getEurope();
			
			case "asia": case "ASIA": case "Asia":return Continents.getAsia();
			
			case "africa": case "AFRICA": case "Africa": return Continents.getAfrica();
			
			case "northamerica": case "NORTHAMERICA" : case "NorthAmerica":return Continents.getNorth();
			
			case "southamerica": case "SOUTHAMERICA" : case "SouthAmerica": return Continents.getSouth();
			
			case "oceania": case "OCEANIA" : case "Oceania":return Continents.getOceania();
			
			case "antarctica": case "ANTARCTICA" : case "Antarctica": return Continents.getAntar();
			
			default: throw new NotValidContinent();
			
		}
	
	 
}}
