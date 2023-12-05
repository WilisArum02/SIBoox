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
@Table(name = "peminjamanskripsi")
@NamedQueries({
    @NamedQuery(name = "Peminjamanskripsi_1.findAll", query = "SELECT p FROM Peminjamanskripsi_1 p"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByIdPeminjaman", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.idPeminjaman = :idPeminjaman"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByNim", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.nim = :nim"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByNama", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.nama = :nama"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByProdi", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.prodi = :prodi"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByAngkatan", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.angkatan = :angkatan"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByTanggalPeminjaman", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.tanggalPeminjaman = :tanggalPeminjaman"),
    @NamedQuery(name = "Peminjamanskripsi_1.findByTanggalPengembalian", query = "SELECT p FROM Peminjamanskripsi_1 p WHERE p.tanggalPengembalian = :tanggalPengembalian")})
public class Peminjamanskripsi_1 implements Serializable {

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
    @JoinColumn(name = "id_skripsi", referencedColumnName = "id_skripsi")
    @ManyToOne
    private Skripsi_1 idSkripsi;

    public Peminjamanskripsi_1() {
    }

    public Peminjamanskripsi_1(String idPeminjaman) {
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

    public Skripsi_1 getIdSkripsi() {
        return idSkripsi;
    }

    public void setIdSkripsi(Skripsi_1 idSkripsi) {
        this.idSkripsi = idSkripsi;
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
        if (!(object instanceof Peminjamanskripsi_1)) {
            return false;
        }
        Peminjamanskripsi_1 other = (Peminjamanskripsi_1) object;
        if ((this.idPeminjaman == null && other.idPeminjaman != null) || (this.idPeminjaman != null && !this.idPeminjaman.equals(other.idPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Peminjamanskripsi_1[ idPeminjaman=" + idPeminjaman + " ]";
    }
    
}
