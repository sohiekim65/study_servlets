package com.ddoooe.study_servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/formsSelectsServlet")
public class FormsSelectsServlets extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        PrintWriter printWriter = response.getWriter();

        String title = "FormsSelects";
        printWriter.println("<html lang='en'>");

        printWriter.println("<head>");
        printWriter.println("<title>" + title + "</title>");
        printWriter.println("<link");
        printWriter.println("href='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css'");
        printWriter.println("rel='stylesheet'");
        printWriter.println("integrity='sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65'");
        printWriter.println("crossorigin='anonymous'");
        printWriter.println("/>");
        printWriter.println("<link rel='stylesheet' href='./css/commons.css' />");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div class='fs-3'>form selects</div>");
        printWriter.println("<div>");
        printWriter.println("<label for='' class='form-label'>select</label>");
        printWriter.println(" <select class='form-select' aria-label=''>");
        printWriter.println(" <option>Open this select menu</option>");
        printWriter.println(" <option value='M01'>One</option>");
        printWriter.println("  <option value='M02' selected>Two</option>");
        printWriter.println("  <option value='M03'>Three</option>");
        printWriter.println(" </select>");
        printWriter.println("</div>");
        printWriter.println("<div>");
        printWriter.println(" <label for='' class='form-label'>select multiple</label>");
        printWriter.println(" <select class=form-select' multiple aria-label=''>");
        printWriter.println("  <option value='M01'>One</option>");
        printWriter.println("   <option value='M02' selected>Two</option>");
        printWriter.println(" <option value='M03'>Three</option>");
        printWriter.println(" <option value='M04' selected>Four</option>");
        printWriter.println(" <option value='M01'>One</option>");
        printWriter.println("  <option value='M02' selected>Two</option>");
        printWriter.println("  <option value='M03'>Three</option>");
        printWriter.println("  <option value='M04' selected>Four</option>");
        printWriter.println("</select>");
        printWriter.println("</div>");
        printWriter.println("<script");
        printWriter.println("src='https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js'");
        printWriter.println("integrity='sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4'");
        printWriter.println(" crossorigin='anonymous'");
        printWriter.println("></script>");
        printWriter.println("</body>");
        printWriter.println("</html>");

        printWriter.close();
    }
}
