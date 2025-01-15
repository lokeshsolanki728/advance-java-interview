package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        Statement stmt = conn.createStatement();
        String insertSQL = "INSERT INTO employee (name, age, dob) VALUES ('Alice', 25, '1998-01-15')";
        int rowsAffected = stmt.executeUpdate(insertSQL);
        System.out.println(rowsAffected + " record(s) inserted.");
        stmt.close();
        conn.close();
    }
}
