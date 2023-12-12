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

public class ReportPeminjamanSkripsi extends javax.swing.JPanel {

    ArrayList<Skripsi_1> dataBuku;

    private void tampil() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                skripsiJoin.get("idSkripsi"),
                skripsiJoin.get("judul"),
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

    public ReportPeminjamanSkripsi() {
        try {

            dataBuku = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();

        } catch (SQLException ex) {
            Logger.getLogger(ReportPeminjamanSkripsi.class.getName()).log(Level.SEVERE, null, ex);
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
        jButtonCetakJumlah = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Cetak Peminjaman Skripsi SIBoox");

        JTablePeminjamanBuku.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Peminjaman", "NIM Peminjam", "Nama Lengkap", "Prodi", "Angkatan", "Id Skripsi", "Judul Skripsi", "Tanggal Peminjaman", "Tanggal Pengembalian"
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

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angkatan", "NIM", "Bulan" }));
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
        txt_menu1.setText("Home > Cetak > Peminjaman Skripsi");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Literature10.png"))); // NOI18N

        jButtonCetakJumlah.setBackground(new java.awt.Color(0, 0, 102));
        jButtonCetakJumlah.setForeground(new java.awt.Color(0, 153, 255));
        jButtonCetakJumlah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        jButtonCetakJumlah.setText("Jumlah Skripsi dipinjam");
        jButtonCetakJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCetakJumlahActionPerformed(evt);
            }
        });

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCetakJumlah)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(5, 5, 5)
                        .addComponent(txt_judul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 405, Short.MAX_VALUE)
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
                        .addComponent(jButtonCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonCetakJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                getdataangkatan(s);
                break;
            case 1:
                getdatanim(s);
                break;
        }

    }//GEN-LAST:event_jButtonCariActionPerformed

    private void jButtonCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakActionPerformed

        try {
            String selection = (String) jComboBoxPencarian.getSelectedItem();
            String reportPath = "src/projectuas/reportPeminjamanSkripsi.jrxml";
            String searchTerm = jTextFieldPencarian1.getText().trim();

            if (selection == null || selection.isEmpty()) {
                throw new IllegalArgumentException("-");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
            Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER);

            Predicate searchPredicate;
            switch (jComboBoxPencarian.getSelectedIndex()) {
                case 0:
                    searchPredicate = cb.like(cb.lower(peminjamanRoot.get("angkatan")), "%" + searchTerm.toLowerCase() + "%");
                    break;
                case 1:
                    searchPredicate = cb.like(cb.lower(peminjamanRoot.get("nim")), "%" + searchTerm.toLowerCase() + "%");
                    break;
                default:
                    throw new IllegalArgumentException("Invalid search criteria selected.");
            }

            cq.where(searchPredicate);

            cq.multiselect(
                    peminjamanRoot.get("idPeminjaman"),
                    peminjamanRoot.get("nim"),
                    peminjamanRoot.get("nama"),
                    peminjamanRoot.get("prodi"),
                    peminjamanRoot.get("angkatan"),
                    skripsiJoin.get("idSkripsi"),
                    skripsiJoin.get("judul"),
                    peminjamanRoot.get("tanggalPeminjaman"),
                    peminjamanRoot.get("tanggalPengembalian")
            );

            TypedQuery<Object[]> query = em.createQuery(cq);
            List<Object[]> results = query.getResultList();
            em.getTransaction().commit();

            em.close();
            emf.close();

            // Mapping hasil query ke dalam parameter JasperReport
            List<Map<String, Object>> mappedResults = new ArrayList<>();
            for (Object[] result : results) {
                Map<String, Object> map = new HashMap<>();
                String idPeminjaman = (String) result[0];
                String nim = (String) result[1];
                String nama = (String) result[2];
                String prodi = (String) result[3];
                String angkatan = (String) result[4];
                String idSkripsi = (String) result[5];
                String judul = (String) result[6];
                Date tanggalPeminjaman = (Date) result[7];
                Date tanggalPengembalian = (Date) result[8];

                // Ubah menjadi java.sql.Date
                java.sql.Date sqlTanggalPeminjaman = new java.sql.Date(tanggalPeminjaman.getTime());
                java.sql.Date sqlTanggalPengembalian = new java.sql.Date(tanggalPengembalian.getTime());

                map.put("id_peminjaman", idPeminjaman);
                map.put("nim", nim);
                map.put("nama", nama);
                map.put("prodi", prodi);
                map.put("angkatan", angkatan);
                map.put("id_skripsi", idSkripsi);
                map.put("judul", judul);
                map.put("tanggal_peminjaman", sqlTanggalPeminjaman);
                map.put("tanggal_pengembalian", sqlTanggalPengembalian);
                mappedResults.add(map);
            }

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("querySearch", searchTerm);
            parameter.put("searchBy", selection);

            // Creating a JasperReports data source from the mapped results
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(mappedResults);

            // Loading the report design file (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ReportPeminjamanSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jButtonCetakActionPerformed

    private void jComboBoxPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPencarianActionPerformed

    private void JTablePeminjamanBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePeminjamanBukuMouseClicked

    }//GEN-LAST:event_JTablePeminjamanBukuMouseClicked

    private void jButtonCetakJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCetakJumlahActionPerformed
        try {
            String selection = (String) jComboBoxPencarian.getSelectedItem();
            String reportPath = "src/projectuas/reportJumlahPeminjamanSkripsi.jrxml";
            String searchTerm = jTextFieldPencarian1.getText().trim();

            if (selection == null || selection.isEmpty()) {
                throw new IllegalArgumentException("-");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
            Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
            Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER);

            cq.multiselect(
                    skripsiJoin.get("idSkripsi"),
                    skripsiJoin.get("judul"),
                    cb.count(peminjamanRoot.get("idPeminjaman")).alias("jumlah_peminjaman")
            );

            cq.groupBy(skripsiJoin.get("idSkripsi"), skripsiJoin.get("judul"));
            cq.orderBy(cb.desc(cb.count(peminjamanRoot.get("idPeminjaman"))));

            TypedQuery<Object[]> query = em.createQuery(cq);
            List<Object[]> results = query.getResultList();
            em.getTransaction().commit();

            em.close();
            emf.close();

            // Mapping hasil query ke dalam parameter JasperReport
            List<Map<String, Object>> mappedResults = new ArrayList<>();
            for (Object[] result : results) {
                Map<String, Object> map = new HashMap<>();
                String idSkripsi = (String) result[0];
                String judul = (String) result[1];
                Long jumlahPeminjaman = (Long) result[2];

                map.put("id_skripsi", idSkripsi);
                map.put("judul", judul);
                map.put("jumlah_peminjaman", jumlahPeminjaman);
                mappedResults.add(map);
            }


            // Creating a JasperReports data source from the mapped results
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(mappedResults);

            // Loading the report design file (*.jrxml)
            JasperReport jasperReport = JasperCompileManager.compileReport(reportPath);
            JasperPrint print = JasperFillManager.fillReport(jasperReport, null, dataSource);
            JasperViewer viewer = new JasperViewer(print, false);
            viewer.setVisible(true);

        } catch (JRException ex) {
            Logger.getLogger(ReportPeminjamanSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonCetakJumlahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePeminjamanBuku;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButtonCari;
    private javax.swing.JButton jButtonCetak;
    private javax.swing.JButton jButtonCetakJumlah;
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
        Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                skripsiJoin.get("idSkripsi"),
                skripsiJoin.get("judul"),
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
        Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                skripsiJoin.get("idSkripsi"),
                skripsiJoin.get("judul"),
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
        Root<Peminjamanskripsi_1> peminjamanRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanRoot.get("idPeminjaman"),
                peminjamanRoot.get("nim"),
                peminjamanRoot.get("nama"),
                peminjamanRoot.get("prodi"),
                peminjamanRoot.get("angkatan"),
                skripsiJoin.get("idSkripsi"),
                skripsiJoin.get("judul"),
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
