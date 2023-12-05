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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "buku")
@NamedQueries({
    @NamedQuery(name = "Buku_1.findAll", query = "SELECT b FROM Buku_1 b"),
    @NamedQuery(name = "Buku_1.findByIsbn", query = "SELECT b FROM Buku_1 b WHERE b.isbn = :isbn"),
    @NamedQuery(name = "Buku_1.findByJudul", query = "SELECT b FROM Buku_1 b WHERE b.judul = :judul"),
    @NamedQuery(name = "Buku_1.findByPengarang", query = "SELECT b FROM Buku_1 b WHERE b.pengarang = :pengarang"),
    @NamedQuery(name = "Buku_1.findByPenerbit", query = "SELECT b FROM Buku_1 b WHERE b.penerbit = :penerbit"),
    @NamedQuery(name = "Buku_1.findByTahun", query = "SELECT b FROM Buku_1 b WHERE b.tahun = :tahun"),
    @NamedQuery(name = "Buku_1.findByJumlahHalaman", query = "SELECT b FROM Buku_1 b WHERE b.jumlahHalaman = :jumlahHalaman")})
public class Buku_1 implements Serializable {

    @OneToMany(mappedBy = "isbn")
    private Collection<Peminjaman_1> peminjaman1Collection;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Column(name = "judul")
    private String judul;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "penerbit")
    private String penerbit;
    @Column(name = "tahun")
    private String tahun;
    @Column(name = "jumlah_halaman")
    private String jumlahHalaman;
    @JoinColumn(name = "id_kategori", referencedColumnName = "id_kategori")
    @ManyToOne
    private Kategori_1 idKategori;

    public Buku_1() {
    }

    public Buku_1(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public String getTahun() {
        return tahun;
    }

    public void setTahun(String tahun) {
        this.tahun = tahun;
    }

    public String getJumlah_halaman() {
        return jumlahHalaman;
    }

    public void setJumlahHalaman(String jumlahHalaman) {
        this.jumlahHalaman = jumlahHalaman;
    }

    public Kategori_1 getId_kategori() {
        return idKategori;
    }

    public void setIdKategori(Kategori_1 idKategori) {
        this.idKategori = idKategori;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Buku_1)) {
            return false;
        }
        Buku_1 other = (Buku_1) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Buku_1[ isbn=" + isbn + " ]";
    }

    public Collection<Peminjaman_1> getPeminjaman1Collection() {
        return peminjaman1Collection;
    }

    public void setPeminjaman1Collection(Collection<Peminjaman_1> peminjaman1Collection) {
        this.peminjaman1Collection = peminjaman1Collection;
    }

   
    
}
