package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        String insertSQL = "INSERT INTO employee (name, age, dob) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(insertSQL);
        pstmt.setString(1, "lokeshhhh");
        pstmt.setInt(2, 25);
        pstmt.setString(3, "1998-01-15");
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " record(s) inserted.");
        pstmt.close();
        conn.close();
    }
}
