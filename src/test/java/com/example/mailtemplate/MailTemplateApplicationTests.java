package com.example.mailtemplate;

import com.example.mailtemplate.service.MailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MailTemplateApplicationTests {
    static {
        System.setProperty("username", "your naver email");
        System.setProperty("password", "your naver password");
    }

    @Autowired
    private MailService mailService;

    @Test
    @DisplayName("사용자 이메일로 템플릿 형식의 메일을 전송한다.")
    void contextLoads() throws Exception {
        String title = "Study List";
        List<Map<String, String>> list = new ArrayList<>();

        Map<String, String> map = new HashMap<>();
        map.put("idx", "1");
        map.put("title", "Java Study");
        map.put("content", "Java 기초공부하기");
        list.add(map);

        map = new HashMap<>();
        map.put("idx", "2");
        map.put("title", "Spring Study");
        map.put("content", "Spring 기초공부하기");
        list.add(map);

        Map<String, Object> variables = new HashMap<>();
        variables.put("title", title);
        variables.put("list", list);

        mailService.sendMail("수신할 메일주소", "메일제목", "발신자 이름설정", variables);
    }
}
