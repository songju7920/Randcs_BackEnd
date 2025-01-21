package org.example.common.service;

public interface JwtService {

    String generateAccess(String email);

    String generateRefresh(String email);
}
