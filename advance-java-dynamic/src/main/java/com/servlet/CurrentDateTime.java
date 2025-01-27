package com.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a servlet that will display current date and time.
// The browser should automatically refresh contents from the servlet every 5 seconds.
@WebServlet("/CurrentDateTime")
public class CurrentDateTime extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        response.setHeader("Refresh", "5");
        out.println("Current Date and Time: " + new Date());
    }
}
