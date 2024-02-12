package com.nexus.utils;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class Utils {

    private static String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String randomHash(int capacity) {
            StringBuilder sb = new StringBuilder(capacity);
            for (int i = 0; i < capacity; i++) sb.append(AB.charAt(new SecureRandom().nextInt(AB.length())));
            return sb.toString();
    }

    @Deprecated
    public static String replace(String object) {
       return object.replace("%20", " ");
    }

    public static String formatCPF(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    public String toBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
}
