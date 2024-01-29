package com.nexus.utils;

import java.util.function.Supplier;

public interface Conditional<T> {
    Conditional<T> when(boolean condition, Runnable runnable);

    Conditional<T> otherwise(boolean condition, Runnable runnable);

    Conditional<T> when(boolean condition, Supplier<T> supplier);

    Conditional<T> otherwise(boolean condition, Supplier<T> supplier);

    void execute();

    T build();
}
