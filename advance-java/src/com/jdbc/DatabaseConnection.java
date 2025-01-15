package com.jdbc;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class DatabaseConnection {

	private static DatabaseConnection jds = null;

	private ComboPooledDataSource ds = null;

	private DatabaseConnection() {

		try {

			ds = new ComboPooledDataSource();

			ds.setDriverClass("com.mysql.cj.jdbc.Driver");

			ds.setJdbcUrl("jdbc:mysql://localhost:3306/NewJDBC");

			ds.setUser("root");

			ds.setPassword("root");

			ds.setInitialPoolSize(5);

			ds.setAcquireIncrement(5);

			ds.setMaxPoolSize(50);

		} catch (PropertyVetoException e) {

			e.printStackTrace();
		}
	}

	public static DatabaseConnection getInstance() {
		if (jds == null) {
			
				jds = new DatabaseConnection();
		}
		return jds;
	}

	public static Connection getConnection() {

		try {
			return getInstance().ds.getConnection();

		} catch (SQLException e) {
			return null;
		}
	}
}