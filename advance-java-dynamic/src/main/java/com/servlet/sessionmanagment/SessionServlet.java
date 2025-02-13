package com.servlet.sessionmanagment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionManagment")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Create or retrieve existing session
        HttpSession session = request.getSession(true);

        // Get session ID
        String sessionId = session.getId();
        System.out.println(sessionId);
        System.out.println("l;djfk");

        // Redirect to JSP with session ID as a request parameter
        response.sendRedirect("DisplaySession.jsp?sessionId=" + sessionId);
    }
}

 
  
