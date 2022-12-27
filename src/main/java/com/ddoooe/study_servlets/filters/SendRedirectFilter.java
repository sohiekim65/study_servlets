package com.ddoooe.study_servlets.filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// simple이라는 url에 들어오면 필터링
@WebFilter("/simple/*")
public class SendRedirectFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(request.getRemoteHost());
        System.out.println(request.getRemoteAddr());
        // 특정 url을 빼낼려고 http로 cast해주기
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String uri = httpServletRequest.getRequestURI();

        // uri면은 html로 아니면 servlet로 던져버림
        // 뒤에 글자가 서블릿을 가지고 index로 걸러내기 위해
        if(uri.endsWith("Servlets")){
            httpServletResponse.sendRedirect("/index.html");
        } else {
            // 사용자가 얘기했던 servlet으로 넘어간다
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
}
