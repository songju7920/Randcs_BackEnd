package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.service.JwtService;
import org.example.common.spi.JwtPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {
    private final JwtPort jwtPort;

    @Override
    public String generateAccess(String email) {
        return jwtPort.generateAccess(email);
    }

    @Override
    public String generateRefresh(String email) {
        return jwtPort.generateRefresh(email);
    }
}
