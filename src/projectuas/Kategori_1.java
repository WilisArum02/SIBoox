/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "kategori")
@NamedQueries({
    @NamedQuery(name = "Kategori_1.findAll", query = "SELECT k FROM Kategori_1 k"),
    @NamedQuery(name = "Kategori_1.findByIdKategori", query = "SELECT k FROM Kategori_1 k WHERE k.idKategori = :idKategori"),
    @NamedQuery(name = "Kategori_1.findByNama", query = "SELECT k FROM Kategori_1 k WHERE k.nama = :nama")})
public class Kategori_1 implements Serializable {

    @OneToMany(mappedBy = "idKategori")
    private Collection<Buku_1> buku1Collection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kategori")
    private String idKategori;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;

    public Kategori_1() {
    }

    public Kategori_1(String idKategori) {
        this.idKategori = idKategori;
    }

    public Kategori_1(String idKategori, String nama) {
        this.idKategori = idKategori;
        this.nama = nama;
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKategori != null ? idKategori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori_1)) {
            return false;
        }
        Kategori_1 other = (Kategori_1) object;
        if ((this.idKategori == null && other.idKategori != null) || (this.idKategori != null && !this.idKategori.equals(other.idKategori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Kategori_1[ idKategori=" + idKategori + " ]";
    }

    public Collection<Buku_1> getBuku1Collection() {
        return buku1Collection;
    }

    public void setBuku1Collection(Collection<Buku_1> buku1Collection) {
        this.buku1Collection = buku1Collection;
    }
    
}
