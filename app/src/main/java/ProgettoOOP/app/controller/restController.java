package ProgettoOOP.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.service.CountryService;

@RestController
public class restController{
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<Object> getCountries()
	{	
		return new ResponseEntity<>(countryService.selectCountries(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries/{ISO2}", method = RequestMethod.PUT)
	public ResponseEntity<Object> UpdateCountry(@PathVariable("ISO2") String ISO2, @RequestBody Countries country)
	{	
		countryService.UpdateCountry(ISO2, country);
		return new ResponseEntity<>("Country is updated successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries/{ISO2}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("ISO2") String ISO2)
	{	
		countryService.DeleteCountry(ISO2);
		return new ResponseEntity<>("Country is deleted successfully", HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.POST)
	public ResponseEntity<Object> InsertCountry(@RequestBody Countries country)
	{	
		countryService.InsertCountry(country);
		return new ResponseEntity<>("Country is created successfully", HttpStatus.CREATED);
	}
	
	
	
	/* 
	 * 
	 * @RequestMapping(value = "/premium/country/{{country}}", method = RequestMethod.GET)
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
	
	*/
	
}