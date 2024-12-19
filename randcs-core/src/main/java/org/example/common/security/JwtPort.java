package org.example.common.security;

public interface JwtPort {
    String generateAccess(String email);

    String generateRefresh(String email);
}
