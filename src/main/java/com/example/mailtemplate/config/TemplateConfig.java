package com.example.mailtemplate.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

@Configuration
@RequiredArgsConstructor
public class TemplateConfig {
    private static final int BEAN_INIT_ORDER = 1;
    private final ThymeleafProperties thymeleafProperties;

    @Bean
    public TemplateEngine htmlTemplateEngine() {
        TemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.addTemplateResolver(htmlTemplateResolver());

        return templateEngine;
    }

    @Bean
    public SpringResourceTemplateResolver htmlTemplateResolver() {
        SpringResourceTemplateResolver springResourceTemplateResolver = new SpringResourceTemplateResolver();
        springResourceTemplateResolver.setOrder(BEAN_INIT_ORDER);
        springResourceTemplateResolver.setPrefix(thymeleafProperties.getPrefix());
        springResourceTemplateResolver.setSuffix(thymeleafProperties.getSuffix());
        springResourceTemplateResolver.setCharacterEncoding(thymeleafProperties.getEncoding().name());
        springResourceTemplateResolver.setCacheable(Boolean.FALSE);

        return springResourceTemplateResolver;
    }
}
