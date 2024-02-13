package com.nexus.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testRandomHashSuccess() {
        Utils utils = new Utils();
        String hash1 = utils.randomHash(10);
        String hash2 = utils.randomHash(10);

        assertEquals(10, hash1.length());
        assertEquals(10, hash2.length());
        assertNotEquals(hash1, hash2);
    }

    @Test
    void testReplaceUrlEncodedSpacesSuccess() {
        String urlWithSpaces = "hello%20world%20";
        String urlWithoutSpaces = "hello world ";
        String result = Utils.replaceUrlEncodedSpaces(urlWithSpaces);
        assertEquals(urlWithoutSpaces, result);
    }

    @Test
    void testFormatCPFSuccess() {
        String cpfWithSpecialChars = "123.456.789-00";
        String cpfDigitsOnly = "12345678900";
        String result = Utils.formatCPF(cpfWithSpecialChars);
        assertEquals(cpfDigitsOnly, result);
    }

    @Test
    void testFormatCPF() {
        String cpfWithSpecialChars = "123.456.789-00";
        String cpfDigitsOnly = "12345678900";
        String result = Utils.formatCPF(cpfWithSpecialChars);
        assertEquals(cpfDigitsOnly, result);
    }


    @Test
    void testToBase64Success() {
        Utils utils = new Utils();
        String base64String = utils.toBase64("Hello, World!".getBytes());
        assertEquals("SGVsbG8sIFdvcmxkIQ==", base64String);
    }
}
