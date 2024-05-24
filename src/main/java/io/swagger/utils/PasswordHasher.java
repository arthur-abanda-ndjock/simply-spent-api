package io.swagger.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import io.swagger.exceptions.SimplySpendException;

public class PasswordHasher {

    private static String HASH_FUNC_DESC = "SHA3-256";

    public static String getHash(String value) {
        byte[] byteHash;
        try {
            byteHash = MessageDigest
                    .getInstance(HASH_FUNC_DESC).digest(value.getBytes(StandardCharsets.UTF_8));

        } catch (NoSuchAlgorithmException e) {
            throw new SimplySpendException(e);
        }

        return bytesToHex(byteHash);
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}
