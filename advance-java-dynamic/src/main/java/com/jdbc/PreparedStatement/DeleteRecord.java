package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        int idToDelete = 1; // Specify the ID of the record to delete
        String deleteSQL = "DELETE FROM employee WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
        pstmt.setInt(1, idToDelete);
        int rowsAffected = pstmt.executeUpdate();
        System.out.println(rowsAffected + " record(s) deleted.");
        pstmt.close();
        conn.close();
    }
}
