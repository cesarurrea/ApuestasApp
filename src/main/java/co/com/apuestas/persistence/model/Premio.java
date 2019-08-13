/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.apuestas.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "PREMIO")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Premio.findAll", query = "SELECT p FROM Premio p"),
		@NamedQuery(name = "Premio.findByIdpremio", query = "SELECT p FROM Premio p WHERE p.idpremio = :idpremio"),
		@NamedQuery(name = "Premio.findByValorpagar", query = "SELECT p FROM Premio p WHERE p.valorpagar = :valorpagar"),
		@NamedQuery(name = "Premio.findByEstado", query = "SELECT p FROM Premio p WHERE p.estado = :estado"),
		@NamedQuery(name = "Premio.findByFechaestado", query = "SELECT p FROM Premio p WHERE p.fechaestado = :fechaestado") })
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "Premio.SpConsultarPremio", procedureName = "SP_CONSULTAR_PREMIO", parameters = {
				@StoredProcedureParameter(mode = ParameterMode.IN, name = "P_COLILLA", type = BigDecimal.class),
				@StoredProcedureParameter(mode = ParameterMode.REF_CURSOR, name = "P_CUR_PREMIO", type = void.class) }) })
public class Premio implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDPREMIO")
	private BigDecimal idpremio;
	@Basic(optional = false)
	@NotNull
	@Column(name = "NROCOLILLA")
	private BigDecimal nrocolilla;
	@Basic(optional = false)
	@NotNull
	@Column(name = "IDSORTEO")
	private BigDecimal idsorteo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "VALORPAGAR")
	private Long valorpagar;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 1)
	@Column(name = "ESTADO")
	private String estado;
	@Basic(optional = false)
	@NotNull
	@Column(name = "FECHAESTADO")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaestado;
	/*
	 * @JoinColumn(name = "NROCOLILLA", referencedColumnName = "NROCOLILLA")
	 * 
	 * @ManyToOne(optional = false) private Colilla nrocolilla;
	 * 
	 * @JoinColumn(name = "IDSORTEO", referencedColumnName = "IDSORTEO")
	 * 
	 * @ManyToOne(optional = false) private Sorteo idsorteo;
	 */

	public Premio() {
	}

	public Premio(BigDecimal idpremio) {
		this.idpremio = idpremio;
	}

	public Premio(BigDecimal idpremio, Long valorpagar, String estado, Date fechaestado) {
		this.idpremio = idpremio;
		this.valorpagar = valorpagar;
		this.estado = estado;
		this.fechaestado = fechaestado;
	}

	public BigDecimal getIdpremio() {
		return idpremio;
	}

	public void setIdpremio(BigDecimal idpremio) {
		this.idpremio = idpremio;
	}

	public BigDecimal getNrocolilla() {
		return nrocolilla;
	}

	public void setNrocolilla(BigDecimal nrocolilla) {
		this.nrocolilla = nrocolilla;
	}

	public BigDecimal getIdsorteo() {
		return idsorteo;
	}

	public void setIdsorteo(BigDecimal idsorteo) {
		this.idsorteo = idsorteo;
	}

	public Long getValorpagar() {
		return valorpagar;
	}

	public void setValorpagar(Long valorpagar) {
		this.valorpagar = valorpagar;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaestado() {
		return fechaestado;
	}

	public void setFechaestado(Date fechaestado) {
		this.fechaestado = fechaestado;
	}

	/*
	 * public Colilla getNrocolilla() { return nrocolilla; }
	 * 
	 * public void setNrocolilla(Colilla nrocolilla) { this.nrocolilla = nrocolilla;
	 * }
	 * 
	 * public Sorteo getIdsorteo() { return idsorteo; }
	 * 
	 * public void setIdsorteo(Sorteo idsorteo) { this.idsorteo = idsorteo; }
	 */

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idpremio != null ? idpremio.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Premio)) {
			return false;
		}
		Premio other = (Premio) object;
		if ((this.idpremio == null && other.idpremio != null)
				|| (this.idpremio != null && !this.idpremio.equals(other.idpremio))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "co.com.apuestas.persistence.model.Premio[ idpremio=" + idpremio + " ]";
	}

}