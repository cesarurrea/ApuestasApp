package co.com.apuestas.application;

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

import co.com.apuestas.persistence.model.Parametro;
import co.com.apuestas.services.ParametroService;

@RestController
@RequestMapping("/services")
public class ParametroRestController implements IGenericRestController<Parametro, String> {
	
	private final ParametroService service;
	
	@Autowired
	public ParametroRestController(ParametroService service) {
		super();
		this.service = service;
	}

	@Override
	@GetMapping(value = "/parametro", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Parametro> findAll() {		
		return service.findAll();
	}

	@Override
	@GetMapping(value = "/parametro/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Parametro find(@PathVariable("id") String id) {
		
		return service.find(id);
	}

	@Override
	@PostMapping(value = "/parametro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Parametro entity) {
		service.create(entity);
		
	}

	@Override
	@PutMapping(value = "/parametro", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Parametro entity) {
		service.create(entity);
		
	}

	@Override
	@DeleteMapping(value = "/parametro/{id}")
	public void delete(@PathVariable("id") String id) {
		service.remove(id);
		
	}

}
