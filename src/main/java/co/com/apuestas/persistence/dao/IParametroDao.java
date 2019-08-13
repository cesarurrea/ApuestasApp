package co.com.apuestas.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.apuestas.persistence.model.Parametro;

public interface IParametroDao extends CrudRepository<Parametro, String> {

	@Query("SELECT p FROM Parametro p")
	public List<Parametro> listAll();

}
