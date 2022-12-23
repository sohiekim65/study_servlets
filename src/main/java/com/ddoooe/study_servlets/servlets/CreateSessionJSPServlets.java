package com.ddoooe.study_servlets.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// /session/createJSPServlets?username=yojulab&password=1234
@WebServlet(urlPatterns = "/session/createJSPServlets")
public class CreateSessionJSPServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 처리
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // display
        // login
        HttpSession httpSession = null;
        HttpSession httpSession_false = null;
        
        // JSESSIONID이 존재하지 않을 때
        // httpSession_false = request.getSession(false); // Null
        // httpSession = request.getSession(); // 무조건 인스턴스화(있든 없든)
        
        // JSESSIONID이 존재할 때
        // httpSession_false = request.getSession(false); // 존재하면 인스턴스화
        // httpSession = request.getSession(); // 무조건 인스턴스화(있든 없든)

        String path = null;
        if("yojulab".equals(username) && "1234".equals(password)){
            // login
            httpSession = request.getSession(false); // 존재하면 인스턴스화
            if(httpSession == null){
                httpSession = request.getSession(); // 무조건 인스턴스화
                httpSession.setAttribute("username", username);
                httpSession.setAttribute("password", password);
            }
            
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogin.jsp";
        
        } else {
            // logout
            // dispatcher의 두번 생성하지 말고 String 변수를 만들어 사용
            // 로그아웃하면 session 삭제
            httpSession = request.getSession(false);
            if(httpSession != null){
                httpSession.invalidate();
            }
            // invalidate해서 값이 없기 때문에 println할 수 가 없음
            System.out.println(httpSession.getAttribute("username"));
            System.out.println(httpSession.getId());
            path = "/session/checkLogout.jsp";
        }
        // 그리고 dispatcher에 변수를 넘김
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }
}
