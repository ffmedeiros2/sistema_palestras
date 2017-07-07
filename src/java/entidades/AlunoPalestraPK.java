/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author felipe
 */
@Embeddable
public class AlunoPalestraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "matricula_aluno")
    private String matriculaAluno;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_palestra")
    private int idPalestra;

    public AlunoPalestraPK() {
    }

    public AlunoPalestraPK(String matriculaAluno, int idPalestra) {
        this.matriculaAluno = matriculaAluno;
        this.idPalestra = idPalestra;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public int getIdPalestra() {
        return idPalestra;
    }

    public void setIdPalestra(int idPalestra) {
        this.idPalestra = idPalestra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaAluno != null ? matriculaAluno.hashCode() : 0);
        hash += (int) idPalestra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoPalestraPK)) {
            return false;
        }
        AlunoPalestraPK other = (AlunoPalestraPK) object;
        if ((this.matriculaAluno == null && other.matriculaAluno != null) || (this.matriculaAluno != null && !this.matriculaAluno.equals(other.matriculaAluno))) {
            return false;
        }
        if (this.idPalestra != other.idPalestra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.AlunoPalestraPK[ matriculaAluno=" + matriculaAluno + ", idPalestra=" + idPalestra + " ]";
    }
    
}
