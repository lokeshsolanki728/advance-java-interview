package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CreateTable {
    public static void main(String[] args) throws Exception {
        // Load MySQL JDBC driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        // Connection details
        String url = "jdbc:mysql://localhost:3306/NewJDBC";
        String username = "root";
        String password = "root";
        
        // SQL statement for table creation
        String createTableSQL = "CREATE TABLE employee ("
                + "id INT NOT NULL AUTO_INCREMENT, "
                + "name VARCHAR(100), "
                + "age INT, "
                + "dob DATE, "
                + "PRIMARY KEY (id))";

        // Establish connection
        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(createTableSQL)) {

            // Execute the statement
            int result = ps.executeUpdate();
            System.out.println("Table created successfully. Result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
