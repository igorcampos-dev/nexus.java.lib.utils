package com.nexus.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testRandomHash() {
        Utils utils = new Utils();
        int capacity = 10;
        String randomHash = utils.randomHash(capacity);

        assertNotNull(randomHash);
        assertEquals(capacity, randomHash.length());
        assertTrue(randomHash.matches("[a-zA-Z0-9]+"));
    }

    @Test
    void testReplace() {
        Utils utils = new Utils();
        String result = utils.replace("Hello%20World");
        assertEquals("Hello World", result);
    }
}
