package com.nexus.utils;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ObjectsTest {

    @Test
    public void testRequireNonEmpty_Success() {
        List<String> list = new ArrayList<>();
        list.add("elemento");
        Objects.requireNonEmpty(list, new RuntimeException("Lista vazia"));
    }

    @Test
    public void testRequireNonEmpty_Failure() {
        List<String> emptyList = Collections.emptyList();
        assertThrows(RuntimeException.class, () -> Objects.requireNonEmpty(emptyList, new RuntimeException("Lista vazia")));
    }
}
