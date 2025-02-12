package org.example.domain.auth.usecase;

import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.example.common.service.MailService;
import org.example.common.service.RedisService;
import org.example.common.util.AuthCodeUtil;
import org.example.domain.auth.dto.request.SendCodeToEmailRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class SendCodeToEmailUseCase {
    private final MailService mailService;
    private final RedisService redisService;

    public void execute(SendCodeToEmailRequestDto request) {
        String authCode = AuthCodeUtil.generateCode();

        mailService.checkEmailIsValid(request.email());

        MimeMessage mailForm = mailService.makeEmailForm(authCode, request.email());
        mailService.sendMail(mailForm);

        redisService.saveData(request.email(), authCode, 2 * 60);
    }
}
