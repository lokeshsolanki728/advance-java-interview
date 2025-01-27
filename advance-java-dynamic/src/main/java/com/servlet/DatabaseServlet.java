package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/DatabaseServlet") // Make sure you map it correctly
public class DatabaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set content type for the response
        response.setContentType("text/html");

        // Get the ServletConfig object
        ServletConfig config = getServletConfig();

        // Retrieve database connection details from web.xml
        String username = config.getInitParameter("dbUsername");
        String password = config.getInitParameter("dbPassword");
        String url = config.getInitParameter("dbUrl");

        // Initialize JDBC objects
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the database
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

            // Execute SQL query
            resultSet = statement.executeQuery("SELECT * FROM dept");

            // Process results and display data
            StringBuilder resultBuilder = new StringBuilder();
            while (resultSet.next()) {
                // Retrieve data from the result set
                int data1 = resultSet.getInt(1);
                String data2 = resultSet.getString(2);

                // Append data to the result string
                resultBuilder.append(data1).append(" ").append(data2).append("<br>");
            }

            // Write result to response
            response.getWriter().println(resultBuilder.toString());

        } catch (SQLException e) {
            // Handle SQL exceptions and display an error message
            response.getWriter().println("<p>Error: " + e.getMessage() + "</p>");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // Handle JDBC driver loading errors
            response.getWriter().println("<p>Error: JDBC Driver not found!</p>");
            e.printStackTrace();
        } finally {
            // Close resources to prevent memory leaks
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
