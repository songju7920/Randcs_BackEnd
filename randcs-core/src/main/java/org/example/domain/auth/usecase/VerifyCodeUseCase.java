package org.example.domain.auth.usecase;

import lombok.RequiredArgsConstructor;
import org.example.common.service.RedisService;
import org.example.common.util.AuthCodeUtil;
import org.example.domain.auth.dto.request.VerifyCodeRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class VerifyCodeUseCase {
    private final RedisService redisService;

    public void execute(VerifyCodeRequestDto request) {
        String savedCode = redisService.getValueByKey(request.verification());

        AuthCodeUtil.checkCodeMatches(request.code(), savedCode);
    }
}
