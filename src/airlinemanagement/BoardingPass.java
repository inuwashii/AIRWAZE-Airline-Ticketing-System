package airlinemanagement;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;

public class BoardingPass extends JFrame {

    JLabel tfPassengerName, tfPassportNumber, tfCountry, lblOrigin, lblDestination, lblBoardingPassID, lblTakeoffDate;
    JLabel backgroundLabel; // For background image
    private String ticketID; // Instance variable to store ticketID

    // Constructor accepting ticketID as a parameter
    public BoardingPass(String ticketID) {
        this.ticketID = ticketID; // Initialize ticketID
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        // Load background image
        ImageIcon backgroundImageIcon = new ImageIcon(getClass().getResource("bpass.jpg"));
        Image backgroundImage = backgroundImageIcon.getImage().getScaledInstance(1000, 300, Image.SCALE_DEFAULT);
        ImageIcon scaledBackgroundImageIcon = new ImageIcon(backgroundImage);
        backgroundLabel = new JLabel(scaledBackgroundImageIcon);
        backgroundLabel.setBounds(0, 0, 1000, 324); // Set bounds for background label
        add(backgroundLabel);

        JLabel lblname = new JLabel("Passenger Name");
        lblname.setBounds(60, 100, 150, 25);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lblname);

        tfPassengerName = new JLabel();
        tfPassengerName.setBounds(220, 100, 150, 25);
        backgroundLabel.add(tfPassengerName);

        JLabel lblpassport = new JLabel("Passport Number");
        lblpassport.setBounds(380, 100, 150, 25);
        lblpassport.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lblpassport);

        tfPassportNumber = new JLabel();
        tfPassportNumber.setBounds(540, 100, 150, 25);
        backgroundLabel.add(tfPassportNumber);

        JLabel lblcountry = new JLabel("Country");
        lblcountry.setBounds(60, 140, 150, 25);
        lblcountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lblcountry);

        tfCountry = new JLabel();
        tfCountry.setBounds(220, 140, 150, 25);
        backgroundLabel.add(tfCountry);

        JLabel lblorigin = new JLabel("Origin");
        lblorigin.setBounds(60, 180, 150, 25);
        lblorigin.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lblorigin);

        lblOrigin = new JLabel();
        lblOrigin.setBounds(220, 180, 150, 25);
        backgroundLabel.add(lblOrigin);

        JLabel lbldest = new JLabel("Destination");
        lbldest.setBounds(380, 180, 150, 25);
        lbldest.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lbldest);

        lblDestination = new JLabel();
        lblDestination.setBounds(540, 180, 150, 25);
        backgroundLabel.add(lblDestination);

        Font biggerFont = new Font("Tahoma", Font.BOLD, 28);
        lblBoardingPassID = new JLabel();
        lblBoardingPassID.setBounds(810, 120, 300, 50); // Adjust the bounds as needed
        lblBoardingPassID.setFont(biggerFont);
        backgroundLabel.add(lblBoardingPassID);

        JLabel lblTakeoff = new JLabel("Departure Date");
        lblTakeoff.setBounds(60, 220, 150, 25);
        lblTakeoff.setFont(new Font("Tahoma", Font.PLAIN, 16));
        backgroundLabel.add(lblTakeoff);

        lblTakeoffDate = new JLabel();
        lblTakeoffDate.setBounds(220, 220, 150, 25);
        backgroundLabel.add(lblTakeoffDate);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set default close operation to exit
        setSize(1000, 350);
        setLocation(300, 150);
        setResizable(false); // Prevent resizing for fixed layout
        setVisible(true);

        // Fetch and display ticket details
        fetchTicketDetails(ticketID);
    }

    private void fetchTicketDetails(String ticketID) {
        try {
            // Establish database connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ams", "root", "");

            // Prepare the SQL query with a parameterized statement
            String query = "SELECT t.ticket_id, t.name, t.passportnumber, t.nationality, " +
                    "mf.source, mf.destination, t.bpass, mf.takeoff " +
                    "FROM tickets t " +
                    "JOIN manageflight mf ON t.bpass = mf.flightID " +
                    "WHERE t.ticket_id = ?";

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, ticketID);

            // Execute the query
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                // Set values from ResultSet to corresponding components
                tfPassengerName.setText(rs.getString("name"));
                tfPassportNumber.setText(rs.getString("passportnumber"));
                tfCountry.setText(rs.getString("nationality"));
                lblOrigin.setText(rs.getString("source"));
                lblDestination.setText(rs.getString("destination"));
                lblBoardingPassID.setText(generateBoardingPassID()); // Set boarding pass ID
                lblTakeoffDate.setText(rs.getString("takeoff"));
            } else {
                JOptionPane.showMessageDialog(null, "Please enter correct Ticket ID");
            }

            // Close the ResultSet, PreparedStatement, and connection
            rs.close();
            pst.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    // Method to generate a random boarding pass ID like "AA-1230"
    private String generateBoardingPassID() {
        Random random = new Random();
        char[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int number = random.nextInt(10000); // Random number between 0 and 9999

        // Randomly choose two letters and concatenate with the random number
        char letter1 = letters[random.nextInt(letters.length)];
        char letter2 = letters[random.nextInt(letters.length)];

        return String.format("%c%c-%04d", letter1, letter2, number);
    }

    public static void main(String[] args) {
        new BoardingPass("1"); // Pass a sample ticketID for testing
    }
}
