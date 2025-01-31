package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionHandling {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        PreparedStatement pss = null;

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
            conn.setAutoCommit(false); 

            // Prepare the SQL INSERT statement
            ps = conn.prepareStatement("INSERT INTO employee (name, age, dob) VALUES (?, ?, ?)");
            ps.setString(1, "nikhil");
            ps.setInt(2, 22);          
            ps.setDate(3, java.sql.Date.valueOf("2003-05-22"));
            ps.executeUpdate();

            // Prepare the second SQL INSERT statement
            pss = conn.prepareStatement("INSERt INTO employee (name, age, dob) VALUES (?, ?, ?)");
            pss.setString(1, "nikhil"); 
            pss.setInt(2, 22);      
            pss.setDate(3, java.sql.Date.valueOf("2003-05-22"));
            pss.executeUpdate();

            conn.commit();
            System.out.println("Transaction committed successfully!");

        } catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
            if (conn != null) {
                try {
                    conn.rollback(); // Rollback the transaction on failure
                    System.out.println("Transaction rolled back due to an error.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Error during rollback: " + rollbackEx.getMessage());
                }
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception: " + e.getMessage());
        } 
    }
}