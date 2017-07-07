/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a")
    , @NamedQuery(name = "Aluno.findByNomeAluno", query = "SELECT a FROM Aluno a WHERE a.nomeAluno = :nomeAluno")
    , @NamedQuery(name = "Aluno.findByMatriculaAluno", query = "SELECT a FROM Aluno a WHERE a.matriculaAluno = :matriculaAluno")
    , @NamedQuery(name = "Aluno.findByCargaHorariaTotal", query = "SELECT a FROM Aluno a WHERE a.cargaHorariaTotal = :cargaHorariaTotal")})
public class Aluno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 50)
    @Column(name = "nome_aluno")
    private String nomeAluno;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "matricula_aluno")
    private String matriculaAluno;
    @Size(max = 5)
    @Column(name = "carga_horaria_total")
    private String cargaHorariaTotal;
    @JoinColumn(name = "nome_curso", referencedColumnName = "nome_curso")
    @ManyToOne
    private Curso nomeCurso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "aluno")
    private Collection<AlunoPalestra> alunoPalestraCollection;

    public Aluno() {
    }

    public Aluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(String cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public Curso getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(Curso nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    @XmlTransient
    public Collection<AlunoPalestra> getAlunoPalestraCollection() {
        return alunoPalestraCollection;
    }

    public void setAlunoPalestraCollection(Collection<AlunoPalestra> alunoPalestraCollection) {
        this.alunoPalestraCollection = alunoPalestraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaAluno != null ? matriculaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.matriculaAluno == null && other.matriculaAluno != null) || (this.matriculaAluno != null && !this.matriculaAluno.equals(other.matriculaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Aluno[ matriculaAluno=" + matriculaAluno + " ]";
    }
    
}
