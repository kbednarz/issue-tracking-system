package com.github.kbednarz.issuetrackingsystem.service.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class AdministrationMailService extends MailService {
    public AdministrationMailService(JavaMailSender javaMailSender, Integer configDepth) {
        super(javaMailSender, configDepth);
    }

    @Override
    protected void send(String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("administration@project");
        message.setSubject(subject);
        message.setText(content);
        javaMailSender.send(message);
    }

    @Override
    public void update() {
        send("Project added", "Project has been added");
    }
}
