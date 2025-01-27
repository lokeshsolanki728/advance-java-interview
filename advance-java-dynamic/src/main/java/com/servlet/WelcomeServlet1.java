package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a servlet "Welcome". Map this servlet with two URL patterns `/adminDB` and `/staffDB`.
// Print "Welcome Admin" when `/adminDB` is called and "Welcome Staff" when `/staffDB` is called.
@WebServlet({"/adminDB", "/staffDB"})
public class WelcomeServlet1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String uri = request.getRequestURI();
        if (uri.endsWith("/adminDB")) {
            response.getWriter().println("Welcome Admin");
        } else if (uri.endsWith("/staffDB")) {
            response.getWriter().println("Welcome Staff");
        }
    }
}
