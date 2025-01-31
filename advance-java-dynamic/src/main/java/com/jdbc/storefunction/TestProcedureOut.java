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
	 * DELIMITER &&
         CREATE PROCEDURE empOut(OUT c INT)
           BEGIN
              SELECT salary INTO c FROM employee WHERE id = 5;
           END &&
       DELIMITER ;
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
