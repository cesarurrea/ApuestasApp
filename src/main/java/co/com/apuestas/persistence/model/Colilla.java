package co.com.apuestas.persistence.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "COLILLA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colilla.findAll", query = "SELECT c FROM Colilla c")
    , @NamedQuery(name = "Colilla.findByNrocolilla", query = "SELECT c FROM Colilla c WHERE c.nrocolilla = :nrocolilla")
    , @NamedQuery(name = "Colilla.findByEstado", query = "SELECT c FROM Colilla c WHERE c.estado = :estado")
    , @NamedQuery(name = "Colilla.findByFechaestado", query = "SELECT c FROM Colilla c WHERE c.fechaestado = :fechaestado")
    , @NamedQuery(name = "Colilla.findByFechasorteo", query = "SELECT c FROM Colilla c WHERE c.fechasorteo = :fechasorteo")
    , @NamedQuery(name = "Colilla.findByNumeroapuesta", query = "SELECT c FROM Colilla c WHERE c.numeroapuesta = :numeroapuesta")
    , @NamedQuery(name = "Colilla.findByValorapuesta", query = "SELECT c FROM Colilla c WHERE c.valorapuesta = :valorapuesta")})
public class Colilla implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="COLILLA_PK", sequenceName="SEQ_COLILLA", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="COLILLA_PK")
    @Column(name = "NROCOLILLA")
    private BigDecimal nrocolilla;
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
    @Column(name = "FECHASORTEO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasorteo;
    @Column(name = "NUMEROAPUESTA")
    private BigInteger numeroapuesta;
    @Column(name = "VALORAPUESTA")
    private BigInteger valorapuesta;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "nrocolilla")
    private Collection<Premio> premioCollection;*/

    public Colilla() {
    }

    public Colilla(BigDecimal nrocolilla) {
        this.nrocolilla = nrocolilla;
    }

    public Colilla(BigDecimal nrocolilla, String estado, Date fechaestado) {
        this.nrocolilla = nrocolilla;
        this.estado = estado;
        this.fechaestado = fechaestado;
    }

    public BigDecimal getNrocolilla() {
        return nrocolilla;
    }

    public void setNrocolilla(BigDecimal nrocolilla) {
        this.nrocolilla = nrocolilla;
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

    public Date getFechasorteo() {
        return fechasorteo;
    }

    public void setFechasorteo(Date fechasorteo) {
        this.fechasorteo = fechasorteo;
    }

    public BigInteger getNumeroapuesta() {
        return numeroapuesta;
    }

    public void setNumeroapuesta(BigInteger numeroapuesta) {
        this.numeroapuesta = numeroapuesta;
    }

    public BigInteger getValorapuesta() {
        return valorapuesta;
    }

    public void setValorapuesta(BigInteger valorapuesta) {
        this.valorapuesta = valorapuesta;
    }

  /*  @XmlTransient
    public Collection<Premio> getPremioCollection() {
        return premioCollection;
    }

    public void setPremioCollection(Collection<Premio> premioCollection) {
        this.premioCollection = premioCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrocolilla != null ? nrocolilla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Colilla)) {
            return false;
        }
        Colilla other = (Colilla) object;
        if ((this.nrocolilla == null && other.nrocolilla != null) || (this.nrocolilla != null && !this.nrocolilla.equals(other.nrocolilla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.apuestas.persistence.model.Colilla[ nrocolilla=" + nrocolilla + " ]";
    }
    
}