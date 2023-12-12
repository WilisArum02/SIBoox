/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package projectuas;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import projectuas.ModelCard;
import javax.swing.ImageIcon;

public class Dashboard extends javax.swing.JPanel {


    public Dashboard() {
        initComponents();
//        card1.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/Book_1.png")), "Jumlah Buku SIBoox", "450"));
//        card2.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/Literature_1.png")), "Jumlah Skripsi SIBoox", "450"));
        

        //mengambil jumlah buku
        EntityManagerFactory emfBuku = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager emBuku = emfBuku.createEntityManager();

        // Menggunakan JPA untuk menjalankan query dan mendapatkan hasilnya
        Query query = emBuku.createQuery("SELECT COUNT(b.isbn) FROM Buku_1 b");
        Long jumlahBuku = (Long) query.getSingleResult();

        card1.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/Book_1.png")), "Jumlah Buku SIBoox", jumlahBuku.toString()));

        emBuku.close();
        emfBuku.close();
        
        // Mengambil jumlah skripsi
        EntityManagerFactory emfSkripsi = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager emSkripsi = emfSkripsi.createEntityManager();

        Query querySkripsi = emSkripsi.createQuery("SELECT COUNT(s.idSkripsi) FROM Skripsi_1 s");
        Long jumlahSkripsi = (Long) querySkripsi.getSingleResult();

        card2.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/Literature_1.png")), "Jumlah Skripsi SIBoox", jumlahSkripsi.toString()));

        emSkripsi.close();
        emfSkripsi.close();
        
        // Mengambil jumlah peminjaman buku
        EntityManagerFactory emfPeminjaman = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager emPeminjaman = emfPeminjaman.createEntityManager();

        Query queryPeminjaman = emPeminjaman.createQuery("SELECT COUNT(p.idPeminjaman) FROM Peminjaman_1 p");
        Long jumlahPeminjaman = (Long) queryPeminjaman.getSingleResult();

        card3.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/pinjam_1.png")), "Jumlah Peminjaman Buku SIBoox", jumlahPeminjaman.toString()));

        emPeminjaman.close();
        emfPeminjaman.close();
        
        // Mengambil jumlah peminjaman skripsi
        EntityManagerFactory emfPeminjamanSkripsi = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager emPeminjamanSkripsi = emfPeminjamanSkripsi.createEntityManager();

        Query queryPeminjamanSkripsi = emPeminjamanSkripsi.createQuery("SELECT COUNT(ps.idPeminjaman) FROM Peminjamanskripsi_1 ps");
        Long jumlahPeminjamanSkripsi = (Long) queryPeminjamanSkripsi.getSingleResult();

        card4.setData(new ModelCard(new ImageIcon(getClass().getResource("/img/pinjam_1.png")), "Jumlah Peminjaman Skripsi SIBoox", jumlahPeminjamanSkripsi.toString()));

        emPeminjamanSkripsi.close();
        emfPeminjamanSkripsi.close();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panel1 = new javax.swing.JLayeredPane();
        card1 = new projectuas.Card();
        card2 = new projectuas.Card();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        panel2 = new javax.swing.JLayeredPane();
        card3 = new projectuas.Card();
        card4 = new projectuas.Card();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(637, 485));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panel1.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        card1.setColor1(new java.awt.Color(0, 0, 102));
        card1.setColor2(new java.awt.Color(0, 153, 255));
        panel1.add(card1);

        card2.setColor1(new java.awt.Color(0, 0, 102));
        card2.setColor2(new java.awt.Color(0, 153, 255));
        panel1.add(card2);

        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Home > Dashboard");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_1.png"))); // NOI18N

        panel2.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        card3.setColor1(new java.awt.Color(0, 0, 102));
        card3.setColor2(new java.awt.Color(0, 153, 255));
        panel2.add(card3);

        card4.setColor1(new java.awt.Color(0, 0, 102));
        card4.setColor2(new java.awt.Color(0, 153, 255));
        panel2.add(card4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private projectuas.Card card1;
    private projectuas.Card card2;
    private projectuas.Card card3;
    private projectuas.Card card4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLayeredPane panel1;
    private javax.swing.JLayeredPane panel2;
    // End of variables declaration//GEN-END:variables
}
