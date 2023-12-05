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
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ReportSkripsi extends javax.swing.JPanel {

    ArrayList<Skripsi_1> dataSkripsi;

    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT s FROM Skripsi_1 s");
        List<Skripsi_1> results = query.getResultList();
        entityManager.getTransaction().commit();

        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        for (Skripsi_1 s : results) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
        }
        entityManager.close();
    }

    //    private Timer refreshTimer;
    public ReportSkripsi() {
        try {

            dataSkripsi = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();

            // Membuat dan mengatur timer untuk auto-refresh setiap 5 detik (5000 milidetik)
//            refreshTimer = new Timer(1000, new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    tampil();
//                }
//            });
//            refreshTimer.start();
        } catch (SQLException ex) {
            Logger.getLogger(MenuSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void bersih() {
        jTextFieldPencarian.setText("Pencarian");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txt_judul = new javax.swing.JLabel();
        img_logo = new javax.swing.JLabel();
        jTextFieldPencarian = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableSkripsi = new javax.swing.JTable();
        icon_buku1 = new javax.swing.JLabel();
        txt_menu1 = new javax.swing.JLabel();

        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1076, 646));
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(1076, 646));

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Cetak Skripsi SIBoox");

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        jTextFieldPencarian.setText("Pencarian");
        jTextFieldPencarian.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jTextFieldPencarian.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldPencarianFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPencarianFocusLost(evt);
            }
        });
        jTextFieldPencarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPencarianActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Skripsi", "Judul", "Pengarang", "Tahun", "Jumlah_Halaman" }));

        jButton2.setBackground(new java.awt.Color(0, 0, 102));
        jButton2.setForeground(new java.awt.Color(0, 153, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Print.png"))); // NOI18N
        jButton2.setText("Cetak");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        JTableSkripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Skripsi", "Judul", "Pengarang", "Tahun", "JumlahHalaman"
            }
        ));
        JTableSkripsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableSkripsiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableSkripsi);

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Literature10.png"))); // NOI18N

        txt_menu1.setForeground(new java.awt.Color(102, 102, 102));
        txt_menu1.setText("Home > Cetak > Skripsi");

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
                        .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jButton1)
                        .addGap(5, 5, 5)
                        .addComponent(jButton2)
                        .addContainerGap(428, Short.MAX_VALUE))
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
                    .addGap(21, 21, 21)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(139, 139, 139)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(156, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, "card2");

        add(jPanel1, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldPencarianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarianFocusGained
        String pencarian = jTextFieldPencarian.getText();
        if (pencarian.equals("Pencarian")) {
            jTextFieldPencarian.setText("");
        }
    }//GEN-LAST:event_jTextFieldPencarianFocusGained

    private void jTextFieldPencarianFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarianFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarianFocusLost

    private void jTextFieldPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarianActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = jTextFieldPencarian.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataidSkripsi(s);
                break;
            case 1:
                getdatajudul(s);
                break;
            case 2:
                getdatapengarang(s);
                break;
            case 3:
                getdatatahun(s);
                break;
            case 4:
                getdatajumlahHalaman(s);
                break;

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String selection = (String) jComboBoxPencarian.getSelectedItem();
            String reportPath = "src/projectuas/reportSkripsi.jrxml";
            String searchTerm = jTextFieldPencarian.getText().trim();

            if (selection == null || selection.isEmpty()) {
                throw new IllegalArgumentException("-");
            }

            // Building the JPA query dynamically based on the selected criteria
            String queryString = "SELECT s FROM Skripsi_1 s WHERE ";

            switch (jComboBoxPencarian.getSelectedIndex()) {
                case 0:
                    queryString += "LOWER(s.idSkripsi) LIKE LOWER(:searchTerm)";
                    break;
                case 1:
                    queryString += "LOWER(s.judul) LIKE LOWER(:searchTerm)";
                    break;
                case 2:
                    queryString += "LOWER(s.pengarang) LIKE LOWER(:searchTerm)";
                    break;
                case 3:
                    queryString += "LOWER(s.tahun) LIKE LOWER(:searchTerm)";
                    break;
                case 4:
                    queryString += "LOWER(s.jumlahHalaman) LIKE LOWER (:searchTerm)";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid search criteria selected.");
            }

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Skripsi_1> cq = cb.createQuery(Skripsi_1.class);
            Root<Skripsi_1> bok = cq.from(Skripsi_1.class);
            cq.select(bok);

            // Check if WHERE clause is not empty
            if (queryString.endsWith(" WHERE ")) {
                throw new IllegalArgumentException("No search criteria selected.");
            }

            TypedQuery<Skripsi_1> q = em.createQuery(cq);
            List<Skripsi_1> list = q.getResultList();
            Query query = em.createQuery(queryString);
            query.setParameter("searchTerm", "%" + searchTerm + "%");

            List<Skripsi_1> results = query.getResultList();

            List<Object[]> data = new ArrayList<>();
            for (Skripsi_1 result : results) {
                Object[] rowData = {
                    result.getId_skripsi(),
                    result.getJudul(),
                    result.getPengarang(),
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

    }//GEN-LAST:event_jButton2ActionPerformed

    private void JTableSkripsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableSkripsiMouseClicked

    }//GEN-LAST:event_JTableSkripsiMouseClicked

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableSkripsi;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldPencarian;
    private javax.swing.JLabel txt_judul;
    private javax.swing.JLabel txt_menu1;
    // End of variables declaration//GEN-END:variables

    private void ambildata() {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

    void getdataidSkripsi(String idSkripsi) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s WHERE LOWER(s.idSkripsi) LIKE :idSkripsi");
        query.setParameter("idSkripsi", "%" + idSkripsi.toLowerCase() + "%");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

    void getdatajudul(String judul) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s WHERE LOWER(s.judul) LIKE :judul");
        query.setParameter("judul", "%" + judul.toLowerCase() + "%");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

    void getdatapengarang(String pengarang) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s WHERE LOWER(s.pengarang) LIKE :pengarang");
        query.setParameter("pengarang", "%" + pengarang.toLowerCase() + "%");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

    void getdatatahun(String tahun) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s WHERE LOWER(s.tahun) LIKE :tahun");
        query.setParameter("tahun", "%" + tahun.toLowerCase() + "%");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

    void getdatajumlahHalaman(String jumlahHalaman) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT s FROM Skripsi_1 s WHERE LOWER(s.jumlahHalaman) LIKE :jumlahHalaman");
        query.setParameter("jumlahHalaman", "%" + jumlahHalaman.toLowerCase() + "%");
        List<Skripsi_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Skripsi_1 s : list) {
            Object[] ob = new Object[5];
            ob[0] = s.getId_skripsi();
            ob[1] = s.getJudul();
            ob[2] = s.getPengarang();
            ob[3] = s.getTahun();
            ob[4] = s.getJumlah_halaman();
            tbl.addRow(ob);
            i++;
        }
    }

}
