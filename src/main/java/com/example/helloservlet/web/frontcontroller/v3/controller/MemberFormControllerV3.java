package com.example.helloservlet.web.frontcontroller.v3.controller;

import com.example.helloservlet.web.frontcontroller.ModelView;
import com.example.helloservlet.web.frontcontroller.v3.ControllerV3;
import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // 전체 path "WEB-IMF/../.jsp가 아닌 논리 이름만
        return new ModelView("new-form");
    }
}
