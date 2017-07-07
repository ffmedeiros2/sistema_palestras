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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "area_interesse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaInteresse.findAll", query = "SELECT a FROM AreaInteresse a")
    , @NamedQuery(name = "AreaInteresse.findByNomeAreaInteresse", query = "SELECT a FROM AreaInteresse a WHERE a.nomeAreaInteresse = :nomeAreaInteresse")})
public class AreaInteresse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_area_interesse")
    private String nomeAreaInteresse;
    @JoinTable(name = "area_interesse_curso", joinColumns = {
        @JoinColumn(name = "nome_area_interesse", referencedColumnName = "nome_area_interesse")}, inverseJoinColumns = {
        @JoinColumn(name = "nome_curso", referencedColumnName = "nome_curso")})
    @ManyToMany
    private Collection<Curso> cursoCollection;
    @ManyToMany(mappedBy = "areaInteresseCollection")
    private Collection<Palestra> palestraCollection;

    public AreaInteresse() {
    }

    public AreaInteresse(String nomeAreaInteresse) {
        this.nomeAreaInteresse = nomeAreaInteresse;
    }

    public String getNomeAreaInteresse() {
        return nomeAreaInteresse;
    }

    public void setNomeAreaInteresse(String nomeAreaInteresse) {
        this.nomeAreaInteresse = nomeAreaInteresse;
    }

    @XmlTransient
    public Collection<Curso> getCursoCollection() {
        return cursoCollection;
    }

    public void setCursoCollection(Collection<Curso> cursoCollection) {
        this.cursoCollection = cursoCollection;
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
        hash += (nomeAreaInteresse != null ? nomeAreaInteresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaInteresse)) {
            return false;
        }
        AreaInteresse other = (AreaInteresse) object;
        if ((this.nomeAreaInteresse == null && other.nomeAreaInteresse != null) || (this.nomeAreaInteresse != null && !this.nomeAreaInteresse.equals(other.nomeAreaInteresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AreaInteresse[ nomeAreaInteresse=" + nomeAreaInteresse + " ]";
    }
    
}
