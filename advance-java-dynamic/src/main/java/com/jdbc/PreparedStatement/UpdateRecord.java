package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdateRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        int idToUpdate = 1; // Specify the ID of the record to update
        String updateSQL = "UPDATE employee SET name = ?, age = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(updateSQL);
        pstmt.setString(1, "lokesh");
        pstmt.setInt(2, 30);
        pstmt.setInt(3, idToUpdate);
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " record(s) updated.");
        pstmt.close();
        conn.close();
    }
}
