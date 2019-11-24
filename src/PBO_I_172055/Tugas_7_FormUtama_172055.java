package PBO_I_172055;

import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Tugas_7_FormUtama_172055 extends javax.swing.JFrame {

    
    public Tugas_7_FormUtama_172055(String nma) throws SQLException {
        initComponents();
        setVisible(true);
        koneksiDB.DCCkoneksi();
        setTitle("Dashboard");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        lblAdmin.setText("Welcome to \n"+nma);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblAdmin = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mniLogin = new javax.swing.JMenuItem();
        mniLogout = new javax.swing.JMenuItem();
        mnMasterData = new javax.swing.JMenu();
        mniDataMhs = new javax.swing.JMenuItem();
        mnSearch = new javax.swing.JMenu();
        mnReport = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblAdmin.setText("Nama Admin");

        jTextField1.setText("jTextField1");

        mnFile.setText("File");

        mniLogin.setText("Login");
        mniLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLoginActionPerformed(evt);
            }
        });
        mnFile.add(mniLogin);

        mniLogout.setText("Logout");
        mniLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniLogoutActionPerformed(evt);
            }
        });
        mnFile.add(mniLogout);

        jMenuBar1.add(mnFile);

        mnMasterData.setText("Master Data");

        mniDataMhs.setText("Data Mahasiswa");
        mniDataMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mniDataMhsActionPerformed(evt);
            }
        });
        mnMasterData.add(mniDataMhs);

        jMenuBar1.add(mnMasterData);

        mnSearch.setText("Search");
        jMenuBar1.add(mnSearch);

        mnReport.setText("Report");
        jMenuBar1.add(mnReport);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblAdmin)
                .addContainerGap(298, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblAdmin)
                .addContainerGap(242, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mniDataMhsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniDataMhsActionPerformed
        new Tugas_6_172055();
    }//GEN-LAST:event_mniDataMhsActionPerformed

    private void mniLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLoginActionPerformed
        new Tugas_7_FormLogin_172055();
        setEnabled(false);
    }//GEN-LAST:event_mniLoginActionPerformed

    private void mniLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mniLogoutActionPerformed
        int exit = JOptionPane.showConfirmDialog
        (null,"Yakin ingin keluar ?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION)
        {
            new Tugas_7_FormLogin_172055();
            dispose();
        }
    }//GEN-LAST:event_mniLogoutActionPerformed

//    public static void main(String args[]) {
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Tugas_7_FormUtama_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Tugas_7_FormUtama_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Tugas_7_FormUtama_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Tugas_7_FormUtama_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                try {
//                    new Tugas_7_FormUtama_172055().setVisible(true);
//                } catch (SQLException ex) {
//                    Logger.getLogger(Tugas_7_FormUtama_172055.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblAdmin;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenu mnMasterData;
    private javax.swing.JMenu mnReport;
    private javax.swing.JMenu mnSearch;
    private javax.swing.JMenuItem mniDataMhs;
    private javax.swing.JMenuItem mniLogin;
    private javax.swing.JMenuItem mniLogout;
    // End of variables declaration//GEN-END:variables

    private void add(String label) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
