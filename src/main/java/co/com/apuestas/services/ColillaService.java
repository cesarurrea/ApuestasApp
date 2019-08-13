package co.com.apuestas.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apuestas.persistence.dao.IColillaDao;
import co.com.apuestas.persistence.model.Colilla;

@Service
public class ColillaService implements IGenericService<Colilla, BigDecimal> {
	
	private final IColillaDao dao;	
	
	@Autowired
	public ColillaService(IColillaDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void create(Colilla entity) {
		dao.save(entity);
		
	}

	@Override
	public void edit(Colilla entity) {
		dao.save(entity);
		
	}

	@Override
	public void remove(Colilla entity) {
		dao.delete(entity);
		
	}

	@Override
	public Colilla find(BigDecimal id) {
		
		Optional<Colilla> entity = dao.findById(id);
		
		if(entity.isPresent()) {
			return entity.get();
		}
		
		return new Colilla();
	}

	@Override
	public List<Colilla> findAll() {
		
		return dao.listAll();
	}

}
