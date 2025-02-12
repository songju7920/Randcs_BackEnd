package org.example.global.auth.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.error.exception.InternalServerErrorException;
import org.example.common.service.MailService;
import org.example.global.auth.mail.exception.EmailNotValidException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {
    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    @Override
    public void sendMail(MimeMessage mimeMessage) {
        javaMailSender.send(mimeMessage);
    }

    @Override
    public void checkEmailIsValid(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        if (email == null || !email.matches(emailRegex)) {
            throw EmailNotValidException.EXCEPTION;
        }
    }

    @Override
    public MimeMessage makeEmailForm(String content, String requestEmail) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            message.addRecipients(MimeMessage.RecipientType.TO, requestEmail);
            message.setSubject("Helper 인증번호입니다");
            message.setFrom(senderEmail);
            message.setText(setContext(content), "utf-8", "html");

            return message;
        } catch (MessagingException e) {
            throw InternalServerErrorException.EXCEPTION;
        }
    }

    private String setContext(String code) {
        return "<div style='font-size:16px; font-family:Arial, sans-serif;'>" +
                "RandCS 인증번호입니다: <strong>" + code + "</strong>" +
                "</div>";
    }
}
