/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package essai.VIEW;

import essai.Essai;
import essai.Model.User;
import essai.VIEW.UserPage;
import essai.VIEW.dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Omar Ghlila
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    Connection cnx;
    PreparedStatement pst;
    ResultSet rs;
   
    
    public Login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(850, 370));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Login");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 100, 70, 21);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 170, 90, 21);

        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextField1MousePressed(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(170, 100, 107, 30);

        jButton1.setBackground(new java.awt.Color(255, 204, 204));
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(60, 270, 80, 30);

        jButton2.setBackground(new java.awt.Color(255, 204, 204));
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(190, 270, 80, 30);

        jLabel4.setForeground(new java.awt.Color(255, 153, 0));
        getContentPane().add(jLabel4);
        jLabel4.setBounds(50, 210, 183, 30);

        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordField1MousePressed(evt);
            }
        });
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(170, 160, 107, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/essai/img/BG.png"))); // NOI18N
        jLabel6.setMaximumSize(new java.awt.Dimension(700, 474));
        jLabel6.setMinimumSize(new java.awt.Dimension(700, 474));
        jLabel6.setPreferredSize(new java.awt.Dimension(700, 474));
        getContentPane().add(jLabel6);
        jLabel6.setBounds(-40, 0, 890, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        String login = jTextField1.getText();
        String password = String.valueOf(jPasswordField1.getPassword());
        
        
        
        if(login.equals("")||password.equals("")){
            jLabel4.setText("Login or Password are Empty");
            
            
        }else {
            try{
                cnx= Essai.connecterDB();
                pst = cnx.prepareStatement("select * from user where login = ? and pwd =md5(?) ");
                
                pst.setString(1, login);
                pst.setString(2, password);
                
                rs= pst.executeQuery();
                
                if(rs.next()){
                    String s1= rs.getString("type");
                    String n = rs.getString("name");
                    String e = rs.getString("email");
                    String t = rs.getString("tel");
                    
                    
                    
                    if(s1.equalsIgnoreCase("Admin")){
                        System.out.println("admin");
                        dashboard ad = new dashboard(n,e,t);
                        ad.setVisible(true);
                        setVisible(false);
                    }
                    else if ( s1.equalsIgnoreCase("User")) {
                        System.out.println("user");
                        UserPage up = new UserPage(n);
                        up.setVisible(true);
                        setVisible(false);
                    }
                    else {
                        jLabel4.setText("Can't find user role");
                    }
                   
                    
                }
                 else{ 
                    System.out.println("error");
            jLabel4.setText("Login or Password are Wrong ");
        }
        }catch(Exception e){
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE,null,e);
        }
            
        }
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MousePressed
        // TODO add your handling code here:
        jLabel4.setVisible(false);
    }//GEN-LAST:event_jTextField1MousePressed

    private void jPasswordField1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MousePressed
        // TODO add your handling code here:
        jLabel4.setVisible(false);
    }//GEN-LAST:event_jPasswordField1MousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jTextField1.setText("");
        jPasswordField1.setText("");
        jLabel4.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
