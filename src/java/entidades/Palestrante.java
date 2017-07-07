/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "palestrante")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestrante.findAll", query = "SELECT p FROM Palestrante p")
    , @NamedQuery(name = "Palestrante.findByIdPalestrante", query = "SELECT p FROM Palestrante p WHERE p.idPalestrante = :idPalestrante")
    , @NamedQuery(name = "Palestrante.findByNome", query = "SELECT p FROM Palestrante p WHERE p.nome = :nome")
    , @NamedQuery(name = "Palestrante.findByDescricao", query = "SELECT p FROM Palestrante p WHERE p.descricao = :descricao")})
public class Palestrante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palestrante")
    private Integer idPalestrante;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    @Size(max = 1000)
    @Column(name = "descricao")
    private String descricao;
    @ManyToMany(mappedBy = "palestranteCollection")
    private Collection<Palestra> palestraCollection;

    public Palestrante() {
    }

    public Palestrante(Integer idPalestrante) {
        this.idPalestrante = idPalestrante;
    }

    public Integer getIdPalestrante() {
        return idPalestrante;
    }

    public void setIdPalestrante(Integer idPalestrante) {
        this.idPalestrante = idPalestrante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @XmlTransient
    public Collection<Palestra> getPalestraCollection() {
        return palestraCollection;
    }

    public void setPalestraCollection(Collection<Palestra> palestraCollection) {
        this.palestraCollection = palestraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPalestrante != null ? idPalestrante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestrante)) {
            return false;
        }
        Palestrante other = (Palestrante) object;
        if ((this.idPalestrante == null && other.idPalestrante != null) || (this.idPalestrante != null && !this.idPalestrante.equals(other.idPalestrante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Palestrante[ idPalestrante=" + idPalestrante + " ]";
    }
    
}
