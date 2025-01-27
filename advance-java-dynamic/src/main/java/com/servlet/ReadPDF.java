package com.servlet;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Q: Write a servlet that reads a PDF file from the file system and returns it as a servlet response.
@WebServlet("/ReadPDF")
public class ReadPDF extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/pdf");
        String filePath = "C:\\Users\\lokesh solanki\\Desktop\\Books\\Lokesh Solanki1.pdf";
        try (FileInputStream fis = new FileInputStream(filePath);
             OutputStream out = response.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
