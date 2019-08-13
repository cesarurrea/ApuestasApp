package co.com.apuestas.persistence.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.apuestas.persistence.model.Colilla;

public interface IColillaDao extends CrudRepository<Colilla, BigDecimal> {

	@Query("SELECT c FROM Colilla c")
	public List<Colilla> listAll();

}
