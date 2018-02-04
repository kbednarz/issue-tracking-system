package com.github.kbednarz.issuetrackingsystem.service.mail;

import org.springframework.stereotype.Service;

@Service
public abstract class MailService {
    protected MailService nextMailService;
    protected Integer configDepth;

    public void sendMail(Integer depth, String subject, String content) {
        if (configDepth < depth)
            send(subject, content);
        
        if (nextMailService != null)
            nextMailService.sendMail(depth, subject, content);
    }

    protected abstract void send(String subject, String content);

    public void setNextMailService(MailService nextMailService) {
        this.nextMailService = nextMailService;
    }
}
