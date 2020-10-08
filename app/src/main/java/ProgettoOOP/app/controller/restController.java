package ProgettoOOP.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.model.getCountryAllStatus;

@RestController
public class restController {
	
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