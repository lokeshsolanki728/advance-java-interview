package com.jdbc.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchRecord {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");
        String searchSQL = "SELECT * FROM employee";
        PreparedStatement pstmt = conn.prepareStatement(searchSQL);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") +
                    ", Age: " + rs.getInt("age") + ", DOB: " + rs.getDate("dob"));
        }
        rs.close();
        pstmt.close();
        conn.close();
    }
}
