package com.jdbc.storefunction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * @author lokesh solanki
 *
 *         DELIMITER &&
 *            CREATE FUNCTION square(num INT)
 *              RETURNS INT
 *              DETERMINISTIC 
 *              BEGIN
 *                 DECLARE result INT; 
 *                 SET result = num * num;
 *                 RETURN result;
 *              END && 
 *         DELIMITER ;
 * 
 */
public class TestStoreFunction {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/NewJDBC", "root", "root");

		CallableStatement callStmt = conn.prepareCall("{? = CALL square(?)}");

		callStmt.registerOutParameter(1, Types.INTEGER);

		callStmt.setInt(2, 100);

		callStmt.execute();

		System.out.println(" Square " + callStmt.getInt(1));
	}

}
