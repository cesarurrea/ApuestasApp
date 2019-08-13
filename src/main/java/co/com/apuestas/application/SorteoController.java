package co.com.apuestas.application;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import co.com.apuestas.persistence.model.Sorteo;
import co.com.apuestas.services.SorteoService;

@Controller
@RequestMapping(value = "app/sorteo/")
public class SorteoController {

	private final SorteoService service;

	public SorteoController(SorteoService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<Sorteo> getStatus() {
		return service.findAll();
	}

}
