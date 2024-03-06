package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * This method sends an email
     * 
     * @param to      Person to send the email
     * @param subject Subject of the email
     * @param body    Body of the email
     */
    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(new String[] { "jdlm1999@gmail.com", "didier.correa@proteccion.com.co", "correalondon@gmail.com",
                "jdlm201299@gmail.com" });
        message.setSubject(subject);

        String htmlContent = body;

        message.setText(htmlContent);

        mailSender.send(message);
    }
}
