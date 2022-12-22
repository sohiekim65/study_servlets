package com.ddoooe.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;

import com.ddoooe.study_servlets.dao.PollWithDB;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/polls/PollServlet")
public class DetailServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        // input type
        String questions_Uid = request.getParameter("QUESTIONS_UID");

        // biz with DB and Class
        PollWithDB pollWithDB = new PollWithDB();
        // function 불러오기, 밖에서 선언
        HashMap<String, Object> question = null;
        try {
            // function 재선언
            question = pollWithDB.getQuestion(questions_Uid);
            // question이 동작하는 지 확인용 출력
            System.out.println(question.get("QUESTIONS_UID"));
            System.out.println(question.get("QUESTIONS"));
            System.out.println(question.get("ORDERS"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // output with html
        // jsp 입장에서 데이터 받는, 서블릿에서 데이터 넘겨주는
        request.setAttribute("question", question);

        // jsp로 작동하도록 방향 트는 url 인스턴스화(=printWriter 대체용)
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/polls/details.jsp");
        // forward하면서 request, response 모두 넘겨주는
        requestDispatcher.forward(request, response);
    }
}
