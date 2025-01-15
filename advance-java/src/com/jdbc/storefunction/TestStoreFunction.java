package com.jdbc.storefunction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

/**
 * @author lokesh solanki
 *
 *	-> delimiter &&
	-> create function square(num int)
    -> returns int
    -> deterministic
    -> begin
    -> declare result int;
    -> set result = num * num;
    -> return result;
    -> end &&

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
