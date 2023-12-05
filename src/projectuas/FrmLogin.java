/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectuas;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class FrmLogin extends javax.swing.JFrame {

    int xx, xy;

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();

    }

    void bersih() {
        jTextFieldUsername.setText("NIP/NIM");
        jPassword.setText("Username");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBg = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelIconPassword = new javax.swing.JLabel();
        jLabelIconUsename = new javax.swing.JLabel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jLabelLoginSIBoox = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPanelFooter = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        jPanelBg.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/0 Logo_Buku_Menu_Utama.png"))); // NOI18N
        jPanelBg.add(jLabelLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLabelIconPassword.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Password_1.png"))); // NOI18N
        jPanelBg.add(jLabelIconPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 20, 30));

        jLabelIconUsename.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Customer_1.png"))); // NOI18N
        jPanelBg.add(jLabelIconUsename, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 146, 20, 20));

        jTextFieldUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldUsername.setForeground(new java.awt.Color(0, 0, 102));
        jTextFieldUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldUsername.setText("NIP/NIM");
        jTextFieldUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        jTextFieldUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldUsernameFocusLost(evt);
            }
        });
        jTextFieldUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldUsernameActionPerformed(evt);
            }
        });
        jPanelBg.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, 190, 30));

        jPassword.setForeground(new java.awt.Color(0, 0, 102));
        jPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPassword.setText("Password");
        jPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFocusLost(evt);
            }
        });
        jPanelBg.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 190, 190, 30));

        jLabelLoginSIBoox.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelLoginSIBoox.setForeground(new java.awt.Color(0, 0, 102));
        jLabelLoginSIBoox.setText("LOGIN SIBOOX");
        jPanelBg.add(jLabelLoginSIBoox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 260, -1));

        jButtonLogin.setBackground(new java.awt.Color(0, 0, 102));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        jPanelBg.add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 190, 30));

        jPanelFooter.setBackground(new java.awt.Color(0, 0, 102));

        javax.swing.GroupLayout jPanelFooterLayout = new javax.swing.GroupLayout(jPanelFooter);
        jPanelFooter.setLayout(jPanelFooterLayout);
        jPanelFooterLayout.setHorizontalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
        );
        jPanelFooterLayout.setVerticalGroup(
            jPanelFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        jPanelBg.add(jPanelFooter, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, -1, -1));

        jPanelHeader.setBackground(new java.awt.Color(0, 0, 102));

        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Exit_1.png"))); // NOI18N
        jLabelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelHeaderLayout.createSequentialGroup()
                .addContainerGap(594, Short.MAX_VALUE)
                .addComponent(jLabelExit)
                .addContainerGap())
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addComponent(jLabelExit)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelBg.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void jTextFieldUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldUsernameActionPerformed

    private void jTextFieldUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusGained
        String username = jTextFieldUsername.getText();
        if (username.equals("NIP/NIM")) {
            jTextFieldUsername.setText("");
        }
    }//GEN-LAST:event_jTextFieldUsernameFocusGained

    private void jTextFieldUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldUsernameFocusLost
        String username = jTextFieldUsername.getText();
        if (username.equals("") || username.equals("NIP/NIM")) {
            jTextFieldUsername.setText("NIP/NIM");
        }
    }//GEN-LAST:event_jTextFieldUsernameFocusLost

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        String username = jTextFieldUsername.getText();
        String password = new String(jPassword.getPassword());

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectUASPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            // Assuming you have a User entity with attributes 'nomerinduk' and 'password'
            Query query = em.createQuery("SELECT l FROM Login_1 l WHERE l.nomerinduk = :nomerinduk AND l.password = :password");
            query.setParameter("nomerinduk", username);
            query.setParameter("password", password);

            List<Login_1> resultList = query.getResultList();
            
            if (!query.getResultList().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Berhasil Login");
                Login_1 loggedInUser = resultList.get(0);
                String nama = loggedInUser.getNama();
                String level = loggedInUser.getLevel();

                new FrmMenuUtama(nama, level).setVisible(true);
                this.dispose();

                kosongkan_form();
            } else {
                JOptionPane.showMessageDialog(this, "Login invalid, periksa username dan password Anda");

                kosongkan_form();
            }

            em.getTransaction().commit();
        } finally {
            em.close();
            emf.close();
        }

    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jLabelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelExitMouseClicked
        dispose();
    }//GEN-LAST:event_jLabelExitMouseClicked

    private void jPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusGained
        String password = jPassword.getText();
        if (password.equals("Password")) {
            jPassword.setText("");
        }
    }//GEN-LAST:event_jPasswordFocusGained

    private void jPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFocusLost
        String password = jPassword.getText();
        if (password.equals("") || password.equals("Password")) {
            jPassword.setText("Password");
        }
    }//GEN-LAST:event_jPasswordFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelIconPassword;
    private javax.swing.JLabel jLabelIconUsename;
    private javax.swing.JLabel jLabelLoginSIBoox;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelBg;
    private javax.swing.JPanel jPanelFooter;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void kosongkan_form() {
        jTextFieldUsername.setText("");
        jPassword.setText("");
    }
}
