package com.github.kbednarz.issuetrackingsystem.service.mail;

import com.github.kbednarz.issuetrackingsystem.observer.Observer;
import org.springframework.mail.javamail.JavaMailSender;

public abstract class MailService implements Observer {
    protected MailService nextMailService;
    protected Integer configDepth;
    protected JavaMailSender javaMailSender;

    public MailService(JavaMailSender javaMailSender, Integer configDepth) {
        this.configDepth = configDepth;
        this.javaMailSender = javaMailSender;
    }

    public void sendMail(Integer depth, String subject, String content) {
        if (depth < configDepth)
            send(subject, content);

        if (nextMailService != null)
            nextMailService.sendMail(depth, subject, content);
    }

    protected abstract void send(String subject, String content);

    public void setNextMailService(MailService nextMailService) {
        this.nextMailService = nextMailService;
    }
}
