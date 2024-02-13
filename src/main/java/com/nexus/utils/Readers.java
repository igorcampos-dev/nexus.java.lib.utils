package com.nexus.utils;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe utilitária para leitura de arquivos HTML.
 */
@Service
public class Readers{

    private static String PATH = "src/main/resources/messages/actions/";

    /**
     * Lê o conteúdo de um arquivo HTML de confirmação.
     * @param filename o nome do arquivo HTML (sem a extensão .html)
     * @return uma string contendo o conteúdo do arquivo HTML de confirmação
     */
    public String fileHtmlConfirmacao(String filename){
        Path filePath = this.getPath(filename);
        byte[] fileByte = this.getBytesFile(filePath);
        return new String(fileByte, StandardCharsets.UTF_8);
    }

    /**
     * Lê o conteúdo de um arquivo HTML.
     * @param filename o nome do arquivo HTML (sem a extensão .html)
     * @return uma string contendo o conteúdo do arquivo HTML
     */
    public String fileHtml(String filename){
        Path filePath = this.getPath(filename);
        byte[] fileBytes = this.getBytesFile(filePath);
        String content = new String(fileBytes, StandardCharsets.UTF_8);

        return this.extractHtmlContent(content);
    }

    public Path getPath(String filename){
        return Path.of(PATH.concat(filename).concat(".html"));
    }

    private byte[] getBytesFile(Path filePath){
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String extractHtmlContent(String content){
        Pattern pattern = Pattern.compile("<html.*?>(.*?)</html>", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group(1).trim() : "";
    }
}
