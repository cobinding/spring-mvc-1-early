package com.example.helloservlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // servlet package에 자동 등록
@SpringBootApplication
public class HelloServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServletApplication.class, args);
    }

}
