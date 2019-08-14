package co.com.apuestas.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.apuestas.persistence.model.Premio;
import co.com.apuestas.services.PremioService;

@Controller
@RequestMapping (value="app/premio/")
public class PremioController implements IGenericController<Premio, BigDecimal> {

	private final PremioService service;

	@Autowired
	public PremioController(PremioService service) {
		super();
		this.service = service;
	}

	@Override
	public void create(Premio entity) {
		service.create(entity);

	}

	@Override
	public void edit(Premio entity) {
		service.edit(entity);

	}

	@Override
	public void remove(Premio entity) {
		service.remove(entity.getIdpremio());

	}

	@Override
	public Premio find(BigDecimal id) {

		return service.find(id);
	}

	@Override
	public List<Premio> findAll() {

		return service.findAll();
	}
	
	@RequestMapping(value = "/consultar", method = RequestMethod.GET)
	public @ResponseBody List<Premio> consultarPremio(@RequestParam(name = "colilla") BigDecimal colilla) {		
		return service.consultarPremio(colilla);
	}

}
