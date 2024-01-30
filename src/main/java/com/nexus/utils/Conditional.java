package com.nexus.utils;

import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class Conditional<T>{

    private final boolean condition;
    private final Runnable runnable;
    private final Supplier<T> supplier;

    public Conditional(boolean condition, Runnable runnable, Supplier<T> supplier) {
        this.condition = condition;
        this.runnable = runnable;
        this.supplier = supplier;
    }

    public Conditional<T> when(boolean condition, Runnable runnable) {
        return new Conditional<>(condition, runnable, null);
    }

    public Conditional<T> otherwise(boolean condition, Runnable runnable) {
        return !this.condition ? new Conditional<>(condition, runnable, null) : this;
    }

    public Conditional<T> when(boolean condition, Supplier<T> supplier) {
        return new Conditional<>(condition, null, supplier);
    }

    public Conditional<T> otherwise(boolean condition, Supplier<T> supplier) {
        return !this.condition ? new Conditional<>(condition, null, supplier) : this;
    }

    public void execute() {
        if (this.condition) {
            this.runnable.run();
        }
    }

    public T build() {
        return this.condition ? this.supplier.get() : null;
    }
}
