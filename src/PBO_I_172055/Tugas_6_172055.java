package PBO_I_172055;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tugas_6_172055 extends javax.swing.JFrame {

    String nim, nama, jur, t4Lhr, tgl, bln, thn, tglLahirr, hp, alamat, jkl, sql;
    int X, Y, jk;
    Date datenow = new Date();
    DefaultTableModel tbl;
    
    public Tugas_6_172055() 
    {
        initComponents();
        setVisible(true);
        setTitle("Form Mahasiswa");
        fungsiLayar();
        bersih();
        fungsienable();
        fungsikalender();
        dataTable();
    }
    
    void bersih()
    {
        txtNim.requestFocus();
        txtNim.setText("");
        txtNama.setText("");
        txtJurusan.setText("");
        rbLakiLaki.setSelected(false);
        rbPerempuan.setSelected(false);
        txtTtl.setText("");
        cmbTgl.setSelectedItem("Tanggal");
        cmbBln.setSelectedItem("Bulan");
        cmbThn.setSelectedItem("Tahun");
        txtUmur.setText("");
        txtNoHp.setText("");
        txtAlamat.setText("");
        
        btnTambah.setVisible(true);
        btnKeluar.setVisible(true);
        fungsienable();
    }
    
    void fungsienable()
    {
        txtJurusan.setEnabled(false);
        txtUmur.setEnabled(false);
        btnEdit.setVisible(false);
        btnHapus.setVisible(false);
    }
    
    void fungsikalender()
    {
//        Date datenow = new Date();
        Calendar kalender = Calendar.getInstance();
        kalender.setTime(datenow);

        int J = 1, Q = 1, K = 1970, AS = kalender.get(Calendar.YEAR);
        
        cmbTgl.removeAllItems();
        cmbTgl.addItem("Tanggal");
        for(;J<=31;J++)
        {
            if (J<10)
                cmbTgl.addItem("0"+String.valueOf(J));
            else
                cmbTgl.addItem(String.valueOf(J));
        }
        
        cmbBln.removeAllItems();
        cmbBln.addItem("Bulan");
        for(;Q<=12;Q++)
        {
            if (Q<10)
                cmbBln.addItem("0"+String.valueOf(Q));
            else
                cmbBln.addItem(String.valueOf(Q));
        }
        
        cmbThn.removeAllItems();
        cmbThn.addItem("Tahun");
        for(;K<=AS;K++)
        {
            cmbThn.addItem(String.valueOf(K));
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
    
    private void fungsiumur()
    {
        long umur=0;
        
        
        try {
            int tglLahir = (int) cmbTgl.getSelectedItem();
            int blnLahir = (int) cmbBln.getSelectedItem();
            int thnLahir = (int) cmbThn.getSelectedItem();
            
            
            Calendar kalender = Calendar.getInstance();
            kalender.setTime(datenow);
            int tglnow = kalender.get(Calendar.DATE);
            int blnnow = kalender.get(Calendar.MONTH);
            int thnnow = kalender.get(Calendar.YEAR);
            
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
        catch (Exception e) 
        {
//            JOptionPane.showMessageDialog(null, "apanya "+e.toString());
        }
//        JOptionPane.showMessageDialog(null, tglLahir);
    }
    
    void fungsiLayar()
    {
        Dimension layar = Toolkit.getDefaultToolkit().getScreenSize();
        X = layar.width / 2 - this.getSize().width / 2;
        Y = 100;
        this.setLocation(X, Y);
    }
    
    private void dataTable()
    {
        tbl = new DefaultTableModel();
        tbl.addColumn("NIM");
        tbl.addColumn("Nama");
        tbl.addColumn("Jurusan");
        tbl.addColumn("Tempat_Lahir");
        tbl.addColumn("Tanggal_Lahir");
        tbl.addColumn("Alamat");
        tbl.addColumn("Telephone");
        tbl.addColumn("Jenis_Kelamin");
        tblBiodata.setModel(tbl);
        
        try 
        {
            Statement stat = (Statement) koneksiDB.DCCkoneksi().createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM mhs_172055 ORDER BY id DESC");
            
            while (res.next())
            {
                tbl.addRow(new Object[]
                {
                    res.getString("NIM"),
                    res.getString("Nama"),
                    res.getString("Jurusan"),
                    res.getString("Tempat_Lahir"),
                    res.getString("Tanggal_Lahir"),
                    res.getString("Alamat"),
                    res.getString("Telephone"),
                    res.getString("Jenis_Kelamin"),
                });
                tblBiodata.setModel(tbl);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Gagal"+e.toString());
        }
    }
    
    void fungsiGetData()
    {
        nim = txtNim.getText();
        nama = txtNama.getText();
        jur = txtJurusan.getText();

        t4Lhr = txtTtl.getText();
        tgl = String.valueOf(cmbTgl.getSelectedItem());
        bln = String.valueOf(cmbBln.getSelectedItem());
        thn = String.valueOf(cmbThn.getSelectedItem());
        tglLahirr = thn+"-"+bln+"-"+tgl;
        hp = txtNoHp.getText();
        alamat = txtAlamat.getText();
    }
    
    public void fungsiquery() throws SQLException
    {
        Statement stat;
        stat = (Statement) koneksiDB.DCCkoneksi().createStatement();
        stat.execute(sql);
        stat.close();
    }
    
    void fungsiremove()
    {
        while (tblBiodata.getRowCount()>0)
        {
            tbl.removeRow(0);
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
        txtUmur = new javax.swing.JTextField();
        lblThn = new javax.swing.JLabel();
        btnTambah = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblBiodata = new javax.swing.JTable();
        cmbClear = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtNoHp = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rbLakiLaki = new javax.swing.JRadioButton();
        rbPerempuan = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAlamat = new javax.swing.JTextArea();
        txtSearch = new javax.swing.JTextField();
        cmbThn = new javax.swing.JComboBox();

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

        lblNim.setText("NIM");

        lblNama.setText("Nama");

        lblJurusan.setText("Jurusan");

        lblTtl.setText("TTL");

        lblUmur.setText("Umur");

        txtNim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNimActionPerformed(evt);
            }
        });

        cmbTgl.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTgl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cmbBln.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbBln.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKeluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKeluarMouseClicked(evt);
            }
        });
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        tblBiodata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIM", "Nama", "Jurusan", "Tempat dan Tanggal Lahir", "Umur"
            }
        ));
        tblBiodata.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBiodataMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblBiodata);

        cmbClear.setText("Clear");
        cmbClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClearActionPerformed(evt);
            }
        });

        jLabel1.setText("No.HP");

        jLabel2.setText("Alamat");

        jLabel3.setText("Jenis Kelamin");

        rbLakiLaki.setText("Laki-Laki");
        rbLakiLaki.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbLakiLaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbLakiLakiActionPerformed(evt);
            }
        });

        rbPerempuan.setText("Perempuan");
        rbPerempuan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        rbPerempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPerempuanActionPerformed(evt);
            }
        });

        txtAlamat.setColumns(20);
        txtAlamat.setRows(5);
        jScrollPane3.setViewportView(txtAlamat);

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        cmbThn.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbThn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cmbThn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbThnActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTtl)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(rbLakiLaki)
                                .addGap(18, 18, 18)
                                .addComponent(rbPerempuan))
                            .addComponent(lblUmur)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNim)
                                    .addComponent(lblNama)
                                    .addComponent(lblJurusan)
                                    .addComponent(jLabel1))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtNama, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(txtNim, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtJurusan)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(54, 54, 54)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblThn))
                                            .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtTtl, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cmbBln, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cmbThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addGap(0, 11, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rbLakiLaki)
                    .addComponent(rbPerempuan))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTtl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbTgl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTtl)
                    .addComponent(cmbThn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUmur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblUmur))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoHp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTambahMouseClicked
//        DefaultTableModel dataModel = (DefaultTableModel) tblBiodata.getModel();
//        List list = new ArrayList<>();
//       
//        tblBiodata.setAutoCreateColumnsFromModel(true);
//        list.add(txtNim.getText());
//        list.add(txtNama.getText());
//        list.add(txtJurusan.getText());
//        list.add(txtTtl.getText()+"/"+cmbTgl.getSelectedItem()+"/"+cmbBln.getSelectedItem()+"/"+
//                cmbThn.getSelectedItem());
//        list.add(txtUmur.getText());
//        dataModel.addRow(list.toArray());
        fungsiGetData();
        
        if (!nim.equals("") && !nama.equals("") && !jur.equals("") && !t4Lhr.equals("") 
                && !tgl.equals("") && !bln.equals("") && !thn.equals("") && !hp.equals("") 
                && !alamat.equals(""))
        {
            try 
            {
                sql = "INSERT INTO mhs_172055 SET NIM='"+nim+"', Nama='"+nama+"',"
                    + " Jurusan='"+jur+"', Tempat_Lahir='"+t4Lhr+"', Tanggal_Lahir='"+tglLahirr+"', "
                    + " Alamat='"+alamat+"', Telephone='"+hp+"', Jenis_Kelamin='"+jk+"'";
                fungsiquery();
                
                JOptionPane.showMessageDialog(null, "Success ");
            }
            catch (SQLException e) 
            {
                JOptionPane.showMessageDialog(null, "Form Biodata Mahasiswa Belum Lengkap "+e.getMessage());
            }
            dataTable();
            bersih();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Form Biodata Mahasiswa Belum Lengkap");
        }
    }//GEN-LAST:event_btnTambahMouseClicked

    private void btnKeluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKeluarMouseClicked
        bersih();
        dispose();
    }//GEN-LAST:event_btnKeluarMouseClicked

    private void txtNimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNimActionPerformed
        fungsijurusan();
    }//GEN-LAST:event_txtNimActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        
    }//GEN-LAST:event_btnTambahActionPerformed

    private void cmbClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClearActionPerformed
        bersih();
    }//GEN-LAST:event_cmbClearActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
//        DefaultTableModel model = (DefaultTableModel) tblBiodata.getModel();
//        try {
//            int IndexRow = tblBiodata.getSelectedRow();
//            model.removeRow(IndexRow);
//            bersih();
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, "Pilih Data");
//        }

        nim = txtNim.getText();
        nama = txtNama.getText();
        
        try 
        {
            sql = ("DELETE FROM mhs_172055 WHERE NIM='"+nim+"'");
            fungsiquery();
            
            JOptionPane.showMessageDialog(null, "Succesfully Deleted ");
        }
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Failed to Deleted ");
        }
        dataTable();
        bersih();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void rbLakiLakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbLakiLakiActionPerformed
        if (rbLakiLaki.isSelected())
        {
            jk = 1;
            rbPerempuan.setSelected(false);
        }
    }//GEN-LAST:event_rbLakiLakiActionPerformed

    private void rbPerempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPerempuanActionPerformed
        if (rbPerempuan.isSelected())
        {
            jk = 0;
            rbLakiLaki.setSelected(false);
        }
    }//GEN-LAST:event_rbPerempuanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (btnEdit.getText() == "btnEdit")
        {
            txtNim.requestFocus();
        }
        else
        {
            fungsiGetData();
            
            try 
            {
                sql = ("UPDATE mhs_172055 SET Nama='"+nama+"',"
                    + " Jurusan='"+jur+"', Tempat_Lahir='"+t4Lhr+"', Tanggal_Lahir='"+tglLahirr+"', "
                    + " Alamat='"+alamat+"', Telephone='"+hp+"', Jenis_Kelamin='"+jk+"' WHERE NIM='"+nim+"'");
                fungsiquery();
                
                JOptionPane.showMessageDialog(null, "Update Success ");
            }
            catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, "Update Failed "+e.getMessage());
            }
            dataTable();
            bersih();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tblBiodataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBiodataMouseClicked
        btnEdit.setVisible(true);
        btnHapus.setVisible(true);
        btnTambah.setVisible(false);
        btnKeluar.setVisible(false);
        
        int row = tblBiodata.getSelectedRow();
        
        txtNim.setText(tblBiodata.getModel().getValueAt(row, 0).toString());
        txtNama.setText(tblBiodata.getModel().getValueAt(row, 1).toString());
        txtJurusan.setText(tblBiodata.getModel().getValueAt(row, 2).toString());
        txtTtl.setText(tblBiodata.getModel().getValueAt(row, 3).toString());
        
        String[] pecah = tblBiodata.getModel().getValueAt(row, 4).toString().split("-");
        cmbThn.setSelectedItem(pecah[0]);
        cmbBln.setSelectedItem(pecah[1]);
        cmbTgl.setSelectedItem(pecah[2]);
//        fungsiumur();
        
        txtAlamat.setText(tblBiodata.getModel().getValueAt(row, 5).toString());
        txtNoHp.setText(tblBiodata.getModel().getValueAt(row, 6).toString());
        jkl = (String) tblBiodata.getModel().getValueAt(row, 7);
        jk = Integer.parseInt(jkl);
            if (jk==1)
            {
                rbLakiLaki.setSelected(true);
                rbPerempuan.setSelected(false);
            }
            else if (jk==0)
            {
                rbPerempuan.setSelected(true);
                rbLakiLaki.setSelected(false);
            }
    }//GEN-LAST:event_tblBiodataMouseClicked

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String sc = txtSearch.getText().trim();
        fungsiremove();
        
        tbl = new DefaultTableModel();
        tbl.addColumn("NIM");
        tbl.addColumn("Nama");
        tbl.addColumn("Jurusan");
        tbl.addColumn("Tempat_Lahir");
        tbl.addColumn("Tanggal_Lahir");
        tbl.addColumn("Alamat");
        tbl.addColumn("Telephone");
        tbl.addColumn("Jenis_Kelamin");
        tblBiodata.setModel(tbl);
        
        try 
        {
            Statement stat = (Statement) koneksiDB.DCCkoneksi().createStatement();
            ResultSet res = stat.executeQuery("SELECT * FROM mhs_172055 WHERE nama LIKE '"+sc+"%'");
            
            while (res.next())
            {
                tbl.addRow(new Object[]
                {
                    res.getString("NIM"),
                    res.getString("Nama"),
                    res.getString("Jurusan"),
                    res.getString("Tempat_Lahir"),
                    res.getString("Tanggal_Lahir"),
                    res.getString("Alamat"),
                    res.getString("Telephone"),
                    res.getString("Jenis_Kelamin"),
                });
                tblBiodata.setModel(tbl);
            }
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Gagal"+e.toString());
        }
        
    }//GEN-LAST:event_txtSearchKeyReleased

    private void cmbThnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbThnActionPerformed
        try {
            fungsiumur();
        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_cmbThnActionPerformed

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
    private javax.swing.JButton cmbClear;
    private javax.swing.JComboBox cmbTgl;
    private javax.swing.JComboBox cmbThn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblJurusan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNim;
    private javax.swing.JLabel lblThn;
    private javax.swing.JLabel lblTtl;
    private javax.swing.JLabel lblUmur;
    private javax.swing.JRadioButton rbLakiLaki;
    private javax.swing.JRadioButton rbPerempuan;
    private javax.swing.JTable tblBiodata;
    private javax.swing.JTextArea txtAlamat;
    private javax.swing.JTextField txtJurusan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNim;
    private javax.swing.JTextField txtNoHp;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTtl;
    private javax.swing.JTextField txtUmur;
    // End of variables declaration//GEN-END:variables
}
