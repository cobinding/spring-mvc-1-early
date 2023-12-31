package com.example.helloservlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(req, resp);
        System.out.println("hello");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        // url에 쿼리 파라미터 넣으면 터미널에 찍히는 코드
        String username = request.getParameter("username");
        System.out.println("username = " + username);

        // 응답
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // Body에 데이터넣어주기
        response.getWriter().write("hello" + username);
    }
}
