package com.ms.email.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com"); // Set your SMTP server host
        mailSender.setPort(587); // Use the appropriate port for Gmail
        mailSender.setUsername("msemailtest01@gmail.com");
        mailSender.setPassword("obkplznchsrcztrk");

        // Configure other properties if needed
        mailSender.getJavaMailProperties().setProperty("mail.smtp.auth", "true");
        mailSender.getJavaMailProperties().setProperty("mail.smtp.starttls.enable", "true");

        return mailSender;
    }
}
