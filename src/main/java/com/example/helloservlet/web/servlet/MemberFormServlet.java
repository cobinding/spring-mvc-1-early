package com.example.helloservlet.web.servlet;

import com.example.helloservlet.domain.member.MemberRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
public class MemberFormServlet extends HttpServlet {

    // private을 이용해 싱글톤으로 막아놨기 때문에 new로 생성하지 않고 getInstance 활용
    MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        // Servlet으로 하면 html 모두 자바 코드로 줘야한다.
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        w.write("<!DOCTYPE html>\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"UTF-8\">\n" +
            "    <title>Title</title>\n" +
            "</head>\n" +
            "<body>\n" +
            "<form action=\"/servlet/members/save\" method=\"post\">\n" +
            "    username: <input type=\"text\" name=\"username\" />\n" +
            "    age:      <input type=\"text\" name=\"age\" />\n" +
            " <button type=\"submit\">전송</button>\n" + "</form>\n" +
            "</body>\n" +
            "</html>\n");
    }
}
