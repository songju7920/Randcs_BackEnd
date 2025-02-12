package org.example.common.service;

import jakarta.mail.internet.MimeMessage;

public interface MailService {

    void sendMail(MimeMessage mimeMessage);

    void checkEmailIsValid(String email);

    MimeMessage makeEmailForm(String content, String requestEmail);
}