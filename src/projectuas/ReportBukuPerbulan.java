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
import java.util.Date;
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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportBukuPerbulan extends javax.swing.JPanel {

    ArrayList<Buku_1> dataBuku;

    private void tampil() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Peminjaman_1> peminjamanRoot = cq.from(Peminjaman_1.class);
        Join<Peminjaman_1, Buku_1> bukuJoin = peminjamanRoot.join("isbn", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                bukuJoin.get("isbn"),
                bukuJoin.get("judul"),
                peminjamanRoot.get("tanggalPeminjaman"),
                peminjamanRoot.get("tanggalPengembalian")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanBuku.getModel();
        tbl.setRowCount(0);
        for (Object[] row : results) {
            tbl.addRow(row);
        }

        em.close();
        emf.close();
    }

    public ReportBukuPerbulan() {
        try {

            dataBuku = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();

        } catch (SQLException ex) {
            Logger.getLogger(ReportBukuPerbulan.class.getName()).log(Level.SEVERE, null, ex);
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
        JTablePeminjamanBuku = new javax.swing.JTable();
        jTextFieldPencarian1 = new javax.swing.JTextField();
        jButtonCari = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();
        jButtonCetak = new javax.swing.JButton();
        txt_menu1 = new javax.swing.JLabel();
        icon_buku1 = new javax.swing.JLabel();
        jDateChooserAwal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jDateChooserAkhir = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Cetak Peminjaman Buku Bulanan SIBoox");

        JTablePeminjamanBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Peminjaman", "NIM Peminjam", "Nama Lengkap", "Prodi", "Angkatan", "ISBN", "Judul Buku", "Tanggal Peminjaman", "Tanggal Pengembalian"
            }
        ));
        JTablePeminjamanBuku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablePeminjamanBukuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTablePeminjamanBuku);

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

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angkatan", "NIM", " " }));
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
        txt_menu1.setText("Home > Cetak > Bulanan Buku");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Book (1).png"))); // NOI18N

        jLabel1.setText("Dari Tanggal");

        jLabel2.setText("Sampai Tanggal");

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
                        .addComponent(jButtonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(5, 5, 5)
                        .addComponent(txt_judul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon_buku1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_menu1)))
                .addGap(166, 166, 166))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 928, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(162, Short.MAX_VALUE)))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPencarian1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jButtonCari, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jComboBoxPencarian))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jDateChooserAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jDateChooserAkhir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(500, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(169, 169, 169)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(126, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, "card2");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed

        try {
            String reportPath = "src/projectuas/reportBukuPerbulan.jrxml";
            Date tanggalAwal = (Date) jDateChooserAwal.getDate();
            Date tanggalAkhir = (Date) jDateChooserAkhir.getDate();

            String searchTerm = jTextFieldPencarian1.getText().trim();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> criteriaQuery = criteriaBuilder.createQuery(Object[].class);
            Root<Peminjaman_1> pRoot = criteriaQuery.from(Peminjaman_1.class);
            Join<Peminjaman_1, Buku_1> bJoin = pRoot.join("isbn", JoinType.INNER);

            List<Predicate> predicates = new ArrayList<>();

            if (!searchTerm.isEmpty()) {
                switch (jComboBoxPencarian.getSelectedIndex()) {
                    case 0:
                        predicates.add(criteriaBuilder.equal(pRoot.get("angkatan"), Integer.parseInt(searchTerm)));
                        break;
                    case 1:
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(pRoot.get("nim")), "%" + searchTerm.toLowerCase() + "%"));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid search criteria selected.");
                }
            }

            if (tanggalAwal != null && tanggalAkhir != null) {
                predicates.add(criteriaBuilder.between(pRoot.get("tanggalPeminjaman"), tanggalAwal, tanggalAkhir));
            }

            criteriaQuery.multiselect(
                    pRoot.get("idPeminjaman"),
                    pRoot.get("nim"),
                    pRoot.get("nama"),
                    pRoot.get("prodi"),
                    pRoot.get("angkatan"),
                    bJoin.get("isbn"),
                    bJoin.get("judul"),
                    pRoot.get("tanggalPeminjaman"),
                    pRoot.get("tanggalPengembalian")
            );

            if (!predicates.isEmpty()) {
                criteriaQuery.where(predicates.toArray(new Predicate[0]));
            }

            TypedQuery<Object[]> query = em.createQuery(criteriaQuery);

            // Set parameter tanggal jika dimasukkan
            if (tanggalAwal != null && tanggalAkhir != null) {
                query.setParameter("tanggalAwal", tanggalAwal);
                query.setParameter("tanggalAkhir", tanggalAkhir);
            }

            List<Object[]> results = query.getResultList();
            em.getTransaction().commit();
            em.close();
            emf.close();

            List<Map<String, Object>> mappedResults = new ArrayList<>();
            for (Object[] result : results) {
                Map<String, Object> map = new HashMap<>();
                map.put("id_peminjaman", result[0]);
                map.put("nim", result[1]);
                map.put("nama", result[2]);
                map.put("prodi", result[3]);
                map.put("angkatan", result[4]);
                map.put("isbn", result[5]);
                map.put("judul", result[6]);
                map.put("tanggal_peminjaman", new java.sql.Date(((Date) result[7]).getTime()));
                map.put("tanggal_pengembalian", new java.sql.Date(((Date) result[8]).getTime()));
                mappedResults.add(map);
            }

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("queryString", searchTerm);
            parameter.put("searchBy", jComboBoxPencarian.getSelectedItem());
            parameter.put("tanggalAwal", tanggalAwal);
            parameter.put("tanggalAkhir", tanggalAkhir);

            // Membuat sumber data untuk JasperReports dari data hasil pencarian
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(mappedResults);

            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException | NumberFormatException ex) {
            Logger.getLogger(ReportBukuPerbulan.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jComboBoxPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPencarianActionPerformed

    private void jButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCariActionPerformed
        String s = jTextFieldPencarian1.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataangkatan(s);
                break;
            case 1:
                getdatanim(s);
                break;
        }
    }//GEN-LAST:event_jButtonCariActionPerformed

    private void jTextFieldPencarian1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarian1ActionPerformed

    private void jTextFieldPencarian1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarian1FocusLost

    private void jTextFieldPencarian1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarian1FocusGained
        String pencarian = jTextFieldPencarian1.getText();
        if (pencarian.equals("Pencarian")) {
            jTextFieldPencarian1.setText("");
        }
    }//GEN-LAST:event_jTextFieldPencarian1FocusGained

    private void JTablePeminjamanBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePeminjamanBukuMouseClicked

    }//GEN-LAST:event_JTablePeminjamanBukuMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePeminjamanBuku;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private com.toedter.calendar.JDateChooser jDateChooserAkhir;
    private com.toedter.calendar.JDateChooser jDateChooserAwal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
        Root<Peminjaman_1> peminjamanRoot = cq.from(Peminjaman_1.class);
        Join<Peminjaman_1, Buku_1> bukuJoin = peminjamanRoot.join("isbn", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                bukuJoin.get("isbn"),
                bukuJoin.get("judul"),
                peminjamanRoot.get("tanggalPeminjaman"),
                peminjamanRoot.get("tanggalPengembalian")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdataangkatan(String angkatan) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Peminjaman_1> peminjamanRoot = cq.from(Peminjaman_1.class);
        Join<Peminjaman_1, Buku_1> bukuJoin = peminjamanRoot.join("isbn", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                bukuJoin.get("isbn"),
                bukuJoin.get("judul"),
                peminjamanRoot.get("tanggalPeminjaman"),
                peminjamanRoot.get("tanggalPengembalian")
        );

        cq.where(cb.like(cb.lower(peminjamanRoot.get("angkatan")), "%" + angkatan.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    void getdatanim(String nim) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Peminjaman_1> peminjamanRoot = cq.from(Peminjaman_1.class);
        Join<Peminjaman_1, Buku_1> bukuJoin = peminjamanRoot.join("isbn", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                bukuJoin.get("isbn"),
                bukuJoin.get("judul"),
                peminjamanRoot.get("tanggalPeminjaman"),
                peminjamanRoot.get("tanggalPengembalian")
        );

        cq.where(cb.like(cb.lower(peminjamanRoot.get("nim")), "%" + nim.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanBuku.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

}
