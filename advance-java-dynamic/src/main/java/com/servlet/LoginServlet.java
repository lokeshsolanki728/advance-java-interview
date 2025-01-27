package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// Q: Write a LoginServlet that stores the login ID in a session object
// and forwards to WelcomeServlet, which displays the message at the top.
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String loginId = request.getParameter("loginId");
        HttpSession session = request.getSession();
        session.setAttribute("loginId", loginId);
        response.sendRedirect("/advance-java-dynamci/WelcomeServlet");
    }
}
