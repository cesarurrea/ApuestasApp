package co.com.apuestas.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.apuestas.persistence.model.Premio;
import co.com.apuestas.services.PremioService;

@RestController
@RequestMapping("/services")
public class PremioRestController {
	
	private final PremioService service;

	public PremioRestController(PremioService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping(value = "/premio/{colilla}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Premio> consultarPremio(@PathVariable("colilla") BigDecimal colilla) {		
		return service.consultarPremio(colilla);
	}
	
	

}
