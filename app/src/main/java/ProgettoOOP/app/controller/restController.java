package ProgettoOOP.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ProgettoOOP.app.model.getCovidCases;

@RestController
public class restController {
	@GetMapping("/hello")
	public getCovidCases exampleMethod(@RequestParam(name="param1", defaultValue="World") String param1) {
		return new getCovidCases("Mario", "Rossi");
	}
	@PostMapping("/hello")
	public getCovidCases exampleMethod2(@RequestBody getCovidCases body) {
		return body;
	}
}
