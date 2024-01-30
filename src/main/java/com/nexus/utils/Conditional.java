package com.nexus.utils;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Conditional<T>{

    private boolean condition;
    private Runnable runnable;
    private Supplier<T> supplier;



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
