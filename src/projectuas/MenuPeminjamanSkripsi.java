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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.AbstractQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.swing.DefaultComboBoxModel;
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
public class MenuPeminjamanSkripsi extends javax.swing.JPanel {

    ArrayList<Peminjamanskripsi_1> dataPeminjamanskripsi;

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
                skripsiJoin.get("judul").alias("judulSkripsi"),
                peminjamanRoot.get("tanggalPeminjaman"),
                peminjamanRoot.get("tanggalPengembalian")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanSkripsi.getModel();
        tbl.setRowCount(0);
        for (Object[] row : results) {
            tbl.addRow(row);
        }

        em.close();
        emf.close();
    }

    private String idSkripsi;

    public MenuPeminjamanSkripsi() {
        try {

            dataPeminjamanskripsi = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();
            loadData();

        } catch (SQLException ex) {
            Logger.getLogger(MenuPeminjamanSkripsi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void bersih() {
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
        jScrollPane2 = new javax.swing.JScrollPane();
        JTablePeminjamanSkripsi = new javax.swing.JTable();
        jTextFieldPencarian = new javax.swing.JTextField();
        txt_menu1 = new javax.swing.JLabel();
        icon_buku1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextNIM = new javax.swing.JTextField();
        jTextNama = new javax.swing.JTextField();
        jTextProdi = new javax.swing.JTextField();
        jTextAngkatan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jComboJudulSkripsi = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextIDPeminjaman = new javax.swing.JTextField();
        jDateChooserPinjam = new com.toedter.calendar.JDateChooser();
        jDateChooserKembali = new com.toedter.calendar.JDateChooser();

        setLayout(new java.awt.CardLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new java.awt.CardLayout());

        jPanelDataBuku.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDataBuku.setPreferredSize(new java.awt.Dimension(1076, 646));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Data Peminjaman Skripsi SIBoox");

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

        jScrollPane2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane2MouseClicked(evt);
            }
        });

        JTablePeminjamanSkripsi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Peminjaman", "NIM Peminjam", "Nama Lengkap", "Prodi", "Angkatan", "ID Skripsi", "Judul Skripsi", "Tanggal Peminjaman", "Tanggal Pengembalian"
            }
        ));
        JTablePeminjamanSkripsi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTablePeminjamanSkripsiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(JTablePeminjamanSkripsi);

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
        txt_menu1.setText("Home > Peminjaman > Skripsi");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pinjam10.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Angkatan", "NIM Peminjam", " " }));

        jLabel1.setText("NIM Peminjam");

        jLabel2.setText("Nama Lengkap");

        jLabel3.setText("Prodi");

        jLabel4.setText("Angkatan");

        jTextAngkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextAngkatanActionPerformed(evt);
            }
        });

        jLabel5.setText("Judul Skripsi");

        jLabel8.setText("Tanggal Peminjaman");

        jLabel9.setText("Tanggal Pengembalian");

        jLabel10.setText("Id Peminjaman");

        jTextIDPeminjaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextIDPeminjamanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDataBukuLayout = new javax.swing.GroupLayout(jPanelDataBuku);
        jPanelDataBuku.setLayout(jPanelDataBukuLayout);
        jPanelDataBukuLayout.setHorizontalGroup(
            jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addComponent(img_logo)
                        .addGap(5, 5, 5)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addComponent(txt_judul)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 449, Short.MAX_VALUE)
                                .addComponent(icon_buku1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_menu1))
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextAngkatan, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                            .addComponent(jTextNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextProdi, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel10))
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextNIM)
                                            .addComponent(jTextIDPeminjaman))))
                                .addGap(78, 78, 78)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addGap(31, 31, 31)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jDateChooserPinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboJudulSkripsi, 0, 210, Short.MAX_VALUE)
                                    .addComponent(jDateChooserKembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(162, 240, Short.MAX_VALUE)))))
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
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jComboJudulSkripsi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jTextIDPeminjaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)))
                .addGap(18, 18, 18)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooserPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jDateChooserKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(171, 171, 171))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jTextNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextAngkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(23, 23, 23)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
        );

        jPanelMain.add(jPanelDataBuku, "card2");

        add(jPanelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed

        try {
            String idPeminjaman = jTextIDPeminjaman.getText().trim();
            String nim = jTextNIM.getText().trim();
            String nama = jTextNama.getText();
            String prodi = jTextProdi.getText();
            String angkatan = jTextAngkatan.getText();
            String judulSkripsi = jComboJudulSkripsi.getSelectedItem().toString(); // Ambil judul skripsi dari ComboBox

            // Mengambil tanggal dari jDateChooserPinjam
            Date tanggalPeminjamanDate = jDateChooserPinjam.getDate();
            java.sql.Date tanggalPeminjaman = null;
            if (tanggalPeminjamanDate != null) {
                tanggalPeminjaman = new java.sql.Date(tanggalPeminjamanDate.getTime());
            }

            // Mengambil tanggal dari jDateChooserKembali
            Date tanggalPengembalianDate = jDateChooserKembali.getDate();
            java.sql.Date tanggalPengembalian = null;
            if (tanggalPengembalianDate != null) {
                tanggalPengembalian = new java.sql.Date(tanggalPengembalianDate.getTime());
            }

            // awal persistence
            EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            entityManager.getTransaction().begin();

            // Query untuk mendapatkan data skripsi berdasarkan idSkripsi
            Query skripsiQuery = entityManager.createQuery("SELECT s FROM Skripsi_1 s WHERE s.judul = :judulSkripsi");
            skripsiQuery.setParameter("judulSkripsi", judulSkripsi);
            Skripsi_1 skripsi = (Skripsi_1) skripsiQuery.getSingleResult();

            // Membuat objek entitas Peminjaman_1
            Peminjamanskripsi_1 peminjamanskripsi = new Peminjamanskripsi_1();
            peminjamanskripsi.setIdPeminjaman(idPeminjaman);
            peminjamanskripsi.setNim(nim);
            peminjamanskripsi.setNama(nama);
            peminjamanskripsi.setProdi(prodi);
            peminjamanskripsi.setAngkatan(angkatan);
            peminjamanskripsi.setTanggalPeminjaman(tanggalPeminjaman);
            peminjamanskripsi.setTanggalPengembalian(tanggalPengembalian);

            // Set objek Buku_1 ke peminjaman
            Skripsi_1 judul = new Skripsi_1();
            judul.setIdSkripsi(idSkripsi);
            peminjamanskripsi.setIdSkripsi(judul);

            // Simpan peminjaman ke database
            entityManager.persist(peminjamanskripsi);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");

            // akhir persistence
            jTextIDPeminjaman.setText("");
            jTextNIM.setText("");
            jTextNama.setText("");
            jTextProdi.setText("");
            jTextAngkatan.setText("");
            jComboJudulSkripsi.setSelectedItem("Pilih Judul Skripsi");
            jDateChooserPinjam.setDate(null);
            jDateChooserKembali.setDate(null);

            tampil(); // Fungsi untuk refresh data pada tabel

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }

    }//GEN-LAST:event_bt_tambahActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed

        String idPeminjaman = jTextIDPeminjaman.getText().trim();

// Awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();

// Mencari data peminjaman berdasarkan idPeminjaman
        Peminjamanskripsi_1 peminjamanskripsi = entityManager.find(Peminjamanskripsi_1.class, idPeminjaman);

        if (peminjamanskripsi != null) {
            // Jika data peminjaman ditemukan, hapus data dari database
            entityManager.remove(peminjamanskripsi);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Data peminjaman berhasil dihapus.");
        } else {
            // Jika data peminjaman tidak ditemukan, tampilkan pesan kesalahan
            JOptionPane.showMessageDialog(null, "Data peminjaman dengan ID " + idPeminjaman + " tidak ditemukan.");
        }

// Akhir persistence
        jTextIDPeminjaman.setText("");
        jTextNIM.setText("");
        jTextNama.setText("");
        jTextProdi.setText("");
        jTextAngkatan.setText("");
        jComboJudulSkripsi.setSelectedItem("Pilih Judul Skripsi");
        jDateChooserPinjam.setDate(null);
        jDateChooserKembali.setDate(null);

// Refresh data setelah menghapus
        tampil();
    }//GEN-LAST:event_bt_hapusActionPerformed

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

    private void JTablePeminjamanSkripsiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTablePeminjamanSkripsiMouseClicked

        try {
            // Buat EntityManagerFactory sesuai dengan nama persistence unit Anda
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();

            int row = JTablePeminjamanSkripsi.getSelectedRow();
            String idPeminjaman = (JTablePeminjamanSkripsi.getModel().getValueAt(row, 0).toString());

            // Gunakan EntityManager untuk mengambil data dari database
            Peminjamanskripsi_1 peminjamanskripsi = em.find(Peminjamanskripsi_1.class, idPeminjaman);

            if (peminjamanskripsi != null) {
                // Set nilai-nilai yang diambil dari database ke JTextField
                jTextIDPeminjaman.setText(peminjamanskripsi.getIdPeminjaman());
                jTextNIM.setText(peminjamanskripsi.getNim());
                jTextNama.setText(peminjamanskripsi.getNama());
                jTextProdi.setText(peminjamanskripsi.getProdi());
                jTextAngkatan.setText(peminjamanskripsi.getAngkatan());

                // Dapatkan judul skripsi dari relasi
                String judulSkripsi = peminjamanskripsi.getIdSkripsi().getJudul();

                // Set nilai ComboBox judul skripsi
                jComboJudulSkripsi.setSelectedItem(judulSkripsi);

                // Set tanggal peminjaman
                Date tanggalPeminjamanDate = peminjamanskripsi.getTanggalPeminjaman();
                jDateChooserPinjam.setDate(tanggalPeminjamanDate);

                // Set tanggal pengembalian
                Date tanggalPengembalianDate = peminjamanskripsi.getTanggalPengembalian();
                jDateChooserKembali.setDate(tanggalPengembalianDate);

            }

            // Tutup EntityManager setelah digunakan
            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_JTablePeminjamanSkripsiMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String s = jTextFieldPencarian.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataangkatan(s);
                break;
                case 1:
                getdatanim(s);
                break;

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jScrollPane2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane2MouseClicked

    private void jTextAngkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextAngkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextAngkatanActionPerformed

    private void jTextIDPeminjamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextIDPeminjamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextIDPeminjamanActionPerformed

    private void getJudulSkripsi() {
        try {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Pilih Judul Skripsi");

            EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT s.judul FROM Skripsi_1 s");
            List<String> listIdSkripsi = query.getResultList();

            for (String judul : listIdSkripsi) {
                model.addElement(judul);
            }

            em.getTransaction().commit();
            em.close();

            jComboJudulSkripsi.setModel(model);
            jComboJudulSkripsi.addActionListener(e -> {
                int selectedIndex = jComboJudulSkripsi.getSelectedIndex();

                if (selectedIndex > 0) {
                    try {
                        EntityManager emSelect = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
                        emSelect.getTransaction().begin();

                        Query selectQuery = emSelect.createQuery("SELECT s.idSkripsi FROM Skripsi_1 s WHERE s.judul = :judulSkripsi");
                        selectQuery.setParameter("judulSkripsi", model.getElementAt(selectedIndex));
                        String idSkripsi = (String) selectQuery.getSingleResult();

                        emSelect.getTransaction().commit();
                        emSelect.close();

                        this.idSkripsi = idSkripsi;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable JTablePeminjamanSkripsi;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private javax.swing.JComboBox<String> jComboJudulSkripsi;
    private com.toedter.calendar.JDateChooser jDateChooserKembali;
    private com.toedter.calendar.JDateChooser jDateChooserPinjam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanelDataBuku;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextAngkatan;
    private javax.swing.JTextField jTextFieldPencarian;
    private javax.swing.JTextField jTextIDPeminjaman;
    private javax.swing.JTextField jTextNIM;
    private javax.swing.JTextField jTextNama;
    private javax.swing.JTextField jTextProdi;
    private javax.swing.JLabel txt_judul;
    private javax.swing.JLabel txt_menu1;
    // End of variables declaration//GEN-END:variables

    private void ambildata() {
        EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
        Root<Peminjamanskripsi_1> peminjamanskripsiRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanskripsiRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanskripsiRoot.get("idPeminjaman"),
                peminjamanskripsiRoot.get("nim"),
                peminjamanskripsiRoot.get("nama"),
                peminjamanskripsiRoot.get("prodi"),
                peminjamanskripsiRoot.get("angkatan"),
                skripsiJoin.get("idSkripsi"),
                skripsiJoin.get("judul").alias("judulSkripsi"),
                peminjamanskripsiRoot.get("tanggalPeminjaman"),
                peminjamanskripsiRoot.get("tanggalPengembalian")
        );

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanSkripsi.getModel();
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
        Root<Peminjamanskripsi_1> peminjamanskripsiRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanskripsiRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanskripsiRoot.get("idPeminjaman"),
                peminjamanskripsiRoot.get("nim"),
                peminjamanskripsiRoot.get("nama"),
                peminjamanskripsiRoot.get("prodi"),
                peminjamanskripsiRoot.get("angkatan"),
                skripsiJoin.get("isbn"),
                skripsiJoin.get("judul").alias("judulBuku"),
                peminjamanskripsiRoot.get("tanggalPeminjaman"),
                peminjamanskripsiRoot.get("tanggalPengembalian")
        );

        cq.where(cb.like(cb.lower(peminjamanskripsiRoot.get("angkatan")), "%" + angkatan.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanSkripsi.getModel();
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
        Root<Peminjamanskripsi_1> peminjamanskripsiRoot = cq.from(Peminjamanskripsi_1.class);
        Join<Peminjamanskripsi_1, Skripsi_1> skripsiJoin = peminjamanskripsiRoot.join("idSkripsi", JoinType.INNER); // Sesuaikan dengan nama atribut di entitas Peminjaman_1

        cq.multiselect(
                peminjamanskripsiRoot.get("idPeminjaman"),
                peminjamanskripsiRoot.get("nim"),
                peminjamanskripsiRoot.get("nama"),
                peminjamanskripsiRoot.get("prodi"),
                peminjamanskripsiRoot.get("angkatan"),
                skripsiJoin.get("isbn"),
                skripsiJoin.get("judul").alias("judulBuku"),
                peminjamanskripsiRoot.get("tanggalPeminjaman"),
                peminjamanskripsiRoot.get("tanggalPengembalian")
        );

        cq.where(cb.like(cb.lower(peminjamanskripsiRoot.get("nim")), "%" + nim.toLowerCase() + "%"));

        List<Object[]> results = em.createQuery(cq).getResultList();
        em.getTransaction().commit();
        em.close();

        DefaultTableModel tbl = (DefaultTableModel) JTablePeminjamanSkripsi.getModel();
        tbl.setRowCount(0);
        int i = 1;
        for (Object[] row : results) {
            tbl.addRow(row);
            i++;
        }
    }

    private void loadData() {
        getJudulSkripsi();
    }

}
