/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package projectuas;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * @author HP
 */
public class MenuKategori extends javax.swing.JPanel {
   
    
   ArrayList<Kategori_1> dataKategori;

    private void tampil() {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("SELECT k FROM Kategori_1 k");
        List<Kategori_1> results = query.getResultList();
        entityManager.getTransaction().commit();
        
        DefaultTableModel tbl = (DefaultTableModel) JTableKategori.getModel();
        tbl.setRowCount(0);
        for (Kategori_1 k : results) {
            Object[] ob = new Object[2];
            ob[0] = k.getIdKategori();
            ob[1] = k.getNama();
            tbl.addRow(ob);
        }
        entityManager.close();
    }
    
//    private Timer refreshTimer;
    public MenuKategori() {
        try {
            
            dataKategori = new ArrayList<>();
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
            Logger.getLogger(MenuKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void bersih(){
        jTextFieldPencarian.setText("Pencarian");
    }
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMain = new javax.swing.JPanel();
        jPanelDataBuku = new javax.swing.JPanel();
        img_logo = new javax.swing.JLabel();
        txt_judul = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_Edit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableKategori = new javax.swing.JTable();
        jTextFieldPencarian = new javax.swing.JTextField();
        txt_menu1 = new javax.swing.JLabel();
        icon_buku1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelIDKategori = new javax.swing.JLabel();
        jTextFieldIDKategori = new javax.swing.JTextField();
        jLabelNamaKategori = new javax.swing.JLabel();
        jTextFieldNama = new javax.swing.JTextField();
        bt_Upload = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new java.awt.CardLayout());

        jPanelDataBuku.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDataBuku.setPreferredSize(new java.awt.Dimension(1076, 646));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Kategori Buku SIBoox");

        bt_tambah.setBackground(new java.awt.Color(0, 0, 102));
        bt_tambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_tambah.setForeground(new java.awt.Color(0, 153, 255));
        bt_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Plus.png"))); // NOI18N
        bt_tambah.setText("Tambah");
        bt_tambah.setBorder(null);
        bt_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tambahActionPerformed(evt);
            }
        });

        bt_hapus.setBackground(new java.awt.Color(0, 0, 102));
        bt_hapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_hapus.setForeground(new java.awt.Color(0, 153, 255));
        bt_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Waste.png"))); // NOI18N
        bt_hapus.setText("Hapus");
        bt_hapus.setBorder(null);
        bt_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_hapusActionPerformed(evt);
            }
        });

        bt_Edit.setBackground(new java.awt.Color(0, 0, 102));
        bt_Edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Edit.setForeground(new java.awt.Color(0, 153, 255));
        bt_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Edit.png"))); // NOI18N
        bt_Edit.setText("Edit");
        bt_Edit.setBorder(null);
        bt_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_EditActionPerformed(evt);
            }
        });

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        JTableKategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID Kategori", "Nama Kategori"
            }
        ));
        JTableKategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTableKategoriMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTableKategori);

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

        txt_menu1.setForeground(new java.awt.Color(102, 102, 102));
        txt_menu1.setText("Home > Koleksi > Kategori");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Category10.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelIDKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelIDKategori.setText("ID Kategori");
        jLabelIDKategori.setToolTipText("");
        jLabelIDKategori.setPreferredSize(new java.awt.Dimension(29, 16));

        jTextFieldIDKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDKategoriActionPerformed(evt);
            }
        });

        jLabelNamaKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelNamaKategori.setText("Nama Kategori");

        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });

        bt_Upload.setBackground(new java.awt.Color(0, 0, 102));
        bt_Upload.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        bt_Upload.setForeground(new java.awt.Color(0, 153, 255));
        bt_Upload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Add.png"))); // NOI18N
        bt_Upload.setText("Unggah File");
        bt_Upload.setBorder(null);
        bt_Upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UploadActionPerformed(evt);
            }
        });

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID Kategori", "Nama Kategori", " " }));

        javax.swing.GroupLayout jPanelDataBukuLayout = new javax.swing.GroupLayout(jPanelDataBuku);
        jPanelDataBuku.setLayout(jPanelDataBukuLayout);
        jPanelDataBukuLayout.setHorizontalGroup(
            jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNamaKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelIDKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNama)
                            .addComponent(jTextFieldIDKategori)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                        .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 183, Short.MAX_VALUE)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBoxPencarian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.DEFAULT_SIZE, 334, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(5, 5, 5)
                        .addComponent(txt_judul)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(icon_buku1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_menu1)))
                .addGap(20, 20, 20))
        );
        jPanelDataBukuLayout.setVerticalGroup(
            jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(icon_buku1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelIDKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIDKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNamaKategori, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(216, 216, 216))
        );

        jPanelMain.add(jPanelDataBuku, "card2");

        add(jPanelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed
        String idKategori = jTextFieldIDKategori.getText().trim();
        String nama = jTextFieldNama.getText();


        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Kategori_1 k = new Kategori_1();
        k.setIdKategori(idKategori);

        if (k != null) {
            k.setNama(nama);
            entityManager.persist(k);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");
        } else {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan.");
        }

        // akhir persistence
        jTextFieldIDKategori.setText("");
        jTextFieldNama.setText("");
        
        tampil();
        
    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        String idKategori = jTextFieldIDKategori.getText().trim();

        //awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Kategori_1 k = entityManager.find(Kategori_1.class, idKategori);

        if (k != null) {
            entityManager.remove(k);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
        } else {
            JOptionPane.showMessageDialog(null, "Data dengan Id Kategori " + idKategori + " gagal dihapus.");
        }
        // akhir persistence
        jTextFieldIDKategori.setText("");
        jTextFieldNama.setText("");
        
        tampil();

    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EditActionPerformed
        String idKategori = jTextFieldIDKategori.getText().trim();
        String nama = jTextFieldNama.getText();


        // awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Kategori_1 k = entityManager.find(Kategori_1.class, idKategori);

        if (k != null) {
            k.setNama(nama);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Data berhasil diedit.");
        } else {
            JOptionPane.showMessageDialog(null, "data dengan Id Kategori " + idKategori + " gagal diedit.");
        }
        
        // akhir persistence
        jTextFieldIDKategori.setText("");
        jTextFieldNama.setText("");
        
        tampil();

    }//GEN-LAST:event_bt_EditActionPerformed

    private void jTextFieldPencarianFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarianFocusGained
        String pencarian=jTextFieldPencarian.getText();
        if(pencarian.equals("Pencarian")){
            jTextFieldPencarian.setText("");
        }
    }//GEN-LAST:event_jTextFieldPencarianFocusGained

    private void jTextFieldPencarianFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPencarianFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarianFocusLost

    private void jTextFieldPencarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPencarianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPencarianActionPerformed

    private void JTableKategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableKategoriMouseClicked
        try {
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            int row = JTableKategori.getSelectedRow();
            String tabel_klik = (JTableKategori.getModel().getValueAt(row, 0).toString());
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM kategori WHERE id_kategori='" + tabel_klik + "'");
            if (sql.next()) {
                String idKategori = sql.getString("id_kategori");
                jTextFieldIDKategori.setText(idKategori);
                String nama = sql.getString("nama");
                jTextFieldNama.setText(nama);

            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_JTableKategoriMouseClicked

    private void jTextFieldIDKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDKategoriActionPerformed

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

    private void bt_UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UploadActionPerformed
        JFileChooser filechooser = new JFileChooser();

        int i = filechooser.showOpenDialog(null);
        if (i == JFileChooser.APPROVE_OPTION) {
            EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            entityManager.getTransaction().begin();

            File f = filechooser.getSelectedFile();
            String filepath = f.getPath();
            String fi = f.getName();
            //Parsing CSV Data
            System.out.print(filepath);
            DefaultTableModel csv_data = new DefaultTableModel();

            try {

                InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
                org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);
                for (CSVRecord csvRecord : csvParser) {

                    Kategori_1 k = new Kategori_1();
                    k.setIdKategori(csvRecord.get(0));
                    k.setNama(csvRecord.get(1));
                    entityManager.persist(k);

                }

            } catch (Exception ex) {
                System.out.println("Error in Parsing CSV File");
            }
            entityManager.getTransaction().commit();

        }
        
        tampil();
    }//GEN-LAST:event_bt_UploadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    String s = jTextFieldPencarian.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataidKategori(s);
                break;
            case 1:
                getdatanama(s);
                break;

        }
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTableKategori;
    private javax.swing.JButton bt_Edit;
    private javax.swing.JButton bt_Upload;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private javax.swing.JLabel jLabelIDKategori;
    private javax.swing.JLabel jLabelNamaKategori;
    private javax.swing.JPanel jPanelDataBuku;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldIDKategori;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JTextField jTextFieldPencarian;
    private javax.swing.JLabel txt_judul;
    private javax.swing.JLabel txt_menu1;
    // End of variables declaration//GEN-END:variables

    private void ambildata() {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT k FROM Kategori_1 k");
        List<Kategori_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableKategori.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Kategori_1 k : list) {
            Object[] ob = new Object[2];
            ob[0] = k.getIdKategori();
            ob[1] = k.getNama();
            tbl.addRow(ob);
            i++;
        }
    }
    
    void getdataidKategori(String idKategori) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT k FROM Kategori_1 k WHERE LOWER(k.idKategori) LIKE :idKategori");
        query.setParameter("idKategori", "%" + idKategori.toLowerCase() + "%");
        List<Kategori_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableKategori.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Kategori_1 k : list) {
            Object[] ob = new Object[2];
            ob[0] = k.getIdKategori();
            ob[1] = k.getNama();
            tbl.addRow(ob);
            i++;
        }
    }
    
    void getdatanama(String namaKategori) {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("SELECT k FROM Kategori_1 k WHERE LOWER(k.nama) LIKE :nama");
        query.setParameter("nama", "%" + namaKategori.toLowerCase() + "%");
        List<Kategori_1> list = query.getResultList();
        em.getTransaction().commit();
        em.close();
        DefaultTableModel tbl = (DefaultTableModel) JTableKategori.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Kategori_1 k : list) {
            Object[] ob = new Object[2];
            ob[0] = k.getIdKategori();
            ob[1] = k.getNama();
            tbl.addRow(ob);
            i++;
        }
    }
    
    

    }



