package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UpdateRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        Statement stmt = conn.createStatement();
        int idToUpdate = 1; // Specify the ID of the record to update
        String updateSQL = "UPDATE employee SET name = 'John Doe', age = 30 WHERE id = " + idToUpdate;
        int rowsAffected = stmt.executeUpdate(updateSQL);
        System.out.println(rowsAffected + " record(s) updated.");
        stmt.close();
        conn.close();
    }
}
