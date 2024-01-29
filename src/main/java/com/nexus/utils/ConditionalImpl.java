package com.nexus.utils;

import java.util.function.Supplier;

public class ConditionalImpl<T> implements Conditional<T> {

    private final boolean condition;
    private final Runnable runnable;
    private final Supplier<T> supplier;

    public ConditionalImpl(boolean condition, Runnable runnable, Supplier<T> supplier) {
        this.condition = condition;
        this.runnable = runnable;
        this.supplier = supplier;
    }

    @Override
    public Conditional<T> when(boolean condition, Runnable runnable) {
        return new ConditionalImpl<>(condition, runnable, null);
    }

    @Override
    public Conditional<T> otherwise(boolean condition, Runnable runnable) {
        return !this.condition ? new ConditionalImpl<>(condition, runnable, null) : this;
    }

    @Override
    public Conditional<T> when(boolean condition, Supplier<T> supplier) {
        return new ConditionalImpl<>(condition, null, supplier);
    }

    @Override
    public Conditional<T> otherwise(boolean condition, Supplier<T> supplier) {
        return !this.condition ? new ConditionalImpl<>(condition, null, supplier) : this;
    }

    @Override
    public void execute() {
        if (this.condition) {
            this.runnable.run();
        }
    }

    @Override
    public T build() {
        return this.condition ? this.supplier.get() : null;
    }
}
