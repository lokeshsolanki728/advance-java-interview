package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a servlet `WhatIsMyIP` using annotation that will display the IP address of the client request.
@WebServlet("/WhatIsMyIP")
public class WhatIsMyIP extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String clientIP = request.getRemoteAddr();
        response.getWriter().println("Your IP Address is: " + clientIP);
    }
}
