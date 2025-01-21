package org.example.common.spi;

public interface JwtPort {

    String generateAccess(String email);

    String generateRefresh(String email);
}
