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
@Table(name = "login")
@NamedQueries({
    @NamedQuery(name = "Login_1.findAll", query = "SELECT l FROM Login_1 l"),
    @NamedQuery(name = "Login_1.findByNomerinduk", query = "SELECT l FROM Login_1 l WHERE l.nomerinduk = :nomerinduk"),
    @NamedQuery(name = "Login_1.findByPassword", query = "SELECT l FROM Login_1 l WHERE l.password = :password"),
    @NamedQuery(name = "Login_1.findByNama", query = "SELECT l FROM Login_1 l WHERE l.nama = :nama"),
    @NamedQuery(name = "Login_1.findByLevel", query = "SELECT l FROM Login_1 l WHERE l.level = :level")})
public class Login_1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nomerinduk")
    private String nomerinduk;
    @Column(name = "password")
    private String password;
    @Column(name = "nama")
    private String nama;
    @Column(name = "level")
    private String level;

    public Login_1() {
    }

    public Login_1(String nomerinduk) {
        this.nomerinduk = nomerinduk;
    }

    public String getNomerinduk() {
        return nomerinduk;
    }

    public void setNomerinduk(String nomerinduk) {
        this.nomerinduk = nomerinduk;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nomerinduk != null ? nomerinduk.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Login_1)) {
            return false;
        }
        Login_1 other = (Login_1) object;
        if ((this.nomerinduk == null && other.nomerinduk != null) || (this.nomerinduk != null && !this.nomerinduk.equals(other.nomerinduk))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectuas.Login_1[ nomerinduk=" + nomerinduk + " ]";
    }
    
}
