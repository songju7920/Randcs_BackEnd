package org.example.common.service;

public interface SecurityService {

    String encodePassword(String password);

    void checkPasswordMatches(String rawPassword, String encryptedPassword);
}
