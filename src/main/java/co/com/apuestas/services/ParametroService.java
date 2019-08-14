package co.com.apuestas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apuestas.persistence.dao.IParametroDao;
import co.com.apuestas.persistence.model.Parametro;

@Service
public class ParametroService implements IGenericService<Parametro, String> {

	private final IParametroDao dao;

	@Autowired
	public ParametroService(IParametroDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void create(Parametro entity) {
		dao.save(entity);

	}

	@Override
	public void edit(Parametro entity) {
		dao.save(entity);

	}

	@Override
	public void remove(String id) {
		Parametro parametro = this.find(id);
		
		if(parametro.getNombre() != null) {
			dao.delete(parametro);			
		}	

	}

	@Override
	public Parametro find(String id) {
		Optional<Parametro> parametro = dao.findById(id);
		
		if (parametro.isPresent()) {
			return parametro.get();
		}

		return new Parametro();
	}

	@Override
	public List<Parametro> findAll() {

		return dao.listAll();
	}

}
