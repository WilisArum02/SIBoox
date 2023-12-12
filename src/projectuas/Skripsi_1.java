/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectuas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author HP
 */
@Entity
@Table(name = "Skripsi")
@NamedQueries({
    @NamedQuery(name = "Skripsi_1.findAll", query = "SELECT s FROM Skripsi_1 s"),
    @NamedQuery(name = "Skripsi_1.findByIdSkripsi", query = "SELECT s FROM Skripsi_1 s WHERE s.idSkripsi = :idSkripsi"),
    @NamedQuery(name = "Skripsi_1.findByJudul", query = "SELECT s FROM Skripsi_1 s WHERE s.judul = :judul"),
    @NamedQuery(name = "Skripsi_1.findByPengarang", query = "SELECT s FROM Skripsi_1 s WHERE s.pengarang = :pengarang"),
    @NamedQuery(name = "Skripsi_1.findByTahun", query = "SELECT s FROM Skripsi_1 s WHERE s.tahun = :tahun"),
    @NamedQuery(name = "Skripsi_1.findByJumlahHalaman", query = "SELECT s FROM Skripsi_1 s WHERE s.jumlahHalaman = :jumlahHalaman")})
public class Skripsi_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_skripsi")
    private String idSkripsi;
    @Column(name = "judul")
    private String judul;
    @Column(name = "pengarang")
    private String pengarang;
    @Column(name = "tahun")
    private String tahun;
    @Column(name = "jumlah_halaman")
    private String jumlahHalaman;

    public Skripsi_1() {
    }

    public Skripsi_1(String idSkripsi) {
        this.idSkripsi = idSkripsi;
    }

    public String getId_skripsi() {
        return idSkripsi;
    }

    public void setIdSkripsi(String idSkripsi) {
        this.idSkripsi = idSkripsi;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSkripsi != null ? idSkripsi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Skripsi_1)) {
            return false;
        }
        Skripsi_1 other = (Skripsi_1) object;
        if ((this.idSkripsi == null && other.idSkripsi != null) || (this.idSkripsi != null && !this.idSkripsi.equals(other.idSkripsi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Skripsi_1[ idSkripsi=" + idSkripsi + " ]";
    }
    
}
