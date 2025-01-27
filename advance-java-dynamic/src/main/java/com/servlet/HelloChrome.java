package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a servlet `HelloChrome` that will display the message "Welcome Chrome" 
// to all incoming requests from Chrome browser. 
// If request is received from any other browser, display "This site is best viewed in Chrome".
@WebServlet("/HelloChrome")
public class HelloChrome extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String userAgent = request.getHeader("User-Agent");
        if (userAgent != null && userAgent.contains("Chrome")) {
            response.getWriter().println("Welcome Chrome");
        } else {
            response.getWriter().println("This site is best viewed in Chrome");
        }
    }
}
