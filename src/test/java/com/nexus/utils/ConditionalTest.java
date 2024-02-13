package com.nexus.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.function.Supplier;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ConditionalTest {

    private Runnable runnable;
    private Supplier<String> supplier;
    private Conditional<String> conditional;

    @BeforeEach
    void setup() {
        runnable = mock(Runnable.class);
        supplier = mock(Supplier.class);
    }

    @Test
    void testWhenRunnable() {
        conditional = new Conditional<String>().when(true, runnable);
        conditional.execute();
        verify(runnable, times(1)).run();
    }

    @Test
    void testOtherwiseRunnable() {
        conditional = new Conditional<String>().when(false, runnable);
        conditional = conditional.otherwise(true, runnable);
        conditional.execute();
        verify(runnable, times(1)).run();
    }

    @Test
    void testWhenSupplier() {
        when(supplier.get()).thenReturn("Test");
        conditional = new Conditional<String>().when(true, supplier);
        assertEquals("Test", conditional.build());
    }

    @Test
    void testOtherwiseSupplier() {
        when(supplier.get()).thenReturn("Test");
        conditional = new Conditional<String>().when(false, supplier);
        conditional = conditional.otherwise(true, supplier);
        assertEquals("Test", conditional.build());
    }
}
