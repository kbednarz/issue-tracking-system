package com.github.kbednarz.issuetrackingsystem.service.mail;

import org.junit.Test;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MailServiceTest {

    @Test
    public void sendMail() {
        // given
        JavaMailSender javaMailSender = mock(JavaMailSender.class);
        AdministrationMailService administrationMailService = new AdministrationMailService(javaMailSender, 3);
        EmployeeMailSender employeeMailSender = mock(EmployeeMailSender.class);
        administrationMailService.setNextMailService(employeeMailSender);

        // when
        administrationMailService.sendMail(2, "subject", "text");

        // then
        verify(javaMailSender).send(any(SimpleMailMessage.class));
        verify(employeeMailSender).sendMail(2, "subject", "text");
    }
}