package com.servlet.sessionTracking;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session or create a new one
        HttpSession session = request.getSession();

        // Retrieve session attribute
        String username = (String) session.getAttribute("username");

        // Set content type
        response.setContentType("text/html");

        // Write the response
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h1>Welcome to the Session Servlet</h1>");
        if (username != null) {
            response.getWriter().println("<p>Session Attribute: Username = " + username + "</p>");
        } else {
            response.getWriter().println("<p>No session attribute found.</p>");
        }

        // Add a link to go back to the JSP page
        String encodedBackURL = response.encodeURL("Cookie.jsp");
        response.getWriter().println("<a href=\"" + encodedBackURL + "\">Go Back to Index</a>");

        response.getWriter().println("</body></html>");
    }
}
