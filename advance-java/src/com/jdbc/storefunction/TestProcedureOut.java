package com.jdbc.storefunction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureOut {

	/**
	 * @param args
	 * @throws Exception
	 * 
	 * mysql> delimiter &&
       mysql> create procedure empOut(out c int)
           -> begin
           -> select salary into c from employee where id = 5;
           -> end &&
	 */
	public static void main(String[] args) throws Exception {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");

			CallableStatement callStmt = conn.prepareCall("{CALL empOut(?)}");

			callStmt.registerOutParameter(1, Types.INTEGER);

			callStmt.execute();

			int resultValue = callStmt.getInt(1);

			System.out.println("Result from empOut stored procedure: " + resultValue);

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

}
