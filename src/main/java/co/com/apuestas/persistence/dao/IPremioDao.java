package co.com.apuestas.persistence.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import co.com.apuestas.persistence.model.Premio;

public interface IPremioDao extends CrudRepository<Premio, BigDecimal> {

	@Procedure(name = "Premio.SpConsultarPremio")
	ResultSet consultarPremio(@Param("P_COLILLA") BigDecimal colilla);
	
	@Query("SELECT p FROM Premio p")
	public List<Premio> listAll();

}
