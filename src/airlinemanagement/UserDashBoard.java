/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package airlinemanagement;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author MICHELLE
 */
public class UserDashBoard extends javax.swing.JFrame {
    

    /**
     * Creates new form UserDashBoard
     */
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Integer userID;
    public UserDashBoard() {
        super("Dashboard");
        initComponents();
        userID = UserSession.getUserID();
        conn = connectDB.myconnection();
        loadUserDetails();
        loadUserTickets();
        
    }
    private void loadUserDetails() {
    String userID = UserSession.getUserID().toString();

    try {
        String sql = "SELECT fname, passportID, contact, picture FROM users WHERE user_id = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, userID);
        rs = pst.executeQuery();

        if (rs.next()) {
            String name = rs.getString("fname");
            String passportID = rs.getString("passportID");
            String contact = rs.getString("contact");
            byte[] pictureBytes = rs.getBytes("picture");

            pname.setText(name);
            passportid.setText(passportID);
            ctpn.setText(contact);

            if (pictureBytes != null) {
                // Resize image before displaying
                ImageIcon imageIcon = new ImageIcon(pictureBytes);
                Image image = imageIcon.getImage();
                
                // Get dimensions of pictureID
                int width = pictureID.getWidth();
                int height = pictureID.getHeight();
                
                if (width > 0 && height > 0) {
                    Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
                    pictureID.setIcon(new ImageIcon(scaledImage));
                } else {
                    // Handle case where pictureID dimensions are not yet available
                    pictureID.setIcon(imageIcon);
                }
            } else {
                pictureID.setIcon(null); // Clear the picture if no image data is found
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error loading user details: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
        }
    }
}

private void loadUserTickets() {
        // Replace with your database connection details
        String url = "jdbc:mysql://localhost:3306/ams";
        String username = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            // Get the current logged-in user's ID
            int userID = UserSession.getUserID();

            // SQL query to fetch ticket details for the logged-in user
            String sql = "SELECT ticket_id, flightcode FROM tickets WHERE passenger_id = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, userID);
                try (ResultSet rs = pst.executeQuery()) {
                    // Create a DefaultTableModel to hold the data
                    DefaultTableModel model = new DefaultTableModel();
                    model.addColumn("Ticket ID");
                    model.addColumn("Flight Code");

                    // Populate the table model with data from the result set
                    while (rs.next()) {
                        Vector row = new Vector();
                        row.add(rs.getInt("ticket_id"));
                        row.add(rs.getString("flightcode"));
                        model.addRow(row);
                    }

                    // Set the table model to jTable3
                    jTable3.setModel(model);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Failed to load user tickets: " + e.getMessage());
            e.printStackTrace();
        }
    }
    public void viewTickets() {
    try {
        String sql = "SELECT ticket_id, name, flightcode, gender, passportnumber, amount, nationality FROM tickets WHERE passenger_id = ?";
        pst = conn.prepareStatement(sql);
        pst.setInt(1, userID);
        rs = pst.executeQuery();
        
        jTable2.setModel(DbUtils.resultSetToTableModel(rs)); // Update the table with tickets
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error fetching tickets: " + e.getMessage());
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
        }
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

        jPanel1 = new javax.swing.JPanel();
        logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pictureID = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        pname = new javax.swing.JTextField();
        passportid = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ctpn = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        bpic = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        origin = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        destination = new javax.swing.JComboBox<>();
        flightid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        boardingPassPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        ticketID = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153,80));

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        pictureID.setMaximumSize(new java.awt.Dimension(130, 0));
        pictureID.setMinimumSize(new java.awt.Dimension(110, 0));
        pictureID.setName(""); // NOI18N
        pictureID.setOpaque(true);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureID, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pictureID, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("NAME");

        pname.setEditable(false);
        pname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnameActionPerformed(evt);
            }
        });

        passportid.setEditable(false);
        passportid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passportidActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PASSPORT ID");

        ctpn.setEditable(false);
        ctpn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctpnActionPerformed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CONTACT NO.");

        bpic.setText("Browse Picture");
        bpic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bpicActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passportid, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ctpn, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bpic, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(bpic, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passportid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(32, 32, 32)
                .addComponent(ctpn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addComponent(logout)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("ORIGIN");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("DESTINATION");

        origin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manila", "Tokyo", "Cebu", "Riyadh", "Seoul", "Hong Kong", "Taipei", "Washington D.C.", "Las Vegas", "Dubai", " " }));
        origin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                originActionPerformed(evt);
            }
        });

        jButton4.setText("SEARCH FLIGHT");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Flight ID", "Origin", "Destination", "Available Seats", "Departure Date", "Cost"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jButton5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton5.setText("Book");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        destination.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manila", "Tokyo", "Cebu", "Riyadh", "Seoul", "Hong Kong", "Taipei", "Washington D.C.", "Las Vegas", "Dubai", " " }));

        flightid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flightidActionPerformed(evt);
            }
        });

        jLabel5.setText("Select Flight ID:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43)
                        .addComponent(jButton4)))
                .addGap(0, 25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(flightid, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(42, 42, 42))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(origin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destination, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(flightid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BOOK A FLIGHT", jPanel3);

        jButton1.setText("Generate Boarding Pass");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel6.setText("Enter Ticket ID:");

        ticketID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketIDActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Tickets"
            }
        ));
        jScrollPane1.setViewportView(jTable3);

        javax.swing.GroupLayout boardingPassPanelLayout = new javax.swing.GroupLayout(boardingPassPanel);
        boardingPassPanel.setLayout(boardingPassPanelLayout);
        boardingPassPanelLayout.setHorizontalGroup(
            boardingPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardingPassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boardingPassPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ticketID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(220, 220, 220))
            .addGroup(boardingPassPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        boardingPassPanelLayout.setVerticalGroup(
            boardingPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boardingPassPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(boardingPassPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ticketID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("BOARDING PASS", boardingPassPanel);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 500, 450));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255,80));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/airlinemanagement/1.jpg"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(754, 545));
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -5, 740, 470));

        setSize(new java.awt.Dimension(754, 470));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    
    
    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        setVisible(false);
        Login ob=new Login();
        ob.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void pnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pnameActionPerformed

    private void passportidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passportidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passportidActionPerformed

    private void ctpnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctpnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ctpnActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String flightOrigin = origin.getSelectedItem().toString();
    String flightDestination = destination.getSelectedItem().toString();

    try {
        // Specify columns with aliases in your SQL query
        String sql = "SELECT flightID AS 'Flight ID', source AS 'Origin', destination AS 'Destination', "
                   + "noofseat AS 'Available Seats', takeoff AS 'Departure Date', cost AS 'Cost' "
                   + "FROM manageflight WHERE source = ? AND destination = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, flightOrigin);
        pst.setString(2, flightDestination);
        rs = pst.executeQuery();

        // Set the model for jTable2
        jTable2.setModel(DbUtils.resultSetToTableModel(rs));
        
        // Optionally, adjust column widths or other jTable2 settings as needed
        // jTable2.getColumnModel().getColumn(index).setPreferredWidth(width);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       String passengerName = pname.getText().trim();
    String flightCode = flightid.getText().trim();

    if (passengerName.isEmpty() || flightCode.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Flight ID is required!");
        return;
    }

    try {
        // Prepare SQL query to find user details
        String sqlUser = "SELECT * FROM users WHERE fname = ?";
        PreparedStatement pstUser = conn.prepareStatement(sqlUser);
        pstUser.setString(1, passengerName);
        ResultSet rsUser = pstUser.executeQuery();
        
        if (rsUser.next()) {
            int passengerId = rsUser.getInt("user_id");
            String passportNumber = rsUser.getString("passportID");

            // Prepare SQL query to find flight details in manageflight table
            String sqlFlight = "SELECT * FROM manageflight WHERE flightID = ?";
            PreparedStatement pstFlight = conn.prepareStatement(sqlFlight);
            pstFlight.setString(1, flightCode);
            ResultSet rsFlight = pstFlight.executeQuery();

            if (rsFlight.next()) {
                int flightId = rsFlight.getInt("flightID");
                String origin = rsFlight.getString("source");
                String destination = rsFlight.getString("destination");
                BigDecimal cost = rsFlight.getBigDecimal("cost");
                int currentAvailableSeats = rsFlight.getInt("noofseat");
                String manageFlightCode = rsFlight.getString("flightcode");

                // Display flight details and confirm booking
                int option = JOptionPane.showConfirmDialog(this,
                        "Confirm booking:\n\n" +
                        "Passenger Name: " + passengerName + "\n" +
                        "Flight Code: " + manageFlightCode + "\n" +
                        "Country: " + rsUser.getString("country") + "\n" +
                        "Passport ID: " + passportNumber + "\n" +
                        "Cost: PHP" + cost + "\n" +
                        "Origin: " + origin + "\n" +
                        "Destination: " + destination + "\n\n" +
                        "Do you want to proceed with booking this flight?",
                        "Confirm Booking",
                        JOptionPane.YES_NO_OPTION);

                if (option == JOptionPane.YES_OPTION) {
                    // Check if there are available seats
                    if (currentAvailableSeats > 0) {
                        // Decrement available seats by 1
                        int newAvailableSeats = currentAvailableSeats - 1;

                        // Update available seats in the database
                        String updateSeatsSQL = "UPDATE manageflight SET noofseat = ? WHERE flightID = ?";
                        PreparedStatement pstUpdateSeats = conn.prepareStatement(updateSeatsSQL);
                        pstUpdateSeats.setInt(1, newAvailableSeats);
                        pstUpdateSeats.setInt(2, flightId);
                        pstUpdateSeats.executeUpdate();

                        // Proceed with booking by inserting ticket details
                        String sqlInsertTicket = "INSERT INTO tickets (passenger_id, name, flightcode, gender, passportnumber, amount, nationality, bpass) " +
                                                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement pstInsertTicket = conn.prepareStatement(sqlInsertTicket, Statement.RETURN_GENERATED_KEYS);
                        pstInsertTicket.setInt(1, passengerId);
                        pstInsertTicket.setString(2, passengerName);
                        pstInsertTicket.setString(3, manageFlightCode); // Use flightcode from manageflight table
                        pstInsertTicket.setString(4, rsUser.getString("gender"));
                        pstInsertTicket.setString(5, passportNumber);
                        pstInsertTicket.setBigDecimal(6, cost);
                        pstInsertTicket.setString(7, rsUser.getString("country"));
                        pstInsertTicket.setInt(8, flightId);

                        int rowsAffected = pstInsertTicket.executeUpdate();

                        if (rowsAffected > 0) {
                            // Get generated ticket ID
                            ResultSet generatedKeys = pstInsertTicket.getGeneratedKeys();
                            if (generatedKeys.next()) {
                                int ticketId = generatedKeys.getInt(1);
                                JOptionPane.showMessageDialog(this,
                                        "Ticket booked successfully!\n\n" +
                                        "Ticket ID: " + ticketId + "\n" +
                                        "Passenger Name: " + passengerName + "\n" +
                                        "Flight Code: " + manageFlightCode + "\n" +
                                        "Country: " + rsUser.getString("country") + "\n" +
                                        "Passport ID: " + passportNumber + "\n" +
                                        "Cost: PHP" + cost + "\n" +
                                        "Origin: " + origin + "\n" +
                                        "Destination: " + destination);
                                        loadUserTickets();
                            } else {
                                JOptionPane.showMessageDialog(this, "Error: Ticket ID not generated!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Error: Failed to book ticket!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No available seats for this flight.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Booking cancelled.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Flight with code " + flightCode + " not found in manageflight table!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Passenger with name " + passengerName + " not found!");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "SQL Error: " + e.getMessage());
    }
    
    }//GEN-LAST:event_jButton5ActionPerformed

    private void originActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_originActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_originActionPerformed

    private void flightidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flightidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_flightidActionPerformed

    private void bpicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bpicActionPerformed
           // TODO add your handling code here:
           browseAndUploadPicture();
    }//GEN-LAST:event_bpicActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String tkt = ticketID.getText().trim();

    // Hide the current window
        setVisible(false);

    // Create a new instance of BoardingPass and pass the ticket ID
        BoardingPass ob = new BoardingPass(tkt);
        ob.setVisible(true);
    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ticketIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ticketIDActionPerformed
    
    private int getUserID() {
        loadUserDetails();
    return 1;
    }
    private void browseAndUploadPicture() {
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    int result = fileChooser.showOpenDialog(this);
    
    if (result == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        
        // Upload selected picture file to database
        uploadPictureToDatabase(selectedFile);
        
        // Display the uploaded picture in your UI (assuming you have a JLabel named pictureID)
        displayPicture(selectedFile);
    }
    }
     public void uploadPictureToDatabase(File file) {
        FileInputStream fis = null;
        try {
            // Replace with your database URL, username, and password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");

            // Resize image to desired dimensions (e.g., 130x110 pixels)
            int targetWidth = 130;
            int targetHeight = 110;
            BufferedImage originalImage = ImageIO.read(file);
            Image resizedImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
            BufferedImage bufferedResizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
            bufferedResizedImage.getGraphics().drawImage(resizedImage, 0, 0, null);

            // Prepare image data for database update
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedResizedImage, "jpg", baos);
            InputStream is = new ByteArrayInputStream(baos.toByteArray());

            // Update database with prepared statement
            String sql = "UPDATE users SET picture = ? WHERE user_id = ?";
            pst = conn.prepareStatement(sql);
            pst.setBinaryStream(1, is, baos.size());
            pst.setInt(2, userID); // Replace with the actual userID of the logged-in user

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Picture uploaded successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to upload picture. No rows updated.");
            }
        } catch (HeadlessException | IOException | SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Failed to upload picture.");
        } finally {
            try {
                if (fis != null) fis.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private void displayPicture(File file) {
    try {
        // Create ImageIcon from file
        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());

        // Get Image from ImageIcon
        Image image = imageIcon.getImage();

        // Check if pictureID has valid dimensions
        int width = pictureID.getWidth();
        int height = pictureID.getHeight();

        if (width > 0 && height > 0) {
            // Scale the image to fit pictureID
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            pictureID.setIcon(new ImageIcon(scaledImage));
        } else {
            // If dimensions are invalid, show error message
            JOptionPane.showMessageDialog(this, "Invalid picture size.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Failed to display picture.");
    }
}



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
            java.util.logging.Logger.getLogger(UserDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserDashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         File imageFile = new File("path_to_your_image.jpg");
         int userID = 1;
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel boardingPassPanel;
    private javax.swing.JButton bpic;
    private javax.swing.JTextField ctpn;
    private javax.swing.JComboBox<String> destination;
    private javax.swing.JTextField flightid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JButton logout;
    private javax.swing.JComboBox<String> origin;
    private javax.swing.JTextField passportid;
    private javax.swing.JLabel pictureID;
    private javax.swing.JTextField pname;
    private javax.swing.JTextField ticketID;
    // End of variables declaration//GEN-END:variables
private int getAvailableSeats(int flightId) throws SQLException {
    String sql = "SELECT noofseat FROM manageflight WHERE flightID = ?";
    PreparedStatement pst = conn.prepareStatement(sql);
    pst.setInt(1, flightId);
    ResultSet rs = pst.executeQuery();

    if (rs.next()) {
        return rs.getInt("noofseat");
    }
    return 0; // Return 0 if no record found (though it should not happen ideally)
}

}
