/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package projectuas;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportBuku extends javax.swing.JPanel {

    ArrayList<Buku_1> dataBuku;

//    private void tampil() {
//        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
//        entityManager.getTransaction().begin();
//        Query query = entityManager.createQuery("SELECT b FROM Buku_1 b");
//        List<Buku_1> results = query.getResultList();
//        entityManager.getTransaction().commit();
////        
//        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
//        tbl.setRowCount(0);
//        for (Buku_1 b : results) {
//            Object[] ob = new Object[7];
//            ob[0] = b.getIsbn();
//            ob[1] = b.getJudul();
//            ob[2] = b.getNamaKategori();
//            ob[3] = b.getPengarang();
//            ob[4] = b.getPenerbit();
//            ob[5] = b.getTahun();
//            ob[6] = b.getJumlah_halaman();
//            tbl.addRow(ob);
//        }
//        entityManager.close();
//    }
    private void tampil() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Buku_1

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"),
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        for (Object[] row : results) {
            tbl.addRow(row);
        }

        em.close();
        emf.close();
    }

    //    private Timer refreshTimer;
    public ReportBuku() {
        try {

            dataBuku = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();

//            refreshTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    tampil();
//                }
//            });
//            refreshTimer.start();
        } catch (SQLException ex) {
            Logger.getLogger(MenuBuku.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void bersih() {
        jTextFieldPencarian1.setText("Pencarian");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        img_logo = new javax.swing.JLabel();
        txt_judul = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableBuku = new javax.swing.JTable();
        jTextFieldPencarian1 = new javax.swing.JTextField();
        jButtonCari = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();
        jButtonCetak = new javax.swing.JButton();
        txt_menu1 = new javax.swing.JLabel();
        icon_buku1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Cetak Buku SIBoox");

        JTableBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Judul", "Id Kategori", "Kategori", "Pengarang", "Penerbit", "Tahun", "Jumlah_Halaman"
            }
        ));
        JTableBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableBukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableBuku);

        jTextFieldPencarian1.setText("Pencarian");
        jTextFieldPencarian1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jTextFieldPencarian1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPencarian1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPencarian1FocusLost(evt);
            }
        });
        jTextFieldPencarian1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPencarian1ActionPerformed(evt);
            }
        });

        jButtonCari.setBackground(new java.awt.Color(0, 0, 102));
        jButtonCari.setForeground(new java.awt.Color(0, 153, 255));
        jButtonCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButtonCari.setText("Cari");
        jButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCariActionPerformed(evt);
            }
        });

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Judul", "Pengarang", "Penerbit", "Tahun", "Jumlah_Halaman" }));
        jComboBoxPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPencarianActionPerformed(evt);
            }
        });

        jButtonCetak.setBackground(new java.awt.Color(0, 0, 102));
        jButtonCetak.setForeground(new java.awt.Color(0, 153, 255));
        jButtonCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        jButtonCetak.setText("Cetak");
        jButtonCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakActionPerformed(evt);
            }
        });

        txt_menu1.setForeground(new java.awt.Color(102, 102, 102));
        txt_menu1.setText("Home > Cetak > Buku");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Book (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jTextFieldPencarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonCari)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonCetak)
                        .addContainerGap(516, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(5, 5, 5)
                        .addComponent(txt_judul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon_buku1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_menu1)
                        .addGap(20, 20, 20))))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane2)
                    .addGap(20, 20, 20)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon_buku1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldPencarian1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                        .addComponent(jButtonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBoxPencarian))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(177, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, "card2");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPencarian1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1FocusGained
        String pencarian = jTextFieldPencarian1.getText();
        if (pencarian.equals("Pencarian")) {
            jTextFieldPencarian1.setText("");
        }
    }//GEN-LAST:event_jTextFieldPencarian1FocusGained

    private void jTextFieldPencarian1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarian1FocusLost

    private void jTextFieldPencarian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarian1ActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        String s = jTextFieldPencarian1.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataisbn(s);
                break;
            case 1:
                getdatajudul(s);
                break;
            case 2:
                getdatapengarang(s);
                break;
            case 3:
                getdatapenerbit(s);
                break;
            case 4:
                getdatatahun(s);
                break;
            case 5:
                getdatajumlahHalaman(s);
                break;

        }

    }//GEN-LAST:event_jButtonCariActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed

         try {
            String selection = (String) jComboBoxPencarian.getSelectedItem();
            String reportPath = "src/projectuas/reportBuku.jrxml";
            String searchTerm = jTextFieldPencarian1.getText().trim();

            if (selection == null || selection.isEmpty()) {
                throw new IllegalArgumentException("-");
            }

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT b FROM Buku_1 b WHERE ";

            switch (jComboBoxPencarian.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(b.isbn) LIKE LOWER(:searchTerm)";
                    break;
                case 1:
                    queryString += "LOWER(b.judul) LIKE LOWER(:searchTerm)";
                    break;
                case 2:
                    queryString += "LOWER(b.pengarang) LIKE LOWER(:searchTerm)";
                    break;
                case 3:
                    queryString += "LOWER(b.penerbit) LIKE LOWER(:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(b.tahun) LIKE LOWER(:searchTerm)";
                    break;
                case 5:
                    queryString += "LOWER(b.jumlahHalaman) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Buku_1> cq = cb.createQuery(Buku_1.class);
            Root<Buku_1> bok = cq.from(Buku_1.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<Buku_1> q = em.createQuery(cq);
            List<Buku_1> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<Buku_1> results = query.getResultList();

            List<Object[]> data = new ArrayList<>();
            for (Buku_1 result : results) {
                Object[] rowData = {
                    result.getIsbn(),
                    result.getJudul(),
                    result.getPengarang(),
                    result.getPenerbit(),
                    result.getTahun(),
                    result.getJumlah_halaman()
                };
                data.add(rowData);
            }
            em.getTransaction().commit();
            em.close();
            emf.close();

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(results);

            // Memuat file desain laporan (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jComboBoxPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPencarianActionPerformed

    private void JTableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableBukuMouseClicked

    }//GEN-LAST:event_JTableBukuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableBuku;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldPencarian1;
    private javax.swing.JLabel txt_judul;
    private javax.swing.JLabel txt_menu1;
    // End of variables declaration//GEN-END:variables
private void ambildata() {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Buku_1

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"), // Mengakses atribut nama dari objek Kategori_1
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdataisbn(String isbn) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Buku_1

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"), // Mengakses atribut nama dari objek Kategori_1
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("isbn")), "%" + isbn.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdatajudul(String judul) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Buku_1

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"), // Mengakses atribut nama dari objek Kategori_1
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("judul")), "%" + judul.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

//    void getdatakategori(String kategori) {
//        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder cb = em.getCriteriaBuilder();
//        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
//        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
//        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Buku_1
//
//        cq.multiselect(
//                bukuRoot.get("isbn"),
//                bukuRoot.get("judul"),
//                kategoriJoin.get("idKategori"),
//                kategoriJoin.get("nama").alias("kategori"), // Mengakses atribut nama dari objek Kategori_1
//                bukuRoot.get("pengarang"),
//                bukuRoot.get("penerbit"),
//                bukuRoot.get("tahun"),
//                bukuRoot.get("jumlahHalaman")
//        );
//
//        cq.where(cb.like(cb.lower(kategoriJoin.get("nama")), "%" + kategori.toLowerCase() + "%"));
//
//        List<Object[]> results = em.createQuery(cq).getResultList();
//        em.getTransaction().commit();
//        em.close();
//
//        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
//        tbl.setRowCount(0);
//        int i = 1;
//        for (Object[] row : results) {
//            tbl.addRow(row);
//            i++;
//        }
//    }

    void getdatapengarang(String pengarang) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER);

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"),
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("pengarang")), "%" + pengarang.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdatapenerbit(String penerbit) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER);

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"),
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("penerbit")), "%" + penerbit.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdatatahun(String tahun) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER);

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"),
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("tahun")), "%" + tahun.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdatajumlahHalaman(String jumlahHalaman) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Buku_1> bukuRoot = cq.from(Buku_1.class);
        Join<Buku_1, Kategori_1> kategoriJoin = bukuRoot.join("idKategori", JoinType.INNER);

        cq.multiselect(
                bukuRoot.get("isbn"),
                bukuRoot.get("judul"),
                kategoriJoin.get("idKategori"),
                kategoriJoin.get("nama").alias("kategori"),
                bukuRoot.get("pengarang"),
                bukuRoot.get("penerbit"),
                bukuRoot.get("tahun"),
                bukuRoot.get("jumlahHalaman")
        );

        cq.where(cb.like(cb.lower(bukuRoot.get("jumlahHalaman")), "%" + jumlahHalaman.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTableBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }
}
