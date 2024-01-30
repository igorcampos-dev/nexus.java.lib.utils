package com.nexus.utils;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;

@Service
public class Utils {

    private static String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String randomHash(int capacity) {
            StringBuilder sb = new StringBuilder(capacity);
            for (int i = 0; i < capacity; i++) sb.append(AB.charAt(new SecureRandom().nextInt(AB.length())));
            return sb.toString();
    }

    public String replace(String object) {
       return object.replace("%20", " ");
    }
}
