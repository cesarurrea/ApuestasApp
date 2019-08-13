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

import co.com.apuestas.persistence.model.Colilla;
import co.com.apuestas.services.ColillaService;

@RestController
@RequestMapping("/services")
public class ColillaRestController implements IGenericRestController<Colilla, BigDecimal> {

	private final ColillaService service;
	
	@Autowired
	public ColillaRestController(ColillaService service) {
		super();
		this.service = service;
	}

	@Override
	@GetMapping(value = "/colilla", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Colilla> findAll() {

		return service.findAll();
	}

	@Override
	@GetMapping(value = "/colilla/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Colilla find(@PathVariable("id") BigDecimal id) {

		return service.find(id);
	}

	@Override
	@PostMapping(value = "/colilla", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void save(@RequestBody Colilla entity) {
		service.create(entity);

	}

	@Override
	@PutMapping(value = "/colilla", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void create(@RequestBody Colilla entity) {
		service.create(entity);

	}

	@Override
	@DeleteMapping(value = "/colilla", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@RequestBody Colilla entity) {
		service.remove(entity);

	}

}
