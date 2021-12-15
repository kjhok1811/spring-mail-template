package com.example.mailtemplate.service;

import com.example.mailtemplate.constant.TemplateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MailService {
    private final TemplateEngine htmlTemplateEngine;
    private final JavaMailSenderImpl javaMailSender;

    public void sendMail(String toAddress, String subject, String personal, Map<String, Object> variables) throws Exception {
        Context context = new Context();
        context.setVariables(variables);

        InternetAddress from = new InternetAddress(javaMailSender.getUsername(), personal);
        InternetAddress to = new InternetAddress(toAddress);

        String htmlTemplate = htmlTemplateEngine.process(TemplateUtils.DEFAULT_TEMPLATE_PATH, context);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, StandardCharsets.UTF_8.name());
        messageHelper.setFrom(from);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(htmlTemplate, Boolean.TRUE);

        javaMailSender.send(mimeMessage);
    }
}
