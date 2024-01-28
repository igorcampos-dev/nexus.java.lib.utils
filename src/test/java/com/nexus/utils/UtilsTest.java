package com.nexus.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testRandomHash() {
        UtilsImpl utils = new UtilsImpl();
        int capacity = 10;
        String randomHash = utils.randomHash(capacity);

        assertNotNull(randomHash);
        assertEquals(capacity, randomHash.length());
        assertTrue(randomHash.matches("[a-zA-Z0-9]+"));
    }
}
