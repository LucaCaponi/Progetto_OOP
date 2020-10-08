package ProgettoOOP.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.model.CountryAllStatus;
import ProgettoOOP.app.service.CountryService;

@RestController
public class restController {
	@Autowired
	CountryService countryService;
	@RequestMapping(value = "/countries")
	public ResponseEntity<Object> getCountries()
	{	
		return new ResponseEntity<>(countryService.selectCountries(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/premium/country/{{country}}", method = RequestMethod.GET)
	public ResponseEntity<Object> getCountryAllStatus(@RequestParam(name="from", defaultValue="2020-03-01T00:00:00Z") String from,
			@RequestParam(name="to", defaultValue="2020-04-01T00:00:00Z") String to) 
	{	
		return new ResponseEntity<>();
	}
	
	@RequestMapping(value = "/premium/summary", method = RequestMethod.GET)
	public ResponseEntity<Object> getSummary(@RequestParam(name="from", defaultValue="2020-03-01T00:00:00Z") String from,
			@RequestParam(name="to", defaultValue="2020-04-01T00:00:00Z") String to) 
	{	
		return new ResponseEntity<>();
	}
	
	
}