package co.com.apuestas.application;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.apuestas.persistence.model.Parametro;
import co.com.apuestas.services.ParametroService;

@Controller
@RequestMapping(value = "app")
public class ParametroController implements IGenericController<Parametro, String> {

	private final ParametroService service;

	public ParametroController(ParametroService service) {
		super();
		this.service = service;
	}

	@Override
	public void create(Parametro entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void edit(Parametro entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Parametro entity) {
		// TODO Auto-generated method stub

	}

	@Override
	@RequestMapping(value = "/parametro", method = RequestMethod.GET)
	public @ResponseBody Parametro find(@RequestParam(name = "id") String id) {
		return service.find(id);
	}

	@Override
	public List<Parametro> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<Parametro> getStatus() {
		return service.findAll();
	}

}
