<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session Tracking Example</title>
</head>
<body>
    <h1>Session Tracking using response.encodeURL()</h1>

    <%
        // Create a session or get the existing one
        HttpSession sessionn = request.getSession(true);

        // Store an attribute in the session
        sessionn.setAttribute("username", "Lokesh");

        // Generate the URL with the session ID encoded
        String encodedURL = response.encodeURL("SessionServlet");
    %>

    <!-- Provide a link to the servlet -->
    <a href="<%= encodedURL %>">Go to Session Servlet</a>
</body>
</html>
