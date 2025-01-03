package org.example.common.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.common.service.CurrentUserProvider;
import org.example.common.spi.SecurityPort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserProviderImpl implements CurrentUserProvider {
    private final SecurityPort securityPort;

    @Override
    public String getCurrentUserEmail() {
        return securityPort.getCurrentUserEmail();
    }
}
