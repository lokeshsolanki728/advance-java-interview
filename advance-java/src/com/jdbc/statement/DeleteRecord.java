package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DeleteRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        Statement stmt = conn.createStatement();
        int idToDelete = 1; // Specify the ID of the record to delete
        String deleteSQL = "DELETE FROM employee WHERE id = " + idToDelete;
        int rowsAffected = stmt.executeUpdate(deleteSQL);
        System.out.println(rowsAffected + " record(s) deleted.");
        stmt.close();
        conn.close();
    }
}
