/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class RestaurantManagementGUI {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/restaurant"; 
    private static final String DB_USER = "root"; // 
    private static final String DB_PASSWORD = ""; // 

    public static void main(String[] args) {
        // Create Main Frame
        JFrame frame = new JFrame("Restaurant Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Tabbed Pane
        JTabbedPane tabbedPane = new JTabbedPane();

        // Order Management Tab
        JPanel orderPanel = new JPanel();
        orderPanel.setLayout(new BoxLayout(orderPanel, BoxLayout.Y_AXIS));

        // Order Fields
        orderPanel.add(new JLabel("Menu Item:"));
        JComboBox<String> menuItemComboBox = new JComboBox<>(new String[]{"Appetizer", "Main Course", "Dessert"});
        orderPanel.add(menuItemComboBox);

        orderPanel.add(new JLabel("Table Type:"));
        JComboBox<String> tableTypeComboBox = new JComboBox<>(new String[]{"Regular", "VIP", "Outdoor"});
        orderPanel.add(tableTypeComboBox);

        orderPanel.add(new JLabel("Order Details:"));
        JTextArea orderDetailsArea = new JTextArea(5, 20);
        orderPanel.add(new JScrollPane(orderDetailsArea));

        JButton orderButton = new JButton("Place Order");
        orderButton.addActionListener(e -> {
            String menuItem = (String) menuItemComboBox.getSelectedItem();
            String tableType = (String) tableTypeComboBox.getSelectedItem();
            String orderDetails = orderDetailsArea.getText();

            // Save Order to Database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO Orders (menuItem, tableType, details) VALUES (?, ?, ?)")) {
                stmt.setString(1, menuItem);
                stmt.setString(2, tableType);
                stmt.setString(3, orderDetails);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Order Placed Successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error placing order.");
            }
        });
        orderPanel.add(orderButton);

        tabbedPane.addTab("Orders", orderPanel);

        // Reservation Management Tab
        JPanel reservationPanel = new JPanel();
        reservationPanel.setLayout(new BoxLayout(reservationPanel, BoxLayout.Y_AXIS));

        reservationPanel.add(new JLabel("Customer Name:"));
        JTextField reservationCustomerNameField = new JTextField(20);
        reservationPanel.add(reservationCustomerNameField);

        reservationPanel.add(new JLabel("Reservation Date (YYYY-MM-DD):"));
        JTextField reservationDateField = new JTextField(20);
        reservationPanel.add(reservationDateField);

        reservationPanel.add(new JLabel("Reservation Time (HH:MM:SS):"));
        JTextField reservationTimeField = new JTextField(20);
        reservationPanel.add(reservationTimeField);

        reservationPanel.add(new JLabel("Table Type:"));
        JComboBox<String> reservationTableTypeComboBox = new JComboBox<>(new String[]{"Regular", "VIP", "Outdoor"});
        reservationPanel.add(reservationTableTypeComboBox);

        JButton createReservationButton = new JButton("Create Reservation");
        createReservationButton.addActionListener(e -> {
            String customerName = reservationCustomerNameField.getText();
            String date = reservationDateField.getText();
            String time = reservationTimeField.getText();
            String tableType = (String) reservationTableTypeComboBox.getSelectedItem();

            // Save Reservation to Database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO Reservations (customerName, reservationDate, reservationTime, tableType) VALUES (?, ?, ?, ?)")) {
                stmt.setString(1, customerName);
                stmt.setString(2, date);
                stmt.setString(3, time);
                stmt.setString(4, tableType);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Reservation Created Successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error creating reservation.");
            }
        });
        reservationPanel.add(createReservationButton);

        tabbedPane.addTab("Reservations", reservationPanel);

        // Customer Details Tab
        JPanel customerPanel = new JPanel();
        customerPanel.setLayout(new BoxLayout(customerPanel, BoxLayout.Y_AXIS));

        customerPanel.add(new JLabel("Customer Name:"));
        JTextField customerNameField = new JTextField(20);
        customerPanel.add(customerNameField);

        customerPanel.add(new JLabel("Contact Information:"));
        JTextField contactField = new JTextField(20);
        customerPanel.add(contactField);

        customerPanel.add(new JLabel("Notes:"));
        JTextArea notesArea = new JTextArea(5, 20);
        customerPanel.add(new JScrollPane(notesArea));

        JButton saveCustomerButton = new JButton("Save Customer Details");
        saveCustomerButton.addActionListener(e -> {
            String customerName = customerNameField.getText();
            String contactInfo = contactField.getText();
            String notes = notesArea.getText();

            // Save Customer Details to Database
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement stmt = conn.prepareStatement("INSERT INTO Customers (name, contactInfo, notes) VALUES (?, ?, ?)")) {
                stmt.setString(1, customerName);
                stmt.setString(2, contactInfo);
                stmt.setString(3, notes);
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(frame, "Customer Details Saved Successfully!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Error saving customer details.");
            }
        });
        customerPanel.add(saveCustomerButton);

        tabbedPane.addTab("Customer Details", customerPanel);

        frame.add(tabbedPane);
        frame.setVisible(true);
    }
}
