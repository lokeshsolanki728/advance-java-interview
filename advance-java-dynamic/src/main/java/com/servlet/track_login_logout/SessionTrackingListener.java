package com.servlet.track_login_logout;

import javax.servlet.http.*;
import java.sql.*;
import java.time.LocalDateTime;

/**
 * @param username
 * 
 *                 CREATE TABLE user_log ( id INT AUTO_INCREMENT PRIMARY KEY,
 *                 username VARCHAR(50), event_type VARCHAR(10), -- LOGIN/LOGOUT
 *                 event_time TIMESTAMP );
 * 
 */
public class SessionTrackingListener implements HttpSessionBindingListener {
	private String username;

	public SessionTrackingListener(String username) {
		this.username = username;
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		logEvent("LOGIN", username);
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		logEvent("LOGOUT", username);
	}

	private void logEvent(String eventType, String username) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newJDBC", "root", "root");
				PreparedStatement ps = con
						.prepareStatement("INSERT INTO user_log (username, event_type, event_time) VALUES (?, ?, ?)")) {

			ps.setString(1, username);
			ps.setString(2, eventType);
			ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
}
