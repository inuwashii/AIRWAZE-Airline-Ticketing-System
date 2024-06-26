/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlinemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class managepassenger extends javax.swing.JFrame {

    /**
     * Creates new form managepassenger
     */
    public managepassenger() {
        initComponents();
        setLocationRelativeTo(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pn = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        g = new javax.swing.JTextField();
        nationality = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        passID = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Passenger");

        jLabel2.setText("Passenger Name");

        jLabel3.setText("Email");

        jLabel4.setText("Password");

        jLabel5.setText("Gender");

        jLabel6.setText("Country");

        jLabel7.setText("<--BACK");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Passenger Name", "Email", "Password", "Gender", "Country", "PassportID", "Contact"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("INSERT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SEARCH");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("DELETE");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel8.setText("PassportID");

        jLabel9.setText("Contact");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(298, 298, 298))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(47, 47, 47)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(40, 40, 40)
                                .addComponent(jButton3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(passID, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(8, 8, 8))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jButton4)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
try {
    String passengerName = pn.getText().trim();  // Trim to remove leading/trailing whitespace
    String passengerEmail = email.getText().trim();
    String userPassword = password.getText().trim();
    String passportID = passID.getText().trim();
    String passengerContact = contact.getText().trim();
    String passengerCountry = nationality.getText().trim();
    String passengerGender = g.getText().trim();

    // Check if any required field is empty
    if (passengerName.isEmpty() || passengerEmail.isEmpty() || userPassword.isEmpty() ||
        passportID.isEmpty() || passengerContact.isEmpty() || passengerCountry.isEmpty() || passengerGender.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all fields");
        return; // Exit method if any field is empty
    }

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
    String sql = "INSERT INTO users (fname, email, password, passportID, contact, country, gender) VALUES (?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement ptst = con.prepareStatement(sql);
    ptst.setString(1, passengerName);
    ptst.setString(2, passengerEmail);
    ptst.setString(3, userPassword);
    ptst.setString(4, passportID);
    ptst.setString(5, passengerContact);
    ptst.setString(6, passengerCountry);
    ptst.setString(7, passengerGender);

    int rowsInserted = ptst.executeUpdate();
    if (rowsInserted > 0) {
        JOptionPane.showMessageDialog(this, "Data inserted successfully");
    } else {
        JOptionPane.showMessageDialog(this, "Failed to insert data");
    }

    con.close();
} catch (SQLException | ClassNotFoundException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    e.printStackTrace();
}

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
try {
    // Read input fields
    String name = pn.getText();
    String em = email.getText();
    String pass = password.getText();
    String gender = g.getText();
    String nat = nationality.getText();
    String phone = contact.getText();
    String passid = passID.getText();

    // Check if the email field is empty
    if (em.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Email field is empty. Update not performed.");
        return;
    }

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");

    // Check if the email exists in the database
    String checkEmailSql = "SELECT COUNT(*) FROM users WHERE email = ?";
    PreparedStatement checkEmailStmt = con.prepareStatement(checkEmailSql);
    checkEmailStmt.setString(1, em);
    ResultSet rs = checkEmailStmt.executeQuery();
    rs.next();
    int emailCount = rs.getInt(1);

    if (emailCount == 0) {
        // Email does not exist
        JOptionPane.showMessageDialog(this, "Email does not exist in the database. Update not performed.");
    } else {
        // Email exists, proceed with the update
        String updateSql = "UPDATE users SET fname = ?, country = ?, passportID = ?, contact = ?, password = ?, gender = ? WHERE email = ?";
        PreparedStatement updateStmt = con.prepareStatement(updateSql);
        updateStmt.setString(1, name);
        updateStmt.setString(2, nat);
        updateStmt.setString(3, passid);
        updateStmt.setString(4, phone);
        updateStmt.setString(5, pass);
        updateStmt.setString(6, gender);
        updateStmt.setString(7, em);

        int rowsUpdated = updateStmt.executeUpdate();

        if (rowsUpdated > 0) {
            JOptionPane.showMessageDialog(this, "Record Updated!");
        } else {
            JOptionPane.showMessageDialog(this, "Update failed. No rows affected.");
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, e);
}

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");
        
        // Read input fields
        String name=pn.getText();
        String em=email.getText();
        String pass=password.getText();
        String gender=g.getText();
        String nat=nationality.getText();
        String phone=contact.getText();
        String passid=passID.getText();
        
        // Construct the SQL query
        StringBuilder sql = new StringBuilder("SELECT * FROM users WHERE 1=1");
        
        if (!name.isEmpty()) {
            sql.append(" AND fname LIKE ?");
        }
        if (!gender.isEmpty()) {
            sql.append(" AND gender LIKE ?");
        }
        if (!nat.isEmpty()) {
            sql.append(" AND country LIKE ?");
        }
        if (!passid.isEmpty()) {
            sql.append(" AND passportID LIKE ?");
        }
        if (!phone.isEmpty()) {
            sql.append(" AND contact LIKE ?");
        }
        if (!em.isEmpty()) {
            sql.append(" AND email LIKE ?");
        }
        if (!pass.isEmpty()) {
            sql.append(" AND password LIKE ?");
        }
        
        PreparedStatement ptst = con.prepareStatement(sql.toString());
        
        // Set the parameters for the prepared statement
        int paramIndex = 1;
        if (!name.isEmpty()) {
        ptst.setString(paramIndex++, "%" + name + "%");
        }
        if (!gender.isEmpty()) {
        ptst.setString(paramIndex++, "%" + gender + "%");
        }
        if (!nat.isEmpty()) {
        ptst.setString(paramIndex++, "%" + nat + "%");
        }
        if (!passid.isEmpty()) {
        ptst.setString(paramIndex++, "%" + passid + "%");
        }
        if (!phone.isEmpty()) {
        ptst.setString(paramIndex++, "%" + phone + "%");
        }
        if (!em.isEmpty()) {
        ptst.setString(paramIndex++, "%" + em + "%");
        }
        if (!pass.isEmpty()) {
        ptst.setString(paramIndex++, "%" + pass + "%");
        }
        
        ResultSet rs = ptst.executeQuery();
        DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
        dt.setRowCount(0);
        while (rs.next()) {
            Object o[] = {rs.getString("fname"), rs.getString("email"), rs.getString("password"), rs.getString("gender"), rs.getString("country"), rs.getString("passportID"), rs.getString("contact")};
            dt.addRow(o);
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e);
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");

    String fname = pn.getText().trim(); // Trim whitespace from input
    if (fname.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please enter a Passenger Name");
        return; // Exit method if no Passenger Name is entered
    }

    String sql = "DELETE FROM users WHERE fname=?";
    PreparedStatement ptst = con.prepareStatement(sql);
    ptst.setString(1, fname);

    int rowsDeleted = ptst.executeUpdate();
    if (rowsDeleted > 0) {
        JOptionPane.showMessageDialog(this, "Data deleted successfully");
    } else {
        JOptionPane.showMessageDialog(this, "Passenger Name not found");
    }

    con.close();
} catch (SQLException | ClassNotFoundException e) {
    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    e.printStackTrace();
}


    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
dashboard obj=new dashboard();
obj.setVisible(true);
dispose();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(managepassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(managepassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(managepassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(managepassenger.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new managepassenger().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField contact;
    private javax.swing.JTextField email;
    private javax.swing.JTextField g;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nationality;
    private javax.swing.JTextField passID;
    private javax.swing.JTextField password;
    private javax.swing.JTextField pn;
    // End of variables declaration//GEN-END:variables
}
