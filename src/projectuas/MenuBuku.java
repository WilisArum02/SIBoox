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
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
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
public class MenuBuku extends javax.swing.JPanel {

    ArrayList<Buku_1> dataBuku;

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

    private String idKategori;

    public MenuBuku() {
        try {

            dataBuku = new ArrayList<>();
            initComponents();
            ambildata();
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SIBoox", "postgres", "123");
            tampil();
            loadData();

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

        jPanelMain = new javax.swing.JPanel();
        jPanelDataBuku = new javax.swing.JPanel();
        img_logo = new javax.swing.JLabel();
        txt_judul = new javax.swing.JLabel();
        bt_tambah = new javax.swing.JButton();
        bt_hapus = new javax.swing.JButton();
        bt_Edit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        JTableBuku = new javax.swing.JTable();
        jTextFieldPencarian1 = new javax.swing.JTextField();
        txt_menu1 = new javax.swing.JLabel();
        icon_buku1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabelISBN = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabelJudul = new javax.swing.JLabel();
        jTextFieldJudul = new javax.swing.JTextField();
        jLabelKategori = new javax.swing.JLabel();
        jLabelPengarang = new javax.swing.JLabel();
        jTextFieldPengarang = new javax.swing.JTextField();
        jLabelPenerbit = new javax.swing.JLabel();
        jTextFieldPenerbit = new javax.swing.JTextField();
        jLabelTahun = new javax.swing.JLabel();
        jTextFieldTahun = new javax.swing.JTextField();
        jLabelJumlahHalaman = new javax.swing.JLabel();
        jTextFieldJumlahHalaman = new javax.swing.JTextField();
        bt_Upload = new javax.swing.JButton();
        jComboBoxPencarian = new javax.swing.JComboBox<>();
        jComboBoxKategori = new javax.swing.JComboBox<>();

        setLayout(new java.awt.CardLayout());

        jPanelMain.setBackground(new java.awt.Color(255, 255, 255));
        jPanelMain.setLayout(new java.awt.CardLayout());

        jPanelDataBuku.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDataBuku.setPreferredSize(new java.awt.Dimension(1076, 646));

        img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Logo_buku_1 (1).png"))); // NOI18N

        txt_judul.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_judul.setForeground(new java.awt.Color(0, 153, 255));
        txt_judul.setText("Data Buku SIBoox");

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

        txt_menu1.setForeground(new java.awt.Color(102, 102, 102));
        txt_menu1.setText("Home > Koleksi > Buku");

        icon_buku1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Book (1).png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 102));
        jButton1.setForeground(new java.awt.Color(0, 153, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Search.png"))); // NOI18N
        jButton1.setText("Cari");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelISBN.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelISBN.setText("ISBN");
        jLabelISBN.setToolTipText("");
        jLabelISBN.setPreferredSize(new java.awt.Dimension(29, 16));

        jTextFieldISBN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldISBNActionPerformed(evt);
            }
        });

        jLabelJudul.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelJudul.setText("Judul");

        jTextFieldJudul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJudulActionPerformed(evt);
            }
        });

        jLabelKategori.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelKategori.setText("Kategori");

        jLabelPengarang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelPengarang.setText("Pengarang");

        jTextFieldPengarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPengarangActionPerformed(evt);
            }
        });

        jLabelPenerbit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelPenerbit.setText("Penerbit");

        jTextFieldPenerbit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPenerbitActionPerformed(evt);
            }
        });

        jLabelTahun.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelTahun.setText("Tahun");

        jTextFieldTahun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTahunActionPerformed(evt);
            }
        });

        jLabelJumlahHalaman.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabelJumlahHalaman.setText("Jumlah Halaman");

        jTextFieldJumlahHalaman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJumlahHalamanActionPerformed(evt);
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

        jComboBoxPencarian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ISBN", "Judul", "Kategori", "Pengarang", "Penerbit", "Tahun", "Jumlah_Halaman" }));

        javax.swing.GroupLayout jPanelDataBukuLayout = new javax.swing.GroupLayout(jPanelDataBuku);
        jPanelDataBuku.setLayout(jPanelDataBukuLayout);
        jPanelDataBukuLayout.setHorizontalGroup(
            jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addComponent(img_logo)
                                .addGap(5, 5, 5)
                                .addComponent(txt_judul))
                            .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                    .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(67, 67, 67)
                                    .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jTextFieldJudul, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextFieldISBN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                                .addComponent(jLabelTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))
                                            .addComponent(jLabelJumlahHalaman, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldTahun, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldJumlahHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelPengarang, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31)
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jTextFieldPengarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBoxKategori, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(51, 51, 51)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addComponent(icon_buku1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_menu1))
                            .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBoxPencarian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDataBukuLayout.createSequentialGroup()
                                    .addComponent(jTextFieldPencarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(bt_hapus, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bt_Edit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bt_tambah, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bt_Upload, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addGap(114, 114, 114))
        );
        jPanelDataBukuLayout.setVerticalGroup(
            jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(img_logo, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_judul, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelKategori)
                            .addComponent(jComboBoxKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPengarang)
                            .addComponent(jLabelPengarang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldPenerbit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPenerbit))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldTahun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTahun))
                        .addGap(12, 12, 12)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldJumlahHalaman, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelJumlahHalaman))
                        .addGap(26, 26, 26))
                    .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addComponent(txt_menu1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(bt_tambah, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_Edit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_hapus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_Upload, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(icon_buku1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jComboBoxPencarian, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDataBukuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDataBukuLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jTextFieldPencarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );

        jPanelMain.add(jPanelDataBuku, "card2");

        add(jPanelMain, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void bt_UploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UploadActionPerformed

JFileChooser filechooser = new JFileChooser();

    int i = filechooser.showOpenDialog(null);
    if (i == JFileChooser.APPROVE_OPTION) {
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();

        File f = filechooser.getSelectedFile();
        String filepath = f.getPath();
        String fi = f.getName();

        //Parsing Data CSV
        System.out.print(filepath);
        DefaultTableModel csv_data = new DefaultTableModel();

        // Deklarasi bukuRoot
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Buku_1> criteriaQuery = criteriaBuilder.createQuery(Buku_1.class);
        Root<Buku_1> bukuRoot = criteriaQuery.from(Buku_1.class);

        try {
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filepath));
            org.apache.commons.csv.CSVParser csvParser = CSVFormat.DEFAULT.parse(inputStreamReader);

            for (CSVRecord csvRecord : csvParser) {
                Buku_1 b = new Buku_1();
                b.setIsbn(csvRecord.get(0));
                b.setJudul(csvRecord.get(1));
                b.setPengarang(csvRecord.get(3));
                b.setPenerbit(csvRecord.get(4));
                b.setTahun(csvRecord.get(5));
                b.setJumlahHalaman(csvRecord.get(6));

                // Menggunakan join dengan kategori
                String namaKategori = csvRecord.get(2);  // Ambil nama kategori dari CSV

                CriteriaQuery<Kategori_1> kategoriQuery = criteriaBuilder.createQuery(Kategori_1.class);
                Root<Kategori_1> kategoriRoot = kategoriQuery.from(Kategori_1.class);
                kategoriQuery.select(kategoriRoot);
                kategoriQuery.where(criteriaBuilder.equal(kategoriRoot.get("nama"), namaKategori));

                TypedQuery<Kategori_1> kategoriTypedQuery = entityManager.createQuery(kategoriQuery);
                Kategori_1 kategori = kategoriTypedQuery.getSingleResult();

                b.setIdKategori(kategori);  // Set ID Kategori pada Buku_1

                entityManager.persist(b);
            }

            // Commit hanya jika tidak ada exception
            entityManager.getTransaction().commit();

            // Menampilkan pesan sukses
            JOptionPane.showMessageDialog(null, "File berhasil diupload.");

            // Refresh data setelah mengunggah
            tampil();
        } catch (Exception ex) {
            // Menampilkan pesan gagal
            JOptionPane.showMessageDialog(null, "File gagal diupload. Error: " + ex.getMessage());

            // Rollback transaksi jika terjadi exception
            entityManager.getTransaction().rollback();

            ex.printStackTrace();
        }
    }
    
    }//GEN-LAST:event_bt_UploadActionPerformed

    private void jTextFieldJumlahHalamanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJumlahHalamanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJumlahHalamanActionPerformed

    private void jTextFieldTahunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTahunActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTahunActionPerformed

    private void jTextFieldPenerbitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPenerbitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPenerbitActionPerformed

    private void jTextFieldPengarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPengarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPengarangActionPerformed

    private void jTextFieldJudulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJudulActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJudulActionPerformed

    private void jTextFieldISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldISBNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldISBNActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = jTextFieldPencarian1.getText();
        switch (jComboBoxPencarian.getSelectedIndex()) {
            case 0:
                getdataisbn(s);
                break;
            case 1:
                getdatajudul(s);
                break;
            case 2:
                getdatakategori(s);
                break;
            case 3:
                getdatapengarang(s);
                break;
            case 4:
                getdatapenerbit(s);
                break;
            case 5:
                getdatatahun(s);
                break;
            case 6:
                getdatajumlahHalaman(s);
                break;

        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void JTableBukuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTableBukuMouseClicked
        try {
            // Buat EntityManagerFactory sesuai dengan nama persistence unit Anda
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
            EntityManager em = emf.createEntityManager();

            int row = JTableBuku.getSelectedRow();
            String tabel_klik = (JTableBuku.getModel().getValueAt(row, 0).toString());

            // Gunakan EntityManager untuk mengambil data dari database
            Buku_1 buku = em.find(Buku_1.class, tabel_klik);

            if (buku != null) {
                // Set nilai-nilai yang diambil dari database ke JTextField
                jTextFieldISBN.setText(buku.getIsbn());
                jTextFieldJudul.setText(buku.getJudul());
                jTextFieldPengarang.setText(buku.getPengarang());
                jTextFieldPenerbit.setText(buku.getPenerbit());
                jTextFieldTahun.setText(buku.getTahun());
                jTextFieldJumlahHalaman.setText(buku.getJumlah_halaman());

                // Dapatkan nama kategori dari relasi
                String namaKategori = buku.getId_kategori().getNama();

                // Set nilai ComboBox kategori
                jComboBoxKategori.setSelectedItem(namaKategori);
            }

            // Tutup EntityManager setelah digunakan
            em.close();
            emf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_JTableBukuMouseClicked

    private void bt_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_EditActionPerformed

        try {
            String isbn = jTextFieldISBN.getText().trim();
            String judul = jTextFieldJudul.getText();
            String namaKategori = jComboBoxKategori.getSelectedItem().toString(); // Ambil nama kategori dari combo box
            String pengarang = jTextFieldPengarang.getText();
            String penerbit = jTextFieldPenerbit.getText();
            String tahun = jTextFieldTahun.getText();
            String jumlah_halaman = jTextFieldJumlahHalaman.getText();

            // awal persistence
            EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            entityManager.getTransaction().begin();

            // Query untuk mendapatkan idKategori berdasarkan namaKategori
            Query kategoriQuery = entityManager.createQuery("SELECT k.idKategori FROM Kategori_1 k WHERE k.nama = :namaKategori");
            kategoriQuery.setParameter("namaKategori", namaKategori);

            try {
                String idKategori = (String) kategoriQuery.getSingleResult();

                // Mencari buku berdasarkan ISBN
                Buku_1 buku = entityManager.find(Buku_1.class, isbn);

                if (buku != null) {
                    // Set nilai atribut buku dengan nilai baru
                    buku.setJudul(judul);
                    buku.setPengarang(pengarang);
                    buku.setPenerbit(penerbit);
                    buku.setTahun(tahun);
                    buku.setJumlahHalaman(jumlah_halaman);

                    // Set objek Kategori_1 ke buku
                    Kategori_1 kategori = new Kategori_1();
                    kategori.setIdKategori(idKategori);
                    buku.setIdKategori(kategori);

                    // Commit perubahan
                    entityManager.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Data berhasil diedit.");
                } else {
                    JOptionPane.showMessageDialog(null, "Data dengan ISBN " + isbn + " tidak ditemukan.");
                }

            } catch (NoResultException e) {
                JOptionPane.showMessageDialog(null, "Kategori dengan nama " + namaKategori + " tidak ditemukan.");
            }

            // akhir persistence
            jTextFieldISBN.setText("");
            jTextFieldJudul.setText("");
            jComboBoxKategori.setSelectedItem("Pilih Kategori");
            jTextFieldPengarang.setText("");
            jTextFieldPenerbit.setText("");
            jTextFieldTahun.setText("");
            jTextFieldJumlahHalaman.setText("");
            
            tampil(); // Fungsi untuk refresh data pada tabel
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }
    }//GEN-LAST:event_bt_EditActionPerformed

    private void bt_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_hapusActionPerformed
        String isbn = jTextFieldISBN.getText().trim();

        // Awal persistence
        EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
        entityManager.getTransaction().begin();
        Buku_1 b = entityManager.find(Buku_1.class, isbn);

        if (b != null) {
            entityManager.remove(b);
            entityManager.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus.");
        } else {
            JOptionPane.showMessageDialog(null, "Data dengan ISBN " + isbn + " tidak ditemukan.");
        }

        // Akhir persistence
        jTextFieldISBN.setText("");
        jTextFieldJudul.setText("");
        jComboBoxKategori.setSelectedItem("Pilih Kategori");
        jTextFieldPengarang.setText("");
        jTextFieldPenerbit.setText("");
        jTextFieldTahun.setText("");
        jTextFieldJumlahHalaman.setText("");

        // Refresh data setelah menghapus
        tampil();
    }//GEN-LAST:event_bt_hapusActionPerformed

    private void bt_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tambahActionPerformed

        try {
            String isbn = jTextFieldISBN.getText().trim();
            String judul = jTextFieldJudul.getText();
            String namaKategori = jComboBoxKategori.getSelectedItem().toString(); // Ambil nama kategori dari ComboBox
            String pengarang = jTextFieldPengarang.getText();
            String penerbit = jTextFieldPenerbit.getText();
            String tahun = jTextFieldTahun.getText();
            String jumlah_halaman = jTextFieldJumlahHalaman.getText();

            // awal persistence
            EntityManager entityManager = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            entityManager.getTransaction().begin();

            // Query untuk mendapatkan idKategori berdasarkan namaKategori
            Query kategoriQuery = entityManager.createQuery("SELECT k.idKategori FROM Kategori_1 k WHERE k.nama = :namaKategori");
            kategoriQuery.setParameter("namaKategori", namaKategori);
            String idKategori = (String) kategoriQuery.getSingleResult();

            // Membuat objek entitas Buku_1
            Buku_1 buku = new Buku_1();
            buku.setIsbn(isbn);
            buku.setJudul(judul);
            buku.setPengarang(pengarang);
            buku.setPenerbit(penerbit);
            buku.setTahun(tahun);
            buku.setJumlahHalaman(jumlah_halaman);

            // Set objek Kategori_1 ke buku
            Kategori_1 kategori = new Kategori_1();
            kategori.setIdKategori(idKategori);
            buku.setIdKategori(kategori);

            // Simpan buku ke database
            entityManager.persist(buku);
            entityManager.getTransaction().commit();

            JOptionPane.showMessageDialog(null, "Data berhasil disimpan.");

            // akhir persistence
            jTextFieldISBN.setText("");
            jTextFieldJudul.setText("");
            jComboBoxKategori.setSelectedItem("Pilih Kategori");
            jTextFieldPengarang.setText("");
            jTextFieldPenerbit.setText("");
            jTextFieldTahun.setText("");
            jTextFieldJumlahHalaman.setText("");

            tampil(); // Fungsi untuk refresh data pada tabel

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + ex.getMessage());
        }

    }//GEN-LAST:event_bt_tambahActionPerformed

    private void getKategori() {

        try {
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
            model.addElement("Pilih Kategori");

            EntityManager em = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT k.nama FROM Kategori_1 k");
            List<String> listKategori = query.getResultList();

            for (String nama : listKategori) {
                model.addElement(nama);
            }

            em.getTransaction().commit();
            em.close();

            jComboBoxKategori.setModel(model);
            jComboBoxKategori.addActionListener(e -> {
                int selectedIndex = jComboBoxKategori.getSelectedIndex();

                if (selectedIndex > 0) {
                    try {
                        EntityManager emSelect = Persistence.createEntityManagerFactory("ProjectUASPU").createEntityManager();
                        emSelect.getTransaction().begin();

                        Query selectQuery = emSelect.createQuery("SELECT k.idKategori FROM Kategori_1 k WHERE k.nama = :namaKategori");
                        selectQuery.setParameter("namaKategori", model.getElementAt(selectedIndex));
                        String idKategori = (String) selectQuery.getSingleResult();

                        emSelect.getTransaction().commit();
                        emSelect.close();

                        this.idKategori = idKategori;
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
    private javax.swing.JTable JTableBuku;
    private javax.swing.JButton bt_Edit;
    private javax.swing.JButton bt_Upload;
    private javax.swing.JButton bt_hapus;
    private javax.swing.JButton bt_tambah;
    private javax.swing.JLabel icon_buku1;
    private javax.swing.JLabel img_logo;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxKategori;
    private javax.swing.JComboBox<String> jComboBoxPencarian;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelJudul;
    private javax.swing.JLabel jLabelJumlahHalaman;
    private javax.swing.JLabel jLabelKategori;
    private javax.swing.JLabel jLabelPenerbit;
    private javax.swing.JLabel jLabelPengarang;
    private javax.swing.JLabel jLabelTahun;
    private javax.swing.JPanel jPanelDataBuku;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldJudul;
    private javax.swing.JTextField jTextFieldJumlahHalaman;
    private javax.swing.JTextField jTextFieldPencarian1;
    private javax.swing.JTextField jTextFieldPenerbit;
    private javax.swing.JTextField jTextFieldPengarang;
    private javax.swing.JTextField jTextFieldTahun;
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

    void getdatakategori(String kategori) {
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

        cq.where(cb.like(cb.lower(kategoriJoin.get("nama")), "%" + kategori.toLowerCase() + "%"));

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

    private void loadData() {
        getKategori();
    }

}
