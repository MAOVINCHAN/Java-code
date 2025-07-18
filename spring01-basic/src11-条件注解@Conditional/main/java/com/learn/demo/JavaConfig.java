package com.learn.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean("showCmd") // 同名的bean在spring容器中只会注册一个
    @Conditional(WinCondition.class)
    IShowCmd winShow() {
        return new WinShow();
    }

    @Bean("showCmd") // 同名的bean在spring容器中只会注册一个
    @Conditional(LinCondition.class)
    IShowCmd linShow() {
        return new LinuxShow();
    }
}
