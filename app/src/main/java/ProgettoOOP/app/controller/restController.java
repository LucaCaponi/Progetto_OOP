package ProgettoOOP.app.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.exception.ExceptionAbstract;
import ProgettoOOP.app.exception.ExceptionPrincipal;
import ProgettoOOP.app.model.Countries;
import ProgettoOOP.app.service.CountryService;

@RestController
public class restController{
	
	@Autowired
	CountryService countryService;
	
	@RequestMapping(value = "/totalcountries", method = RequestMethod.GET)
	public ResponseEntity<Object> gettotalCountries() throws Exception
	{	
		return new ResponseEntity<>(countryService.totalCountries(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/totalcountryallstatus", method = RequestMethod.GET)
	public ResponseEntity<Object> gettotalCountryAllStatus(@RequestParam(name="from", defaultValue="2020-03-01T00:00:00Z") String from,
			@RequestParam(name="to", defaultValue="2020-04-01T00:00:00Z") String to) throws Exception 
	{	
		return new ResponseEntity<>(countryService.totalStatusCountries(from, to), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.POST) 
	public ResponseEntity<Object> InsertCountry(@RequestBody Countries country) throws Exception
	{	
		countryService.InsertCountry(country);
		return new ResponseEntity<>("Country is created successfully", HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/countries", method = RequestMethod.GET)
	public ResponseEntity<Object> getCountries() throws Exception
	{	
		return new ResponseEntity<>(countryService.gettingCountries(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countries/{ISO2}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@PathVariable("ISO2") String ISO2)
	{	
		countryService.DeleteCountry(ISO2);
		return new ResponseEntity<>("Country is deleted successfully", HttpStatus.OK);
	}
	
	@ExceptionHandler(ExceptionAbstract.class)
	public ResponseEntity<Object> handleExceptionAbstract(ExceptionAbstract e) {
		ExceptionPrincipal error = new ExceptionPrincipal(Calendar.getInstance() , HttpStatus.BAD_REQUEST , e.getClass().getCanonicalName() , e.getMessage());
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}