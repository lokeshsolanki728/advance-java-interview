package com.jdbc.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateTable {
public static void main(String[] args) throws Exception {
	Class.forName("com.mysql.cj.jdbc.Driver");
	  String createTableSQL = "CREATE TABLE employee ("
              + "id INT NOT NULL AUTO_INCREMENT, "
              + "name VARCHAR(100), "
              + "age INT, "
              + "dob DATE, "
              + "PRIMARY KEY (id))";
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC","root","root");
	Statement ps=conn.createStatement();	
	int a =ps.executeUpdate(createTableSQL);
	System.out.println(a);
	
}
}
