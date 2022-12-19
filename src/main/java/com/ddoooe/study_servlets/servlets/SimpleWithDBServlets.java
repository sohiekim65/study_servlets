package com.ddoooe.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

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
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");
        // DB 연결 부분
        SimpleWithDB simpleWithDB = new SimpleWithDB();
        ArrayList<HashMap> bundle_list = simpleWithDB.getList();

        // display
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<div>SimpleWithDBServlets</div>");
        for(int i = 0; i < bundle_list.size(); i++) {
            HashMap<String, Object> bundle =  bundle_list.get(i);
            HashMap<String, Object> question = (HashMap<String, Object>) bundle.get("question");
            ArrayList<HashMap> example_list = (ArrayList<HashMap>)bundle.get("example_list");
            HashMap<String, Object> answer = example_list.get(i);
            int orders = (int) question.get("ORDERS");
            String questions = (String) question.get("QUESTIONS");
            String questions_uid = (String) question.get("QUESTIONS_UID");
            printWriter.println("<div>"+orders+". "+questions+"<input type='hidden' value='"+questions_uid+"' /></div>");
            // 답항 출력
            // for(int j = 0; j < example_list.size(); j++){
            // }
        }
        printWriter.close();

    }
}
