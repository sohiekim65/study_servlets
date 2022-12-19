package com.ddoooe.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.ddoooe.study_servlets.dao.SimpleWithDB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/WithDBServlets")
public class SimpleWithDBServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // DB 연결 부분
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        simpleWithDB.getList();
        // Display area
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");
        printWriter.close();
    }
}
