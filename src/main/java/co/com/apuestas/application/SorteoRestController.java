package co.com.apuestas.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.com.apuestas.persistence.model.Sorteo;
import co.com.apuestas.services.SorteoService;

@RestController
@RequestMapping("/services")
public class SorteoRestController implements IGenericRestController<Sorteo, BigDecimal> {
	
	private final SorteoService service;	
	
	@Autowired	
	public SorteoRestController(SorteoService service) {
		super();
		this.service = service;
	}

	@Override
	@GetMapping(value = "/sorteo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Sorteo> findAll() {
		
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/sorteo/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Sorteo find(@PathVariable("id") BigDecimal id) {		
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/sorteo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Sorteo entity) {
		service.create(entity);
		
	}

	@Override
	@PutMapping(value = "/sorteo", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Sorteo entity) {
		service.create(entity);
		
	}

	@Override
	@DeleteMapping(value = "/sorteo/{id}")
	public void delete(@PathVariable("id") BigDecimal id) {
		service.remove(id);
		
	}

}
