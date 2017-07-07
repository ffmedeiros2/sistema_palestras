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
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findByMatriculaProfessor", query = "SELECT p FROM Professor p WHERE p.matriculaProfessor = :matriculaProfessor")
    , @NamedQuery(name = "Professor.findByNomeProfessor", query = "SELECT p FROM Professor p WHERE p.nomeProfessor = :nomeProfessor")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "matricula_professor")
    private String matriculaProfessor;
    @Size(max = 30)
    @Column(name = "nome_professor")
    private String nomeProfessor;
    @ManyToMany(mappedBy = "professorCollection")
    private Collection<Palestra> palestraCollection;

    public Professor() {
    }

    public Professor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(String matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
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
        hash += (matriculaProfessor != null ? matriculaProfessor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.matriculaProfessor == null && other.matriculaProfessor != null) || (this.matriculaProfessor != null && !this.matriculaProfessor.equals(other.matriculaProfessor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Professor[ matriculaProfessor=" + matriculaProfessor + " ]";
    }
    
}
