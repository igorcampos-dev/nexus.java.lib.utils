package com.nexus.utils;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import static org.junit.jupiter.api.Assertions.*;

class ReadersTest {


    @Test
    void testFileHtmlConfirmacaoFileNotFound() {
        Readers readers = new Readers();
        assertThrows(RuntimeException.class, () -> {
            readers.fileHtmlConfirmacao("nonexistentfile");
        });
    }

    @Test
    void testFileHtmlFileNotFound() {
        Readers readers = new Readers();
        assertThrows(RuntimeException.class, () -> {
            readers.fileHtml("nonexistentfile");
        });
    }

    @Test
    void testGetPath() {
        Readers readers = new Readers();
        String expectedPath = "src/main/resources/messages/actions/sample.html";
        Path actualPath = readers.getPath("sample");
        assertEquals(expectedPath, actualPath.toString());
    }

}
