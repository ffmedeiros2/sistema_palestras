/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "aluno_palestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoPalestra.findAll", query = "SELECT a FROM AlunoPalestra a")
    , @NamedQuery(name = "AlunoPalestra.findByMatriculaAluno", query = "SELECT a FROM AlunoPalestra a WHERE a.alunoPalestraPK.matriculaAluno = :matriculaAluno")
    , @NamedQuery(name = "AlunoPalestra.findByIdPalestra", query = "SELECT a FROM AlunoPalestra a WHERE a.alunoPalestraPK.idPalestra = :idPalestra")
    , @NamedQuery(name = "AlunoPalestra.findByPresenca", query = "SELECT a FROM AlunoPalestra a WHERE a.presenca = :presenca")})
public class AlunoPalestra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoPalestraPK alunoPalestraPK;
    @Column(name = "presenca")
    private Boolean presenca;
    @JoinColumn(name = "matricula_aluno", referencedColumnName = "matricula_aluno", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;
    @JoinColumn(name = "id_palestra", referencedColumnName = "id_palestra", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Palestra palestra;

    public AlunoPalestra() {
    }

    public AlunoPalestra(AlunoPalestraPK alunoPalestraPK) {
        this.alunoPalestraPK = alunoPalestraPK;
    }

    public AlunoPalestra(String matriculaAluno, int idPalestra) {
        this.alunoPalestraPK = new AlunoPalestraPK(matriculaAluno, idPalestra);
    }

    public AlunoPalestraPK getAlunoPalestraPK() {
        return alunoPalestraPK;
    }

    public void setAlunoPalestraPK(AlunoPalestraPK alunoPalestraPK) {
        this.alunoPalestraPK = alunoPalestraPK;
    }

    public Boolean getPresenca() {
        return presenca;
    }

    public void setPresenca(Boolean presenca) {
        this.presenca = presenca;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoPalestraPK != null ? alunoPalestraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoPalestra)) {
            return false;
        }
        AlunoPalestra other = (AlunoPalestra) object;
        if ((this.alunoPalestraPK == null && other.alunoPalestraPK != null) || (this.alunoPalestraPK != null && !this.alunoPalestraPK.equals(other.alunoPalestraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AlunoPalestra[ alunoPalestraPK=" + alunoPalestraPK + " ]";
    }
    
}
