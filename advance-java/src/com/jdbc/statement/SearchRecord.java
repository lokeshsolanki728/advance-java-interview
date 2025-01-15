package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SearchRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        Statement stmt = conn.createStatement();
        String searchSQL = "SELECT * FROM employee";
        ResultSet rs = stmt.executeQuery(searchSQL);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age") + ", DOB: " + rs.getDate("dob"));
        }
        rs.close();
        stmt.close();
        conn.close();
    }
}
