package com.nexus.utils;


import java.util.Collection;

public final class Objects {

    /**
     * Verifica se uma lista não está vazia.
     *
     * @param obj a lista a ser verificada
     * @param e a exceção a ser lançada se a lista estiver vazia
     * @param <T> o tipo dos elementos na lista
     * @throws RuntimeException se a lista estiver vazia
     */

    public static <T> void requireNonNull(T obj, RuntimeException e) {
        if (obj == null) {
            throw e;
        }
    }

    /**
     * Verifica se uma coleção não é nula e não está vazia.
     *
     * @param collection A coleção a ser verificada.
     * @param e A exceção a ser lançada se a coleção for nula ou vazia.
     * @throws RuntimeException A exceção fornecida se a coleção for nula ou vazia.
     *
     * @param <T> O tipo da coleção. Deve estender a classe Collection.
     */
    public static <T extends Collection<?>> void requireNonEmpty(T collection, RuntimeException e) {
        if (collection == null || collection.isEmpty()) {
            throw e;
        }
    }

    /**
     * Lança a exceção passada por parâmetro se a condição for verdadeira.
     * @param condition A condição a ser verificada.
     * @param exception A exceção a ser lançada se a condição for verdadeira.
     */
    public static void throwIfTrue(boolean condition, RuntimeException exception) {
        if (condition) {
            throw exception;
        }
    }

    /**
     * Lança a exceção passada por parâmetro se a condição for falsa.
     * @param condition A condição a ser verificada.
     * @param exception A exceção a ser lançada se a condição for verdadeira.
     */
    public static void throwIfFalse(boolean condition, RuntimeException exception) {
        if (!condition) {
            throw exception;
        }
    }

}
