package com.jdbc.storefunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class TestProcedureInOut {

	/**
	 * 
	 *       -> DELIMITER &&
	 *       -> CREATE PROCEDURE empInOut(IN id INT, OUT salary INT)
	         -> BEGIN SELECT salary INTO salary FROM emp WHERE id = id;
	 *       -> END &&
	 *       -> DELIMITER ;
	 */
	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{CALL empInOut(?,?)}");

		callStmt.setInt(1, 5);

		callStmt.registerOutParameter(2, Types.INTEGER);

		callStmt.execute();

		System.out.println(callStmt.getInt(2));

	}

}
