package org.example.common.util;

import org.example.common.error.exception.CodeNotMatchesException;

import java.util.Random;

public final class AuthCodeUtil {
    public static String generateCode() {
        StringBuilder randomCode = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 4; i += 1) {
            randomCode.append(random.nextInt(10));
        }

        return randomCode.toString();
    }

    public static void checkCodeMatches(String code, String savedCode) {
        if (!code.equals(savedCode)) {
            throw CodeNotMatchesException.EXCEPTION;
        }
    }
}
