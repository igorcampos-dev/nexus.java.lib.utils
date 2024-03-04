package com.nexus.utils;

import jdk.jfr.Experimental;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.function.Supplier;

/**
 * Classe experimental para criar uma lógica condicional mais flexível usando expressões lambda.
 * Essa classe permite criar condições e executar diferentes ações com base nessas condições de forma mais concisa
 * do que o uso tradicional do "if()".
 *
 * @param <T> o tipo de retorno para a operação condicional
 */
@Experimental
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Conditional<T>{

    private boolean condition;
    private Runnable runnable;
    private Supplier<T> supplier;

    /**
     * Define a ação a ser executada se a condição for verdadeira.
     *
     * @param condition a condição para avaliar
     * @param runnable a ação a ser executada se a condição for verdadeira
     * @return uma instância de Conditional com a ação definida
     */
    public Conditional<T> when(boolean condition, Runnable runnable) {
        return new Conditional<>(condition, runnable, null);
    }

    /**
     * Define a ação a ser executada se a condição for falsa.
     *
     * @param condition a condição para avaliar
     * @param runnable a ação a ser executada se a condição for falsa
     * @return uma instância de Conditional com a ação definida
     */
    public Conditional<T> otherwise(boolean condition, Runnable runnable) {
        return !this.condition ? new Conditional<>(condition, runnable, null) : this;
    }

    /**
     * Define a operação a ser executada se a condição for verdadeira.
     *
     * @param condition a condição para avaliar
     * @param supplier a operação a ser executada se a condição for verdadeira
     * @return uma instância de Conditional com a operação definida
     */
    public Conditional<T> when(boolean condition, Supplier<T> supplier) {
        return new Conditional<>(condition, null, supplier);
    }

    /**
     * Define a operação a ser executada se a condição for falsa.
     *
     * @param condition a condição para avaliar
     * @param supplier a operação a ser executada se a condição for falsa
     * @return uma instância de Conditional com a operação definida
     */
    public Conditional<T> otherwise(boolean condition, Supplier<T> supplier) {
        return !this.condition ? new Conditional<>(condition, null, supplier) : this;
    }

    /**
     * Executa a ação associada à condição, se a condição for verdadeira.
     */
    public void execute() {
        if (this.condition) {
            this.runnable.run();
        }
    }

    /**
     * Constrói e retorna o resultado da operação associada à condição, se a condição for verdadeira.
     *
     * @return o resultado da operação associada à condição, ou null se a condição for falsa
     */
    public T build() {
        return this.condition ? this.supplier.get() : null;
    }
}
