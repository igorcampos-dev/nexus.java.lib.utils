package com.nexus.utils;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * Classe utilitária com métodos para gerar hash aleatório, substituir espaços codificados em URLs,
 * formatar CPF e converter bytes para base64.
 */
public class Utils {

    // Conjunto de caracteres para gerar o hash aleatório
    private static String AB = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    /**
     * Gera um hash aleatório com o tamanho especificado.
     * @param capacity o tamanho do hash a ser gerado
     * @return uma string contendo o hash aleatório
     */
    public String randomHash(int capacity) {
        StringBuilder sb = new StringBuilder(capacity);
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < capacity; i++) {
            sb.append(AB.charAt(random.nextInt(AB.length())));
        }
        return sb.toString();
    }

    /**
     * Substitui os espaços codificados ("%20") em uma URL por espaços normais.
     * @param object a string contendo a URL com espaços codificados
     * @return a string com os espaços codificados substituídos por espaços normais
     */
    public static String replaceUrlEncodedSpaces(String object) {
        return object.replace("%20", " ");
    }

    /**
     * Remove os caracteres não numéricos de um CPF.
     * @param cpf a string contendo o CPF a ser formatado
     * @return uma string contendo apenas os dígitos do CPF
     */
    public static String formatCPF(String cpf) {
        return cpf.replaceAll("[^0-9]", "");
    }

    /**
     * Converte um array de bytes para uma string em base64.
     * @param bytes o array de bytes a ser convertido
     * @return uma string em base64 representando os bytes
     */
    public String toBase64(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }
}
