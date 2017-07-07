/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author felipe
 */
@Entity
@Table(name = "palestra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Palestra.findAll", query = "SELECT p FROM Palestra p")
    , @NamedQuery(name = "Palestra.findByIdPalestra", query = "SELECT p FROM Palestra p WHERE p.idPalestra = :idPalestra")
    , @NamedQuery(name = "Palestra.findByNomePalestra", query = "SELECT p FROM Palestra p WHERE p.nomePalestra = :nomePalestra")
    , @NamedQuery(name = "Palestra.findByData", query = "SELECT p FROM Palestra p WHERE p.data = :data")
    , @NamedQuery(name = "Palestra.findByHorario", query = "SELECT p FROM Palestra p WHERE p.horario = :horario")
    , @NamedQuery(name = "Palestra.findByLotacaoMaxima", query = "SELECT p FROM Palestra p WHERE p.lotacaoMaxima = :lotacaoMaxima")
    , @NamedQuery(name = "Palestra.findByCargaHoraria", query = "SELECT p FROM Palestra p WHERE p.cargaHoraria = :cargaHoraria")})
public class Palestra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_palestra")
    private Integer idPalestra;
    @Size(max = 50)
    @Column(name = "nome_palestra")
    private String nomePalestra;
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Size(max = 4)
    @Column(name = "horario")
    private String horario;
    @Column(name = "lotacao_maxima")
    private Integer lotacaoMaxima;
    @Column(name = "carga_horaria")
    private Integer cargaHoraria;
    @JoinTable(name = "area_interesse_palestra", joinColumns = {
        @JoinColumn(name = "id_palestra", referencedColumnName = "id_palestra")}, inverseJoinColumns = {
        @JoinColumn(name = "nome_area_interesse", referencedColumnName = "nome_area_interesse")})
    @ManyToMany
    private Collection<AreaInteresse> areaInteresseCollection;
    @JoinTable(name = "responsavel", joinColumns = {
        @JoinColumn(name = "id_palestra", referencedColumnName = "id_palestra")}, inverseJoinColumns = {
        @JoinColumn(name = "maticula_professor", referencedColumnName = "matricula_professor")})
    @ManyToMany
    private Collection<Professor> professorCollection;
    @JoinTable(name = "palestra_palestrante", joinColumns = {
        @JoinColumn(name = "id_palestra", referencedColumnName = "id_palestra")}, inverseJoinColumns = {
        @JoinColumn(name = "id_palestrante", referencedColumnName = "id_palestrante")})
    @ManyToMany
    private Collection<Palestrante> palestranteCollection;
    @JoinColumn(name = "id_sala", referencedColumnName = "id_sala")
    @ManyToOne
    private Sala idSala;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "palestra")
    private Collection<AlunoPalestra> alunoPalestraCollection;

    public Palestra() {
    }

    public Palestra(Integer idPalestra) {
        this.idPalestra = idPalestra;
    }

    public Integer getIdPalestra() {
        return idPalestra;
    }

    public void setIdPalestra(Integer idPalestra) {
        this.idPalestra = idPalestra;
    }

    public String getNomePalestra() {
        return nomePalestra;
    }

    public void setNomePalestra(String nomePalestra) {
        this.nomePalestra = nomePalestra;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Integer getLotacaoMaxima() {
        return lotacaoMaxima;
    }

    public void setLotacaoMaxima(Integer lotacaoMaxima) {
        this.lotacaoMaxima = lotacaoMaxima;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @XmlTransient
    public Collection<AreaInteresse> getAreaInteresseCollection() {
        return areaInteresseCollection;
    }

    public void setAreaInteresseCollection(Collection<AreaInteresse> areaInteresseCollection) {
        this.areaInteresseCollection = areaInteresseCollection;
    }

    @XmlTransient
    public Collection<Professor> getProfessorCollection() {
        return professorCollection;
    }

    public void setProfessorCollection(Collection<Professor> professorCollection) {
        this.professorCollection = professorCollection;
    }

    @XmlTransient
    public Collection<Palestrante> getPalestranteCollection() {
        return palestranteCollection;
    }

    public void setPalestranteCollection(Collection<Palestrante> palestranteCollection) {
        this.palestranteCollection = palestranteCollection;
    }

    public Sala getIdSala() {
        return idSala;
    }

    public void setIdSala(Sala idSala) {
        this.idSala = idSala;
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
        hash += (idPalestra != null ? idPalestra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Palestra)) {
            return false;
        }
        Palestra other = (Palestra) object;
        if ((this.idPalestra == null && other.idPalestra != null) || (this.idPalestra != null && !this.idPalestra.equals(other.idPalestra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Palestra[ idPalestra=" + idPalestra + " ]";
    }
    
}
