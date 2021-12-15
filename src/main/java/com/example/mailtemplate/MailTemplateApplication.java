package com.example.mailtemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MailTemplateApplication {
    public static void main(String[] args) {
        System.setProperty("username", "your naver email");
        System.setProperty("password", "your naver password");
        SpringApplication.run(MailTemplateApplication.class, args);
    }
}
