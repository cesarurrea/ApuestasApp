package co.com.apuestas.services;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.apuestas.persistence.dao.IPremioDao;
import co.com.apuestas.persistence.model.Premio;

@Service
public class PremioService implements IGenericService<Premio, BigDecimal> {

	private final IPremioDao dao;

	@Autowired
	public PremioService(IPremioDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public List<Premio> findAll() {

		return dao.listAll();
	}

	@Override
	public void edit(Premio entity) {
		dao.save(entity);

	}

	@Override
	public void create(Premio entity) {
		dao.save(entity);

	}

	@Override
	public void remove(BigDecimal id) {
		Premio entity = this.find(id);

		if (entity.getIdpremio() != null) {
			dao.delete(entity);

		}
		

	}

	public List<Premio> consultarPremio(BigDecimal colilla) {
		List<Premio> lista = new ArrayList<>();
		Premio premio;

		ResultSet rs = dao.consultarPremio(colilla);

		try {
			while (rs.next()) {
				premio = new Premio();

				premio.setIdpremio(rs.getBigDecimal("IDPREMIO"));

				premio.setNrocolilla(rs.getBigDecimal("NROCOLILLA"));

				premio.setIdsorteo(rs.getBigDecimal("IDSORTEO"));

				premio.setValorpagar(rs.getLong("VALORPAGAR"));

				premio.setEstado(rs.getString("ESTADO"));

				premio.setFechaestado(rs.getDate("FECHAESTADO"));

				lista.add(premio);

			}
		} catch (SQLException e) {
		}

		return lista;
	}

	@Override
	public Premio find(BigDecimal id) {
		Optional<Premio> premio = dao.findById(id);

		if (premio.isPresent()) {
			return premio.get();
		}

		return new Premio();
	}

}
