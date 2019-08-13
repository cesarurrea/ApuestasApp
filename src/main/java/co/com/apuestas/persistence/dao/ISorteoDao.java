package co.com.apuestas.persistence.dao;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.apuestas.persistence.model.Sorteo;

public interface ISorteoDao extends CrudRepository<Sorteo, BigDecimal>{
	
	@Query("SELECT s FROM Sorteo s")
	public List<Sorteo> listAll();

}
