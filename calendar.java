/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alp_oop_try1;

import com.toedter.calendar.JCalendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;

public class calendar extends javax.swing.JFrame {

    /**
     * Creates new form calendar
     */
    static int user_id = -1;

    public calendar(int userId) {
        user_id = userId;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        lihatJumlahUang = new javax.swing.JButton();
        Kembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lihatJumlahUang.setText("Lihat");
        lihatJumlahUang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatJumlahUangActionPerformed(evt);
            }
        });

        Kembali.setText("Kembali");
        Kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(Kembali)
                        .addGap(110, 110, 110)
                        .addComponent(lihatJumlahUang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(174, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kembali)
                    .addComponent(lihatJumlahUang))
                .addContainerGap(107, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int getPemasukan() {
        initComponents();

        Date date = jCalendar1.getDate();
        System.out.println("date : " + date);
        String tgl = DateFormat.getDateInstance().format(date);
        String outputFormat = "yyyy-MM-dd";

        System.out.println("date : " + tgl);
        int val = 0;

        try {
            DateFormat inputDateFormat = new SimpleDateFormat("MMM d, yyyy");
            Date date1 = inputDateFormat.parse(tgl);

            DateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
            String formattedDate = outputDateFormat.format(date1);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/extrack", "root", "");
            Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT SUM(nominal) FROM history WHERE date = '" + formattedDate + "' AND keterangan = 'pemasukan';");
            while (data.next()) {
//                val = Integer.parseInt(data.getString("SUM(nominal)"));
                val = data.getInt("SUM(nominal)");

            }
            System.out.println("Val : " + val);
            return val;
        } catch (Exception e) {
            System.out.print("Error : ");
            e.printStackTrace();
        }
        return val;
    }

    public int getPengeluaran() {
        initComponents();

        Date date = jCalendar1.getDate();
        System.out.println("date : " + date);
        String tgl = DateFormat.getDateInstance().format(date);
        String outputFormat = "yyyy-MM-dd";

        System.out.println("date : " + tgl);
        int val = 0;

        try {
            DateFormat inputDateFormat = new SimpleDateFormat("MMM d, yyyy");
            Date date1 = inputDateFormat.parse(tgl);

            DateFormat outputDateFormat = new SimpleDateFormat(outputFormat);
            String formattedDate = outputDateFormat.format(date1);

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/extrack", "root", "");
            Statement stat = conn.createStatement();
            ResultSet data = stat.executeQuery("SELECT SUM(nominal) FROM history WHERE date = '" + formattedDate + "' AND keterangan = 'pengeluaran';");
            while (data.next()) {
//                val = Integer.parseInt(data.getString("SUM(nominal)"));
                val = data.getInt("SUM(nominal)");
            }
            System.out.println("Val : " + val);

            return val;
        } catch (Exception e) {
            System.out.print("Error : ");
            e.printStackTrace();
        }
        return val;
    }

    private void lihatJumlahUangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatJumlahUangActionPerformed
        JOptionPane.showMessageDialog(this, "Jumlah pemasukan : " + getPemasukan() + "\nJumlah pengeluaran : " + getPengeluaran());
        //nnt messagenya diganti jumlah uang di hari itu, diambil dari databasenya
    }//GEN-LAST:event_lihatJumlahUangActionPerformed

    private void KembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliActionPerformed
        // TODO add your handling code here:
        one o = new one(user_id);
        o.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_KembaliActionPerformed

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
            java.util.logging.Logger.getLogger(calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calendar(user_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Kembali;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JButton lihatJumlahUang;
    // End of variables declaration//GEN-END:variables
}