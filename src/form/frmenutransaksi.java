/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author zulfa
 */
public class frmenutransaksi extends javax.swing.JFrame {
    private DefaultTableModel model = null;
    private PreparedStatement stat;
    private ResultSet rs;
    koneksi k = new koneksi();
    /**
     * Creates new form frmenu
     */
    public frmenutransaksi() {
        initComponents();
        k.connect();
        refreshTable();
        refreshCombo();
    }
    
    class transaksi extends frmenutransaksi{
        int id_transaksi, id_menu, harga, jumlah_beli, total_bayar;
        String nama_pelanggan, tanggal, nama_menu;

        public transaksi() {
            this.nama_pelanggan = txtnmpelanggan.getText();
            String combo = cbidmasakan.getSelectedItem().toString();
            String[] arr = combo.split(":");
            this.id_menu = Integer.parseInt(arr[0]);
            try {
                Date date = text_tanggal.getDate();
                DateFormat dateformat = new SimpleDateFormat("YYYY-MM-dd");
                this.tanggal = dateformat.format(date);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            this.nama_menu = arr[1];
            this.harga = Integer.parseInt(arr[2]);
            this.jumlah_beli = Integer.parseInt(txtjmlbeli.getText());
            this.total_bayar = this.harga * this.jumlah_beli;            
        }        
    }
    
    public void refreshTable(){
        model = new DefaultTableModel();
        model.addColumn("ID Transaksi");
        model.addColumn("Nama Pelanggan");
        model.addColumn("ID Menu");
        model.addColumn("Tanggal");
        model.addColumn("Nama Masakan");
        model.addColumn("Harga");
        model.addColumn("Jumlah Beli");
        model.addColumn("Total Bayar");
        tbtransaksi.setModel(model);
        try {
            this.stat = k.getCon().prepareStatement("select * from transaksi");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                Object[] data={
                  rs.getString(1),
                  rs.getString(2),
                  rs.getString(3),
                  rs.getString(4),
                  rs.getString(5),
                  rs.getString(6),
                  rs.getString(7),
                  rs.getString(8),
                };
                model.addRow(data);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        txtidtransaksi.setText("");
        txtnmpelanggan.setText("");
        txtjmlbeli.setText("");
        txttotalbayar.setText("");
    }
    
    public void refreshCombo(){
        try {
            this.stat = k.getCon().prepareStatement("select * from menu "
                    + "where status='tersedia'");
            this.rs = this.stat.executeQuery();
            while (rs.next()) {                
                cbidmasakan.addItem(rs.getString("id_menu")+":"+
                rs.getString("nama_menu")+":"+rs.getString("harga"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtidtransaksi = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        bttrinput = new javax.swing.JButton();
        bttrdel = new javax.swing.JButton();
        bttrcetaklaporan = new javax.swing.JButton();
        bttrupdate = new javax.swing.JButton();
        btlogout = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbtransaksi = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        txtnmpelanggan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtjmlbeli = new javax.swing.JTextField();
        cbidmasakan = new javax.swing.JComboBox<>();
        btlihatmenu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txttotalbayar = new javax.swing.JTextField();
        text_tanggal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU TRANSAKSI");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("ID Transaksi");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Jumlah Beli");

        txtidtransaksi.setEnabled(false);
        txtidtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidtransaksiActionPerformed(evt);
            }
        });

        bttrinput.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttrinput.setText("INPUT");
        bttrinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrinputActionPerformed(evt);
            }
        });

        bttrdel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttrdel.setText("DELETE");
        bttrdel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrdelActionPerformed(evt);
            }
        });

        bttrcetaklaporan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttrcetaklaporan.setText("CETAK LAPORAN");
        bttrcetaklaporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrcetaklaporanActionPerformed(evt);
            }
        });

        bttrupdate.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        bttrupdate.setText("UPDATE");
        bttrupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttrupdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(bttrinput, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttrupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bttrdel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bttrcetaklaporan)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bttrcetaklaporan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(bttrinput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttrdel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttrupdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        btlogout.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btlogout.setText("LOG OUT");
        btlogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlogoutActionPerformed(evt);
            }
        });

        tbtransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbtransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbtransaksiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbtransaksi);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Nama Pelanggan");

        txtnmpelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnmpelangganActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("ID Masakan");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Tanggal");

        txtjmlbeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtjmlbeliActionPerformed(evt);
            }
        });

        btlihatmenu.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        btlihatmenu.setText("LIHAT MENU");
        btlihatmenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btlihatmenuActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Total Bayar");

        txttotalbayar.setEnabled(false);
        txttotalbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalbayarActionPerformed(evt);
            }
        });

        text_tanggal.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtidtransaksi))
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnmpelanggan))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(txttotalbayar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbidmasakan, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btlihatmenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtjmlbeli))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btlogout, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(txtidtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                    .addComponent(txtnmpelanggan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btlihatmenu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbidmasakan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                    .addComponent(text_tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtjmlbeli, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttotalbayar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(402, 402, 402))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidtransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidtransaksiActionPerformed

    private void txtnmpelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnmpelangganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnmpelangganActionPerformed

    private void btlihatmenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlihatmenuActionPerformed
        frmenumasakan menu = new frmenumasakan();
        menu.setVisible(true);
        this.setVisible(false);
        menu.btdelete.setEnabled(true);
        menu.btinput.setEnabled(true);
        menu.btupdate.setEnabled(true);
        menu.btmenutransaksi.setEnabled(true);
    }//GEN-LAST:event_btlihatmenuActionPerformed

    private void bttrdelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrdelActionPerformed
        try {
            transaksi tran = new transaksi();
            tran.id_transaksi = Integer.parseInt(txtidtransaksi.getText()); 
            this.stat = k.getCon().prepareStatement("delete from transaksi "
                    + "where id_transaksi=?");
            this.stat.setInt(1, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bttrdelActionPerformed

    private void txtjmlbeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtjmlbeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtjmlbeliActionPerformed

    private void txttotalbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalbayarActionPerformed

    private void btlogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btlogoutActionPerformed
        // TODO add your handling code here:
        frlogin u1 = new frlogin();
        u1.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btlogoutActionPerformed

    private void bttrupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrupdateActionPerformed
        try {
            transaksi tran = new transaksi();
            tran.id_transaksi = Integer.parseInt(txtidtransaksi.getText());
            this.stat = k.getCon().prepareStatement("update transaksi set nama_pelanggan=?,"
                    + "id_menu=?,tanggal=?,nama_menu=?,harga=?,jumlah_beli=?,total_bayar=? "
                    + "where id_transaksi=?");
            this.stat.setString(1, tran.nama_pelanggan);
            this.stat.setInt(2, tran.id_menu);
            this.stat.setString(3, tran.tanggal);
            this.stat.setString(4, tran.nama_menu);
            this.stat.setInt(5, tran.harga);
            this.stat.setInt(6, tran.jumlah_beli);
            this.stat.setInt(7, tran.total_bayar);
            this.stat.setInt(8, tran.id_transaksi);
            this.stat.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bttrupdateActionPerformed

    private void bttrinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrinputActionPerformed
        try {
            transaksi tran = new transaksi();
            txttotalbayar.setText(""+tran.total_bayar);
            this.stat = k.getCon().prepareStatement("insert into transaksi values(?,?,?,?,?,?,?,?)");
            this.stat.setInt(1, 0);
            this.stat.setString(2, tran.nama_pelanggan);
            this.stat.setInt(3, tran.id_menu);
            this.stat.setString(4, tran.tanggal);
            this.stat.setString(5, tran.nama_menu);
            this.stat.setInt(6, tran.harga);
            this.stat.setInt(7, tran.jumlah_beli);
            this.stat.setInt(8, tran.total_bayar);
            int pilihan = JOptionPane.showConfirmDialog(null,
                    "Tanggal: "+tran.tanggal+
                    "\nNama Pelanggan: "+tran.nama_pelanggan+
                    "\nPembelian: "+tran.jumlah_beli+" "+tran.nama_menu+
                    "\nTotal Bayar: "+tran.total_bayar+"\n",
                    "Tambahkan Transaksi?",
                    JOptionPane.YES_NO_OPTION);
            if (pilihan == JOptionPane.YES_OPTION) {
                this.stat.executeUpdate();
                refreshTable();
            } else if(pilihan == JOptionPane.NO_OPTION){
                refreshTable();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_bttrinputActionPerformed

    private void tbtransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbtransaksiMouseClicked
        txtidtransaksi.setText(model.getValueAt(tbtransaksi.getSelectedRow(), 0).toString());
        txtnmpelanggan.setText(model.getValueAt(tbtransaksi.getSelectedRow(), 1).toString());
        txtjmlbeli.setText(model.getValueAt(tbtransaksi.getSelectedRow(), 6).toString());
        txttotalbayar.setText(model.getValueAt(tbtransaksi.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tbtransaksiMouseClicked

    private void bttrcetaklaporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttrcetaklaporanActionPerformed
        // TODO add your handling code here:
        try {
            File namafile = new File("src/laporan/laporan_transaksi.jasper");
            JasperPrint jp = JasperFillManager.fillReport(namafile.getPath(), null, k.getCon());
            JasperViewer.viewReport(jp,false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }//GEN-LAST:event_bttrcetaklaporanActionPerformed

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
            java.util.logging.Logger.getLogger(frmenutransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmenutransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmenutransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmenutransaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmenutransaksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btlihatmenu;
    private javax.swing.JButton btlogout;
    public javax.swing.JButton bttrcetaklaporan;
    private javax.swing.JButton bttrdel;
    public javax.swing.JButton bttrinput;
    private javax.swing.JButton bttrupdate;
    private javax.swing.JComboBox<String> cbidmasakan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbtransaksi;
    private com.toedter.calendar.JDateChooser text_tanggal;
    private javax.swing.JTextField txtidtransaksi;
    private javax.swing.JTextField txtjmlbeli;
    private javax.swing.JTextField txtnmpelanggan;
    private javax.swing.JTextField txttotalbayar;
    // End of variables declaration//GEN-END:variables
}
