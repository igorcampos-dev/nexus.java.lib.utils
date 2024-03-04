package com.nexus.utils;

import java.util.List;

public final class Objects {

    /**
     * Verifica se uma lista não está vazia.
     *
     * @param obj a lista a ser verificada
     * @param e a exceção a ser lançada se a lista estiver vazia
     * @param <T> o tipo dos elementos na lista
     * @throws RuntimeException se a lista estiver vazia
     */
    public static <T> void requireNonEmpty(List<T> obj, RuntimeException e) {
        if (obj.isEmpty()) {
            throw e;
        }
    }
}
