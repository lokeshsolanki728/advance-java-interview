package com.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a CatalogServlet that stores user-selected items in a cookie.
// Display the last visit's selected items stored in the cookie.
@WebServlet("/CatalogServlet")
public class CatalogServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String item = request.getParameter("item");
        if (item != null) {
            Cookie cookie = new Cookie("lastSelectedItem", item);
            cookie.setMaxAge(30 * 24 * 60 * 60); // 30 days
            response.addCookie(cookie);
        }

        Cookie[] cookies = request.getCookies();
        String lastItem = "None";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastSelectedItem")) {
                    lastItem = c.getValue();
                    break;
                }
            }
        }
        response.getWriter().println("Last Selected Item: " + lastItem);
    }
}
