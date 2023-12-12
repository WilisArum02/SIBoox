/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "peminjaman")
@NamedQueries({
    @NamedQuery(name = "Peminjaman_1.findAll", query = "SELECT p FROM Peminjaman_1 p"),
    @NamedQuery(name = "Peminjaman_1.findByIdPeminjaman", query = "SELECT p FROM Peminjaman_1 p WHERE p.idPeminjaman = :idPeminjaman"),
    @NamedQuery(name = "Peminjaman_1.findByNim", query = "SELECT p FROM Peminjaman_1 p WHERE p.nim = :nim"),
    @NamedQuery(name = "Peminjaman_1.findByNama", query = "SELECT p FROM Peminjaman_1 p WHERE p.nama = :nama"),
    @NamedQuery(name = "Peminjaman_1.findByProdi", query = "SELECT p FROM Peminjaman_1 p WHERE p.prodi = :prodi"),
    @NamedQuery(name = "Peminjaman_1.findByAngkatan", query = "SELECT p FROM Peminjaman_1 p WHERE p.angkatan = :angkatan"),
    @NamedQuery(name = "Peminjaman_1.findByTanggalPeminjaman", query = "SELECT p FROM Peminjaman_1 p WHERE p.tanggalPeminjaman = :tanggalPeminjaman"),
    @NamedQuery(name = "Peminjaman_1.findByTanggalPengembalian", query = "SELECT p FROM Peminjaman_1 p WHERE p.tanggalPengembalian = :tanggalPengembalian")})
public class Peminjaman_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_peminjaman")
    private String idPeminjaman;
    @Column(name = "nim")
    private String nim;
    @Column(name = "nama")
    private String nama;
    @Column(name = "prodi")
    private String prodi;
    @Column(name = "angkatan")
    private String angkatan;
    @Column(name = "tanggal_peminjaman")
    @Temporal(TemporalType.DATE)
    private Date tanggalPeminjaman;
    @Column(name = "tanggal_pengembalian")
    @Temporal(TemporalType.DATE)
    private Date tanggalPengembalian;
    @JoinColumn(name = "isbn", referencedColumnName = "isbn")
    @ManyToOne
    private Buku_1 isbn;

    public Peminjaman_1() {
    }

    public Peminjaman_1(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(String idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getAngkatan() {
        return angkatan;
    }

    public void setAngkatan(String angkatan) {
        this.angkatan = angkatan;
    }

    public Date getTanggalPeminjaman() {
        return tanggalPeminjaman;
    }

    public void setTanggalPeminjaman(Date tanggalPeminjaman) {
        this.tanggalPeminjaman = tanggalPeminjaman;
    }

    public Date getTanggalPengembalian() {
        return tanggalPengembalian;
    }

    public void setTanggalPengembalian(Date tanggalPengembalian) {
        this.tanggalPengembalian = tanggalPengembalian;
    }

    public Buku_1 getIsbn() {
        return isbn;
    }

    public void setIsbn(Buku_1 isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeminjaman != null ? idPeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peminjaman_1)) {
            return false;
        }
        Peminjaman_1 other = (Peminjaman_1) object;
        if ((this.idPeminjaman == null && other.idPeminjaman != null) || (this.idPeminjaman != null && !this.idPeminjaman.equals(other.idPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Peminjaman_1[ idPeminjaman=" + idPeminjaman + " ]";
    }
    
}
