package com.junit;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLifeCycle {
	private static Connection conn = null;
	private PreparedStatement ps = null;

	@BeforeClass
	public static void beforeClass() throws Exception {
		System.out.println("before class");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/newJDBC", "root", "root");
	}

	@Before
	public void before() throws Exception {
		System.out.println("before Test method");
		String sql = "insert into emp (id, name,salary) values (?,?,?)";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 5);
		ps.setString(2, "Lokesh");
		ps.setInt(3, 333);
		int i = ps.executeUpdate();
		System.out.println("data inserted " + i);
		ps.close();
	}

	@Test
	public void testFindMax1() throws Exception {
		UserBean bean = UserModel.findByPk(5);
		assertEquals("Lokesh", bean.getName());
		System.out.println("test method");
	}

	@After
	public void after() throws Exception {
		System.out.println("after Method");
		String sql = "delete from emp where id = ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, 3);
		int i = ps.executeUpdate();
		System.out.println("data deleted " + i);
		ps.close();
	}

	@AfterClass
	public static void afterClass() throws Exception {
		System.out.println("after class");
		if (conn != null) {
			conn.close();
		}
	}
}
