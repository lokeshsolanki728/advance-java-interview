package com.servlet.track_login_logout;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/LoginServlett")
// url = LoginServlett?username=lokesh&password=1122
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username);
		System.out.println(password);

		// Validate username/password here
		if ("lokesh".equals(username) && "1122".equals(password)) {
			HttpSession session = request.getSession();
			SessionTrackingListener listener = new SessionTrackingListener(username);
			session.setAttribute("user", listener); // This triggers valueBound()

			response.getWriter().println("Login successful!");
		} else {
			response.getWriter().println("Invalid credentials!");
		}
	}
}
