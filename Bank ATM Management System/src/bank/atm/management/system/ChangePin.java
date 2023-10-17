package bank.atm.management.system;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.DataBaseConnection;

public class ChangePin extends javax.swing.JFrame {

    DataBaseConnection con = new DataBaseConnection();

    PreparedStatement ps;
    ResultSet rs, rs1;
    String sql = "";

    private MainMenu mainMenu;

    public ChangePin(MainMenu mainMenu) {
        initComponents();
        this.mainMenu = mainMenu;
    }
    int MyAccNum;

    public ChangePin(int AccNum) {
        initComponents();
        MyAccNum = AccNum;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        newPin = new javax.swing.JTextField();
        newPin1 = new javax.swing.JTextField();
        btnChangePin = new javax.swing.JButton();
        btnBackChangePin = new javax.swing.JButton();
        Atm = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CHANGE YOUR PIN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, 260, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("New Pin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Re-Enter New Pin");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 30));
        jPanel1.add(newPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 160, 30));
        jPanel1.add(newPin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 160, 30));

        btnChangePin.setText("CHANGE");
        btnChangePin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChangePinMouseClicked(evt);
            }
        });
        jPanel1.add(btnChangePin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 140, 30));

        btnBackChangePin.setIcon(new javax.swing.ImageIcon("E:\\GitHub\\SecondPartJava\\Bank ATM Management System\\icon\\undo.png")); // NOI18N
        btnBackChangePin.setText("BACK");
        btnBackChangePin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBackChangePinMouseClicked(evt);
            }
        });
        jPanel1.add(btnBackChangePin, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 140, 30));

        Atm.setIcon(new javax.swing.ImageIcon("E:\\GitHub\\SecondPartJava\\Bank ATM Management System\\icon\\atm2.jpg")); // NOI18N
        jPanel1.add(Atm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 540));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackChangePinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackChangePinMouseClicked
        // TODO add your handling code here:
        dispose();
        mainMenu.setVisible(true);
    }//GEN-LAST:event_btnBackChangePinMouseClicked

    private void btnChangePinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChangePinMouseClicked
        // TODO add your handling code here:

        if (newPin.getText().isEmpty() || newPin1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Enter the Confim Pin");
        } else if (!newPin.getText().equals(newPin1.getText())) {
            JOptionPane.showMessageDialog(rootPane, "Pin 1 and Pin 2 are not equals");
        } else {
            String sql = "Update accountinfo set pin=? where accId=?";

            try {
                ps = con.getCon().prepareStatement(sql);
                ps.setInt(1, Integer.valueOf(newPin.getText()));
                ps.setInt(2, MyAccNum);

                if (ps.executeUpdate()==1) {
                    JOptionPane.showMessageDialog(rootPane, "Pin Updated Successful");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "NOT MATCH PASSWORD");

                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex);

                Logger.getLogger(Deposit.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }//GEN-LAST:event_btnChangePinMouseClicked

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
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                MainMenu mainMenu = new MainMenu();

                ChangePin changePin = new ChangePin(mainMenu);
                changePin.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Atm;
    private javax.swing.JButton btnBackChangePin;
    private javax.swing.JButton btnChangePin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField newPin;
    private javax.swing.JTextField newPin1;
    // End of variables declaration//GEN-END:variables
}
