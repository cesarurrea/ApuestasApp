package co.com.apuestas.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping(value = "/")
	private String index() {
		return "index";
	}
	
	@RequestMapping("parametro")
	public String parametro() {
		return "maestros/parametro/listar";
	}
	
	@RequestMapping("sorteo")
	public String sorteo() {
		return "maestros/sorteo/listar";
	}
	
	@RequestMapping("colilla")
	public String colilla() {
		return "maestros/colilla/listar";
	}
	
	@RequestMapping("/premio")
	public String premio() {
		return "procesos/premio/listar";
	}

}
