<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <title>Session ID Display</title>
</head>
<body>
    <h1>Session Tracking Example</h1>

    <%
        // Retrieve the session
        HttpSession session2 = request.getSession(false); // false means don't create if not exists

        if (session2 != null) {
            // Get session ID
            String sessionId = session2.getId();
    %>
            <p>Session ID: <%= sessionId %></p>
    <%
        } else {
    %>
            <p>No active session found.</p>
    <%
        }
    %>
</body>
</html>
