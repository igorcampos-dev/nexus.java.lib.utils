package com.nexus.utils;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ReadersImpl implements ReadersService {

    @Override
    public String fileHtmlConfirmacao(String html, String path) throws IOException {
        String filePath = path.concat(html);
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        return new String(encoded, StandardCharsets.UTF_8);
    }

    @Override
    public String fileHtml(String filename, String path) throws IOException {
        Path filePath = Path.of(path.concat(filename).concat(".html"));
        byte[] fileBytes = Files.readAllBytes(filePath);
        String conteudo = new String(fileBytes, StandardCharsets.UTF_8);
        Pattern pattern = Pattern.compile("<html.*?>(.*?)</html>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(conteudo);

        return matcher.find() ? matcher.group(1).trim() : "";
    }
}
