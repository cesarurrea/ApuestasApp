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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cesar
 */
@Entity
@Table(name = "SORTEO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sorteo.findAll", query = "SELECT s FROM Sorteo s")
    , @NamedQuery(name = "Sorteo.findByIdsorteo", query = "SELECT s FROM Sorteo s WHERE s.idsorteo = :idsorteo")
    , @NamedQuery(name = "Sorteo.findByNumeroapuesta", query = "SELECT s FROM Sorteo s WHERE s.numeroapuesta = :numeroapuesta")
    , @NamedQuery(name = "Sorteo.findByFechasorteo", query = "SELECT s FROM Sorteo s WHERE s.fechasorteo = :fechasorteo")})
public class Sorteo implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @SequenceGenerator(name="SORTEO_PK", sequenceName="SEQ_SORTEO", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SORTEO_PK")
    @Column(name = "IDSORTEO")
    private BigDecimal idsorteo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMEROAPUESTA")
    private BigInteger numeroapuesta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHASORTEO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechasorteo;
   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "idsorteo")
    private Collection<Premio> premioCollection;*/

    public Sorteo() {
    }

    public Sorteo(BigDecimal idsorteo) {
        this.idsorteo = idsorteo;
    }

    public Sorteo(BigDecimal idsorteo, BigInteger numeroapuesta, Date fechasorteo) {
        this.idsorteo = idsorteo;
        this.numeroapuesta = numeroapuesta;
        this.fechasorteo = fechasorteo;
    }

    public BigDecimal getIdsorteo() {
        return idsorteo;
    }

    public void setIdsorteo(BigDecimal idsorteo) {
        this.idsorteo = idsorteo;
    }

    public BigInteger getNumeroapuesta() {
        return numeroapuesta;
    }

    public void setNumeroapuesta(BigInteger numeroapuesta) {
        this.numeroapuesta = numeroapuesta;
    }

    public Date getFechasorteo() {
        return fechasorteo;
    }

    public void setFechasorteo(Date fechasorteo) {
        this.fechasorteo = fechasorteo;
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
        hash += (idsorteo != null ? idsorteo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sorteo)) {
            return false;
        }
        Sorteo other = (Sorteo) object;
        if ((this.idsorteo == null && other.idsorteo != null) || (this.idsorteo != null && !this.idsorteo.equals(other.idsorteo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.apuestas.persistence.model.Sorteo[ idsorteo=" + idsorteo + " ]";
    }
    
}
