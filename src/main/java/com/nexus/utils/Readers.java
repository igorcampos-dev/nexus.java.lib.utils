package com.nexus.utils;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class Readers{

    private static String PATH = "src/main/resources/messages/actions/";

    public String fileHtmlConfirmacao(String filename){
        Path filePath = this.getPath(filename);
        byte[] fileByte = this.getBytesFile(filePath);
        return new String(fileByte, StandardCharsets.UTF_8);
    }

    public String fileHtml(String filename){
        Path filePath = this.getPath(filename);
        byte[] fileBytes = this.getBytesFile(filePath);
        String content = new String(fileBytes, StandardCharsets.UTF_8);

        return this.extractHtmlContent(content);
    }


    public Path getPath(String filename){
        return Path.of(PATH.concat(filename).concat(".html"));
    }

    public byte[] getBytesFile(Path filePath){
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String extractHtmlContent(String content){
        Pattern pattern = Pattern.compile("<html.*?>(.*?)</html>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group(1).trim() : "";
    }
}
