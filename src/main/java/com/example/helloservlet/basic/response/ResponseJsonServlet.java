package com.example.helloservlet.basic.response;


import com.example.helloservlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        response.setContentType("application/json");
        // response.setCharacterEncoding("utf-8"); json은 utf-8 형식

        HelloData helloData = new HelloData();
        helloData.setUsername("chuchu");
        helloData.setAge(200);

        // 문자열로 바꿔주기
        // response.getWriter().write(helloData.toString());
        String result = objectMapper.writeValueAsString(helloData);
        response.getWriter().write(result);


    }

}
