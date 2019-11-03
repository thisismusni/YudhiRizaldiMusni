package PBO_I_172055;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tugas_6_172055 extends javax.swing.JFrame {

    public Tugas_6_172055() 
    {
        initComponents();
        bersih();
        fungsienable();
        fungsikalender();
    }
    
    void bersih()
    {
        txtNim.requestFocus();
        txtNim.setText("");
        txtNama.setText("");
        txtJurusan.setText("");
        txtTtl.setText("");
        cmbTgl.setSelectedItem("Tanggal");
        cmbBln.setSelectedItem("Bulan");
        cmbThn.setSelectedItem("Tahun");
        txtUmur.setText("");
    }
    
    void fungsienable()
    {
        txtJurusan.setEnabled(false);
        txtUmur.setEnabled(false);
    }
    
    void fungsikalender()
    {
        int j=1,q=1,k=1970,as=2019;
        
        cmbTgl.removeAllItems();
        cmbTgl.addItem("Tanggal");
        for(;j<=31;j++)
        {
            cmbTgl.addItem(j);
        }
        
        cmbBln.removeAllItems();
        cmbBln.addItem("Bulan");
        for(;q<=12;q++)
        {
            cmbBln.addItem(q);
        }
        
        cmbThn.removeAllItems();
        cmbThn.addItem("Tahun");
        for(;k<=as;k++)
        {
            cmbThn.addItem(k);
        }
    }
    
    void fungsijurusan()
    {
        String nim = txtNim.getText();
        String prodi = nim.substring(2,3);
        
        switch(prodi)
        {
            case"1":txtJurusan.setText("Sistem Informasi");break;
            case"2":txtJurusan.setText("Teknik Informatika");break;
            case"3":txtJurusan.setText("Manajemen Informatika");break;
            default:txtJurusan.setText("tidak ada jurusan");
        }
        
        txtNama.requestFocus();
    }
    
    void fungsiumur() 
    {
        long umur=0;
        
        try {
            
            int tglLahir = (int) cmbTgl.getSelectedItem();
            int blnLahir = (int) cmbBln.getSelectedItem();
            int thnLahir = (int) cmbThn.getSelectedItem();
            Date datenow = new Date();
            
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(datenow);
            int tglnow = calendar.get(Calendar.DATE);
            int blnnow = calendar.get(Calendar.MONTH);
            int thnnow = calendar.get(Calendar.YEAR);
            
            if (thnLahir <= thnnow)
            {
                if (blnLahir <= blnnow)
                {
                    if (tglLahir <= tglnow && blnLahir <= blnnow)
                    {
                        umur = thnnow-thnLahir;
                    }
                    else if (tglLahir >= tglnow && blnLahir >= blnnow)
                    {
                        umur = thnnow-thnLahir;
                    }
                    else if (tglLahir <= tglnow && blnLahir >= blnnow)
                    {
                        umur = thnnow-thnLahir;
                    }
                    else if (tglLahir >= tglnow && blnLahir <= blnnow)
                    {
                        umur = thnnow-thnLahir;
                    }
                    else
                    {
                        umur = thnnow-thnLahir-1;
                    }
                }
                else if (blnLahir >= blnnow)
                {
                    umur = thnnow-thnLahir-1;
                }
            }
        txtUmur.setText(String.valueOf(umur));
            
        } 
        catch (Exception e) {
            
        }
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblNim = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblJurusan = new javax.swing.JLabel();
        lblTtl = new javax.swing.JLabel();
        lblUmur = new javax.swing.JLabel();
        txtNim = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtJurusan = new javax.swing.JTextField();
        txtTtl = new javax.swing.JTextField();
        cmbTgl = new javax.swing.JComboBox();
        cmbBln = new javax.swing.JComboBox();
        cmbThn = new javax.swing.JComboBox();
        txtUmur = new javax.swing.JTextField();
        lblThn = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBiodata = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblNim.setText("NIM :");

        lblNama.setText("Nama :");

        lblJurusan.setText("Jurusan :");

        lblTtl.setText("TTL :");

        lblUmur.setText("Umur :");

        txtNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNimActionPerformed(evt);
            }
        });

        cmbTgl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTgl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbBln.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBln.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbThn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbThn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbThn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThnActionPerformed(evt);
            }
        });

        lblThn.setText("Tahun");

        btnTambah.setText("Tambah");
        btnTambah.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTambahMouseClicked(evt);
            }
        });
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnEdit.setText("Edit");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnKeluar.setText("Keluar");
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarMouseClicked(evt);
            }
        });

        tblBiodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Jurusan", "Tempat dan Tanggal Lahir", "Umur"
            }
        ));
        jScrollPane2.setViewportView(tblBiodata);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNim)
                                    .addComponent(lblNama))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJurusan)
                                    .addComponent(lblTtl)
                                    .addComponent(lblUmur))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnTambah)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnEdit)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnHapus)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnKeluar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTtl, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblThn))
                                            .addComponent(txtJurusan))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cmbBln, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbThn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNim)
                    .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJurusan)
                    .addComponent(txtJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTtl)
                    .addComponent(txtTtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUmur)
                    .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnEdit)
                    .addComponent(btnHapus)
                    .addComponent(btnKeluar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
        DefaultTableModel dataModel = (DefaultTableModel) tblBiodata.getModel();
        List list = new ArrayList<>();
       
        tblBiodata.setAutoCreateColumnsFromModel(true);
        list.add(txtNim.getText());
        list.add(txtNama.getText());
        list.add(txtJurusan.getText());
        list.add(txtTtl.getText()+"/"+cmbTgl.getSelectedItem()+"/"+cmbBln.getSelectedItem()+"/"+
                cmbThn.getSelectedItem());
        list.add(txtUmur.getText());
        dataModel.addRow(list.toArray());
        
        bersih();
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarMouseClicked
        int exit = JOptionPane.showConfirmDialog
        (null,"Yakin ingin keluar ?", "Tutup Aplikasi", JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) 
        {
            System.exit(0);
        }
    }//GEN-LAST:event_btnKeluarMouseClicked

    private void cmbThnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThnActionPerformed
        fungsiumur();
    }//GEN-LAST:event_cmbThnActionPerformed

    private void txtNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNimActionPerformed
        fungsijurusan();
    }//GEN-LAST:event_txtNimActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTambahActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Tugas_6_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tugas_6_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tugas_6_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tugas_6_172055.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tugas_6_172055().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox cmbBln;
    private javax.swing.JComboBox cmbTgl;
    private javax.swing.JComboBox cmbThn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblJurusan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNim;
    private javax.swing.JLabel lblThn;
    private javax.swing.JLabel lblTtl;
    private javax.swing.JLabel lblUmur;
    private javax.swing.JTable tblBiodata;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtTtl;
    private javax.swing.JTextField txtUmur;
    // End of variables declaration//GEN-END:variables
}
