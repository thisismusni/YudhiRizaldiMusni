package PBO_I_172055;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Tugas_7_FormLogin_172055 extends javax.swing.JFrame {

    String use, pas, user, pass, nma;
    int X, Y;
    
    public Tugas_7_FormLogin_172055() 
    {
        initComponents();
        setVisible(true);
        setTitle("Login");
        fungsiLayar();
    }
    
    void fungsiLogin()
    {
        try
        {
            user = txtUser.getText();
            pass = txtPass.getText();
            
            Statement stat = (Statement) koneksiDB.DCCkoneksi().createStatement();
            ResultSet res = stat.executeQuery("SELECT nama, usernamee, passwordd FROM "
                    + "admin_172055 WHERE usernamee='"+user+"' AND passwordd='"+pass+"'");
            
            while (res.next())
            {
                use = (res.getString("usernamee"));
                pas = (res.getString("passwordd"));
                nma = (res.getString("nama"));
            }

            if (!"".equals(user) && !"".equals(pass))
            {
                if(user.equals(use) && pass.equals(pas))
                {
                    new Tugas_7_FormUtama_172055(nma);
                    koneksiDB.nmaAdmin = nma;
                    setEnabled(false);
                    
                }
                else if (!user.equals(use) && pass.equals(pas))
                {
                    JOptionPane.showMessageDialog(null, "Username anda salah");
                    txtUser.setText("");
                    txtUser.requestFocus();
                }
                else if (user.equals(use) && !pass.equals(pas))
                {
                    JOptionPane.showMessageDialog(null, "Password anda salah");
                    txtPass.setText("");
                    txtPass.requestFocus();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Username dan Password anda salah");
                    txtUser.setText("");
                    txtPass.setText("");
                    txtUser.requestFocus();
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "masukkan username dan password anda");
                txtUser.requestFocus();
            }   
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    void fungsiLayar()
    {
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        X = layar.width / 2 - this.getSize().width / 2;
        Y = 100;
        this.setLocation(X, Y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbShowpass = new javax.swing.JCheckBox();
        txtPass = new javax.swing.JPasswordField();
        lblUser = new javax.swing.JLabel();
        lblPass = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnRegistrasi = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbShowpass.setText("Show");
        cbShowpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cbShowpass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbShowpassMouseClicked(evt);
            }
        });
        cbShowpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbShowpassActionPerformed(evt);
            }
        });
        cbShowpass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbShowpassKeyPressed(evt);
            }
        });

        txtPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPassKeyPressed(evt);
            }
        });

        lblUser.setText("Username");

        lblPass.setText("Password");

        txtUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUserKeyPressed(evt);
            }
        });

        btnLogin.setText("Login");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnExit.setText("Exit");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnRegistrasi.setText("Belum punya akun..?");
        btnRegistrasi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrasiMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblUser))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblPass))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cbShowpass)
                        .addComponent(txtUser)
                        .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(btnRegistrasi))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnLogin)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPass)
                .addGap(5, 5, 5)
                .addComponent(txtPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(cbShowpass)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin)
                    .addComponent(btnExit))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRegistrasi)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbShowpassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbShowpassMouseClicked

    }//GEN-LAST:event_cbShowpassMouseClicked

    private void cbShowpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbShowpassActionPerformed
        if(cbShowpass.isSelected())
        {
            txtPass.setEchoChar((char)0);
        }
        else
        {
            txtPass.setEchoChar('*');
        }
    }//GEN-LAST:event_cbShowpassActionPerformed

    private void cbShowpassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbShowpassKeyPressed
        if (evt.getKeyCode() ==KeyEvent.VK_ENTER)
        {
            fungsiLogin();
        }
    }//GEN-LAST:event_cbShowpassKeyPressed

    private void txtPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPassKeyPressed
        if (evt.getKeyCode() ==KeyEvent.VK_ENTER)
        {
            fungsiLogin();
        }
    }//GEN-LAST:event_txtPassKeyPressed

    private void txtUserKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUserKeyPressed
        if (evt.getKeyCode() ==KeyEvent.VK_ENTER)
        {
            fungsiLogin();
        }
    }//GEN-LAST:event_txtUserKeyPressed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        fungsiLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnRegistrasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrasiMouseClicked
        new Tugas_8_FormRAdmin_172055();
        dispose();
    }//GEN-LAST:event_btnRegistrasiMouseClicked

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
            java.util.logging.Logger.getLogger(Tugas_7_FormLogin_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas_7_FormLogin_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas_7_FormLogin_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas_7_FormLogin_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas_7_FormLogin_172055().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel btnRegistrasi;
    private javax.swing.JCheckBox cbShowpass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblPass;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
