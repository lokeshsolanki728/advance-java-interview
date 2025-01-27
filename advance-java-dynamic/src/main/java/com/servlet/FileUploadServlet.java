package com.servlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@MultipartConfig
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Part filePart = request.getPart("file"); // Form field name "file"
        String fileName = filePart.getSubmittedFileName();

        // Save the uploaded file to server directory
        String uploadPath = getServletContext().getRealPath("/") + "uploads";
        System.out.println(uploadPath);
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdir();

        filePart.write(uploadPath + File.separator + fileName);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>File Uploaded Successfully!</h3>");
        out.println("<img src='uploads/" + fileName + "' width='300' height='300'/>");
        out.println("</body></html>");
    }
}
