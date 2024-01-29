package com.nexus.utils;

import java.io.IOException;

public interface ReadersService {
    String fileHtmlConfirmacao(String html, String path) throws IOException;
    String fileHtml(String filename, String path) throws IOException;
}
