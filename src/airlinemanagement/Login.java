/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlinemanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class Login extends javax.swing.JFrame {

    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public Login() {
        super ("Login");
        initComponents();
        conn = connectDB.myconnection();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BackgroundPanal = new javax.swing.JPanel();
        UserNameLabel = new javax.swing.JLabel();
        PasswordLabel = new javax.swing.JLabel();
        loginuser = new javax.swing.JTextField();
        loginpass = new javax.swing.JPasswordField();
        signupbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        loginClose = new javax.swing.JLabel();
        LoginBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BackgroundPanal.setBackground(new java.awt.Color(255, 255, 255,80));
        BackgroundPanal.setForeground(new java.awt.Color(255, 255, 255));

        UserNameLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        UserNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserNameLabel.setText("Email:");

        PasswordLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        PasswordLabel.setForeground(new java.awt.Color(255, 255, 255));
        PasswordLabel.setText("Password:");

        loginpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginpassActionPerformed(evt);
            }
        });

        signupbtn.setBackground(new java.awt.Color(204, 204, 204));
        signupbtn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        signupbtn.setText("Sign Up");
        signupbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                signupbtnMouseClicked(evt);
            }
        });
        signupbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("AIRWAZE Airlines Ticketing System");

        loginClose.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        loginClose.setForeground(new java.awt.Color(204, 204, 204));
        loginClose.setText("X");
        loginClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginCloseMouseClicked(evt);
            }
        });

        LoginBtn.setBackground(new java.awt.Color(204, 204, 204));
        LoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        LoginBtn.setText("Login");
        LoginBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LoginBtnMouseClicked(evt);
            }
        });
        LoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginBtnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Create account?");

        javax.swing.GroupLayout BackgroundPanalLayout = new javax.swing.GroupLayout(BackgroundPanal);
        BackgroundPanal.setLayout(BackgroundPanalLayout);
        BackgroundPanalLayout.setHorizontalGroup(
            BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanalLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanalLayout.createSequentialGroup()
                        .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UserNameLabel)
                            .addComponent(PasswordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(loginuser, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(loginpass))
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(signupbtn)
                        .addGap(225, 225, 225))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanalLayout.createSequentialGroup()
                        .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BackgroundPanalLayout.createSequentialGroup()
                        .addComponent(loginClose)
                        .addGap(19, 19, 19))))
        );
        BackgroundPanalLayout.setVerticalGroup(
            BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundPanalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(loginClose)
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginuser, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UserNameLabel))
                .addGap(39, 39, 39)
                .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginpass, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PasswordLabel))
                .addGap(44, 44, 44)
                .addComponent(LoginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(BackgroundPanalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(38, 38, 38))
        );

        getContentPane().add(BackgroundPanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 500));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airlinemanagement/1.jpg"))); // NOI18N
        jLabel3.setPreferredSize(new java.awt.Dimension(754, 545));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 760, 560));

        setSize(new java.awt.Dimension(770, 562));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_signupbtnMouseClicked
        
    }//GEN-LAST:event_signupbtnMouseClicked

    private void loginCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginCloseMouseClicked
        System.exit(0);
    }//GEN-LAST:event_loginCloseMouseClicked

    private void LoginBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LoginBtnMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LoginBtnMouseClicked

    private void signupbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupbtnActionPerformed
        setVisible(false);
        SignUp ob=new SignUp();
        ob.setVisible(true);
    }//GEN-LAST:event_signupbtnActionPerformed

    private void LoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginBtnActionPerformed
        String sql = "Select * from users where email = ? and password = ?";
        String admins = "admin";
        String UN = loginuser.getText();
        String ANS = loginpass.getText();
        try{
            if (UN.equalsIgnoreCase(admins) && ANS.equalsIgnoreCase(admins)){
                setVisible(false);
                dashboard ob = new dashboard();
                ob.setVisible(true);
                return;
            }
            pst = conn.prepareStatement(sql);
            pst.setString(1,loginuser.getText());
            pst.setString(2,loginpass.getText());
            rs = pst.executeQuery();
            if (rs.next()){
                Integer userID = rs.getInt("user_id");
                UserSession.setUserID(userID);
                rs.close();
                pst.close();
                
                setVisible(false);
                UserDashBoard ob = new UserDashBoard();
                ob.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            try{
                rs.close();
                pst.close();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_LoginBtnActionPerformed

    private void loginpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginpassActionPerformed

    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel BackgroundPanal;
    private javax.swing.JButton LoginBtn;
    private javax.swing.JLabel PasswordLabel;
    private javax.swing.JLabel UserNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel loginClose;
    private javax.swing.JPasswordField loginpass;
    private javax.swing.JTextField loginuser;
    private javax.swing.JButton signupbtn;
    // End of variables declaration//GEN-END:variables
}
