package com.ddoooe.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/helloWorldServlets")
public class HelloWorldServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        
        String message = "HelloWorldServlets with Message !";
        PrintWriter printWriter = response.getWriter();

        printWriter.println("<html lang='en'>");
        printWriter.println("<head>");
        printWriter.println("<title>" + message + "</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div>" + message + "</div>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
