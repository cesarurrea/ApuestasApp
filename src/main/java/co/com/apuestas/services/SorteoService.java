package co.com.apuestas.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apuestas.persistence.dao.ISorteoDao;
import co.com.apuestas.persistence.model.Sorteo;

@Service
public class SorteoService implements IGenericService<Sorteo, BigDecimal> {

	private final ISorteoDao dao;
	
	@Autowired
	public SorteoService(ISorteoDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void create(Sorteo entity) {
		dao.save(entity);	

	}

	@Override
	public void edit(Sorteo entity) {
		dao.save(entity);

	}

	@Override
	public void remove(Sorteo entity) {
		dao.delete(entity);

	}

	@Override
	public Sorteo find(BigDecimal id) {
		
		Optional<Sorteo> entity = dao.findById(id);
		
		if (entity.isPresent()) {
			return entity.get();
		}
		
		return new Sorteo();
	}

	@Override
	public List<Sorteo> findAll() {
		
		return dao.listAll();
	}

}
